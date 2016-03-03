package com.iheart.appium.iosAutomation;

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
	
	@Test
	public void testGenreGameForNewAccount(){
		Assert.assertTrue("Could not create a new account and get the genre picker", signupPage.createAnAccount());
		// Assert all genres are present
		String missingGenres = genrePage.verifyGenres();
		Assert.assertTrue("Not all expected genres were present!\nMissing:\n" + missingGenres, missingGenres.length() <= 0);
		// Select multiple genres, both by name and by position on list.
		for(int i = 0; i < 4; i++){
			swipeDown();
		}
		int[] genres = {3, 4};
		genrePage.selectGenres(genres, false);
		genrePage.selectGenre("Top 40 & Pop"); // This one will click done
		Assert.assertTrue("Could not select genre", isVisible(Page.iheartradio_logo_full));
	
		// Perish pesky popups!
		Page.handlePossiblePopUp();
		
		// Test genre game improve recommendations
		Assert.assertTrue("Could not click improve recommendations to get to genre selection page", genrePage.improveRecommendations());
		// Make sure everything we selected earlier is still selected and saved
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected(3));
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected(4));
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected("Top 40 & Pop"));
		genrePage.selectGenre("Top 40 & Pop", false);
		Assert.assertTrue("Could not deselect genre!", !genrePage.isGenreSelected("Top 40 & Pop"));
		genrePage.selectGenre("Top 40 & Pop", false);
		Assert.assertTrue("Could not verify genre after deselecting and selecting again!", genrePage.isGenreSelected("Top 40 & Pop"));
	}
	
	@Test
	public void testGenreGameForMaybeLater(){
		// Anonymous users get love too
		signupPage.skipLogin();
		Assert.assertTrue("Could not click improve recommendations to get to genre selection page", genrePage.improveRecommendations());
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected("Top 40 & Pop"));
	}
	
}
