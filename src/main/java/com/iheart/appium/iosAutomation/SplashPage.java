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
	@iOSFindBy(name = "onboarding_logo") public IOSElement onboardingLogo;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]") protected IOSElement onboardingText;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") protected IOSElement additionalOnboardingText;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAPageIndicator[1]") protected IOSElement splashPageIndicator;
	@iOSFindBy(name = "Log In") protected IOSElement splashPageLogInButton;
	@iOSFindBy(name = "Create Account") protected IOSElement createAccount;
	
	// Behavioral and helper methods
	public String getOnBoardingText(){
		String onboardingTextString = null;
		if(onboardingText != null){
			onboardingTextString = onboardingText.getText();
		}
		return onboardingTextString;
	}
	public void waitForSplash(){
		waitForVisible(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]"), 20);
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
			if(!isVisible(splashPageLogInButton)){
				couldNotFind.append("Login button was not present\n");
			}
		}catch(Exception e){
			couldNotFind.append("Login button was not present\n");
		}
		try{
			if(!isVisible(splashPageLogInButton)){
				couldNotFind.append("Get started button was not present\n");
			}
		}catch(Exception e){
			couldNotFind.append("Get started button was not present\n");
		}
		return couldNotFind.toString();
	}
	
	public boolean clickCreateAccount(){
		waitForElementToBeVisible(createAccount, 10);
		createAccount.click();
		waitForElementToBeVisible(signupPage.getCreateAccount(), 2);
		return isVisible(signupPage.getCreateAccount());
	}
}
