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
		return playACustomStation("Taylor Swift");
	}
	public String playACustomStation(String artist) {
		String chosenStation = search.searchForStation(artist);
		loginPage.dismissStayConnectedPopup();
		// verify that it is playing: Get its attribute: class shall be 'pause'
		if (!player.isPlaying("artist"))
			return "";
		
		// Stop the station
		player.playButton_artist.click();
		return chosenStation;
	}

	public boolean canPlayCustomStation() {
		String chosenStation = playACustomStation();
		if(chosenStation == null || chosenStation.length() <= 0){
			return false;
		}
		// verify that login prompt has not popped up
		if (isVisible(createAccount)){
			return false;
		}
		
		// Verify it is the first under My Station -> Recent Stations
		player.back.click();
		search.cancel.click();
		myStations.click();
		if (!driver.getPageSource().contains(chosenStation)){
			System.err.println("Newly played custom station is not added under my Recent Stations.");
			return false;
		}
		
		return true;
	}
}