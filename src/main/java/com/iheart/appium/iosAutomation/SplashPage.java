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
	@iOSFindBy(name = "onboarding_logo") protected IOSElement onboardingLogo;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") protected IOSElement onboardingText;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]") protected IOSElement additionalOnboardingText;
	@iOSFindBy(name = "UIAPageIndicator") protected IOSElement splashPageIndicator;
	@iOSFindBy(name = "Log In") protected IOSElement splashPageLogInButton;
	@iOSFindBy(name = "Get Started") protected IOSElement splashPageGetStartedButton;
	
	// Behavioral and helper methods
	public String getOnBoardingText(){
		String onboardingTextString = "";
		if(onboardingText != null){
			onboardingTextString = onboardingText.getText();
		}
//		IOSElement titleText = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"));
//		if(titleText != null){
//			onboardingText = titleText.getText();
//		}
		return onboardingTextString;
	}
	public boolean isBackgroundImagePresent(){
		IOSElement backgroundImage = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]"));
		if(backgroundImage != null){
			if(backgroundImage.getLocation().getX() == 0 &&
					backgroundImage.getLocation().getY() == 0){
				return true;
			}
		}
		return false;
	}
}
