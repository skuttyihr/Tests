package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestArtistProfile extends TestRoot {
	
	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	@Test
	public void testArtistProfileElements(){
		LocalTime before = consoleLogStart("Testing elements on Artist Profile Page - testArtistProfileElements()");
		loginPage.loginWithoutVerifying("artistProfilePage@test.com", "test");
		homePage.clickMyStationsTab();
		//This should play Red Hot Chili Peppers Radio - the only favorite for this account.
		homePage.clickCertainCellOnMyStationsToBeginPlaying(1);
		Assert.assertTrue("Artist Profile should be open for Red Hot Chili Peppers", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("MiniPlayer should be open for Red Hot Chili Peppers", miniPlayer.isCurrentlyOnMiniPlayer());
		artistProfilePage.showAllElements();
		consoleLogEnd(before, true, "Tested testArtistProfileElements().");
		
	}
	@Test
	public void testArtistProfileFunctions(){
		LocalTime before = consoleLogStart("Testing methods on Artist Profile Page");
		loginPage.loginWithoutVerifying("artistProfileFunctions@test.com", "test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Rihanna");
		searchPage.clickTopResult();
		Assert.assertTrue("Artist Profile should be open for Rihanna", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("MiniPlayer should be open for Rihanna", miniPlayer.isCurrentlyOnMiniPlayer());
		Assert.assertEquals("Rihanna should be the Artist Profile  Bio Header Label", "Rihanna", artistProfilePage.getArtistProfileArtistName());
		Assert.assertEquals("Rihanna's Latest Release should be Sledgehammer", "Sledgehammer", artistProfilePage.getLatestReleaseAlbumTitle());
		consoleLogEnd(before, true, "Tested testArtistProfileFunctions()");
	}
}
