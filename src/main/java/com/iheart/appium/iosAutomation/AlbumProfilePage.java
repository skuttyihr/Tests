/**
 * Objective - Page object to store the elements in the overflow menu of elements on the Album Profile page
 * @author sreekalakutty
 *
 */

package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AlbumProfilePage extends Page{

	//@iOSFindBy(accessibility="ArtistProfileTrackCell-ActionsButton-UIButton-0") private IOSElement ArtistProfileTrackCellActionsButtonUIButton0;
	@iOSFindBy(id="Save Track") private IOSElement saveTrackButton;

	public AlbumProfilePage(){
		super();
	}
	public AlbumProfilePage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	public void clickTrackOverflow(){
		artistProfilePage.getArtistProfileTrackCellActionsButtonUIButton0().click();
	}	

	public void saveTrack() {
		saveTrackButton.click();
	}
}
