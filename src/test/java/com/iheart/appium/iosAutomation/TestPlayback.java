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
		TestRoot.tearDown();
	}
	
	@Test
	public void test_createArtistStation_thumbUp_thumbDown_favorite_skip() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		Assert.assertTrue("Artist was not added to favorites!", forYouPage.createArtistStation());
		// Remove favorites
		Page.removeAllFavorites();
	}

	@Test
	public void test_playPodcasts_skip_share() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		podcastsPage.playPodcasts();
	}

	@Test
	public void test_playLiveRadio_thumbUP_thumbDown_doFavorite() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		forYouPage.playLiveRadio();
	}

	@Test
	public void test_playCustomStation_search_logout() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Was not able to login", loginPage.login());
		Assert.assertTrue("Was not able to play a custom station and load it into recent history", 
				customRadio.canPlayCustomStation());
		sideNavBar.logout();
		Assert.assertFalse("Was able to play a custom station after loggingout", 
				customRadio.canPlayCustomStation());
	}
}
