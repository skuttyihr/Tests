package com.iheart.appium.iosAutomation;

import org.junit.Assert;

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
			Assert.fail("Station is not playing.");
		
		// Stop the station
		player.playButton_artist.click();
		return chosenStation;
	}

	public boolean canPlayCustomStation() {
		String chosenStation = playACustomStation();
		if(chosenStation == null || chosenStation.length() <= 0){
			return false;
		}
		
		// Verify it is the first under My Station -> Recent Stations
		// Click on top Bake
		player.back.click();
		search.cancel.click();
		myStations.click();
		if (!driver.getPageSource().contains(chosenStation)){
			System.err.println("Newly played custom station is not added under my Recent Stations.");
			return false;
		}
		// logout
		sideNavigationBar.gotoSettings();
		sideNavigationBar.logout();

		// Vefiry Login prompt
		sideNavigationBar.gotoHomePage();
		perfectFor.click();
		// playAstation();
		playACustomStation();
		// verify that login prompt is popped up
		if (!isElementVisible(createAccount)){
			System.err.println("No login prompt is displayed for signed out users.");
			return false;
		}
		return true;
	}
}