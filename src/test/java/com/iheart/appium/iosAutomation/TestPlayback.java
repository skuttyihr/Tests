package com.iheart.appium.iosAutomation;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
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
		// Remove favorites
		homePage.removeAllFavorites();
		TestRoot.tearDown();
	}
	
	private void assertPlaybackVolume(){
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
	@Test
	public void testCustomArtistStationPlaybackAndLogout() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		String artist = "Florence + the Machine";
		
		Assert.assertTrue("Was not able to login", loginPage.login());
		// Test that we can create an artist station
		Assert.assertTrue("Could not play a custom artist station based on the artist: " + artist,
				customRadio.playACustomStation(artist).contains(artist));
		
		// Test that all playback elements are present on an artist station
		// Verify method will "Favorite" the artist statiomn
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
		
		// Log out
		sideNavBar.logout();
		
		// Try to play a station while logged out (should not play)
		String anyErrors = customRadio.canPlayCustomStation();
		Assert.assertFalse("Was able to play a custom station after logging out", 
				anyErrors == null || anyErrors.length() <= 0);
	}
	
	@Test
	public void testCustomArtistStationMiniPlayer(){
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
		String miniPlayerControls = miniPlayer.verifyControls();
		Assert.assertTrue("Mini player control issues:\n" + miniPlayerControls, didPass(miniPlayerControls));
		
		// Check that mini bar is on every page we expect it to be on
		sideNavBar.gotoLiveRadioPage();
		Assert.assertTrue("Mini player was not visible on live radio page", isVisible(miniPlayer.miniPlayerBar));
		sideNavBar.gotoLiveArtistPage();
		Assert.assertTrue("Mini player was not visible on artist radio page", isVisible(miniPlayer.miniPlayerBar));
		sideNavBar.gotoPodcastsPage();
		Assert.assertTrue("Mini player was not visible on podcasts page", isVisible(miniPlayer.miniPlayerBar));
		sideNavBar.gotoPerfectFor();
		Assert.assertTrue("Mini player was not visible on perfect for page", isVisible(miniPlayer.miniPlayerBar));
		sideNavBar.gotoListeningHistoryPage();
		Assert.assertTrue("Mini player was not visible on listening history page", isVisible(miniPlayer.miniPlayerBar));
	}
	
	@Test
	public void testArtistRadioSkipLimit(){
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Could not create a new account", signupPage.createAnAccount());
		genrePage.selectGenre(1);
		Page.handlePossiblePopUp();
		
		String artist = "Matt and Kim";
		Assert.assertTrue("Could not play a custom artist station based on the artist: " + artist,
				customRadio.playACustomStation(artist).contains(artist));
		for(int i = 0; i < 6; i++){
			Assert.assertTrue("Could not skip for the " + i + " time.", player.doSkip());
		}
		player.pause();
		Assert.assertTrue("Should not have been able to skip", !player.doSkip());
	}

	////  Podcast Tests  ////
	
	@Test
	public void testPodcastPlaybackAndControls() {
		System.out.println("test method:" + name.getMethodName());
		loginPage.loginWithoutVerifying();
		String errorsWithPodcasts = podcastsPage.playPodcasts();
		Assert.assertTrue("Could not play a podcast episode. Errors:\n" 
							+ errorsWithPodcasts, didPass(errorsWithPodcasts));
		// Test that the scrubber can advance on its own during playback
		sleep(2000); // So the podcast isn't at 0
		// Pause so we don't mess up the test
		player.pause();
		miniPlayer.maximizeMiniPlayer();
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
		
		assertPlaybackVolume();
		
		// Mini player verification
		player.minimizePlayer();
		String miniPlayerVerification = miniPlayer.verifyControls();
		Assert.assertTrue("Mini player controls were not available:\n" + miniPlayerVerification,
				didPass(miniPlayerVerification));
		
		// Log out and verify playback stops
		sideNavBar.logout();
		sideNavBar.gotoHomePage();
		Assert.assertTrue("Mini player was still visible, podcast still playing, after logging out.", 
				!isVisible(miniPlayer.miniPlayerBar));
	}

	
	////  Live Radio Tests  ////
	
	@Test
	public void testLiveRadioPlayback() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		// Play a live radio station and verify it.
		String playedStation = forYouPage.playLiveRadio();
		Assert.assertTrue("Could not play a live radio station.", strGood(playedStation));
		
		// TODO
		/* Live radio errors:
		 * Could not verify live radio controls:
		 * Play icon is not displayed
		 * Skip icon is not displayed
		 * Could not load artist album artwork
		 * Could not favorite artist station
		 * could not skip
		 */
		String verifyPlayer = player.verifyPlaybackControls();
		Assert.assertTrue("Could not verify live radio controls:\n" + verifyPlayer, didPass(verifyPlayer));
		
		assertPlaybackVolume();
		
		// Get to the mini player and assert it's visible
		Assert.assertTrue("Mini player was not displayed.", player.minimizePlayer());
		miniPlayer.maximizeMiniPlayer();
		
		// Scan more than 6 times
		for (int i = 0; i < 7; i++){
			Assert.assertTrue("Could not scan to a new station after " + i + " loops.", player.doScan());
		}
		
		// Get back to mini player
		player.minimizePlayer();
		
		// Verify mini player controls
		String miniPlayerControls = miniPlayer.verifyControls();
		Assert.assertTrue("Mini player control issues:\n" + miniPlayerControls, didPass(miniPlayerControls));
		
		
		// Log out and verify that we can still play radio
		sideNavBar.logout();
		sideNavBar.gotoHomePage();
		playedStation = forYouPage.playLiveRadio();
		Assert.assertTrue("Could not play a live radio station after logging out.", strGood(playedStation));
	}
	
	@Test
	public void testAdditionalInfo(){
		// Tests that the additional info ellipsis is present and functional for live stations, podcasts, and artist radio
		loginPage.loginWithoutVerifying();
		// Artist radio
		String artist = "The Killers";
		Assert.assertTrue("Could not play a custom artist station based on the artist: " + artist,
				customRadio.playACustomStation(artist).contains(artist));
		String moreInfoErrors = player.verifyAllMoreInfoItems();
		Assert.assertTrue("Errors with More Info page for artist radio: " + moreInfoErrors, didPass(moreInfoErrors));
		player.closeMoreInfo();
		// Load up a podcast and test that we cannot see the more info button
		player.getBack();
		sideNavBar.gotoHomePage();
		Assert.assertTrue(strGood(search.searchForPodCast("Elvis Duran on Demand")));
		Assert.assertTrue("More Info button was not disabled, as we expected it to be",
				isVisible(player.more) && !player.more.isEnabled());
		
		// Check live radio playback
		player.getBack();
		sideNavBar.gotoHomePage();
		search.searchForStation("Z100");
		moreInfoErrors = player.verifyAllMoreInfoItems();
		Assert.assertTrue("Errors with More Info page for live radio: " + moreInfoErrors, didPass(moreInfoErrors));
	}
}
