package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;

import com.iheart.appium.utilities.TestRoot;


public class TestPages extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

	// @After
	// public void after() {
	// TestRoot.tearDown();
	// }

	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	//@Test
	// @Ignore
	/**
	 * Test for Logo and Title on Pages. Checks a variety of Logos and Titles
	 * and whether they are visible or not. Includes MyStations, Local Radio,
	 * Live Radio, Live Artist Page, Podcasts Page, Perfect For, Listening
	 * History, Alarm, & Sleep
	 * 
	 */
	public void testForLogoAndTitleOnPages() {
		LocalTime before = consoleLogStart(
				"Testing testForLogoAndTitleOnPages()- checks Logos and Titles for MyStations, Local Radio, Live Radio, Live Artist Page, Podcasts Page, Perfect  For, Listening History, Alarm, & Sleep");
		loginPage.loginVerifyEntitlement("trav@free.com", "travfree", "FREE");
		// Verify each page
		Assert.assertTrue("Logo was not visible", isVisible(Page.iheartradio_logo_full));
		//homePage.gotoMyStations();
		Assert.assertTrue("Logo was not visible on My Stations", isVisible(Page.iheartradio_logo_full));
		//homePage.gotoLocalRadio();
		Assert.assertTrue("Logo was not visible on Local Radio", isVisible(Page.iheartradio_logo_full));
		sideNavBar.gotoLiveRadioPage();
		Assert.assertTrue("Live radio page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Live Radio page was not visible", Page.liveRadio.isDisplayed());
		Assert.assertTrue("Live Radio page did not have title of 'Live Radio'",
				Page.liveRadio.getText().equals("Live Radio"));
		sideNavBar.gotoArtistPage();
		Assert.assertTrue("Artist Radio page should not have logo", !isVisible(Page.iheartradio_logo_full));
		sleep(4000);
		Assert.assertTrue("Artist Radio page did not have title of 'Artist Radio'",
				Page.artistRadio.getAttribute("value").equals("Artist Radio"));
		sideNavBar.gotoPodcastsPage();
		Assert.assertTrue("Podcast page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Podcast page did not have title of 'Podcasts'",
				Page.podcasts.getAttribute("value").equals("Podcasts"));
		// sk - 11/5 - n/a anymore so commenting out
		// sideNavBar.gotoPerfectFor();
		// Assert.assertTrue("Perfect For page should not have logo",
		// !isVisible(Page.iheartradio_logo_full));
		// Assert.assertTrue("Perfect For page did not have title of 'Perfect
		// For'",
		// isVisible(findElement(driver, By.name("Perfect For"))));
		sideNavBar.gotoListeningHistoryPage();
		Assert.assertTrue("Listening History page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Listening History page title was not visible",
				Page.listeningHistory.getText().equals("Listening History"));
		Assert.assertTrue("Listening History page did not have title of 'Listening History'",
				Page.listeningHistory.getText().equals("Listening History"));
		// Items that require login
		sideNavBar.gotoAlarm();
		// We went into alarm, as expected
		Assert.assertTrue("Alarm page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Alarm Clock page did not have title of 'Alarm Clock'",
				Page.alarmClock.getText().equals("Alarm Clock"));
		sideNavBar.gotoSleep();
		Assert.assertTrue("Sleep page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Sleep Timer page did not have title of 'Sleep Timer'",
				Page.sleepTimer.getText().equals("Sleep Timer"));
		consoleLogEnd(before, true, "Tested testForLogoAndTitleOnPages()");
	}

}
