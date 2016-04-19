package com.iheart.appium.iosAutomation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestLogin extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
        // Can't always switch context, Appium bug
	// Only fails when ran in a suite
        // Starting with a reset seems to help

        @Test(timeout=200000)
	public void testLoginViaFacebook() {
		System.out.println("Testing login via Facebook.");
		Assert.assertTrue("Could not log in via Facebook", loginPage.loginViaFacebook());
	}
	
	@Test 
	public void testLoginViaEmail(){
		System.out.println("Testing login via Email Address.");
		Assert.assertTrue("Could not log in with email and password", loginPage.login());
	}
	
	// Since Google opens Safari, we can't access those elements. 
	@Ignore
	@Test
	public void testLoginViaGoogle(){
		System.out.println("Testing login Via Google.");
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
		}
	}
}
