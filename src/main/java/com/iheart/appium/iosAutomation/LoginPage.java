package com.iheart.appium.iosAutomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
/**
 * LoginPage refactored by Travis Statham on 7/2016
 * AccessibilityIdentifiers added to ios-flagship master so we can click and access them easily. 
 * Methods added to mutate all private IOSElements
 * loginPage is reached by using onboardingPage.clickOnboardingLoginButton()
 * @author travisstatham
 *
 */
public class LoginPage extends Page {

	//Nav Bar Elements
	@iOSFindBy(accessibility = "NavBarBackButton") private IOSElement NavBarBackButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[2]") private IOSElement NavBarTitle;
	//Main container contains Email, Password, Log In and Forgot your password?
	@iOSFindBy(accessibility = "IHRiPhoneLoginView-MainContainer-UIView") private IOSElement IHRiPhoneLoginViewMainContainerUIView;
	    //TableView contains Email and Password Cells and their TextFields
		@iOSFindBy(accessibility = "IHRAuthorizationView-TableView-UITableView") private IOSElement IHRAuthorizationViewTableViewUITableView;
			@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddress-UITableViewCell") private IOSElement IHRAuthorizationViewEmailAddressCell;
				@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddress-TextField") private IOSElement IHRAuthorizationViewEmailAddressTextField;
			@iOSFindBy(accessibility = "IHRAuthorizationView-PasswordCell-UITableViewCell")     private IOSElement IHRAuthorizationViewPasswordCell;	
				@iOSFindBy(accessibility = "IHRAuthorizationView-Password-TextField")     private IOSElement IHRAuthorizationViewPasswordTextField;
		@iOSFindBy(accessibility = "IHRAuthorizationView-LogInAuthButton-UIButton")  private IOSElement IHRAuthorizationViewLogInAuthButtonUIButton;
		@iOSFindBy(accessibility = "IHRAuthorizationView-ForgotPasswordButton-UIButton") private IOSElement IHRAuthorizationViewForgotPasswordButtonUIButton;
	//OrConnectWith container just contains a label
	@iOSFindBy(accessibility = "IHRAuthorizationView-OrConnectWithContainer-UIView") private IOSElement IHRAuthorizationViewOrConnectWithContainerUIView;
		@iOSFindBy(accessibility = "IHRAuthorizationView-OrConnectWithLabel-UILabel") private IOSElement IHRAuthorizationViewOrConnectWithLabelUILabel;
	//SocialContainer UIView contains the Facebook and Google Log In Buttons	
	@iOSFindBy(accessibility = "IHRAuthorizationView-SocialContainer-UIView") private IOSElement IHRAuthorizationViewSocialContainerUIView;
		@iOSFindBy(accessibility = "IHRAuthorizationView-FacebookButton-UIButton") private IOSElement IHRAuthorizationViewFacebookButtonUIButton;
		@iOSFindBy(accessibility = "IHRAuthorizationView-GoogleButton-UIButton")   private IOSElement IHRAuthorizationViewGoogleButtonUIButton;


	//Web Elements for Facebook Login
	//@iOSFindBy(accessibility = "Facebook") private WebElement facebookButton;

	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement fbEmail;
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private IOSElement fbPassword;
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]") private IOSElement fbLogin;
	@iOSFindBy(accessibility= "Email or Phone") private WebElement fbEmailField;
	@iOSFindBy(accessibility= "Facebook Password") private WebElement fbPasswordField;
	@iOSFindBy(accessibility= "Log In") private WebElement fbLogInField;

	

	// WEB version
	@FindBy(name = "email") private WebElement facebookEmail_web;
	@FindBy(name = "pass") private WebElement facebookPass_web;
	@FindBy(name = "login") private WebElement facebookLogin;

	// Native version

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement facebookEmail_native;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private WebElement facebookPassword_native;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]") private WebElement FBlogin_native;

	@iOSFindBy(accessibility = "Google") private WebElement googleButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement googleEmail;
	@iOSFindBy(accessibility = "Next") private WebElement nextButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private WebElement googlePassword;
	@iOSFindBy(accessibility = "Sign in") private WebElement signIn;
	// for first-timer
	@iOSFindBy(accessibility = "Continue") private WebElement continueButton; // for first-time login user
	@iOSFindBy(accessibility = "Allow") private WebElement allowButton;


	public LoginPage() {
		super();
	}

	public LoginPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	/**
	 * Logs in, verifies log in, and returns to home page
	 * @return
	 */
	public boolean login() { // logger.info("About to login...");
		System.out.println("About to login()");
		boolean loggedIn = false;
		// Log in
		loginWithoutVerifying();
		// verify we are in
		IOSElement forYouTest = waitForVisible(driver, By.name("For You"), 20);
		if(forYouTest != null && isVisible(forYouTest)){
			loggedIn = settings.isLoggedIn();
		}
		sideNavBar.gotoHomePage();
		return loggedIn;
	}
	

	/**
	 * If String emailAddress is null, it will use default system property email address. 
	 * @param emailAddress
	 */
	public void enterLoginEmailAddress(String emailAddress){
		System.out.println("enterLoginEmailAddress()");
		IHRAuthorizationViewEmailAddressTextField.click();
		if(emailAddress!= null){
			IHRAuthorizationViewEmailAddressTextField.sendKeys(emailAddress);
		}
		else {
			IHRAuthorizationViewEmailAddressTextField.sendKeys(IHEARTUSERNAME);
		}
	}
	
	public void clearLoginEmailAddress(){
		System.out.println("clearLoginEmailAddress()");
		IHRAuthorizationViewEmailAddressTextField.clear();
	}
	
	/**
	 * If String password is null, it will use default system property password. 
	 * @param password
	 */
	public void enterLoginPassword(String password){
		System.out.println("enterLoginPassword()");
		IHRAuthorizationViewPasswordTextField.click();
		if(password!= null){
			IHRAuthorizationViewPasswordTextField.sendKeys(password);
		}
		else {
			IHRAuthorizationViewPasswordTextField.sendKeys(IHEARTPASSWORD);
		}
	}
	public void clearLoginPassword(){
		System.out.println("clearLoginPassword()");
		IHRAuthorizationViewPasswordTextField.clear();
	}
	/**
	 * Click Facebook Login Button
	 */
	public void clickFacebookLoginButton(){
		System.out.println("clickFacebookLoginButton()");
		IHRAuthorizationViewFacebookButtonUIButton.click();
	}
	
	/**
	 * Click Google Login Button
	 */
	public void clickGoogleLoginButton(){
		System.out.println("clickGoogleLoginButton()");
		IHRAuthorizationViewGoogleButtonUIButton.click();
	}
	/**
	 * Click the regular Log In Auth Button. This will only appear once text has been entered into the Email Address and Password text fields above it. 
	 */
	public void clickLogInAuthButton(){
		System.out.println("clickLogInAuthButton()");
		IHRAuthorizationViewLogInAuthButtonUIButton.click();
	}
	
	/**
	 * Click the Forgot your Password? button to reset your account's password. 
	 */
	public void clickForgotYourPasswordButton(){
		System.out.println("clickForgotYourPasswordButton()");
		IHRAuthorizationViewForgotPasswordButtonUIButton.click();
	}
	/**
	 * Logs in without checking settings.isLoggedIn(). 
	 * Enters userName and password and clicks Log in. 
	 * Minimizes player, handles pop-ups.
	 * Selects Alternative genre. 
	 */
	public void loginWithoutVerifying(){
		System.out.println("about to loginWithoutVerifying()");
		onboardingPage.clickOnboardingLoginButton();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 5);
		enterLoginEmailAddress(IHEARTUSERNAME);
		enterLoginPassword(IHEARTPASSWORD);
		System.out.println("Sent keys for Username and Password.");
		clickLogInAuthButton();
		System.out.println("Clicked Log In form button.");
		chooseStayConnected(false);
		player.minimizePlayer();
		// Dismiss zip code
		Page.enterZip();
		// Dismiss stay connected popup
		Page.handlePossiblePopUp();
		System.out.println("Dismissed Zip code and handled possible popups.");
		// Select Genre
		if(waitForVisible(driver, By.name("IHRiPhoneGenrePickerView"), 5) != null){
			genrePage.selectGenre("Alternative");
			System.out.println("Selected 'Alternative' genre.");
		}
		// Dismiss stay connected popup that sometimes shows up AFTER genre picker
		chooseStayConnected(false);
		System.out.println("Logged in without verifying");
	}


	/**
	 * Checks all the Values of the IOSElements, prints them to the console, fills in email address and password and logs in and verifies Homepage access.
	 * @return
	 */
	public boolean checkValuesOfElements(){
		onboardingPage.clickOnboardingLoginButton();
		System.out.println("On LoginPage, checking elements...");
		printElementInformation(IHRiPhoneLoginViewMainContainerUIView);
		printElementInformation(IHRAuthorizationViewTableViewUITableView);
		printElementInformation(IHRAuthorizationViewEmailAddressCell);
		printElementInformation(IHRAuthorizationViewEmailAddressTextField);
		printElementInformation(IHRAuthorizationViewPasswordTextField);
		printElementInformation(IHRAuthorizationViewPasswordCell);
		printElementInformation(IHRAuthorizationViewLogInAuthButtonUIButton);
		printElementInformation(IHRAuthorizationViewOrConnectWithContainerUIView);
		printElementInformation(IHRAuthorizationViewOrConnectWithLabelUILabel);
		printElementInformation(IHRAuthorizationViewSocialContainerUIView);
		printElementInformation(IHRAuthorizationViewFacebookButtonUIButton);
		printElementInformation(IHRAuthorizationViewGoogleButtonUIButton);
		printElementInformation(IHRAuthorizationViewForgotPasswordButtonUIButton);
		printElementInformation(NavBarBackButton);
		printElementInformation(NavBarTitle);

		enterLoginEmailAddress(null);
		enterLoginPassword(null);

		sleep(50);
		clickLogInAuthButton();
		chooseStayConnected(false);
		Page.enterZip();
		// Dismiss stay connected popup
		Page.handlePossiblePopUp();
		waitForElementToBeVisible(HomePage.forYouTab, 5);
		if(HomePage.forYouTab.isDisplayed()){
			System.out.println("For You Tab on Home is displayed- Log In worked!");
			return true;
		}
		return false;
	}
	/**
	 * Logs into a Facebook account. May fail if Facebook removes access from the account. 
	 * @return
	 */
	public boolean loginViaFacebook() {
		onboardingPage.clickOnboardingLoginButton();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 5);
		clickFacebookLoginButton();
		
		//Sleep to allow web to display, can't wait because context needs to switch
		TestRoot.sleep(10000);
		System.out.println("Current context: " + driver.getContext());
		Set<String> contexts = driver.getContextHandles();
		for(String context : contexts){
			System.out.println(context);
		}
		//This is extremely wonky! Rarely works and cannot find the fields. 
		if(switchToWebContext()){
			System.out.println("Current context should be WEBVIEW_1: " + driver.getContext());
			// Facebook changed their page
			if(fbEmailField != null && fbPasswordField != null && fbLogInField != null){
				fbEmailField.sendKeys(FACEBOOKUSERNAME);
				fbPasswordField.sendKeys(FACEBOOKPASSWORD);
				fbLogInField.click();
				System.out.println("Testing Facebook login. Entered FB Email, Password, and Clicked Login.");
			}
			IOSElement fbemailField = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]"));
			IOSElement fbpasswordField = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]"));
			IOSElement fbloginButton = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]"));
			if(fbemailField == null){
				fbemailField = findElement(driver, By.name("Email or Phone"));
			}
			if(fbpasswordField == null){
				fbpasswordField = findElement(driver, By.name("Facebook Password"));
			}
			if(fbloginButton == null){
				fbloginButton = findElement(driver, By.name("Log In"));
				
			}
			if(fbemailField != null && fbpasswordField != null && fbloginButton != null){
				fbemailField.sendKeys(FACEBOOKUSERNAME);
				fbpasswordField.sendKeys(FACEBOOKPASSWORD);
				fbloginButton.click();
				System.out.println("Testing Facebook login. Entered FB Email, Password, and Clicked Login.");
			}
			else{
				System.out.println("Facebook Email Field, Password, Log In Button don't seem to be found.");
			}
		
			sleep(2000);
			// Handle Authorization confirm
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
		try{
			genrePage.selectGenre(1);
		}catch(Exception e){} // This doesn't always display
		dismissLoginPopups();
		System.out.println("Current context: " + driver.getContext());
		// check status
		return settings.isLoggedIn();
	}
	/**
	 * Dismisses the possible popups that appear once you've logged in. 
	 */
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

	public boolean loginViaGoogle() {
		onboardingPage.clickOnboardingLoginButton();
		clickGoogleLoginButton();

		if(switchToWebContext()){
			googleEmail.sendKeys(GOOGLEUSERNAME);
			nextButton.click();
			googlePassword.sendKeys(GOOGLEPASSWORD);
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
		return settings.isLoggedIn();
	}

	public void dismissStayConnectedPopup() {
		try {
			waitForVisible(driver, By.name("Maybe Later"), 4).click();
		} catch (Exception e) {
		}
	}

	public void chooseStayConnected(boolean stayConnected) {
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
	public boolean currentlyOnLoginPage(){
		if(IHRAuthorizationViewForgotPasswordButtonUIButton.isDisplayed()){
			System.out.println("Currently on LoginPage");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public void tapBack(){
		System.out.println("Hitting 'Back' from LoginPage to go back to OnboardingPage");
		NavBarBackButton.click();
	}

}
