package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SplashPage extends Page {

	public SplashPage(){
		super();
	}
	public SplashPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	// Elements
	
	@iOSFindBy(accessibility = "onboarding_logo") public IOSElement onboardingLogo;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]") public IOSElement onboardingText;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") public IOSElement additionalOnboardingText;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAPageIndicator[1]") public IOSElement splashPageIndicator;
	@iOSFindBy(accessibility = "Log In") public IOSElement logIn;
	@iOSFindBy(accessibility = "Create Account") public IOSElement createAccount;
	/*
	@iOSFindBy(accessibility = "SplashPageOnboardingLogoUIAImage") public IOSElement onboardingLogo;
	@iOSFindBy(accessibility = "SplashPageTitleLabel") public IOSElement onboardingText;
	@iOSFindBy(accessibility = "SplashPageDescriptionLabel") public IOSElement additionalOnboardingText;
	@iOSFindBy(accessibility = "SplashPagePageControl") public IOSElement splashPageIndicator;
	@iOSFindBy(accessibility = "SplashPageLogInButton") public IOSElement logIn;
	@iOSFindBy(accessibility = "SplashPageSignUpButton") public IOSElement createAccount;
	*/
	// Behavioral and helper methods
	public String getOnBoardingText(){
		String onboardingTextString = null;
		if(onboardingText != null){
			onboardingTextString = onboardingText.getText();
		}
		return onboardingTextString;
	}
	
	//used in whatisn'tvisible (SplashPage.java)
	public void waitForSplash(){
		waitForVisible(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]"), 5);
	}
	
	public boolean isBackgroundImagePresent(){
		IOSElement backgroundImage = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]"));
		if(backgroundImage != null){
			return true;
		}
		return false;
	}
	
	public String whatIsntVisible(){
		return whatIsntVisible(false);
	}
	public String whatIsntVisible(boolean wait){
		if(wait == true){
			waitForSplash();
		}
		
		StringBuilder couldNotFind = new StringBuilder();
		if(!isBackgroundImagePresent()){
			couldNotFind.append("Background image was not present\n");
		}
		if(getOnBoardingText() == null){
			couldNotFind.append("Onboarding text was not present\n");
		}
		try{
			if(!isVisible(onboardingLogo)){
				couldNotFind.append("Onboarding logo was not present\n");
			}
		}catch(Exception e){}
		try{
			if(!isVisible(additionalOnboardingText)){
				couldNotFind.append("Onboarding additional text was not present\n");
			}
		}catch(Exception e){
			couldNotFind.append("Onboarding additional text was not present\n");
		}
		try{
			if(!isVisible(splashPageIndicator)){
				couldNotFind.append("Page indicator was not present\n");
			}
		}catch(Exception e){
			couldNotFind.append("Page indicator was not present\n");
		}
		try{
			if(!isVisible(logIn)){
				couldNotFind.append("Login button was not present\n");
			}
		}catch(Exception e){
			couldNotFind.append("Login button was not present\n");
		}
		try{
			if(!isVisible(logIn)){
				couldNotFind.append("Get started button was not present\n");
			}
		}catch(Exception e){
			couldNotFind.append("'Create Account' button was not present\n");
		}
		return couldNotFind.toString();
	}
	
	public boolean clickLogIn(){
		waitForElementToBeVisible(logIn, 2);
		logIn.click();

		//waitForElementToBeVisible(loginPage.IHRAuthorizationViewEmailAddressTextField, 5);
		return isVisible(loginPage.IHRAuthorizationViewEmailAddressTextField);
	}
	
	public boolean clickCreateAccount(){
		System.out.println("3");
		waitForElementToBeVisible(createAccount, 6);
		createAccount.click();
		waitForElementToBeVisible(signupPage.getCreateAccount(), 5);
		return isVisible(signupPage.getCreateAccount());
	}
}
