	package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.iheart.appium.utilities.TestRoot;

public class TestHomePage extends TestRoot {
	
	@Before
	public void setUp() throws Exception {
		TestRoot.setup();
	}
	@After
	public void after() {

	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	
	@Test
	@Ignore
	public void testForYou_HOME1_FREE(){
		LocalTime before = consoleLogStart(">>>>>testForYou_HOME1_FREE() : Testing all elements on HomePage - For You, My Stations, Local Radio");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", "FREE"));
		if(homePage.isCurrentlyOnHomePage()){
			homePage.clickFreeTrialUpsellButton();
			upsellPage.clickCancelButton();
			homePage.printForYouElements();
		}
		consoleLogEnd(before, true, "<<<<<testForYou_HOME1_FREE() : Tested HomePage Elements.");
	}
	
	@Test
	public void testMyStations_HOME2_FREE(){
		LocalTime before = consoleLogStart(">>>>>testMyStations_HOME2_FREE() : Testing all elements on HomePage - For You, My Stations, Local Radio");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", "FREE"));
		if(homePage.isCurrentlyOnHomePage()){
			homePage.clickMyStationsTab();
			homePage.printMyStationsElements();
		}
		consoleLogEnd(before, true, "<<<<<testMyStations_HOME2_FREE() : Tested HomePage Elements.");
	}
	@Test
	@Ignore
	public void testMyMusic_HOME3_FREE(){
		LocalTime before = consoleLogStart(">>>>>testMyStations_HOME3_FREE() : Testing all elements on HomePage - For You, My Stations, Local Radio");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", "FREE"));
		if(homePage.isCurrentlyOnHomePage()){
			homePage.clickMyMusicTab();
			homePage.printMyMusicElements();
			//homePage.showAllElements();
		}
		consoleLogEnd(before, true, "<<<<<testMyStations_HOME3_FREE() : Tested HomePage Elements.");
	}
	
	@Test
	@Ignore
	public void testAddToFavorites_HOME4_FREE(){
		LocalTime before = consoleLogStart(">>>>>testAddToFavorites_HOME4_FREE() : Testing all elements on HomePage - For You, My Stations, Local Radio");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements//@Test.com","test", "FREE"));
		if(homePage.isCurrentlyOnHomePage()){
			
		}
		consoleLogEnd(before, true, "<<<<<testAddToFavorites_HOME4_FREE() : Tested HomePage Elements.");
	}
	@Test
	public void testHomePagePlay_HOME5_FREE(){
		LocalTime before = consoleLogStart(">>>>>testHomePagePlay_HOME5_FREE() : Testing play on HomePage");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements//@Test.com","test", "FREE"));
		boolean startPlaying = homePage.clickFirstStationOnForYouToBeginPlaying();
		Assert.assertTrue("Clicking on the first station in For You should have started a player.", startPlaying);
		consoleLogEnd(before, startPlaying, "<<<<<testHomePagePlay_HOME5_FREE(): Tested HomePage Play");
	}
	
	/**
	 * Unfavorite option is display
		Notice the equalizer on the station that is currently playing
		The option Add to Favorites or remove are displaying
		Station get deleted and station is not playing
		Station is deleted but it keeps playing
		the station is also display under 'Favorite Stations' and the equalizer is only showing near the Favorite Station
		Notice the equalizer on the station that is currently playing
		The option Add to Favorites or remove are displaying
		Station get deleted and station is not playing
		Station is deleted but it keeps playing
		the station is also display under 'Favorite Stations' and the equalizer is only showing near the Favorite Station
	 */
	@Test
	@Ignore
	public void testMiscHomePage_HOME6_FREE(){
	
	}
	/*
	private void assertScrollAndShowMore(){ 
		List<String> visibleItems = homePage.getVisibleListItems();
		Assert.assertTrue(visibleItems.size() > 0);
		IOSElement showMore = Page.swipeToShowMore();
		Assert.assertTrue("Could not swipe to Show More button", showMore != null);
		List<String> visibleItemsAfterSwipe = homePage.getVisibleListItems();
		Assert.assertTrue("Lists before and after swiping should not have been identical!", 
				!visibleItems.equals(visibleItemsAfterSwipe));
		Assert.assertTrue("Could not click show more", Page.clickShowMore());
		swipeUp(); // just to be sure we could load more
		visibleItems = homePage.getVisibleListItems();
		Assert.assertTrue("One or both lists of visible items was null!", visibleItems != null && visibleItemsAfterSwipe != null);
		Assert.assertTrue("Lists before and after swiping and clicking show more should not have been identical!", 
				!visibleItems.equals(visibleItemsAfterSwipe));
	}
	*/
	/**
	 * Log in, add to favorites from home, checks if station is in favorites. 
	*
	@Test
	//@Ignore
	public void testAddToFavoritesFromHome(){
		LocalTime before = consoleLogStart("testAddToFavoritesFromHome() - Login, Swipe Station and try to Add to Favorites ");
		loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", "FREE"));
		createdFavorite = true; // This test will create a favorite
		// Search for an item so we know what we're working with
		String artist = "Tegan and Sara";
		//searchAndGoHome(artist); 
		homePage.gotoForYou();
		int listItem = 1;
		String addErrors = homePage.toggleListItemFavorites(listItem, false); 
		if(addErrors.equals("\n1\n")){ // Means we had to switch to different list item
			addErrors = "";
			listItem = 1;
		}
		String station = homePage.getListItemText(listItem);
		System.out.println("getListItemText() found [" + station + "].");
		Assert.assertTrue("Could not get station", strGood(station));
		if(station.contains(",")){
			station = station.substring(0, station.indexOf(","));
		}
		Assert.assertTrue("Could not tap add to favorites for this item." + addErrors, didPass(addErrors));
		int stationLocation = homePage.isStationAFavorite(station);
		if(stationLocation > 0){
			System.out.println("Found station in 'Favorites', but should have been removed.");
		}
		Assert.assertTrue("Station was not added to Favorites", stationLocation > 0);
		
		// Remove the station through the toggle now
		homePage.gotoForYou();
		addErrors = homePage.toggleListItemFavorites(listItem, true);
		if(addErrors.equals("\n1\n")){ // Means we had to switch to different list item
			addErrors = "";
			listItem = 1;
		}
		station = homePage.getListItemText(listItem);
		Assert.assertTrue("Could not get station", strGood(station));
		if(strGood(station) && station.contains(",")){
			station = station.substring(0, station.indexOf(","));
		}
		Assert.assertTrue("Could not tap 'Add to Favorites' for this item." + addErrors, didPass(addErrors));
		stationLocation = homePage.isStationAFavorite(station);
		if(stationLocation <= 0){
			System.out.println("Could not find station in 'Favorites'.");
		}
		Assert.assertFalse("Station was not added to 'Favorites'", stationLocation > 0);
		consoleLogEnd(before, stationLocation <= 0 ,  "Tested testAddToFavoritesFromHome() in TestHomePage.java."); //Testing the inverse because it's assertFalse
	}
	*/
	/**
	 * Log in, load up a station, check that it's in recents, add it to favorites, check that it's a favorite as well as a recent. 
	 
	@Test
	@Ignore
	public void testAddToFavoritesFromRecents(){
		LocalTime before = consoleLogStart("testAddToFavoritesFromRecents() - Log in, load up a station, check that it's in recents, add it to favorites, check that it's a favorite as well as a recent. ");
		
		loginPage.loginWithoutVerifying();
		createdFavorite = true;
		
		String artist = "Tegan and Sara";
		//searchAndGoHome(artist);
		// Get to my stations (favorites and recents)
		homePage.gotoMyStations();
		int artistValue = homePage.isStationARecent(artist); 
		Assert.assertTrue(artist + " was not a recent station.", artistValue > 0);
		String toggleErrors = homePage.toggleListItemFavorites(artistValue);
		Assert.assertTrue("Encountered errors adding recent item to favorites by swiping and tapping button.",
				didPass(toggleErrors));
		Assert.assertTrue("Station was not added to favorites", homePage.isStationAFavorite(artist) > 0);
		// Should still be in recents
		artistValue = homePage.isStationARecent(artist);
		if(artistValue <= 0){
			System.out.println("Could not find station in recent, trying again.");
			// Try again. 
			sideNavBar.gotoMyStationsPage();
			artistValue = homePage.isStationARecent(artist);
		}
		Assert.assertTrue(artist + " was not a recent station.", artistValue > 0);
		
		// Now remove from favorites
		// Might not be the first element
		int removeItem = homePage.searchForStation(artist);
		Assert.assertTrue(removeItem > 0);
		toggleErrors = homePage.toggleListItemFavorites(removeItem, true);
		Assert.assertTrue("Was not able to remove favorite without errors: " + toggleErrors, didPass(toggleErrors));
		int favoritePos = homePage.isStationAFavorite(artist);
		if(favoritePos >= 0){
			System.out.println("Could not find station in favorites, trying again.");
			// Try again. 
			sideNavBar.gotoMyStationsPage();
			favoritePos = homePage.isStationAFavorite(artist);
		}
		Assert.assertTrue("Station was not removed from favorites", favoritePos < 0);
		consoleLogEnd(before, favoritePos < 0,  "Tested testAddToFavoritesFromRecents() in TestHomePage.java.");
	}
	*/
	/**
	 * testAddToFavoritesFromLocalRadio- Log in, go to Live/Local Radio tab, add a station, check my stations for it being there
	 
	@Test
	@Ignore
	public void testAddToFavoritesFromLocalRadio(){  
		LocalTime before = consoleLogStart("testAddToFavoritesFromLocalRadio- Log in, go to Live/Local Radio tab, add a station, check my stations for it being there ");
		loginPage.loginWithoutVerifying();
		createdFavorite = true;
		sideNavBar.gotoHomePage();
		homePage.gotoLocalRadio();
		Page.enterZip();
		// Grab the name of the station
		String stationName = homePage.getStationNameFromListItem(1);
		Assert.assertTrue("Station name was empty", strGood(stationName));
		// Play the first station
		Assert.assertTrue("Could not play the first local radio station.", homePage.selectListItem(1));
	//	Assert.assertTrue("Did not start playing", player.isPlaying());
		// Only minimize if we have to
		//if(player.isPlayingInPlayer()){
		//	player.minimizePlayer();
	//	}
		if(stationName.contains(",")){
			stationName = stationName.substring(0,  stationName.indexOf(","));
		}
		Assert.assertTrue("Could not grab a station name", strGood(stationName));
		// Add to favorites
		String toggleErrors = homePage.toggleListItemFavorites(1);
		if(toggleErrors.equals("\n1\n")){ // Means we had to switch to different list item
			toggleErrors = "";
		}
		Assert.assertTrue(
				"Encountered errors adding recent item to favorites by swiping and tapping button.\n" 
							+ toggleErrors,
				didPass(toggleErrors));
		homePage.gotoMyStations();
		boolean stationIsAFavorite = homePage.isStationAFavorite(stationName) > 0;
		boolean stationIsARecent = homePage.isStationARecent(stationName) > 0 ;
		Assert.assertTrue("Station was not added to favorites", stationIsAFavorite);
		Assert.assertTrue("Station was not in recents as well as favorites", stationIsARecent);
		consoleLogEnd(before, stationIsAFavorite && stationIsARecent,  "Tested testAddToFavoritesFromLocalRadio() in TestHomePage.java.");
	}
	*/
	/**
	 * // Show More is on For You and My Stations
		// Scroll to bottom of each list, verify what's visible, then keep scrolling
		// Use XPath to grab visible names, as any other method will hold them even if they're not visible
	
	@Test
	@Ignore
	public void testShowMore(){  
		LocalTime before = consoleLogStart("testShowMore() is testing the Show More on the For You and My Stations");
		
		loginPage.loginWithoutVerifying();
		sideNavBar.gotoHomePage();
		// Play some stations to be sure we have a history of at least a few stations.
		Assert.assertTrue("Could not load up some stations in history.", didPass(homePage.loadUpStations(3)));
		
		// Test scroll and show more for For You section
		assertScrollAndShowMore();

		// Doing the same for the mystations page
		homePage.gotoMyStations();
		assertScrollAndShowMore();
		consoleLogEnd(before, true,  "Tested testShowMore() in TestHomePage.java");
	}
	 */
	/**
	 * // Test that we can scroll to the bottom, then jump back to the top

	@Test
	@Ignore
	public void testScrollAndTapBar(){   
		LocalTime before = consoleLogStart("testScrollAndTapBar()");
		loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", "FREE")
		sideNavBar.gotoHomePage();
		List<String> topItems = homePage.getVisibleListItems();
		for(int i = 0; i < 3; i++)
			swipeUp();
		List<String> bottomItems = homePage.getVisibleListItems();
		Assert.assertTrue("Could not scroll!", !topItems.equals(bottomItems));
		// Tap the top status bar
		//homePage.statusBar.click();
		// We're back at the top
		List<String> newTopItems = homePage.getVisibleListItems();
		Assert.assertTrue("Could not scroll back to top!", topItems.equals(newTopItems));
		consoleLogEnd(before, topItems.equals(newTopItems),  "Tested testScrollAndTapBar() in TestHomePage.java");
	}
	 */
}
