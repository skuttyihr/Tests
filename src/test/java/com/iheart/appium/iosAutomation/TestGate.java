package com.iheart.appium.iosAutomation;

import java.util.HashSet;
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
		Set<String> alreadyTested = new HashSet<String>();
		int foundCases = 0;
		StringBuilder couldntFind = new StringBuilder();
		// Reset so we're back to the first pane
		resetBackground();
		for(int i = 0; i < 3; i++){
			String onboardingText = Page.getOnBoardingText();
			
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
					couldntFind.append(onboardingText + "\n");
				}
			}
			else{
				Assert.fail("Failed while waiting for text matching: " + shouldBe);
			}
		}
		Assert.assertTrue("Did not see all three entry panes. Could not find: \n" + couldntFind.toString(), 
				foundCases == 3);
		Assert.assertTrue("Did not find all cases we expected.", shouldBe.size() == 0);
	}
}
