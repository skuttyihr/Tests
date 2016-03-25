package com.iheart.appium.iosAutomation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHomePage extends TestRoot {

	@Before
	public void setUp() throws Exception {
		TestRoot.setup();
	}
	@After
	public void after() {
		// Remove favorites
		homePage.removeAllFavorites();
		TestRoot.tearDown();
	}
	
	private void searchAndGoHome(String s){
		search.searchForStation(s);
		player.minimizePlayer();
		search.cancel.click();
		
		sideNavBar.gotoHomePage(); // Ensure we're on the home page
	}
	
	private void assertScrollAndShowMore(){
		List<String> visibleItems = homePage.getVisibleListItems();
		Assert.assertTrue(visibleItems.size() > 0);
		Assert.assertTrue("Could not swipe to Show More button", Page.swipeToShowMore());
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
	
	@Test
	public void testAddToFavoritesFromHome(){
		Assert.assertTrue("Was not able to login", loginPage.login()); // Log in so we can favorite stations
		
		// Search for an item so we know what we're working with
		String artist = "Tegan and Sara";
		searchAndGoHome(artist); 
		homePage.gotoForYou();
		int listItem = 1;
		String addErrors = homePage.toggleListItemFavorites(listItem);
		if(addErrors.startsWith("switch to")){
			try{
				listItem = Integer.parseInt(addErrors.replace("switch to ", ""));
			}
			catch(Exception e){
				System.err.println(addErrors);
			}
			finally{
				addErrors = "";
			}
		}
		String station = homePage.getListItem(listItem).getText();
		if(station.contains(",")){
			station = station.substring(0, station.indexOf(","));
		}
		Assert.assertTrue("Could not tap add to favorites for this item." + addErrors, didPass(addErrors));
		Assert.assertTrue("Station was not added to favorites", homePage.isStationAFavorite(station) > 0);
		
		// Remove the station through the toggle now
		homePage.gotoForYou();
		addErrors = homePage.toggleListItemFavorites(listItem);
		if(addErrors.startsWith("switch to")){
			try{
				listItem = Integer.parseInt(addErrors.replace("switch to ", ""));
			}
			catch(Exception e){
				System.err.println(addErrors);
			}
			finally{
				addErrors = "";
			}
		}
		station = homePage.getListItem(listItem).getText();
		if(station.contains(",")){
			station = station.substring(0, station.indexOf(","));
		}
		Assert.assertTrue("Could not tap add to favorites for this item." + addErrors, didPass(addErrors));
		Assert.assertFalse("Station was still in favorites", homePage.isStationAFavorite(station) > 0);
	}
	
	@Test
	public void testAddToFavoritesFromRecents(){
		// Log in, load up a station, check that it's in recents, add it to favorites, check that it's a favorite as well as a recent. 
		loginPage.loginWithoutVerifying();
		
		String artist = "Tegan and Sara";
		searchAndGoHome(artist);
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
		Assert.assertTrue(artist + " was not a recent station.", artistValue > 0);
		
		// Now remove from favorites
		// Might not be the first element
		int removeItem = homePage.searchForStation(artist);
		Assert.assertTrue(removeItem > 0);
		toggleErrors = homePage.toggleListItemFavorites(removeItem);
		Assert.assertTrue("Station was not removed from favorites", homePage.isStationAFavorite(artist) < 0);
	}
	
	@Test
	public void testAddToFavoritesFromLocalRadio(){
		// Log in, go to Live/Local Radio tab, add a station, check my stations for it being there
		Assert.assertTrue("Was not able to login", loginPage.login());
		sideNavBar.gotoHomePage();
		homePage.gotoLocalRadio();
		Page.enterZip();
		// Grab the name of the station
		String stationName = homePage.getStationNameFromListItem(1);
		Assert.assertTrue("Station name was empty", strGood(stationName));
		// Play the first station
		Assert.assertTrue("Could not play the first local radio station.", homePage.selectListItem(1));
		Assert.assertTrue("Did not start playing", player.isPlaying());
		// Only minimize if we have to
		if(player.isPlayingInPlayer()){
			player.minimizePlayer();
		}
		if(stationName.contains(",")){
			stationName = stationName.substring(0,  stationName.indexOf(","));
		}
		Assert.assertTrue("Could not grab a station name", strGood(stationName));
		// Add to favorites
		String toggleErrors = homePage.toggleListItemFavorites(1);
		Assert.assertTrue("Encountered errors adding recent item to favorites by swiping and tapping button.",
				didPass(toggleErrors));
		homePage.gotoMyStations();
		Assert.assertTrue("Station was not added to favorites", homePage.isStationAFavorite(stationName) > 0);
		Assert.assertTrue("Station was not in recents as well as favorites", homePage.isStationARecent(stationName) > 0);
	}
	
	@Test
	public void testShowMore(){
		// Show More is on For You and My Stations
		// Scroll to bottom of each list, verify what's visible, then keep scrolling
		// Use XPath to grab visible names, as any other method will hold them even if they're not visible
		loginPage.loginWithoutVerifying();
		sideNavBar.gotoHomePage();
		// Play some stations to be sure we have a history of at least a few stations.
		Assert.assertTrue("Could not load up some stations in history.", didPass(homePage.loadUpStations(3)));
		
		// Test scroll and show more for For You section
		assertScrollAndShowMore();

		// Doing the same for the mystations page
		homePage.gotoMyStations();
		assertScrollAndShowMore();
	}
	
	@Test
	public void testScrollAndTapBar(){
		// Test that we can scroll to the bottom, then jump back to the top
		signupPage.skipLogin();
		sideNavBar.gotoHomePage();
		List<String> topItems = homePage.getVisibleListItems();
		for(int i = 0; i < 3; i++)
			swipeUp();
		List<String> bottomItems = homePage.getVisibleListItems();
		Assert.assertTrue("Could not scroll!", !topItems.equals(bottomItems));
		// Tap the top status bar
		homePage.statusBar.click();
		// We're back at the top
		List<String> newTopItems = homePage.getVisibleListItems();
		Assert.assertTrue("Could not scroll back to top!", topItems.equals(newTopItems));
	}
	
	@Test
	public void testSearchForLiveStation(){
		// Tests ability to search for live stations based on:
		//	Keyword, name, station frequency, and song title
		// Tests search filters, to only show live stations
		
		// log in, as anonymous use will be phased out
		loginPage.loginWithoutVerifying();
		search.searchForStationWithoutSelecting("100.3"); // Z100 Frequency in NY
		// Check that Z100 is the first result under "All" and "Stations" filters.
	}
}
