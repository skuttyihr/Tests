
/**
 * @author skutty
 * iOS flagship app switched to Appboy Upsells in Feb 2017.
 * Test objective are to verify that when a Free or Plus user clicks on certain features, they are presented and upsell. The upsell should be tested for
 * 1. Upsell Headline - the headline on the upsell should match with the expected value on the upsell page
 * 2. If the user is Free and trial eligible - then the upsell buttons should show 'Start 30 day Free Trial' text for both Plus and AllAccess 
 *    subscription buttons, both the buttons should be enabled and connect to AppStore.
 * 3. If the user is Free and trial expired - then the upsell should show 'Subscribe To <Plus/All Access>' text for both Plus and AllAccess 
 *    subscription buttons, both the buttons should be enabled and connect to AppStore.
 * 4. If the user is Plus - then the upsell should show 'Subscribe To All Access' text for the AllAccess 
 *    subscription buttons, only the All Access button should be enabled and connect to AppStore.
 */

package com.iheart.appium.iosAutomation;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.iheart.appium.utilities.Errors;
import com.iheart.appium.utilities.TestRoot;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class TestAppboyUpsells extends TestRoot {
	
	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	// ************************************* Upsells - Replay (Player) ***********************************//
	
	/**
	 * Naming convention for expected upsell headline - page_element_overflow option - where the upsell occurs	
	 * sk - 2/27 -Test unlimited skips upsell shows for FREE TRIAL ELIGIBILE user on ARTIST radio
	 */
	@Test
	public void testPlayerSkipLimitUpsell_UPS1_FREE_TRLELG() {
		LocalTime before = consoleLogStart("Testing artist radio unlimited skip upsell UPS1_FREE_TRLELG");
		Errors err = new Errors();
		err.add(playStationOpenFullPlayer("FREE",true,"Ed Sheeran"));
		fullPlayer.skipToTheLimit();
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(artistRadioFullPlayer_Skip));	
		Assert.assertTrue("Upsell headline test for artist radio unlimited skips for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellButtonStates("FREE", true, "skip"));
		Assert.assertTrue("Buttons state test for artist radio unlimited skips for free user failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio Unmlimited Skips Upsell for Free TrialEligible User");	
	}
	
	
	/**
	 * sk - 2/27 -Test replay upsell shows for FREE NON-TRIAL ELIGIBILE user on LIVE radio
	 */
	@Test
	public void testPlayerReplayUpsell_UPS2_FREE_TRLEXP() {
		LocalTime before = consoleLogStart("Testing live radio replay upsell_UPS2_FREE_TRLEXP");
		Errors err = new Errors();
		err.add(playStationOpenFullPlayer("FREE",false,"Luke Bryan"));
		err.add(fullPlayer.clickReplayButtonToOpenReplayModal());
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(liveRadioFullPlayer_Replay));	
		Assert.assertTrue("Upsell headline test for artist radio replay for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellButtonStates("FREE", false,"replay"));
		Assert.assertTrue("Buttons state test for artist radio replay for free user failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Live Radio Replay Upsell for Free Non Trial Eligible User");	
	}

	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// sk - 2/24 - helper methods - placing them at the bottom of the page, so as to keep focus on the tests at the top.	
	public Errors playStationOpenFullPlayer(String subscriptionType, boolean isTrialEligible, String stationName) {
		Errors err = new Errors();
		login(subscriptionType, isTrialEligible);
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.searchAndPlayTopResults(stationName);
		err.add(miniPlayer.openFullPlayer());
		System.out.println("Full player opened, playing " + stationName + " Radio");
		return err;
	}
	
	public void login(String subscriptionType, boolean isTrialEligible)  {
		if (subscriptionType.equals("FREE") && isTrialEligible ==  true)
			loginPage.loginVerifyEntitlement(IHEARTFREEUSERNAME, IHEARTFREEPASSWD,"FREE");
		else if(subscriptionType.equals("FREE") && isTrialEligible ==  false)
			loginPage.loginVerifyEntitlement("plustrial@mail.com", "tester","FREE");
		else if(subscriptionType.equals("PLUS") && isTrialEligible == false)
			loginPage.loginVerifyEntitlement(IHEARTPLUSUSERNAME, IHEARTPLUSPASSWD, "PLUS");
		else
			loginPage.loginVerifyEntitlement(IHEARTPREMIUMUSERNAME, IHEARTPREMIUMPASSWD, "ALLA");
	}

	/**
	 * sk - 2/27 - Upsell headlines as expected
	 * Naming convention - page_element_overflowoption - where the upsell occurs	artistRadioFullPlayer_Replay
	 * Adding this at the bottom of the page, so as to have the tests in focus at the top of the page.
	 */	
	String albumProfilePage_HeaderOverflow_AddtoPlaylist = "Add this album to your own playlist with iHeartRadio All Access.";
	String allAlbumsPage_AlbumOverflow_AddtoPlaylist = "Create unlimited playlists. Try iHeartRadio All Access.";
	String artistProfilePage_AlbumOverflow_AddtoPlaylist = "Create unlimited playlists. Try iHeartRadio All Access.";
	String fullPlayer_SaveButton_AddtoPlaylist = "Create unlimited playlists. Try iHeartRadio All Access.";
	String myPlaylistPlayer_SaveButton_AddtoAnotherPlaylist = "Create unlimited playlists. Try iHeartRadio All Access.";
	String cPlaylistPlayer_SaveButton_AddtoAnotherPlaylist = "Create unlimited playlists. Try iHeartRadio All Access.";
	String albumProfilePage_SongOverflow_AddtoPlaylist = "Create unlimited playlists. Try iHeartRadio All Access.";
	String artistProfilePage_TopSongsOverflow_AddtoPlaylist = "Create unlimited playlists. Try iHeartRadio All Access."; 
	String albumProfilePage_PlayButton = "Play the whole album with iHeartRadio All Access.";
	String cPlaylistPage_HeaderOverflow_SavePlaylist = "Save this playlist to your collection. Try iHeartRadio All Access.";
	String myPlaylist_TrackOverflow_AddtoPlaylist = "Create your own playlists. Try iHeartRadio All Access.";
	String myPlaylist_HeaderOverflow_AddtoAnotherPlaylist = "Save this playlist to your collection. Try iHeartRadio All Access.";
	String myPlaylist_PlaylistOverflow_Edit = "Get more out of your playlist with iHeartRadio All Access.";
	String myPlaylist_HeaderOverflow_Edit = "Get more out of your playlist with iHeartRadio All Access.";
	String myPlaylist_TrackOverflow_RemoveFromPlaylist = "Get more out of your playlist with iHeartRadio All Access.";
	String artistRadioFullPlayer_Skip = "Unlimited skips. Try iHeartRadio Plus to enjoy as many as you want.";
	String myMusicPivot_Songs = "Access your music library and create unlimited playlists.";
	String myMusicPivot_Albums = "Access your music library and create unlimited playlists.";
	String myMusicPivot_Artists = "Access your music library and create unlimited playlists.";
	String myMusicPivot_CreateNew = "Access your music library and create unlimited playlists.";
	String myPlaylist_Offlinetoggle = "Listen offline, without a connection. Try iHeartRadio All Access.";
	String liveRadioFullPlayer_Replay = "Encore! Instantly replay songs on the radio with iHeartRadio Plus.";
	String artistRadioFullPlayer_Replay = "Encore! Instantly replay songs on the radio with iHeartRadio Plus.";
	String albumProfilePage_HeaderOverflow_SaveAlbum = "Save this album to your music library with iHeartRadio All Access.";
	String allAbumsPage_AlbumOverflow_SaveAlbum = "Save any album you want. Try iHeartRadio All Access.";
	String artistProfilePage_AlbumSectionAlbumOverflow_SaveAlbum = "Save any album you want. Try iHeartRadio All Access.";
	String albumProfilePage_TrackOverflow_SaveSong = "Save any song you want. Try iHeartRadio All Access.";
	String artistProfilePage_TopSongsOverflow_SaveSong = "Save any song you want. Try iHeartRadio All Access.";
	String cPlaylistPage_TrackOverflow_SaveSong = "Save any song you want. Try iHeartRadio All Access.";
	String myPlaylist_ShuffleButton = "Want to shuffle your playlist? Try iHeartRadio All Access.";
	@iOSFindBy(id="Save any album you want. Try iHeartRadio All Access.") private IOSElement albumUpsellText;
	@iOSFindBy(id="Save any song you want. Try iHeartRadio All Access.") private IOSElement songUpsellText;
	@iOSFindBy(id="Create unlimited playlists. Try iHeartRadio All Access.") private IOSElement addToPlaylistUpsellText;
	@iOSFindBy(id="Encore! Instantly replay songs on the radio with iHeartRadio Plus.") private IOSElement replaySongsUpsellText;
	
}
