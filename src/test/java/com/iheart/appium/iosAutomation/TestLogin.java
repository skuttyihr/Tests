package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
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

	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	// Can't always switch context, Appium bug
	// Only fails when ran in a suite
	// Starting with a reset seems to help

	

	/**
	 * LOG-1 - Login with Free Account
	 */
	@Test
	public void testLoginViaEmail_LOG1_FREE() {
		LocalTime before = consoleLogStart("Testing login via Email." + name.getMethodName());
		boolean testResult = loginPage.loginVerifyEntitlement("trav@free.com", "travfree", "FREE");
		Assert.assertTrue("Could not log in with email and password : ((LOG-1))", testResult);
		consoleLogEnd(before, testResult, "Tested testLoginViaEmail_LOG1_FREE ((LOG-1))");
	}
	/**
	 * LOG-2    Login via Facebook Account
	 * 
	 */
	@Test(timeout = 200000)
	public void testLoginViaFacebook_LOG2_FREE() {
		LocalTime before = consoleLogStart("Testing testLoginViaFacebook_LOG2_FREE");
		boolean testResult = loginPage.loginViaFacebook();
		Assert.assertTrue("Could not log in via Facebook : ((LOG-2))", testResult);
		consoleLogEnd(before, testResult, "Tested testLoginViaFacebook_LOG2_FREE ((LOG-2))");
	}
	/**
	 * LOG-3    Login via Google Account
	 * Click Login Button, Click Forgot Your Password, Show all the elements on
	 * Reset Password Page. Enter a bad email - click Reset and expect an error
	 * message. Click Back button and go back to Login page.
	 * 
	 * Refactor ideas: Create a New account - use email to reset the password.
	 * See how to get password out of email or use one of our own email.
	 * 
	 * 
	 * // sk 11/5 - Got Google Login to work
	 */
	@Test
	public void testLoginViaGoogle_LOG3_FREE() {
		LocalTime before = consoleLogStart("Testing Login with Google+ testLoginViaGoogle_LOG3_FREE");
		boolean testResult = loginPage.loginViaGoogle();
		Assert.assertTrue("Could not log in via Google+ : ((LOG-3))", testResult);
		consoleLogEnd(before, testResult, "Tested testLoginViaGoogle_LOG3_FREE. ((LOG-3))");

	}
	/**
	 * LOG-4   Reset Password Page, attempts to reset password for bad account. 
	 * Does not actually reset password for a good account.
	 */
	@Test
	public void testResetPasswordPage_LOG4_FREE() {
		LocalTime before = consoleLogStart("Testing testResetPasswordPage_LOG4_FREE : " + name.getMethodName() );
		onboardingPage.clickOnboardingLoginButton();
		loginPage.clickForgotYourPasswordButton();
		Assert.assertTrue("Clicking 'Forgot your Password' didn't bring app to Reset Password Page",
				resetPasswordPage.isCurrentlyOnResetPasswordPage());
		if (resetPasswordPage.showAllElements()) {
			resetPasswordPage.clearEmailAddress();
			resetPasswordPage.enterEmailAddressToResetPassword("abademail@gmail.com");
			resetPasswordPage.clickResetPasswordButtonWithBadEmail();
			resetPasswordPage.clickBackButton();
		}
		boolean onLoginPage = loginPage.currentlyOnLoginPage();
		Assert.assertTrue("Not currently on loginPage, check for ResetPassword issues. ((LOG-4))", onLoginPage);
		consoleLogEnd(before, onLoginPage, "Tested IOSElements on resetPasswordPage. ((LOG-4))");
	}
	
	@Test
	@Ignore
	public void testResetPasswordRealAccount_LOG5_FREE() {
		//This may be impossible to adequately test through automation.
	}
	
	@Test
	@Ignore
	public void testEmailMismatch_LOG6_FREE() {
		//This may be impossible to adequately test through automation.
	}
	
	/**
	 * LOG-7    Free Account
	 */
	@Test
	public void testLoginViaEmail_LOG7_FREE(){
		LocalTime before = consoleLogStart("Testing login via Email with a FREE Account : " + name.getMethodName());
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("trav@free.com", "travfree", "FREE"));
		consoleLogEnd(before, true, "Tested Log In via Email with a FREE Account. ((LOG-7))");
	}
	/**
	 * LOG-8    Plus Account
	 */
	@Test
	public void testLoginViaEmail_LOG8_PLUS(){
		LocalTime before = consoleLogStart("Testing login via Email with a PLUS Account : " + name.getMethodName());
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("trav@plus.com", "travplus", "PLUS"));
		consoleLogEnd(before, true, "Tested Log In via Email with a PLUS Account. ((LOG-8))");
	}
	/**
	 * LOG-9  All Access Account
	 */
	@Test
	public void testLoginViaEmail_LOG9_ALLACCESS(){
		LocalTime before = consoleLogStart("Testing login via Email with a ALL Account : " + name.getMethodName());
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("trav@all.com", "travall", "ALLA"));
		consoleLogEnd(before, true, "Tested Log In via Email with a ALL Account. ((LOG-9))");
	}

	/**
	 * LOG-10
	 */
	@Test
	public void testIOSElementsOnPage_LOG10_FREE() {
		LocalTime before = consoleLogStart("Testing IOSElements on Log In Page : " + name.getMethodName());
		loginPage.checkValuesOfElements();
		consoleLogEnd(before, true, "Tested IOSElements. ((LOG-10))");
	}

}
