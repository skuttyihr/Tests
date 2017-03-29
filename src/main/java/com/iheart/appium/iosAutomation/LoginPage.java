package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iheart.appium.iosAutomation.AppboyUpsellsPage.Entitlement;
import com.iheart.appium.utilities.TestRoot;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * LoginPage refactored by Travis Statham on 7/2016 AccessibilityIdentifiers
 * added to ios-flagship master so we can click and access them easily. Methods
 * added to mutate all private IOSElements loginPage is reached by using
 * onboardingPage.clickOnboardingLoginButton()
 * 
 * @author travisstatham
 *
 */
public class LoginPage extends Page {

	// Nav Bar Elements
	@iOSFindBy(accessibility = "NavBar-BackButton-UIButton")
	private IOSElement NavBarBackButton;
	// updated xpath for LoginPage Navbar xpath
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeNavigationBar/"
			+ "XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
	private IOSElement NavBarTitle;
	// Main container contains Email, Password, Log In and Forgot your password?
	@iOSFindBy(accessibility = "IHRiPhoneLoginView-MainContainer-UIView")
	private IOSElement IHRiPhoneLoginViewMainContainerUIView;
	// TableView contains Email and Password Cells and their TextFields
	@iOSFindBy(accessibility = "IHRAuthorizationView-TableView-UITableView")
	private IOSElement IHRAuthorizationViewTableViewUITableView;
	@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddress-UITableViewCell")
	private IOSElement IHRAuthorizationViewEmailAddressCell;
	@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddress-TextField")
	private IOSElement IHRAuthorizationViewEmailAddressTextField;
	@iOSFindBy(accessibility = "IHRAuthorizationView-PasswordCell-UITableViewCell")
	private IOSElement IHRAuthorizationViewPasswordCell;
	@iOSFindBy(accessibility = "IHRAuthorizationView-Password-TextField")
	private IOSElement IHRAuthorizationViewPasswordTextField;
	@iOSFindBy(accessibility = "IHRAuthorizationView-LogInAuthButton-UIButton")
	private IOSElement IHRAuthorizationViewLogInAuthButtonUIButton;
	@iOSFindBy(accessibility = "IHRAuthorizationView-ForgotPasswordButton-UIButton")
	private IOSElement IHRAuthorizationViewForgotPasswordButtonUIButton;
	// OrConnectWith container just contains a label
	@iOSFindBy(accessibility = "IHRAuthorizationView-OrConnectWithContainer-UIView")
	private IOSElement IHRAuthorizationViewOrConnectWithContainerUIView;
	@iOSFindBy(accessibility = "IHRAuthorizationView-OrConnectWithLabel-UILabel")
	private IOSElement IHRAuthorizationViewOrConnectWithLabelUILabel;
	// SocialContainer UIView contains the Facebook and Google Log In Buttons
	@iOSFindBy(accessibility = "IHRAuthorizationView-SocialContainer-UIView")
	private IOSElement IHRAuthorizationViewSocialContainerUIView;
	@iOSFindBy(accessibility = "IHRAuthorizationView-FacebookButton-UIButton")
	private IOSElement IHRAuthorizationViewFacebookButtonUIButton;
	@iOSFindBy(accessibility = "IHRAuthorizationView-GoogleButton-UIButton")
	private IOSElement IHRAuthorizationViewGoogleButtonUIButton;
	@iOSFindBy(accessibility = "Open") private IOSElement openButton;

	// Web Elements for Facebook Login
	@iOSFindBy(accessibility = "Email or Phone")
	private WebElement fbEmailField;
	@iOSFindBy(accessibility = "Facebook Password")
	private WebElement fbPasswordField;
	@iOSFindBy(accessibility = "Log In")
	private WebElement fbLogInField;

	// WEB version
	@FindBy(name = "email")
	private WebElement facebookEmail_web;
	@FindBy(name = "pass")
	private WebElement facebookPass_web;
	@FindBy(name = "login")
	private WebElement facebookLogin;

	// Native version
	@iOSFindBy(className = "XCUIElementTypeTextField") private IOSElement fbemailField;
	@iOSFindBy(className = "XCUIElementTypeSecureTextField") private IOSElement fbpasswordField;
	@iOSFindBy(id = "Log In") private IOSElement fbloginButton;
	@iOSFindBy(id = "OK") private IOSElement btnAuthorize;
	
	//sk - 2/6/17
	@iOSFindBy(className = "XCUIElementTypeTextField") private IOSElement txtEmail;
	@iOSFindBy(id = "NEXT") private IOSElement btnNext;
	@iOSFindBy(className = "XCUIElementTypeSecureTextField") private IOSElement txtPasswd;
	@iOSFindBy(id = "SIGN IN") private IOSElement btnSubmit;
	@iOSFindBy(id = "ALLOW") private IOSElement btnAllow;
	@iOSFindBy(accessibility = "Open this page in “iHeartRadio”?") private IOSElement openInAppPrompt;


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
	 * If String emailAddress is null, it will use default system property email
	 * address.
	 * 
	 * @param emailAddress
	 */
	public void enterLoginEmailAddress(String emailAddress) {

		waitAndClick(IHRAuthorizationViewEmailAddressTextField, 5, "");
		if (emailAddress != null) {
			System.out.println("enterLoginEmailAddress()");
			IHRAuthorizationViewEmailAddressTextField.sendKeys(emailAddress);
		} else {
			System.out.println("enterLoginEmailAddress() : " + IHEARTUSERNAME);
			IHRAuthorizationViewEmailAddressTextField.sendKeys(IHEARTUSERNAME);
		}
	}

	public void clearLoginEmailAddress() {
		System.out.println("clearLoginEmailAddress()");
		IHRAuthorizationViewEmailAddressTextField.clear();
	}

	/**
	 * If String password is null, it will use default system property password.
	 * 
	 * @param password
	 */
	public void enterLoginPassword(String password) {

		IHRAuthorizationViewPasswordTextField.click();
		if (password != null) {
			System.out.println("enterLoginPassword()");
			IHRAuthorizationViewPasswordTextField.sendKeys(password);
		} else {
			System.out.println("enterLoginPassword() : " + IHEARTPASSWORD);
			IHRAuthorizationViewPasswordTextField.sendKeys(IHEARTPASSWORD);
		}
	}

	public void clearLoginPassword() {
		System.out.println("clearLoginPassword()");
		IHRAuthorizationViewPasswordTextField.clear();
	}

	/**
	 * Click Facebook Login Button
	 */
	public void clickFacebookLoginButton() {
		System.out.println("clickFacebookLoginButton()");
		IHRAuthorizationViewFacebookButtonUIButton.click();
	}

	/**
	 * Click Google Login Button
	 */
	public void clickGoogleLoginButton() {
		System.out.println("clickGoogleLoginButton()");
		IHRAuthorizationViewGoogleButtonUIButton.click();
	}

	/**
	 * Click the regular Log In Auth Button. This will only appear once text has
	 * been entered into the Email Address and Password text fields above it.
	 */
	public void clickLogInAuthButton() {
		System.out.println("clickLogInAuthButton()");
		IHRAuthorizationViewLogInAuthButtonUIButton.click();
	}

	/**
	 * Click the Forgot your Password? button to reset your account's password.
	 */
	public void clickForgotYourPasswordButton() {
		System.out.println("clickForgotYourPasswordButton()");
		IHRAuthorizationViewForgotPasswordButtonUIButton.click();
	}

	/**
	 * Logs in without checking settings.isLoggedIn(). Enters userName and
	 * password and clicks Log in. Minimizes player, handles pop-ups. Selects
	 * Alternative genre.
	 */
	//sk - 2/8 - commented out a few print to console statements - can readd for regression
	public void loginWithCredentials(String email, String password) {
		//System.out.println("about to loginWithCredentials(email, password)...");
		onboardingPage.clickOnboardingLoginButton();
		waitForElementToBeVisible(IHRAuthorizationViewEmailAddressTextField, 5);
		enterLoginEmailAddress(email);
		enterLoginPassword(password);
		//System.out.println("Sent keys for Username and Password and about to click LogInAuthButton");
		clickLogInAuthButton();
		chooseStayConnected(false);
		// Dismiss zip code
		Page.enterZip("");
		// Dismiss stay connected popup
		Page.handlePossiblePopUp();
		System.out.println("Dismissed Zip code and handled possible popups.");
		// Select Genre
		int[] genres = new int[] {1, 2} ;
		if (genrePage.isCurrentlyOnGenrePage()){
			//removed the println, cause the above method prints it out as well.
			if(!genrePage.isDoneButtonEnabled()){
				genrePage.selectGenres(genres);
				genrePage.clickDoneButton();
			}else{
				genrePage.clickDoneButton();
			}
		}
		// Dismiss stay connected popup that sometimes shows up AFTER genre picker
		chooseStayConnected(false);
		sleep(2000);
		Page.handlePossiblePopUp();  //added after genre screen sometimes pops up again. 
		System.out.println("Logged in to account.");
	}

	/**
	 * Checks all the Values of the IOSElements, prints them to the console,
	 * fills in email address and password and logs in and verifies Homepage
	 * access.
	 * 
	 * @return
	 */
	public boolean checkValuesOfElements() {
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
		if (homePage.isCurrentlyOnHomePage()) {
			System.out.println("For You Tab on Home is displayed- Log In worked!");
			return true;
		}
		return false;
	}

	/**
	 * Logs into a Facebook account. May fail if Facebook removes access from
	 * the account, which tends to happen after two or more successive tests. 
	 * 
	 * @return
	 */
	public boolean loginViaFacebook() {
		onboardingPage.clickOnboardingLoginButton();
		waitForVisible(driver, By.className("XCUIElementTypeTextField"), 10);
		clickFacebookLoginButton();
		System.out.println("Testing Facebook login.");
		// adding in wait
		if (waitForElementToBeVisible(fbemailField, 5)){
			fbemailField.sendKeys(FACEBOOKUSERNAME);
			System.out.println("Entered Facebook Email");
		}
		if(waitForElementToBeVisible(fbpasswordField, 5)){
			fbpasswordField.sendKeys(FACEBOOKPASSWORD);
			System.out.println("Entered Facebook Password");
		}
		if(waitForElementToBeVisible(fbloginButton, 5)){
			fbloginButton.click();
			System.out.println("Clicked Facebook Login");
		}
		//System.out.println("If Test Ends right here, it means that Facebook has blocked access to this account, the test will probably run again tomorrow");
		if (waitForElementToBeVisible(btnAuthorize,3))
			btnAuthorize.click();
		dismissLoginPopups();
		// check status
		return settingsPage.isLoggedIn();
	}

	/**
	 * Dismisses the possible popups that appear once you've logged in.
	 */
	void dismissLoginPopups() {
		handlePossiblePopUp();
		//handleWantYourLocalRadioPopup();
		tellUsWhatYouLike();
		dismissStayConnectedPopup();
	}

	public boolean loginViaGoogle() {
		onboardingPage.clickOnboardingLoginButton();
		clickGoogleLoginButton();
		if (waitForElementToBeVisible(txtEmail, 2)) {
			System.out.println("Google email field is displayed");
			txtEmail.tap(1, 20);
			txtEmail.sendKeys(GOOGLEUSERNAME);
		}
		if (waitForElementToBeVisible(btnNext, 4))
			btnNext.click();
		if (waitForElementToBeVisible(txtPasswd, 8))
			txtPasswd.sendKeys(GOOGLEPASSWORD);
		if (waitForElementToBeVisible(btnNext, 2))
			btnNext.click();
		if (waitForElementToBeVisible(btnAllow, 2))
			btnAllow.click();
		if (waitForElementToBeVisible(openInAppPrompt, 5))
			openButton.click();
		dismissStayConnectedPopup();
		dismissLoginPopups();
		return settingsPage.isLoggedIn();
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

	public boolean isCurrentlyOnLoginPage() {
		return isCurrentlyOn("isCurrentlyOnLoginPage()", IHRAuthorizationViewForgotPasswordButtonUIButton);
	}

	public void tapBack() {
		//System.out.println("Hitting 'Back' from LoginPage to go back to OnboardingPage");
		NavBarBackButton.click();
	}

	public boolean loginVerifyEntitlement(String email, String password, Entitlement entitlement) {
		System.out.println("loginVerifyEntitlement()...");
		boolean loggedIn = false;
		boolean doesEntitlementMatch = false;
		// Log in
		loginWithCredentials(email, password);
		// verify we are in
		if(homePage.isCurrentlyOnForYouTab()){
			loggedIn = true;
		}
		if(entitlement.equals(Entitlement.PLUS)){
			doesEntitlementMatch = homePage.isCurrentlyOnPlusAccountLogo();
		}else if(entitlement.equals(Entitlement.ALLA)){
			doesEntitlementMatch = homePage.isCurrentlyOnAllAccessAccountLogo();
		}else if(entitlement.equals(Entitlement.FREE)){
			doesEntitlementMatch = homePage.isCurrentlyOnFreeAccountLogo();
		}
		return loggedIn && doesEntitlementMatch;
		
	}

}
