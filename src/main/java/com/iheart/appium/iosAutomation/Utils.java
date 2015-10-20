package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;




public class Utils {
	
	  public static void takeScreenshot(WebDriver driver, String testMethod) throws Exception 
	   {      
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	   			Date date = new Date();
	   			//System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		       String screenshotName = testMethod + dateFormat.format(date) + ".png";
		       System.out.println("See screenshotName:" + screenshotName);
	           File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //The below method will save the screen shot in d drive with name "screenshot.png"
	           FileUtils.copyFile(scrFile, new File(screenshotName));
	           System.out.println("Screenshot is taken.");
	   }
	   
	
	public static void waitForPageToLoad(WebDriver driver) {
	    ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	
	        public Boolean apply(WebDriver driver) {
	
	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	
	        }
	
	      };
	
	    Wait<WebDriver> wait = new WebDriverWait(driver,1000);
	
	      try {
	
	              wait.until(expectation);
	
	      } catch(Throwable error) {
	
	              System.out.println("Timeout waiting for Page Load Request to complete.");
	
	      }
	
	} 
	
	
	
	
	public static int getRandomInt()
	{
		Random randomGenerator = new Random();
	  
	    int randomInt = randomGenerator.nextInt(999999);
	     
	    return randomInt;
	    
	}
	
	public static IOSDriver launchBrowser(String browser) throws Exception
	{
		 IOSDriver driver;
		
		
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.4");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
	    desiredCapabilities.setCapability("browser", "safari");
	    desiredCapabilities.setCapability("appiumVersion", "1.4.8");
	    
	   driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	   return driver;
	}
	
	public static IOSDriver launchBrowserInRealDevice(String browser, String deviceName, String udid, String bundleid) throws Exception
	{
		 IOSDriver driver;
		
		
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.4");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
	    desiredCapabilities.setCapability("udid", udid);
	   // desiredCapabilities.setCapability("bundleid", bundleid); //com.clearchannel.iheartradio
		
	    desiredCapabilities.setCapability("browser", browser);
	    desiredCapabilities.setCapability("appiumVersion", "1.4.8");
	    
	   driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	   WaitUtility.sleep(5000);
	   return driver;
	}
	
	
	//default to iphone 6
	public  static IOSDriver launchAPPinSimulator() throws Exception
	{
		return launchAPPinSimulator("iPhone 6");
	}
	
	public  static  IOSDriver launchAPPinSimulator(String simulatorName) throws Exception
	{
		 IOSDriver driver;
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.4");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, simulatorName);
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/1111128/Library/Developer/Xcode/DerivedData/iPhone-cgjadqsrbgztopfcrtkodcgtscgf/Build/Products/Debug-iphonesimulator/iHeartRadio.app");
	    desiredCapabilities.setCapability("appiumVersion", "1.4.8");
	   
	   
	   driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	   WaitUtility.sleep(5000);
	   return driver;
	}
	
	
	//This is for native, what about mobile web? 
	public static IOSDriver launchAPPinRealDevice(String deviceName, String udid, String bundleid, String ipaName) throws Exception
	{
		 IOSDriver driver;
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();

		 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.4");
		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		// capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		 //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
		//capabilities.setCapability("device", "iPhone 5s");
		//capabilities.setCapability("udid", "6a667778f94f8241aa6511e3c8cbc8b1643bb9b5");
		//capabilities.setCapability("bundleid", "com.example.appiumiphonetest");
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("bundleid", bundleid); //com.clearchannel.iheartradio
		//capabilities.setCapability("ipa", "MyiOSApp.ipa");
		capabilities.setCapability("ipa", ipaName); ///Users/1111128/git/ios-flagship/iPhone.ipa
		capabilities.setCapability("appiumVersion", "1.4.8");
	   
	   
	   driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   Page.setIsRealDevice(true);
	   WaitUtility.sleep(5000);
	   return driver;
	}



	public static Map<String, String> getLocationByIp(WebDriver driver)
	{    Map<String, String> geoInfo = new HashMap<String, String>();
		 driver.navigate().to("http://www.iplocation.net");
		 String country = driver.findElement(By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
		 String state = driver.findElement(By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(3)")).getText();
		 String city = driver.findElement(By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(4)")).getText();
		 
		 geoInfo.put("country", country);
		 geoInfo.put("state", state);
		 geoInfo.put("city", city);
		 
		 
		 
		 return geoInfo;
	}
	

}
