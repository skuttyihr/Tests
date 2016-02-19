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
		TestRoot.tearDown();
	}
	
	@Test
	public void testSearchFilters(){
		long start = System.currentTimeMillis();
		Assert.assertTrue("Was not able to login", loginPage.login()); // Log in so we can choose artist stations later
		System.out.println("Login took " + ((System.currentTimeMillis() - start) / 1000) + " seconds");
		/* Search for "Alt" because "Alt" could be:
		 * The band Alt-J (Trivia: Named for the delta/triangle that comes from typing Alt + J on a Mac)
		 * WFUV On-Air, a radio station, or The Alternative Project, a live station without radio
		 * Alternative Girlfriend by the Barenaked Ladies
		 * The 102.DLG Radio FM Show podcast
		 * And many more, making it good for testing every posible filter for results
		 */
		Assert.assertTrue("Could not search for a term", search.searchForStationWithoutSelecting("Alt"));
		String errors = search.applyFilters();
		Assert.assertTrue("Errors in switching filters:\n" + errors, didPass(errors));
		Assert.assertTrue("Blank search still had results.", !search.searchForStationWithoutSelecting(""));
		errors = search.applyFilters();
		Assert.assertTrue("Filters should have returned no results for blank search",
				errors.contains("Filters had no effect."));
	}
}
