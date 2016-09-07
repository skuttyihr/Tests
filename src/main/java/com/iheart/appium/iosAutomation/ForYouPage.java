package com.iheart.appium.iosAutomation;

import java.util.List;

import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.*;

public class ForYouPage extends Page {

	@iOSFindBy(accessibility = "NavBar-SideMenuButton-UIButton") private IOSElement NavBarSideMenuButtonUIButton;
	@iOSFindBy(accessibility = "IHRCastingBarButtonItem-UIButton") private IOSElement IHRCastingBarButtonItemUIButton;
	@iOSFindBy(accessibility = "NavBar-SearchBarButton-UIButton") private IOSElement NavBarSearchBarButtonUIButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]") private IOSElement firstStation;
	// @iOSFindBy(accessibility="Sign in") private WebElement signIn;

	// for search
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]") private IOSElement topHit;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[1]/UIAStaticText[1]") private IOSElement topStation;

	public ForYouPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	public void clickHamburgerButtonToOpenSideMenu(){
		System.out.println("clickHamburgerButtonToOpenSideMenu()...");
		NavBarSideMenuButtonUIButton.click();
	}
	public void clickNavBarSearchButtonToOpenSearch(){
		System.out.println("clickNavBarSearchButtonToOpenSearch()...");
		NavBarSearchBarButtonUIButton.click();
	}
	public void clickCastingBarButtonToConnectADevice(){
		System.out.println("clickCastingBarButtonToConnectADevice()...");
		IHRCastingBarButtonItemUIButton.click();
	}
	
	public boolean isHamburgerButtonDisplayed(){
		boolean isDisp = NavBarSideMenuButtonUIButton.isDisplayed();
		System.out.println("isHamburgerButtonDisplayed() : " + isDisp);
		return isDisp;
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

		miniPlayer.openFullPlayer();
		
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
		miniPlayer.openFullPlayer();
		return myStation;
	}
	
	public String playAndVerifyLiveRadio(IOSDriver<IOSElement> d) {
		Errors errors = new Errors();
		String myStation = playLiveRadio();
		System.out.println("Starting with:" + myStation);
		
		// Verify PLAYER
		errors.add(d, player.verifyPlaybackControls(d, myStation), "playAndVerifyLiveRadio");
		if(!player.doFavorite()){
			errors.add(d, "Could not favorite!\n", "playAndVerifyLiveRadio");
		}
		if(!player.doScan()){
			errors.add(d, "Could not scan!\n", "playAndVerifyLiveRadio");
		}
		if(!player.doThumbUp()){
			errors.add(d, "Could not do thumbs up!\n", "playAndVerifyLiveRadio");
		}
		if(!player.doThumbDown()){
			errors.add(d, "Could not do thumbs down!\n", "playAndVerifyLiveRadio");
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
		//player.back.click();
		fullPlayer.clickDownArrowOnNavBarToMinimizeFullPlayer();
		if(!verifyInForYou(myStation)){
			errors.add(d, "Could not find station: " + myStation + " in my stations page.\n", "playAndVerifyLiveRadio");
		}
		
		return errors.getErrors();
	}
	
	public boolean verifyInForYou(String station){
		if(!isHamburgerButtonDisplayed()){
			//player.back.click();
			fullPlayer.clickDownArrowOnNavBarToMinimizeFullPlayer();
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
