package com.iheart.appium.iosAutomation;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class TestRoot {
	
	protected static final int UP = 0;
	protected static final int RIGHT = 1;
	protected static final int DOWN = 2;
	protected static final int LEFT = 3;
	
	protected static int implicitWaitTimeout = 375;
	
	protected static IOSDriver<IOSElement> driver;

	private static int appWidth = 0;
	private static int appHeight = 0;
	
	// Desired Capabilities for Appium to be imported from properties
	protected static String DEVICE_NAME;
	protected static String UDID;
	protected static String PLATFORM_VERSION;
	protected static String BUNDLE_ID;
	protected static String IPA_NAME;
	protected static boolean SIMULATOR = true;

	// Page elements
	protected static HomePage homePage;
	protected static LoginPage loginPage;
	protected static SignUpPage signupPage;
	protected static Player player;
	protected static SideNavigationBar sideNavBar;
	protected static ForYouPage forYouPage;
	protected static CustomRadio customRadio;
	protected static Search search;
	protected static DeepLink deepLink;
	protected static PodcastsPage podcastsPage;
	protected static SplashPage splashPage;
	protected static GenrePage genrePage;
	protected static MiniPlayer miniPlayer;
	protected static SettingsPage settings;
	protected static PerfectFor perfectFor;
	
	protected static boolean useSimulator = false;
	
	protected static void setup() {
		
		String appiumUrl = "";
		String appiumPort = "";
		
		// Load up the properties file
		Properties props = null;
		try {
			props = loadProperties("ios.properties.local");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Create the desired capabilities
		if(props != null){
			DEVICE_NAME = props.getProperty("APPIUM.DEVICE.NAME");
			UDID = props.getProperty("APPIUM.DEVICE.UDID");
			PLATFORM_VERSION = props.getProperty("APPIUM.DEVICE.PLATFORMVERSION");
			BUNDLE_ID = props.getProperty("APPIUM.APP.BUNDLEID");
			IPA_NAME = props.getProperty("APPIUM.APP.PATH");
			SIMULATOR = Boolean.parseBoolean(props.getProperty("APPIUM.USESIMULATOR"));
			appiumUrl = props.getProperty("APPIUM.WEBDRIVER.URL");
			appiumPort = props.getProperty("APPIUM.WEBDRIVER.PORT");
		}
		else{
			// Use system properties
			DEVICE_NAME = System.getProperty("APPIUM.DEVICE.NAME");
			UDID = System.getProperty("APPIUM.DEVICE.UDID");
			PLATFORM_VERSION = System.getProperty("APPIUM.DEVICE.PLATFORMVERSION");
			BUNDLE_ID = System.getProperty("APPIUM.APP.BUNDLEID");
			IPA_NAME = System.getProperty("APPIUM.APP.PATH");
			
			SIMULATOR = Boolean.parseBoolean(System.getProperty("APPIUM.USESIMULATOR"));
			appiumUrl = System.getProperty("APPIUM.URL");
			appiumPort = System.getProperty("APPIUM.PORT");
		}
		
		// Create a new driver object
		URL url = null;
		try {
			url = new URL("http://" + appiumUrl + ":" + appiumPort + "/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
			
		DesiredCapabilities capabilities = new DesiredCapabilities();
        
		// Set capabilities
		capabilities.setCapability("deviceName", DEVICE_NAME);
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", PLATFORM_VERSION);
		capabilities.setCapability("bundleId", BUNDLE_ID);
        capabilities.setCapability("app", IPA_NAME);
        
        if(SIMULATOR){
        	capabilities.setCapability("sendKeyStrategy", "oneByOne");
        	capabilities.setCapability("calendarFormat", "gregorian");
        }
        else{
        	capabilities.setCapability("sendKeyStrategy", "grouped");
        	capabilities.setCapability("udid", UDID);
        }
        	
		// Start the driver
        try{
        	driver = new IOSDriver<IOSElement>(url, capabilities);
        }
        catch(Exception e){
        	System.err.println("Could not start driver. Emulator or device may be unavailable. Appium may have disconnected or stopped. Sleeping 30 seconds to retry.");
        	for(int i = 30; i > 0; i -= 5){
        		System.err.println("Retrying in: " + i + "...");
        		sleep(5000);
        	}
        	System.err.println("LAST CHANCE... TRYING TO START APPIUM BEFORE RETRYING DRIVER INITIALIZATION...\n");
        	driver = new IOSDriver<IOSElement>(url, capabilities);
        	sleep(100);
        }
		
		// Create pages and set driver status
		Page.setDriver(driver);
		
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		signupPage = new SignUpPage(driver);
		player = new Player(driver);
		sideNavBar = new SideNavigationBar(driver);

		forYouPage = new ForYouPage(driver);
		podcastsPage = new PodcastsPage(driver);
		search = new Search(driver);
		customRadio = new CustomRadio(driver);
		deepLink = new DeepLink(driver);
		splashPage = new SplashPage(driver);
		genrePage = new GenrePage(driver);
		miniPlayer = new MiniPlayer(driver);
		settings = new SettingsPage(driver);
		perfectFor = new PerfectFor(driver);
		
		driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		
		// Get rid of zip code request if it displays
		Page.enterZip();

		// Wait for login to display
		waitForElementToBeVisible(signupPage.getGetStartedButton(), 15);
	}

	protected static void tearDown() {
		if(driver != null){
			try{
				// If app isn't resetting through appium, try running a test with this un-commented
//				driver.resetApp();
				driver.quit();
			}
			catch(Exception e){
				System.err.println("ERROR SHUTTING DOWN DRIVER");
				e.printStackTrace();
			}
		}
	}
	
	//// Utility Methods ////
	
	public static int getRandomInt() {
		return getRandomInt(999999);
	}
	public static int getRandomInt(int max){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(max);
	}
	
	/**
	 * Takes a screenshot, saves it to the location of the test method 
	 * @param driver
	 * @param testMethod
	 * @throws Exception
	 */
	public static void takeScreenshot(WebDriver driver, String testMethod) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		// System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		String screenshotName = testMethod + dateFormat.format(date) + ".png";
		System.out.println("See screenshotName:" + screenshotName);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		FileUtils.copyFile(scrFile, new File(screenshotName));
		System.out.println("Screenshot is taken.");
	}
	
	/**
	 * Passed in a property file, it returns the loaded properties
	 * @param propFile
	 * @return
	 * @throws Exception
	 */
	public static Properties loadProperties(String propFile) throws Exception {
		Properties loadedProps = new Properties();
		InputStream in = null;
		try {
			in = TestRoot.class.getClassLoader().getResourceAsStream(propFile);
			loadedProps.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return loadedProps;
	}

	/**
	 * Returns a Map of String, String for the location from an IP address
	 * @param driver
	 * @return
	 */
	public static Map<String, String> getLocationByIp(WebDriver driver) {
		Map<String, String> geoInfo = new HashMap<String, String>();
		driver.navigate().to("http://www.iplocation.net");
		String country = driver
				.findElement(
						By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(2)"))
				.getText();
		String state = driver
				.findElement(
						By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(3)"))
				.getText();
		String city = driver
				.findElement(
						By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(4)"))
				.getText();

		geoInfo.put("country", country);
		geoInfo.put("state", state);
		geoInfo.put("city", city);

		return geoInfo;
	}
	
	/** dynamically load jQuery */
	public static void injectJQuery(WebDriver driver) {
		String LoadJQuery = "(function(jqueryUrl, callback) {\n" + "if (typeof jqueryUrl != 'string') {"
				+ "jqueryUrl = 'https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js';\n" + "}\n"
				+ "if (typeof jQuery == 'undefined') {\n" + "var script = document.createElement('script');\n"
				+ "var head = document.getElementsByTagName('head')[0];\n" + "var done = false;\n"
				+ "script.onload = script.onreadystatechange = (function() {\n"
				+ "if (!done && (!this.readyState || this.readyState == 'loaded'\n"
				+ "|| this.readyState == 'complete')) {\n" + "done = true;\n"
				+ "script.onload = script.onreadystatechange = null;\n" + "head.removeChild(script);\n"
				+ "callback();\n" + "}\n" + "});\n" + "script.src = jqueryUrl;\n" + "head.appendChild(script);\n"
				+ "}\n" + "else {\n" + "callback();\n" + "}\n" + "})(arguments[0], arguments[arguments.length - 1]);\n";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// give jQuery time to load asynchronously
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		js.executeAsyncScript(LoadJQuery);
		System.out.println("Jquery is loaded.");
	}
	
	public static IOSElement find(IOSDriver<IOSElement> d, String locator){
		// Guess the locator, returns the element
		if(locator.startsWith("//")){
			return findElement(d, By.xpath(locator));
		}
		else{
			// name or ID?
			IOSElement testEle = findElement(d, By.name(locator));
			if(testEle == null){
				// try ID
				testEle = findElement(d, By.id(locator));
			}
			return testEle; // null if we found nothing
		}
	}
	
	public static IOSElement findElement(IOSDriver<IOSElement> d, By by){
		IOSElement e = null;
		try{
			d.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			e = d.findElement(by);
		}
		catch(Exception exc){}
		finally{
			d.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		}
		return e;
	}
	
	public static List<IOSElement> findElements(IOSDriver<IOSElement> d, By by){
		List<IOSElement> foundElements = null;
		
		try{
			d.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			foundElements = d.findElements(by);
		}
		catch(Exception e){
			System.out.println("Could not find elements");
		}
		finally{
			d.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		}
		
		return foundElements;
	}
	
	/**
	 * Guesses, useful for only Xpaths or names.
	 * @param locator
	 * @return
	 */
	public static By find(String locator){
		// Try to guess locator 
		if(locator.startsWith("//")){
			return find(locator, "xpath");
		}
		else{
			return find(locator, "name");
		}
	}
	/**
	 * Driver, locator, method to locate BY
	 * @param d
	 * @param locator
	 * @param method
	 * @return
	 */
	public static By find(String locator, String method){
		if(method.equalsIgnoreCase("name")){
			return By.name(locator);
		}
		else if(method.equalsIgnoreCase("name")){
			return By.id(locator);
		}
		else if(method.equalsIgnoreCase("xpath")){
			return By.xpath(locator);
		}
		else if(method.toLowerCase().contains("css")){
			return By.cssSelector(locator);
		}
		else{
			return By.className(locator);
		}
	}
	
	// General navigation
	/**
	 * Swipe in a direction from a start point
	 * Directions: 0: up, 1: right, 2: down, 3: left
	 * @param startx
	 * @param starty
	 * @param direction
	 * @param duration
	 */
	public static void swipe(int startx, int starty, int direction, int duration){
		int endx = 0;
		int endy = 0;
		switch (direction){
		case 0:
			endx = startx;
			endy = starty - 300;
			break;
		case 1:
			endx = startx + 150;
			endy = starty;
			break;
		case 2: 
			endx = startx;
			endy = starty + 300;
			break;
		case 3:
			endx = startx - 150;
			endy = starty;
			break;
		}
		if(endx < 0)
			endx = 0;
		if(endx > getAppWidth())
			endx = getAppWidth();
		if(endy < 0)
			endy = 0;
		if(endy > getAppHeight())
			endy = getAppHeight();
		
		driver.swipe(startx, starty, endx, endy, duration);
	}
	public static void swipeUp(){
		int startx = getAppWidth() / 2;
		int starty = (getAppHeight() / 6) * 5;
		swipe(startx, starty, 0, 500);
	}
	/**
	 * Swipe left to right
	 */
	public static void swipeRight(){
		int startx = getAppWidth() / 6;
		int starty = getAppHeight() / 2;
		swipe(startx, starty, 1, 500);
	}
	public static void swipeDown(){
		int startx = getAppWidth() / 2;
		int starty = getAppHeight() / 6;
		swipe(startx, starty, 2, 500);
	}
	/**
	 * Swipe right to left
	 */
	public static void swipeLeft(){
		int startx = (getAppWidth() / 6) * 5;
		int starty = getAppHeight() / 2;
		swipe(startx, starty, 3, 500);
	}
	
	/**
	 * Swipes on an element, keeping within the bounds of the element, if possible
	 * Will try to swipe to/from 10%-90% of the element +/- 4/5 from center
	 * 0=Up 1=Right 2=Down 3=Left
	 * @param item
	 * @param direction
	 */
	public static void swipeOnItem(IOSElement item, int direction){
		if(!isVisible(item)){
			return;
		}
		int x = item.getLocation().getX();
		int y = item.getLocation().getY();
		int w = item.getSize().getWidth();
		int h = item.getSize().getHeight();
		int tenthX = (w / 10); // Add X after calculation
		int tenthY = (h / 10); // Add Y after calculation
		int centerX = tenthX * 5 + x;
		int centerY = tenthY * 5 + y;
		// The parts we're going to figure out
		int startX = centerX;
		int startY = centerY;
		int endX = centerX;
		int endY = centerY;
		switch(direction){
		case 0: // Up ^
			startX = centerX;
			startY = (tenthY * 9) + y;
			endX = centerX;
			endY = tenthY + y;
			break;
		case 1: // Right ----->
			startX = tenthX + x;
			startY = centerY;
			endX = (tenthX * 9) + x;
			endY = centerY;
			break;
		case 2: // Down V
			startX = centerX;
			startY = tenthY + y;
			endX = centerX;
			endY = (tenthY * 9) + y;
			break;
		case 3: // Left <-----
			startX = (tenthX * 9) + x;
			startY = centerY;
			endX = tenthX + x;
			endY = centerY;
			break;
		default:
			System.err.println("Direction must be 0, 1, 2, or 3 for Up, Right, Down, or Left, respectively.");
			break;
		}
		
		if(startX != endX || startY != endY){
			try{
				driver.swipe(startX, startY, endX, endY, 500);
			}
			catch(Exception e){
				System.err.println("Error trying to swipe on element!\n");
				e.printStackTrace();
			}
		}
	}
	
	public static int getAppWidth(){
		if(appWidth == 0)
			appWidth = driver.manage().window().getSize().getWidth();
		return appWidth;
	}
	public static int getAppHeight(){
		if(appHeight == 0)
			appHeight = driver.manage().window().getSize().getHeight();
		return appHeight;
	}
	
	public static Set<String> getContextHandles() {
		Set<String> contexts = new HashSet<String>();
		try{
			contexts = driver.getContextHandles(); // Errors here
		}
		catch(Exception e){
		}

		return contexts;
	}
	public static boolean switchToWebContext(){
		Set<String> handles = getContextHandles();
		String webContext = "";
		if(handles != null && handles.size() > 0){
			for(String c : handles){
				if(c.contains("WEB")){
					webContext = c;
					driver.context(c);
				}
			}
			sleep(1000);
		}
		return driver.getContext().equals(webContext);
	}
	public static boolean switchToNativeContext(){
		driver.context("NATIVE_APP");
		sleep(1000);
		return driver.getContext().equals("NATIVE_APP");
	}
	
	//// Waiting Methods ////
	static boolean isVisible(IOSElement e){
		boolean isVisible = false;
		if(e == null){
			return false;
		}
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			isVisible = e.isDisplayed();
		}catch(Exception x){}
		finally{
			driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		}
		return isVisible;
	}
	
	public static void sleep(int timeInMs){
		try{
			Thread.sleep(timeInMs);
		} catch(Exception e){}
	}
	
	/** 
	 * Waits until the document readtState equals complete
	 * AKA: a page has loaded
	 * Uses Javascript Executor
	 * @param driver
	 */
	public static void waitForPageToLoad(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 1000);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete.");
		}
	}

	
	public static IOSElement waitForPresent(IOSDriver<IOSElement> d, By by, long timeoutInSec){
		long timeLeftMil = timeoutInSec * 1000;
		while(timeLeftMil > 0){
			if(findElement(d, by) != null){
				break;
			}
//			sleep(200);
			timeLeftMil -= 1000;
		}
		return (IOSElement) d.findElement(by);
	}
	
	public static IOSElement waitForVisible(IOSDriver<IOSElement> d, By by, long timeoutInSec){
		// Wait for it to be present (not just clickable/visible, but loaded)
		long timeLeftMil = timeoutInSec * 1000;
		while(timeLeftMil > 0){
			if(findElement(d, by) != null){
				break;
			}
			timeLeftMil -= 1000; // Takes about a second each time
		}
		
		timeoutInSec = (timeLeftMil / 1000);
		if(timeLeftMil >= 500){
			timeoutInSec = 1;
		}
	
		IOSElement returnElement = null;
		WebDriverWait wait = new WebDriverWait(d, timeoutInSec);
		try{
			returnElement = (IOSElement) wait.until(ExpectedConditions.elementToBeClickable(d.findElement(by)));
		}
		catch(Exception e){
			// Attempt to grab it anyway
			try{
				returnElement = (IOSElement) d.findElement(by);
			}
			catch(Exception e1){}
		}
		return returnElement;
	}
	
	public static void waitForElementToBeVisible(IOSElement ele, int timeInSeconds){
		if(isVisible(ele)){
			timeInSeconds = 0; // Already visible
		}
		long timeLeftMil = timeInSeconds * 1000;
		while(timeLeftMil > 0){
			if(isVisible(ele)){
				break;
			}
//			sleep(100); // Intentionally mismatched to make up for time searching for element
			timeLeftMil -= 1000;
		}
		
		timeInSeconds = (int) (timeLeftMil / 1000);
		if(timeLeftMil >= 500){
			timeInSeconds = 1;
		}
		if(timeInSeconds >= 1){
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			try{
				wait.until(ExpectedConditions.elementToBeClickable(ele));
			}
			catch(Exception e){
				return;
			}
		}
	}
	
	public static void waitForElementToBeEnabled(IOSElement ele, int maxWaitTimeSeconds){
		if(!isVisible(ele)){
			waitForElementToBeVisible(ele, maxWaitTimeSeconds);
			maxWaitTimeSeconds = 1;
		}
		if(ele.isEnabled()){
			return;
		}
		
		while(maxWaitTimeSeconds > 0){
			try{
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
				if(ele.isEnabled()){
					break;
				}
			}
			catch(Exception e){}
			finally{
				maxWaitTimeSeconds -= 1;
				driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
			}
		}
	}
	
	public static boolean waitForNotVisible(IOSDriver<IOSElement> d, By by, int maxWaitTimeSeconds){
		boolean elementGone = false;
		for(int i = 0; i < maxWaitTimeSeconds; i++){
			try{
				IOSElement element = waitForVisible(d, by, 1);
				if(element == null){
					elementGone = true;
					break;
				}
			}catch(Exception e){}
		}
		return elementGone;
	}
	
	public static boolean click(IOSDriver<IOSElement> d, By by){
		IOSElement clickMe = findElement(d, by);
		if(isVisible(clickMe)){
			clickMe.click();
			return true;
		}
		return false;
	}
	
	/**
	 * If a string is not empty and not null ("good"), return true
	 * @param s
	 * @return
	 */
	public static boolean strGood(String s){
		return s != null && s.length() > 0;
	}
	
	/**
	 * For test cases that return an error string, 
	 * 		this gets a simple boolean by inverting the logic 
	 * 		of the standard string test, 
	 * 		returning TRUE if there are NO ERRORS.
	 * @param s
	 * @return
	 */
	public static boolean didPass(String s){
		return !strGood(s);
	}
	public static boolean passed(String s){ // A rose by any other name...
		return didPass(s);
	}
	public static boolean didPass(Errors err){
		return err.howMany() == 0;
	}
	public static boolean passed(Errors err){
		return didPass(err);
	}
	
	public static boolean isAbout(int testing, int expected){
		return isAbout(testing, expected, 2);
	}
	public static boolean isAbout(int testing, int expected, int variance){
		if(testing == expected || testing + variance >= expected && testing - variance <= expected){
			return true;
		}
		return false;
	}
	
	// Test Watcher control
	@Rule
	public TestRule watcher = new TestWatcher() {

		@Override
		public void failed(Throwable e, Description description) {
			try {
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String currentPath = System.getProperty("user.dir");
				String path = currentPath + File.separator + "target" + File.separator + "surefire-reports" + File.separator;

				String fullFilePath = path + description.getClassName() + File.separator + description.getMethodName() + ".jpg";

				FileUtils.copyFile(screenshot, new File(fullFilePath));

			} catch (Exception ex) {
				System.err.println(ex.toString());
				System.err.println(ex.getMessage());
			}
		}
	};
}
