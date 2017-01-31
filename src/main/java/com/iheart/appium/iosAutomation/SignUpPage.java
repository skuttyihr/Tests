package com.iheart.appium.iosAutomation;

import java.util.Date;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.ios.*;
/**
 * SignUpPage refactored by Travis Statham to use AccessibilityIdentifers that are now in ios-flagship master.
 * Elements listed in order as they are shown in app.
 * Methods added to mutate all private IOSElements
 * This page is reached by going through onboardingPage.clickOnCreateAccountButton()
 * @author travisstatham
 *
 */
public class SignUpPage extends Page {

	//The following elements are located on the SignUpPage - Also known as the Create Account view. They are represented as nested, in linear order. 
	//NavBar at top of page. 
	@iOSFindBy(accessibility ="NavBar-BackButton-UIButton") private IOSElement NavBarBackButton;
	
	//@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[2]") private IOSElement NavBarTitleCreateAccount;
	//Main Container with Table View and Agreement Container
	@iOSFindBy(accessibility = "IHRiPhoneSignUpView-mainContainer-UIView") private IOSElement IHRSignUpViewMainContainerUIView;
		//Table View with Email Address, Password, Zip Code, Birth Year, and Gender buttons. 
		@iOSFindBy(accessibility = "IHRAuthorizationView-TableView-UITableView") private IOSElement IHRAuthorizationViewTableViewUITableView;
			//Email And Password TextFields
			@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddress-UITableViewCell") private IOSElement IHRAuthorizationViewEmailAddressUITableViewCell;
				@iOSFindBy(accessibility = "IHRAuthorizationView-EmailAddress-TextField") private IOSElement IHRAuthorizationViewEmailAddressTextField;
			@iOSFindBy(accessibility = "IHRAuthorizationView-PasswordCell-UITableViewCell") private IOSElement IHRAuthorizationViewPasswordCellUITableViewCell;
				@iOSFindBy(accessibility = "IHRAuthorizationView-Password-TextField") private IOSElement IHRAuthorizationViewPasswordTextField;
			//Zip and Birth Cell [Zip Text Field, Birth Year Text Field ]
			@iOSFindBy(accessibility = "IHRiPhoneSignUpView-zipAndBirthCell-UITableViewCell") private IOSElement IHRiPhoneSignUpViewZipAndBirthCellUITableViewCell;
				@iOSFindBy(accessibility = "IHRiPhoneSignUpView-zipCodeTextField-UITextfield") private IOSElement IHRiPhoneSignUpViewZipCodeTextFieldUITextField;
				@iOSFindBy(accessibility = "IHRiPhoneSignUpView-birthYearTextField-UITextfield") private IOSElement IHRiPhoneSignUpViewBirthYearTextFieldUITextField;
			//Gender Cell [ Gender Label, Male Button, Female Button ]
			@iOSFindBy(accessibility = "IHRiPhoneSignUpView-genderCell-UITableViewCell") private IOSElement IHRiPhoneSignUpViewGenderCellUITableViewCell;
				@iOSFindBy(accessibility = "IHRiPhoneSignUpView-genderLabel-UILabel") private IOSElement IHRiPhoneSignUpViewGenderLabelUILabel;
				//These don't have objects that accessibilityIdentifer can be added to. 
				@iOSFindBy(accessibility = "Male") private IOSElement IHRiPhoneSignUpViewMaleButtonUIButton;
				@iOSFindBy(accessibility = "Female") private IOSElement IHRiPhoneSignUpViewFemaleButtonUIButton;
		//UI View  with Agreement Container
		@iOSFindBy(accessibility = "IHRiPhoneSignUpView-agreementContainer-UIView") private IOSElement IHRiPhoneSignUpViewAgreementContainerUIView;
			@iOSFindBy(accessibility = "IHRiPhoneSignUpView-iAgreeToTheTermsLabel-UILabel") private IOSElement IHRiPhoneSignUpViewIAgreeToTheTermsLabelUILabel; 
			@iOSFindBy(accessibility = "IHRiPhoneSignUpView-termsOfServiceButton-UIButton") private IOSElement IHRiPhoneSignUpViewTermsOfServiceButtonUIButton; 
			@iOSFindBy(accessibility = "IHRiPhoneSignUpView-andLabel-UILabel") private IOSElement IHRiPhoneSignUpViewAndLabelUILabel; 
			@iOSFindBy(accessibility = "IHRiPhoneSignUpView-privacyPolicyButton-UIButton") private IOSElement IHRiPhoneSignUpViewPrivacyPolicyButtonUIButton;
		//LogInAuthButton / Create Account Button is only visible after the Table View elements are filled out. 
		@iOSFindBy(accessibility = "IHRAuthorizationView-LogInAuthButton-UIButton") private IOSElement IHRAuthorizationViewLogInAuthButtonUIButton;
	//Or Connect With Container with Facebook and Google Buttons		
	@iOSFindBy(accessibility = "IHRAuthorizationView-OrConnectWithContainer-UIView") private IOSElement IHRAuthorizationViewOrConnectWithContainerUIView;
	
		@iOSFindBy(accessibility = "IHRAuthorizationView-FacebookButton-UIButton") private IOSElement IHRAuthorizationViewFacebookButtonUIButton;
		@iOSFindBy(accessibility = "IHRAuthorizationView-GoogleButton-UIButton") private IOSElement IHRAuthorizationViewGoogleButtonUIButton;
	
	@iOSFindBy(accessibility = "Okay") private IOSElement AccountExistsAlreadyOkayButton;
	
	//New Methods:
	
		/**
		 * Enter Email Address to Create Account, if parameter is null, creates a new random mailinator email, otherwise uses String input.
		 * @param email
		 */
	public void enterNewAccountEmailAddress(String email){
		System.out.println("enterNewAccountEmailAddress()");
		IHRAuthorizationViewEmailAddressTextField.click();
		if(email == null){
			// Generate a random email
			String _email = getCurrentDateInMilli() + "@mailinator.com";
			IHRAuthorizationViewEmailAddressTextField.sendKeys(_email);
		}else{
			IHRAuthorizationViewEmailAddressTextField.sendKeys(email);
		}
			
	}
	public void clearNewAccountEmailAddress(){
		System.out.println("clearNewAccountEmailAddress()");
		IHRAuthorizationViewEmailAddressTextField.clear();
	}
	//Mutate Password Text Field
	public void enterNewAccountPassword(String password){
		System.out.println("enterNewAccountPassword()");
		IHRAuthorizationViewPasswordTextField.click();
		if(password == null){
			IHRAuthorizationViewPasswordTextField.sendKeys(NEWACCOUNTPASSWORD);
		}else{
			IHRAuthorizationViewPasswordTextField.sendKeys(password);
		}
			
	}
	public void clearNewAccountPassword(){
		System.out.println("clearNewAccountPassword()");
		IHRAuthorizationViewPasswordTextField.clear();
	}
	//Mutate Zip Code Text Field
	public void enterNewAccountZipcode(String zipcode){
		System.out.println("enterNewAccountZipcode()");
		IHRiPhoneSignUpViewZipCodeTextFieldUITextField.click();
		if(zipcode == null){
			IHRiPhoneSignUpViewZipCodeTextFieldUITextField.sendKeys("10001");
		}else{
			IHRiPhoneSignUpViewZipCodeTextFieldUITextField.sendKeys(zipcode);
		}
			
	}
	public void clearNewAccountZipcode(){
		System.out.println("clearNewAccountZipcode()");
		IHRiPhoneSignUpViewZipCodeTextFieldUITextField.clear();
	}
	
	//Mutate Birth Year Text Field
	public void enterNewAccountBirthYear(String birthyear){
		System.out.println("enterNewAccountBirthYear()");
		IHRiPhoneSignUpViewBirthYearTextFieldUITextField.click();
		if(birthyear == null){
			IHRiPhoneSignUpViewBirthYearTextFieldUITextField.sendKeys("1989");
		}else{
			IHRiPhoneSignUpViewBirthYearTextFieldUITextField.sendKeys(birthyear);
		}
			
	}
	public void clearNewAccountBirthYear(){
		System.out.println("clearNewAccountBirthYear()");
		IHRiPhoneSignUpViewBirthYearTextFieldUITextField.clear();
	}
	
	public void clickMaleGenderButton(){
		System.out.println("clickMaleGenderButton()");
		IHRiPhoneSignUpViewMaleButtonUIButton.click();
	}
	public void clickFemaleGenderButton(){
		System.out.println("clickFemaleGenderButton()");
		IHRiPhoneSignUpViewFemaleButtonUIButton.click();
	}
	
	public void clickTermsOfService(){
		System.out.println("clickTermsOfService()");
		IHRiPhoneSignUpViewTermsOfServiceButtonUIButton.click();
	}
	public void clickPrivacyPolicy(){
		System.out.println("clickPrivacyPolicy()");
		IHRiPhoneSignUpViewPrivacyPolicyButtonUIButton.click();
	}
	
	/**
	 * This can only be clicked when the textfields above it are filled out. 
	 */
	public void clickCreateAccountButton(){
		IHRAuthorizationViewLogInAuthButtonUIButton.click();
	}
	public void waitForCreateAccountButtonToAppear(){
		TestRoot.waitForElementToBeVisible(IHRAuthorizationViewLogInAuthButtonUIButton, 5);
	}
	
	public void clickNewAccountFacebookButton(){
		IHRAuthorizationViewFacebookButtonUIButton.click();
	}
	public void clickNewAccountGoogleButton(){
		IHRAuthorizationViewGoogleButtonUIButton.click();
	}
	
	public void checkAllElements(){
		System.out.println("Checking all elements in SignUpPage to verify they are in iOS app");
		onboardingPage.clickOnboardingCreateAccountButton();
		printElementInformation(NavBarBackButton);
		//printElementInformation(NavBarTitleCreateAccount);
		//Main Container with Table View and Agreement Container
		printElementInformation(IHRSignUpViewMainContainerUIView);
			//Table View with Email Address, Password, Zip Code, Birth Year, and Gender buttons. 
		printElementInformation(IHRAuthorizationViewTableViewUITableView);
				//Email And Password TextFields
		printElementInformation(IHRAuthorizationViewEmailAddressTextField);
		printElementInformation(IHRAuthorizationViewPasswordTextField);
				//Zip and Birth Cell [Zip Text Field, Birth Year Text Field ]
		printElementInformation(IHRiPhoneSignUpViewZipAndBirthCellUITableViewCell);
		printElementInformation(IHRiPhoneSignUpViewZipCodeTextFieldUITextField);
		printElementInformation(IHRiPhoneSignUpViewBirthYearTextFieldUITextField);
				//Gender Cell [ Gender Label, Male Button, Female Button ]
		printElementInformation(IHRiPhoneSignUpViewGenderCellUITableViewCell);
		printElementInformation(IHRiPhoneSignUpViewGenderLabelUILabel);
					//These don't have objects that accessibilityIdentifer can be added to. 
		printElementInformation(IHRiPhoneSignUpViewMaleButtonUIButton);
		printElementInformation(IHRiPhoneSignUpViewFemaleButtonUIButton);
			//UI View  with Agreement Container
		printElementInformation(IHRiPhoneSignUpViewAgreementContainerUIView);
		printElementInformation(IHRiPhoneSignUpViewIAgreeToTheTermsLabelUILabel); //By creating an account, you also agree to our
		printElementInformation(IHRiPhoneSignUpViewTermsOfServiceButtonUIButton);//Terms of Service underlined link / button to ToS
		printElementInformation(IHRiPhoneSignUpViewAndLabelUILabel); //and
		printElementInformation(IHRiPhoneSignUpViewPrivacyPolicyButtonUIButton);
			//LogInAuthButton / Create Account Button is only visible after the Table View elements are filled out. 
		enterNewAccountEmailAddress(null);
		enterNewAccountPassword(null);
		enterNewAccountZipcode(null);
		enterNewAccountBirthYear(null);
		clickMaleGenderButton();
		waitForCreateAccountButtonToAppear();
		printElementInformation(IHRAuthorizationViewLogInAuthButtonUIButton);
		//Or Connect With Container with Facebook and Google Buttons		
		printElementInformation(IHRAuthorizationViewOrConnectWithContainerUIView);
		
		printElementInformation(IHRAuthorizationViewFacebookButtonUIButton);
		printElementInformation(IHRAuthorizationViewGoogleButtonUIButton);
	}
	
	/**
	 * createNewAccount -  Clicks on Create Account Button on Onboarding Page and then enters default values into the fields. 
	 * Should return the user to the homePage
	 * @return
	 */
	public boolean createNewAccount(){
		onboardingPage.clickOnboardingCreateAccountButton();
		System.out.println("Creating a new account with default parameters.");
		enterNewAccountEmailAddress(null);
		enterNewAccountPassword(null);
		enterNewAccountZipcode(null);
		clearNewAccountZipcode();
		enterNewAccountZipcode(null);
		enterNewAccountBirthYear(null);
		clickMaleGenderButton();
		waitForCreateAccountButtonToAppear();
		System.out.println("Information entered, about to click on Create Account Button.");
		clickCreateAccountButton();
		enterZip();
		
		//TestRoot.waitForElementToBeVisible(genrePage.genrePicker, 15);

		// verify that 'Tell us what you like' page shows up
		return genrePage.isCurrentlyOnGenrePage() || homePage.isCurrentlyOnHomePage();
		
	}
	/**
	 * Creates a new Account with the included parameters. 
	 * @param email
	 * @param password
	 * @param zipcode
	 * @param birthyear
	 * @param gender
	 * @return
	 */
	public boolean createNewAccount(String email, String password, String zipcode, String birthyear, String gender){
		onboardingPage.clickOnboardingCreateAccountButton();
		System.out.println("Creating a new account[ email:"+ email + "  Pw: " + password + "  Zipcode: "+ zipcode + "  birthyear:" + "  gender:" + gender + "].");
		enterNewAccountEmailAddress(email);
		enterNewAccountPassword(password);
		enterNewAccountZipcode(zipcode);
		enterNewAccountBirthYear(birthyear);
		if(gender.equalsIgnoreCase("male")){
			clickMaleGenderButton();
		}else if(gender.equalsIgnoreCase("female")){
			clickFemaleGenderButton();
		}
		
		waitForCreateAccountButtonToAppear();
		System.out.println("Information entered, about to click on Create Account Button.");
		clickCreateAccountButton();
		enterZip();
		return genrePage.isCurrentlyOnGenrePage() || homePage.isCurrentlyOnHomePage();
		
	}

	public boolean currentlyOnSignUpPage(){
		if(IHRiPhoneSignUpViewIAgreeToTheTermsLabelUILabel.isDisplayed()){
			System.out.println("Currently on SignUpPage");
			return true;
		}
		else {
			return false;
		}
	}

	public SignUpPage() {
		super();
	}

	public SignUpPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}

	private String getCurrentDateInMilli() {
		Date date = new Date();
		return date.getTime() + "";
	}

	public void tapBack(){
		NavBarBackButton.click();
	}
	
}
