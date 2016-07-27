package com.iheart.appium.iosAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends Page {

	
	//@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddress-TextField") public IOSElement IHRAuthorizationViewEmailAddressTextField;
	//@iOSFindBy(accessibility = "IHRAuthorizationView-Password-TextField")     public IOSElement IHRAuthorizationViewPasswordTextField;
	@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddressCell-UITableViewCell") public IOSElement IHRAuthorizationViewEmailAddressCell;
	@iOSFindBy(accessibility = "IHRAuthorizationView-PasswordCell-UITableViewCell")     public IOSElement IHRAuthorizationViewPasswordCell;
	//@iOSFindBy(accessibility = "IHRAuthorizationView-LogInAuthButton-UIButton")  public IOSElement IHRAuthorizationViewLogInAuthButtonUIButton;
	@iOSFindBy(accessibility = "IHRAuthorizationView-OrConnectWithLabel-UILabel") public IOSElement IHRAuthorizationViewOrConnectWithLabelUILabel;
	@iOSFindBy(accessibility = "IHRAuthorizationView-SocialContainer-UIView") public IOSElement IHRAuthorizationViewSocialContainerUIView;
	
	//Commented out 6.5.0 for 6.4.1
	//@iOSFindBy(accessibility = "IHRAuthorizationView-FacebookButton-UIButton") public static IOSElement IHRAuthorizationViewFacebookButtonUIButton;
	//@iOSFindBy(accessibility = "IHRAuthorizationView-GoogleButton-UIButton")   public static IOSElement IHRAuthorizationViewGoogleButtonUIButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[4]") public static IOSElement IHRAuthorizationViewFacebookButtonUIButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")  public static IOSElement IHRAuthorizationViewGoogleButtonUIButton;

	@iOSFindBy(accessibility = "IHRAuthorizationView-ForgotPasswordButton-UIButton") public IOSElement IHRAuthorizationViewForgotPasswordButtonUIButton;
	//@iOSFindBy(accessibility = "NavBarBackButton") public IOSElement NavBarBackButton;

	//cut and pasted
	public final String logInButtonName = "Log In";
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") private IOSElement IHRAuthorizationViewLogInAuthButtonUIButton;
	
	//commented out 6.5.0
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]") public IOSElement IHRAuthorizationViewEmailAddressTextField;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]") public static IOSElement IHRAuthorizationViewEmailAddressTextField;
	
	//commented out 6.5.0
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]") public IOSElement IHRAuthorizationViewPasswordTextField;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]") public IOSElement IHRAuthorizationViewPasswordTextField;
	
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") public IOSElement logInFormButton;
	@iOSFindBy(id = "Back") public IOSElement NavBarBackButton;
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]") public IOSElement NavBarBackButton;
	@iOSFindBy(accessibility = "Facebook") private WebElement facebookButton;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement fbEmail;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private IOSElement fbPassword;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]") private IOSElement fbLogin;

	// WEB version
	@FindBy(name="email") public static WebElement facebookEmail_web;
	@FindBy(name="pass") public static WebElement facebookPassword_web;
	@FindBy(name="login") public static WebElement facebookLogin;		
	@FindBy(name="__CONFIRM__") public WebElement confirmBtn;	
	
	// Native version

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement facebookEmail_native;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private WebElement facebookPassword_native;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]") private WebElement FBlogin_native;

	@iOSFindBy(accessibility = "Google") private WebElement googleButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") public static IOSElement txtEmail;

	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") private WebElement googleEmail;
	@iOSFindBy(id = "Next") private WebElement nextButton;
	//@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]") private static WebElement googlePassword;
	@iOSFindBy(accessibility = "Sign in") private WebElement signIn;
	// for first-timer
	@iOSFindBy(accessibility = "Continue") private WebElement continueButton; // for first-time login user
	//@iOSFindBy(accessibility = "Allow") private WebElement allowButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]") private WebElement allowButton;


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
	public static void clickFacebookLoginButton(){
		IHRAuthorizationViewFacebookButtonUIButton.click();
	}
	
	/**
	 * Click Google Login Button
	 */
	public static void clickGoogleLoginButton(){
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

		splashPage.clickLogIn();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 2);
		enterLoginEmailAddress(IHEARTUSERNAME);
		enterLoginPassword(IHEARTPASSWORD);
		clickLogInAuthButton();
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
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 3);
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
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 4);
		clickFacebookLoginButton();
		
		//Sleep to allow web to display, can't wait because context needs to switch
		TestRoot.sleep(5000);
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
			
			TestRoot.sleep(8000);
			
			try{
				findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]")).click();
				//driver.findElement(By.id("__CONFIRM__")).click();
			}
			catch(Exception e){e.printStackTrace();}
		
		// Now switch to native view
		if(!switchToNativeContext()){
			System.err.println("Could not switch back to native context!");
		}
		dismissLoginPopups();
		try{
			genrePage.selectGenre(1);
		}catch(Exception e){} // This doesn't always display
		dismissLoginPopups();

		// check status
		return settings.isLoggedIn();
	}
	
	private static void dismissLoginPopups(){
		
		handlePossiblePopUp();
		handleWantYourLocalRadioPopup();
		tellUsWhatYouLike();
		dismissStayConnectedPopup();

	}
	
	private static void handleWantYourLocalRadioPopup() {

		try {
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]")).click();
		} catch (Exception e) {

		}

	}
		    	 	

	public boolean loginViaGoogle() {
		splashPage.clickLogIn();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 2);
		clickGoogleLoginButton();
		System.out.println("pwd entered");

		//if(switchToWebContext()){
		sleep(8000);
		
		if (driver.getContextHandles().size() > 1)
			driver.context("WEBVIEW_1");
		
		sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Email")));
		txtEmail.sendKeys(GOOGLEUSERNAME);
		System.out.println(driver.getContext() +"  1");
		sleep(5000);

		WebElement btnNext = driver.findElement(By.id("next"));
		btnNext.click();
		System.out.println(driver.getContext() +"  1");
		sleep(5000);

		WebDriverWait waitFor = new WebDriverWait(driver,5);
		WebElement txtPasswd = waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
		txtPasswd.sendKeys(GOOGLEPASSWORD);
		txtPasswd.submit();
		System.out.println(driver.getContext() +"  1");
		sleep(5000);

		
		WebDriverWait waitAl = new WebDriverWait(driver,5);
		WebElement btnAllow = waitAl.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")));
		btnAllow.click();
		//allowButton.click();
		sleep(8000);
		//driver.findElement(By.id("Allow")).click();
		//} catch (Exception e) {
			//}
			sleep(8000);
		
		/**
		 * Verify login name shows under Options
		 */
		sleep(5000);

		

			// Try to go back to iHeart (iOS 9 only button click)
			findElement(driver, By.name("Back to iHeartRadio")).click();
			if(switchToNativeContext()){
				dismissLoginPopups();
			}
			else{
				System.err.println("Could not switch back to native context after Google login!");
			}
		//}
		//else{
			//System.err.println("Could not switch context for Google Login");
			//return false;
			System.out.println("Google Login Done");

		return settings.isLoggedIn();
	}
			
			
	public static void dismissStayConnectedPopup() {
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
	public static void tellUsWhatYouLike() {
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
