package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class CustomRadio extends Page {

	public CustomRadio() {
		super();
	}

	public CustomRadio(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	
	public String playACustomStation(){
		return playACustomStation("Chvrches");
	}
	public String playACustomStation(String artist) {
		String chosenStation = search.searchForStation(artist);
		loginPage.dismissStayConnectedPopup(); // Pretty good universal popup dismisser
		// verify that it is playing: Get its attribute: class shall be 'pause'
		if (!player.isPlaying("artist"))
			return "";
		
		// Stop the station
		player.playButton_artist.click();
		return chosenStation;
	}

	public String canPlayCustomStation() {
		String chosenStation = playACustomStation();
		if(chosenStation == null || chosenStation.length() <= 0){
			return "Could not choose a station.";
		}
		// verify that login prompt has not popped up
		if (isVisible(createAccount)){
			return "Create account should not have popped up here, as we're logged in";
		}
		
		// Verify it is the first under My Station -> Recent Stations
		player.back.click();
		waitForElementToBeVisible(search.cancel, 2);
		search.cancel.click();
		waitForElementToBeVisible(myStations, 2);
		if(!isVisible(myStations)){
			sideNavBar.gotoHomePage();
		}
		myStations.click();
		if (!driver.getPageSource().contains(chosenStation)){
			return "Newly played custom station, " + chosenStation + ", is not added under my Recent Stations.";
		}
		
		return ""; // No errors
	}
}