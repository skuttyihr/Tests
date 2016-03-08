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
		Page.removeAllFavorites();
		TestRoot.tearDown();
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
		search.searchForStation("Tegan and Sara");
		player.minimizePlayer();
		search.cancel.click();
		
		sideNavBar.gotoHomePage(); // Ensure we're on the home page 
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
}
