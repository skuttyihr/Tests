package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.After;
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
public class TestHomePage extends TestRoot {
	
	@Before
	public void setUp() throws Exception {
		setup();
	}
	@After
	public void after() {

	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	@Rule
	public RetryRule retry = new RetryRule(1);
	
	@Test
	@Category(Regression.class)
	public void HOME1_testForYou_FREE(){
		LocalTime before = consoleLogStart(">>>>>testForYou_HOME1_FREE() : Testing all elements on HomePage - For You, My Stations, Local Radio");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", Entitlement.FREE));
		if(homePage.isCurrentlyOnHomePage()){
			homePage.clickFreeTrialUpsellButton();
			upsellPage.clickCancelButton();
			homePage.printForYouElements();
		}
		consoleLogEnd(before, true, "<<<<<testForYou_HOME1_FREE() : Tested HomePage Elements.");
	}
	
	@Test
	@Category(Regression.class)
	public void HOME2_testMyStations_FREE(){
		LocalTime before = consoleLogStart(">>>>>testMyStations_HOME2_FREE() : Testing all elements on HomePage - For You, My Stations, Local Radio");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", Entitlement.FREE));
		if(homePage.isCurrentlyOnHomePage()){
			homePage.clickMyStationsTab();
			homePage.printMyStationsElements();
		}
		consoleLogEnd(before, true, "<<<<<testMyStations_HOME2_FREE() : Tested HomePage Elements.");
	}

	@Test
	@Ignore

	public void HOME3_testMyMusic_FREE(){
		LocalTime before = consoleLogStart(">>>>>testMyStations_HOME3_FREE() : Testing all elements on HomePage - For You, My Stations, Local Radio");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", Entitlement.FREE));
		if(homePage.isCurrentlyOnHomePage()){
			homePage.clickMyMusicTab();
			homePage.printMyMusicElements();
			//homePage.showAllElements();
		}
		consoleLogEnd(before, true, "<<<<<testMyStations_HOME3_FREE() : Tested HomePage Elements.");
	}
	
	@Test
	@Ignore

	public void HOME4_testAddToFavorites_FREE(){
		LocalTime before = consoleLogStart(">>>>>testAddToFavorites_HOME4_FREE() : Testing all elements on HomePage - For You, My Stations, Local Radio");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", Entitlement.FREE));
		if(homePage.isCurrentlyOnHomePage()){
			
		}
		consoleLogEnd(before, true, "<<<<<testAddToFavorites_HOME4_FREE() : Tested HomePage Elements.");
	}
	@Test
	@Category(Regression.class)
	public void HOME5_testHomePagePlay_FREE(){
		LocalTime before = consoleLogStart(">>>>>testHomePagePlay_HOME5_FREE() : Testing play on HomePage");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("homepageelements@Test.com","test", Entitlement.FREE));
		boolean startPlaying = homePage.clickFirstStationOnForYouToBeginPlaying();
		Assert.assertTrue("Clicking on the first station in For You should have started a player.", startPlaying);
		consoleLogEnd(before, startPlaying, "<<<<<testHomePagePlay_HOME5_FREE(): Tested HomePage Play");
	}
	
	/**
	 * Unfavorite option is display
		Notice the equalizer on the station that is currently playing
		The option Add to Favorites or remove are displaying
		Station get deleted and station is not playing
		Station is deleted but it keeps playing
		the station is also display under 'Favorite Stations' and the equalizer is only showing near the Favorite Station
		Notice the equalizer on the station that is currently playing
		The option Add to Favorites or remove are displaying
		Station get deleted and station is not playing
		Station is deleted but it keeps playing
		the station is also display under 'Favorite Stations' and the equalizer is only showing near the Favorite Station
	 */
	@Test
	@Ignore
	public void HOME6_testMiscHomePage_FREE(){
	
	}
	/*
	private void assertScrollAndShowMore(){ 
		List<String> visibleItems = homePage.getVisibleListItems();
		Assert.assertTrue(visibleItems.size() > 0);
		IOSElement showMore = Page.swipeToShowMore();
		Assert.assertTrue("Could not swipe to Show More button", showMore != null);
		List<String> visibleItemsAfterSwipe = homePage.getVisibleListItems();
		Assert.assertTrue("Lists before and after swiping should not have been identical!", 
				!visibleItems.equals(visibleItemsAfterSwipe));
		Assert.assertTrue("Could not click show more", Page.clickShowMore());
		swipeUp(); // just to be sure we could load more
		visibleItems = homePage.getVisibleListItems();
		Assert.assertTrue("One or both lists of visible items was null!", visibleItems != null && visibleItemsAfterSwipe != null);
		Assert.assertTrue("Lists before and after swiping and clicking show more should not have been identical!", 
				!visibleItems.equals(visibleItemsAfterSwipe));
	}
	*/
	
}
