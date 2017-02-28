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
	
	//@iOSFindBy(accessibility = "Workout Hits") private IOSElement cPlaylistTitle;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]") private IOSElement cPlaylistTitle;	
	@iOSFindBy(accessibility = "Top Hits to keep you motivated in the gym") private IOSElement cPlaylistDescription;
	@iOSFindBy(xpath = "By iHeartRadio /.*") private IOSElement cPlaylistCurator_Duration;
	@iOSFindBy(id = "pause button") private IOSElement btnPause;
	@iOSFindBy(accessibility = "overflow list") private IOSElement cPlaylistOverflow;
	@iOSFindBy(accessibility = "NavBar-BackButton-UIButton") private IOSElement statusBar;
	@iOSFindBy(className = "XCUIElementTypeImage") private IOSElement cPlaylistCoverArt;
	@iOSFindBy(accessibility = "Shuffle") private IOSElement shuffleButton;
	@iOSFindBy(accessibility = "Stronger") private IOSElement firstTrack;
	@iOSFindBy(accessibility = "Rock Your Body") private IOSElement secondTrack;
	@iOSFindBy(accessibility = "'Till I Collapse") private IOSElement thirdTrack;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeStaticText[1]]")
	private IOSElement curatedByAndDurationText;

	// ***************  Behaviors  ***************//
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
		waitForElementToBeVisible(cPlaylistDescription, 3);
		if (!printElementName(cPlaylistTitle))
			err.add("Curated Playlist Profile Page Title is not seen.");
		if (!printElementName(cPlaylistDescription))
			err.add("Curated Playlist Profile Page Description is not seen.");
		if (!printElementName(curatedByAndDurationText))
			err.add("Curated Playlist Profile Page Curator and Duration is not seen.");
		if (!printElementName(cPlaylistCoverArt))
			err.add("Curated Playlist Profile Page Cover Art is not seen.");
		if (!printElementName(cPlaylistOverflow))
			err.add("Curated Playlist Profile Page Overflow is not seen.");
		if (!printElementName(shuffleButton))
			err.add("Curated Playlist Profile Page Shuffle button is not seen.");
		if (!printElementName(firstTrack))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(secondTrack))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(thirdTrack))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(btnPause))
			err.add("Curated Playlist Profile Page - Play button is in play station as pause button is displayed.");
		return err;	
	}
}

	
	
	
	
	
	


