package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends Page {

	
	@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddress-TextField") public IOSElement IHRAuthorizationViewEmailAddressTextField;
	@iOSFindBy(accessibility = "IHRAuthorizationView-Password-TextField")     public IOSElement IHRAuthorizationViewPasswordTextField;
	@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddressCell-UITableViewCell") public IOSElement IHRAuthorizationViewEmailAddressCell;
	@iOSFindBy(accessibility = "IHRAuthorizationView-PasswordCell-UITableViewCell")     public IOSElement IHRAuthorizationViewPasswordCell;
	@iOSFindBy(accessibility = "IHRAuthorizationView-LogInAuthButton-UIButton")  public IOSElement IHRAuthorizationViewLogInAuthButtonUIButton;
	@iOSFindBy(accessibility = "IHRAuthorizationView-OrConnectWithLabel-UILabel") public IOSElement IHRAuthorizationViewOrConnectWithLabelUILabel;
	@iOSFindBy(accessibility = "IHRAuthorizationView-SocialContainer-UIView") public IOSElement IHRAuthorizationViewSocialContainerUIView;
	@iOSFindBy(accessibility = "IHRAuthorizationView-FacebookButton-UIButton") public IOSElement IHRAuthorizationViewFacebookButtonUIButton;
	@iOSFindBy(accessibility = "IHRAuthorizationView-GoogleButton-UIButton")   public IOSElement IHRAuthorizationViewGoogleButtonUIButton;
	@iOSFindBy(accessibility = "IHRAuthorizationView-ForgotPasswordButton-UIButton") public IOSElement IHRAuthorizationViewForgotPasswordButtonUIButton;
	@iOSFindBy(accessibility = "NavBarBackButton") public IOSElement NavBarBackButton;

	//old xpath
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]") public IOSElement userName;
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]/UIATextField[1]") public IOSElement userName;
	
	//old xpath
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]") public IOSElement password;
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]/UIASecureTextField[1]") public IOSElement password;
	
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") public IOSElement logInFormButton;
//	@iOSFindBy(accessibility = "Back") public IOSElement backButton;
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]") public IOSElement backButton;
	@iOSFindBy(accessibility = "Facebook") private WebElement facebookButton;

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

	@iOSFindBy(accessibility = "Google") private WebElement googleButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement googleEmail;
	@iOSFindBy(accessibility = "Next") private WebElement nextButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private WebElement googlePassword;
	@iOSFindBy(accessibility = "Sign in") private WebElement signIn;
	// for first-timer
	@iOSFindBy(accessibility = "Continue") private WebElement continueButton; // for first-time login user
	@iOSFindBy(accessibility = "Allow") private WebElement allowButton;

	// for verification: Maybe shall move nav bar stuff up to the Page.java?
	//@iOSFindBy(accessibility = "For You")
	//private WebElement forYou;

	public LoginPage() {
		super();
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public LoginPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
		IHRAuthorizationViewEmailAddressTextField.click();
		if(emailAddress!= null){
			IHRAuthorizationViewEmailAddressTextField.sendKeys(emailAddress);
		}
		else IHRAuthorizationViewEmailAddressTextField.sendKeys(IHEARTUSERNAME);
	
	}
	
	/**
	 * If String password is null, it will use default system property password. 
	 * @param password
	 */
	public void enterLoginPassword(String password){
		IHRAuthorizationViewPasswordTextField.click();
		if(password!= null){
			IHRAuthorizationViewPasswordTextField.sendKeys(password);
		}
		else IHRAuthorizationViewPasswordTextField.sendKeys(IHEARTPASSWORD);
	}
	/**
	 * Click Facebook Login Button
	 */
	public void clickFacebookLoginButton(){
		IHRAuthorizationViewFacebookButtonUIButton.click();
	}
	
	/**
	 * Click Google Login Button
	 */
	public void clickGoogleLoginButton(){
		IHRAuthorizationViewGoogleButtonUIButton.click();
	}
	/**
	 * Click the regular Log In Auth Button. This will only appear once text has been entered into the Email Address and Password text fields above it. 
	 */
	public void clickLogInAuthButton(){
		IHRAuthorizationViewLogInAuthButtonUIButton.click();
	}
	
	/**
	 * Click the Forgot your Password? button to reset your account's password. 
	 */
	public void clickForgotYourPasswordButton(){
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
		splashPage.clickLogIn();
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

	public String stringifyElementInformation(IOSElement iosElement){
		return "TagName=["+iosElement.getTagName()+ "] Text=["+ iosElement.getText() + "] Object:"  + iosElement.toString() ;
	}
	
	public void printElementInformation(IOSElement iosElement){
		System.out.println("Text=["+ iosElement.getText() + "]  TagName=["+iosElement.getTagName()+ "]  ||||||  Object:"  + iosElement.toString()) ;
	}
	
	public boolean checkValuesOfElements(){
		splashPage.clickLogIn();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 5);
		printElementInformation(IHRAuthorizationViewEmailAddressTextField);
		printElementInformation(IHRAuthorizationViewPasswordTextField);
		printElementInformation(IHRAuthorizationViewEmailAddressCell);
		printElementInformation(IHRAuthorizationViewPasswordCell);
		printElementInformation(IHRAuthorizationViewLogInAuthButtonUIButton);
		printElementInformation(IHRAuthorizationViewOrConnectWithLabelUILabel);
		printElementInformation(IHRAuthorizationViewSocialContainerUIView);
		printElementInformation(IHRAuthorizationViewFacebookButtonUIButton);
		printElementInformation(IHRAuthorizationViewGoogleButtonUIButton);
		printElementInformation(IHRAuthorizationViewForgotPasswordButtonUIButton);
		printElementInformation(NavBarBackButton);

		enterLoginEmailAddress("test66@gmail.com");
		enterLoginPassword("test");

		sleep(5000);
		clickLogInAuthButton();
		chooseStayConnected(false);
		sleep(5000);
		if(HomePage.forYouTab.isDisplayed()){
			System.out.println("For You Tab on Home is displayed- Log In worked!");
			return true;
		}
		return false;
	}
	public boolean loginViaFacebook() {
		splashPage.clickLogIn();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 5);
		clickFacebookLoginButton();
		
		//Sleep to allow web to display, can't wait because context needs to switch
		TestRoot.sleep(10000);
		System.out.println("Current context: " + driver.getContext());
		if(switchToWebContext()){
			System.out.println("Current context: " + driver.getContext());
//			driver.findElement(By.name("email")).sendKeys(FACEBOOK_USER_NAME); // iheartrocks999@gmail.com
//			driver.findElement(By.name("pass")).sendKeys(FACEBOOK_PASSWORD); // iheart001
//			driver.findElement(By.name("login")).click();
			// Facebook changed their page
			IOSElement fbemailField = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]"));
			IOSElement fbpasswordField = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]"));
			IOSElement fbloginButton = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]"));
			if(fbemailField == null){
				fbemailField = findElement(driver, By.name("email"));
			}
			if(fbpasswordField == null){
				fbpasswordField = findElement(driver, By.name("pass"));
			}
			if(fbloginButton == null){
				fbloginButton = findElement(driver, By.name("login"));
			}
			
			if(fbemailField != null && fbpasswordField != null && fbloginButton != null){
				fbemailField.sendKeys(FACEBOOKUSERNAME);
				fbpasswordField.sendKeys(FACEBOOKPASSWORD);
				fbloginButton.click();
				System.out.println("Testing Facebook login. Entered FB Email, Password, and Clicked Login.");
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
		splashPage.clickLogIn();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 5);
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
	
	public void tapBack(){
		NavBarBackButton.click();
	}

}
