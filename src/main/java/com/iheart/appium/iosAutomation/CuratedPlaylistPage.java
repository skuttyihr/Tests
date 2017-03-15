package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import com.iheart.appium.utilities.Errors;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

/** 
 * @author skutty - 2/12 - Curated Playlist Page Objects
 * Tests - verify curated playlist profile page, verify profile page overflow for plus users
 * Login as plus user. Search for 'pop ', scroll down to Playlists - select a playlist. At a track, tap on overflow menu. 
 */

public class CuratedPlaylistPage extends Page{
	
	public CuratedPlaylistPage() {
		super();
	}

	public CuratedPlaylistPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}

	// ***************  Elements   ***************// 
	
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
	private IOSElement cPlaylistTitle;	
	@iOSFindBy(accessibility = "Top Hits to keep you motivated in the gym") private IOSElement cPlaylistDescription;
	@iOSFindBy(xpath = "By iHeartRadio /.*") private IOSElement cPlaylistCurator_Duration;
	@iOSFindBy(id = "pause button") private IOSElement btnPause;
	@iOSFindBy(accessibility = "overflow list") private IOSElement cPlaylistOverflow;
	@iOSFindBy(accessibility = "NavBar-BackButton-UIButton") private IOSElement statusBar;
	@iOSFindBy(className = "XCUIElementTypeImage") private IOSElement cPlaylistCoverArt;
	@iOSFindBy(accessibility = "Shuffle") private IOSElement shuffleButton;
	@iOSFindBy(accessibility = "overflow list") private IOSElement cPlaylistProfilePageOverflow;
	@iOSFindBy(accessibility = "Track Overflow") private IOSElement cPlaylistProfileTrackOverflow;
	@iOSFindBy(accessibility = "Save Playlist") private IOSElement cPlaylistProfilePageOverflowMenuSavePlaylist;
	@iOSFindBy(accessibility = "Share") private IOSElement cPlaylistProfilePageOverflowMenuShare;
	@iOSFindBy(accessibility = "Cancel") private IOSElement cPlaylistProfilePageOverflowMenuCancel;
	@iOSFindBy(accessibility = "Learn More") private IOSElement cPlaylistProfilePageLearnMoreButton;
	@iOSFindBy(accessibility = "Save Song") private IOSElement cPlaylistProfilePageTrackOverflowSaveSong;
	@iOSFindBy(accessibility = "Add to Playlist") private IOSElement cPlaylistProfilePageTrackOverflowAddtoPlaylist;
	@iOSFindBy(accessibility = "Go to Artist") private IOSElement cPlaylistProfilePageTrackOverflowGotoArtist;
	@iOSFindBy(accessibility = "Go to Album") private IOSElement cPlaylistProfilePageTrackOverflowGotoAlbum;
	@iOSFindBy(accessibility = "Share") private IOSElement cPlaylistProfilePageOverflowShare;
	@iOSFindBy(accessibility = "Reminders") private IOSElement cPlaylistProfilePageShareModalElement;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeCollectionView") private IOSElement shareModal;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[3]") 
	private IOSElement curatedByAndDurationText;
	

	// ***************  Behaviors  ***************//
	/** 
	 * sk - 2/24
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
	
	/**
	 * sk - cellnumbers for tracks starts from 2
	 * @param cellnumber
	 * @return
	 */
	public IOSElement getPlaylistCellSongName(int cellnumber) {
		IOSElement cPlaylistCellSongName = waitForVisible(driver, By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
		+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
		+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[" + cellnumber + "]"), 3);
		return cPlaylistCellSongName;				
	}

	public IOSElement getTrackOverflow(int cellnumber) {
		IOSElement cPlaylistTrackOverflow = findElement(driver, By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[2]/"
				+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
				+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/"
				+ "XCUIElementTypeCell[" + 	cellnumber + "]/XCUIElementTypeButton[1]"));
		return cPlaylistTrackOverflow;				
	}

	public void clickShare() {
		if (waitForElementToBeVisible(cPlaylistProfilePageOverflowShare, 5)) {
			cPlaylistProfilePageOverflowShare.click();
			System.out.println("Share button clicked.");
		}
	}

	public Errors verifyPlaylistProfilePage() {
		Errors err = new Errors();
		//System.out.println(cPlaylistTitle.getText());
		waitForVisible(driver, By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
				+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
				+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]"), 5);
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
		if (!printElementName(getPlaylistCellSongName(2)))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(getPlaylistCellSongName(3)))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(getPlaylistCellSongName(4)))
			err.add("Curated Playlist Profile Page - cells are not showing tracks.");
		if (!printElementName(btnPause))
			err.add("Curated Playlist Profile Page - Pause state play button is not displayed, as cur playlist stn should have started streamining on search and play.");
		return err;	
	}

	public Errors verifyPlaylistProfilePageOverflow(String subscription) {
		Errors err = new Errors();
		if (waitForElementToBeVisible(cPlaylistProfilePageOverflow, 3))
			cPlaylistProfilePageOverflow.click();
		if (waitForElementToBeVisible(cPlaylistProfilePageOverflowMenuSavePlaylist, 3)) {
			cPlaylistProfilePageOverflowMenuSavePlaylist.click();
			System.out.println("verifyPlaylistProfilePageOverflow(): Save Playlist clicked");
		}
		else {
			err.add("Curated Playlist profile page Save Playlist option in page overflow menu is not displayed.");
			return err;
		}
		if (!appboyUpsellsPage.isUpsellDisplayed()) {
			err.add("Upsell was not displayed to Plus user on Save Playlist from curated playlist page overflow.");
			return err;
		}
		appboyUpsellsPage.closeUpsell();
		clickShare();
		if (!isVisible(shareModal) && !(isVisible(cPlaylistProfilePageShareModalElement)))
			err.add("Curated Playlist page overflow - share option did not display the share modal.");
		return err;
	}	
}


	
	
	
	
	
	


