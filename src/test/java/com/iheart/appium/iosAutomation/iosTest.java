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

public class iosTest {
	private static final String DEVICE_NAME = "QA iPhone 5s";
	 private static final String UDID ="6a667778f94f8241aa6511e3c8cbc8b1643bb9b5"; //IPHONE 5s
	//private static final String UDID = "d7cb4ae985ed62b786a621597c9c0d53a4c1e678";
	 private static final String BUNDLE_ID = "com.clearchannel.iheartradio";
	 private static final String IPA_NAME = "/Users/1111128/git/ios-flagship/iPhone.ipa";
	 
	 private HomePage homePage;
	 private LoginPage loginPage;
	 private SignUpPage signupPage;
	 private Player player;
	 private SideNavigationBar sideNavBar;

	 private ForYouPage forYouPage;
	 private PerfectForPage perfectForPage;
	 private DeepLink deepLink;
	 
	 private IOSDriver driver;
	  
	  private String sessionId;
	  
	  @Rule public TestName name = new TestName();
		
	
	@Before
	  public void setUp() throws Exception {
		
		//BasicConfigurator.configure();
	   driver = Utils.launchAPPinSimulator();
	  // driver = Utils.launchAPPinRealDevice(DEVICE_NAME, UDID, BUNDLE_ID, IPA_NAME);
		
	   Page.setDriver(driver);
	  
	   
      loginPage = new LoginPage(driver);
      signupPage = new SignUpPage(driver);
      player = new Player(driver);
      sideNavBar = new SideNavigationBar(driver);
      
      forYouPage = new ForYouPage(driver);
      perfectForPage = new PerfectForPage(driver);
      
      deepLink = new DeepLink(driver);
	    
	  }
	
	@Test
	public void test_AIOS_22642_playCustomStation() throws Exception {
	   try{
		   loginPage.login();
	       perfectForPage.AIOS_22642_playCustomStation();
		 	
	   }catch(Exception e)
	   {   e.printStackTrace();
		   Utils.takeScreenshot(driver, "testLogin");
	   }
	}
	
	@Ignore("Skip")
	public void test_AIOS_22669_loginViaGoogle() throws Exception {
	   try{
	       loginPage.loginViaGoogle();
		 	
	   }catch(Exception e)
	   {   e.printStackTrace();
		   Utils.takeScreenshot(driver, "testLogin");
	   }
	}
	
	
	@Ignore("skip this")
	public void test_AIOS_22669_loginViaFacebook() throws Exception {
	   try{
	       loginPage.loginViaFacebook();
		 	
	   }catch(Exception e)
	   {   e.printStackTrace();
		   Utils.takeScreenshot(driver, "testLogin");
	   }
	}
	
	
	@Test
	public void test_AIOS_22672_createAnAccount() throws Exception {
	   try{
	       signupPage.AIOS_22672_createAnAccount();
			
	   }catch(Exception e)
	   {   e.printStackTrace();
		   Utils.takeScreenshot(driver, "test_AIOS_22672_createAnAccount");
	   }
	}
    
	
	
    
	
	  @After
	  public void tearDown() {
	      driver.quit();
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
