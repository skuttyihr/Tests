package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import com.iheart.appium.utilities.Errors;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CuratedPlaylistPage extends Page{
	
	public CuratedPlaylistPage() {
		super();
	}

	public CuratedPlaylistPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}

	// ***************  Elements   ***************// 
	
	@iOSFindBy(accessibility = "Workout Hits") private IOSElement cPlaylistTitle;
	@iOSFindBy(accessibility = "Top Hits to keep you motivated in the gym") private IOSElement cPlaylistDescription;
	@iOSFindBy(accessibility = "By iHeartRadio • 1 hr 22 min") private IOSElement cPlaylistCurator_Duration;
	@iOSFindBy(accessibility = "pause button") private IOSElement btnPause;
	@iOSFindBy(accessibility = "overflow list") private IOSElement cPlaylistOverflow;
	@iOSFindBy(accessibility = "NavBar-BackButton-UIButton") private IOSElement statusBar;
	@iOSFindBy(className = "XCUIElementTypeImage") private IOSElement cPlaylistCoverArt;
	@iOSFindBy(accessibility = "Shuffle") private IOSElement shuffleButton;
	
	// ***************   Behaviors   ***************//
	/** 
	 * getters
	 * @return IOSElement
	 */
	
	public IOSElement getPauseButton() {
		waitForElementToBeVisible(btnPause, 1);
		return btnPause;
	}
	
	public IOSElement getPlaylistOverflow() {
		waitForElementToBeVisible(cPlaylistOverflow,2);
		return cPlaylistOverflow;
	}
	
	public IOSElement getPlaylistCellSongName(int cellnumber) {
		IOSElement cPlaylistCellSongName = findElement(driver, By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
				+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
				+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/"
				+ "XCUIElementTypeCell[" + cellnumber + "]/XCUIElementTypeStaticText[1]"));
		return cPlaylistCellSongName;				
	}

	public Errors verifyPlaylistProfilePage() {
		Errors err = new Errors();
		if (!printElementName(cPlaylistTitle))
			err.add("Curated Playlist Profile Page Title is not seen.");
		if (!printElementName(cPlaylistDescription))
			err.add("Curated Playlist Profile Page Description is not seen.");
		if (!printElementName(cPlaylistCurator_Duration))
			err.add("Curated Playlist Profile Page Curator and Duration is not seen.");
		if (!printElementName(cPlaylistCoverArt))
			err.add("Curated Playlist Profile Page Cover Art is not seen.");
		if (!printElementName(cPlaylistOverflow))
			err.add("Curated Playlist Profile Page Overflow is not seen.");
		if (!printElementName(shuffleButton))
			err.add("Curated Playlist Profile Page Shuffle button is not seen.");
		if (!printElementName(getPlaylistCellSongName(1)))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(getPlaylistCellSongName(2)))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(getPlaylistCellSongName(3)))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(btnPause))
			err.add("Curated Playlist Profile Page - Play button is in play station as pause button is displayed.");
		return err;	
	}
}

	
	
	
	
	
	


