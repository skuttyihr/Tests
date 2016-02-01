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
	public void test_AIOS_22674_createArtistStation_thumbUp_thumbDown_favorite_skip() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			forYouPage.AIOS_22674_createArtistStation();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22697_playPodcasts_skip_share() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			podcastsPage.AIOS_22697_playPodcasts();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22669_loginViaFacebook() throws Exception {
		try {
			loginPage.AIOS_22669_loginViaFacebook();

		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22673_playLiveRadio_thumbUP_thumbDown_doFavorite() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			forYouPage.AIOS_22673_playLiveRadio();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22642_playCustomStation_search_logout() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			perfectForPage.AIOS_22642_playCustomStation();

		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22672_createAnAccount() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			signupPage.AIOS_22672_createAnAccount();

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
