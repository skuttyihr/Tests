package com.iheart.appium.iosAutomation;

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
	
	@Test
	public void testHomeSearch(){
		Assert.assertTrue("Was not able to login", loginPage.login()); // Log in so we can choose artist stations later
		/* Search for "Alt" because "Alt" could be:
		 * The band Alt-J (Trivia: Named for the delta/triangle that comes from typing Alt + J on a Mac)
		 * WFUV On-Air, a radio station, or The Alternative Project, a live station without radio
		 * Alternative Girlfriend by the Barenaked Ladies
		 * The 102.DLG Radio FM Show podcast
		 * And many more, making it good for testing every posible filter for results
		 */
		Assert.assertTrue("Could not search for a term", search.searchForStationWithoutSelecting("Alt"));
		// Assert that we can filter the search results
		String errors = search.applyFilters();
		Assert.assertTrue("Errors in switching filters:\n" + errors, didPass(errors));
		// Assert emptiness of blank search
		Assert.assertTrue("Blank search still had results.", !search.searchForStationWithoutSelecting(""));
		errors = search.applyFilters();
		Assert.assertTrue("Filters should have returned no results for blank search",
				errors.contains("Filters had no effect."));
		
		// Search that garbage input gives us nothing
		search.applyFilter("all");
		String badSearch = "dfgkjhqz";
		Assert.assertFalse("Garbage search should have returned no results.", search.searchForStationWithoutSelecting(badSearch));
		Assert.assertTrue("Results were returned for bad input", search.areResultsEmpty(badSearch));
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
		Assert.assertTrue("Was not able to login", loginPage.login()); 
		
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
		toggleErrors = homePage.toggleListItemFavorites(1);
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
}
