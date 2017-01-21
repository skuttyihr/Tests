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
		
	public Errors saveSong() {
		if (waitForElementToBeVisible(saveSongButton, 2)){
				saveSongButton.click();
		}
		else{
			err.add("Could not save song, button was not visible.", "saveSong");
		}
		return err;		
	}

	/**
	 */
	public Errors addToPlaylist() {
		if (waitForElementToBeVisible(addToPlaylistButton, 2)){
			addToPlaylistButton.click();
		}		
		else{
			err.add("Could not click Add to Playlist, button was not visible", "addToPlaylist");
		}
		return err;
	}
			
	/**
	 * sk-1/15 close upsell
	 */
	public void closeUpsellandOverflow() {
		closeUpsellButton.click();
		closeOverflow.click();
	}
	
	public void closeUpsell(){
		closeUpsellButton.click();
	}
	
	public void closeUpsellclickAddToPlaylist(){
		closeUpsellButton.click();
		addToPlaylistButton.click();
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
	public Errors saveAlbum(){
		artistProfilePage.getArtistProfileAlbumCellActionsButtonUIButton0().click();
		if (waitForElementToBeVisible(saveAlbumButton, 2)){
				saveAlbumButton.click();
		}
		else
			err.add("Could not save song, button was not visible.", "saveAlbum");
		return err;
	}
	
}

