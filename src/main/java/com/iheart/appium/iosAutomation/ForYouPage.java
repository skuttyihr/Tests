package com.iheart.appium.iosAutomation;

import java.util.List;

import io.appium.java_client.pagefactory.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.*;

public class ForYouPage extends Page {

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]") private IOSElement firstStation;
	// @iOSFindBy(name="Sign in") private WebElement signIn;

	// for search
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]") private IOSElement topHit;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[1]/UIAStaticText[1]") private IOSElement topStation;

	public ForYouPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}

	// Returns true if the station was added
	public boolean createArtistStation() {
		String artist = "Josh Groban";
		waitForElementToBeVisible(search.searchButton, 5);
		search.searchButton.click();
		search.searchField.sendKeys(artist);
		topHit.click();
		// Verify PLAYER
		player.verifyPlayer_artist(artist);
		player.doThumbUp();
		player.doThumbDown("artist");
		player.doFavorite();
		player.doSkip();
		// Verify that this station is added under My Station
		player.back.click();
		search.cancel.click();
		player.myStations.click();
		return isStationAFavorite(artist) > 0;
	}

	private String chooseLiveRadioToPlay(List<WebElement> stations) {
		String myStation = "";
		String radioName = "";
		boolean played = false;
		// 1.Not ends with 'Radio', 1. Hopefully, but not necessarily, contains
		// number like 101.3
		for (WebElement station : stations) {
			// radioName = station.getAttribute("name");
			radioName = station.getText();
			System.out.println("See station:" + radioName);
			if (!radioName.contains(" Radio")) {
				// Any station contains numbers?
				if (radioName.matches(".*\\d+.*")) {
					myStation = radioName;
					station.click();
					played = true;
					break;
				}
			}

		} // for

		if (played)
			return myStation;
		// if no station contains number, then play candidate;
		for (WebElement station : stations) {
			if (!station.getText().contains(" Radio")) {
				myStation = station.getText();
				station.click();
				break;
			}
		} // for

		return myStation;

	}

	public void playLiveRadio() {
		String myStation = "";
		WebElement collectionView = driver
				.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]"));
		List<WebElement> stations = collectionView.findElements(By.className("UIACollectionCell"));
		myStation = chooseLiveRadioToPlay(stations);
		System.out.println("MySTATION:" + myStation);

		// Verify PLAYER
		player.verifyPlayer_live(myStation);
		player.doFavorite();
		player.doScan();
		player.doThumbUp();
		player.doThumbDown();
		// player.doFavorite();

		// Here, remember the playing station name:
		myStation = driver
				.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"))
				.getText();
		System.out.println("playing station:" + myStation);

		// player.pauseAndResume("live");

		// tap on My Station and make sure Station is added??
		// Verify that this station is added under My Station
		(player.back).click();
		waitForVisible(driver, By.name("My Stations"), 5).click();
		// Wait for the list to be visible
		getStationFromList(1); // Includes a wait
		if (!driver.getPageSource().contains(myStation))
			Assert.fail("Live station is not added under My Station.");
	}

	public void comeToThisPage() {
		driver.findElement(By.name("For You")).click();
	}
}
