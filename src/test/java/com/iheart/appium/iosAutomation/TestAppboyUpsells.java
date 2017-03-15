
/**
 * @author skutty
 * iOS flagship app switched to Appboy Upsells in Feb 2017.
 * Test objective are to verify that when a Free or Plus user clicks on certain features, they are presented and upsell. The upsell should be tested for
 * 1. Upsell Headline - the headline on the upsell should match with the expected value on the upsell page
 * 2. If the user is Free and trial eligible - then the upsell buttons should show 'Start 30 day Free Trial' text for both Plus and AllAccess 
 *    subscription buttons, both the buttons should be enabled and connect to AppStore.
 * 3. If the user is Free and trial expired - then the upsell should show 'Subscribe To <Plus/All Access>' text for both Plus and AllAccess 
 *    subscription buttons, both the buttons should be enabled and connect to AppStore.
 * 4. If the user is Plus - then the upsell should show 'Subscribe To All Access' text for the AllAccess 
 *    subscription buttons, only the All Access button should be enabled and connect to AppStore.
 */

package com.iheart.appium.iosAutomation;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import com.iheart.appium.iosAutomation.AppboyUpsellsPage.Entitlement;
import com.iheart.appium.iosAutomation.AppboyUpsellsPage.RepeatAction;
import com.iheart.appium.utilities.Errors;
import com.iheart.appium.utilities.TestRoot;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAppboyUpsells extends TestRoot {

	@Before
	public void setUp() {
		setup();
	}
	
	@Rule
	public ScreenshotRule screenshot = new ScreenshotRule();
	
	// ************************************* Upsells - Replay (Player) ***********************************//
	
	/**
	 * Naming convention for expected upsell headline - page_element_overflow option - where the upsell occurs	
	 * sk - 2/27 -Test unlimited skips upsell shows for FREE TRIAL ELIGIBILE user on ARTIST radio - should have both buttons active
	 * Button should show Free Trial 
	 * 3/6 - Pass
	 */
	@Test
	public void UPS1_testPlayerSkipLimitUpsell_FREE_TRLELG() {
		LocalTime before = consoleLogStart("Testing artist radio unlimited skip upsell UPS1_testPlayerSkipLimitUpsell_FREE_TRLELG");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, true, "Ed Sheeran");		
		fullPlayer.skipToTheLimit();
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.ARTISTRADIOFULLPLAYER_SKIP));	
		Assert.assertTrue("Upsell headline test for artist radio unlimited skips for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Upsell headline test for artist radio unlimited skips for free user failed." + err, err.noErrors());
		appboyUpsellsPage.repeatActionToTriggerUpsell(RepeatAction.SKIP);
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialEligibleUser());
		Assert.assertEquals("Buttons state test for artist radio unlimited skips for free user failed.", 0, err.getErrors().length());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio Unmlimited Skips Upsell for Free TrialEligible User");	
	}
	
	/**
	 * sk - 3/5 -Test unlimited skips upsell shows for FREE NON TRIAL ELIGIBILE user on ARTIST radio
	 * 3/6 - Pass
	 */
	@Test
	public void UPS2_testPlayerSkipLimitUpsell_FREE_TRLEXP() {
		LocalTime before = consoleLogStart("Testing artist radio unlimited skips upsell UPS2_testPlayerSkipLimitUpsell_FREE_TRLEXP");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, false, "Luke Bryan");
		fullPlayer.skipToTheLimit();
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.ARTISTRADIOFULLPLAYER_SKIP));	
		Assert.assertTrue("Upsell headline test for artist radio unlimited skips for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialExpiredUser());
		appboyUpsellsPage.repeatActionToTriggerUpsell(RepeatAction.SKIP);
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Buttons state test for artist radio unlimited skips for free user failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio Unmlimited Skips Upsell for Free TrialExpired User");	
	}
	
	/**
	 * sk - 3/5 -Test unlimited skips upsell DOES NOT show for Plus user.
	 */
	@Test
	public void UPS3_testPlayerSkipLimitUpsell_PLUS() {
		LocalTime before = consoleLogStart("Testing artist radio unlimited skips UPS3_testPlayerSkipLimitUpsell_PLUS().");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.PLUS, false, "Luke Bryan");
		fullPlayer.skipToTheLimit();
		if (appboyUpsellsPage.isUpsellDisplayed())
			err.add("Upsell page should not display for unlimited skips Plus User.");
		Assert.assertTrue("Upsell display test for plus user failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio Unmlimited Skips Upsell does not show for Plus User");	
	}
		
	/**
	 * sk - 2/27 -Test replay upsell shows for FREE NON-TRIAL ELIGIBILE user on ARTIST radio
	 */
	@Test
	public void UPS4_testPlayerReplayUpsell_Artist_FREE_TRLEXP() {
		LocalTime before = consoleLogStart("Testing artist radio replay UPS4_testPlayerReplayUpsell_Artist_FREE_TRLEXP");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, false, "Luke Bryan");
		err.add(fullPlayer.clickReplayButtonToOpenReplayModal());
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.ARTISTRADIOFULLPLAYER_REPLAY));	
		Assert.assertTrue("Upsell headline test for artist radio replay for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		fullPlayer.clickReplayButtonToOpenReplayModal();
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio Replay Upsell for Free Trial Expired User");	
	}
	
	/**
	 * sk - 3/5 -Test replay upsell shows for FREE NON-TRIAL ELIGIBILE user on LIVE radio
	 */
	@Test
	public void UPS5_testPlayerReplayUpsell_Live_FREE_TRLEXP() {
		LocalTime before = consoleLogStart("Testing live radio replay UPS5_testPlayerReplayUpsell_Live_FREE_TRLEXP()");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, false, "Z100");
		err.add(fullPlayer.clickReplayButtonToOpenReplayModal());
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.LIVERADIOFULLPLAYER_REPLAY));	
		Assert.assertTrue("Upsell headline test for artist radio replay for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		fullPlayer.clickReplayButtonToOpenReplayModal();
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Live Radio Replay Upsell for Free Trial Expired User");	
	}
	
	/**
	 * sk - 2/27 -Test replay upsell shows for FREE TRIAL ELIGIBILE user on ARTIST radio
	 */
	@Test
	public void UPS6_testPlayerReplayUpsell_Artist_FREE_TRLELG() {
		LocalTime before = consoleLogStart("Testing artist radio replay UPS6_testPlayerReplayUpsell_Artist_FREE_TRLELG");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, true, "Luke Bryan");
		err.add(fullPlayer.clickReplayButtonToOpenReplayModal());
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.ARTISTRADIOFULLPLAYER_REPLAY));	
		Assert.assertTrue("Upsell headline test for artist radio replay for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		fullPlayer.clickReplayButtonToOpenReplayModal();
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio Replay Upsell for Free Trial Eligible User");	
	}
	
	/**
	 * sk - 3/5 -Test replay upsell shows for FREE TRIAL ELIGIBILE user on LIVE radio
	 */
	@Test
	public void UPS7_testPlayerReplayUpsell_Live_FREE_TRLELG() {
		LocalTime before = consoleLogStart("Testing live radio replay UPS7_testPlayerReplayUpsell_Live_FREE_TRLELG().");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, true, "Z100");
		err.add(fullPlayer.clickReplayButtonToOpenReplayModal());
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.LIVERADIOFULLPLAYER_REPLAY));	
		Assert.assertTrue("Upsell headline test for artist radio replay for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		fullPlayer.clickReplayButtonToOpenReplayModal();
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Live Radio Replay Upsell for Free Trial Eligible User");	
	}
	
	/**
	 * sk - 3/5 -Test upsell DOES NOT show for Plus user when tapping Replay
	 */
	@Test
	public void UPS8_testPlayerReplayUpsell_PLUS() {
		LocalTime before = consoleLogStart("Testing live radio replay UPS8_testPlayerReplayUpsell_PLUS()");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.PLUS, false, "103.5");
		err.add(fullPlayer.clickReplayButtonToOpenReplayModal());
		if (appboyUpsellsPage.isUpsellDisplayed())
			err.add("Upsell page should not display for replay feature for Plus User.");
		Assert.assertTrue("Upsell should not display for replay feature for Plus user." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Live Radio Replay Upsell did not display for Plus User.");	
	}
/* */	
	/**
	 * sk - 2/27 -Test replay upsell shows for FREE NON-TRIAL ELIGIBILE user on ARTIST radio
	 */
	@Test
	public void UPS9_testPlayerAddToPlaylistUpsell_Artist_FREE_TRLEXP() {
		LocalTime before = consoleLogStart("Testing artist radio replay UPS9_testPlayerAddToPlaylistUpsell_Artist_FREE_TRLEXP()");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, false, "Luke Bryan");
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.FREE));
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.FULLPLAYER_SAVEBUTTON_ADDTOPLAYLIST));
		Assert.assertTrue("Upsell headline test for artist radio replay for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.FREE));
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio - Add to Playlist Upsell for Free Trial Expired User");	
	}
	
	/**
	 * sk - 3/5 -Test replay upsell shows for FREE NON-TRIAL ELIGIBILE user on LIVE radio
	 */
	@Test
	public void UPS10_testPlayerAddToPlaylistUpsell_Live_FREE_TRLEXP() {
		LocalTime before = consoleLogStart("Testing live radio replay UPS10_testPlayerAddToPlaylistUpsell_Live_FREE_TRLEXP()");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, false, "Z100");
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.FREE));
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.FULLPLAYER_SAVEBUTTON_ADDTOPLAYLIST));	
		Assert.assertTrue("Upsell headline test for live radio - 'Save - Add to Playlist' for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.FREE));
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialExpiredUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Live Radio - Add to Playlist Upsell for Free Trial Expired User");	
	}
	
	/**
	 * sk - 2/27 -Test replay upsell shows for FREE TRIAL ELIGIBILE user on ARTIST radio
	 */
	@Test
	public void UPS11_testPlayerAddToPlaylistUpsell_Artist_FREE_TRLELG() {
		LocalTime before = consoleLogStart("Testing artist radio replay UPS11_testPlayerAddToPlaylistUpsell_Artist_FREE_TRLELG()");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, true, "Luke Bryan");
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.FREE));
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.FULLPLAYER_SAVEBUTTON_ADDTOPLAYLIST));	
		Assert.assertTrue("Upsell headline test for artist radio - 'Save - Add to Playlist' for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.FREE));
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio - Add to Playlist Upsell for Free Trial Eligible User");	
	}
	
	/**
	 * sk - 3/5 -Test replay upsell shows for FREE TRIAL ELIGIBILE user on LIVE radio
	 */
	@Test
	public void UPS12_testPlayerAddToPlaylistUpsell_Live_FREE_TRLELG() {
		LocalTime before = consoleLogStart("Testing live radio replay UPS12_testPlayerAddToPlaylistUpsell_Live_FREE_TRLELG().");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.FREE, true, "Z100");
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.FREE));
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.FULLPLAYER_SAVEBUTTON_ADDTOPLAYLIST));
		Assert.assertTrue("Upsell headline test for artist radio replay for free user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.FREE));
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialEligibleUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Live Radio Player - Save - Add to Playlist Upsell for Free user");
	}
	
	/**
	 * sk - 3/5 -Test upsell DOES NOT show for AA user when tapping Replay
	 */
	@Test
	public void UPS13_testPlayerAddToPlaylistUpsell_Live_ALLA() {
		LocalTime before = consoleLogStart("Testing live radio replay UPS13_testPlayerAddToPlaylistUpsell_Live_ALLA()");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.ALLA, false, "103.5");
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.ALLA));
		if (appboyUpsellsPage.isUpsellDisplayed())
			err.add("Upsell page should not display for replay feature for AA User.");
		Assert.assertTrue("Upsell display test for player - save,add to playlist - AA user failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Live Radio Player - Save - Add to Playlist upsell does not show for AA User");	
	}
	
	/**
	 * sk - 3/5 -Test upsell DOES NOT show for AA user when tapping Player - Save - Add to Playlist
	 */
	@Test
	public void UPS14_testPlayerAddToPlaylistUpsell_Artist_ALLA() {
		LocalTime before = consoleLogStart("Testing live radio replay UPS14_testPlayerAddToPlaylistUpsell_Artist_ALLA()");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.ALLA, false, "Nicki Jam");
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.ALLA));
		if (appboyUpsellsPage.isUpsellDisplayed())
			err.add("Upsell page should not display for player - add to playlist feature for AA User.");
		Assert.assertTrue("Upsell display test for rplayer - save,add to playlist - AA user failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Live Radio - Player - save - add to playlist upsell does not show for AA User.");
	}
	
	/**
	 * sk - 3/6 -Test add to playlist upsell shows for PLUS user on ARTIST radio
	 */
	@Test
	public void UPS15_testPlayerAddToPlaylistUpsell_Artist_PLUS() {
		LocalTime before = consoleLogStart("Testing artist radio replay UPS15_testPlayerAddToPlaylistUpsell_Artist_PLUS()");
		Errors err = Page.playStationOpenFullPlayer(Entitlement.PLUS, false, "Luke Bryan");
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.PLUS));
		err.add(appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(appboyUpsellsPage.FULLPLAYER_SAVEBUTTON_ADDTOPLAYLIST));	
		Assert.assertTrue("Upsell headline test for artist radio - 'Save - Add to Playlist' for plus user failed." + err, err.noErrors());
		err.add(appboyUpsellsPage.verifyUpsellPlusButtonState_PlusUser());
		Assert.assertTrue("Button state test 1 failed." + err, err.noErrors());
		err.add(fullPlayer.clickSaveModalAddToPlaylist(Entitlement.PLUS));
		err.add(appboyUpsellsPage.verifyUpsellAAButtonState_PlusUser());
		Assert.assertTrue("Button state test 2 failed." + err, err.noErrors());
		consoleLogEnd(before, err.noErrors(), "Tested Full Player Artist Radio - Add to Playlist Upsell for Plus User");	
	}
}
