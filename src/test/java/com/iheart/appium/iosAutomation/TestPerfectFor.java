package com.iheart.appium.iosAutomation;

import org.junit.After;
import org.junit.Assert;
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
		homePage.removeAllFavorites();
		TestRoot.tearDown();
	}
	
	@Test
	public void testPlayingFromPerfectFor(){
		// plays a few stations from different categories for perfect for tests
		loginPage.loginWithoutVerifying();
		// Select a station from perfect for
		String playErrors = perfectFor.selectPerfectForCategories(1, 1);
		Assert.assertTrue("Could not play a station from perfect for." + playErrors, didPass(playErrors));
		if(isVisible(miniPlayer.miniPlayerBar)){
			miniPlayer.maximizeMiniPlayer();
		}
		// Favorite the station 
		Assert.assertTrue("Could not favorite station", player.doFavorite());
		String favoritedStation = player.getStationTitle();
		Assert.assertTrue("Could not get station title.", strGood(favoritedStation));
		String playbackControlErrors = player.verifyPlaybackControls();
		Assert.assertTrue("Could not verify playback controls: " + playbackControlErrors, didPass(playbackControlErrors));
		// minimize, select another station, verify it's in mini player, maximize
		player.minimizePlayer();
		perfectFor.getBack();
		playErrors = perfectFor.selectPerfectForCategories(3, 4);
		Assert.assertTrue("Could not play a station from perfect for." + playErrors, didPass(playErrors));
		// Go back to check labels
		perfectFor.getBack();
		// First check that the above label says "Find a station Perfect For <Day of Week> <Time of Day>"
		// Example: "Find a station Perfect For Wednesday Morning"
		String labelErrors = perfectFor.checkCategoryLabel();
		Assert.assertTrue("Could not get category header text: " + labelErrors, didPass(labelErrors));
		// Select a specific station, verify subheading labels
		Assert.assertTrue("Could not select 'Decades' category.", perfectFor.selectCategory("Decades"));
		String[] testLabels = {"80", "70", "90", "60", "50"};
		for(String tl : testLabels){
			Assert.assertTrue("Could not find subcategory label: " + tl, perfectFor.searchForListLabel(tl) != null);
		}
		// Assert that we can see the favorited station in the My Stations section 
		sideNavBar.gotoMyStationsPage();
		Assert.assertTrue("Station: " + favoritedStation + " was not a favorite.", homePage.isStationAFavorite(favoritedStation) > 0);
	}
}
