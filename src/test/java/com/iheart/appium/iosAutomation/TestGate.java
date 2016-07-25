package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGate extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
	
	private void resetBackground(){
		// Swipe so we're back to square 1
		for(int i = 0; i < 3; i++){
			pageSwipe(RIGHT);
		}
	}
	/**
	 * Swipe background
	 * Make sure background transitions on its own as well
	 */
	//@Test
	public void  testBackground() {
		LocalTime before = consoleLogStart("Testing Gate and backgrounds in testBackground().");
		Set<String> shouldBe = new HashSet<String>();
		shouldBe.add("Music to your ears.");
		shouldBe.add("Don't miss a beat.");
		shouldBe.add("Join the party.");
		Set<String> found = new HashSet<String>();

		// Assert background image is present
		Assert.assertTrue("Background image was not present!", splashPage.isBackgroundImagePresent());
		
		// Reset so we're back to the first pane
		resetBackground();
		
		long duration = 75000; // 75 seconds max (will be shorter if items are found)
		long startTime = System.currentTimeMillis();
		// Grab all the text we can see
		while(System.currentTimeMillis() - startTime < duration){
			String onboardingText = splashPage.getOnBoardingText();
			if(strGood(onboardingText)){
				found.add(onboardingText);
				System.out.println("Found: " + onboardingText);
			}
			if(found.size() == shouldBe.size()){
				break;
			}
		}
		
		// Report errors if they exist
		StringBuilder couldntFind = new StringBuilder();
		Iterator<String> itr = shouldBe.iterator();
		while(itr.hasNext()){
			String shouldHaveFound = itr.next();
			if(!found.contains(shouldHaveFound)){
				couldntFind.append(shouldHaveFound + "\n");
			}
		}
		if(couldntFind.length() > 0){
			Assert.fail("Could not find the following expected text:\n" + couldntFind.toString());
		}
		
		// Now test that swiping is possible
		// Method: Just prove that swiping changes things. 
		// Get text. Swipe. Get text again. Should be different. 
		// Timeout of 75 seconds again, can be quicker
		found = null;
		found = new HashSet<String>();
		duration = 75000;
		startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime < duration){
			String beforeSwipe = splashPage.getOnBoardingText();
			System.out.println("Before swipe: " + beforeSwipe);
			pageSwipe(LEFT);
			String afterSwipe = splashPage.getOnBoardingText();
			System.out.println("After swipe: " + afterSwipe);
			if(!beforeSwipe.equals(afterSwipe)){
				found.add(afterSwipe);
			}
			else{
				System.out.println("Waiting for it to change, can't swipe from last item to first item");
				sleep(2000);
				afterSwipe = splashPage.getOnBoardingText();
				if(!beforeSwipe.equals(afterSwipe)){
					found.add(afterSwipe);
				}
			}
			if(found.size() == shouldBe.size()){
				break;
			}
			sleep(1667);
		}
		
		itr = shouldBe.iterator();
		while(itr.hasNext()){
			String shouldHaveFound = itr.next();
			if(!found.contains(shouldHaveFound)){
				couldntFind.append(shouldHaveFound + "\n");
			}
		}
		if(couldntFind.length() > 0){
			Assert.fail("Could not find the following expected text while swiping:\n" + couldntFind.toString());
		}
		consoleLogEnd(before, true,  "Tested Background in TestGate.java");
		
	}
	
	private void validateGate(boolean wait){
		String notVisible = splashPage.whatIsntVisible(wait);
		Assert.assertTrue("Not all items were visible on the splash page:\n" + notVisible,
				notVisible != null && notVisible.length() <= 0);
	}
	
	//@Test
	public void testCreateAccountLogInAndMaybeLater(){
		LocalTime before = consoleLogStart("Testing testCreateAccountLogInAndMaybeLater().");
		validateGate(true);
		System.out.println("test done 1");
		Assert.assertTrue("Could not click log in", splashPage.clickLogIn());
		loginPage.tapBack();
		Assert.assertTrue("Could not click get started", splashPage.clickCreateAccount());		
		// Assert that maybe later is no longer an element here. 
		Assert.assertFalse("Maybe Later was visible, but it  should not be visible for new app installs", signupPage.isMaybeLaterVisible());
		consoleLogEnd(before, true,  "Tested CreateAccountLogInAndMaybeLater in TestPlayback.java");
	}
}
