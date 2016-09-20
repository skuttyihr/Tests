package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestLogin extends TestRoot {
	
	@Rule
	public TestName name = new TestName();
	

	@Before
	public void setUp() {
		setup();
	}

//	@After
//	public void after(){
//		tearDown();
//	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
    // Can't always switch context, Appium bug
	// Only fails when ran in a suite
    // Starting with a reset seems to help

    @Test(timeout=200000)
    @Ignore
	public void testLoginViaFacebook()  {

		LocalTime before = consoleLogStart("Testing login via Facebook.");
		boolean testResult = loginPage.loginViaFacebook();
		Assert.assertTrue("Could not log in via Facebook", testResult);
		consoleLogEnd(before, testResult,  "Tested login via Facebook.");
	}

	@Test 
	public void testLoginViaEmail(){
		LocalTime before = consoleLogStart("Testing login via Email." + name.getMethodName());
		boolean testResult = loginPage.login();
		Assert.assertTrue("Could not log in with email and password", testResult);
		consoleLogEnd(before, testResult, "Tested Log In via Email.");
	}
	
	@Test
	public void testIOSElementsOnPage() {
		LocalTime before = consoleLogStart("Testing IOSElements on Log In Page");
		loginPage.checkValuesOfElements();
		consoleLogEnd(before, true, "Tested IOSElements");
	}
	
	@Test
	public void testHomePageElements(){
		LocalTime before = consoleLogStart("Testing all elements on HomePage - For You, My Stations, Local Radio");
		loginPage.loginWithoutVerifying("test66@test.com","test");
		if(homePage.isCurrentlyOnHomePage()){
			homePage.showAllElements();
		}
		consoleLogEnd(before, true, "Tested HomePage Elements.");
	}
	
	@Test
	public void testHomePagePlaySomething(){
		LocalTime before = consoleLogStart("Testing play on HomePage");
		loginPage.loginWithoutVerifying("test66@test.com","test");
		homePage.swipeFirstForYouStationToLeft();
		Assert.assertTrue("Clicking on the first station in For You should have started a player.", homePage.clickFirstStationOnForYouToBeginPlaying());
		consoleLogEnd(before, true, "Tested HomePage Play");
	}
	
	@Test
	public void testSearchPageElements(){
		LocalTime before = consoleLogStart("Testing testSearchPageElements");
		loginPage.loginWithoutVerifying("test55@test.com","test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		boolean elements = searchPage.showAllElements();
		searchPage.enterTextIntoSearchBar("asdf");
		searchPage.clearSearchBarTextField();
		searchPage.enterTextIntoSearchBar("MORE");
		searchPage.clickCancelButtonOnSearchBar();
		homePage.clickNavBarSearchButtonToOpenSearch();
		Assert.assertTrue("One of the elements on the search page appears to be missing.", elements);
		consoleLogEnd(before, elements, "Tested SearchPage Elements");
	}
	@Test
	public void testSearchPageElementsAndLists(){
		LocalTime before = consoleLogStart("Testing testSearchPageElementsAndLists");
		loginPage.loginWithoutVerifying("search11@test.com", "test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		Assert.assertTrue("Elements in Search Page before search aren't all visible.", searchPage.showAllElements());
		searchPage.enterTextIntoSearchBar("rap");
		searchPage.showAllElementsVoid();
		consoleLogEnd(before, true, "Tested testSearchPageElementsAndLists");
	}
	@Test
	public void testArtistProfileElements(){
		LocalTime before = consoleLogStart("Testing elements on Artist Profile Page - testArtistProfileElements()");
		loginPage.loginWithoutVerifying("artistProfilePage@test.com", "test");
		homePage.clickMyStationsTab();
		//This should play Red Hot Chili Peppers Radio - the only favorite for this account.

		homePage.clickCertainCellOnMyStationsToBeginPlaying(1);
		sleep(5000);
		Assert.assertTrue("Artist Profile should be open for Red Hot Chili Peppers", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("MiniPlayer should be open for Red Hot Chili Peppers", miniPlayer.isCurrentlyOnMiniPlayer());
		artistProfilePage.showAllElements();
		consoleLogEnd(before, true, "Tested testArtistProfileElements().");
		
	}
	@Test
	public void testArtistProfileFunctions(){
		LocalTime before = consoleLogStart("Testing methods on Artist Profile Page");
		loginPage.loginWithoutVerifying("artistProfileFunctions@test.com", "test");
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Rihanna");
		searchPage.clickTopResult();
		Assert.assertTrue("Artist Profile should be open for Rihanna", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("MiniPlayer should be open for Rihanna", miniPlayer.isCurrentlyOnMiniPlayer());
		Assert.assertEquals("Rihanna should be the Artist Profile  Bio Header Label", "Rihanna", artistProfilePage.getArtistProfileArtistName());
		Assert.assertEquals("Rihanna's Latest Release should be Sledgehammer", "Sledgehammer", artistProfilePage.getLatestReleaseAlbumTitle());
		consoleLogEnd(before, true, "Tested testArtistProfileFunctions()");
	}
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
		if(numberOfSkipsRemaining != -1 && numberOfSkipsRemaining > 2){
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
		System.out.println(miniPlayer.getSongTitle());
		System.out.println(miniPlayer.getArtistName());
		searchPage.clearSearchBarTextField();
		searchPage.enterTextIntoSearchBar("HOT 97");
		Assert.assertEquals("HOT 97", miniPlayer.getSongTitle());
		Assert.assertEquals("Where Hip Hop Lives in New York ", miniPlayer.getArtistName());
		//If we don't have Track title, we can't thumb it up. Try to thumb it up, verify that it still isn't activated. Not sure if we can see how it's greyed out. 
		miniPlayer.clickThumbUpButton();
		Assert.assertFalse(miniPlayer.isThumbUpButtonActivated());
		Assert.assertTrue("Expected 'Stop Buffering' or 'Stop' because MiniPlayer should be playing an Artist track.",miniPlayer.getTypeOfPlayButton().contains("Stop"));
		miniPlayer.swipeMiniPlayerToLeftToShowSkipButton();
		Assert.assertEquals("Player_Scan", miniPlayer.getTypeOfSkipButton());
		Assert.assertFalse("Elapsed View should not be shown for Radio Stations in MiniPlayer",miniPlayer.isElapsedViewDisplayed());
		
		
		//On a Radio Station - it will show artist and name but a Stop Button. 
				//Swipe produces a Scan Button. 
				//MiniPlayerView-SwipeButtonContainerView-UIView
				//MiniPlayerView-RedSkipButton-UIButton is used for Scan Button. However - label says "Player_Scan"
				//name: MiniPlayerView-PlayButton-UIButton
				//type: UIAButton
				//value: 
				//label: Stop
				//HOT 99.5
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
		Assert.assertTrue("See if both Thumbs are down",fullPlayer.isThumbUpAndThumbDownButtonNotActivated());
		fullPlayer.clickThumbDownButton();
		Assert.assertTrue("See if Thumb Down is selected",fullPlayer.isThumbDownButtonActivated());
		fullPlayer.clickThumbUpButton();
		Assert.assertTrue("See if Thumb Up is selected",fullPlayer.isThumbUpButtonActivated());
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


	
	

	
	/**
	 * Click Login Button, Click Forgot Your Password, Show all the elements on Reset Password Page. 
	 * Enter a bad email - click Reset and expect an error message. Click Back button and go back to Login page. 
	 * 
	 * Refactor ideas: Create a New account - use email to reset the password. See how to get password out of email or use one of our own email. 
	 */
	@Test
	public void testResetPasswordPage(){
		LocalTime before = consoleLogStart("Testing IOSElements on resetPasswordPage");
		onboardingPage.clickOnboardingLoginButton();
		loginPage.clickForgotYourPasswordButton();
		Assert.assertTrue("Clicking 'Forgot your Password' didn't bring app to Reset Password Page", resetPasswordPage.isCurrentlyOnResetPasswordPage());
		if(resetPasswordPage.showAllElements()){
			resetPasswordPage.clearEmailAddress();
			resetPasswordPage.enterEmailAddressToResetPassword("abademail@gmail.com");
			resetPasswordPage.clickResetPasswordButtonWithBadEmail();
			resetPasswordPage.clickBackButton();
		}
		boolean onLoginPage = loginPage.currentlyOnLoginPage();
		Assert.assertTrue("Not currently on loginPage, check for ResetPassword issues",onLoginPage );
		consoleLogEnd(before, onLoginPage, "Tested IOSElements on resetPasswordPage");
	}
	
	// Since Google opens Safari, we can't access those elements. 
	@Ignore
	@Test
	public void testLoginViaGoogle(){
		
		int iOSVersion = 0;
		try{
			iOSVersion = Integer.parseInt(PLATFORM_VERSION.charAt(0) + "");
		}catch(Exception e){}
		if(iOSVersion >= 9){
			System.out.println("Testing login Via Google for iOS Platform Version: "+iOSVersion);		
			Assert.assertTrue("Could not log in via Google+", loginPage.loginViaGoogle());
		}
		else{
			System.out.println("Skipping Google+ login for older OS: " + iOSVersion);
		}
		
	}
}
