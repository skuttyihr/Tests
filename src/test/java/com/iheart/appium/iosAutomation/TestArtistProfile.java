package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import com.iheart.appium.iosAutomation.AppboyUpsellsPage.Entitlement;
import com.iheart.appium.utilities.TestRoot;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestArtistProfile extends TestRoot {
	
	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();

	@Rule
	public RetryRule retry = new RetryRule(1);
	
	
	@Test
	public void ARTP1_testArtistHero_FREE(){
		LocalTime before = consoleLogStart("Testing elements on Artist Profile Page - testArtistProfileElements()");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("artistProfilePage@Test.com", "test", Entitlement.FREE));
		homePage.clickMyStationsTab();
		//This should play Red Hot Chili Peppers Radio - the only favorite for this account.
		homePage.clickCertainCellOnMyStationsToBeginPlaying(1);
		Assert.assertTrue("Artist Profile should be open for Red Hot Chili Peppers", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("MiniPlayer should be open for Red Hot Chili Peppers", miniPlayer.isCurrentlyOnMiniPlayer());
		artistProfilePage.printArtistHero();
		consoleLogEnd(before, true, "Tested testArtistHero_ARTP1_FREE().");
		
	}
	@Test	
	public void ARTP2_testArtistBio_FREE(){
		LocalTime before = consoleLogStart("Testing elements on Artist Profile Page - testArtistBio_ARTP2_FREE()");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("artistProfilePage@Test.com", "test", Entitlement.FREE));
		homePage.clickMyStationsTab();
		//This should play Red Hot Chili Peppers Radio - the only favorite for this account.
		homePage.clickCertainCellOnMyStationsToBeginPlaying(1);
		Assert.assertTrue("Artist Profile should be open for Red Hot Chili Peppers", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("MiniPlayer should be open for Red Hot Chili Peppers", miniPlayer.isCurrentlyOnMiniPlayer());
		artistProfilePage.printArtistBioElements();
		consoleLogEnd(before, true, "Tested testArtistBio_ARTP2_FREE().");
	}
	@Test
	public void ARTP3_testLatestReleaseTopSongsAlbumsRelatedPopular_FREE(){
		LocalTime before = consoleLogStart("Testing elements on Artist Profile Page - testLatestReleaseTopSongsAlbumsRelatedPopular_ARTP3_FREE()");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("artistProfilePage@Test.com", "test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("nicki minaj");
		searchPage.clickTopResult();
		Assert.assertTrue("Artist Profile should be open for minaj", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("MiniPlayer should be open for minaj", miniPlayer.isCurrentlyOnMiniPlayer());
		artistProfilePage.printLatestRelease();
		artistProfilePage.printTopSongs();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.printAlbums();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.printPopularOn();
		consoleLogEnd(before, true, "Tested testLatestReleaseTopSongsAlbumsRelatedPopular_ARTP3_FREE().");
	}
	
	@Test
	public void ARTP4_testAlbumsAndAlbumProfile_FREE(){
		LocalTime before = consoleLogStart("Testing elements on Artist Profile Page - testAlbumsAndAlbumProfile_ARTP4_FREE()");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("artistProfilePage@Test.com", "test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("britney");
		searchPage.clickTopResult();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.scrollArtistProfilePageDown();
		//sk - 2/8 - commenting out for now
		artistProfilePage.clickShowAllAlbumsCellButton();
		Assert.assertFalse("Play Button should NOT show up on 'All Albums' page.", artistProfilePage.isCurrentlyOnPlayButton());
		//artistProfilePage.printAllAlbumsInformation();
		artistProfilePage.clickFirstAlbumCell();
		Assert.assertFalse("Play Button should NOT show up on 'Album Profile'", artistProfilePage.isCurrentlyOnPlayButton());
		artistProfilePage.printAlbumProfileInformation();
		consoleLogEnd(before, true, "Tested testAlbumsAndAlbumProfile_ARTP4_FREE().");
	}
	
	
	@Test
	public void ARTP5_testFunctions_FREE(){
		LocalTime before = consoleLogStart("Testing methods on testFunctions_ARTP5_FREE");
		Assert.assertTrue("Should log in successfully to FREE account.",loginPage.loginVerifyEntitlement("artistProfileFunctions@Test.com", "test", Entitlement.FREE));
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar("Rihanna");
		searchPage.clickTopResult();
		Assert.assertTrue("Artist Profile should be open for Rihanna", artistProfilePage.isCurrentlyOnArtistProfilePage());
		Assert.assertTrue("MiniPlayer should be open for Rihanna", miniPlayer.isCurrentlyOnMiniPlayer());
		//sk - 2/10 - updated the Latest Release track for Rihanna
		Assert.assertEquals("Rihanna's Latest Release should be 'Sex With Me (Dance Remixes)'", "Sex With Me (Dance Remixes)", artistProfilePage.getLatestReleaseAlbumTitle());
				Assert.assertNotNull("Latest Release section display but there is no album title displayed", artistProfilePage.getLatestReleaseAlbumTitle());
		artistProfilePage.clickFirstTopSongsCell();
		miniPlayer.openFullPlayer();
		Assert.assertEquals("Clicking on a Top Song should have started Artist Radio", "Artist Radio", fullPlayer.getStationType());
		fullPlayer.minimizeFullPlayerToMiniPlayer();
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.scrollArtistProfilePageDown();
		Assert.assertTrue("Clicking on a Related Artist should have started a new song", artistProfilePage.clickFirstRelatedArtistCellToOpenTheirArtistRadioClickPlayCheckForNewSong());		
		consoleLogEnd(before, true, "Tested testFunctions_ARTP5_FREE()");
	}
	

	@Test
	@Ignore
	public void ARTP6_testFunctions_PLUS(){
		LocalTime before = consoleLogStart("Testing methods on testFunctions_ARTP6_PLUS");
		System.out.println("This test case still needs work. Thinking is that there must be differences we should expect for PLUS users as they navigate");
		System.out.println("What is different for Plus Users on Artist Profile Page? Navigating Album Profile, Song to Start, Overflow buttons and their options. Any Save to or Add to playlist? modals" );
		consoleLogEnd(before, true, "Tested testFunctions_ARTP6_PLUS()");
	}
	@Test
	@Ignore
	public void ARTP7_testFunctions_ALLA(){
		LocalTime before = consoleLogStart("Testing methods on testFunctions_ARTP7_ALLA");
		System.out.println("This test case still needs work. Thinking is that there must be differences we should expect for ALLA users as they navigate");
		System.out.println("What is different for ALLA Users on Artist Profile Page? Navigating Album Profile, Song to Start, Overflow buttons and their options. Any Save to or Add to playlist? modals" );
		
		consoleLogEnd(before, true, "Tested testFunctions_ARTP7_ALLA()");
	}
}
