package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGenre extends TestRoot{

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
	
	/**
	 * Verifies all the genres on the genre page and ensures that all are present. 
	 * Then it swipes to the top of the page, selects some genres, handles popups, 
	 * improvesRecommendations, and deselects and reselects Top 40.
	 */
	//@Test
	public void testGenreGameForNewAccount(){
		LocalTime before = consoleLogStart("Testing Genre Game for New Account.");
		Assert.assertTrue("Could not create a new account and get the genre picker", signupPage.createAnAccount());
		// Assert all genres are present
		String missingGenres = genrePage.verifyGenres();
		Assert.assertTrue("Not all expected genres were present!\nMissing:\n" + missingGenres, missingGenres.length() <= 0);
		// Select multiple genres, both by name and by position on list.
		for(int i = 0; i < 4; i++){
			swipeDown(); // Scrolls back to the top of the genre page
		}
		int[] genres = {3, 4};
		genrePage.selectGenres(genres, false);
		genrePage.selectGenre("Top 40 & Pop"); // This one will click done
		Page.handlePossiblePopUp(); // Yet another popup
		Assert.assertTrue("Could not select genre", isVisible(Page.iheartradio_logo_full));
	
		// Perish pesky popups!
		Page.handlePossiblePopUp();
		
		// Test genre game improve recommendations
		Assert.assertTrue("Could not click improve recommendations to get to genre selection page", genrePage.improveRecommendations());
		// Make sure everything we selected earlier is still selected and saved
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected(3));
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected(4));
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected("Top 40 & Pop"));
		genrePage.deselectGenre("Top 40 & Pop", false);
		Assert.assertTrue("Could not deselect genre!", !genrePage.isGenreSelected("Top 40 & Pop"));
		genrePage.selectGenre("Top 40 & Pop", false);
		Assert.assertTrue("Could not verify genre after deselecting and selecting again!", genrePage.isGenreSelected("Top 40 & Pop"));
		
		consoleLogEnd(before, true,  "Tested Genre Game for New Account"); 
	}
}
