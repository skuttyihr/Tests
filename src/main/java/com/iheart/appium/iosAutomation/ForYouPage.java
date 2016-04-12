package com.iheart.appium.iosAutomation;

import java.util.List;

import io.appium.java_client.pagefactory.*;

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

	private String chooseLiveRadioToPlay(List<WebElement> stations) {
		String myStation = "";
		String radioName = "";
		boolean played = false;
		// 1.Not ends with 'Radio', 1. Hopefully, but not necessarily, contains
		// number like 101.3
		for (WebElement station : stations) {
			// radioName = station.getAttribute("name");
			radioName = station.getText();
//			System.out.println("See station:" + radioName);
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

		miniPlayer.maximizeMiniPlayer();
		
		return myStation;

	}

	public String playLiveRadio(){
		String myStation = "";
		WebElement collectionView = waitForVisible(driver,
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]"),
				10);
		if(collectionView != null){
			List<WebElement> stations = collectionView.findElements(By.className("UIACollectionCell"));
			myStation = chooseLiveRadioToPlay(stations);
		}
		miniPlayer.maximizeMiniPlayer();
		return myStation;
	}
	
	public String playAndVerifyLiveRadio() {
		Errors errors = new Errors();
		String myStation = playLiveRadio();
		System.out.println("Starting with:" + myStation);
		
		// Verify PLAYER
		errors.add(player.verifyPlaybackControls(myStation));
		if(!player.doFavorite()){
			errors.add("Could not favorite!\n");
		}
		if(!player.doScan()){
			errors.add("Could not scan!\n");
		}
		if(!player.doThumbUp()){
			errors.add("Could not do thumbs up!\n");
		}
		if(!player.doThumbDown()){
			errors.add("Could not do thumbs down!\n");
		}

		// Here, remember the playing station name:
		String newStation = driver
				.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"))
				.getText();
		if(!newStation.equals(myStation)){
			System.out.println("Had to switch to new station due to disabled thumb buttons. New station: " + newStation);
			myStation = newStation;
		}

		// Verify that this station is added under My Station
		player.back.click();
		if(!verifyInForYou(myStation)){
			errors.add("Could not find station: " + myStation + " in my stations page.\n");
		}
		
		return errors.getErrors();
	}
	
	public boolean verifyInForYou(String station){
		if(!isVisible(sideNavBar.navIcon)){
			player.back.click();
		}
		sideNavBar.gotoMyStationsPage();
		getStationFromList(1); // Includes a wait
		if (!driver.getPageSource().contains(station))
			return false;
		return true;
	}

	public void comeToThisPage() {
		driver.findElement(By.name("For You")).click();
	}
}
