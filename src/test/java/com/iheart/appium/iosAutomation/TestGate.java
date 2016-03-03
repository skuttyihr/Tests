package com.iheart.appium.iosAutomation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
			swipeRight();
		}
	}
	/**
	 * Swipe background
	 * Make sure background transitions on its own as well
	 */
	@Test
	public void testBackground() {
		Set<String> shouldBe = new HashSet<String>();
		shouldBe.add("Music to your ears.");
		shouldBe.add("Don't miss a beat.");
		shouldBe.add("Join the party.");
		List<String> alreadyTested = new ArrayList<String>();
		int foundCases = 0;
		Assert.assertTrue("Background image was not present!", splashPage.isBackgroundImagePresent());
		
		// Reset so we're back to the first pane
		resetBackground();
		for(int i = 0; i < 3; i++){
			if(shouldBe.size() == 0){
				break;
			}
			String onboardingText = splashPage.getOnBoardingText();
			
			if(onboardingText != null){
				System.out.println("Testing: " + onboardingText);
				if(alreadyTested.contains(onboardingText)){
					if(alreadyTested.size() < 4){ // limit retries
						i--;
					}
					System.out.println("Already tested: " + onboardingText + ", continuing...");
					sleep(3000);
					alreadyTested.add(onboardingText);
					continue;
				}
				alreadyTested.add(onboardingText);
				if(shouldBe.contains(onboardingText)){
					shouldBe.remove(onboardingText);
					foundCases++;
				}
				else{
					Assert.fail("Found string (" + onboardingText + ") was not in list of acceptable strings.");
				}
			}
			else{
				Assert.fail("Failed while waiting for text matching: " + shouldBe);
			}
		}
		Assert.assertTrue("Did not see all three entry panes.", foundCases == 3);
		Assert.assertTrue("Did not find all cases we expected.", shouldBe.size() == 0);
		
		
		
		// Do test again, this time swiping between pages
		shouldBe.add("Music to your ears.");
		shouldBe.add("Don't miss a beat.");
		shouldBe.add("Join the party.");
		alreadyTested = null;
		alreadyTested = new ArrayList<String>();
		foundCases = 0;
		// Reset so we're back to the first pane
		resetBackground();
		for(int i = 0; i < 3; i++){
			if(shouldBe.size() == 0){
				break;
			}
			
			String onboardingText = splashPage.getOnBoardingText();
			if(onboardingText != null){
				System.out.println("Testing with swipe: " + onboardingText);
				if(alreadyTested.contains(onboardingText)){
					if(alreadyTested.size() < 4){ // limit retries
						i--;
					}
					System.out.println("Already tested: " + onboardingText + " while swiping, continuing...");
					alreadyTested.add(onboardingText);
					swipeLeft();
					continue;
				}
				alreadyTested.add(onboardingText);
				if(shouldBe.contains(onboardingText)){
					shouldBe.remove(onboardingText);
					foundCases++;
				}
				else{
					Assert.fail("Found string (" + onboardingText + ") was not in list of acceptable strings.");
				}
			}
			else{
				Assert.fail("Failed while swiping for text matching: " + shouldBe);
			}
			swipeLeft();
		}
		Assert.assertTrue("Did not see all three entry panes while swiping.", foundCases == 3);
		Assert.assertTrue("Did not find all cases we expected while swiping.", shouldBe.size() == 0);
	}
	
	
	private void validateGate(boolean wait){
		String notVisible = splashPage.whatIsntVisible(wait);
		Assert.assertTrue("Not all items were visible on the splash page:\n" + notVisible,
				notVisible != null && notVisible.length() <= 0);
	}
	
	@Test
	public void testCreateAccountLogInAndMaybeLater(){
		validateGate(true);
		Assert.assertTrue("Could not click log in", loginPage.clickLogin());
		loginPage.tapBack();
		validateGate(true);
		Assert.assertTrue("Could not click get started", signupPage.tapGetStarted());
//		signupPage.tapBack();
		Assert.assertTrue("Could not click maybe later", signupPage.skipLogin());
	}
}
