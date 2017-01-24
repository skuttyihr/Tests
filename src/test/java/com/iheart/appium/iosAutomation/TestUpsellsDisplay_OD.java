/**
 * Objective - Verify upsells are displayed to free and plus users at expected features
 * @author sreekalakutty
 * Verifications:
 * testArtistProfilePageAlbumOverflow_Plus - 
 */
package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.iheart.appium.iosAutomation.TestRoot.ScreenshotRule;

public class TestUpsellsDisplay_OD extends TestRoot {


	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	
	@Test
	public void testArtistProfilePageAlbumOverflow_Free(){
		
		LocalTime before = consoleLogStart(
				"Testing Free User - Overflow Menus on Artist Profile Page.");			
		//go to Albums on ArtistProfilePage
		loginPage.loginWithCredentials(IHEARTFREEUSERNAME, IHEARTFREEPASSWD);
		artistProfilePage.gotoAlbumsOnArtistProfilePage("Ed Sheeran");
		
		//verify upsells are seen on artist profile profile page at album overflows
		artistProfileOverflowPage.saveAlbum();	
		String upsellAlbumText = upsellPage.getAlbumUpsellText().getText();
		assertAlbumUpsell("Free",upsellAlbumText);
		artistProfileOverflowPage.closeUpsellclickAddToPlaylist();		
		String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
		assertPlaylistUpsell("Free",upsellPlaylistText);
		artistProfileOverflowPage.closeUpsellandOverflow();
		consoleLogEnd(before, true, "Free User - Upsells passed for Artist Profile Page - Albums");	
		
		//verify upsells are seen on albums profile page - track overflow
		artistProfilePage.gotoAlbumProfilePage(0);
		albumProfilePage.clickTrackOverflow();
		artistProfileOverflowPage.saveSong();
		String upsellText = upsellPage.getSongUpsellText().getText();
		assertTrackUpsell("Free", upsellText);		
		upsellPlaylistText = "";
		artistProfileOverflowPage.closeUpsellclickAddToPlaylist();
		upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
		assertPlaylistUpsell("Free", upsellPlaylistText);
		artistProfileOverflowPage.closeUpsellandOverflow();
		consoleLogEnd(before, true, "Free User - Upsells passed for tracks on Album Profile Page.");	
	}
	
	//verify upsells at albums on artist profile page and album profile page for plus user
	@Test
	public void testArtistProfilePageAlbumOverflow_Plus(){
		LocalTime before = consoleLogStart(
				"Testing Plus User - Overflow Menus on Artist Profile Page.");
		loginPage.loginWithCredentials(IHEARTPLUSUSERNAME, IHEARTPLUSPASSWD);
		artistProfilePage.gotoAlbumsOnArtistProfilePage("Ed Sheeran");
		
		//verify upsells are seen on artist profile profile page at album overflows
		artistProfileOverflowPage.saveAlbum();
		String upsellAlbumText = upsellPage.getAlbumUpsellText().getText();
		assertAlbumUpsell("Plus", upsellAlbumText);
		artistProfileOverflowPage.closeUpsellclickAddToPlaylist();
		String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
		assertPlaylistUpsell("Plus", upsellPlaylistText);
		artistProfileOverflowPage.closeUpsellandOverflow();
		consoleLogEnd(before, true, "Plus User - Upsells passed for Artist Profile Page - Albums");

		//verify upsells are seen on albums profile page - track overflow
		artistProfilePage.gotoAlbumProfilePage(0);
		albumProfilePage.clickTrackOverflow();
		artistProfileOverflowPage.saveSong();
		String upsellText = upsellPage.getSongUpsellText().getText();	
		assertTrackUpsell("Plus", upsellText);		
		upsellPlaylistText="";		
		artistProfileOverflowPage.closeUpsellclickAddToPlaylist();
		upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
		assertPlaylistUpsell("Plus", upsellPlaylistText);
		artistProfileOverflowPage.closeUpsellandOverflow();
		consoleLogEnd(before, true, "Plus User - Upsells passed for tracks  on Album Profile Page.");
	}

		
	/*	 sk - 11/21 - adding in methods to assert upsell text and various button states - as per PR review
		also keeping the assert methods on the test page
	*/
	public void assertAlbumUpsell(String type,String text) {
		if (type == "Free") {
			Assert.assertEquals("Album Upsell should display", "Save any album you want. Try iHeartRadio All Access.", text );
			Assert.assertTrue("Upsell page at 'Album overflow - Save Album' for free user should not have Plus subs button deactivated", 
				upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Album' for free user should not have Premium subs button deactivated", 
				upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile Page - Album upsell text verified; plus and premium subs buttons are activated for free user.");
		}
		else if (type == "Plus") {
			Assert.assertEquals("Album Upsell should display", "Save any album you want. Try iHeartRadio All Access.", text);
			Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for plus user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for plus user should not have Premiu subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile Page - Album upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");
		}
		
	}
	
	//sk - 11/21
	public void assertPlaylistUpsell(String type,String text) {
		if (type == "Free") {
			Assert.assertEquals("Album Upsell should display", "Create unlimited playlists. Try iHeartRadio All Access.", text );	
			//assert plus and premium subscribe buttons are activated
			Assert.assertTrue("Upsell page at 'Album overflow - Add to Playlist' for free user should not have Plus subs button deactivated", upsellPage.isPlusButtonActive());					
			Assert.assertTrue("Upsell page at 'Album overflow - Add to Playlist' for free user should not have Premium subs button deactivated", upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile page - Add to Playlist upsell text verified; plus and premium subs buttons are activated for free user.");				
			
		}
		else if (type == "Plus") {
			Assert.assertEquals("Album Upsell should display", "Create unlimited playlists. Try iHeartRadio All Access.", text );
			//To do - assert plus and premium buttons are activated
			Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for plus user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for plus user should not have Premium subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile Page - Add to Playlist upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");
		}
	}
	
	//sk - 11/21
	public void assertTrackUpsell(String type, String text) {
		if (type == "Free") {
			Assert.assertEquals("Song Upsell should display", "Save any song you want. Try iHeartRadio All Access.",text);
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premium subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			System.out.println("Album Profile Page - Save Song Upsell text verified; plus and premium subs buttons are activated for free user.");		
		}
		else if (type == "Plus") {
			Assert.assertEquals("Song Upsell should display", "Save any song you want. Try iHeartRadio All Access.",text);
			Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for plus user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for plus user should not have Premium subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			System.out.println("Album Profile Page - Save Song upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");			
		}
		
	}
	
}	

