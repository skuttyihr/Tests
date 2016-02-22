package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import io.appium.java_client.ios.IOSDriver;

public class SideNavigationBar extends Page {

	// ******* Side Navigation Bar *******
	// @iOSFindBy(name="nav")
//	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]") public IOSElement navIcon;
	private final String navIconString = "Side Menu";
	@iOSFindBy(name = navIconString) public IOSElement navIcon;
	@iOSFindBy(name = "Now Playing") public IOSElement playingIcon;

	@iOSFindBy(name = "Home") public IOSElement home;
	@iOSFindBy(name = "My Stations") public IOSElement myStations;
	@iOSFindBy(name = "Live Radio") public IOSElement liveRadio;
	@iOSFindBy(name = "Artist Radio") public IOSElement artistRadio;
	@iOSFindBy(name = "Podcasts") public IOSElement podcasts;
	@iOSFindBy(name = "Perfect For") public IOSElement perfectFor;
	@iOSFindBy(name = "Listening History") public IOSElement listeningHistory;
	@iOSFindBy(name = "Alarm Clock") public IOSElement alarm;
	@iOSFindBy(name = "Sleep Timer") public IOSElement sleep;
//	@iOSFindBy(name = "Songs") public IOSElement songs;
	@iOSFindBy(name = "Account Settings") public IOSElement settings;

	// ****** End of Side Nav page ******

	// Fields in Settings page
	@iOSFindBy(name = "Logged In As")
	private IOSElement loggedInAs;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")
	private IOSElement logout;

	public SideNavigationBar(IOSDriver<IOSElement> _driver) {
		super(_driver);
		setSideNavigationBar(this);
	}

	// Put header and player related methods here
	public void gotoHomePage() {
		waitForVisible(driver, find(navIconString), 5).click();
		home.click();
	}

	public void gotoLiveRadioPage() {
		navIcon.click();
		liveRadio.click();
	}

	public void gotoLiveArtistPage() {
		navIcon.click();
		artistRadio.click();
	}

	public void gotoPodcastsPage() {
		navIcon.click();
		podcasts.click();
	}
	
	public void gotoPerfectFor(){
		navIcon.click();
		perfectFor.click();
	}

	public void gotoListeningHistoryPage() {
		navIcon.click();
		listeningHistory.click();
	}

	public void gotoMyStationsPage(){
		if(!isVisible(myStations)){
			gotoHomePage();
		}
		myStations.click();
	}
	
	public void gotoAlarm(){
		navIcon.click();
		alarm.click();
	}
	
	public void gotoSleep(){
		navIcon.click();
		sleep.click();
	}
	
	public void gotoSettings() {
		if(settings == null || !isVisible(settings)){
			waitForElementToBeVisible(navIcon, 2);
			navIcon.click();
		}
		waitForElementToBeVisible(settings, 5);
		settings.click();
	}

	public void logout() {
		gotoSettings();
		loggedInAs.click();
		logout.click();
	}

}
