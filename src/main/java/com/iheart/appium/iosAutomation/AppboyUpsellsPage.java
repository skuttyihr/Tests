/**
 * @author skutty - 2/24
 * Elements and methods for the new Appboy Upsells that have been integrated into the app
 * 
 */

package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;
import com.iheart.appium.utilities.Errors;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AppboyUpsellsPage extends Page{

	/**
	 * sk - 2/19 - Upsell modal elements
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeLink[1]/XCUIElementTypeImage[1]")
	private IOSElement closeUpsellButton;
	@iOSFindBy(accessibility = "IHRUpsellView-ContentView-UIView") private IOSElement IHRUpsellViewContentViewUIView;
	@iOSFindBy(id = "Subscribe, to Plus") private IOSElement subscribeToPlusButton;
	@iOSFindBy(id = "Subscribe, to All Access") private IOSElement subscribeToAllAccessButton;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeImage")
	private IOSElement napsterLogo;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeImage")
	private IOSElement upsellPageFirstLine;
	@iOSFindBy(id = "Cancel") private IOSElement cancelAppStoreModalButton	;
	@iOSFindBy(id = "Use Existing Apple ID") private IOSElement appleStoreModalButtonAppleId;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[13]/XCUIElementTypeLink[1]")
	private IOSElement start30DayFreeTrialPlusUserButton;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[13]/XCUIElementTypeLink[2]")
	private IOSElement start30DayFreeTrialAllAccessUserButton;
	@iOSFindBy(accessibility="NEW") private IOSElement newFeatureTag;
	@iOSFindBy(xpath="//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/"
			+ "XCUIElementTypeStaticText") private IOSElement upsellHeadlineText;
	@iOSFindBy(accessibility="Got it") private IOSElement gotItButton;
	@iOSFindBy(accessibility="Use Existing Apple ID") private IOSElement existingAppleIDButtonOnAppleStoreSignInModal;


	/**
	 * sk - 2/27 - Upsell headlines as expected
	 * Naming convention - page_element_overflowoption - where the upsell occurs	artistRadioFullPlayer_Replay
	 * Adding this at the bottom of the page, so as to have the tests in focus at the top of the page.
	 */	
	public final String ALBUMPROFILEPAGE_HEADEROVERFLOW_ADDTOPLAYLIST = "Add this album to your own playlist with iHeartRadio All Access.";
	public final String ALLALBUMSPAGE_ALBUMOVERFLOW_ADDTOPLAYLIST = "Create unlimited playlists. Try iHeartRadio All Access.";
	public final String ARTISTPROFILEPAGE_ALBUMOVERFLOW_ADDTOPLAYLIST = "Create unlimited playlists. Try iHeartRadio All Access.";
	public final String FULLPLAYER_SAVEBUTTON_ADDTOPLAYLIST = "Create unlimited playlists. Try iHeartRadio All Access.";
	public final String MYPLAYLISTPLAYER_SAVEBUTTON_ADDTOANOTHERPLAYLIST = "Create unlimited playlists. Try iHeartRadio All Access.";
	public final String CPLAYLISTPLAYER_SAVEBUTTON_ADDTOANOTHERPLAYLIST = "Create unlimited playlists. Try iHeartRadio All Access.";
	public final String ALBUMPROFILEPAGE_SONGOVERFLOW_ADDTOPLAYLIST = "Create unlimited playlists. Try iHeartRadio All Access.";
	public final String ARTISTPROFILEPAGE_TOPSONGSOVERFLOW_ADDTOPLAYLIST = "Create unlimited playlists. Try iHeartRadio All Access."; 
	public final String ALBUMPROFILEPAGE_PLAYBUTTON = "Play the whole album with iHeartRadio All Access.";
	public final String CPLAYLISTPAGE_HEADEROVERFLOW_SAVEPLAYLIST = "Save this playlist to your collection. Try iHeartRadio All Access.";
	public final String MYPLAYLIST_TRACKOVERFLOW_ADDTOPLAYLIST = "Create your own playlists. Try iHeartRadio All Access.";
	public final String MYPLAYLIST_HEADEROVERFLOW_ADDTOANOTHERPLAYLIST = "Save this playlist to your collection. Try iHeartRadio All Access.";
	public final String MYPLAYLIST_PLAYLISTOVERFLOW_EDIT = "Get more out of your playlist with iHeartRadio All Access.";
	public final String MYPLAYLIST_HEADEROVERFLOW_EDIT = "Get more out of your playlist with iHeartRadio All Access.";
	public final String MYPLAYLIST_TRACKOVERFLOW_REMOVEFROMPLAYLIST = "Get more out of your playlist with iHeartRadio All Access.";
	public final String ARTISTRADIOFULLPLAYER_SKIP = "Unlimited skips. Try iHeartRadio Plus to enjoy as many as you want.";
	public final String MYMUSICPIVOT_SONGS = "Access your music library and create unlimited playlists.";
	public final String MYMUSICPIVOT_ALBUMS = "Access your music library and create unlimited playlists.";
	public final String MYMUSICPIVOT_ARTISTS = "Access your music library and create unlimited playlists.";
	public final String MYMUSICPIVOT_CREATENEW = "Access your music library and create unlimited playlists.";
	public final String MYPLAYLIST_OFFLINETOGGLE = "Listen offline, without a connection. Try iHeartRadio All Access.";
	public final String LIVERADIOFULLPLAYER_REPLAY = "Encore! Instantly replay songs on the radio with iHeartRadio Plus.";
	public final String ARTISTRADIOFULLPLAYER_REPLAY = "Encore! Instantly replay songs on the radio with iHeartRadio Plus.";
	public final String ALBUMPROFILEPAGE_HEADEROVERFLOW_SAVEALBUM = "Save this album to your music library with iHeartRadio All Access.";
	public final String ALLABUMSPAGE_ALBUMOVERFLOW_SAVEALBUM = "Save any album you want. Try iHeartRadio All Access.";
	public final String ARTISTPROFILEPAGE_ALBUMSECTIONALBUMOVERFLOW_SAVEALBUM = "Save any album you want. Try iHeartRadio All Access.";
	public final String ALBUMPROFILEPAGE_TRACKOVERFLOW_SAVESONG = "Save any song you want. Try iHeartRadio All Access.";
	public final String ARTISTPROFILEPAGE_TOPSONGSOVERFLOW_SAVESONG = "Save any song you want. Try iHeartRadio All Access.";
	public final String CPLAYLISTPAGE_TRACKOVERFLOW_SAVESONG = "Save any song you want. Try iHeartRadio All Access.";
	public final String MYPLAYLIST_SHUFFLEBUTTON = "Want to shuffle your playlist? Try iHeartRadio All Access.";

	public AppboyUpsellsPage() {
		super();
	}

	public AppboyUpsellsPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	public enum Entitlement {FREE, PLUS, ALLA};

	/**
	 * sk - 2/24 - getting upsell text after appboy upsells kicked in
	 * @return
	 */
	public String getUpsellText() {
		if (waitForElementToBeVisible(upsellHeadlineText, 3)) {
			return  upsellHeadlineText.getText();			
		}
		return "";
	}

	public IOSElement getNewFeatureTag() {
		return newFeatureTag;
	}

	public boolean isUpsellDisplayed() {
		boolean isUpsellDisplayed = waitForElementToBeVisible(newFeatureTag, 8); 
		System.out.println("appboyUpsellsPage.isUpsellDisplayed(): " + isUpsellDisplayed);
		return isUpsellDisplayed;
	}
	
	public void closeUpsell() {
		if (waitForElementToBeVisible(closeUpsellButton, 3)) {
			closeUpsellButton.click();
		}
	}

	public String getTextFromPlusButton() {
		String buttonText = "";
		if (waitForElementToBeVisible(subscribeToPlusButton, 2)) {
			buttonText = subscribeToPlusButton.getText();
			System.out.println("appboyUpsellsPage.getTextFromPlusButton():" + buttonText);
		} else if (waitForElementToBeVisible(start30DayFreeTrialPlusUserButton,2)) {
			buttonText = start30DayFreeTrialPlusUserButton.getText();
			System.out.println("appboyUpsellsPage.SubscribeToPlusButton.getText():" + buttonText);
		}
		return buttonText;
	}

	public String getTextFromAllAccessButton() {
		if (waitForElementToBeVisible(subscribeToAllAccessButton, 2)) {
			System.out.println("appboyUpsellsPage.getTextFromAllAccessButton(): All Access subscription button is visible.");
			return subscribeToAllAccessButton.getText();
		}
		return "";
	}
	
	/**
	 * When Subscribing to AA or Plus for a Free User, it will ask you to sign into an Apple ID in order to complete the transaction.
	 * We will check whether this modal is displayed before canceling and leaving the Upsell Modal. 
	 * 
	 * Can't test full subscription process in automation (assumption?)
	 * @return
	 */
	public boolean isAppleSignInModalDisplayed() {
		boolean isAppleModalDisplayed = isVisible(existingAppleIDButtonOnAppleStoreSignInModal);
		System.out.println("appboyUpsellsPage.isAppleISignInModalDisplayed() : " + isAppleModalDisplayed);
		return isAppleModalDisplayed;	
	}
	
	public void clickCancelAppStoreModalButton(){
		if(waitForElementToBeVisible(cancelAppStoreModalButton, 5)) {
			cancelAppStoreModalButton.click();
			System.out.println("appboyUpsellsPage.clickAppleSignInModalCancelButton(): done");
		}
	}

	/**
	 * sk - 1/15 - modified on 2/24 due to changeover to Appboy Upsell
	 * @return status if clicking on Subscribe to Plus button opens Apple store modal
	 */
	public boolean isPlusButtonActive(){
		if(isVisible(subscribeToPlusButton)) {
			subscribeToPlusButton.click();
			if (!waitForElementToBeVisible(existingAppleIDButtonOnAppleStoreSignInModal, 10)) {
				System.out.println("appboyUpsellsPage.isPlusButtonActive(): Clicking 'Subscribe to Plus' button did not connect to app store.");
			}
			else {
				clickCancelAppStoreModalButton();
				return true;
			}
		}
		if(isVisible(start30DayFreeTrialPlusUserButton)) {
			System.out.println("Start Trial for 30 days Plus button is displayed.");
			start30DayFreeTrialPlusUserButton.click();
			if (!waitForElementToBeVisible(existingAppleIDButtonOnAppleStoreSignInModal, 10)) {
				System.out.println("appboyUpsellsPage.isPlusButtonActive(): Clicking 'Start 30 Day FreeTrial Plus' button did not connect to app store.");
			}
			else {
				System.out.println("appboyUpsellsPage.isPlusButtonActive(): 'Start Trial for 30 days Plus button' connected to the app store.");
				clickCancelAppStoreModalButton();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * sk - 1/15 - modified on 2/24 due to changeover to Appboy Upsell
	 * @return status if Subscribe to AA button opens Apple modal
	 */
	public boolean isPremiumButtonActive() {
		if(isVisible(subscribeToAllAccessButton)) {
			subscribeToAllAccessButton.click();
			if (!waitForElementToBeVisible(existingAppleIDButtonOnAppleStoreSignInModal, 10)) {
				System.out.println("appboyUpsellsPage.isPremiumButtonActive(): Subscribe to All Access button did not connect to the app store.");
			}
			else {
				System.out.println("appboyUpsellsPage.isPremiumButtonActive(): Subscribe to All Access button connected to the app store.");
				clickCancelAppStoreModalButton();
				return true;
			}
		}
		if (start30DayFreeTrialAllAccessUserButton.isDisplayed()) {
			start30DayFreeTrialAllAccessUserButton.click();
			System.out.println("appboyUpsellsPage.isPremiumButtonActive(): AAButton clicked.");
			if (!waitForElementToBeVisible(existingAppleIDButtonOnAppleStoreSignInModal, 10)) {
				System.out.println("appboyUpsellsPage.isPremiumButtonActive(): Start Trial for 30 days All Access button did not connect to the app store.");
			}	
			else {
				System.out.println("appboyUpsellsPage.isPremiumButtonActive(): Start Trial for 30 days All Access button connected to the app store.");
				clickCancelAppStoreModalButton();
				return true;
			}
		}
		return false;
	}	

	/** sk - 2/24 - method to verify upsells headline, buttons activated and text on buttons
	 * naming convention for the upsell that that is coming in - Page_Element_NameOfOverflowOption - if its an overflow element
	 * else it will be Page_Element. This will make it easy to call this method from any pages
	 * The expected upsell headlines above have also been named with the same convention
	 */
	public Errors verifyUpsellHeadlineIsAsExpected(String expectedHeadline) {
		Errors err = new Errors();
		String actualUpsellHeadline = "";
		if (isUpsellDisplayed()) {
			actualUpsellHeadline = getUpsellText();
			if (!actualUpsellHeadline.equals(expectedHeadline)) {
				System.out.println("appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(): Upsell headlines was not as expected.");
				err.add("Actual upsell headline is: " + actualUpsellHeadline + " Expected is: " + expectedHeadline);
			}
		}
		else {
			err.add("Upsell is not displayed.");
		}				
		System.out.println("appboyUpsellsPage.verifyUpsellHeadlineIsAsExpected(): Upsell headline verified - Actual Upsell headline is: " + actualUpsellHeadline + " Expected is: " + expectedHeadline);
		return err;
	}


	/**
	 * sk - 2/27 - verify Buttons are in the correct state (active/inactive) based on if user is free or plus.
	 * Eg. For plus user, Subscribe to Plus button should be inactive, while Subscribe to AA button should be active
	 * Active state is verified by the fact that the appstore modal shows when the button is tapped.
	 * @return Errors object
	 */
	public Errors verifyUpsellPlusButtonState_PlusUser() {
		Errors err = new Errors();
		System.out.println("appboyUpsellsPage.verifyUpsellPlusButtonState_PlusUser()");
		if (isUpsellDisplayed()) {
			if (isPlusButtonActive()) {
				err.add("Plus user: Subscribe to Plus button shouldn't be active for a plus user and shouldn't connect to App Store - failed");
			}
			else {
				System.out.println("appboyUpsellPage.verifyUpsellPlusButtonStatePlusUser(): Plus user : Clicked on 'Subscribe to Plus' Button, "
						+ "and did not connect to App Store.");
			}
		}
		return err;
	}

	public Errors verifyUpsellAAButtonState_PlusUser() {
		Errors err = new Errors();
		System.out.println("appboyUpsellsPage.verifyUpsellAAButtonState_PlusUser()");
		if (isUpsellDisplayed()) {
			if (!isPremiumButtonActive()) {
				err.add("Plus user : 'Subscribe to All Access' button was not active for a plus user and could not connect to App Store.");	
			}
			else {
				System.out.println("Plus user : Subscribe to All Access Button was active, and connected to App Store.");
			}
		}
		return err;
	}
	
	public Errors verifyUpsellPlusButtonState_FreeTrialExpiredUser() {
		Errors err = new Errors();
		System.out.println("appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialExpiredUser()");
		if (isUpsellDisplayed()) {
			if (!isPlusButtonActive()) {
				err.add("Free non trial eligibile user: 'Subscribe to Plus' button was not active for a Free non trial eligible user and could not connect to App Store.");
			}
			else {
				System.out.println("Free non trial eligibile user : 'Subscribe to Plus' button was active, and connected to App Store.");
			}
		}
		return err;

	}
	
	public Errors verifyUpsellAAButtonState_FreeTrialExpiredUser() {
		Errors err = new Errors();
		System.out.println("appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialExpiredUser()");
		if (isUpsellDisplayed()) {
			if (!isPremiumButtonActive()) {
				err.add("Free non trial eligibile user:  Subscribe to All Access button was not active for a Free non trial eligible user and could not connect to App Store.");
			}
			else {
				System.out.println("Free non trial eligibile user : Subscribe to All Access Button was active, and connected to App Store.");
			}
		}
		return err;
	}
	
	public Errors verifyUpsellPlusButtonState_FreeTrialEligibleUser() {
		Errors err = new Errors();
		System.out.println("appboyUpsellsPage.verifyUpsellPlusButtonState_FreeTrialEligibleUser()");
		if (isUpsellDisplayed()) {
			if (!isPlusButtonActive()) {
				err.add("Free trial eligibile user: 'Start 30 day Free Trial' Plus Button was not active and couldn't connect to App Store.");
			} 
			else {
				System.out.println("Free trial eligibile user: Start 30 day Free Trial Plus Button was active, and connected to App Store.");
			}
		}
		return err;	
	}

	public Errors verifyUpsellAAButtonState_FreeTrialEligibleUser() {
		Errors err = new Errors();
		System.out.println("appboyUpsellsPage.verifyUpsellAAButtonState_FreeTrialEligibleUser()");
		if (isUpsellDisplayed()) {
			if (!isPremiumButtonActive()) {
				err.add("Free trial eligibile user: 'Start 30 day Free Trial' All Access Button was not active and could not connect to App Store.");
			}
		}
		else
			err.add("Upsell is not displayed.");
		return err;
	}	
}	
