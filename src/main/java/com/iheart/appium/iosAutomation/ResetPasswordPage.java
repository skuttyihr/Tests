package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ResetPasswordPage extends Page {
	
	//Nav Bar
	@iOSFindBy(accessibility = "NavBar-BackButton-UIButton") private IOSElement NavBarBackButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[2]") private IOSElement NavBarTitleText;
	
	@iOSFindBy(accessibility = "IHRiPhoneForgotPasswordView-TableView-UITableView") private IOSElement IHRiPhoneForgotPasswordViewTableViewUITableView;
	@iOSFindBy(accessibility = "IHRForgotPasswordView-EmailFieldCell-UITableViewCell") private IOSElement IHRForgotPasswordViewEmailFieldCellUITableViewCell;
	@iOSFindBy(accessibility = "IHRForgotPasswordView-EmailField-UITextField") private IOSElement IHRForgotPasswordViewEmailFieldUITextField;
	@iOSFindBy(accessibility = "IHRiPhoneForgotPasswordView-HintLabel-UILabel") private IOSElement IHRiPhoneForgotPasswordViewHintLabelUILabel;
	@iOSFindBy(accessibility = "IHRiPhoneForgotPasswordView-ResetButton-UIButton") private IOSElement IHRiPhoneForgotPasswordViewResetButtonUIButton;
	
	/**
	 * Constructor for ResetPasswordPage object - to be called in TestRoot.java
	 */
	public ResetPasswordPage() {
		super();
	}
	/**
	 * Constructor for ResetPasswordPage object - to be called in TestRoot.java
	 * IOSDriver is parameter. 
	 */
	public ResetPasswordPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	/**
	 * Returns true if all elements with accessibilityIdentiers return true for isDisplayed()
	 * Also prints out IOSElement information to the console.
	 * @return
	 */
	public boolean showAllElements(){
		//Must enter something into EmailField so that ResetButton appears.
		enterEmailAddressToResetPassword("anEmailAddress@gmail.com");
		return(
			printElementInformation(IHRiPhoneForgotPasswordViewTableViewUITableView) &&
			printElementInformation(IHRForgotPasswordViewEmailFieldCellUITableViewCell) &&
			printElementInformation(IHRForgotPasswordViewEmailFieldUITextField) &&
			printElementInformation(IHRiPhoneForgotPasswordViewHintLabelUILabel) &&
			printElementInformation(IHRiPhoneForgotPasswordViewResetButtonUIButton)
			);	
	}
	
	/**
	 * Enters email address into Reset Password Text Field
	 * @param email
	 */
	public void enterEmailAddressToResetPassword(String email){
		System.out.println("Entering email address into Reset Password TextField: "+ email);
		IHRForgotPasswordViewEmailFieldUITextField.click();
		IHRForgotPasswordViewEmailFieldUITextField.sendKeys(email);
	}
	
	/**
	 * Clear email address text field
	 */
	public void clearEmailAddress(){
		IHRForgotPasswordViewEmailFieldUITextField.clear();
	}
	
	/**
	 * Get HintLabel text
	 */
	public String getHintLabelText(){
		return IHRiPhoneForgotPasswordViewHintLabelUILabel.getText();
	}
	
	/**
	 * Go back - Most likely to loginPage
	 */
	public void clickBackButton(){
		NavBarBackButton.click();
	}
	

	/**
	 * Get NavBar Title Text
	 * @return
	 */
	public String getNavBarTitleText(){
		return NavBarTitleText.getText();
	}
	
	public void clickResetPasswordButtonWithBadEmail(){
		IHRiPhoneForgotPasswordViewResetButtonUIButton.click();
		//Wrong Email Address. 'Right string format abc@example.com.' Now Click Ok to repeat an email.
		waitForVisible(driver, By.name("OK"), 2).click();
	}
	public boolean clickResetPasswordButton(){
		IHRiPhoneForgotPasswordViewResetButtonUIButton.click();
		//Password Reset Success Notification comes up. Now Click Ok.
		waitForVisible(driver, By.name("OK"), 2).click();
		//Goes to Login Page
		return loginPage.currentlyOnLoginPage();
	}
	public boolean isCurrentlyOnResetPasswordPage(){
		return IHRiPhoneForgotPasswordViewTableViewUITableView.isDisplayed();
	}
}
