package com.iheart.appium.iosAutomation;

import org.junit.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PerfectForPage extends Page {
	@iOSFindBy(name = "Perfect For") private IOSElement perfectFor;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]") private IOSElement firstElement;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]") private IOSElement firstStation;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]") private IOSElement firstStationLink; // to get its name

	// LOGIN PROMPT
	@iOSFindBy(name = "Sign up for Free") private IOSElement signUpPrompt;
	@iOSFindBy(name = "Create Account") private IOSElement createAccount;

	public PerfectForPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}

	protected void playAstation() {
		perfectFor.click();
		sleep(2000);
		firstElement.click();
		sleep(2000);
		firstStation.click();
	}

	private String playACustomStation() {
		searchField.sendKeys("Swift");
		sleep(15000);
		sleep(2000);
		String chosenStation = firstStationLink.getText();
		System.out.println("Chosen station:" + chosenStation);
		firstStationLink.click();
		sleep(5000);
		sleep(2000);

		return chosenStation;
	}

	public void playCustomStation() {
		String chosenStation = "";
		waitForElementToBeVisible(perfectFor, 10);
		perfectFor.click();
		if (isRealDevice)
			sleep(5000);
		else
			sleep(1000);

		chosenStation = playACustomStation();
		// verify that it is playing: Get its attribute: class shall be 'pause'
		if (!player.isPlaying("artist"))
			Assert.fail("Station is not playing.");

		// Stop the station

		// Verify it is the first under My Station -> Recent Stations
		// Click on top Bake
		player.back.click();
		cancel.click();
		myStations.click();
		if (isRealDevice)
			sleep(5000);
		sleep(1500);
		// String firstStation =
		// driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]")).getText();
		// System.out.println("Recent stations:" + firstStation);
		if (!driver.getPageSource().contains(chosenStation))
			Assert.fail("Newly played custom station is not added under my Recent Stations.");

		// logout
		sideNavigationBar.gotoSettings();
		sideNavigationBar.logout();

		// Vefiry Login prompt
		sideNavigationBar.gotoHomePage();
		perfectFor.click();
		// playAstation();
		playACustomStation();
		// verify that login prompt is popped up
		if (!isElementVisible(createAccount))
			Assert.fail("No login prompt is displayed for signed out users.");

	}

}
