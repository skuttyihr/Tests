package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestFullPlayerAndMiniPlayer extends TestRoot {

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}

	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	@Test
	public void testMiniPlayerArtistRadio_MPLAY1_FREE() {
		LocalTime before = consoleLogStart(
				"Testing testMiniPlayerArtistRadio_MPLAY1_FREE() - login, start MiniPlayer for Artist Radio, show all elements, test functionality.");
		//loginPage.loginWithoutVerifying("test55@test.com", "test");
		loginPage.loginWithoutVerifying("trav@free.com", "travfree");
		homePage.clickNavBarSearchButtonToOpenSearch();
		// Start Artist Radio
		searchPage.enterTextIntoSearchBar("Rage against the machine");
		searchPage.clickTopResult();
		Assert.assertTrue("Expected 'Pause Buffering' or 'Pause' because MiniPlayer should be playing an Artist track.",
				miniPlayer.getTypeOfPlayButton().contains("Pause"));
		miniPlayer.showAllElements();
		miniPlayer.clickPlayPauseButton();
		Assert.assertTrue("Expected 'Play Buffering' or 'Play' because MiniPlayer should be playing an Artist track.",
				miniPlayer.getTypeOfPlayButton().contains("Play"));
		miniPlayer.clickPlayPauseButton();
		int numberOfSkipsRemaining = miniPlayer.getNumberOfSkipsRemaining();
		if (numberOfSkipsRemaining > 2) {
			miniPlayer.swipeMiniPlayerToLeftAndClickSkipButton();
			Assert.assertTrue("Skip may not have worked - song title is the same.",
					miniPlayer.isTitleDifferentAfterSkip());
		}
		miniPlayer.swipeMiniPlayerToLeftToShowSkipButton();
		System.out.println("SkipButton type = [" + miniPlayer.getTypeOfSkipButton() + "]");
		Assert.assertTrue("Expected 'Skip' instead of 'Scan' because MiniPlayer should be playing an Artist track.",
				miniPlayer.getTypeOfSkipButton().contains("Skip"));
		miniPlayer.swipeMiniPlayerToRightToHideSkipButton();
		Assert.assertTrue("Track should not be Thumbed Up or Down yet...",
				miniPlayer.isThumbUpAndThumbDownButtonNotActivated());
		miniPlayer.clickThumbUpButton();
		Assert.assertTrue("ThumbUpButton is not Selected", miniPlayer.isThumbUpButtonActivated());
		miniPlayer.clickThumbDownButton();
		Assert.assertTrue("ThumbDownButton is not Selected", miniPlayer.isThumbDownButtonActivated());
		Assert.assertTrue("Test that it is still currently on Mini Player", miniPlayer.isCurrentlyOnMiniPlayer());
		consoleLogEnd(before, true, "Tested IOSElements, Controls in MiniPlayer for artist radio");
	}
	/*
	 * Comment this in if you need to do short tests for functionality. 
	@Test
	public void testHiddenSkip(){
		loginPage.loginWithoutVerifying("trav@free.com", "travfree");
		homePage.clickNavBarSearchButtonToOpenSearch();
		// Start Artist Radio
		searchPage.enterTextIntoSearchBar("Rage against the machine");
		searchPage.clickTopResult();
		sleep(5000);
		miniPlayer.isThumbUpAndThumbDownButtonNotActivated();
		int numberOfSkipsRemaining = miniPlayer.getNumberOfSkipsRemaining();
		if (numberOfSkipsRemaining > 2) {
			miniPlayer.swipeMiniPlayerToLeftAndClickSkipButton();
			Assert.assertTrue("Skip may not have worked - song title is the same.",
					miniPlayer.isTitleDifferentAfterSkip());
		}
		
	}
	*/
	/**
	 * 
	 *  sk - 11/8 - altered the flow of the method- there was an extra click on
 	 *	the sidebar for each sideanv access, which I removed
	 */
	
	@Test
	public void testMiniPlayerWorksOnAllPages_MPLAY2_FREE() {
		LocalTime before = consoleLogStart(
				"Testing testMiniPlayerWorksOnAllPages - login, start MiniPlayer for Artist Radio, Open other pages, check that MiniPlayer is still running.");
		loginPage.loginWithoutVerifying("steph@free.com", "stephfree");
		homePage.clickNavBarSearchButtonToOpenSearch();
		// Start Artist Radio
		searchPage.enterTextIntoSearchBar("Inanimate Existence");
		searchPage.clickTopResult();
		// Should currently be on Inanimate Existence Artist Bio Page and
		// playing Artist Radio in miniPlayer.
		Assert.assertTrue("Artist Profile Page should currently be open but it is not.",
				artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("Miniplayer should be open playing Inanimate Existence, but it is not.",
				miniPlayer.isCurrentlyOnMiniPlayer());
		artistProfilePage.clickNavBarBackButton();
		// Now it should be back to SearchPage
		searchPage.clickCancelButtonOnSearchBar();
		// Canceled out of Search. Now we should be on Homepage.
		System.out.println("Testing that MiniPlayer continues to show up as you click on different pages.");
		sideNavBar.gotoLiveRadioPage();
		// EVENTUALLY - Add clickHamburgerButton method to all these pages.
		// System doesn't know that it is on non-Home pages so it can click the
		// SideMenuButton.
		System.out.print("Live Radio  :");
		Assert.assertTrue("Mini player was not visible on live radio page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoArtistPage();
		System.out.print("Artist  :");
		Assert.assertTrue("Mini player was not visible on artist radio page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoPodcastsPage();
		System.out.print("Podcasts  :");
		Assert.assertTrue("Mini player was not visible on podcasts page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoListeningHistoryPage();
		System.out.print("Listening History  :");
		Assert.assertTrue("Mini player was not visible on listening history page",
				miniPlayer.isCurrentlyOnMiniPlayer());

		consoleLogEnd(before, true, "Tested IOSElements, Controls in MiniPlayer for artist radio");
	}

	@Test
	public void testMiniPlayerRadioStation_MPLAY3_FREE() {
		LocalTime before = consoleLogStart("Testing testMiniPlayerRadioStationAfterLogin");
		loginPage.loginWithoutVerifying();
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("HOT 99.5");
		searchPage.clickTopResult();
		Assert.assertTrue("Clicking 99.5 in Search Results should have started playback in Miniplayer.",
				miniPlayer.isCurrentlyOnMiniPlayer());
		System.out.println(miniPlayer.getSongTitle());
		System.out.println(miniPlayer.getArtistName());
		searchPage.clearSearchBarTextField();
		searchPage.enterTextIntoSearchBar("HOT 97");
		searchPage.clickTopResult();
		Assert.assertEquals("HOT 97", miniPlayer.getSongTitle());
		Assert.assertEquals("Where Hip Hop Lives in New York ", miniPlayer.getArtistName());
		// If we don't have Track title, we can't thumb it up. Try to thumb it
		// up, verify that it still isn't activated. Not sure if we can see how
		// it's greyed out.
		miniPlayer.clickThumbUpButton();
		Assert.assertFalse(miniPlayer.isThumbUpButtonActivated());
		Assert.assertTrue("Expected 'Stop Buffering' or 'Stop' because MiniPlayer should be playing an Artist track.",
				miniPlayer.getTypeOfPlayButton().contains("Stop"));
		miniPlayer.swipeMiniPlayerToLeftToShowSkipButton();
		Assert.assertEquals("Player_Scan", miniPlayer.getTypeOfSkipButton());
		Assert.assertFalse("Elapsed View should not be shown for Radio Stations in MiniPlayer",
				miniPlayer.isElapsedViewDisplayed());
		consoleLogEnd(before, true, "Tested MiniPlayer for a Radio Station");
	}
	

	@Test
	public void testMiniPlayerPlaylist_MPLAY4_FREE() {
	
	}
	@Test
	public void testMiniPlayerPodcast_MPLAY5_FREE() {
	
	}

	@Test
	public void testFullPlayer_FPLAY1_FREE() {
		LocalTime before = consoleLogStart("Testing testFullPlayerElements");
		loginPage.loginWithoutVerifying("test66@test.com", "test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		// New accounts start a Full Player
		searchPage.enterTextIntoSearchBar("Opeth");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.showAllElements();
		consoleLogEnd(before, true, "Tested testFullPlayerElements");
	}

	@Test
	public void testFullPlayerFunctionality_FPLAY2_FREE() {
		LocalTime before = consoleLogStart("Testing testFullPlayerFunctionality()");
		loginPage.loginWithoutVerifying("test66@test.com", "test");
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
		//if (!fullPlayer.isFavoriteButtonOnNavBarSelected()) { // Station is not
																// favorited,
																// fav it, check
																// that it is
																// fav'ed
			//fullPlayer.clickFavoriteButtonOnNavBar(true, true);
			//Assert.assertTrue("Favorite Button on NavBar should be selected after getting clicked.",
					//fullPlayer.isFavoriteButtonOnNavBarSelected());
		//} else { // Station is fav'ed, De-fav it, check that it isn't faved.
		//	fullPlayer.clickFavoriteButtonOnNavBar(true, true);
		//	Assert.assertFalse("Favorite Button on NavBar should be selected after getting clicked.",
		//			fullPlayer.isFavoriteButtonOnNavBarSelected());
		//}
		consoleLogEnd(before, lastAssert, "Tested testFullPlayerElements");
	}
	/**
	 * This Logs in with a FREE user, opens Artist Radio through Search and then tests the Replay and Save Buttons on the FullPlayer.
	 * Free User:
	 * Replay -> Upsell
	 * Save -> Save Song -> Saves to My Music
	 * Save -> Add to Playlist -> Upsell
	 * Save -> Save Station -> Adds Station to Favorites
	 * Save -> Remove Station -> Removes Station from Favorites
	 *
	 */
	@Test
	public void testFullPlayerSaveAndReplayButton_FPLAY3_FREE(){
		LocalTime before = consoleLogStart("Testing testFullPlayerSaveAndReplayButton_FPLAY3_FREE()");
		loginPage.loginWithoutVerifying("trav@free.com", "travfree");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Job for a cowboy");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.clickReplayButtonToOpenReplayModal();
		Assert.assertTrue("Clicking Replay Button for a Free User should have triggered Upsell.", upsellPage.isUpsellModalOpen());
		upsellPage.clickXtoCloseUpsellModal();
		fullPlayer.clickSaveButtonToOpenSaveModal();
		Assert.assertFalse("Clicking 'Save' should have opened Save Modal and hidden the FullPlayer under it", fullPlayer.isCurrentlyOnFullPlayer());
		fullPlayer.clickSaveSongInSaveModal();
		//No real way to check if Growl displays. But we can verify that Save Modal disappears and fullPlayer opens back up. //'SongName' saved to My Music
		Assert.assertTrue("Clicking 'Save Song' should have popped up a growl and continued on the fullPlayer.", fullPlayer.isCurrentlyOnFullPlayer());
		fullPlayer.clickSaveButtonToOpenSaveModal();
		fullPlayer.clickAddToPlaylistButtonInSaveModal("FREE");
		Assert.assertTrue("Upsell Modal should be open after clicking 'Add to Playlist' " ,upsellPage.isUpsellModalOpen());
		upsellPage.clickXtoCloseUpsellModal();
		Assert.assertTrue("Upsell Modal should be closed and  FullPlayer should be open.", fullPlayer.isCurrentlyOnFullPlayer());
		fullPlayer.clickSaveButtonToOpenSaveModal();
		fullPlayer.clickAddToPlaylistButtonInSaveModal("FREE");
		upsellPage.clickSubscribeAllAccessButton();
		Assert.assertTrue("Apple ID sign in should be displayed to buy All Access",upsellPage.isAppleIDSignInModalDisplayed());
		upsellPage.clickCancelButton();
		fullPlayer.clickSaveButtonToOpenSaveModal();
		fullPlayer.clickAddToPlaylistButtonInSaveModal("FREE");
		upsellPage.clickSubscribePlusButton();
		Assert.assertTrue("Apple ID sign in should be displayed to buy Plus",upsellPage.isAppleIDSignInModalDisplayed());;
		upsellPage.clickCancelButton();
	    fullPlayer.clickSaveButtonToOpenSaveModal();
	    if(fullPlayer.isSaveStationInSaveModalDisplayed()){
	    	fullPlayer.clickSaveStationInSaveModal();
	    }else if(fullPlayer.isRemoveStationInSaveModalDisplayed()){
	    	fullPlayer.clickRemoveStationInSaveModal();
	    }
	    fullPlayer.clickSaveButtonToOpenSaveModal();
	    if(fullPlayer.isSaveStationInSaveModalDisplayed()){
	    	fullPlayer.clickSaveStationInSaveModal();
	    }else if(fullPlayer.isRemoveStationInSaveModalDisplayed()){
	    	fullPlayer.clickRemoveStationInSaveModal();
	    }
	    consoleLogEnd(before, true, "Tested Replay Button, Save Button[Save Song, Add to Playlist, Save/Remove Station] in testFullPlayerSaveAndReplayButton_FPLAY3_FREE().");
	}
	@Test
	public void testFullPlayerSaveReplaySkip_FPLAY4_PLUS(){
		LocalTime before = consoleLogStart("Testing testFullPlayerSaveReplaySkip_FPLAY4_PLUS()");
		loginPage.loginWithoutVerifying("trav@plus.com", "travplus");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Chimaira");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		System.out.println("Testing to see if Save Button works for PLUS user...");
		fullPlayer.clickSaveButtonToOpenSaveModal();
		Assert.assertTrue("Clicking 'Add to Playlist' should show Upsell Modal.", fullPlayer.clickAddToPlaylistButtonInSaveModal("PLUS"));
		upsellPage.clickSubscribeAllAccessButton();
		Assert.assertTrue("Should show account was made on Web and only has 'Got It' button to escape from AA Upsell.",upsellPage.clickGotItWebUpsellDisplayed());
		//Assert.assertTrue("Apple ID sign in should be displayed to buy All Access",upsellPage.isAppleIDSignInModalDisplayed());
		upsellPage.clickXtoCloseUpsellModal();
		fullPlayer.clickSaveButtonToOpenSaveModal();
		fullPlayer.clickSaveSongInSaveModal();
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
		sleep(2000);
		fullPlayer.isReplayFirstTrackCellDisplayed();
		Assert.assertTrue("Clicking 'Replay' button should open Replay Modal and not Upsell page.", fullPlayer.isCurrentlyOnReplayModal());

		fullPlayer.clickReplaySecondCell();
		Assert.assertEquals("After skipping 5 times, the Fifth Track's song name should match the Second to last song in Replay.", fifthTrackName, fullPlayer.getTitleOfSongPlaying());
		consoleLogEnd(before, true , "Tested testFullPlayerSaveButton_PLUS().");
	}
	/**
	 * FPLAY5 - ALLACCESS ACCOUNT
	 * Opens FullPlayer for Artist Radio
	 * Does Replay and tests that the same song gets played and checks that time resets.
	 * It then skips 8 times and then Replays the Last three tracks, Track 3, Track 2, Track 1.
	 */
	@Test
	public void testFullPlayerSaveReplaySkip_FPLAY5_ALLACCESS(){
		LocalTime before = consoleLogStart("Testing testFullPlayerSaveReplaySkip_FPLAY5_ALLACCESS()");
		loginPage.loginWithoutVerifying("trav@all.com", "travall");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Chimaira");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		sleep(30000);
		String firstSongPlaying = fullPlayer.getTitleOfSongPlaying();
		String timeIntoSong = fullPlayer.getPositionLabelText();
		fullPlayer.clickReplayButtonToOpenReplayModal();
		sleep(2000);
		fullPlayer.isReplayFirstTrackCellDisplayed();
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
		
		//fullPlayer.getReplayreplayTitleLabel();
		//System.out.println("Replay Modal : First Song -> Song Name : " + fullPlayer.getReplayFirstSongName());
		//System.out.println("Replay Modal : First Song -> Song Artist : " + fullPlayer.getReplayFirstSongArtist());
		///ullPlayer.clickSaveButtonToOpenSaveModal();
		//fullPlayer.clickAddToPlaylistButtonInSaveModal("ALLACCESS");
		 consoleLogEnd(before, fullPlayer.isCurrentlyOnFullPlayer(), "Tested testFullPlayerSaveReplaySkip_FPLAY5_ALLACCESS().");
	}
	@Test
	public void testFullPlayerAddToPlaylist_FPLAY6_ALLACCESS(){
		//Logs in, plays artist radio
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
	}
}
