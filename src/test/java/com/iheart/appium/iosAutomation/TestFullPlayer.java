package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;

import com.iheart.appium.utilities.TestRoot;
import com.iheart.appium.utilities.TestRoot.Stable;

public class TestFullPlayer extends TestRoot {

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}

	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	@Rule
	public RetryRule retry = new RetryRule(1);
	
	/**
	 * 1. Login with Free user, Search for an Artist, Click Top Result, open Full Player, Show all elements.
	 * Verify Nav Bar Elements - Down Arrow, Favorite Button, Share Button, Cast Button
		Verify Slider elements - Position Label, Duration Label, Progress Slider, Image
		Click More Info -
		Verify Option Menu elements - Views, Buy Song, Lyrics, Go To Artist Profile, Cancel Button
		Verify Album art, title, subtitle at top of option menu in Metadata. 
		Click Lyrics Button if it is enabled
		Track name, artist name, and lyrics themselves appear with a back button
		Click Back Button or Cancel button.
		Verify Station Name and Type match the station originally played.
		Verify Background View
		Verify Slider, PlayButton, Forward, More, Thumb Down, Thumb Up, Title (track), Subtitle (artist)
	 */
	@Test
	@Category(Stable.class)
	public void testFullPlayer_FPLAY1_FREE() {
		LocalTime before = consoleLogStart("Testing testFullPlayer_FPLAY1_FREE");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test66@Test.com", "test", "FREE"));
		homePage.clickNavBarSearchButtonToOpenSearch();
		// New accounts start a Full Player
		searchPage.enterTextIntoSearchBar("Opeth");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.showAllElements();
		consoleLogEnd(before, true, "Tested testFullPlayer_FPLAY1_FREE");
	}

	/**
	 * 	1. Login, Search for an Artist, click Top Result, Open Full Player
		2. Minimize FullPlayer to MiniPlayer (Click Down Arrow)
		3. Open FullPlayer, Check type of Play Button
		4. Verify Thumbs Up and Down functionality
		5. Click the Share button, Click Cancel button on the Share.
		6. Check the Progress Slider makes sense, Check Artist, Station Type
		7. Use the Skip button and ensure the count goes down each skip
		8. Try the Casting Button and the Favorite Button
	 *  Verify that Artist Radio starts and you're on Full Player
		Verify that MiniPlayer and FullPlayer can be switched between
		Verify that Thumbs Up and Thumbs Down can be double tapped
		Verify the Share Screen
		Verify the elements under the Art like the slider, play button, and the Artist name and Artist type
		Verify that the skip button works
		Verify that the casting button works
	 */
	@Test
	public void testFullPlayerFunctionality_FPLAY2_FREE() {
		LocalTime before = consoleLogStart("Testing testFullPlayerFunctionality_FPLAY2_FREE()");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test66@Test.com", "test", "FREE"));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Britney");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.minimizeFullPlayerToMiniPlayer();
		Assert.assertTrue("MiniPlayer should be open now", miniPlayer.isCurrentlyOnMiniPlayer());
		miniPlayer.openFullPlayer();
		Assert.assertTrue("Check if Full Player is open.", fullPlayer.isCurrentlyOnFullPlayer());
		Assert.assertEquals("Expecting playType to be 'player pause' since it should still be playing.", "player pause",
				fullPlayer.getTypeOfPlayButton());
		if (fullPlayer.isThumbUpAndThumbDownButtonNotActivated()) {
			// Both thumbs are down.
			fullPlayer.clickThumbDownButton();
			Assert.assertTrue("See if Thumb Down is selected", fullPlayer.isThumbDownButtonActivated());
			fullPlayer.clickThumbUpButton();
			Assert.assertTrue("See if Thumb Up is selected", fullPlayer.isThumbUpButtonActivated());
		} else if (fullPlayer.isThumbDownButtonActivated()) {
			// Just the Thumbs down button is activated - unclick it, and then
			// click it again.
			fullPlayer.clickThumbDownButton();
			Assert.assertFalse(
					"Thumb down button was originally activated, clicking it again should make it unactivated.",
					fullPlayer.isThumbDownButtonActivated());
		} else if (fullPlayer.isThumbUpButtonActivated()) {
			fullPlayer.clickThumbUpButton();
			Assert.assertFalse("Thumb up button was originally activated, clicking it again should make it unactivated",
					fullPlayer.isThumbUpButtonActivated());
		}
		fullPlayer.clickShareButtonOnNavBar();
		Assert.assertTrue("Should be on Share screen on Full Player", fullPlayer.isShareMenuOpen());
		fullPlayer.clickCancelOnShareMenuToReturnToFullPlayer();
		System.out.println("Checking Progress Slider now...");
		Assert.assertTrue("Progress Slider may be broken", fullPlayer.checkProgressSliderAlignedToPosition());
		Assert.assertEquals("We expect to be playing Britney Spears after searching 'Britney' ", "Britney Spears",
				fullPlayer.getStationName());
		Assert.assertEquals("We expect to be on Artist Radio if we enter 'Britney' into Search.", "Artist Radio",
				fullPlayer.getStationType());
		boolean lastAssert = fullPlayer.doesSkipCountDecreaseAfterClickingSkipButton();
		Assert.assertTrue("Skip may not have worked, or skip counter didn't decrease, or not enough skips were left",
				lastAssert);
		//fullPlayer.clickCastingAirplayButtonOnNavBar();
		//Assert.assertTrue("Clicking on the Casting / Airplay button should have opened the Connect to a Device screen.",
		//		fullPlayer.isConnectToADeviceDisplayed());
		//fullPlayer.clickCloseOnConnectADevice();
		//System.out.println("FavoriteButtonOnNavBarSelected? : " + fullPlayer.isFavoriteButtonOnNavBarSelected());
		//if (!fullPlayer.isFavoriteButtonOnNavBarSelected()) { 
			//fullPlayer.clickFavoriteButtonOnNavBar(true, true);
			//Assert.assertTrue("Favorite Button on NavBar should be selected after getting clicked.",
					//fullPlayer.isFavoriteButtonOnNavBarSelected());
		//} else { // Station is fav'ed, De-fav it, check that it isn't faved.
		//	fullPlayer.clickFavoriteButtonOnNavBar(true, true);
		//	Assert.assertFalse("Favorite Button on NavBar should be selected after getting clicked.",
		//			fullPlayer.isFavoriteButtonOnNavBarSelected());
		//}
	     consoleLogEnd(before, lastAssert, "Tested testFullPlayerFunctionality_FPLAY2_FREE.");
	}
	/**
	 * This Logs in with a FREE user, opens Artist Radio through Search and then tests the Replay and Save Buttons on the FullPlayer.
	 * Free User:
	 * Replay -> Upsell
	 * Save -> Save Song -> Saves to My Music
	 * Save -> Add to Playlist -> Upsell
	 * Save -> Save Station -> Adds Station to Favorites
	 * Save -> Remove Station -> Removes Station from Favorites
	 * Verify that Save Button opens Save Modal
     * Verify that 'Save Song' saves to My Music but cannot play.
     * Verify that 'Add to Playlist' triggers Upsell
     * Verify that 'Save Station' and 'Remove Station' work.
	 * Verify that 'Replay' button triggers upsell.
	 *
	 */
	@Test
	public void testFullPlayerSaveAndReplayButton_FPLAY3_FREE(){
		LocalTime before = consoleLogStart("Testing testFullPlayerSaveAndReplayButton_FPLAY3_FREE()");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("trav@free.com", "travfree", "FREE"));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Job for a cowboy");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.clickReplayButtonToOpenReplayModal();
		//Assert.assertTrue("Clicking Replay Button for a Free User should have triggered Upsell.", upsellPage.isUpsellModalOpen());
		String replayUpsellText = upsellPage.getReplaySongUpsellText().getText();
		upsellPage.replaySongUpsell("Free", "Encore! Instantly replay songs on the radio with iHeartRadio Plus.");
		upsellPage.clickXtoCloseUpsellModal();
		fullPlayer.clickSaveButtonToOpenSaveModal();
		Assert.assertFalse("Clicking 'Save' should have opened Save Modal and hidden the FullPlayer under it", fullPlayer.isCurrentlyOnFullPlayer());
		fullPlayer.clickSaveSongInSaveModal();
		//No real way to check if Growl displays. But we can verify that Save Modal disappears and fullPlayer opens back up. //'SongName' saved to My Music
		Assert.assertTrue("Clicking 'Save Song' should have popped up a growl and continued on the fullPlayer.", fullPlayer.isCurrentlyOnFullPlayer());
		fullPlayer.clickSaveButtonToOpenSaveModal();
		fullPlayer.clickAddToPlaylistButtonInSaveModal("FREE");
		//Assert.assertTrue("Upsell Modal should be open after clicking 'Add to Playlist' " ,upsellPage.isUpsellModalOpen());
		upsellPage.clickXtoCloseUpsellModal();
		Assert.assertTrue("Upsell Modal should be closed and  FullPlayer should be open.", fullPlayer.isCurrentlyOnFullPlayer());
		//upsellPage.clickSubscribeAllAccessButton();
		//Assert.assertTrue("Apple ID sign in should be displayed to buy All Access",upsellPage.isAppleIDSignInModalDisplayed());
		//Assert.assertTrue("Apple ID sign in should be displayed to buy Plus",upsellPage.isAppleIDSignInModalDisplayed());
	    fullPlayer.clickSaveButtonToOpenSaveModal();
	    System.out.println("Testing 'Save Station' puts the Heart next Station Name");
	    if(fullPlayer.isSaveStationInSaveModalDisplayed()){
	    	fullPlayer.clickSaveStationInSaveModal();
	    	Assert.assertTrue("Clicking Save Station should have made the Station Hearted/Favorited.",fullPlayer.isStationHearted());
	    }else if(fullPlayer.isRemoveStationInSaveModalDisplayed()){
	    	fullPlayer.clickRemoveStationInSaveModal();
	    	Assert.assertFalse("Clicking Remove Station should have removed the station's Heart from being visible.",fullPlayer.isStationHearted());
	    }
	    fullPlayer.clickSaveButtonToOpenSaveModal();
	    if(fullPlayer.isSaveStationInSaveModalDisplayed()){
	    	fullPlayer.clickSaveStationInSaveModal();
	    	Assert.assertTrue("Clicking Save Station should have made the Station Hearted/Favorited.",fullPlayer.isStationHearted());
	    }else if(fullPlayer.isRemoveStationInSaveModalDisplayed()){
	    	fullPlayer.clickRemoveStationInSaveModal();
	    	Assert.assertFalse("Clicking Remove Station should have removed the station's Heart from being visible.",fullPlayer.isStationHearted());
	    }
	    consoleLogEnd(before, true, "Tested Replay Button, Save Button[Save Song, Add to Playlist, Save/Remove Station] in testFullPlayerSaveAndReplayButton_FPLAY3_FREE().");
	}
	/**
	 * Open Artist Radio after Logging in to a Plus account created on Web.
	 * Click Save Button -> Click Add to Playlist -> Get Upsell
	 * Click upsell AA Button -> Get denied -> Exit Upsell Modal
	 * Test Save Song
	 * Test more than 6 tracks,
	 * then Replay second to last played song and make sure it is the same name.
	 */
	@Test
	public void testFullPlayerSaveReplaySkip_FPLAY4_PLUS(){
		LocalTime before = consoleLogStart("Testing testFullPlayerSaveReplaySkip_FPLAY4_PLUS()");
		Assert.assertTrue("Should log in successfully to PLUS account.",loginPage.loginVerifyEntitlement(IHEARTPLUSUSERNAME,IHEARTPLUSPASSWD,"PLUS"));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Chimaira");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		System.out.println("Testing to see if Save Button works for PLUS user...");
		fullPlayer.clickSaveButtonToOpenSaveModal();
		Assert.assertTrue("Clicking 'Add to Playlist' should show Upsell Modal.", fullPlayer.clickAddToPlaylistButtonInSaveModal("PLUS"));
		//upsellPage.clickSubscribeAllAccessButton();
		String upsellPlaylistText = upsellPage.getAddToPlaylistUpsellText().getText();		
		upsellPage.assertPlaylistUpsell("Plus",upsellPlaylistText);
		//Assert.assertTrue("Should show account was made on Web and only has 'Got It' button to escape from AA Upsell.",upsellPage.clickGotItWebUpsellDisplayed());
		//Assert.assertTrue("Apple ID sign in should be displayed to buy All Access", upsellPage.isAppleIDSignInModalDisplayed());
		upsellPage.clickXtoCloseUpsellModal();
		fullPlayer.clickSaveButtonToOpenSaveModal();
		fullPlayer.clickSaveSongInSaveModal();
		String songUpsellText = upsellPage.getSongUpsellText().getText();		
		upsellPage.assertTrackUpsell("Plus", songUpsellText);
		//Get name of currently playing song.
		//Go to My Music
		//Get title of last added Song in My Playlist 
		//Verify that song names are equal.
		String fifthTrackName = "";
		System.out.println("Testing to see if Skip button works more than 6 times, a PLUS and ALL ACCESS feature...");
		for(int i=0; i< 7; i++){
			fullPlayer.clickSkipButton();
			if(i==5){
				fifthTrackName = fullPlayer.getTitleOfSongPlaying();
				System.out.println("fifthTrackName: '" + fifthTrackName +"'");
			}
		}
		fullPlayer.clickReplayButtonToOpenReplayModal();
		Assert.assertTrue("Clicking 'Replay' button should open Replay Modal and show first Track Cell", fullPlayer.isCurrentlyOnReplayFirstTrackCell());
		Assert.assertTrue("Clicking 'Replay' button should open Replay Modal and not Upsell page.", fullPlayer.isCurrentlyOnReplayModal());

		fullPlayer.clickReplaySecondCell();
		Assert.assertEquals("After skipping 5 times, the Fifth Track's song name should match the Second to last song in Replay.", fifthTrackName, fullPlayer.getTitleOfSongPlaying());
		consoleLogEnd(before, true , "Tested testFullPlayerSaveReplaySkip_FPLAY4_PLUS().");
	}
	/**
	 * FPLAY5 - ALLACCESS ACCOUNT
	 * Opens FullPlayer for Artist Radio on AA account.
	 * No upsell modals should be displayed.
	 * Does Replay and tests that the same song gets played and checks that time resets.
	 * It then skips 8 times and then Replays the Last three tracks, Track 3, Track 2, Track 1.
	 */
	@Test
	@Category(Stable.class)
	public void testFullPlayerSaveReplaySkip_FPLAY5_ALLA(){
		LocalTime before = consoleLogStart("Testing testFullPlayerSaveReplaySkip_FPLAY5_ALLA()");
		Assert.assertTrue("Should log in successfully to ALLA account.",loginPage.loginVerifyEntitlement(IHEARTPREMIUMUSERNAME, IHEARTPREMIUMPASSWD, "ALLA"));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Chimaira");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		sleep(5000);
		String firstSongPlaying = fullPlayer.getTitleOfSongPlaying();
		String timeIntoSong = fullPlayer.getPositionLabelText();
		fullPlayer.clickReplayButtonToOpenReplayModal();
		Assert.assertTrue("Clicking 'Replay' button should open Replay Modal and show first Track Cell",fullPlayer.isCurrentlyOnReplayFirstTrackCell());
		Assert.assertTrue("Clicking First Cell in Replay Modal should simply work.",fullPlayer.clickReplayFirstCell());
		String firstSongRePlaying = fullPlayer.getTitleOfSongPlaying();
		String timeIntoSongRePlaying = fullPlayer.getPositionLabelText();
		boolean isMoreThan = false;
		Assert.assertEquals("Clicking Replay should have the same song title playing.", firstSongPlaying, firstSongRePlaying);
		int first = Integer.parseInt(timeIntoSong.substring(2,4));
		int second = Integer.parseInt(timeIntoSongRePlaying.substring(2,4));
		System.out.println("First Song after 30 seconds Int: "+ first + "  Second Song after Replay pressed Int: " + second);
		if(first > second){
			isMoreThan = true;
		}
		Assert.assertTrue("Clicking Replay on the same song should have less time elapsed.", isMoreThan);
		System.out.println("Testing to see if Skip button works more than 6 times.");
		for(int i=0; i< 7; i++){
			fullPlayer.clickSkipButton();
		}
		fullPlayer.clickReplayButtonToOpenReplayModal();
		sleep(2000);
		Assert.assertTrue("Clicking 'Replay' button should open Replay Modal and not Upsell page.", fullPlayer.isCurrentlyOnReplayModal());
		fullPlayer.clickReplayThirdCell();
		fullPlayer.clickReplayButtonToOpenReplayModal();
		fullPlayer.clickReplaySecondCell();
		fullPlayer.clickReplayButtonToOpenReplayModal();
		fullPlayer.clickReplayFirstCell();
		consoleLogEnd(before, fullPlayer.isCurrentlyOnFullPlayer(), "Tested testFullPlayerSaveReplaySkip_FPLAY5_ALLA().");
	}
	/**
	 * //Logs in, plays artist radio
		//Clicks Save
		//Add to Playlist
		//Add AIDS to Playlist page in IOS
		//Click 'Create New'
		//Use Today's Date - add's song to playlist.
		//Skip Song
		//Add to playlist, use existing
		//Skip Song
		//Add to Playlist, use MyPlaylist
		//Check songs, get titles in player.
	 */
	@Test
	@Ignore
	public void testFullPlayerAddToPlaylist_FPLAY6_ALLA(){
		//empty
	}
}
