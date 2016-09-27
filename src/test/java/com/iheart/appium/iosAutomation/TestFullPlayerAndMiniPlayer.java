package com.iheart.appium.iosAutomation;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestFullPlayerAndMiniPlayer extends TestRoot {
	
	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	@Test
	public void testMiniPlayerArtistRadioElementsAndFunctionality(){
		LocalTime before = consoleLogStart("Testing testMiniPlayerArtistRadioElementsAndFunctionality - login, start MiniPlayer for Artist Radio, show all elements, test functionality.");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		//Start Artist Radio
		searchPage.enterTextIntoSearchBar("Rage against the machine");
		searchPage.clickTopResult();
		Assert.assertTrue("Expected 'Pause Buffering' or 'Pause' because MiniPlayer should be playing an Artist track.",miniPlayer.getTypeOfPlayButton().contains("Pause"));
		miniPlayer.showAllElements();
		miniPlayer.clickPlayPauseButton();
		Assert.assertTrue("Expected 'Play Buffering' or 'Play' because MiniPlayer should be playing an Artist track.",miniPlayer.getTypeOfPlayButton().contains("Play"));
		miniPlayer.clickPlayPauseButton();
		int numberOfSkipsRemaining = miniPlayer.getNumberOfSkipsRemaining();
		if(numberOfSkipsRemaining > 2){
			miniPlayer.swipeMiniPlayerToLeftAndClickSkipButton();
			Assert.assertTrue("Skip may not have worked - song title is the same.", miniPlayer.isTitleDifferentAfterSkip());
		}
		miniPlayer.swipeMiniPlayerToLeftToShowSkipButton();
		Assert.assertTrue("Expected 'Skip' instead of 'Scan' because MiniPlayer should be playing an Artist track.",miniPlayer.getTypeOfSkipButton().contains("Skip"));
		miniPlayer.swipeMiniPlayerToRightToHideSkipButton();
		Assert.assertTrue("Track should not be Thumbed Up or Down yet...", miniPlayer.isThumbUpAndThumbDownButtonNotActivated());
		miniPlayer.clickThumbUpButton();
		Assert.assertTrue("ThumbUpButton is not Selected", miniPlayer.isThumbUpButtonActivated());
		miniPlayer.clickThumbDownButton();
		Assert.assertTrue("ThumbDownButton is not Selected", miniPlayer.isThumbDownButtonActivated());
		Assert.assertTrue("Test that it is still currently on Mini Player", miniPlayer.isCurrentlyOnMiniPlayer());
		consoleLogEnd(before, true, "Tested IOSElements, Controls in MiniPlayer for artist radio");
	}
	
	@Test
	public void testMiniPlayerWorksOnAllPages(){
		LocalTime before = consoleLogStart("Testing testMiniPlayerWorksOnAllPages - login, start MiniPlayer for Artist Radio, Open other pages, check that MiniPlayer is still running.");
		loginPage.loginWithoutVerifying("test66@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		//Start Artist Radio
		searchPage.enterTextIntoSearchBar("Inanimate Existence");
		searchPage.clickTopResult();
		//Should currently be on Inanimate Existence Artist Bio Page and playing Artist Radio in miniPlayer. 
		Assert.assertTrue("Artist Profile Page should currently be open but it is not.", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("Miniplayer should be open playing Inanimate Existence, but it is not.",miniPlayer.isCurrentlyOnMiniPlayer());
		artistProfilePage.clickNavBarBackButton();
		//Now it should be back to SearchPage
		searchPage.clickCancelButtonOnSearchBar();
		//Canceled out of Search. Now we should be on Homepage. 
		homePage.clickHamburgerButtonToOpenSideMenu();
		System.out.println("Testing that MiniPlayer continues to show up as you click on different pages.");
		sideNavBar.gotoLiveRadioPage();
		homePage.clickHamburgerButtonToOpenSideMenu();
		//EVENTUALLY - Add clickHamburgerButton method to all these pages. System doesn't know that it is on non-Home pages so it can click the SideMenuButton. 
		System.out.print("Live Radio  :");
		Assert.assertTrue("Mini player was not visible on live radio page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoLiveArtistPage();
		homePage.clickHamburgerButtonToOpenSideMenu();
		System.out.print("Live Artist  :");
		Assert.assertTrue("Mini player was not visible on artist radio page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoPodcastsPage();
		homePage.clickHamburgerButtonToOpenSideMenu();
		System.out.print("Podcasts  :");
		Assert.assertTrue("Mini player was not visible on podcasts page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoPerfectFor();
		homePage.clickHamburgerButtonToOpenSideMenu();
		System.out.print("Perfect For  :");
		Assert.assertTrue("Mini player was not visible on perfect for page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoListeningHistoryPage();
		homePage.clickHamburgerButtonToOpenSideMenu();
		System.out.print("Listening History  :");
		Assert.assertTrue("Mini player was not visible on listening history page", miniPlayer.isCurrentlyOnMiniPlayer());
		
		consoleLogEnd(before, true, "Tested IOSElements, Controls in MiniPlayer for artist radio");
	}
	
	@Test
	public void testMiniPlayerRadioStationAfterLogin(){
		LocalTime before = consoleLogStart("Testing testMiniPlayerRadioStationAfterLogin");
		loginPage.loginWithoutVerifying();
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("HOT 99.5");
		searchPage.clickTopResult();
		Assert.assertTrue("Clicking 99.5 in Search Results should have started playback in Miniplayer.", miniPlayer.isCurrentlyOnMiniPlayer());
		System.out.println(miniPlayer.getSongTitle());
		System.out.println(miniPlayer.getArtistName());
		searchPage.clearSearchBarTextField();
		searchPage.enterTextIntoSearchBar("HOT 97");
		searchPage.clickTopResult();
		Assert.assertEquals("HOT 97", miniPlayer.getSongTitle());
		Assert.assertEquals("Where Hip Hop Lives in New York ", miniPlayer.getArtistName());
		//If we don't have Track title, we can't thumb it up. Try to thumb it up, verify that it still isn't activated. Not sure if we can see how it's greyed out. 
		miniPlayer.clickThumbUpButton();
		Assert.assertFalse(miniPlayer.isThumbUpButtonActivated());
		Assert.assertTrue("Expected 'Stop Buffering' or 'Stop' because MiniPlayer should be playing an Artist track.",miniPlayer.getTypeOfPlayButton().contains("Stop"));
		miniPlayer.swipeMiniPlayerToLeftToShowSkipButton();
		Assert.assertEquals("Player_Scan", miniPlayer.getTypeOfSkipButton());
		Assert.assertFalse("Elapsed View should not be shown for Radio Stations in MiniPlayer",miniPlayer.isElapsedViewDisplayed());
		consoleLogEnd(before, true, "Tested MiniPlayer for a Radio Station");
	}
	@Test
	public void testFullPlayerElements(){
		LocalTime before = consoleLogStart("Testing testFullPlayerElements");
		loginPage.loginWithoutVerifying("test66@test.com", "test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		//New accounts start a Full Player
		searchPage.enterTextIntoSearchBar("Opeth");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.showAllElements();
		Assert.assertTrue(true);
		consoleLogEnd(before, true, "Tested testFullPlayerElements");
	}
	@Test
	public void testFullPlayerFunctionality(){
		LocalTime before = consoleLogStart("Testing testFullPlayerFunctionality()");
		loginPage.loginWithoutVerifying("test66@test.com", "test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Britney");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.minimizeFullPlayerToMiniPlayer();
		Assert.assertTrue("MiniPlayer should be open now", miniPlayer.isCurrentlyOnMiniPlayer());
		miniPlayer.openFullPlayer();
		Assert.assertTrue("Check if Full Player is open.",fullPlayer.isCurrentlyOnFullPlayer());
		Assert.assertEquals("Expecting playType to be 'player pause' since it should still be playing.", "player pause", fullPlayer.getTypeOfPlayButton());
		if(fullPlayer.isThumbUpAndThumbDownButtonNotActivated()){
			//Both thumbs are down. 
			fullPlayer.clickThumbDownButton();
			Assert.assertTrue("See if Thumb Down is selected",fullPlayer.isThumbDownButtonActivated());
			fullPlayer.clickThumbUpButton();
			Assert.assertTrue("See if Thumb Up is selected",fullPlayer.isThumbUpButtonActivated());
		}else if(fullPlayer.isThumbDownButtonActivated()){
			//Just the Thumbs down button is activated - unclick it, and then click it again.
			fullPlayer.clickThumbDownButton();
			Assert.assertFalse("Thumb down button was originally activated, clicking it again should make it unactivated.", fullPlayer.isThumbDownButtonActivated());
		}else if(fullPlayer.isThumbUpButtonActivated()){
			fullPlayer.clickThumbUpButton();
			Assert.assertFalse("Thumb up button was originally activated, clicking it again should make it unactivated", fullPlayer.isThumbUpButtonActivated());
		}
		fullPlayer.clickShareButtonOnNavBar();
		Assert.assertTrue("Should be on Share screen on Full Player", fullPlayer.isShareMenuOpen());
		fullPlayer.clickCancelOnShareMenuToReturnToFullPlayer();
		System.out.println("Checking Progress Slider now...");
		Assert.assertTrue("Progress Slider may be broken",fullPlayer.checkProgressSliderAlignedToPosition());
		Assert.assertEquals("We expect to be playing Britney Spears after searching 'Britney' ", "Britney Spears", fullPlayer.getStationName());
		Assert.assertEquals("We expect to be on Artist Radio if we enter 'Britney' into Search.", "Artist Radio",fullPlayer.getStationType());
		Assert.assertTrue("Skip may not have worked, or skip counter didn't decrease, or not enough skips were left",fullPlayer.doesSkipCountDecreaseAfterClickingSkipButton());
		fullPlayer.clickCastingAirplayButtonOnNavBar();
		Assert.assertTrue("Clicking on the Casting / Airplay button should have opened the Connect to a Device screen.", fullPlayer.isConnectToADeviceDisplayed());
		fullPlayer.clickCloseOnConnectADevice();
		if(!fullPlayer.isFavoriteButtonOnNavBarSelected()){ //Station is not favorited, fav it, check that it is fav'ed
			fullPlayer.clickFavoriteButtonOnNavBar(true, true);
			Assert.assertTrue("Favorite Button on NavBar should be selected after getting clicked.", fullPlayer.isFavoriteButtonOnNavBarSelected());
		}
		else{ //Station is fav'ed, De-fav it, check that it isn't faved. 
			fullPlayer.clickFavoriteButtonOnNavBar(true, true); 
			Assert.assertFalse("Favorite Button on NavBar should be selected after getting clicked.", fullPlayer.isFavoriteButtonOnNavBarSelected());
		}
		consoleLogEnd(before, true, "Tested testFullPlayerElements");
	}

	
	

}
