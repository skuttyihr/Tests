package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;

public class SideNavigationBar extends Page {

	// ******* Side Navigation Bar *******
	// @iOSFindBy(accessibility="nav")
//	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]") public IOSElement navIcon;
	private final String navIconString = "Side Menu";
	@iOSFindBy(accessibility = navIconString) public IOSElement navIcon;
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
//	@iOSFindBy(accessibility = "Songs") public IOSElement songs;
	@iOSFindBy(accessibility = "Settings") public IOSElement settings;

	// ****** End of Side Nav page ******

	// Fields in Settings page
	@iOSFindBy(accessibility = "Logged In As")
	private IOSElement loggedInAs;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")
	private IOSElement logout;

	public SideNavigationBar(IOSDriver<IOSElement> _driver) {
		super(_driver);
		setSideNavigationBar(this);
	}

	public void getToAndEnterZip(String zip){
		if(!isVisible(waitForVisible(driver, find(navIconString), 2))){
			getBack();
		}
		if(isVisible(navIcon)){
			navIcon.click();
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
		if(!isVisible(waitForVisible(driver, find(navIconString), 2))){
			getBack();
		}
		if(click(driver, find(navIconString))){
			waitForElementToBeVisible(home, 1);
			home.click();
		}
	}

	public void gotoLiveRadioPage() {
		navIcon.click();
		liveRadio.click();
		Page.handlePossiblePopUp();
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
			if(!isVisible(navIcon)){
				getBack();
			}
			navIcon.click();
		}
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
