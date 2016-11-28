package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
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
	 * LOG-1 - Login with NONE Account
	 */
	@Test
	public void testLoginViaEmail() {
		LocalTime before = consoleLogStart("Testing login via Email." + name.getMethodName());
		boolean testResult = loginPage.login();
		Assert.assertTrue("Could not log in with email and password", testResult);
		consoleLogEnd(before, testResult, "Tested Log In via Email. ((LOG-1))");
	}
	/**
	 * LOG-2    Login via Facebook Account
	 * Fails on Entering Password
	 */
	@Test(timeout = 200000)
	public void testLoginViaFacebook() {
		LocalTime before = consoleLogStart("Testing login via Facebook.");
		boolean testResult = loginPage.loginViaFacebook();
		Assert.assertTrue("Could not log in via Facebook", testResult);
		consoleLogEnd(before, testResult, "Tested login via Facebook. ((LOG-2))");
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
	public void testLoginViaGoogle() {
		LocalTime before = consoleLogStart("Testing Login with Google+");
		boolean testResult = loginPage.loginViaGoogle();
		Assert.assertTrue("Could not log in via Google+", testResult);
		consoleLogEnd(before, testResult, "Tested Google Login. ((LOG-3))");

	}
	/**
	 * LOG-4   Reset Password Page, attempts to reset password for bad account. 
	 * Does not actually reset password for a good account.
	 */
	@Test
	public void testResetPasswordPage() {
		LocalTime before = consoleLogStart("Testing IOSElements on resetPasswordPage : " + name.getMethodName() );
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
		Assert.assertTrue("Not currently on loginPage, check for ResetPassword issues", onLoginPage);
		consoleLogEnd(before, onLoginPage, "Tested IOSElements on resetPasswordPage. ((LOG-4))");
	}
	/**
	 * LOG-7    Free Account
	 */
	@Test
	public void testLoginViaEmail_FREEACCOUNT(){
		LocalTime before = consoleLogStart("Testing login via Email with a FREE Account : " + name.getMethodName());
		loginPage.loginWithoutVerifying("trav@free.com", "travfree");
		boolean testResult = homePage.isCurrentlyOnForYouTab();
		Assert.assertTrue("Could not log in with email and password", testResult);
		consoleLogEnd(before, testResult, "Tested Log In via Email with a FREE Account. ((LOG-7))");
	}
	/**
	 * LOG-8    Plus Account
	 */
	@Test
	public void testLoginViaEmail_PLUSACCOUNT(){
		LocalTime before = consoleLogStart("Testing login via Email with a PLUS Account : " + name.getMethodName());
		loginPage.loginWithoutVerifying("trav@plus.com", "travplus");
		boolean testResult = homePage.isCurrentlyOnForYouTab();
		Assert.assertTrue("Could not log in with email and password", testResult);
		consoleLogEnd(before, testResult, "Tested Log In via Email with a PLUS Account. ((LOG-8))");
	}
	/**
	 * LOG-9  All Access Account
	 */
	@Test
	public void testLoginViaEmail_ALLACCESSACCOUNT(){
		LocalTime before = consoleLogStart("Testing login via Email with a ALL Account : " + name.getMethodName());
		loginPage.loginWithoutVerifying("trav@all.com", "travall");
		boolean testResult = homePage.isCurrentlyOnForYouTab();
		Assert.assertTrue("Could not log in with email and password", testResult);
		consoleLogEnd(before, testResult, "Tested Log In via Email with a ALL Account. ((LOG-9))");
	}

	/**
	 * LOG-10
	 */
	@Test
	public void testIOSElementsOnPage() {
		LocalTime before = consoleLogStart("Testing IOSElements on Log In Page : " + name.getMethodName());
		loginPage.checkValuesOfElements();
		consoleLogEnd(before, true, "Tested IOSElements. ((LOG-10))");
	}

}
