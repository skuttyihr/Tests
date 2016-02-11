package com.iheart.appium.iosAutomation;

import io.appium.java_client.pagefactory.*;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.*;

import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]") private IOSElement userName;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]") private IOSElement password;
	@iOSFindBy(name = "Log In") private IOSElement loginButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") private IOSElement logInFormButton;
	@iOSFindBy(name = "Back") private IOSElement backButton;
	@iOSFindBy(name = "Log In") private IOSElement logIn;
	
	
	@iOSFindBy(name = "Facebook") private WebElement facebookButton;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement fbEmail;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private IOSElement fbPassword;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]") private IOSElement fbLogin;

	// WEB version
	@FindBy(name = "email") private WebElement facebookEmail_web;
	@FindBy(name = "pass") private WebElement facebookPass_web;
	@FindBy(name = "login") private WebElement facebookLogin;

	// Native version

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement facebookEmail_native;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private WebElement facebookPassword_native;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]") private WebElement FBlogin_native;

	@iOSFindBy(name = "Google") private WebElement googleButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement googleEmail;
	@iOSFindBy(name = "Next") private WebElement nextButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private WebElement googlePassword;
	@iOSFindBy(name = "Sign in") private WebElement signIn;
	// for first-timer
	@iOSFindBy(name = "Continue") private WebElement continueButton; // for first-time login user
	@iOSFindBy(name = "Allow") private WebElement allowButton;

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

	public boolean login() { // logger.info("About to login...");
		
		waitForElementToBeVisible(loginButton, 20);
		loginButton.click();
		waitForElementToBeVisible(userName, 5);
		userName.sendKeys(USER_NAME);
		password.sendKeys(PASSWORD);
		logInFormButton.click();
		
		chooseStayConnected(false);
		
		if(waitForVisible(driver, By.name("IHRiPhoneGenrePickerView"), 10) != null){
			signupPage.selectGenre("Alternative");
		}
		
		chooseStayConnected(false);
		
		// verify we are in
		IOSElement forYouTest = waitForVisible(driver, By.name("For You"), 35);
		if(forYouTest != null)
			return forYouTest.isDisplayed();
		else
			return false;
	}

//	public void loginViaFacebook_NEW() {
//		loginButton.click();
//		waitForElementToBeVisible(facebookButton, 10);
//		facebookButton.click();
//		
//		// Give Context time to switch
//		TestRoot.sleep(2000);
//		Set<String> handles = getContextHandles();
//		if(handles.size() > 1){ 
//			driver.context("WEBVIEW_1");
//			sleep(2000);
//		}
//		/*
//		 * //native view facebookEmail_native.sendKeys(FACEBOOK_USER_NAME);
//		 * facebookPassword_native.sendKeys(PASSWORD); FBlogin_native.click();
//		 * TestRoot.sleep(5000);
//		 */
//		waitForVisible(driver, By.name("email"), 5).sendKeys(FACEBOOK_USER_NAME);
//		driver.findElement(By.name("pass")).sendKeys(PASSWORD);
//		driver.findElement(By.name("login")).click();
//
//		// Handle Authorizaton confirm
//		waitForVisible(driver, By.name("__CONFIRM__"), 5).click();
//		
//		// Now switch to native view
//		if(handles.size() > 1){ 
//			sleep(500);
//			driver.context("NATIVE_APP");
//			sleep(2000);
//		}
//
//		handleWantYourLocalRadioPopup();
//		tellUsWhatYouLike();
//		dismissStayConnectedPopup();
//
//		// Now go to setting to check login status
//		try {
//			// In case navIcon is not showing up yet
//			sideNavigationBar.navIcon.click();
//		} catch (Exception e) {
//			tellUsWhatYouLike();
//		}
//		sideNavigationBar.gotoSettings();
//
//		// check status
//		String status = driver
//				.findElement(
//						By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]"))
//				.getText();
//		System.out.println("Status:" + status);
//		if (!status.equalsIgnoreCase("Logged In"))
//			Assert.fail("Facebook login failed.");
//	}

	public boolean loginViaFacebook() {
//		System.out.println("See context:" + driver.getContext());
		// getContextHandles();
		waitForElementToBeVisible(loginButton, 10);
		loginButton.click();
		waitForElementToBeVisible(userName, 5);
		facebookButton.click();
		
		//Sleep to allow web to display, can't wait because context needs to switch
		TestRoot.sleep(2000);
		Set<String> handles = getContextHandles();
		String webContext = "";
		if(handles != null && handles.size() > 0){
			for(String c : handles){
				if(c.contains("WEB")){
					webContext = c;
					driver.context(c);
				}
			}
			TestRoot.sleep(1000);
		}
		if(driver.getContext().equals(webContext)){
			// Delay so we can give them time
			sleep(1000);
			driver.findElement(By.name("email")).sendKeys(FACEBOOK_USER_NAME); // iheartrocks999@gmail.com
			driver.findElement(By.name("pass")).sendKeys(PASSWORD); // iheart001
			driver.findElement(By.name("login")).click();
			sleep(2000);
			// Handle Authorizaton confirm
			try{
				driver.findElement(By.name("__CONFIRM__")).click();
			}
			catch(Exception e){}
		}
		else{
			System.err.println("Could not switch to Facebook web view context.");
			return false;
		}
		// Now switch to native view
		if(handles != null && handles.size() > 1){
			sleep(1000);
			driver.context("NATIVE_APP");
			sleep(3000);
		}

		handleWantYourLocalRadioPopup();
		tellUsWhatYouLike();
		dismissStayConnectedPopup();

		// Now go to setting to check login status
		sideNavigationBar.gotoSettings();

		// check status
		String status = driver.findElement(
						By.name("Logged In"))
				.getText();
		System.out.println("Status:" + status);
		if (status == null || status.length() <= 0 || !status.equals("Logged In"))
			return false;
		else
			return true;
	}

	private void handleWantYourLocalRadioPopup() {

		try {
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]")).click();
		} catch (Exception e) {

		}

	}

	public boolean clickLogin(){
		loginButton.click();
		waitForElementToBeVisible(logIn, 2);
		return logIn.isDisplayed();
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
//		logger.info("see page:" + driver.getPageSource());

	}

	public void dismissStayConnectedPopup() {
		try {
			driver.findElement(By.name("Maybe Later")).click();
		} catch (Exception e) {
		}
	}

	private void chooseStayConnected(boolean stayConnected) {
		handlePossiblePopUp();
		tellUsWhatYouLike();
		try {
			if (stayConnected)
				waitForVisible(driver, By.name("Get Notifications"), 2).click();
			else
				waitForVisible(driver, By.name("Maybe Later"), 2).click();
		} catch (Exception e) {
		}
	}

	// Tell us what you like
	private void tellUsWhatYouLike() {
		try {
			driver.findElement(By.name("Pop")).click();
			driver.findElement(By.name("Done")).click();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	
	public void tapBack(){
		backButton.click();
	}

}
