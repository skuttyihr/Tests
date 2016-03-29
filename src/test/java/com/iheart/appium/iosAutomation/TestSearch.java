package com.iheart.appium.iosAutomation;

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
		homePage.removeAllFavorites();
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
		 * And many more, making it good for testing every possible filter for results
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
	public void testSearchForLiveStation(){
		// Tests ability to search for live stations based on:
		//	Keyword, name, station frequency, and song title
		// Tests search filters, to only show live stations
		
		// log in, as anonymous use will be phased out
		loginPage.loginWithoutVerifying();
		// TODO Ensure we're getting 10013 zipcode results... may have to actually... enter a zipcode!
		String[] searchFor = {"100.3", "Z100"};
		search.searchForStationWithoutSelecting(searchFor[0]); 
		// Check that Z100 is the first result under "All" and "Stations" filters.
		Assert.assertTrue(searchFor[1] + " was not found for frequency search of " + searchFor[0], search.isResultListed(searchFor[1]));
	}
}
