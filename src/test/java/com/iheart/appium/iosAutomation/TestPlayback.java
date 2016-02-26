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
		Page.removeAllFavorites();
		TestRoot.tearDown();
	}
	
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
		String artist = "Josh Groban";
		Assert.assertTrue("Was not able to login", loginPage.login());
		// Test that we can create an artist station
		Assert.assertTrue("Could not play a custom artist station based on the artist: " + artist,
				customRadio.playACustomStation(artist).contains(artist));
		
		// Test that all playback elements are present on an artist station
		// Verify method will "Favorite" the artist statiomn
		String verifyPlaybackErrors = player.verifyArtistPlaybackControls();
		Assert.assertTrue("Playback elements were not present: " + verifyPlaybackErrors, didPass(verifyPlaybackErrors));

		// Can we skip 6 times? TODO
		
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
	public void testPodcastPlaybackAndControls() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		String errorsWithPodcasts = podcastsPage.playPodcasts();
		Assert.assertTrue("Could not play a podcast episode. Errors:\n" 
							+ errorsWithPodcasts, didPass(errorsWithPodcasts));

		// Test that the scrubber can advance on its own during playback
		sleep(2000); // So the podcast isn't at 0
		// Pause so we don't mess up the test
		player.pause("podcast");
		int scrubberPosPercent = player.getPodcastScubberPostitionPercentage();
		Assert.assertTrue("Scrubber did not show playback", scrubberPosPercent > 0);
		int timeElapsed = player.getElapsedTime();
		int totalTime = player.getTotalTime();
		int estimatedTimePassed = (int) (totalTime * (float) scrubberPosPercent / 100);
		Assert.assertTrue("Slider position did not accurately reflect the position", 
					isAbout(timeElapsed, estimatedTimePassed, 5));
		
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
		Assert.assertTrue("We couldn't scrub playback on podcast. "
				+ "Got: " + timeElapsed + " Expected: " + expectedElapsedTime,
				isAbout(timeElapsed, expectedElapsedTime, 15));
	}

	@Test
	public void test_playLiveRadio_thumbUP_thumbDown_doFavorite() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		Assert.assertTrue("Could not play a live radio station", forYouPage.playLiveRadio());
	}

}
