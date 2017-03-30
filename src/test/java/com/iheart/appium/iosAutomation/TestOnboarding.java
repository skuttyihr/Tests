package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import com.iheart.appium.iosAutomation.AppboyUpsellsPage.Entitlement;
import com.iheart.appium.utilities.TestRoot;
import com.iheart.appium.utilities.TestRoot.Regression;
import com.iheart.appium.utilities.TestRoot.Stable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOnboarding extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	@Rule
	public RetryRule retry = new RetryRule(1);
	
	/**
	 * testAllElementsOnOnboardingPage is a method that makes sure all elements with AccessibilityIdentifiers show up on the Onboarding page.
	 * It prints out all object information to the console.
	 * It also verifies that all elements are displayed, and checks that at least the portrait OR the landscape image is displayed.  
	 *
	 * This works at 169 seconds. 
	 */
	@Test
	@Category(Regression.class)
	public void testAllElementsOnOnboardingPage_ONB1_FREE(){ 
		LocalTime before = consoleLogStart("Testing testAllElementsOnOnboardingPage_ONB1_FREE()");
		boolean allElementsDisplayedOnOnboardingPage = onboardingPage.showAllElements();
		Assert.assertTrue("One of the elements on Onboarding Page is not displayed as expected.",allElementsDisplayedOnOnboardingPage);
		consoleLogEnd(before, allElementsDisplayedOnOnboardingPage,  "Tested ONB1_testAllElementsOnOnboardingPage_FREE() in TestOnboarding.java");
	}
	
	/**
	 * testUIScrollViewOnOnboardingPage tests the 3 Titles and their descriptions within the app.
	 * Due to the nature of fetching text from iosElements that are constantly rotating, there is issues with getting a 1:1 relationship between Title and Description
	 * thus, it is better to separately test both Titles and Descriptions instead of both together.
	 * the Methods used to get the Titles and Descriptions out of the app simply getText on the elements and add to a set until there are 3 unique elements. 
	 * No page swiping or timing is required, we expect to get 3 unique Strings within 10 tries. If this method fails, first thing to do is to increase the max number of fails.
	 * We could also add Sleeps. 
	 */
	@Test
	@Category({Stable.class, Regression.class})
	public void ONB2_testUIScrollViewOnOnboardingPage_FREE(){
		LocalTime before = consoleLogStart("Testing ONB2_testUIScrollViewOnOnboardingPage_FREE()");
		//Part One
		System.out.println("Testing that Titles are as expected.");
		Set<String> foundWithinApp = onboardingPage.getThreeTextFields();
		Set<String> shouldBeInApp = new HashSet<String>();
		shouldBeInApp.add("Join the party.");
		shouldBeInApp.add("Music to your ears.");
		shouldBeInApp.add("Radio and unlimited music.");
		Assert.assertTrue("Titles on Onboarding Screen have changed.",foundWithinApp.containsAll(shouldBeInApp));
		//Part Two
		System.out.println("Testing that Descriptions are as expected.");
		Set<String> foundDescriptionsWithinApp = onboardingPage.getThreeDescriptionTextFields();
		Set<String> descriptionsShouldBeInApp = new HashSet<String>();
		descriptionsShouldBeInApp.add("Thousands of live radio and artist stations. Connect with your favorites. Always free.");
		descriptionsShouldBeInApp.add("Discover millions of songs and new releases. All your music, wherever you go.");
		descriptionsShouldBeInApp.add("Unlimited skips, listen offline, save and replay songs from the radio.");
		Assert.assertTrue("Descriptions have changed.",foundDescriptionsWithinApp.containsAll(descriptionsShouldBeInApp));
		//End
		boolean result = (foundDescriptionsWithinApp.containsAll(descriptionsShouldBeInApp) && foundWithinApp.containsAll(shouldBeInApp));
		consoleLogEnd(before, result,  "Tested ONB2_testUIScrollViewOnOnboardingPage_FREE() in TestOnboarding.java");
	}

	/**
	 * Simply click the 'Log In' Button and the 'Create Account' Button and ensure the next pages are as expected. 
	 */
	@Test
	@Category({Stable.class, Regression.class})
	public void ONB3_testCreateAccountAndLogInButtons_FREE(){
		LocalTime before = consoleLogStart("Testing ONB3_testCreateAccountAndLogInButtons_FREE().");
		GifSequenceWriter writer = loginPage.initGIFWriter();
		Assert.assertTrue("Could not click 'Log In' Button", onboardingPage.clickOnboardingLoginButton());
		loginPage.addPageToGif(writer);
		loginPage.tapBack();
		loginPage.addPageToGif(writer);
		Assert.assertTrue("Could not click 'Create Account' Button", onboardingPage.clickOnboardingCreateAccountButton());
		loginPage.addPageToGif(writer);
		loginPage.closeGifWriter(writer);
		consoleLogEnd(before, true,  "Tested ONB3_testCreateAccountAndLogInButtons_FREE");
	}
	
	@Test
	@Ignore //still doesn't work
	public void ONB4_testOnboardingDisappearal_FREE(){
		LocalTime before = consoleLogStart("Testing testOnboardingDisappearal_ONB4_FREE().");
		loginPage.loginVerifyEntitlement("trav@free.com", "travfree", Entitlement.FREE);
		System.out.println("Closing app.");
		driver.closeApp();
		//closeApp();
		System.out.println("Launching app.");
		driver.launchApp();
		Assert.assertTrue("Closing app and relaunching app after logging in should save log in information.", homePage.isCurrentlyOnForYouTab());
		consoleLogEnd(before, true,  "Tested testOnboardingDisappearal_ONB4_FREE in TestOnboarding.java");
		driver.closeApp();
		//Login with email. 
		//Play live station. 
		//Kill app. 
		//Relaunch app.
	}
}
