package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.iheart.appium.utilities.TestRoot;

public class TestMiniPlayer extends TestRoot {

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
		GifSequenceWriter writer = loginPage.initGIFWriter();
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("testfree@mail.com", "tester", "FREE"));
		loginPage.addPageToGif(writer);
		homePage.clickNavBarSearchButtonToOpenSearch();
		loginPage.addPageToGif(writer);
		// Start Artist Radio
		searchPage.enterTextIntoSearchBar("Rage against the machine");
		loginPage.addPageToGif(writer);
		searchPage.clickTopResult();
		loginPage.addPageToGif(writer);
		Assert.assertTrue("Expected 'Pause Buffering' or 'Pause' because MiniPlayer should be playing an Artist track.",
				miniPlayer.getTypeOfPlayButton().contains("Pause"));
		miniPlayer.showAllElements();
		miniPlayer.clickPlayPauseButton();
		loginPage.addPageToGif(writer);
		Assert.assertTrue("Expected 'Play Buffering' or 'Play' because MiniPlayer should be playing an Artist track.",
				miniPlayer.getTypeOfPlayButton().contains("Play"));
		miniPlayer.clickPlayPauseButton();
		loginPage.addPageToGif(writer);	
		int numberOfSkipsRemaining = miniPlayer.getNumberOfSkipsRemaining();
		if (numberOfSkipsRemaining > 2) {
			miniPlayer.swipeMiniPlayerToLeftAndClickSkipButton();
			loginPage.addPageToGif(writer);
			Assert.assertTrue("Skip may not have worked - song title is the same.",
					miniPlayer.isTitleDifferentAfterSkip());
		}
		miniPlayer.swipeMiniPlayerToLeftToShowSkipButton();
		loginPage.addPageToGif(writer);
		System.out.println("SkipButton type = [" + miniPlayer.getTypeOfSkipButton() + "]");
		Assert.assertTrue("Expected 'Skip' instead of 'Scan' because MiniPlayer should be playing an Artist track.",
				miniPlayer.getTypeOfSkipButton().contains("Skip"));
		miniPlayer.swipeMiniPlayerToRightToHideSkipButton();
		loginPage.addPageToGif(writer);
		Assert.assertTrue("Track should not be Thumbed Up or Down yet...",
				miniPlayer.isThumbUpAndThumbDownButtonNotActivated());
		miniPlayer.clickThumbUpButton();
		loginPage.addPageToGif(writer);
		Assert.assertTrue("ThumbUpButton is not Selected", miniPlayer.isThumbUpButtonActivated());
		miniPlayer.clickThumbDownButton();
		loginPage.addPageToGif(writer);
		Assert.assertTrue("ThumbDownButton is not Selected", miniPlayer.isThumbDownButtonActivated());
		Assert.assertTrue("Test that it is still currently on Mini Player", miniPlayer.isCurrentlyOnMiniPlayer());
		loginPage.closeGifWriter(writer);
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
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("steph@free.com", "stephfree", "FREE"));
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
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("steph@free.com", "stephfree", "FREE"));
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
/*	@Test
	@Ignore
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
	@Test
	@Ignore
	public void testMiniPlayerPodcast_MPLAY5_FREE() {
	
	}
*/
}
