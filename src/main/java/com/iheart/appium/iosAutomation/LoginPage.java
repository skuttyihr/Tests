package com.iheart.appium.iosAutomation;

import io.appium.java_client.pagefactory.*;

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
	
	public boolean verifyLogin(){
		// Now go to setting to check login status
		sideNavigationBar.gotoSettings();

		// check status
		IOSElement loggedInStatus = waitForVisible(driver, By.name("Logged In"), 2); 
		if(loggedInStatus != null){
			String status = loggedInStatus.getText();
			if (status == null || status.length() <= 0 || !status.equals("Logged In"))
				return false;
			else
				return true;
		}
		else{
			// Logged in via email
			loggedInStatus = waitForVisible(driver, 
							By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]"), 2);
			if(loggedInStatus != null){
				String email = loggedInStatus.getText();
				if (email == null || email.length() <= 0)
					return false;
				else
					return true;
			}
			else{
				return false;
			}
		}
	}

	public boolean login() { // logger.info("About to login...");
		boolean loggedIn = false;
		waitForElementToBeVisible(loginButton, 20);
		loginButton.click();
		waitForElementToBeVisible(userName, 5);
		userName.sendKeys(USER_NAME);
		password.sendKeys(PASSWORD);
		logInFormButton.click();
		
//		chooseStayConnected(false);
		dismissLoginPopups();
		
		if(waitForVisible(driver, By.name("IHRiPhoneGenrePickerView"), 7) != null){
			genrePage.selectGenre("Alternative");
		}
		
//		chooseStayConnected(false);
		dismissLoginPopups();
		// verify we are in
		IOSElement forYouTest = waitForVisible(driver, By.name("For You"), 20);
		if(forYouTest != null && isVisible(forYouTest)){
			loggedIn = verifyLogin();
		}
		
		if(!isVisible(homePage.forYou)){
			sideNavBar.gotoHomePage();
		}
		
		return loggedIn;
	}

	public boolean loginViaFacebook() {
		waitForElementToBeVisible(loginButton, 10);
		loginButton.click();
		waitForElementToBeVisible(userName, 5);
		facebookButton.click();
		
		//Sleep to allow web to display, can't wait because context needs to switch
		TestRoot.sleep(2000);
		if(switchToWebContext()){
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
		if(!switchToNativeContext()){
			System.err.println("Could not switch back to native context!");
		}
		dismissLoginPopups();
		// check status
		return verifyLogin();
	}
	private void dismissLoginPopups(){
		handlePossiblePopUp();
		handleWantYourLocalRadioPopup();
		tellUsWhatYouLike();
		dismissStayConnectedPopup();
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
		return isVisible(logIn);
	}
	
	public boolean loginViaGoogle() {
		clickLogin();
		googleButton.click();

		if(switchToWebContext()){
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
			
			// Try to go back to iHeart (iOS 9 only button click)
			findElement(driver, By.name("Back to iHeartRadio")).click();
			if(switchToNativeContext()){
				dismissLoginPopups();
			}
			else{
				System.err.println("Could not switch back to native context after Google login!");
			}
		}
		else{
			System.err.println("Could not switch context for Google Login");
			return false;
		}
		return verifyLogin();
	}

	public void dismissStayConnectedPopup() {
		try {
			waitForVisible(driver, By.name("Maybe Later"), 4).click();
		} catch (Exception e) {
		}
	}

	public void chooseStayConnected(boolean stayConnected) {
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
	public void tellUsWhatYouLike() {
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
