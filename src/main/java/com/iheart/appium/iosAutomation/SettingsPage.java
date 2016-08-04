package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SettingsPage extends Page {

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]") public IOSElement loggedInAs;
	@iOSFindBy(accessibility = "Logged In") public IOSElement thirdPartyLoggedIn;
	@iOSFindBy(accessibility = "NavBar-SideMenuButton-UIButton") private IOSElement NavBarSideMenuButtonUIButton;
	
	public SettingsPage(){
		super();
	}
	public SettingsPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	public boolean isHamburgerButtonDisplayed(){
		boolean isDisp = NavBarSideMenuButtonUIButton.isDisplayed();
		System.out.println("isHamburgerButtonDisplayed() : " + isDisp);
		return isDisp;
	}
	public void clickHamburgerButtonToOpenSideMenu(){
		System.out.println("clickHamburgerButtonToOpenSideMenu()...");
		NavBarSideMenuButtonUIButton.click();
	}
	
	public boolean isLoggedIn(){
		if(!isHamburgerButtonDisplayed()){
			fullPlayer.clickDownArrowOnNavBarToMinimizeFullPlayer();
		}
		sideNavBar.gotoSettings();
		
		if(isVisible(thirdPartyLoggedIn)){
			String status = thirdPartyLoggedIn.getText();
			if (!strGood(status) || !status.equals("Logged In"))
				return false;
			else
				return true;
		}
		else{
			if(isVisible(loggedInAs)){
				return strGood(loggedInAs.getText());
			}
			return false;
		}
	}
}
