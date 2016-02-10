package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class SplashPage extends Page {

	public SplashPage(){
		super();
	}
	public SplashPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	public String getOnBoardingText(){
		String onboardingText = "";
		IOSElement titleText = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"));
		if(titleText != null){
			onboardingText = titleText.getText();
		}
		return onboardingText;
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
