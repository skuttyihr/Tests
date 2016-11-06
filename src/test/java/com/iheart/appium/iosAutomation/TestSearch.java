package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSElement;


public class TestSearch extends TestRoot {

	@Before
	public void setUp() throws Exception {
		TestRoot.setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	@Test
	public void testSearchPageElements(){
		LocalTime before = consoleLogStart("Testing testSearchPageElements");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.showAllElements();
		searchPage.enterTextIntoSearchBar("asdf");
		searchPage.clearSearchBarTextField();
		searchPage.enterTextIntoSearchBar("MORE");
		searchPage.clickCancelButtonOnSearchBar();
		homePage.clickNavBarSearchButtonToOpenSearch();
		consoleLogEnd(before, true, "Tested SearchPage Elements");
	}
	@Test
	public void testSearchPageElementsAndLists(){
		LocalTime before = consoleLogStart("Testing testSearchPageElementsAndLists");
		loginPage.loginWithoutVerifying("search11@test.com", "test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.showAllElements();
		searchPage.enterTextIntoSearchBar("rap");
		searchPage.showAllElementsVoid();
		consoleLogEnd(before, true, "Tested testSearchPageElementsAndLists");
	}
	@Test
	public void testNoResults(){
		LocalTime before = consoleLogStart(">>>>>testNoResults() : Testing testNoResults");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		String searchTerm = "xqWtlzap";
		searchPage.enterTextIntoSearchBar(searchTerm);
		//sk - 11/5/16 - only leaving the actual verification text for novalidresults - commenting out the rest
		TestRoot.sleep(3000);
		boolean invalidSearch = searchPage.isNoResultsCellDisplayedCorrectly();
		Assert.assertTrue("Garbage search should have returned no results cell.", searchPage.isNoResultsCellDisplayedCorrectly());
		/*searchPage.enterBackSpaceKeyIntoSearchBar(4);
		Assert.assertTrue("Deleting one space shouldn't have shown results yet.", searchPage.isNoResultsCellDisplayedCorrectly());
		searchPage.clearSearchBarTextField();
		searchPage.enterTextIntoSearchBar("cvg");
		Assert.assertTrue("Deleting one space shouldn't have shown results yet.", searchPage.isNoResultsCellDisplayedCorrectly());
		searchPage.enterBackSpaceKeyIntoSearchBar(1);
		String cv = searchPage.getSearchBarText();
		Assert.assertEquals( "Entering a backspace should have worked. ", cv , "cv");
		searchPage.clickTopResult();
		boolean isCurentlyOnArtistProfile = artistProfilePage.isCurrentlyOnArtistProfilePage();
		Assert.assertTrue("Should be on ArtistProfile with search term of 'cv'",isCurentlyOnArtistProfile);
		consoleLogEnd(before, isCurentlyOnArtistProfile, "<<<<<Tested testNoResults");*/
		consoleLogEnd(before, invalidSearch, "<<<<<Tested testNoResults");

		
	}
	@Test
	public void testSearchTrackRadio(){
		LocalTime before = consoleLogStart(">>>>>testSearchTrackRadio() : Searching a song, clicking Top Result, hoping for Artist Radio.");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		//sk - 11/5/16- updated to reflect the changed behavior - playing track from search creates <ArtistName> Radio
		String expectedRadioType = "Artist Radio";
		String artistName = "Black Crown Initiate";
		String songName = "Belie The Machine";
		searchPage.enterTextAndPressEnterIntoSearchBar(songName);
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		String actualStationType = fullPlayer.getStationType();
		String actualStationName = fullPlayer.getStationName();
		Assert.assertEquals("Expected Full Player to be on '"+ expectedRadioType + "' but it's not matching up with actual : " + actualStationType, expectedRadioType, actualStationType);
		Assert.assertEquals("Expected Full Player to be on '"+ songName +"' Track Radio but it's not matching up with the Actual : " + actualStationName ,artistName, actualStationName );
		consoleLogEnd(before, expectedRadioType.equals(actualStationType), "<<<<<testSearchTrackRadio() : ");
		
	}
	@Test
	public void testSearchArtistRadio(){
		LocalTime before = consoleLogStart(">>>>>testSearchArtistRadio() : Searching a song, clicking Top Result, hoping for Artist Radio.");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		String artistName = "Black Crown Initiate";
		String expectedRadioType = "Artist Radio";
		searchPage.enterTextAndPressEnterIntoSearchBar(artistName);
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		String actualStationType = fullPlayer.getStationType();
		String actualStationName = fullPlayer.getStationName();
		Assert.assertEquals("Expected Full Player to be on '"+ expectedRadioType + "' but it's not matching up with actual :" + actualStationType, expectedRadioType, actualStationType);
		Assert.assertEquals("Expected Full Player to be on '" + artistName + "' Artist Radio but it's not matching up with actual : " + actualStationName ,artistName, actualStationName );
		consoleLogEnd(before, expectedRadioType.equals(actualStationType), "<<<<<testSearchArtistRadio(). ");
		
	}
	//sk -11/5/16 - Theme Radio has been removed from the app - so commenting out
	/*@Test
	public void testSearchThemeRadio(){
		LocalTime before = consoleLogStart(">>>>>testSearchArtistRadio() : Searching a song, clicking Top Result, hoping for Artist Radio.");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		String themeName = "Heavy Metal Barbell";
		String expectedRadioType = "Theme Radio";
		searchPage.enterTextAndPressEnterIntoSearchBar(themeName);
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		String actualStationType = fullPlayer.getStationType();
		String actualStationName = fullPlayer.getStationName();
		Assert.assertEquals("Expected Full Player to be on '"+ expectedRadioType + "' but it's not matching up with actual :" + actualStationType, expectedRadioType, actualStationType);
		Assert.assertEquals("Expected Full Player to be on '" + themeName + "' but it's not matching up with actual : " + actualStationName ,themeName, actualStationName );
		consoleLogEnd(before, expectedRadioType.equals(actualStationType), "<<<<<testSearchArtistRadio().");
		
	}
	*/
	@Test
	public void testSearchPodcasts(){
		LocalTime before = consoleLogStart(">>>>>testSearchPodcasts() : Searching for 'starta', clicking First Podcast Cell, hoping for Podcast List of episodes");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		String podcastName = "starta";
		searchPage.enterTextAndPressEnterIntoSearchBar(podcastName);
		searchPage.clickFirstPodcastsCell();
		IOSElement episodes = Page.waitForVisible(driver, By.name("Episodes"), 10);
		printElementInformation(episodes);
		Assert.assertTrue("Clicking the first Podcasts Cell for 'starta' should show Episodes of Star Talk",episodes.getText().equals("Episodes"));
		consoleLogEnd(before, true, "<<<<<testSearchPodcasts() : ");
		
	}
	@Test
	public void testSearchLiveRadio(){
		LocalTime before = consoleLogStart(">>>>>testSearchLiveRadio() : Searching for 'rock', clicking First Live Station, hoping for Live Radio.");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		String liveSearchName = "rock";
		String expectedRadioType = "Live Radio";
		searchPage.enterTextIntoSearchBar(liveSearchName);
		searchPage.clickFirstLiveStation();
		miniPlayer.openFullPlayer();
		String actualStationType = fullPlayer.getStationType();
		String actualStationName = fullPlayer.getStationName();
		Assert.assertEquals("Expected Full Player to be on '"+ expectedRadioType + "' but it's not matching up with actual :" + actualStationType, expectedRadioType, actualStationType);
		consoleLogEnd(before, true, "<<<<<testSearchLiveRadio() : " + actualStationType +" : "+ actualStationName);

		
	}

}
