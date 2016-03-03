package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SettingsPage extends Page {

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]0") public IOSElement loggedInAs;
	@iOSFindBy(name = "Logged In") public IOSElement thirdPartyLoggedIn;
}
