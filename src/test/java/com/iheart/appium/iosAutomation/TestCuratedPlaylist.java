package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.iheart.appium.utilities.Errors;
import com.iheart.appium.utilities.TestRoot;


public class TestCuratedPlaylist extends TestRoot {
	
	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	@Test
	public void testPlaylistProfilePageMetadata_CUR1_PLUS() {
		LocalTime before = consoleLogStart("Testing elements on Curated Playlist Page Metadata - Plus User - testPlaylistProfilePageMetadata_CUR_1_PLUS().");
		loginPage.loginVerifyEntitlement(IHEARTPLUSUSERNAME, IHEARTPLUSPASSWD, "PLUS");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.searchAndPlayPlaylist("workout hits");
		Errors err = curatedPlaylistPage.verifyPlaylistProfilePage();
		//Assert.assertEquals("Curated Playlist profile page metadata and image test failed", true, err.noErrors());
		Assert.assertTrue("String for error: " + err, err.noErrors());
		consoleLogEnd(before, true, "Plus User - Curated Playlist Profile Page Title, Description, Image, Curator Details and Date are displayed.");
	}
	
	@Test
	public void testPlaylistProfilePageMetadata_CUR2_ALLA() {
		LocalTime before = consoleLogStart("Testing elements on Curated Playlist Page Metadata - Plus User - testPlaylistProfilePageMetadata_CUR_2_ALLA()");
		loginPage.loginVerifyEntitlement(IHEARTPREMIUMUSERNAME, IHEARTPREMIUMPASSWD,"ALLA");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.searchAndPlayPlaylist("workout hits");
		Errors err = curatedPlaylistPage.verifyPlaylistProfilePage();
		Assert.assertEquals("Curated Playlist profile page metadata and image test failed",  0, err.getErrors().length());
		consoleLogEnd(before, true, "AA User - Curated Playlist Profile Page Title, Description, Image, Curator Details and Date are displayed.");
	}
	
}