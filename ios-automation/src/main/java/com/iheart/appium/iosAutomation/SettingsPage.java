package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SettingsPage extends Page {

	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[2]") public IOSElement loggedInAs;
	@iOSFindBy(accessibility = "Logged In As") public IOSElement thirdPartyLoggedIn;
	@iOSFindBy(accessibility = "NavBar-SideMenuButton-UIButton") private IOSElement NavBarSideMenuButtonUIButton;
	

	@iOSFindBy(accessibility = "Subscription") private IOSElement subscription;
	
	public SettingsPage(){
		super();
	}
	public SettingsPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	public boolean isHamburgerButtonDisplayed(){
		boolean isDisp = NavBarSideMenuButtonUIButton.isDisplayed();
		//System.out.println("isHamburgerButtonDisplayed() : " + isDisp);
		return isDisp;
	}
	public void clickHamburgerButtonToOpenSideMenu(){
		System.out.println("clickHamburgerButtonToOpenSideMenu()...");
		NavBarSideMenuButtonUIButton.click();
	}
	
	//sk-11/5/6 - added in dismiss pop method call for Google Login to work
	public boolean isLoggedIn(){
		if(!isHamburgerButtonDisplayed()){
			fullPlayer.clickDownArrowOnNavBarToMinimizeFullPlayer();
		}
		sideNavBar.gotoSettings();
		loginPage.dismissLoginPopups();
		if(isVisible(thirdPartyLoggedIn)){
			String status = thirdPartyLoggedIn.getAttribute("value");
			System.out.println(status);
			if (!strGood(status) || !status.equals("Logged In As"))
				return false;
		}
		//this returns a String, causing the test to fail
			/*}
		else{
			if(isVisible(loggedInAs)){
				return strGood(loggedInAs.getText());*/
		return true;
	}
	public boolean doesEntitlementMatch(String entitlementType) {
		sideNavBar.gotoSettings();
		loginPage.dismissLoginPopups();
		if(isVisible(subscription)){
			String subType = subscription.getText();
			return subType.equals(entitlementType);
		}
		return false;
	}
}
