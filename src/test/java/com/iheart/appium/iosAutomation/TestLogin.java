package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestLogin extends TestRoot {
	
	@Rule
	public TestName name = new TestName();
	

	@Before
	public void setUp() {
		setup();
	}

	@After
	public void after(){
		tearDown();
	}
	
        // Can't always switch context, Appium bug
	// Only fails when ran in a suite
        // Starting with a reset seems to help

    @Test(timeout=200000)
	public void testLoginViaFacebook()  {

		LocalTime before = consoleLogStart("Testing login via Facebook.");
		boolean testResult = loginPage.loginViaFacebook();
		Assert.assertTrue("Could not log in via Facebook", testResult);
		consoleLogEnd(before, testResult,  "Tested login via Facebook.");
	}

	@Test 
	public void testLoginViaEmail(){
		LocalTime before = consoleLogStart("Testing login via Email." + name.getMethodName());
		boolean testResult = loginPage.login();
		Assert.assertTrue("Could not log in with email and password", testResult);
		consoleLogEnd(before, testResult, "Tested Log In via Email.");
	}
	
	@Test
	public void testIOSElementsOnPage() {
		LocalTime before = consoleLogStart("Testing IOSElements on Log In Page");
		loginPage.checkValuesOfElements();
		consoleLogEnd(before, true, "Tested IOSElements");
	}
	
	@Test
	public void testResetPasswordPage(){
		LocalTime before = consoleLogStart("Testing IOSElements on resetPasswordPage");
		onboardingPage.clickOnboardingLoginButton();
		loginPage.clickForgotYourPasswordButton();
		Assert.assertTrue("Clicking 'Forgot your Password' didn't bring app to Reset Password Page", resetPasswordPage.isCurrentlyOnResetPasswordPage());
		if(resetPasswordPage.showAllElements()){
			resetPasswordPage.clearEmailAddress();
			resetPasswordPage.enterEmailAddressToResetPassword("abademail@gmail.com");
			resetPasswordPage.clickResetPasswordButtonWithBadEmail();
			resetPasswordPage.clickBackButton();
		}
		boolean onLoginPage = loginPage.currentlyOnLoginPage();
		Assert.assertTrue("Not currently on loginPage, check for ResetPassword issues",onLoginPage );
		consoleLogEnd(before, onLoginPage, "Tested IOSElements on resetPasswordPage");
	}
	
	// Since Google opens Safari, we can't access those elements. 
	@Ignore
	@Test
	public void testLoginViaGoogle(){
		
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
