package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.iheart.appium.utilities.Errors;
import com.iheart.appium.utilities.TestRoot;
import com.iheart.appium.utilities.TestRoot.Stable;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


public class TestCuratedPlaylist extends TestRoot {
	
	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	@Rule
	public RetryRule retry = new RetryRule(1);
	
	@Test
	@Category(RCStable.class)
	public void CUR1_testPlaylistProfilePageMetadata_PLUS() {
		LocalTime before = consoleLogStart("Testing elements on Curated Playlist Page Metadata - Plus User - testPlaylistProfilePageMetadata_CUR_1_PLUS().");
		loginPage.loginVerifyEntitlement(IHEARTPLUSUSERNAME, IHEARTPLUSPASSWD, "PLUS");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.searchAndPlayPlaylist("workout hits");
		Errors err = curatedPlaylistPage.verifyPlaylistProfilePage();
		Assert.assertEquals("Curated Playlist profile page metadata and image test failed", true, err.noErrors());
		consoleLogEnd(before, true, "Plus User - Curated Playlist Profile Page Title, Description, Image, Curator Details and Date are displayed.");
	}
	
	@Test
	@Category(RCStable.class)
	public void CUR2_testPlaylistProfilePageMetadata_ALLA() {
		LocalTime before = consoleLogStart("Testing elements on Curated Playlist Page Metadata - Plus User - testPlaylistProfilePageMetadata_CUR_2_ALLA()");
		loginPage.loginVerifyEntitlement(IHEARTPREMIUMUSERNAME, IHEARTPREMIUMPASSWD,"ALLA");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.searchAndPlayPlaylist("workout hits");
		Errors err = curatedPlaylistPage.verifyPlaylistProfilePage();
		Assert.assertEquals("Curated Playlist profile page metadata and image test failed",  0, err.getErrors().length());
		consoleLogEnd(before, true, "AA User - Curated Playlist Profile Page Title, Description, Image, Curator Details and Date are displayed.");
	}
	
	@Test
	@Category(RCStable.class)
	public void CUR3_testPlaylistProfilePageOverflow_PLUS() {
		LocalTime before = consoleLogStart("Testing elements on Curated Playlist Page Metadata - Plus User - test page overflow menu");
		loginPage.loginVerifyEntitlement(IHEARTPLUSUSERNAME, IHEARTPLUSPASSWD, "PLUS");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.searchAndPlayPlaylist("ambient pop");
		Errors err = curatedPlaylistPage.verifyPlaylistProfilePageOverflow("PLUS");
		Assert.assertEquals("Curated Playlist profile page  - Page Overflow menu test failed for Plus User: ",  true, err.noErrors());
		consoleLogEnd(before, true, "Plus User - Curated Playlist Profile Page Overflow options  - Save Playlist and Share Menu tested.");
	}	
}
