package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;

public class SideNavigationBar extends Page {

	// ******* Side Navigation Bar *******
	// @iOSFindBy(accessibility="nav")
	//	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]") public IOSElement navIcon;
	//private final String navIconString = "Side Menu";
	//@iOSFindBy(accessibility = navIconString) public IOSElement navIcon;
	@iOSFindBy(accessibility = "NavBar-SideMenuButton-UIButton") private IOSElement NavBarSideMenuButtonUIButton;
	@iOSFindBy(accessibility = "Now Playing") public IOSElement playingIcon;

	@iOSFindBy(accessibility = "Home") public IOSElement home;
	@iOSFindBy(accessibility = "My Stations") public IOSElement myStations;
	@iOSFindBy(accessibility = "Live Radio") public IOSElement liveRadio;
	@iOSFindBy(accessibility = "Artist Radio") public IOSElement artistRadio;
	@iOSFindBy(accessibility = "Podcasts") public IOSElement podcasts;
	@iOSFindBy(accessibility = "Perfect For") public IOSElement perfectFor;
	@iOSFindBy(accessibility = "Listening History") public IOSElement listeningHistory;
	@iOSFindBy(accessibility = "Alarm Clock") public IOSElement alarm;
	@iOSFindBy(accessibility = "Sleep Timer") public IOSElement sleep;
	//@iOSFindBy(accessibility = "Songs") public IOSElement songs;		 +	//@iOSFindBy(accessibility = "Songs") public IOSElement songs;
	/** 
	 * sk 2/10 -- 7.2.0 - changes
	 */
	//@iOSFindBy(accessibility = "Settings") public IOSElement settings;		 +	//@iOSFindBy(accessibility = "Settings") public IOSElement settings;
	@iOSFindBy(accessibility = "Account") public IOSElement settings;
	@iOSFindBy(accessibility = "Logged In As") 	private IOSElement loggedInAs;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")
	private IOSElement logout;
	
	public SideNavigationBar(IOSDriver<IOSElement> _driver) {
		super(_driver);
		setSideNavigationBar(this);
	}
	
	public boolean isSideNavBarOpen(){
		return home!=null;
	}
	public void clickNavBarSideMenuButton(){
		//sr - commented out for 6.7.0 - as it repeats multiple times
		//System.out.println("Clicking on Hamburger Button to Open/Close SideBar");
		NavBarSideMenuButtonUIButton.click();
	}

	public void getToAndEnterZip(String zip){
		if(!waitForElementToBeVisible(NavBarSideMenuButtonUIButton, 2)){
			clickNavBarBackButton();
		}
		if(isVisible(NavBarSideMenuButtonUIButton)){
			clickNavBarSideMenuButton();
			liveRadio.click();
		}
		IOSElement enterZip = waitForVisible(driver, find("Enter ZIP"), 3);
		if(!isVisible(enterZip)){
			enterZip = waitForVisible(driver, find("Use ZIP"), 1);
		}
		if(isVisible(enterZip)){
			enterZip.click();
			IOSElement zipEntry = waitForVisible(driver, find("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]"), 5);
			if(isVisible(zipEntry)){
				zipEntry.sendKeys(zip);
				findElement(driver, By.name("OK")).click();
			}
		}
	}
	
	// Put header and player related methods here
	public void gotoHomePage() {
		if(!waitForElementToBeVisible(NavBarSideMenuButtonUIButton, 2)){
			clickNavBarBackButton();
		}
		clickNavBarSideMenuButton();
		waitForElementToBeVisible(home, 1);
		home.click();
	}

	public void gotoLiveRadioPage() {
		clickNavBarSideMenuButton();
		liveRadio.click();
		Page.handlePossiblePopUp();
	}
	
	//sk - 11/7 - renamed method to reflect Artist page
	public void gotoArtistPage() {
		clickNavBarSideMenuButton();
		artistRadio.click();
	}

	public void gotoPodcastsPage() {
		clickNavBarSideMenuButton();
		podcasts.click();
	}
	
	public void gotoPerfectFor(){
		clickNavBarSideMenuButton();
		perfectFor.click();
	}

	public void gotoListeningHistoryPage() {
		clickNavBarSideMenuButton();
		listeningHistory.click();
	}

	public void gotoMyStationsPage(){
		if(!isVisible(myStations)){
			gotoHomePage();
		}
		myStations.click();
	}
	
	public void gotoAlarm(){
		clickNavBarSideMenuButton();
		alarm.click();
	}
	
	public void gotoSleep(){
		clickNavBarSideMenuButton();
		sleep.click();
	}
	
	public void gotoSettings() {
		if(settings == null || !isVisible(settings)){
			//sk-11/5-added in additional condition checking, else test fails looking for a back button when hamburger is just late in loading
			if(!waitForElementToBeVisible(NavBarSideMenuButtonUIButton, 4) && waitForElementToBeVisible(NavBarBackButton,2)){
				clickNavBarBackButton();
			}
			clickNavBarSideMenuButton();
		}
		//Added in method to dismiss pop-ups
		Page.quickDismissPopUp();
		waitForElementToBeVisible(settings, 5);
		settings.click();
	}

	public void logout() {
		System.out.println("Logging out through SideNavBar");
		gotoSettings();
		loggedInAs.click();
		logout.click();
	}

}
