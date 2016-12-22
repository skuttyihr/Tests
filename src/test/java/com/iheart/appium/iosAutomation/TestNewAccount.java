package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

public class TestNewAccount extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

	// @After
	// public void after() {
	// tearDown();
	// }

	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	/**
	 * Test: CreateNewAccount creates a new account in iOS. It fills out email,
	 * password, zipcode, birth year(selection), gender, checks Terms and
	 * Conditions, Creates account, and then uses enters a zip code and expects
	 * the Genre page to open.
	 * 
	 */
	@Test
	public void testCreateNewEmailAccount_SIGN1_FREE() {
		LocalTime before = consoleLogStart(
				">>>>>testCreateNewEmailAccount_SIGN1_FREE() : Creating a new account with the default parameters. ");
		Assert.assertTrue(signupPage.createNewAccount());
		consoleLogEnd(before, true, "<<<<<testCreateNewEmailAccount_SIGN1_FREE");

	}
	@Test
	@Ignore
	public void testCreateNewGmailAccount_SIGN2_FREE(){
		
		System.out.println("testCreateNewGmailAccount_SIGN2_FREE() - Isn't created yet.");
		//Can't keep using Gmail accounts
		//Most likely cannot be automated.
	}
	@Test
	@Ignore
	public void testCreateNewFacebookAccount_SIGN3_FREE(){
		System.out.println("testCreateNewFacebookAccount_SIGN3_FREE() - Isn't created yet.");
		//Can't keep using Facebook accounts
		//Most likely cannot be automated.
	}
	@Test
	public void testAllElements_SIGN4_FREE() {
		LocalTime before = consoleLogStart(
				">>>>>testAllElements_SIGN4_FREE() : Checking all the iOS Elements on the Onboarding / Sign Up Page.");
		// We only care about console output here
		signupPage.checkAllElements();
		consoleLogEnd(before, true,
				"<<<<<testAllElements_SIGN4_FREE() : Test completed and all elements must be on the Onboarding Screen as expected.");
	}

	/**
	 * Verifies all the genres on the genre page and ensures that all are
	 * present. Then it swipes to the top of the page, selects some genres,
	 * handles popups, improvesRecommendations, and deselects and reselects Top
	 * 40.
	 */
	@Test
	public void testGenreGameForNewAccount_GEN1_FREE() {
		LocalTime before = consoleLogStart(">>>>>testGenreGameForNewAccount_GEN1_FREE(): Testing Genre Game for New Account.");
		Assert.assertTrue("Could not create a new account and get the genre picker", signupPage.createNewAccount());
		Assert.assertFalse("Done Button shouldn't be enabled for a new account.", genrePage.isDoneEnabled());
		// Assert all genres are present
		String missingGenres = genrePage.verifyGenres();
		Assert.assertTrue("Not all expected genres were present!\nMissing:\n" + missingGenres,
				missingGenres.length() <= 0);
		// Select multiple genres, both by name and by position on list.
		for (int i = 0; i < 4; i++) {
			swipeDown(); // Scrolls back to the top of the genre page
		}
		int[] genres = { 3, 4 };
		genrePage.selectGenres(genres, false);
		genrePage.selectGenre("Top 40 & Pop"); // This one will click done
		Page.handlePossiblePopUp(); // Yet another popup
		Assert.assertTrue("Could not select genre", isVisible(Page.iheartradio_logo_full));
		// Perish pesky popups!
		Page.handlePossiblePopUp();
		// Test genre game improve recommendations
		Assert.assertTrue("Could not click improve recommendations to get to genre selection page",
				genrePage.improveRecommendations());
		// Make sure everything we selected earlier is still selected and saved
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected(3));
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected(4));
		Assert.assertTrue("Could not verify genre!", genrePage.isGenreSelected("Top 40 & Pop"));
		genrePage.deselectGenre("Top 40 & Pop", false);
		Assert.assertTrue("Could not deselect genre!", !genrePage.isGenreSelected("Top 40 & Pop"));
		genrePage.selectGenre("Top 40 & Pop", false);
		Assert.assertTrue("Could not verify genre after deselecting and selecting again!",
				genrePage.isGenreSelected("Top 40 & Pop"));

		consoleLogEnd(before, true, "<<<<<testGenreGameForNewAccount_GEN1_FREE() : Tested Genre Game for New Account");
	}
}
