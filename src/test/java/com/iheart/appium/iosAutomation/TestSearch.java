package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSearch extends TestRoot {

	@Before
	public void setUp() throws Exception {
		TestRoot.setup();
	}
	@After
	public void after() {
		// Remove favorites
//		homePage.removeAllFavorites();
		TestRoot.tearDown();
	}

	/**
	* Search for "Alt" because "Alt" could be:
	* The band Alt-J (Trivia: Named for the delta/triangle that comes from typing Alt + J on a Mac)
	* WFUV On-Air, a radio station, or The Alternative Project, a live station without radio
	* Alternative Girlfriend by the Barenaked Ladies
	* The 102.DLG Radio FM Show podcast
	* And many more, making it good for testing every possible filter for results
	*/
	 
	@Test
	public void testHomeSearch(){
		try{
		Assert.assertTrue("Was not able to login", loginPage.login()); // Log in so we can choose artist stations later
	
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
		
		// Search for an artist based on song title 
		search.clearSearch();
		String searchSong = "Basket Case";
		search.searchForStationWithoutSelecting(searchSong);
		Assert.assertTrue(searchSong + " was not found in results.", search.isResultListed(searchSong));
	}
	catch(Exception e)
	{
		Page.handleError("Home Page Search failed", "testHomeSearch");
	}
}
	
	/**
	 * Tests live stations can be searched for by name, keyword, and frequency.
	 */
	@Test
	public void testSearchForLiveStation(){
	try{
		LocalTime before = consoleLogStart("testSearchForLiveStation - tests name, keyword, and frequency");
		// log in
		loginPage.loginWithoutVerifying();
		// Get to the live radio page via sidebar and enter zip if requested
		sideNavBar.getToAndEnterZip("10013");
		// Go back to home page to search
		sideNavBar.gotoHomePage();
		String[] searchFor = {"100.3", "Z100", "Hit Music"};
		search.searchForStationWithoutSelecting(searchFor[0]); 
		// Check that Z100 is the first result under "All" and "Stations" filters.
		Assert.assertTrue(searchFor[1] + " was not found for frequency search of " + searchFor[0], search.isResultListed(searchFor[1]));
		search.clearSearch();
		search.searchForStationWithoutSelecting(searchFor[1]);
		Assert.assertTrue(searchFor[1] + " was not found", search.isResultListed(searchFor[1]));
		// Search for key phrase
		search.clearSearch();
		search.searchForStationWithoutSelecting(searchFor[2]);
		Assert.assertTrue(searchFor[1] + " was not found", search.isResultListed(searchFor[1]));
	}
	catch(Exception e)
		{
			Page.handleError("Search for Live Station Failed", "SearchForLiveStation()");
		}
	}
	
}
