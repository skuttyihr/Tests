package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class HomePage extends Page {

	public HomePage() {
		super();
	}
	public HomePage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}

	/*
	 * public HomePage(IOSDriver _driver) { super(_driver); }
	 */
	public void gotoHome(){
		if(!forYou.isDisplayed()){
			sideNavigationBar.navIcon.click();
			sideNavigationBar.home.click();
		}
	}
	public void gotoMyStations() {
		gotoHome();
		myStations.click();
	}

	public void gotoForYou() {
		gotoHome();
		forYou.click();
	}

	public void gotoPerfectFor() {
		gotoHome();
		perfectFor.click();
	}

}
