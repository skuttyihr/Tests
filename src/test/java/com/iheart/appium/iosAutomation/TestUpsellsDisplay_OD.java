/**
 * Objective - Verify upsells are displayed to free and plus users at expected features
 * @author sreekalakutty
 * Verifications:
 * testArtistProfilePageAlbumOverflow_Plus - 
 */
package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.iheart.appium.utilities.TestRoot;

public class TestUpsellsDisplay_OD extends TestRoot {


	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	
	//@Test
	public void testArtistProfilePageAlbumOverflow_Free(){
		
		LocalTime before = consoleLogStart(
				"Testing Free User - Overflow Menus on Artist Profile Page.");			
		//go to Albums on ArtistProfilePage
		loginPage.loginWithCredentials(IHEARTFREEUSERNAME, IHEARTFREEPASSWD);
		artistProfilePage.gotoAlbumsOnArtistProfilePage("Ed Sheeran");
		
		//verify upsells are seen on artist profile profile page at album overflows
		artistProfileOverflowPage.saveAlbum();	
		String upsellAlbumText = upsellPage.getAlbumUpsellText().getText();
		upsellPage.assertAlbumUpsell("Free",upsellAlbumText);
		artistProfileOverflowPage.closeUpsellclickAddToPlaylist();		
		String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
		upsellPage.assertPlaylistUpsell("Free",upsellPlaylistText);
		artistProfileOverflowPage.closeUpsellandOverflow();
		consoleLogEnd(before, true, "Free User - Upsells passed for Artist Profile Page - Albums");	
		
		//verify upsells are seen on albums profile page - track overflow
		artistProfilePage.gotoAlbumProfilePage(0);
		albumProfilePage.clickTrackOverflow();
		artistProfileOverflowPage.saveSong();
		String upsellText = upsellPage.getSongUpsellText().getText();
		upsellPage.assertTrackUpsell("Free", upsellText);		
		upsellPlaylistText = "";
		artistProfileOverflowPage.closeUpsellclickAddToPlaylist();
		upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
		upsellPage.assertPlaylistUpsell("Free", upsellPlaylistText);
		artistProfileOverflowPage.closeUpsellandOverflow();
		consoleLogEnd(before, true, "Free User - Upsells passed for tracks on Album Profile Page.");	
	}
	
	//verify upsells at albums on artist profile page and album profile page for plus user
	//@Test
	public void testArtistProfilePageAlbumOverflow_Plus(){
		LocalTime before = consoleLogStart(
				"Testing Plus User - Overflow Menus on Artist Profile Page.");
		loginPage.loginWithCredentials(IHEARTPLUSUSERNAME, IHEARTPLUSPASSWD);
		artistProfilePage.gotoAlbumsOnArtistProfilePage("Ed Sheeran");
		
		//verify upsells are seen on artist profile profile page at album overflows
		artistProfileOverflowPage.saveAlbum();
		String upsellAlbumText = upsellPage.getAlbumUpsellText().getText();
		upsellPage.assertAlbumUpsell("Plus", upsellAlbumText);
		artistProfileOverflowPage.closeUpsellclickAddToPlaylist();
		String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
		upsellPage.assertPlaylistUpsell("Plus", upsellPlaylistText);
		artistProfileOverflowPage.closeUpsellandOverflow();
		consoleLogEnd(before, true, "Plus User - Upsells passed for Artist Profile Page - Albums");

		//verify upsells are seen on albums profile page - track overflow
		artistProfilePage.gotoAlbumProfilePage(0);
		albumProfilePage.clickTrackOverflow();
		artistProfileOverflowPage.saveSong();
		String upsellText = upsellPage.getSongUpsellText().getText();	
		upsellPage.assertTrackUpsell("Plus", upsellText);		
		upsellPlaylistText="";		
		artistProfileOverflowPage.closeUpsellclickAddToPlaylist();
		upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
		upsellPage.assertPlaylistUpsell("Plus", upsellPlaylistText);
		artistProfileOverflowPage.closeUpsellandOverflow();
		consoleLogEnd(before, true, "Plus User - Upsells passed for tracks  on Album Profile Page.");
	}
		
	/*	 sk - 11/21 - adding in methods to assert upsell text and various button states - as per PR review
		also keeping the assert methods on the test page
	*/		
}	

