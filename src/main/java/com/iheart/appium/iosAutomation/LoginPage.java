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
		System.out.println("about to loginWithoutVerifying()");
		splashPage.clickLogIn();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 2);
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
/*	
	public static boolean loginViaFacebook()
	{  
		 splashPage.clickLogIn();
		 waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 2);
		 clickFacebookLoginButton();
		 
		//Sleep to allow web to display, can't wait because context needs to switch
		TestRoot.sleep(3000);
		System.out.println("Current context: " + driver.getContext());
		//if(switchToWebContext()){
		switchToWebContext();
		System.out.println("Current context: " + driver.getContext());
		facebookEmail_web.sendKeys(FACEBOOKUSERNAME);
		switchToWebContext();
		facebookPassword_web.sendKeys(FACEBOOKPASSWORD );
		switchToWebContext();
		System.out.println("Current context: " + driver.getContext());
		switchToWebContext();
		facebookLogin.click();  
		sleep(2000);
		System.out.println("Current context: " + driver.getContext());

		// Handle Authorization confirm
		try{
			driver.findElement(By.name("__CONFIRM__")).click();
		}
		catch(Exception e){}
		
	
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
	
}*/
	public boolean loginViaFacebook() {
		splashPage.clickLogIn();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 4);
		clickFacebookLoginButton();
		
		//Sleep to allow web to display, can't wait because context needs to switch
		TestRoot.sleep(5000);
		//if(switchToWebContext()){
			System.out.println("Current context: " + driver.getContext());
			//driver.findElement(By.name("email")).sendKeys(FACEBOOK_USER_NAME); // iheartrocks999@gmail.com
			//driver.findElement(By.name("pass")).sendKeys(FACEBOOK_PASSWORD); // iheart001
			//driver.findElement(By.name("login")).click();
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
			
			System.out.println(driver.getPageSource());
			if(fbemailField != null && fbpasswordField != null && fbloginButton != null){
				fbemailField.sendKeys(FACEBOOKUSERNAME);
				fbpasswordField.sendKeys(FACEBOOKPASSWORD);
				fbloginButton.click();
				System.out.println("Testing Facebook login. Entered FB Email, Password, and Clicked Login.");
			}
			sleep(3000);

			//while (!switchToWebContext())
				//switchToWebContext();
			//sleep(1000);
			System.out.println("Current context: " + driver.getContext());
			// Handle Authorization confirm
			TestRoot.sleep(5000);
			//while (!switchToWebContext()){
				//switchToWebContext();
			//}

			try{
				System.out.println(driver.getPageSource());
				sleep(3000);

				//driver.context("");
				System.out.println(driver.getContext());
				findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]")).click();
				//IOSElement dr = findElement(driver, By.name("__CONFIRM__"));
				//dr.click();
				//driver.findElement(By.id("__CONFIRM__")).click();
			}
			catch(Exception e){e.printStackTrace();}
		//}
		//else{
			//System.err.println("Could not switch to Facebook web view context.");
			//return false;
		//}
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
	
	private static void dismissLoginPopups(){
		
		System.out.println("at popup 1");
		handlePossiblePopUp();
		System.out.println("at popup 2");
		handleWantYourLocalRadioPopup();
		System.out.println("at popup 3");
		tellUsWhatYouLike();
		System.out.println("at popup 4");
		dismissStayConnectedPopup();
		System.out.println("at popup 5");

	}
	private static void handleWantYourLocalRadioPopup() {

		try {
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]")).click();
		} catch (Exception e) {

		}

	}

	//Sree - 6.4.1
 /*public boolean loginViaGoogle() {
		
		//Begin Login from iHR app
			splashPage.clickLogIn();
			
			
			 * Enter google+ login credentials
			 
			waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 5);
			clickGoogleLoginButton();
			TestRoot.sleep(5000);
			System.out.println("enter data"+ driver.getContext());
try{
			IOSElement googleEmail = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]"));
			System.out.println("easfnter data"+ driver.getContext());

			IOSElement googleNext = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]"));
			System.out.println("enter data"+ driver.getContext());
			driver.context("WEBVIEW_1");
			WebDriverWait wait = new WebDriverWait(driver,5);
			googleEmail = (IOSElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Email")));
			System.out.println("232");

			googleEmail.sendKeys(GOOGLEUSERNAME);
			System.out.println(232);
			if(switchToWebContext()){
				
				sleep(1000);
				System.out.println("back");
				WebDriverWait waitdr = new WebDriverWait(driver,5);
				googleEmail = (IOSElement) waitdr.until(ExpectedConditions.visibilityOfElementLocated(By.name("Email")));
				googleEmail.sendKeys(GOOGLEUSERNAME);
				WebElement btnNext = driver.findElement(By.id("next"));
				btnNext.click();
				
				WebElement googlePassword = findElement(driver, By.xpath("/UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]"));
				WebDriverWait waitFor = new WebDriverWait(driver,5);
				googlePassword = waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
				googlePassword.sendKeys(GOOGLEPASSWORD);
				googlePassword.submit();
				sleep(500);
				
			}
			else
				((WebElement) googleEmail).sendKeys("simtestph@gmail.com");
			System.out.println("srent");

			googleNext.click();
			System.out.println("12");

			sleep(4000);
			IOSElement googlePassword = findElement(driver, By.xpath("/UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]"));
			System.out.println("13");

			driver.getPageSource();
			googlePassword.sendKeys(GOOGLEPASSWORD);
			googlePassword.submit();
			sleep(500);
			System.out.println("15");
			
}
catch(Exception e)
{
	e.printStackTrace();
}			
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("window.scrollTo(0,0)"); 
			int i = 0;
			do
			{
					i++;
					js = (JavascriptExecutor) driver; 
					js.executeScript("window.scrollBy(0, 200)");

				
			} while(i<=2);
			
			 driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")).click();
				System.out.println("16 - after Allow");
				dismissLoginPopups();
			 return settings.isLoggedIn();
			
	}		*/				    	 	

	public boolean loginViaGoogle() {
		splashPage.clickLogIn();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 2);
		clickGoogleLoginButton();
		System.out.println("pwd entered");

		//if(switchToWebContext()){
		sleep(8000);
		
		System.out.println(driver.getContextHandles().size());

		if (driver.getContextHandles().size() > 1)
			driver.context("WEBVIEW_1");
		
		System.out.println(driver.getContext() +"   1");

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

		
		/*JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollTo(0,0)"); 
		int i = 0;
		do
		{
				i++;
				js = (JavascriptExecutor) driver; 
				js.executeScript("window.scrollBy(0, 200)");
				System.out.println(driver.getContext() +"  2");


			
		} while(i<=2);*/
		
		/**
		 * Verify login name shows under Options
		 */
		System.out.println(driver.getContext() +"  3");

		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")).click();
		//sleep(1800);
		
		//System.out.println(driver.getContext() +"  4");


		//dismissLoginPopups();

		//System.out.println("dismissed pops");
			//try {
		//switchToNativeContext();
		sleep(5000);

		WebDriverWait waitAl = new WebDriverWait(driver,5);
		WebElement btnAllow = waitAl.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")));
		btnAllow.click();
		//allowButton.click();
		System.out.println(driver.getContext() +"  4");
		sleep(8000);
		//driver.findElement(By.id("Allow")).click();
		//} catch (Exception e) {
			//}
			sleep(8000);
			System.out.println(driver.getContext() +"  4");

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
