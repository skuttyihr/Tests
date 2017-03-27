package com.iheart.appium.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iheart.appium.iosAutomation.AddToPlaylistPage;
import com.iheart.appium.iosAutomation.AlbumProfilePage;
import com.iheart.appium.iosAutomation.AppboyUpsellsPage;
import com.iheart.appium.iosAutomation.ArtistProfileOverflowPage;
import com.iheart.appium.iosAutomation.ArtistProfilePage;
import com.iheart.appium.iosAutomation.CuratedPlaylistPage;
import com.iheart.appium.iosAutomation.DeepLink;
import com.iheart.appium.iosAutomation.FullPlayer;
import com.iheart.appium.iosAutomation.GenrePage;
import com.iheart.appium.iosAutomation.GifSequenceWriter;
import com.iheart.appium.iosAutomation.HomePage;
import com.iheart.appium.iosAutomation.LoginPage;
import com.iheart.appium.iosAutomation.MiniPlayer;
import com.iheart.appium.iosAutomation.MyMusicPage;
import com.iheart.appium.iosAutomation.OnboardingPage;
import com.iheart.appium.iosAutomation.Page;
import com.iheart.appium.iosAutomation.PodcastsPage;
import com.iheart.appium.iosAutomation.ResetPasswordPage;
import com.iheart.appium.iosAutomation.SearchPage;
import com.iheart.appium.iosAutomation.SettingsPage;
import com.iheart.appium.iosAutomation.SideNavigationBar;
import com.iheart.appium.iosAutomation.SignUpPage;
import com.iheart.appium.iosAutomation.UpsellPage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import src.main.java.testCommons.*;

public class TestRoot{

	// Suite categories
	public static interface Stable{
	}
	
	protected static final int UP = 0;
	protected static final int RIGHT = 1;
	protected static final int DOWN = 2;
	protected static final int LEFT = 3;

	protected static int implicitWaitTimeout = 500;

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
	protected static String MODEL;

	// Page elements
	protected static LoginPage loginPage;
	protected static SignUpPage signupPage;
	protected static ResetPasswordPage resetPasswordPage;
	protected static HomePage homePage;
	protected static FullPlayer fullPlayer;
	protected static SideNavigationBar sideNavBar;
	protected static SearchPage searchPage;
	protected static DeepLink deepLink;
	protected static PodcastsPage podcastsPage;
	protected static OnboardingPage onboardingPage;
	protected static GenrePage genrePage;
	protected static MiniPlayer miniPlayer;
	protected static SettingsPage settingsPage;
	protected static UpsellPage upsellPage;
	protected static ArtistProfileOverflowPage artistProfileOverflowPage;
	protected static AlbumProfilePage albumProfilePage;
	protected static CuratedPlaylistPage curatedPlaylistPage;
	protected static AppboyUpsellsPage appboyUpsellsPage;

	// New On Demand Elements
	protected static ArtistProfilePage artistProfilePage;
	protected static MyMusicPage myMusicPage;
	protected static AddToPlaylistPage addToPlaylistPage;
	protected static boolean useSimulator = false;

	// Login Info
	protected static String IHEARTUSERNAME;
	protected static String IHEARTPASSWORD;
	protected static String FACEBOOKUSERNAME;
	protected static String FACEBOOKFULLNAME;
	protected static String FACEBOOKPASSWORD;
	protected static String GOOGLEUSERNAME;
	protected static String GOOGLEPASSWORD;
	protected static String NEWACCOUNTPASSWORD;
	protected static String IHEARTFREEUSERNAME;
	protected static String IHEARTPLUSUSERNAME;
	protected static String IHEARTPREMIUMUSERNAME;
	protected static String IHEARTFREEPASSWD;
	protected static String IHEARTPLUSPASSWD;
	protected static String IHEARTPREMIUMPASSWD;
	protected static String IHEARTFREETRIALEXPUSERNAME;
	protected static String IHEARTFREETRIALEXPPASSWD;

	// Screenshot directory and URL
	protected static String SCREENSHOT_DIRECTORY;
	protected static String SCREENSHOT_URL;

	protected static boolean setup() {
		System.out.println("TestRoot.setup()");
		String appiumUrl = "";
		String appiumPort = "";

		// Load up the properties file
		Properties props = null;
		try {
			System.out.println("Loading properties at ios.properties.local");
			props = src.main.java.testCommons.LoadProperties.loadProperties("ios.properties.local");
		} catch (Exception e) {
			System.out.println("Could not load properties, defaulting to system properties.");
			props = null;
		}
		// Create the desired capabilities
		DEVICE_NAME = LoadProperties.getProperties(props, "APPIUM.DEVICE.NAME");
		UDID = LoadProperties.getProperties(props, "APPIUM.DEVICE.UDID");
		PLATFORM_VERSION = LoadProperties.getProperties(props, "APPIUM.DEVICE.PLATFORMVERSION");
		BUNDLE_ID = LoadProperties.getProperties(props, "APPIUM.APP.BUNDLEID");
		IPA_NAME = LoadProperties.getProperties(props, "APPIUM.APP.PATH");
		SIMULATOR = Boolean.parseBoolean(LoadProperties.getProperties(props, "APPIUM.USESIMULATOR"));
		appiumUrl = LoadProperties.getProperties(props, "APPIUM.WEBDRIVER.URL");
		appiumPort = LoadProperties.getProperties(props, "APPIUM.WEBDRIVER.PORT");
		try {
			MODEL = LoadProperties.getProperties(props, "APPIUM.DEVICE.MODEL");
		} catch (Exception e) {
		}

		// Set the screenshot directory
		try {
			SCREENSHOT_DIRECTORY = LoadProperties.getProperties(props, "OPTIONS.SCREENSHOT.DIRECTORY");
			if (!strGood(SCREENSHOT_DIRECTORY)) {
				SCREENSHOT_DIRECTORY = "screenshots/";
			}
			SCREENSHOT_URL = LoadProperties.getProperties(props, "OPTIONS.SCREENSHOT.URL");
			if (!strGood(SCREENSHOT_URL)) {
				SCREENSHOT_URL = "";
			}
		} catch (Exception e) {
			// These aren't mandatory, so do nothing
		}

		// Load the passwords
		Properties passwords = null;
		try {
			passwords = LoadProperties.loadProperties("passwords.local");
		} catch (Exception e) {
			System.out.println("Could not load passwords, defaulting to system properties to load passwords.");
			passwords = null;
		}
		
		// Use decrypted local properties
		IHEARTUSERNAME = LoadProperties.getProperties(passwords, "IHEART.USERNAME");
		IHEARTFREEUSERNAME = LoadProperties.getProperties(passwords, "IHEART.FREE.USERNAME");
		IHEARTPLUSUSERNAME = LoadProperties.getProperties(passwords, "IHEART.PLUS.USERNAME");
		IHEARTPREMIUMUSERNAME = LoadProperties.getProperties(passwords, "IHEART.PREMIUM.USERNAME");
		IHEARTFREETRIALEXPUSERNAME = LoadProperties.getProperties(passwords, "IHEART.FREETRIALEXP.USERNAME");
		IHEARTPASSWORD = LoadProperties.getProperties(passwords, "IHEART.PASSWORD");
		IHEARTFREEPASSWD = LoadProperties.getProperties(passwords, "IHEART.FREE.PASSWORD");
		IHEARTPLUSPASSWD = LoadProperties.getProperties(passwords, "IHEART.PLUS.PASSWORD");
		IHEARTPREMIUMPASSWD = LoadProperties.getProperties(passwords, "IHEART.PREMIUM.PASSWORD");
		IHEARTFREETRIALEXPPASSWD = LoadProperties.getProperties(passwords, "IHEART.FREETRIALEXP.PASSWORD");
		FACEBOOKUSERNAME = LoadProperties.getProperties(passwords, "FACEBOOK.USERNAME");
		FACEBOOKFULLNAME = LoadProperties.getProperties(passwords, "FACEBOOK.FULLNAME");
		FACEBOOKPASSWORD = LoadProperties.getProperties(passwords, "FACEBOOK.PASSWORD");
		GOOGLEUSERNAME = LoadProperties.getProperties(passwords, "GOOGLE.USERNAME");
		GOOGLEPASSWORD = LoadProperties.getProperties(passwords, "GOOGLE.PASSWORD");
		NEWACCOUNTPASSWORD = LoadProperties.getProperties(passwords, "NEWACCOUNT.PASSWORD");

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
		// capabilities.setCapability("interKeyDelay", 0); //Should input text
		// faster
		capabilities.setCapability("bundleId", BUNDLE_ID);
		// added in new capabilities for automation to work with appium 1.6.0
		// and xcode 8
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("wdaLocalPort", "8100");
		// capabilities.setCapability("realDeviceLogger","/Users/sreekalakutty/node_modules/deviceconsole/deviceconsole");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("fullReset", true);
		capabilities.setCapability("app", IPA_NAME);

		System.out.println(DEVICE_NAME + ":iOS:" + PLATFORM_VERSION + ":" + BUNDLE_ID + ":" + IPA_NAME);

		if (SIMULATOR) {
			capabilities.setCapability("sendKeyStrategy", "oneByOne");
			capabilities.setCapability("calendarFormat", "gregorian");
		} else {
			capabilities.setCapability("sendKeyStrategy", "grouped");
			capabilities.setCapability("udid", UDID);
		}

		
		// Start the driver
		try {
			driver = new IOSDriver<IOSElement>(url, capabilities);
		} catch (Exception e) {
			System.err.println(
					"Could not start driver. Emulator or device may be unavailable. Appium may have disconnected or stopped. Sleeping 30 seconds to retry.\n"
							+ "Properties:\n" + "Device name: " + DEVICE_NAME + "\n" + "UDID: " + UDID + "\n"
							+ "Platform version: " + PLATFORM_VERSION + "\n" + "Bundle ID: " + BUNDLE_ID + "\n"
							+ "IPA/App file name: " + IPA_NAME + "\n" + "Using simulator: " + SIMULATOR + "\n"
							+ "Appium URL: " + appiumUrl + "\n" + "Appium port: " + appiumPort + "\n" + "Model name: "
							+ MODEL + "\n");
			
			
			// Retry a few times until we get it right
			int maxRetries = 7;
			int secondDelay = 30;
			for (int retry = 0; retry < maxRetries; retry++){
	    		// Delay for X seconds before retrying
	        	for(int i = secondDelay; i > 0; i--){
	        		if (i % 5 == 0){
	        			System.err.println("Retrying in: " + i + "...");
	        		}
	        		sleep(1000);
	        	}
	        	
	        	// Attempt to restart the driver
	        	System.err.println("RETRYING INITIALIZATION (" + (retry + 1) + " tries so far).");
	        	try{
	        		driver = new IOSDriver<IOSElement>(url, capabilities);
	        	}
	        	catch(Exception e2){
	    			driver = null;
	        	}
	        	
	        	if (driver != null){
	        		System.out.println("Success!");
	        		break;
	        	}
			}
			
			// If it still hasn't gotten this right, stop trying
			if (driver == null){
				System.err.println("\n\n\nCould not start driver. Is a device/emulator connected? Is the Jenkins Build Agent active?\n\n\n");
				return false;
			}
		}

		// Create pages and set driver status
		Page.setDriver(driver);
		resetPasswordPage = new ResetPasswordPage(driver);
		homePage = new HomePage(driver);
		genrePage = new GenrePage(driver);
		loginPage = new LoginPage(driver);
		signupPage = new SignUpPage(driver);
		fullPlayer = new FullPlayer(driver);
		sideNavBar = new SideNavigationBar(driver);
		podcastsPage = new PodcastsPage(driver);
		searchPage = new SearchPage(driver);
		deepLink = new DeepLink(driver);
		upsellPage = new UpsellPage(driver);
		onboardingPage = new OnboardingPage(driver);
		genrePage = new GenrePage(driver);
		miniPlayer = new MiniPlayer(driver);
		settingsPage = new SettingsPage(driver);
		artistProfilePage = new ArtistProfilePage(driver);
		artistProfileOverflowPage = new ArtistProfileOverflowPage(driver);
		albumProfilePage = new AlbumProfilePage(driver);
		myMusicPage = new MyMusicPage(driver);
		addToPlaylistPage = new AddToPlaylistPage(driver);
		curatedPlaylistPage = new CuratedPlaylistPage(driver);
		driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		System.out.println("Testing on: " + MODEL);

		// Get rid of zip code request if it displays
		Page.enterZip();

		// Wait for OnboardingPage to display
		onboardingPage.waitForOnboardingPage();
		
		return driver != null;
	}

	public String stringifyElementInformation(IOSElement iosElement) {
		return "TagName=[" + iosElement.getTagName() + "] Text=[" + iosElement.getText() + "] Object:"
				+ iosElement.toString();
	}

	public boolean printElementInformation(IOSElement iosElement) {
		try {
			if (iosElement == null) {
				System.out.println("is NULL! Returning false. ");
				return false;
			} else {
				String[] aId = iosElement.toString().split(">");
				// String getText = iosElement.getAttribute("name");
				String value = iosElement.getAttribute("value");
				// !value.equals("") ||
				if (value != null) {
					// .isSelected() doesnt work anymore with Appium 1.6.0beta3
					System.out.println("  [" + aId[1] + "  text: [" + value + "]  tagName: [" + iosElement.getTagName()
							+ "] isDisplayed: [" + iosElement.isDisplayed() + "] isEnabled: [" + iosElement.isEnabled()
							+ "].");
				} else { // Element has no Text, not printing it.
					System.out.println("  [" + aId[1] + " tagName: [" + iosElement.getTagName() + "] isDisplayed: ["
							+ iosElement.isDisplayed() + "] isEnabled: [" + iosElement.isEnabled() + "].");
				}
				return iosElement.isDisplayed();
			}
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException for element e = " + e.getMessage());
			return false;
		}
	}
	/**
	 * Use this to get click on a IOSElement. 
	 * Pass in the element, the time to wait for the element, and if possible, the pageObject and Method name as a String. 
	 * @param iosElement
	 * @param timeInSeconds
	 * @param pageAndMethodName  ex: pageObject.clickOnCreateAccountButton 
	 * @return
	 */
	public boolean waitAndClick(IOSElement iosElement, int timeInSeconds, String pageAndMethodName) {
		boolean didClick = false;
		if(waitForElementToBeVisible(iosElement, timeInSeconds)) {
			iosElement.click();
			didClick = true;
		}
		if(iosElement == null) {
			System.out.println("waitAndClick() : ELEMENT WAS NULL!");
			return false;
		}
		String[] splitUp = iosElement.toString().split(">");
		if(pageAndMethodName.equals("")) {
			System.out.println("waitAndClick() : Element["+splitUp[1] + "][ Did Click? : "+ didClick + "].");
		}else {
			System.out.println(pageAndMethodName + "() : IOS Element["+splitUp[1] + "][ Did Click? : "+ didClick + "].");
		}
		return didClick;
	}
	/**
	 * Use this to get text out of an IOSElement. 
	 * Pass in the element, the time to wait for the element, and if possible, the pageObject and Method name as a String. 
	 * @param iosElement
	 * @param timeInSeconds     ex: 3 
	 * @param pageAndMethodName  ex: pageObject.clickOnCreateAccountButton 
	 * @return
	 */
	public String waitAndGetText(IOSElement iosElement, int timeInSeconds, String pageAndMethodName) {
		String text = "";
		if(waitForElementToBeVisible(iosElement, timeInSeconds)) {
			text = iosElement.getText();
		}
		String[] splitUp = iosElement.toString().split(">");
		if(pageAndMethodName.equals("")) {
			System.out.println("waitAndGetText() : Element["+splitUp[1] + "][ Text : "+ text + "].");
		}else {
			System.out.println(pageAndMethodName + "() : IOS Element["+splitUp[1] + "][ Text : "+ text + "].");
		}
		return text;
	}
	
/**
	 * sk - 2/8 - method to print out Element Names as they appear in the app.
	 * @param element
	 * @return
	 */
	public boolean printElementName(IOSElement element) {
		String getText = "";
		String value = "";
		String label = "";

		if (!isVisible(element)) {
			waitForElementToBeVisible(element, 5);
			System.out.println("element is null or is not visible.");
			return false;
			}
		
		getText = element.getAttribute("name");
		value = element.getAttribute("value");
		label = element.getAttribute("label");

		if ( getText != null) 
			System.out.println("Element '" + getText + "' is displayed.");
		else if (value != null) 
			System.out.println("Element '" + value + "' is displayed.");
		else if (label != null)
			System.out.println("Element '" + label + "' is displayed.");
		else
			System.out.println("Element '" + element.getTagName() + "' is displayed.");
		return element.isDisplayed();
	}

	protected static void tearDown() {
		System.out.println("Testcase finished. Testroot.after():: Quitting driver.");
		if (driver != null) {
			try {
				// If app isn't resetting through appium, try running a test
				// with this un-commented
				// driver.resetApp();
				driver.quit();
			} catch (Exception e) {
				System.err.println("ERROR SHUTTING DOWN DRIVER");
				e.printStackTrace();
			}
		}
		System.out.println("######################################################################");
	}

	//// Utility Methods ////

	public static int getRandomInt() {
		return getRandomInt(999999);
	}

	public static int getRandomInt(int max) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(max);
	}

	/**
	 * Takes a screenshot, saves it to the location of the test method
	 * 
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
		// The below method will save the screen shot in d drive with name-----
		// "screenshot.png"
		FileUtils.copyFile(scrFile, new File(screenshotName));
		System.out.println("Screenshot is taken.");
	}

	/**
	 * Returns a Map of String, String for the location from an IP address
	 * 
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

	public static IOSElement find(IOSDriver<IOSElement> d, String locator) {
		// Guess the locator, returns the element
		if (locator.startsWith("//")) {
			return findElement(d, MobileBy.xpath(locator));
		} else {
			// name or ID?
			IOSElement testEle = findElement(d, MobileBy.AccessibilityId(locator));
			if (testEle == null) {
				// try Name
				testEle = findElement(d, MobileBy.name(locator));
			}
			return testEle; // null if we found nothing
		}
	}

	public static IOSElement findElement(IOSDriver<IOSElement> d, By by) {
		IOSElement e = null;
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			e = d.findElement(by);
		} catch (Exception exc) {
		} finally {
			d.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		}
		return e;
	}

	public static List<IOSElement> findElements(IOSDriver<IOSElement> d, By by) {
		List<IOSElement> foundElements = null;
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			foundElements = d.findElements(by);
		} catch (Exception e) {
			System.out.println("Could not find elements");
		} finally {
			d.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		}

		return foundElements;
	}

	/**
	 * Guesses, useful for only Xpaths or names.
	 * 
	 * @param locator
	 * @return
	 */
	public static By find(String locator) {
		// Try to guess locator
		if (locator.startsWith("//")) {
			return find(locator, "xpath");
		} else {
			return find(locator, "name");
		}
	}

	/**
	 * Driver, locator, method to locate BY
	 * 
	 * @param d
	 * @param locator
	 * @param method
	 * @return
	 */
	public static By find(String locator, String method) {
		if (method.equalsIgnoreCase("name")) {
			return MobileBy.name(locator);
		} else if (method.equalsIgnoreCase("name")) {
			return MobileBy.id(locator);
		} else if (method.equalsIgnoreCase("xpath")) {
			return MobileBy.xpath(locator);
		} else if (method.toLowerCase().contains("css")) {
			return MobileBy.cssSelector(locator);
		} else {
			return MobileBy.className(locator);
		}
	}

	/**
	 * Pass in the Page or Element Message you want to test as a String
	 * "isCurrentlyOnHomePage" for instance, and the specific element to test.
	 * Method checks that the element is not null and then checks whether it
	 * isDisplayed.
	 * 
	 * @param isCurrentlyOnPageMessage
	 * @param element
	 * @return
	 */
	public boolean isCurrentlyOn(String isCurrentlyOnPageMessage, IOSElement element) {

		try {
			if (Page.waitForElementToBeVisible(element, 5)) {
				if (element != null) {
					boolean onPage = element.isDisplayed();
					System.out.println(isCurrentlyOnPageMessage + "() : " + onPage);
					return onPage;
				}else{
					System.out.println(isCurrentlyOnPageMessage + "() Element is null : " + false);
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println(isCurrentlyOnPageMessage + "() : false.   ~~~NoSuchElementException Caught.~~~");
			return false;
		}
		return false; // Default
	}

	// General navigation
	/**
	 * Swipe in a direction from a start point Directions: 0: up, 1: right, 2:
	 * down, 3: left
	 * 
	 * @param startx
	 * @param starty
	 * @param direction
	 * @param duration
	 */
	public static void swipe(int startx, int starty, int direction, int duration) {
		int endx = 0;
		int endy = 0;
		switch (direction) {
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
		if (endx < 0)
			endx = 0;
		if (endx > getAppWidth())
			endx = getAppWidth();
		if (endy < 0)
			endy = 0;
		if (endy > getAppHeight())
			endy = getAppHeight();

		driver.swipe(startx, starty, endx, endy, duration);
	}

	public static void swipeUp() {
		// sk - 11/5/0216 - this swipe is not working anymore with Appium 1.6.0
		/*
		 * int startx = getAppWidth() / 2; int starty = (getAppHeight() / 6) *
		 * 5; swipe(startx, starty, 0, 500);
		 */

		// sk - 11/5/ - new swipe up
		Dimension size = driver.manage().window().getSize();
		int centerX = size.height / 2;
		int centerY = size.width / 2;
		new TouchAction(driver).press(centerX, centerY).waitAction(1000).moveTo(0, -250).release().perform();
		System.out.println("Swipe Up");
	}

	/**
	 * Swipe left to right
	 */
	public static void swipeRight() {
		int startx = getAppWidth() / 6;
		int starty = getAppHeight() / 2;
		swipe(startx, starty, 1, 500);
	}

	public static void swipeDown() {
		int startx = getAppWidth() / 2;
		int starty = getAppHeight() / 6;
		swipe(startx, starty, 2, 500);
	}

	/**
	 * Swipe right to left
	 */
	public static void swipeLeft() {
		int startx = (getAppWidth() / 6) * 5;
		int starty = getAppHeight() / 2;
		swipe(startx, starty, 3, 500);
	}

	/**
	 * Does a large swipe in the desired direction, used for paging left or
	 * right
	 * 
	 * @param direction
	 */
	public static void pageSwipe(int direction) {
		int y = getAppHeight() / 2;
		int startX = 0;
		int endX = 0;
		if (direction == 1) {
			// left to right
			startX = getAppWidth() / 10;
			endX = (getAppWidth() / 10) * 9;
		} else {
			// right to left
			startX = (getAppWidth() / 10) * 9;
			endX = getAppWidth() / 10;
		}
		try {
			driver.swipe(startX, y, endX, y, 500);
		} catch (Exception e) {
		}
	}
	
	/**
	 * scrollUp really just Swipes up. A swipe up covers about 3.5 cells on the iPhone. So two of these scrollDown calls will swipe up 7 cells. Test it thoroughly.
	 */
	public static void rootScrollUp(){
		System.out.println("rootScrollUp() : Swiping Up Once.");
		TouchAction ta1 = new TouchAction(driver);
		MultiTouchAction ma = new MultiTouchAction(driver);
		ta1.press(100, 550).waitAction(1000).moveTo(0, 200).release();
		ma.add(ta1).perform();
	}
	/**
	 * scrollDown really just Swipes up. A swipe up covers about 3.5 cells on the iPhone. So two of these scrollDown calls will swipe up 7 cells. Test it thoroughly.
	 */
	public static void rootScrollDown(){
		System.out.println("rootScrollDown() : Swiping Up Once.");
		TouchAction ta1 = new TouchAction(driver);
		MultiTouchAction ma = new MultiTouchAction(driver);
		ta1.press(100, 250).waitAction(1000).moveTo(0, -200).release();
		ma.add(ta1).perform();
	}
	/**
	 * Swipes on an element, keeping within the bounds of the element, if
	 * possible Will try to swipe to/from 10%-90% of the element +/- 4/5 from
	 * center 0=Up 1=Right 2=Down 3=Left
	 * 
	 * @param item
	 * @param direction
	 */
	public static void swipeOnItem(IOSElement item, int direction) {
		if (!isVisible(item)) {
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
		switch (direction) {
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

		if (startX != endX || startY != endY) {
			try {
				driver.swipe(startX, startY, endX, endY, 500);
			} catch (Exception e) {
				System.err.println("Error trying to swipe on element!\n");
				e.printStackTrace();
			}
		}
	}

	public static int getAppWidth() {
		if (appWidth == 0)
			appWidth = driver.manage().window().getSize().getWidth();
		return appWidth;
	}

	public static int getAppHeight() {
		if (appHeight == 0)
			appHeight = driver.manage().window().getSize().getHeight();
		return appHeight;
	}

	public static Set<String> getContextHandles() {
		Set<String> contexts = new HashSet<String>();
		try {
			contexts = driver.getContextHandles(); // Errors here
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contexts;
	}

	public static boolean switchToWebContext() {
		try {
			driver.context("WEBVIEW_1"); // WEBVIEW_1
			sleep(3500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver.getContext().equals("WEBVIEW_1");
	}

	public static boolean switchToNativeContext() {
		driver.context("NATIVE_APP");
		sleep(1000);
		return driver.getContext().equals("NATIVE_APP");
	}

	//// Waiting Methods ////
	//sk - 2/24 - the method was returning false even when the element was displayed as there was no 'return true'
	public static boolean isVisible(IOSElement e) {
		boolean isVisible = false;
		if (e == null) {
			//System.out.println("Failing in isVisible(), element is being sent as null");
			return false;
		}
		try {
			driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
			isVisible = e.isDisplayed();
			System.out.println("isDisplayed() in isVisible(): " +  isVisible);
			return isVisible;		
		} catch (Exception x) {
		} finally {
			driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		}
		return isVisible;
	}

	public static boolean isEnabled(IOSElement e) {
		boolean isEnabled = false;
		if (e == null)
			return false;
		try {
			driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
			isEnabled = e.isEnabled();
			System.out.println("isEnabled() in isVisible(): " + isEnabled);			
			return isEnabled;
		} catch (Exception x) {
		} finally {
			driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		}
		return isEnabled;
	}

	public static void sleep(int timeInMs) {
		try {
			Thread.sleep(timeInMs);
		} catch (Exception e) {
		}
	}

	/**
	 * Waits until the document readtState equals complete AKA: a page has
	 * loaded Uses Javascript Executor
	 * 
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

	public static IOSElement waitForPresent(IOSDriver<IOSElement> d, By by, long timeoutInSec) {
		long timeLeftMil = timeoutInSec * 1000;
		while (timeLeftMil > 0) {
			if (findElement(d, by) != null) {
				break;
			}
			// sleep(200);
			timeLeftMil -= 1000;
		}
		return (IOSElement) d.findElement(by);
	}

	public static IOSElement waitForVisible(IOSDriver<IOSElement> d, By by, long timeoutInSec) {
		// Wait for it to be present (not just clickable/visible, but loaded)
		long timeLeftMil = timeoutInSec * 1000;
		while (timeLeftMil > 0) {
			if (findElement(d, by) != null) {
				break;
			}
			timeLeftMil -= 1000; // Takes about a second each time
		}

		IOSElement returnElement = null;
		try {
			returnElement = findElement(d, by);
		} catch (Exception e) {
			System.out.println(
					"waitForVisible() failed because the element could not be found...  by = " + by.toString());
		}
		return returnElement;
	}

	public static boolean waitForElementToBeVisible(IOSElement ele, int timeInSeconds) {
		if (isVisible(ele)) {
			return true; // Already visible
		}
		long timeLeftMil = timeInSeconds * 1000;
		while (timeLeftMil > 0) {
			if (isVisible(ele)) {
				break;
			}
			// sleep(100); // Intentionally mismatched to make up for time
			// searching for element
			timeLeftMil -= 1000;
		}
		return isVisible(ele);
	}

	public static boolean waitForElementToBeEnabled(IOSElement ele, int maxWaitTimeSeconds) {
		if (!isVisible(ele)) {
			waitForElementToBeVisible(ele, maxWaitTimeSeconds);
			maxWaitTimeSeconds = 1;
		}
		if (ele.isEnabled()) {
			return true;
		}

		while (maxWaitTimeSeconds > 0) {
			try {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
				if (ele.isEnabled()) {
					//System.out.println("WaitForElementToBeEnabled(): Element is enabled");
					break;
				}
			} catch (Exception e) {
			} finally {
				maxWaitTimeSeconds -= 1;
				driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
			}
		}
		if (!isVisible(ele)) {
			return false;
		}
		return ele.isEnabled();
	}

	public static boolean waitForNotVisible(IOSDriver<IOSElement> d, By by, int maxWaitTimeSeconds) {
		boolean elementGone = false;
		for (int i = 0; i < maxWaitTimeSeconds; i++) {
			try {
				IOSElement element = waitForVisible(d, by, 1);
				if (element == null) {
					elementGone = true;
					break;
				}
			} catch (Exception e) {
			}
		}
		return elementGone;
	}

	public static boolean click(IOSDriver<IOSElement> d, By by) {
		IOSElement clickMe = findElement(d, by);
		if (isVisible(clickMe)) {
			clickMe.click();
			return true;
		}
		return false;
	}

	public static boolean click(IOSDriver<IOSElement> d, IOSElement ele) {
		boolean couldClick = false;

		if (isVisible(ele)) {
			try {
				ele.click();
				couldClick = true;
			} catch (Exception e) {}
		}

		return couldClick;
	}

	/**
	 * If a string is not empty and not null ("good"), return true
	 * 
	 * @param s
	 * @return
	 */
	public static boolean strGood(String s) {
		return s != null && s.length() > 0;
	}

	/**
	 * For test cases that return an error string, this gets a simple boolean by
	 * inverting the logic of the standard string test, returning TRUE if there
	 * are NO ERRORS.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean didPass(String s) {
		return !strGood(s);
	}

	public static boolean passed(String s) { // A rose by any other name...
		return didPass(s);
	}

	public static boolean didPass(Errors err) {
		return err.howMany() == 0;
	}

	public static boolean passed(Errors err) {
		return didPass(err);
	}

	public static boolean isAbout(int testing, int expected) {
		return isAbout(testing, expected, 2);
	}

	public static boolean isAbout(int testing, int expected, int variance) {
		if (testing == expected || testing + variance >= expected && testing - variance <= expected) {
			return true;
		}
		return false;
	}

	public static String getTextOfInt(int x) {
		String returnString = "";

		returnString = String.valueOf(x);
		switch (returnString.charAt(returnString.length() - 1)) {
		case '1':
			returnString += "st";
			break;
		case '2':
			returnString += "nd";
			break;
		case '3':
			returnString += "rd";
			break;
		default:
			returnString += "th";
			break;
		}

		return returnString;
	}

	public static LocalTime consoleLogStart(String consoleMessage) {
		System.out.println(consoleMessage);
		return LocalTime.now();
	}

	public static void consoleLogEnd(LocalTime begin, boolean testResult, String endMessage) {
		Duration seconds = Duration.between(begin, LocalTime.now());
		String result = testResult ? "Test Passed. " : "Test Failed. ";
		System.out.println(result + endMessage + "    [ " + seconds.getSeconds() + " seconds ]");

	}

	/**
	 * Retries is there is a failure related to a session termination, not an assert or other exception
	 * @author daniellegolinsky
	 *
	 */
	public class RetryRule implements TestRule{
		int retries = 1; // default
		public RetryRule(){
			this.retries = 1;
		}
		public RetryRule(int r){
			this.retries = r;
		}
		
		@Override
		public Statement apply(Statement base, Description description) {
			return statement(base, description);
		}
		
		private Statement statement(final Statement base, final Description description){
			return new Statement(){
				@Override
				public void evaluate() throws Throwable {
					// Save the exception for the end of the retries
					Throwable caughtThrowable = null;
					
					for (int i = 0; i < retries; i++){
						try{
							base.evaluate();
							return; // End
						}
						catch (Throwable t){
							System.out.println(t);
							caughtThrowable = t;
							// Only retry if it was a driver issue, not an assertion
							if(!(t instanceof java.lang.AssertionError)
									&& t.getMessage().contains("session is either terminated or not started")){
								System.err.println("\n\nRun #" + (i + 1) + " failed, may retry.");
							}
							else{
								throw t;
							}
						}
					}
					if (caughtThrowable != null){
						throw caughtThrowable;
					}
				}
			};
		}
	}
	
	
	/**
	 * Screenshot Rule Runs after every test. If the test passed, this runs the
	 * usual shutdown method If it failed, it takes a screenshot, then runs the
	 * usual shutdown method This replaces @after with the following:
	 * 
	 * @Rule public ScreenshotRule screenshot = new ScreenshotRule();
	 * 
	 */
	public class ScreenshotRule implements MethodRule {

		@Override
		/**
		 * Tests run within this. Once it ends, it takes a screenshot for
		 * failures, but ends regardless
		 */
		public Statement apply(Statement statement, FrameworkMethod method, Object target) {
			return new Statement() {
				@Override
				/**
				 * Run the test, if it fails, catch the failure (an
				 * exception/throwable) and take a screenshot, before allowing
				 * the failure to continue. Then, fail the test.
				 */
				public void evaluate() throws Throwable {
					try {
						statement.evaluate();
					} catch (Throwable t) {
						// Catch the failure, take the screenshot, then pass the
						// failure on
						if (driver != null) {
							Errors.captureScreenshot(driver, method.getName());
						}
						// Make sure we quit
						tearDown();
						// Throw the original error
						throw t;
					} finally {
						// Quit even if it did not fail
						tearDown();
					}
				}
			};
		}
	}
	
	/**
	 * sk - 1/23 - added method to enable going to any album on artist profile page indicated by an integer
	 */
	public IOSElement generateIOSElementId(String eleName, int x){
		String value = eleName + "-" + x;
		return (findElement(driver, By.id(value)));
	}
	
	
	public GifSequenceWriter initGIFWriter(){
		String filePath = "";
		if (driver != null) {
			filePath = Errors.captureScreenshot(driver, "");
		}
		 BufferedImage firstImage;
		 ImageOutputStream output;
		 GifSequenceWriter gifSequenceWriter = null;
		try {
			firstImage = ImageIO.read(new File(filePath));
			filePath = filePath.substring(0, filePath.length()-4) + "-GIF" + ".png";
			output = new FileImageOutputStream(new File(filePath));
			gifSequenceWriter = new GifSequenceWriter(output, firstImage.getType(), 1500, true);
			gifSequenceWriter.writeToSequence(firstImage);
		} catch (IOException e) {
			System.out.println("Init GIF Writer Failed");
		}
		
		return gifSequenceWriter;
		
		
	}
	public void addPageToGif(GifSequenceWriter writer){
		sleep(1000);
		String filePath = "";
		if (driver != null) {
			filePath = Errors.captureScreenshot(driver, "");
		}
		 try {
			BufferedImage nextImage = ImageIO.read(new File(filePath));
			writer.writeToSequence(nextImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public boolean closeGifWriter(GifSequenceWriter writer){
		try {
		BufferedImage endImage = ImageIO.read(new File("screenshots/endImage.png"));
			writer.writeToSequence(endImage);

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return true;
	}
}
