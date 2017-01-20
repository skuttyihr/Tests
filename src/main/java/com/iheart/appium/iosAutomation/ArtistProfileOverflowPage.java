/**
 * Objective - Page to store the elements in the overflow menu of elements on the Artist Profile page
 * @author sreekalakutty
 *
 */


package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ArtistProfileOverflowPage extends Page{

	@iOSFindBy(id="Save Song") private IOSElement saveSongButton;
	@iOSFindBy(id="Add to Playlist") private IOSElement addToPlaylistButton;
	@iOSFindBy(id="Save Album") private IOSElement saveAlbumButton;
	@iOSFindBy(id="upsell close") private IOSElement closeUpsellButton;
	@iOSFindBy(id="Cancel") private IOSElement closeOverflow;	

	public ArtistProfileOverflowPage(){
		super();
	}
	
	public ArtistProfileOverflowPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
		
	public void saveSong() {
		waitForElementToBeVisible(saveSongButton, 2);
		saveSongButton.click();
	}

	/**
	 */
	public void addToPlaylist() {
		waitForElementToBeVisible(addToPlaylistButton, 2);
		addToPlaylistButton.click();
	}

	/**
	 * sk-1/15 close upsell
	 */
	public void closeUpsell() {
		closeUpsellButton.click();
	}
	
	/**
	 * sk-1/15 - close overflow
	 */
	public void closeOverflow() {
		closeOverflow.click();
	}

	/**
	 * sk-1/15 - save album from artist profile overflow 
	 */
	public void saveAlbum() {
		waitForVisible(driver, By.id("Save Album"), 5).click();
		//saveAlbumButton.click();
	}
	
}

