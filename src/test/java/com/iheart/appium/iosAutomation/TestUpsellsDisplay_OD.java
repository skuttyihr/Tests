/**
 * Objective - Verify upsells are displayed to free and plus users at expected features
 * @author sreekalakutty
 * Verifications:
 * testArtistProfilePageAlbumOverflow_Plus - 
 */
package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.iheart.appium.iosAutomation.TestRoot.ScreenshotRule;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class TestUpsellsDisplay_OD extends TestRoot {

/*

7.	Close upsell
8.	Tap Show All Albums
9.	On album profile page, tap on overflow at individual album
10.	Select ‘save album’
Assert upsell modal is trigerred and has plus and premium buttons activated..
Assert upsell modal has correct text pertaining to saving albums.

 * 	
 */
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
		loginPage.loginWithCredentials("testfree@mail.com", "tester");
		artistProfilePage.gotoArtistProfile("Ed Sheeran");
		artistProfilePage.scrollArtistProfilePageDown();

		//verify upsells are seen on artist profile profile page at album overflows
		try
		{	
			artistProfilePage.getArtistProfileAlbumCellActionsButtonUIButton0().click();
			artistProfileOverflowPage.saveAlbum();
			String upsellAlbumText = upsellPage.getAlbumUpsellText().getText();
			System.out.println("Upsell Text seen : " + upsellAlbumText);
			Assert.assertEquals("Album Upsell should display", "Save any album you want. Try iHeartRadio All Access.",upsellAlbumText );
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premiu subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			artistProfileOverflowPage.closeUpsell();		
			artistProfileOverflowPage.addToPlaylist();
			System.out.println("Artist Profile Page - Album upsell text verified; plus and premium subs buttons are activated for free user.");

			String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
			Assert.assertEquals("Album Upsell should display", "Create unlimited playlists. Try iHeartRadio All Access.",upsellPlaylistText );
				//assert plus and premium subscribe buttons are activated
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", upsellPage.isPlusButtonActive());					
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premiu subs button deactivated", 
				upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile page - Add to Playlist upsell text verified; plus and premium subs buttons are activated for free user.");
			artistProfileOverflowPage.closeUpsell();
			artistProfileOverflowPage.closeOverflow();
			consoleLogEnd(before, true, "Free User - Upsells passed for Artist Profile Page - Albums");

		}
		catch (Exception e){
			//fail the test if upsells are not seen or upsells with correct text are not seen
			Assert.fail("Free User - Artist Profile Page - Album overflow button is not displayed");
			consoleLogEnd(before, false, "Free User - Upsells passed for Artist Profile Page - Albums");

		}
		
		//verify upsells are seen on album profile page
		artistProfilePage.gotoAlbumProfilefromArtistProfilePage();
		try{
			albumProfilePage.clickTrackOverflowOnArtistProfilePage();
			artistProfileOverflowPage.saveSong();
			String upsellText = upsellPage.getSongUpsellText().getText();
			Assert.assertEquals("Song Upsell should display", "Save any song you want. Try iHeartRadio All Access.",upsellText);
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premiu subs button deactivated", 
					upsellPage.isPremiumButtonActive());artistProfileOverflowPage.closeUpsell();
			System.out.println("Album Profile Page - Save Song Upsell text verified; plus and premium subs buttons are activated for free user.");

			artistProfileOverflowPage.addToPlaylist();
			String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
			Assert.assertEquals("Album Upsell should display", "Create unlimited playlists. Try iHeartRadio All Access.",upsellPlaylistText );
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premiu subs button deactivated", 
					upsellPage.isPremiumButtonActive());artistProfileOverflowPage.closeUpsell();
			System.out.println("Album Profile Page - Add to Playlist upsell text verified; plus and premium subs buttons are activated for free user.");

			artistProfileOverflowPage.closeOverflow();	
			consoleLogEnd(before, true, "Free User - Upsells passed for tracks  on Album Profile Page.");
		}
		catch(Exception e){
			Assert.fail("Free User - Album Page from  - Album Profile Page is not displayed");
			consoleLogEnd(before, false, "Free User - Upsells passed for tracks  on Album Profile Page.");
		}	
		
	}
		@Test
		public void testArtistProfilePageAlbumOverflow_Plus(){
			LocalTime before = consoleLogStart(
					"Testing Plus User - Overflow Menus on Artist Profile Page.");			
			loginPage.loginWithCredentials("testplus@mail.com", "tester");
			artistProfilePage.gotoArtistProfile("Ed Sheeran");
			artistProfilePage.scrollArtistProfilePageDown();

			/* 1. verify upsells are seen on artist profile profile page at album overflows
			 * 2. verify only the premium subscription button is active 
			 */
			try
			{	
				artistProfilePage.getArtistProfileAlbumCellActionsButtonUIButton0().click();
				artistProfileOverflowPage.saveAlbum();
				String upsellAlbumText = upsellPage.getAlbumUpsellText().getText();
				System.out.println("Upsell Text seen : " + upsellAlbumText);
				Assert.assertEquals("Album Upsell should display", "Save any album you want. Try iHeartRadio All Access.",upsellAlbumText );
				Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", 
						upsellPage.isPlusButtonActive());	
				Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premiu subs button deactivated", 
						upsellPage.isPremiumButtonActive());
				System.out.println("Artist Profile Page - Album upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");

				artistProfileOverflowPage.closeUpsell();		
				artistProfileOverflowPage.addToPlaylist();
				String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
				Assert.assertEquals("Album Upsell should display", "Create unlimited playlists. Try iHeartRadio All Access.",upsellPlaylistText );
				//To do - assert plus and premium buttons are activated
				Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", 
						upsellPage.isPlusButtonActive());	
				Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premiu subs button deactivated", 
						upsellPage.isPremiumButtonActive());
				System.out.println("Artist Profile Page - Add to Playlist upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");

				artistProfileOverflowPage.closeUpsell();
				artistProfileOverflowPage.closeOverflow();
				consoleLogEnd(before, true, "Free User - Upsells passed for Artist Profile Page - Albums");

			}
			catch (Exception e){
				Assert.fail("Free User - Artist Profile Page - Album overflow button is not displayed");
				consoleLogEnd(before, false, "Free User - Upsells passed for Artist Profile Page - Albums");

			}

			//verify upsells are seen on album profile page
			artistProfilePage.gotoAlbumProfilefromArtistProfilePage();
			try{
				albumProfilePage.clickTrackOverflowOnArtistProfilePage();
				artistProfileOverflowPage.saveSong();
				String upsellText = upsellPage.getSongUpsellText().getText();
				Assert.assertEquals("Song Upsell should display", "Save any song you want. Try iHeartRadio All Access.",upsellText);
				Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", 
						upsellPage.isPlusButtonActive());	
				Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premium subs button deactivated", 
						upsellPage.isPremiumButtonActive());
				System.out.println("Album Profile Page - Save Song upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");
				artistProfileOverflowPage.closeUpsell();			
				artistProfileOverflowPage.addToPlaylist();
				String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();
				Assert.assertEquals("Album Upsell should display", "Create unlimited playlists. Try iHeartRadio All Access.",upsellPlaylistText );
				Assert.assertFalse("Upsell page at 'Album overflow - Add to Playlist' for free user should not have Plus subs button deactivated", 
						upsellPage.isPlusButtonActive());	
				Assert.assertTrue("Upsell page at 'Album overflow - Add to Playlist' for free user should not have Premiu subs button deactivated", 
						upsellPage.isPremiumButtonActive());
				System.out.println("Album Profile Page - Add to Playlist upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");

				artistProfileOverflowPage.closeUpsell();
				artistProfileOverflowPage.closeOverflow();	
				consoleLogEnd(before, true, "Free User - Upsells passed for tracks  on Album Profile Page.");
			}
			catch(Exception e){
				Assert.fail("Free User - Album Page from  - Album Profile Page is not displayed");
				consoleLogEnd(before, false, "Free User - Upsells passed for tracks  on Album Profile Page.");
			}
	}
}	

