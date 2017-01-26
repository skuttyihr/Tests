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

	@iOSFindBy(id="Save Track") private IOSElement saveTrackButton;

	public AlbumProfilePage(){
		super();
	}
	public AlbumProfilePage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	public void clickTrackOverflow(){
		if (artistProfilePage.getArtistProfileTrackCellActionsButtonUIButton0() != null)
			artistProfilePage.getArtistProfileTrackCellActionsButtonUIButton0().click();
	}	

	public void saveTrack() {
		Errors err = new Errors();
		if (isVisible(saveTrackButton))
			saveTrackButton.click();
		else
			err.add("Save Song button was not visible.", "saveTrack");			
	}
}
