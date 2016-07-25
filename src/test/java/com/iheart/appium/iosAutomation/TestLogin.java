package com.iheart.appium.iosAutomation;



import java.time.LocalTime;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestLogin extends TestRoot {
	
	@Rule
	public TestName name = new TestName();
	
	@Rule
	public TestRule watcher = new TestWatcher() {
	    protected void starting(Description description) {
	       System.out.println("\nStarting test: " + description.getMethodName());
	    }
	 };

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@After
	public void after() throws Exception {
		
		TestRoot.tearDown();
	}
	
        // Can't always switch context, Appium bug
	// Only fails when ran in a suite
        // Starting with a reset seems to help

    //@Test(timeout=200000)
	public void testLoginViaFacebook()  {

		LocalTime before = consoleLogStart("Testing login via Facebook.");
		boolean testResult = loginPage.loginViaFacebook();
		Assert.assertTrue("Could not log in via Facebook", testResult);
		consoleLogEnd(before, testResult,  "Tested login via Facebook.");
	}

	//@Test 
	public void testLoginViaEmail(){
		LocalTime before = consoleLogStart("Testing login via Email." + name.getMethodName());
		boolean testResult = loginPage.login();
		Assert.assertTrue("Could not log in with email and password", testResult);
		consoleLogEnd(before, testResult, "Tested Log In via Email.");
	}
	
	//@Test
	public void testIOSElementsOnPage() {
		LocalTime before = consoleLogStart("Testing IOSElements on Log In Page");
		loginPage.checkValuesOfElements();
		consoleLogEnd(before, true, "Tested IOSElements");
	};
	
	// Since Google opens Safari, we can't access those elements. 
	//@Ignore
	@Test
	public void testLoginViaGoogle(){
		
		//6.4.1
		Assert.assertTrue("Google Login Done", loginPage.loginViaGoogle());
				
		/*
		int iOSVersion = 0;
		try{
			iOSVersion = Integer.parseInt(PLATFORM_VERSION.charAt(0) + "");
			}catch(Exception e){}
		if(iOSVersion >= 9){
			System.out.println("Testing login Via Google for iOS Platform Version: "+iOSVersion);		
			Assert.assertTrue("Could not log in via Google+", loginPage.loginViaGoogle());
		 }
				else{
					System.out.println("Skipping Google+ login for older OS: " + iOSVersion);
				}*/
		
	}
}
