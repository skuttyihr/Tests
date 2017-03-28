package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

import com.iheart.appium.iosAutomation.AppboyUpsellsPage.Entitlement;
import com.iheart.appium.utilities.TestRoot;
import com.iheart.appium.utilities.TestRoot.RCStable;

import io.appium.java_client.ios.IOSElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSearch extends TestRoot {

	@Before
	public void setUp() throws Exception {
		TestRoot.setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	@Rule
	public RetryRule retry = new RetryRule(1);
	
	@Test
	@Category(RCStable.class)
	public void SEA1_testSearchPageResults_FREE(){
		LocalTime before = consoleLogStart("Testing testSearchPageResults_SEA1_FREE");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("search11@Test.com", "test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.showAllElements();
		searchPage.enterTextIntoSearchBar("rap");
		searchPage.showAllElementsVoid();
		consoleLogEnd(before, true, "Tested testSearchPageResults_SEA1_FREE");
	}
	@Test
	@Category(RCStable.class)
	public void SEA2_testSearchPageTextfield_FREE(){
		LocalTime before = consoleLogStart("Testing testSearchPageTextfield_SEA2_FREE");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test55@Test.com","test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.showAllElements();
		searchPage.enterTextIntoSearchBar("asdf");
		searchPage.clearSearchBarTextField();
		searchPage.enterTextIntoSearchBar("MORE");
		searchPage.clickCancelButtonOnSearchBar();
		homePage.clickNavBarSearchButtonToOpenSearch();
		consoleLogEnd(before, true, "Tested testSearchPageTextfield_SEA2_FREE");
	}
	
	@Test
	@Category(Stable.class)
	public void SEA3_testNoResults_FREE(){
		LocalTime before = consoleLogStart(">>>>>testNoResults_SEA3_FREE() : Testing testNoResults");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test55@Test.com","test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		String searchTerm = "xqWtlzap";
		searchPage.enterTextIntoSearchBar(searchTerm);
		//sk - 11/5/16 - only leaving the actual verification text for no valid results - commenting out the rest
		boolean invalidSearch = searchPage.isNoResultsCellDisplayedCorrectly();
		Assert.assertTrue("Garbage search should have returned no results cell.", invalidSearch);
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
		consoleLogEnd(before, invalidSearch, "<<<<<Tested testNoResults_SEA3_FREE");

		
	}
	
	@Test
	@Category(Stable.class)
	public void SEA4_testSearchTrack_FREE(){
		LocalTime before = consoleLogStart(">>>>>testSearchTrack_SEA4_FREE() : Searching a song, clicking Top Result, hoping for Artist Radio.");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test55@Test.com","test",Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		//sk - 11/5/16- updated to reflect the changed behavior - playing track from search creates <ArtistName> Radio
		String expectedRadioType = "Artist Radio";
		String artistName = "Black Crown Initiate";
		String songName = "Belie The Machine";
		searchPage.enterTextAndPressEnterIntoSearchBar(songName);
		searchPage.clickTopResult();
		Assert.assertTrue("Opening Top Result for Searching Track Name should have opened Mini Player with Artist Radio.", miniPlayer.isCurrentlyOnMiniPlayer());
		miniPlayer.openFullPlayer();
		String actualStationType = fullPlayer.getStationType();
		String actualStationName = fullPlayer.getStationName();
		Assert.assertEquals("Expected Full Player to be on '"+ expectedRadioType + "' but it's not matching up with actual : " + actualStationType, expectedRadioType, actualStationType);
		Assert.assertEquals("Expected Full Player to be on '"+ songName +"' Track Radio but it's not matching up with the Actual : " + actualStationName ,artistName, actualStationName );
		consoleLogEnd(before, expectedRadioType.equals(actualStationType), "<<<<<testSearchTrack_SEA4_FREE() : ");
		
	}
	@Test
	@Category(Stable.class)
	public void SEA5_testSearchArtist_FREE(){
		LocalTime before = consoleLogStart(">>>>>testSearchArtist_SEA5_FREE() : Searching a song, clicking Top Result, hoping for Artist Radio.");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test55@Test.com","test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		String artistName = "Black Crown Initiate";
		String expectedRadioType = "Artist Radio";
		searchPage.enterTextAndPressEnterIntoSearchBar(artistName);
		searchPage.clickTopResult();
		Assert.assertTrue("Opening Top Result for Searching Artist Name should have opened Mini Player with Artist Radio.", miniPlayer.isCurrentlyOnMiniPlayer());
		miniPlayer.openFullPlayer();
		String actualStationType = fullPlayer.getStationType();
		String actualStationName = fullPlayer.getStationName();
		Assert.assertEquals("Expected Full Player to be on '"+ expectedRadioType + "' but it's not matching up with actual :" + actualStationType, expectedRadioType, actualStationType);
		Assert.assertEquals("Expected Full Player to be on '" + artistName + "' Artist Radio but it's not matching up with actual : " + actualStationName ,artistName, actualStationName );
		consoleLogEnd(before, expectedRadioType.equals(actualStationType), "<<<<<testSearchArtist_SEA5_FREE(). ");
		
	}
	
	@Test
	@Category(Stable.class)
	public void SEA6_testSearchPlaylist_FREE(){
		LocalTime before = consoleLogStart(">>>>>testSearchPlaylist_SEA6_FREE() : Searching a song, clicking Top Result, hoping for Artist Radio.");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test55@Test.com","test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		String playlistName = "Workout Hits";
//		String expectedRadioType = "Playlist by iHeartRadio";
		searchPage.enterTextAndPressEnterIntoSearchBar(playlistName);
		//sk - 2/8 - the Playlist section is visible, so scrolldown is not required
		//searchPage.scrollSearchResultsCollectionView(SwipeElementDirection.DOWN, 100, 200, 100);
		searchPage.clickFirstPlaylistCell();
		//Playlist Results open
		//Learn More Button
		Assert.assertTrue("Clicking on a Playlist should have opened Upsell Modal", searchPage.isCurrentlyOnLearnMore());
		searchPage.clickLearnMoreButton();
		Assert.assertTrue("Clicking on 'Learn More' Button should have shown Upsell Title Page.", searchPage.isCurrentlyOnUpgradePage());
		consoleLogEnd(before, true, "<<<<<testSearchPlaylist_SEA6_FREE().");
	}
	
	@Test
	@Category(RCStable.class)
	public void SEA7_testSearchPodcasts_FREE(){
		LocalTime before = consoleLogStart(">>>>>testSearchPodcasts_SEA7_FREE() : Searching for 'starta', clicking First Podcast Cell, hoping for Podcast List of episodes");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test55@Test.com","test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		String podcastName = "starta";
		searchPage.enterTextAndPressEnterIntoSearchBar(podcastName);
		searchPage.clickFirstPodcastsCell();
		IOSElement episodes = Page.waitForVisible(driver, By.name("RECENT EPISODES"), 10);
		printElementInformation(episodes);
		Assert.assertTrue("Clicking the first Podcasts Cell for 'starta' should show Episodes of Star Talk",episodes.getText().equals("RECENT EPISODES"));
		searchPage.clickStartTalkPodcastEpisode();
		Assert.assertTrue("Clicking one of the Podcast episdoes should have opened MiniPlayer", miniPlayer.isCurrentlyOnMiniPlayer() );
		consoleLogEnd(before, true, "<<<<<testSearchPodcasts_SEA7_FREE() : ");
		
	}
	
	
	@Test
	@Category(RCStable.class)
	public void SEA8_testSearchLive_FREE(){
		LocalTime before = consoleLogStart(">>>>>testSearchLiveRadio() : Searching for 'rock', clicking First Live Station, hoping for Live Radio.");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("test55@Test.com","test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		String liveSearchName = "rock";
		String expectedRadioType = "Live Radio";
		searchPage.enterTextIntoSearchBar(liveSearchName);
		searchPage.clickFirstLiveStation();
		Assert.assertTrue("Opening Top Result for Searching Live Radio should have opened Mini Player with Live Radio.", miniPlayer.isCurrentlyOnMiniPlayer());
		
		miniPlayer.openFullPlayer();
		String actualStationType = fullPlayer.getStationType();
		String actualStationName = fullPlayer.getStationName();
		Assert.assertEquals("Expected Full Player to be on '"+ expectedRadioType + "' but it's not matching up with actual :" + actualStationType, expectedRadioType, actualStationType);
		consoleLogEnd(before, true, "<<<<<testSearchLiveRadio() : " + actualStationType +" : "+ actualStationName);
	}
	/**
	 * Search result hierarchy displays as such:
		Top Hit: Just displays one top result, top hit not repeated in other sections
		Live Stations: Top 2 live stations plus See More option
		Artists: Top 2 Artists plus See More option
		Tracks: Top 2 Tracks plus See More option. An overflow menu appears with options to Save to My Music/Add to Playlist
		Playlists: Now displays list of Top 2 curated playlists plus See More option. An overflow menu appears with options to Save to My Music/Add to Playlist
		Podcasts: Top 2 Podcasts plus option to see more
	 */
	@Test
	@Ignore
	public void SEA9_testSearchResults_PLUS(){
		
	}
	/**
	 * Search result hierarchy displays as such:
		Top Hit: Just displays one top result, top hit not repeated in other sections
		Live Stations: Top 2 live stations plus See More option
		Artists: Top 2 Artists plus See More option
		Tracks: Top 2 Tracks plus See More option. An overflow menu appears with options to Save to My Music/Add to Playlist
		Playlists: Now displays list of Top 2 curated playlists plus See More option. An overflow menu appears with options to Save to My Music/Add to Playlist
		Podcasts: Top 2 Podcasts plus option to see more
	 */
	@Test
	@Ignore
	public void SEA10_testSearchResults_ALLA(){
		
	}

}
