package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import com.iheart.appium.utilities.TestRoot;
import com.iheart.appium.utilities.TestRoot.Regression;
import com.iheart.appium.utilities.TestRoot.Stable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestNewAccount extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	@Rule
	public RetryRule retry = new RetryRule(1);
	
	/**
	 * Test: CreateNewAccount creates a new account in iOS. It fills out email,
	 * password, zipcode, birth year(selection), gender, checks Terms and
	 * Conditions, Creates account, and then uses enters a zip code and expects
	 * the Genre page to open.
	 * //"travused@all.com","travUsed66t","11206","1977","male"));
	 * 
	 */
	@Test
	@Category(Regression.class)
	public void SIGN1_testCreateNewEmailAccount_FREE() {
		LocalTime before = consoleLogStart(
				">>>>>SIGN1_testCreateNewEmailAccount_FREE() : Creating a new account with the default parameters. ");
		Assert.assertTrue(signupPage.createNewAccount());
		consoleLogEnd(before, true, "<<<<<SIGN1_testCreateNewEmailAccount_FREE");
	}
	 @Test
	 @Ignore 
	 public void SIGN2_testCreateNewGmailAccount_FREE(){
		 System.out.println("SIGN2_testCreateNewGmailAccount_FREE() - Needs Manual Test.");
		 //Can't keep using Gmail accounts //Most likely cannot be automated. }
	 }
	 @Test
	 @Ignore 
	 public void SIGN3_testCreateNewFacebookAccount_FREE(){
		 System.out.println("SIGN3_testCreateNewFacebookAccount_FREE() - Needs Manual Test."); 
		 //Can't keep using Facebook accounts 
		 //Most likely cannot be automated. }
	 }
	/**
	 * Tests all the elements on the sign up page.
	 */
	@Test
	public void SIGN4_testAllElements_FREE() {
		LocalTime before = consoleLogStart(
				">>>>>SIGN4_testAllElements_FREE() : Checking all the iOS Elements on the Onboarding / Sign Up Page.");
		// We only care about console output here
		signupPage.checkAllElements();
		consoleLogEnd(before, true,
				"<<<<<SIGN4_testAllElements_FREE() : Test completed and all elements must be on the Onboarding Screen as expected.");
	}

	/**
	 * Verifies all the genres on the genre page and ensures that all are
	 * present. Then it swipes to the top of the page, selects some genres,
	 * handles popups, improvesRecommendations, and deselects and reselects Top
	 * 40.
	 */
	// sk - 2/8 - commented the elements verification, can be added back or
	// separated out for regression tests
	@Test
	public void SIGN5_testGenreGameForNewAccount_FREE() {
		LocalTime before = consoleLogStart(
				">>>>>SIGN5_testGenreGameForNewAccount_FREE(): Testing Genre Game for New Account.");
		Assert.assertTrue("Could not create a new account and get the genre picker", signupPage.createNewAccount());
		Assert.assertFalse("Done Button shouldn't be enabled for a new account.", genrePage.isDoneButtonEnabled());
		genrePage.printGenreElements();
		Assert.assertEquals(
				"GenrePage TitleLabel should say [" + genrePage.GENREPAGE_TITLE + "] but the Strings didn't match",
				genrePage.GENREPAGE_TITLE, genrePage.getTitleLabelText());
		Assert.assertEquals(
				"GenrePage SubtitleLabel should say [" + genrePage.GENREPAGE_SUBTITLE
						+ "] but the Strings didn't match",
				genrePage.GENREPAGE_SUBTITLE, genrePage.getSubtitleLabelText());
		Assert.assertTrue("Selecting Genres should have enabled the Done Button, allowing it to be clicked.",
				genrePage.selectGenresAndClickDone().noErrors());
		Page.handlePossiblePopUp();
		Assert.assertTrue("Clicking Done button should have landed on For You in Homepage.",
				homePage.isCurrentlyOnForYouTab());
		consoleLogEnd(before, true, "<<<<<SIGN5_testGenreGameForNewAccount_FREE() : Tested Genre Game for New Account");
	}
}
