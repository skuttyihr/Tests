package com.iheart.appium.iosAutomation;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import com.iheart.appium.iosAutomation.Utils;

public class TestRoot {

	protected static IOSDriver<IOSElement> driver;

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
	protected static PerfectForPage perfectForPage;
	protected static DeepLink deepLink;
	protected static PodcastsPage podcastsPage;
	protected static boolean useSimulator = false;
	
	protected static void setup() {
		
		String appiumUrl = "";
		String appiumPort = "";
		
		// Load up the properties file
		Properties props = null;
		try {
			props = Utils.loadProperties("ios.properties.local");
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
		Page.clearErrors();

		loginPage = new LoginPage(driver);
		signupPage = new SignUpPage(driver);
		player = new Player(driver);
		sideNavBar = new SideNavigationBar(driver);

		forYouPage = new ForYouPage(driver);
		perfectForPage = new PerfectForPage(driver);
		podcastsPage = new PodcastsPage(driver);

		deepLink = new DeepLink(driver);
	}

	protected static void tearDown() {
		if (Page.getErrors() != null && Page.getErrors().length() > 0) {
			fail(Page.getErrors().toString());
		}
		
		if(driver != null){
			try{
				driver.quit();
			}
			catch(Exception e){
				System.err.println("ERROR SHUTTING DOWN DRIVER");
				e.printStackTrace();
			}
		}
	}
	
	public static void sleep(int timeInMs){
		try{
			Thread.sleep(timeInMs);
		}catch(Exception e){}
	}

	@Rule
	public TestRule watcher = new TestWatcher() {

		@Override
		public void failed(Throwable e, Description description) {

			try {
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// String filePathRoot = "C:\\_Jenkins\\workspace\\" +
				// jenkinsJobName + "\\target\\surefire-reports\\";
				String currentPath = System.getProperty("user.dir");
				String path = currentPath + File.separator + "target" + File.separator + "surefire-reports" + File.separator;

				String fullFilePath = path + description.getClassName() + File.separator + description.getMethodName() + ".jpg";

				FileUtils.copyFile(screenshot, new File(fullFilePath));

			} catch (Exception ex) {
				System.out.println(ex.toString());
				System.out.println(ex.getMessage());
			}
		}
	};
}
