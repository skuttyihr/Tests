package com.iheart.appium.iosAutomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerfectFor extends TestRoot{

	@Before
	public void setUp() throws Exception {
		TestRoot.setup();
	}
	@After
	public void after() {
		// Remove favorites
		TestRoot.tearDown();
	}
	
	private boolean selectPerfectForCategories(int firstCategory, int station){
		
		
		return player.isPlaying();
	}
	
	@Test
	public void testPlayingFromPerfectFor(){
		// plays a few stations from different categories for perfect for tests
		loginPage.loginWithoutVerifying();
		sideNavBar.gotoPerfectFor();
		// Verify we're looking at perfect for
		
	}
}
