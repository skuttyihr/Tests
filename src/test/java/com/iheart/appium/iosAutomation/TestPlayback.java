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
	 * @throws Exception
	 */
	@Test
	public void test_custom_artist_station() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		Assert.assertTrue("Artist was not added to favorites!", forYouPage.createArtistStation());
	}

	@Test
	public void test_playPodcasts_skip_share() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		Assert.assertTrue("Could not play a podcast episode", podcastsPage.playPodcasts());
	}

	@Test
	public void test_playLiveRadio_thumbUP_thumbDown_doFavorite() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		Assert.assertTrue("Could not play a live radio station", forYouPage.playLiveRadio());
	}

	@Test
	public void test_playCustomStation_search_logout() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		
		//Play radio, record errors.
		String anyErrors = customRadio.canPlayCustomStation();
		Assert.assertTrue("Was not able to play a custom station and load it into recent history. Errors: \n" + anyErrors, 
				anyErrors == null || anyErrors.length() <= 0);
		// Log out
		sideNavBar.logout();
		
		// Try to play a station while logged out
		anyErrors = customRadio.canPlayCustomStation();
		Assert.assertFalse("Was able to play a custom station after logging out", 
				anyErrors == null || anyErrors.length() <= 0);
	}
}
