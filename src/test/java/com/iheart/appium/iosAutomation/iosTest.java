package com.iheart.appium.iosAutomation;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;


public class iosTest extends TestRoot {

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
		loginPage.login();
		forYouPage.createArtistStation();
	}

	@Test
	public void test_playPodcasts_skip_share() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		loginPage.login();
		podcastsPage.playPodcasts();
	}

	@Test
	public void test_playLiveRadio_thumbUP_thumbDown_doFavorite() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		loginPage.login();
		forYouPage.playLiveRadio();
	}

	@Test
	public void test_playCustomStation_search_logout() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		loginPage.login();
		perfectForPage.playCustomStation();
	}
}
