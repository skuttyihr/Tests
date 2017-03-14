package com.iheart.appium.iosAutomation;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Rule;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMyMusic extends TestRoot{
	@Before
	public void setUp() throws Exception {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	/**
	 * This account used to be subscribed to AA, but now it's Free. This changes the Upsell Cell messages.
	 * isTrialEligible = false. 
	 */
	@Test
	public void MYMU1_testMyMusic_FREE_POST_TRIAL(){
		LocalTime before = consoleLogStart("MYMU1_testMyMusic_FREE_POST_TRIAL()");
		loginPage.loginVerifyEntitlement("trav@free.com", "travfree", "FREE");
		homePage.clickMyMusicTab();
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			Assert.assertEquals("Initial Message Title Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_TITLE_LABEL_FREE, myMusicPage.getInitialMessageTitleLabel());
			Assert.assertEquals("Initial Message SubTitle Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_SUBTITLE_LABEL_FREE, myMusicPage.getInitialMessageSubtitleLabel());
			Assert.assertEquals("Initial Message Dismiss Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_DISMISS_LABEL_FREE, myMusicPage.getInitialMessageDismissLabel());
			myMusicPage.dismissInitialMessage();
		}
		myMusicPage.showAllElementsForFREEPOSTUsers();
		Assert.assertEquals("Playlists Title in PlaylistHeaderView does not match.", 
				myMusicPage.PLAYLIST_HEADER_VIEW_PLAYLIST_LABEL_FREE, myMusicPage.getPlaylistsTitle());
		Assert.assertEquals("Upsell Cell Title Label for a Free account after a Trial does not match expected. ", 
				myMusicPage.UPSELL_CELL_TITLE_LABEL_FREE_POST_TRIAL, myMusicPage.getUpsellCellTitleLabel());
		//Assert.assertEquals("Upsell Cell Title Label for a Free account after a Trial does not match expected. ", 
		//		myMusicPage.UPSELL_CELL_TITLE_LABEL_FREE_POST_TRIAL, myMusicPage.getPlaylistsTitle());
		
		//clickMyPlaylist();
		//clickLearnMoreOnMyPlaylist();
		//upsellPage.clickXtoCloseUpsellModal();
		//clickSongsPlaylistButton();
		//upsellPage.clickXtoCloseUpsellModal();
		//clickLearnMoreUpsellButton();
		//upsellPage.clickXtoCloseUpsellModal();
		//printElementInformation(MyMusicViewPremiumPresenterCollectionView);
		consoleLogEnd(before, true, "Tested MYMU1_testMyMusic_FREE_POST_TRIAL()");

	}
	/**
	 * This Account has never signed up for ALLA or PLUS and therefore shouldn't have other playlists saved etc. 
	 * This differs from MYMU1 for the Upsell Cell strings.
	 * isTrialEligible = true
	 */
	@Test
	public void MYMU2_testMyMusic_FREE_PRE_TRIAL(){
		LocalTime before = consoleLogStart("MYMU2_testMyMusic_FREE_PRE_TRIAL()");
		Assert.assertTrue("Should have logged in to an Free Account.",loginPage.loginVerifyEntitlement("trav2@free.com", "trav2free", "FREE"));
		homePage.clickMyMusicTab();
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			Assert.assertEquals("Initial Message Title Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_TITLE_LABEL_FREE, myMusicPage.getInitialMessageTitleLabel());
			Assert.assertEquals("Initial Message SubTitle Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_SUBTITLE_LABEL_FREE, myMusicPage.getInitialMessageSubtitleLabel());
			Assert.assertEquals("Initial Message Dismiss Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_DISMISS_LABEL_FREE, myMusicPage.getInitialMessageDismissLabel());
			myMusicPage.dismissInitialMessage();
		}
		myMusicPage.showAllElementsForFREEPREUsers();
		Assert.assertEquals("Playlists Title in PlaylistHeaderView does not match.", 
				myMusicPage.PLAYLIST_HEADER_VIEW_PLAYLIST_LABEL_FREE, myMusicPage.getPlaylistsTitle());
		Assert.assertEquals("Upsell Cell Title Label for a Free account after a Trial does not match expected. ", 
				myMusicPage.UPSELL_CELL_TITLE_LABEL_FREE_PRE_TRIAL, myMusicPage.getUpsellCellTitleLabel());
		Assert.assertEquals("Upsell Cell Intro Title Label for a Free account pre-trial did not match expected.", 
				myMusicPage.UPSELL_CELL_INTRO_TITLE_LABEL_FREE_PRE_TRIAL, myMusicPage.getUpsellCellIntroTitleLabel());
		
		//Radio and unlimited music on demand, all in one app.
		//clickMyPlaylist();
		//clickLearnMoreOnMyPlaylist();
		//upsellPage.clickXtoCloseUpsellModal();
		//clickSongsPlaylistButton();
		//upsellPage.clickXtoCloseUpsellModal();
		//clickLearnMoreUpsellButton();
		//upsellPage.clickXtoCloseUpsellModal();
		//printElementInformation(MyMusicViewPremiumPresenterCollectionView);
		consoleLogEnd(before, true, "Tested MYMU2_testMyMusic_FREE_PRE_TRIAL()");
	}
	
	/**
	 * Plus looks the same on MyMusic, expect that songs can be played in My Playlist. 
	 */
	@Test
	public void MYMU3_testElements_PLUS(){
		LocalTime before = consoleLogStart("MYMU3_testElements_PLUS()");
		loginPage.loginVerifyEntitlement("trav@plus.com", "travplus", "PLUS");
		homePage.clickMyMusicTab();
		myMusicPage.handleNewInitialMessage();
		myMusicPage.showAllElementsForPLUSUsers();
		myMusicPage.clickFirstPlaylistInMyMusic();
		myMusicPage.handleNewInitialMessage();
		String myPlaylist = myMusicPage.getCollapseableHeaderTitleLabelText();
		Assert.assertEquals("Top Cell should be My Playlist.", "My Playlist", myPlaylist);
		myMusicPage.clickFirstSongOnPlaylist();
		myMusicPage.handleNewInitialMessage();
		Assert.assertTrue("Clicking the first song on the My Playlist should have launched miniPlayer but not song to start", miniPlayer.isCurrentlyOnMiniPlayer());
		consoleLogEnd(before, true, "Tested MYMU3_testElements_PLUS()");
	}
	

	/**
	 * This test opens a populated ALLA account and attempts to open an album from the Albums Playlist button, 
	 * then it dismisses the intitial message,
	 * then it clicks the Show All Playlists Cell and attempts to open the Manage Playlists view. 
	 */
	@Test
	public void MYMU4_managePlaylists_ALLA_POP(){
		LocalTime before = consoleLogStart("MYMU4_managePlaylists_ALLA_POP()");
		
		Assert.assertTrue("Should have logged in to an All Access Account.", 
				loginPage.loginVerifyEntitlement("mymu4@all.com", "Mymu44moo", "ALLA"));
		homePage.clickMyMusicTab();
		//if(artistProfilePage.isCurrentlyOnArtistProfilePage()){
		//	artistProfilePage.clickNavBarBackButton();
		//}
		/*
		sleep(5000);
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			Assert.assertEquals("Initial Message Title Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_TITLE_LABEL_FREE, myMusicPage.getInitialMessageTitleLabel());
			Assert.assertEquals("Initial Message SubTitle Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_SUBTITLE_LABEL_FREE, myMusicPage.getInitialMessageSubtitleLabel());
			Assert.assertEquals("Initial Message Dismiss Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_DISMISS_LABEL_FREE, myMusicPage.getInitialMessageDismissLabel());
			myMusicPage.dismissInitialMessage();
		}
		*/
		Assert.assertFalse("Upcell Cell should not exist on My Music Page for ALLA users. ", 
				myMusicPage.isCurrentlyOnUpsellCell());
		
		Assert.assertTrue("The method should have verified that the three empty cells exist for a Fresh ALLA acct.", myMusicPage.manageAllPlaylists()); //showAllElementsForOldALLAUsers();
		consoleLogEnd(before, true, "Tested MYMU4_managePlaylists_ALLA_POP()");
	}
	
	/**
	 * This test opens MyMusic with an ALLA provisioned account and checks the main elements exist,
	 * and then it opens each of the SONGS, ALBUMS, and ARTISTS views and checks that their empty cells exist. 
	 * This account should never add any songs to MyMusic so that it keeps it's fresh status. 
	 */
	@Test
	public void MYMU5_testEmptySongsAlbumsArtistsPlaylists_ALLA_FRESH(){
		LocalTime before = consoleLogStart("MYMU5_testEmptySongsAlbumsArtistsPlaylists_ALLA_FRESH()");
		Assert.assertTrue("Should have logged in to an All Access Account.", 
				loginPage.loginVerifyEntitlement("mymu5fresh@all.com", "mymu55t", "ALLA"));//travfresh@all.com", "travFresh66t", "ALLA"));
	
		homePage.clickMyMusicTab();
		sleep(5000);
		myMusicPage.handleNewInitialMessage();
		Assert.assertFalse("Upcell Cell should not exist on My Music Page for ALLA users. ", 
				myMusicPage.isCurrentlyOnUpsellCell());
		Assert.assertTrue("The method should have verified that the three empty cells exist for a Fresh ALLA acct."
				,myMusicPage.testEmptySongsAlbumsArtistsPlaylists());
		
		consoleLogEnd(before, true, "Tested MYMU5_testEmptySongsAlbumsArtistsPlaylists_ALLA_FRESH()");
	}
	/**
	 * This test opens MyMusic using an ALLA account with around 50 songs and 4 different playlists. It is verifying the main buttons in MyMusic work.
	 * 
	 */
	@Test
	public void MYMU6_testSongsAlbumsArtistsPlaylists_ALLA_POP(){
		LocalTime before = consoleLogStart("MYMU6_testSongsAlbumsArtistsPlaylists_ALLA_POP()");
		Assert.assertTrue("Should have logged in to an All Access Account.", 
				loginPage.loginVerifyEntitlement("travused@all.com", "travUsed66t", "ALLA"));
	
		homePage.clickMyMusicTab();
		sleep(5000);
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			Assert.assertEquals("Initial Message Title Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_TITLE_LABEL_FREE, myMusicPage.getInitialMessageTitleLabel());
			Assert.assertEquals("Initial Message SubTitle Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_SUBTITLE_LABEL_FREE, myMusicPage.getInitialMessageSubtitleLabel());
			Assert.assertEquals("Initial Message Dismiss Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_DISMISS_LABEL_FREE, myMusicPage.getInitialMessageDismissLabel());
			myMusicPage.dismissInitialMessage();
		}
		Assert.assertFalse("Upcell Cell should not exist on My Music Page for ALLA users. "
				,myMusicPage.isCurrentlyOnUpsellCell());
		Assert.assertTrue("The method should have verified that the third (2) cells for Playlists, Albums, Artists, and Songs are visible for an ALLA acct with multiple songs saved."
				,myMusicPage.showAllElementsForOldALLAUsers());
		consoleLogEnd(before, true, "Tested MYMU6_testSongsAlbumsArtistsPlaylists_ALLA_POP()");
	}
	/**
	 * This test logs in with a FRESH ALLA account that still has a 
	 */
	@Test
	public void MYMU7_createNewPlaylist_ALLA_FRESH(){
		LocalTime before = consoleLogStart("MYMU7_createNewPlaylist_ALLA_FRESH()");
		Assert.assertTrue("Should have logged in to an All Access Account.", 
				loginPage.loginVerifyEntitlement("travfresh@all.com", "travFresh66t", "ALLA"));
		homePage.clickMyMusicTab();	
		sleep(5000);
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			Assert.assertEquals("Initial Message Title Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_TITLE_LABEL_FREE, myMusicPage.getInitialMessageTitleLabel());
			Assert.assertEquals("Initial Message SubTitle Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_SUBTITLE_LABEL_FREE, myMusicPage.getInitialMessageSubtitleLabel());
			Assert.assertEquals("Initial Message Dismiss Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_DISMISS_LABEL_FREE, myMusicPage.getInitialMessageDismissLabel());
			myMusicPage.dismissInitialMessage();
		}
		
		Assert.assertFalse("Upcell Cell should not exist on My Music Page for ALLA users. ", 
				myMusicPage.isCurrentlyOnUpsellCell());
		myMusicPage.clickCreateNewPlaylistButton();
		String playlistName = myMusicPage.enterNewPlaylistNameAndClickCreate("newPL" + ThreadLocalRandom.current().nextInt(20000, 29999));
		sleep(2000);
		myMusicPage.clickFirstPlaylistInMyMusic();
		myMusicPage.printPlaylistInformation();

		Assert.assertEquals("New Playlist name should match top cell", playlistName, myMusicPage.getCollapseableHeaderTitleLabelText());
		int numberOfSongsInNewPlaylist = myMusicPage.getNumberOfSongsInMyPlaylist();
		Assert.assertEquals("The number of songs in a new playlist just created should be 0.", 0, numberOfSongsInNewPlaylist );
		myMusicPage.clickSearchActionButtonOnEmptyPlaylist();
		Assert.assertTrue("Clicking 'Search Songs' on new empty playlist should open Search Page.", 
				searchPage.isCurrentlyOnSearchPage());
		System.out.println("Will now try to search for 'Oops, I did it again' and save it to new playlist");
		searchPage.enterTextIntoSearchBar("oops");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.clickSaveButtonToOpenSaveModal();
		fullPlayer.clickAddToPlaylistButtonInSaveModal("ALLA");
		addToPlaylistPage.printAllElements();
		addToPlaylistPage.clickFirstPlaylistInCollection();
		fullPlayer.minimizeFullPlayerToMiniPlayer();
		searchPage.clearSearchBarTextField();
		searchPage.enterTextIntoSearchBar("save ourselves");
		searchPage.clickTopResult();
		miniPlayer.openFullPlayer();
		fullPlayer.clickSaveButtonToOpenSaveModal();
		fullPlayer.clickAddToPlaylistButtonInSaveModal("ALLA");
		addToPlaylistPage.clickFirstPlaylistInCollection();
		fullPlayer.minimizeFullPlayerToMiniPlayer();
		searchPage.clickCancelButtonOnSearchBar();
		myMusicPage.clickFirstPlaylistInMyMusic();
		myMusicPage.clickPlaylistOverflowButton();
		myMusicPage.clickRenameOnPlaylistOverflow();
		myMusicPage.enterRenamedPlaylistOnPlaylistOverflow("z"); 
		int numberOfSongsInPlaylistWith2Songs = myMusicPage.getNumberOfSongsInMyPlaylist();
		Assert.assertEquals("The number of songs in a playlist with 2 songs should be...drumroll...2.", 2, numberOfSongsInPlaylistWith2Songs );
		myMusicPage.clickOfflineButtonOnPlaylist();
		myMusicPage.clickShuffleButtonOnPlaylist();
		Assert.assertTrue("Offline Switch State should be set to True after clicking it.", myMusicPage.getPlaylistHeaderCellOfflineSwitchState() );
		myMusicPage.clickPlaylistOverflowButton();
		myMusicPage.clickEditOnPlaylistOverflow();
		myMusicPage.printEditPlaylistElements();
		myMusicPage.clickCancelButtonWhileEditingPlaylist();
		if(myMusicPage.clickPlaylistOverflowButton()){
			myMusicPage.clickDeletePlaylistOnPlaylistOverflow();
			myMusicPage.clickDeleteToConfirm();
		}
		myMusicPage.clickFirstPlaylistInMyMusic();
		String otherPlaylistName = myMusicPage.getCollapseableHeaderTitleLabelText();
		Assert.assertNotEquals("Deleting the original playlist should mean that top playlist is different.", playlistName, otherPlaylistName);
		consoleLogEnd(before, true, "Tested MYMU7_createNewPlaylist_ALLA_FRESH()");
		
	}
}
