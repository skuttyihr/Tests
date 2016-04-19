package com.iheart.appium.iosAutomation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSElement;

public class TestPages extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
	
	@Test
	public void testForLogoAndTitleOnPages(){
		loginPage.loginWithoutVerifying();
		// Verify each page
		Assert.assertTrue("Logo was not visible", isVisible(Page.iheartradio_logo_full));
		homePage.gotoMyStations();
		Assert.assertTrue("Logo was not visible on My Stations", isVisible(Page.iheartradio_logo_full));
		homePage.gotoLocalRadio();
		Assert.assertTrue("Logo was not visible on Local Radio", isVisible(Page.iheartradio_logo_full));
		sideNavBar.gotoLiveRadioPage();
		Assert.assertTrue("Live radio page should not have logo", !isVisible(Page.iheartradio_logo_full));
		IOSElement liveRadio = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"));
		Assert.assertTrue("Live Radio page was not visible", isVisible(liveRadio));
		Assert.assertTrue("Live Radio page did not have title of 'Live Radio'", 
				liveRadio.getText().equals("Live Radio"));
		sideNavBar.gotoLiveArtistPage();
		Assert.assertTrue("Artist Radio page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Artist Radio page did not have title of 'Artist Radio'", 
				isVisible(findElement(driver, By.name("Artist Radio"))));
		sideNavBar.gotoPodcastsPage();
		Assert.assertTrue("Podcast page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Podcast page did not have title of 'Podcast'", 
				isVisible(findElement(driver, By.name("Podcast"))));
		sideNavBar.gotoPerfectFor();
		Assert.assertTrue("Perfect For page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Perfect For page did not have title of 'Perfect For'", 
				isVisible(findElement(driver, By.name("Perfect For"))));
		sideNavBar.gotoListeningHistoryPage();
		Assert.assertTrue("Listening History page should not have logo", !isVisible(Page.iheartradio_logo_full));
		IOSElement listeningHistory = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[2]"));
		Assert.assertTrue("Listening History page title was not visible", isVisible(listeningHistory));
		Assert.assertTrue("Listening History page did not have title of 'Listening History'", 
								listeningHistory.getText().equals("Listening History"));
		// Items that require login
		sideNavBar.gotoAlarm();
		//loginPage.loginWithoutVerifying();  //Failed here when in, TC passed when commented out. 
		// We went into alarm, as expected
		Assert.assertTrue("Alarm page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Alarm Clock page did not have title of 'Alarm Clock'", 
				isVisible(findElement(driver, By.name("Alarm Clock"))));
		sideNavBar.gotoSleep();
		Assert.assertTrue("Sleep page should not have logo", !isVisible(Page.iheartradio_logo_full));
		Assert.assertTrue("Sleep Timer page did not have title of 'Sleep Timer'", 
				isVisible(findElement(driver, By.name("Sleep Timer"))));
	}
	
}
