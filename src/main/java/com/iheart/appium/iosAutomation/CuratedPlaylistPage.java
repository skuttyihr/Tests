package com.iheart.appium.iosAutomation;

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
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/"
			+ "XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]")
			private IOSElement cPlaylistCell1SongName;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/"
			+ "XCUIElementTypeCell[3]/XCUIElementTypeStaticText[1]")
			private IOSElement cPlaylistCell2SongName;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/"
			+ "XCUIElementTypeCell[4]/XCUIElementTypeStaticText[1]")
			private IOSElement cPlaylistCell3SongName;
	
	
	
	// ***************   Behaviors   ***************//
	/** 
	 * getters
	 * @return IOSElement
	 */
	
	public IOSElement getPauseButton() {
		return waitForVisible(btnPause, 1);
	}
	
	public IOSElement getPlaylistOverflow() {
		return waitForVisible(btnPause, 1);
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
		if (!printElementName(cPlaylistCell1SongName))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(cPlaylistCell2SongName))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(cPlaylistCell3SongName))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(btnPause))
			err.add("Curated Playlist Profile Page - Play button is in play station as pause button is displayed.");
		return err;	
	}
}
			



	
	
	
	
	
	


