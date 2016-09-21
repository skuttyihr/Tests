package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TestOnboarding extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

//	@After
//	public void after() {
//		tearDown();
//	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	/**
	 * testAllElementsOnOnboardingPage is a method that makes sure all elements with AccessibilityIdentifiers show up on the Onboarding page.
	 * It prints out all object information to the console.
	 * It also verifies that all elements are displayed, and checks that at least the portrait OR the landscape image is displayed.  
	 *
	 * This works at 169 seconds. 
	 */
	@Test
	public void testAllElementsOnOnboardingPage(){ 
		LocalTime before = consoleLogStart("Testing testAllElementsOnOnboardingPage()");
		boolean allElementsDisplayedOnOnboardingPage = onboardingPage.showAllElements();
		Assert.assertTrue("One of the elements on Onboarding Page is not displayed as expected.",allElementsDisplayedOnOnboardingPage);
		consoleLogEnd(before, allElementsDisplayedOnOnboardingPage,  "Tested testAllElementsOnOnboardingPage() in TestOnboarding.java");
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
	public void testUIScrollViewOnOnboardingPage(){
		LocalTime before = consoleLogStart("Testing testUIScrollViewOnOnboardingPage()");
		//Part One
		System.out.println("Testing that Titles are as expected.");
		Set<String> foundWithinApp = onboardingPage.getThreeTextFields();
		Set<String> shouldBeInApp = new HashSet<String>();
		shouldBeInApp.add("Join the party.");
		shouldBeInApp.add("Don't miss a beat.");
		shouldBeInApp.add("Music to your ears.");
		Assert.assertTrue("Titles on Onboarding Screen have changed.",foundWithinApp.containsAll(shouldBeInApp));
		//Part Two
		System.out.println("Testing that Descriptions are as expected.");
		Set<String> foundDescriptionsWithinApp = onboardingPage.getThreeDescriptionTextFields();
		Set<String> descriptionsShouldBeInApp = new HashSet<String>();
		descriptionsShouldBeInApp.add("Thousands of live radio and artist stations. Connect with your favorites. Always free.");
		descriptionsShouldBeInApp.add("Discover world premieres from artists you love. See them live at our exclusive events.");
		descriptionsShouldBeInApp.add("Running or relaxing. Pre-party or post-breakup. We have a station Perfect For you.");
		
		Assert.assertTrue("Descriptions have changed.",foundDescriptionsWithinApp.containsAll(descriptionsShouldBeInApp));
		//End
		boolean result = (foundDescriptionsWithinApp.containsAll(descriptionsShouldBeInApp) && foundWithinApp.containsAll(shouldBeInApp));
		consoleLogEnd(before, result,  "Tested testUIScrollViewOnOnboardingPage() in TestOnboarding.java");
	}

	/**
	 * Simply click the 'Log In' Button and the 'Create Account' Button and ensure the next pages are as expected. 
	 */
	@Test
	public void testCreateAccountAndLogInButtons(){
		LocalTime before = consoleLogStart("Testing testCreateAccountLogInAndMaybeLater().");
		Assert.assertTrue("Could not click 'Log In' Button", onboardingPage.clickOnboardingLoginButton());
		loginPage.tapBack();
		Assert.assertTrue("Could not click 'Create Account' Button", onboardingPage.clickOnboardingCreateAccountButton());
		consoleLogEnd(before, true,  "Tested CreateAccountAndLogInButtons in TestOnboarding.java");
	}
}
