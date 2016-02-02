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

	@Test
	public void test_createArtistStation_thumbUp_thumbDown_favorite_skip() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			forYouPage.createArtistStation();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_playPodcasts_skip_share() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			podcastsPage.playPodcasts();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_loginViaFacebook() throws Exception {
		try {
			loginPage.loginViaFacebook();

		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_playLiveRadio_thumbUP_thumbDown_doFavorite() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			forYouPage.playLiveRadio();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_playCustomStation_search_logout() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			perfectForPage.playCustomStation();

		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_createAnAccount() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			signupPage.createAnAccount();

		} catch (Exception e) {
			handleException(e);
		}
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}

	private void handleException(Exception e) {
		Page.getErrors().append("Exception is thrown.");
		e.printStackTrace();
	}
}
