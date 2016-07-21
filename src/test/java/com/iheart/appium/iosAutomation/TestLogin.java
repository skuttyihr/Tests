package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import org.junit.After;
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

	@After
	public void after(){
		tearDown();
	}
	
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
	public void testMiniPlayerArtistRadioAfterLogin(){
		LocalTime before = consoleLogStart("Testing testMiniPlayerArtistRadioAfterLogin - login, start MiniPlayer, show all elements, test functionality.");
		loginPage.loginWithoutVerifying();
		homePage.searchButton.click();
		//Start Artist Radio
		search.startMiniPlayer("Technically Superior");
		Assert.assertTrue("Expected 'Pause Buffering' or 'Pause' because MiniPlayer should be playing an Artist track.",miniPlayer.getTypeOfPlayButton().contains("Pause"));
		miniPlayer.showAllElements();
		miniPlayer.clickPlayPauseButton();
		Assert.assertTrue("Expected 'Play Buffering' or 'Play' because MiniPlayer should be playing an Artist track.",miniPlayer.getTypeOfPlayButton().contains("Play"));
		miniPlayer.clickPlayPauseButton();
		miniPlayer.swipeMiniPlayerToLeftAndClickSkipButton();
		Assert.assertTrue("Skip may not have worked - song title is the same.", miniPlayer.isTitleDifferentAfterSkip());
		miniPlayer.swipeMiniPlayerToLeftToShowSkipButton();
		Assert.assertTrue("Expected 'Skip' instead of 'Scan' because MiniPlayer should be playing an Artist track.",miniPlayer.getTypeOfSkipButton().contains("Skip"));
		miniPlayer.swipeMiniPlayerToRightToHideSkipButton();
		Assert.assertTrue("Track should not be Thumbed Up or Down yet...", miniPlayer.isThumbUpAndThumbDownButtonNotActivated());
		miniPlayer.clickThumbUpButton();
		Assert.assertTrue("ThumbUpButton is not Selected", miniPlayer.isThumbUpButtonActivated());
		miniPlayer.clickThumbDownButton();
		Assert.assertTrue("ThumbDownButton is not Selected", miniPlayer.isThumbDownButtonActivated());
		Assert.assertTrue("Test that it is still currently on Mini Player", miniPlayer.isCurrentlyOnMiniPlayer());
		search.cancelSearch();
		System.out.println("Testing SideBar Nav items");
		sideNavBar.gotoLiveRadioPage();
		System.out.print("Live Radio  :");
		Assert.assertTrue("Mini player was not visible on live radio page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoLiveArtistPage();
		System.out.print("Live Artist  :");
		Assert.assertTrue("Mini player was not visible on artist radio page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoPodcastsPage();
		System.out.print("Podcasts  :");
		Assert.assertTrue("Mini player was not visible on podcasts page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoPerfectFor();
		System.out.print("Perfect For  :");
		Assert.assertTrue("Mini player was not visible on perfect for page", miniPlayer.isCurrentlyOnMiniPlayer());
		sideNavBar.gotoListeningHistoryPage();
		System.out.print("Listening History  :");
		Assert.assertTrue("Mini player was not visible on listening history page", miniPlayer.isCurrentlyOnMiniPlayer());
		consoleLogEnd(before, true, "Tested IOSElements, Controls in MiniPlayer for artist radio");
		//Features to add:
		//After one song has played - it may show a 9 second ad.
		//Ad-free listening brought to you by Stubhub
		//Click Skip Button 6 times.
		//Recommended for you Popup comes up
		//You've reached this station's skip limit. Check out others below. 
	}
	
	@Test
	public void testMiniPlayerRadioStationAfterLogin(){
		LocalTime before = consoleLogStart("Testing testMiniPlayerRadioStationAfterLogin");
		loginPage.loginWithoutVerifying();
		homePage.searchButton.click();
		search.startMiniPlayer("HOT 99.5");
		System.out.println(miniPlayer.getSongTitle());
		System.out.println(miniPlayer.getArtistName());
		search.clearSearch();
		search.startMiniPlayer("HOT 97");
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
