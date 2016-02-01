package com.iheart.appium.iosAutomation;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

public class RunOnRealDevice extends TestRoot{

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {

		// BasicConfigurator.configure();
		// driver = Utils.launchAPPinSimulator();
		driver = Utils.launchAPPinRealDevice(DEVICE_NAME, UDID, BUNDLE_ID, IPA_NAME);

		Page.setDriver(driver);

		loginPage = new LoginPage(driver);
		signupPage = new SignUpPage(driver);
		player = new Player(driver);
		sideNavBar = new SideNavigationBar(driver);

		forYouPage = new ForYouPage(driver);
		perfectForPage = new PerfectForPage(driver);
		podcastsPage = new PodcastsPage(driver);

		deepLink = new DeepLink(driver);

	}

	@Ignore("skip")
	public void test_AIOS_22697_playPodcasts() throws Exception {

		try {
			loginPage.login();
			podcastsPage.AIOS_22697_playPodcasts();
		} catch (Exception e) {
			e.printStackTrace();
			Utils.takeScreenshot(driver, "AIOS_22697_playPodcasts");
		}
	}

	@Ignore("skip")
	public void test_AIOS_22674_createArtistStation() throws Exception {
		try {
			loginPage.login();
			forYouPage.AIOS_22674_createArtistStation();
		} catch (Exception e) {
			e.printStackTrace();
			Utils.takeScreenshot(driver, "AIOS_22674_createArtistStation");
		}
	}

	@Ignore("SKIP")
	public void test_AIOS_22673_playLiveRadio() throws Exception {
		try {
			loginPage.login();
			forYouPage.AIOS_22673_playLiveRadio();
		} catch (Exception e) {
			e.printStackTrace();
			Utils.takeScreenshot(driver, "AIOS_22673_playLiveRadio");
		}
	}

	@Ignore("skip")
	public void test_AIOS_22642_playCustomStation() throws Exception {
		try {
			loginPage.login();
			forYouPage.AIOS_22673_playLiveRadio();
			perfectForPage.AIOS_22642_playCustomStation();

		} catch (Exception e) {
			e.printStackTrace();
			Utils.takeScreenshot(driver, "testLogin");
		}
	}

	@Ignore("Skip")
	public void test_AIOS_22669_loginViaGoogle() throws Exception {
		try {
			loginPage.loginViaGoogle();

		} catch (Exception e) {
			e.printStackTrace();
			Utils.takeScreenshot(driver, "testLogin");
		}
	}

	@Ignore("skip")
	public void test_AIOS_22669_loginViaFacebook() throws Exception {
		try {

			loginPage.AIOS_22669_loginViaFacebook();
		} catch (Exception e) {
			e.printStackTrace();
			Utils.takeScreenshot(driver, "testLogin");
		}
	}

	@Test
	public void test_AIOS_22672_createAnAccount() throws Exception {
		try {
			signupPage.AIOS_22672_createAnAccount();

		} catch (Exception e) {
			e.printStackTrace();
			Utils.takeScreenshot(driver, "test_AIOS_22672_createAnAccount");
		}
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
}
