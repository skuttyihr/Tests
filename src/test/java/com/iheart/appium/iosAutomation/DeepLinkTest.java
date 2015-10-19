package com.iheart.appium.iosAutomation;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*; 

import org.apache.log4j.BasicConfigurator;
import org.junit.Test; 
import org.junit.Ignore; 
import org.junit.Before; 
import org.junit.After; 
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestCase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class DeepLinkTest {
	private static final String DEVICE_NAME = "iPhone 6";
	// private static final String UDID ="6a667778f94f8241aa6511e3c8cbc8b1643bb9b5"; //IPHONE 5s
	private static final String UDID = "d7cb4ae985ed62b786a621597c9c0d53a4c1e678";
	 private static final String BUNDLE_ID = "com.clearchannel.iheartradio";
	 private static final String IPA_NAME = "/Users/1111128/git/ios-flagship/iPhone.ipa";
	 
	 
	 private DeepLink deepLink;
	 
	 private IOSDriver driver;
	  
	  private String sessionId;
	  
	  @Rule public TestName name = new TestName();
		
	
	@Before
	  public void setUp() throws Exception {
		
		//BasicConfigurator.configure();
	 
		//driver = Utils.launchBrowser("safari");
		driver = Utils.launchBrowserInRealDevice("Safari", "iphone 5s", UDID, BUNDLE_ID);
		driver.get("http://m.z100.com");
	   WaitUtility.sleep(8000);
	   Page.setDriver(driver);
     
       deepLink = new DeepLink(driver);
	    
	  }
	
	
	@Test
	public void AIOS_22641_doDeepLink() throws Exception {
	   try{
	       deepLink.AIOS_22641_doDeepLink();
			
	   }catch(Exception e)
	   {   e.printStackTrace();
		   Utils.takeScreenshot(driver, "testLogin");
	   }
	}
	
	 @After
	  public void tearDown() {
	       //driver.quit();
		  if (Page.getErrors().length() > 0)
				 fail(Page.getErrors().toString());
	    	   
	  }
	
	
	  private void handleException(Exception e)
	  {   Page.getErrors().append("Exception is thrown.");
	        e.printStackTrace();
	       
         try{
	    	   Utils.takeScreenshot(driver, name.getMethodName());
         }catch(Exception eX)
         {
         	
         }
         
	  }
}
