package com.iheart.appium.iosAutomation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PlayerPage extends Page{
	
	@iOSFindBy(name="Back") private IOSElement back;
	@iOSFindBy(name="Share") private IOSElement share;
	@iOSFindBy(name="Favorite") private IOSElement favorite;
	
	//Seems that this is depending upon from where the player is launched
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]") private IOSElement songTrack;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]") private IOSElement singer;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[7]") private IOSElement playButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[11]") private IOSElement more;
	@iOSFindBy(name="skip") private IOSElement skip;
	@iOSFindBy(name="Thumb up") private IOSElement thumbUp;
	@iOSFindBy(name="Thumb down") private IOSElement thumbDown;
	
	public PlayerPage(IOSDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	


}
