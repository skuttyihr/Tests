package com.iheart.appium.iosAutomation;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.*;

import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")
	private IOSElement userName;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]")
	private IOSElement password;
	@iOSFindBy(name = "Log In")
	private IOSElement loginButton;

	@iOSFindBy(name = "Facebook")
	private WebElement facebookButton;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	private WebElement fbEmail;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	private IOSElement fbPassword;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
	private IOSElement fbLogin;

	// WEB version
	@FindBy(name = "email")
	private WebElement facebookEmail_web;
	@FindBy(name = "pass")
	private WebElement facebookPass_web;
	@FindBy(name = "login")
	private WebElement facebookLogin;

	// Native version

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	private WebElement facebookEmail_native;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	private WebElement facebookPassword_native;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
	private WebElement FBlogin_native;

	@iOSFindBy(name = "Google")
	private WebElement googleButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	private WebElement googleEmail;
	@iOSFindBy(name = "Next")
	private WebElement nextButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	private WebElement googlePassword;
	@iOSFindBy(name = "Sign in")
	private WebElement signIn;
	// for first-timer
	@iOSFindBy(name = "Continue")
	private WebElement continueButton; // for first-time login user
	@iOSFindBy(name = "Allow")
	private WebElement allowButton;

	// for verification: Maybe shall move nav bar stuff up to the Page.java?
	@iOSFindBy(name = "For You")
	private WebElement forYou;

	public LoginPage() {
		super();
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public LoginPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void login() { // logger.info("About to login...");

		loginButton.click();

		userName.sendKeys(USER_NAME);
		password.sendKeys(PASSWORD);
		// loginButton.click();

		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
		if (isRealDevice)
			TestRoot.sleep(15000);
		else
			TestRoot.sleep(5000);

		chooseStayConnected(false);

		// verify we are in!

		driver.findElement(By.name("For You")).getText();
		try {
			driver.findElement(By.name("For You")).getText();
		} catch (Exception e) {
			errors.append("Home page is not shown.");
		}
	}

	public void loginViaFacebook_NEW() {
		loginButton.click();
		TestRoot.sleep(1000);
		facebookButton.click();
		TestRoot.sleep(2000);

		getContextHandles();

		System.out.println("See context Now:" + driver.getContext());

		driver.context("WEBVIEW_1");
		TestRoot.sleep(5000);
		System.out.println("After switch:" + driver.getContext());
		/*
		 * //native view facebookEmail_native.sendKeys(FACEBOOK_USER_NAME);
		 * facebookPassword_native.sendKeys(PASSWORD); FBlogin_native.click();
		 * TestRoot.sleep(5000);
		 */
		driver.findElement(By.name("email")).sendKeys(FACEBOOK_USER_NAME);
		driver.findElement(By.name("pass")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();

		TestRoot.sleep(2000);
		// Handle Authorizaton confirm
		driver.findElement(By.name("__CONFIRM__")).click();

		// Now switch to native view
		driver.context("NATIVE_APP");
		// System.out.println("See page:" + driver.getPageSource());

		TestRoot.sleep(5000);

		handleWantYourLocalRadioPopup();
		tellUsWhatYouLike();
		dismissStayConnectedPopup();

		// Now go to setting to check login status
		try {
			// In case navIcon is not showing up yet
			sideNavigationBar.navIcon.click();
		} catch (Exception e) {
			tellUsWhatYouLike();
		}
		sideNavigationBar.gotoSettings();

		// check status
		String status = driver
				.findElement(
						By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]"))
				.getText();
		System.out.println("Status:" + status);
		if (!status.equalsIgnoreCase("Logged In"))
			handleError("Facebook login failed.", "loginViaFacebook");
	}

	public void loginViaFacebook() {
		System.out.println("See context:" + driver.getContext());
		// getContextHandles();
		loginButton.click();
		TestRoot.sleep(1000);
		facebookButton.click();
		TestRoot.sleep(2000);

		getContextHandles();
		driver.context("WEBVIEW_1");
		TestRoot.sleep(5000);
		System.out.println("After switch:" + driver.getContext());
		driver.findElement(By.name("email")).sendKeys(FACEBOOK_USER_NAME);
		driver.findElement(By.name("pass")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();

		// Handle Authorizaton confirm
		driver.findElement(By.name("__CONFIRM__")).click();

		// Now switch to native view
		driver.context("NATIVE_APP");
		// System.out.println("See page:" + driver.getPageSource());

		TestRoot.sleep(5000);

		handleWantYourLocalRadioPopup();
		tellUsWhatYouLike();
		dismissStayConnectedPopup();

		// Now go to setting to check login status
		sideNavigationBar.gotoSettings();

		// check status
		String status = driver
				.findElement(
						By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]"))
				.getText();
		System.out.println("Status:" + status);
		if (!status.equalsIgnoreCase("Logged In"))
			handleError("Facebook login failed.", "loginViaFacebook");
	}

	private void handleWantYourLocalRadioPopup() {

		try {
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]")).click();
		} catch (Exception e) {

		}

	}

	public void loginViaGoogle() {
		loginButton.click();
		TestRoot.sleep(1000);
		googleButton.click();
		TestRoot.sleep(2000);
		googleEmail.sendKeys(GOOGLE_USER_NAME);
		nextButton.click();
		googlePassword.sendKeys(PASSWORD);
		signIn.click();
		try {
			continueButton.click();
		} catch (Exception e) {

		}

		try {
			allowButton.click();
		} catch (Exception e) {

		}
		// verfiy that we are in Perfect for now!
		// See page source:
		logger.info("see page:" + driver.getPageSource());

	}

	private void dismissStayConnectedPopup() {
		try {
			driver.findElement(By.name("Maybe Later")).click();
		} catch (Exception e) {

		}

		TestRoot.sleep(2000);
	}

	private void chooseStayConnected(boolean stayConnected) {
		handlePossiblePopUp();
		tellUsWhatYouLike();
		try {
			if (stayConnected)
				driver.findElement(By.name("Get Notifications")).click();
			else
				driver.findElement(By.name("Maybe Later")).click();
		} catch (Exception e) {

		}

		TestRoot.sleep(2000);
	}

	// Want your local radio?
	private void handlePossiblePopUp() {
		try {
			if (isRealDevice)
				TestRoot.sleep(10000);
			else
				TestRoot.sleep(1000);
			driver.findElement(By.name("No Thanks")).click();
		} catch (Exception e) {

		}
	}

	// Tell us what you like
	private void tellUsWhatYouLike() {
		TestRoot.sleep(2000);
		try {
			driver.findElement(By.name("Rock")).click();
			if (isRealDevice)
				TestRoot.sleep(2000);
			driver.findElement(By.name("Done")).click();
			TestRoot.sleep(2000);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
