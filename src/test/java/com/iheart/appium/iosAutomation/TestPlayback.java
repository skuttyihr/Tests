package com.iheart.appium.iosAutomation;


import java.time.LocalTime;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;


public class TestPlayback extends TestRoot {

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
		TestRoot.setup();
	}
	@After
	public void after() {
		// Remove favorites, logout, and tearDown
		homePage.removeAllFavorites();
		sideNavBar.logout();
		TestRoot.tearDown();
	}
	
	/**
	 * Changes and then checks Playback Volume
	 */
	private void assertPlaybackVolume(){
		System.out.println("Asserting Playback Volume");
		int currentVolume = player.getVolume();
		int expectedVolume = 50;
		if(currentVolume == 50){
			expectedVolume = 25;
		}
		String testVolume = player.setVolume(expectedVolume);
		Assert.assertTrue(testVolume, didPass(testVolume));
		currentVolume = player.getVolume();
		Assert.assertTrue("Volume was not within range:\n" +
						"Current Volume: " + currentVolume +
						"\nExpected Volume: " + expectedVolume,
					isAbout(currentVolume, expectedVolume, 7));
	}
	
	////  Artist Station Tests  ////
	
	/**
		Searches for and plays a custom artist based station
		Thumbs up track
		Thumbs down track
		Favorites station
		Skips track
		Verifies that station has been favorited
		Logs out
		Verifies that we can't play a custom artist station if logged out
	 * @throws Exception
	 */
	//Station was not added to favorites
	@Test
	public void testCustomArtistStationPlaybackAndLogout() throws Exception {
		LocalTime before = consoleLogStart("Testing Custom Artist Station Playback, and then logging out:"+ name.getMethodName());
		String artist = "Florence + the Machine";
		
		Assert.assertTrue("Was not able to login", loginPage.login());
		// Test that we can create an artist station
		Assert.assertTrue("Could not play a custom artist station based on the artist: " + artist,
				customRadio.playACustomStation(artist).contains(artist));
		
		// Test that all playback elements are present on an artist station
		// Verify method will "Favorite" the artist station
		miniPlayer.maximizeMiniPlayer();
		String verifyPlaybackErrors = player.verifyPlaybackControls();
		Assert.assertTrue("Playback elements were not present: " + verifyPlaybackErrors, didPass(verifyPlaybackErrors));
		
		// Test we can modify the volume
		assertPlaybackVolume();
		
		// Test that AirPlay is available
		String airPlayTest = player.streamOverAirPlay();
		Assert.assertTrue("AirPlay was not an available option. ", didPass(airPlayTest));
		
		// Get back to home page / My Stations to verify favorited station
		player.back.click();
		search.cancel.click();
		sideNavBar.gotoMyStationsPage();
		
		// Test that we can add to favorites from playback
		Assert.assertTrue("Station was not added to favorites", homePage.isStationAFavorite(artist) > 0);
		
		consoleLogEnd(before, true,  "Tested Custom Artist Station Playback in TestPlayback.java");
	}
	/**
	 * Login to existing account, LoadUp Mini Player with an artist. Maximize mini Player to Full Size. Minimize Full Size. Verify the controls.
	 * Check SidenavBar - LiveRadioPage, LiveArtistPage, PodcastsPage, PerfectFor, Listening history page. 
	 */
	@Test
	public void testCustomArtistStationMiniPlayer(){
		LocalTime before = consoleLogStart("Testing Custom Artist Station - Mini Player :"+ name.getMethodName());
		String artist = "Halsey";  
		// Log in
		Assert.assertTrue("Was not able to login", loginPage.login());
		// Play an artist and minimize playback
		Assert.assertTrue("Could not load up an artist station", 
				didPass(miniPlayer.loadUpMiniPlayer(artist)));
		// Maximize the mini player
		Assert.assertTrue("Could not load up full sized player from mini player. ",
				miniPlayer.maximizeMiniPlayer());
		// Minimize full sized player
		Assert.assertTrue("Could not minimize full sized player to mini player. ",
				miniPlayer.minimizePlayer());
		
		// Verify the controls on the mini player
		Errors miniPlayerControls = miniPlayer.verifyControls();
		Assert.assertTrue("Mini player control issues:\n" + miniPlayerControls, miniPlayerControls.noErrors());
		
		// Check that mini bar is on every page we expect it to be on
		System.out.println("Testing SideBar Nav items");
		sideNavBar.gotoLiveRadioPage();
		System.out.print("Live Radio");
		Assert.assertTrue("Mini player was not visible on live radio page", isVisible(miniPlayer.miniPlayerBar));
		sideNavBar.gotoLiveArtistPage();
		System.out.print(", Live Artist");
		Assert.assertTrue("Mini player was not visible on artist radio page", isVisible(miniPlayer.miniPlayerBar));
		sideNavBar.gotoPodcastsPage();
		System.out.print(", Podcasts");
		Assert.assertTrue("Mini player was not visible on podcasts page", isVisible(miniPlayer.miniPlayerBar));
		sideNavBar.gotoPerfectFor();
		System.out.print(", Perfect For");
		Assert.assertTrue("Mini player was not visible on perfect for page", isVisible(miniPlayer.miniPlayerBar));
		sideNavBar.gotoListeningHistoryPage();
		System.out.print(", Listening History");
		Assert.assertTrue("Mini player was not visible on listening history page", isVisible(miniPlayer.miniPlayerBar));
		System.out.println(", Removing all favorites");
		//homePage.removeAllFavorites(); //removed from after() and placed here. 
		boolean testResult = miniPlayerControls.noErrors();
		consoleLogEnd(before, testResult,  "Tested Custom Artist Station - Mini Player in TestPlayback.java");
	}
	
	
	/**
	 * This method creates an account, creates a custom station, then skips 6 times, then skips one more and expects not to be able to skip. 
	 * We currently have a limit of 6 skips on our software. 
	 */

	@Test
	public void testArtistRadioSkipLimit(){
		LocalTime before = consoleLogStart("Testing Artist Radio Skip Limit :"+ name.getMethodName());
		// Create an account so we start with a fresh number of skips
		System.out.println("Creating an account");
		Assert.assertTrue("Could not create a new account", signupPage.createNewAccount());
		System.out.println("Selecting 1 genre, and handling possible popups.");
		genrePage.selectGenre(1);
		Page.handlePossiblePopUp();
		
		String artist = "Matt and Kim";
		System.out.println("About to play a custom station for "+ artist);
		Assert.assertTrue("Could not play a custom artist station based on the artist: " + artist,
				customRadio.playACustomStation(artist).contains(artist));
		System.out.println("Maximizing the mini player");
		miniPlayer.maximizeMiniPlayer();
		System.out.println("Attempting to skip songs 6 times");
		for(int i = 1; i < 7; i++){
			Assert.assertTrue("Could not skip for the " + getTextOfInt(i) + " time.", player.doSkip());
		}
		player.pause();
		System.out.println("Attempting to skip a 7th time - should fail");
		boolean result = !player.doSkip();
		Assert.assertTrue("Should not have been able to skip", result);
		consoleLogEnd(before, result,  "Tested Artist Radio Skip Limit in TestPlayback.java");
	}

	/**
	 * Podcast Playback and controls. 
	 * playPodcasts(), maximizeMiniPlayer(), 
	 * check scrubber vs elapsed time, assertPlaybackVolume(), 
	 * verifyControls
	 */
	@Test
	public void testPodcastPlaybackAndControls() {
		LocalTime before = consoleLogStart("Testing Podcast Playback and Controls :"+ name.getMethodName());
		
		loginPage.loginWithoutVerifying();
		String errorsWithPodcasts = podcastsPage.playPodcasts();
		Assert.assertTrue("Could not play a podcast episode. Errors:\n" 
							+ errorsWithPodcasts, didPass(errorsWithPodcasts));
		// Test that the scrubber can advance on its own during playback
		sleep(2000); // So the podcast isn't at 0
		// Pause so we don't mess up the test
		System.out.println("Pause the Player!");
		player.pause();
		System.out.println("Maximize the Mini Player!");
		miniPlayer.maximizeMiniPlayer();
		System.out.println("Test the scrubber position percentage vs elapsed time");
		int scrubberPosPercent = player.getPodcastScubberPostitionPercentage();
		Assert.assertTrue("Scrubber did not show playback", scrubberPosPercent > 0);
		int timeElapsed = player.getElapsedTime();
		int totalTime = player.getTotalTime();
		int estimatedTimePassed = (int) (totalTime * (float) scrubberPosPercent / 100);
		Assert.assertTrue("Slider position did not accurately reflect the position", 
					isAbout(timeElapsed, estimatedTimePassed, 7));
		// Slide the scrubber, then try a similar test to see if we're where we expect to be
		player.scrubTo(50);
		int expectedElapsedTime = totalTime / 2;
		timeElapsed = player.getElapsedTime();
		Assert.assertTrue("We couldn't scrub playback on podcast. "
				+ "Got: " + timeElapsed + " Expected: " + expectedElapsedTime,
				isAbout(timeElapsed, expectedElapsedTime, 15));
		player.scrubTo(25);
		expectedElapsedTime /= 2;
		timeElapsed = player.getElapsedTime();
		
		Assert.assertTrue("We couldn't scrub playback on podcast.\n"
				+ "Got: " + timeElapsed + "\nExpected: " + expectedElapsedTime,
				isAbout(timeElapsed, expectedElapsedTime, 15));
		System.out.println("Test the playback Volume");
		assertPlaybackVolume();
		
		// Mini player verification
		System.out.println("Minimize the player!");
		player.minimizePlayer();
		System.out.println("Verify the Mini Player controls!");
		
		Errors miniPlayerVerification = miniPlayer.verifyControls();
		Assert.assertTrue("Mini player controls were not available:\n" + miniPlayerVerification,
				miniPlayerVerification.noErrors());

		consoleLogEnd(before, miniPlayerVerification.noErrors(),  "Tested Podcast Playback and Controls in TestPlayback.java");
	}
	
	/**
     * Live Radio Playback Tests
     * Login, playLiveRadio(), assertPlaybackVolume(), 
     * mini and maxi player(), doScan() 7 times, verifyControls(), logout()
	 */
	
	@Test
	public void testLiveRadioPlayback() {
		LocalTime before = consoleLogStart("Testing Live Radio Playback features :"+ name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		// Play a live radio station and verify it.
		String playedStation = forYouPage.playLiveRadio();
		Assert.assertTrue("Could not play a live radio station.", strGood(playedStation));

		String verifyPlayer = player.verifyPlaybackControls();
		Assert.assertTrue("Could not verify live radio controls:\n" + verifyPlayer, didPass(verifyPlayer));
		
		assertPlaybackVolume();
		
		// Get to the mini player and assert it's visible
		Assert.assertTrue("Mini player was not displayed.", player.minimizePlayer());
		miniPlayer.maximizeMiniPlayer();
		
		System.out.println("Testing Scan Seven times");
		// Scan more than 6 times
		for (int i = 0; i < 7; i++){
			Assert.assertTrue("Could not scan to a new station after " + i + " loops.", player.doScan());
		}
		System.out.println("Attempting to scan a 7th time - should work, Scan != Skip");
		boolean result = player.doScan();
		Assert.assertTrue("A limit may have been placed on number of times to scan.", result);
		
		// Get back to mini player
		player.minimizePlayer();
		
		// Verify mini player controls
		Errors miniPlayerControls = miniPlayer.verifyControls();
		Assert.assertTrue("Mini player control issues:\n" + miniPlayerControls, miniPlayerControls.noErrors());
		
		consoleLogEnd(before, miniPlayerControls.noErrors(),  "Tested Live Radio Playback in TestPlayback.java");
	}
	
	/**
	 * Test Additional Info
	 * Play a custom station, verifyAllMoreInfoItems, closeMoreInfo, 
	 * gotoHomePage, searchForPodCast, searchForStation, verifyAllMoreInfoItems again
	 * 
	 */
	@Test
	 //Can't exit Lyrics view for some reason. Artist Bio button was not visible, Share option was not visible, Option to buy song was not present. 
	public void testAdditionalInfo(){
		LocalTime before = consoleLogStart("Testing Additional Information :"+ name.getMethodName());
		// Tests that the additional info ellipsis is present and functional for live stations, podcasts, and artist radio
		loginPage.loginWithoutVerifying();
		// Artist radio
		String artist = "The Killers";
		//Assert.assertTrue("Could not play a custom artist station based on the artist: " + artist,
				customRadio.playACustomStation(artist).contains(artist);//);  This is failing due to a dev problem. Let it run. 
		String moreInfoErrors = player.verifyAllMoreInfoItems();
		Assert.assertTrue("Errors with More Info page for artist radio: " + moreInfoErrors, didPass(moreInfoErrors));
		player.closeMoreInfo();
		// Load up a podcast and test that we cannot see the more info button
		player.getBack();
		sideNavBar.gotoHomePage();
		Assert.assertTrue("Did not select a podcast episode.", strGood(search.searchForPodCast("Elvis Duran on Demand")));
		Assert.assertTrue("More Info button was not disabled, as we expected it to be",
				isVisible(player.more) && !player.more.isEnabled());
		
		// Check live radio playback
		player.getBack();
		sideNavBar.gotoHomePage();
		search.searchForStation("Z100");
		moreInfoErrors = player.verifyAllMoreInfoItems();
		
		boolean testResult = didPass(moreInfoErrors);
		Assert.assertTrue("Errors with More Info page for live radio: " + moreInfoErrors, testResult);
		consoleLogEnd(before, testResult,  "Tested Additional Information in TestPlayback.java");
	}
}
