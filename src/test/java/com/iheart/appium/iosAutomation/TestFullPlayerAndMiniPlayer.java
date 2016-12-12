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

	/**
	 * 1. Login with FREE acct, Reach Home, Click Search Button
       2. Enter artist name into Search Bar (ARTIST RADIO)
       3. Click Top Result, then verify all elements in the miniPlayer.
	 * Verify that Play Button has 'Pause' icon.
	 * Click Play Button
     * Swipe MiniPlayer to Left to show Skip button
     * Skip a track and verify the label count for tracks remaining decreased.
     * Click Thumbs Up and Thumbs Down on MiniPlayer for this Artist Radio
     * (todo)Verify that Artist Profile was navigated to.
     * (todo)Play Artist in mini player if something is already playing. 
	 */
	@Test
	public void testMiniPlayerArtistRadio_MPLAY1_FREE() {
		LocalTime before = consoleLogStart(
				"Testing testMiniPlayerArtistRadio_MPLAY1_FREE() - login, start MiniPlayer for Artist Radio, show all elements, test functionality.");
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
		consoleLogEnd(before, true, "Tested testMiniPlayerArtistRadio_MPLAY1_FREE in MiniPlayer for artist radio");
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
	 *  1. Repeat MPLAY-1 with an Artist name
     *  2. Navigate back to Home Page then navigate through Side Menus and verify where MiniPlayer stays up or is hidden.
     *  Verify that MiniPlayer is open on Live Radio page.
		Verify that MiniPlayer is open on Live Artist page.
		Verify that MiniPlayer is open on Podcasts page.
		Verify that MiniPlayer is open on Playlists page.
		Verify that MiniPlayer is open on Listening History page.
	 *  sk - 11/8 - altered the flow of the method- there was an extra click on
 	 *	the sidebar for each sideanv access, which I removed
 	 *
 	 *  ts - 12/08/16 - altered username, testname.
	 */
	
	@Test
	public void testMiniPlayerWorksOnAllPages_MPLAY2_FREE() {
		LocalTime before = consoleLogStart(
				"Testing testMiniPlayerWorksOnAllPages_MPLAY2_FREE - login, start MiniPlayer for Artist Radio, Open other pages, check that MiniPlayer is still running.");
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

		consoleLogEnd(before, true, "Tested testMiniPlayerWorksOnAllPages_MPLAY2_FREE, Controls in MiniPlayer for artist radio");
	}

	/**
	 * 1. Repeat MPLAY-1 with an Radio Station Name ("Hot 99.5")
       2. Verify the assortment of miniPlayer controls are working for Radio Station subset.
	    Verify that MiniPlayer plays for a Live Station (if something is already playing)
		(todo) Play Live in full player if nothing was playing.
		Verify that MiniPlayer song title is the station name and the artist name is the station description
		Verify that Thumbs up, down works.
		Verify that hidden Skip button is a 'Scan' button
		Verify that Elapsed view is hidden
	 */
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
		consoleLogEnd(before, true, "Tested testMiniPlayerRadioStation_MPLAY3_FREE for a Radio Station");
	}
	

	/**
	 * 1. Repeat MPLAY-1 with a Themed Radio / Playlist Name ("Heavy Metal Barbell")
	   2. Verify the assortment of miniPlayer controls are working for Playlist subset.
	 * TO DO - ALL OF TEST CASE
	 * Verify that MiniPlayer plays for a Themed Radio or Playlist
		Verify that MiniPlayer song title is the song name and the artist name is the artist
		Verify that Thumbs up, down works.
		Verify that hidden Skip button is a 'Skip' button
		Verify that Elapsed view is shown
	 */
	@Test
	public void testMiniPlayerPlaylist_MPLAY4_FREE() {
	
	}
	/**	1. Repeat MPLAY-1 with a Podcast ("Startalk")
		2. Verify the assortment of miniPlayer controls are working for Podcast subset.
	 * 
	 * 	Verify that MiniPlayer plays for a Podcast
		Verify that MiniPlayer song title is the station name and the artist name is the station description
		Verify that Thumbs up, down works.
		Verify that hidden Skip button is a 'Scan' button
		Verify that Elapsed view is shown
	 */
	@Test
	public void testMiniPlayerPodcast_MPLAY5_FREE() {
	
	}

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
	public void testFullPlayer_FPLAY1_FREE() {
		LocalTime before = consoleLogStart("Testing testFullPlayer_FPLAY1_FREE");
		loginPage.loginWithoutVerifying("test66@test.com", "test");
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
	 * Verify that Artist Radio starts and you're on Full Player
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
		consoleLogEnd(before, fullPlayer.isCurrentlyOnFullPlayer(), "Tested testFullPlayerSaveReplaySkip_FPLAY5_ALLACCESS().");
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
	public void testFullPlayerAddToPlaylist_FPLAY6_ALLACCESS(){
		//empty
	}
}
