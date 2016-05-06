package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SettingsPage extends Page {

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]") public IOSElement loggedInAs;
	@iOSFindBy(accessibility = "Logged In") public IOSElement thirdPartyLoggedIn;
	
	public SettingsPage(){
		super();
	}
	public SettingsPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	public boolean isLoggedIn(){
		if(!isVisible(sideNavBar.navIcon)){
			// try to click back?
			try{
				player.back.click();
			}catch(Exception e){}
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
