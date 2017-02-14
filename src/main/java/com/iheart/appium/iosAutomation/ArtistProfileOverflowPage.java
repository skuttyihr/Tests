/**
 * Objective - Page to store the elements in the overflow menu of elements on the Artist Profile page
 * @author sreekalakutty
 *
 */


package com.iheart.appium.iosAutomation;

import com.iheart.appium.utilities.*;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ArtistProfileOverflowPage extends Page{

	@iOSFindBy(id="Save Song") private IOSElement saveSongButton;
	@iOSFindBy(id="Add to Playlist") private IOSElement addToPlaylistButton;
	@iOSFindBy(id="Save Album") private IOSElement saveAlbumButton;
	@iOSFindBy(id="upsell close") private IOSElement closeUpsellButton;
	@iOSFindBy(id="Cancel") private IOSElement closeOverflowButton;	

	public ArtistProfileOverflowPage(){
		super();
	}
	
	public ArtistProfileOverflowPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
		
	public Errors saveSong() {
		Errors err = new Errors();
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
		Errors err = new Errors();
		if (waitForElementToBeVisible(addToPlaylistButton, 2)){
			addToPlaylistButton.click();
			System.out.println("Click Add to Playlist");
		}		
		else{
			err.add("Could not click Add to Playlist, button was not visible", "addToPlaylist");
		}
		return err;
	}
			
	/**
	 * sk-1/15 close upsell
	 */
	public Errors closeUpsellandOverflow() {
		Errors err = new Errors();
		err.add(closeUpsell());
		err.add(closeOverflow());	
		return err;
	}
	
	public Errors closeUpsell(){
		Errors err = new Errors();
		if (closeUpsellButton != null && isVisible(closeUpsellButton)){ 
			closeUpsellButton.click();
		}
		else
			err.add("Close Upsell Button was not visible.", "closeUpsell");
		return err;
	}
	
	public Errors closeUpsellclickAddToPlaylist(){
		Errors err = new Errors();
		err.add(closeUpsell());
		err.add(addToPlaylist());
		return err;
	}
	
	/**
	 * sk-1/15 - close overflow
	 */
	public Errors closeOverflow() {
		Errors err = new Errors();
		if (closeOverflowButton != null && isVisible(closeOverflowButton)){
			closeOverflowButton.click();
		}
		else
			err.add("Close Overflow Button was not visible.", "closeOverflow");
		return err;
	}

	/**
	 * sk-1/15 - save album from artist profile overflow 
	 */
	public Errors saveAlbum(){
		Errors err = new Errors();
		if (artistProfilePage.getArtistProfileAlbumCellActionsButtonUIButton0() != null){
			artistProfilePage.getArtistProfileAlbumCellActionsButtonUIButton0().click();
		}
		else
			err.add("Overflow button was not visible at Album on Artist Profile Page","saveAlbum" );
		if (waitForElementToBeVisible(saveAlbumButton, 2)){
				saveAlbumButton.click();
		}
		else
			err.add("Could not save song, button was not visible.", "saveAlbum");
		return err;
	}
	
}

