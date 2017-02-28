/**
 * @author skutty - 2/24
 * Elements and methods for the new Appboy Upsells that have been integrated into the app
 * 
 */

package com.iheart.appium.iosAutomation;

import com.iheart.appium.utilities.Errors;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AppboyUpsellsPage extends Page{

	/**
	 * sk - 2/19 - Upsell modal elements
	 */
	@iOSFindBy(accessibility = "Cancel") 	private IOSElement closeUpsellButton;
	@iOSFindBy(accessibility = "IHRUpsellView-ContentView-UIView")	private IOSElement IHRUpsellViewContentViewUIView;
	@iOSFindBy(id = "Subscribe, to Plus") private IOSElement subscribeToPlusButton;
	@iOSFindBy(id = "Subscribe, to All Access") private IOSElement subscribeToAllAccessButton;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeImage")
	private IOSElement napsterLogo;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeImage")
	private IOSElement upsellPageFirstLine;
	@iOSFindBy(id = "Cancel") private IOSElement cancelAppStoreModalButton ;
    @iOSFindBy(id = "Use Existing Apple ID") private IOSElement appleStoreModalButtonAppleId;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[13]/XCUIElementTypeLink[1]/XCUIElementTypeLink[1]/XCUIElementTypeStaticText[1]")
    private IOSElement start30DayFreeTrialPlusUserButton;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/"
			+ "XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[13]/XCUIElementTypeLink[2]/XCUIElementTypeLink[1]/XCUIElementTypeStaticText[1]")
    private IOSElement start30DayFreeTrialAllAccessUserButton;
	@iOSFindBy(accessibility="NEW") private IOSElement newFeatureTag;
	@iOSFindBy(xpath="//XCUIElementTypeApplication/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/"
			+ "XCUIElementTypeStaticText") private IOSElement IHRUpsellViewMessageLabelUILabel;
	@iOSFindBy(accessibility="Got it") private IOSElement gotItButton;
	@iOSFindBy(accessibility="Use Existing Apple ID") private IOSElement existingAppleIDButtonOnAppleStoreSignInModal;
	
	public AppboyUpsellsPage() {
		super();
	}

	public AppboyUpsellsPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	/**
	 * sk - 2/24 - getting upsell text after appboy upsells kicked in
	 * @return
	 */
	public String getUpsellText() {
		if (waitForElementToBeVisible(IHRUpsellViewMessageLabelUILabel, 3)) {
			String upsellHeadline = IHRUpsellViewMessageLabelUILabel.getText();
			System.out.println("Getting displayed upsell text: " + upsellHeadline);
			return upsellHeadline;
		}
		return "";
	}
	
	public IOSElement getNewFeatureTag() {
		return newFeatureTag;
	}
	
	public boolean isUpsellDisplayed() {
		waitForElementToBeVisible(newFeatureTag, 8);
		System.out.println(isVisible(newFeatureTag));
		boolean isUpsellDisplayed = (isVisible(newFeatureTag));
		System.out.println("isUpsellDisplayed(): " + isUpsellDisplayed);
		return (isUpsellDisplayed);
	}
	
	public String plusButtonGetText() {
		if (waitForElementToBeVisible(subscribeToPlusButton, 2)) {
			System.out.println("Plus button subscription is visible.");
			return subscribeToPlusButton.getText();
		} else if (waitForElementToBeVisible(start30DayFreeTrialPlusUserButton,2)) {
			System.out.println("Free Trial button for plus subscription is visible.");
			return start30DayFreeTrialPlusUserButton.getText();
		}
		return "";
	}

	public String premiumButtonGetText() {
		if (waitForElementToBeVisible(subscribeToAllAccessButton, 2)) {
			System.out.println("All Access subscription button is visible.");
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
		if(existingAppleIDButtonOnAppleStoreSignInModal != null){
			System.out.println("isAppleISignInModalDisplayed() : " + existingAppleIDButtonOnAppleStoreSignInModal.isDisplayed());
			return true;
		}
		return false;
	}
	
	public void clickCancelAppStoreModalButton(){
		waitForElementToBeVisible(cancelAppStoreModalButton, 5);
		cancelAppStoreModalButton.click();
		System.out.println("clickAppleSignInModalCancelButton(): done");
	}

	/**
	 * sk - 1/15 - modified on 2/24 due to changeover to Appboy Upsell
	 * @return status if clicking on Subscribe to Plus button opens Apple store modal
	 */
	public boolean isPlusButtonActive(){
		if(isVisible(subscribeToPlusButton)) {
			System.out.println("Subcribe to Plus button is displayed.");
			subscribeToPlusButton.click();
			if (!waitForElementToBeVisible(existingAppleIDButtonOnAppleStoreSignInModal, 10)) {
				System.out.println("Subcribe to Plus button did not connect to the app store.");
				return false;
			}
			clickCancelAppStoreModalButton();
		}
		else if(isVisible(start30DayFreeTrialPlusUserButton)) {
			System.out.println("Start Trial for 30 days Plus button is displayed.");
			start30DayFreeTrialPlusUserButton.click();
			if (!waitForElementToBeVisible(existingAppleIDButtonOnAppleStoreSignInModal, 10)) {
				System.out.println("Start Trial for 30 days Plus button did not connect to the app store for plus user.");
				return false;
			}
			clickCancelAppStoreModalButton();
		}
		return true;
	}
	
	/**
	 * sk - 1/15 - modified on 2/24 due to changeover to Appboy Upsell
	 * @return status if Subscribe to AA button opens Apple modal
	 */
	public boolean isPremiumButtonActive() {
		if(isVisible(subscribeToAllAccessButton)) {
			subscribeToAllAccessButton.click();
			if (!waitForElementToBeVisible(existingAppleIDButtonOnAppleStoreSignInModal, 10)) {
				System.out.println("Subcribe to All Access button did not connect to the app store.");
				return false;
			}
			else if (isVisible(existingAppleIDButtonOnAppleStoreSignInModal)) {
				System.out.println("Subcribe to All Access button connected to the app store.");
				clickCancelAppStoreModalButton();
			}
		}
		if(isVisible(start30DayFreeTrialAllAccessUserButton)) {
			start30DayFreeTrialAllAccessUserButton.click();
			if (!waitForElementToBeVisible(existingAppleIDButtonOnAppleStoreSignInModal, 10)) {
				System.out.println("Start Trial for 30 days All Access button did not connect to the app store.");
				return false;
			}	
			else if (isVisible(existingAppleIDButtonOnAppleStoreSignInModal)) {
				System.out.println("Start Trial for 30 days All Access button connected to the app store.");
				clickCancelAppStoreModalButton();
			}
		}
		return true;
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
			if (!(actualUpsellHeadline.equals(expectedHeadline))) {
				System.out.println("Upsell headlines was not as expected.");
				err.add("Actual upsell headline is: " + actualUpsellHeadline + " Expected is: " + expectedHeadline);
				return err;
			}
		}
		else {
			err.add("Upsell is not displayed.");
			return err;
		}				
		System.out.println("Upsell headline verified - Actual Upsell headline is: " + actualUpsellHeadline + " Expected is: " + expectedHeadline);
		return err;
	}
		
	/**
	 * sk - 2/24 - verify Button Text should match that for Subcribe OR Free Trial
	 * @return status if Subscribe to AA button opens Apple modal
	 */
	public Errors verifySubscriptionButtonText(String subscriptionType, boolean trialEligible) {
		Errors err = new Errors();
		if (subscriptionType.equals("FREE") && (trialEligible == true)) {
			System.out.println("Checking Free TrialEligible user button text. Start trial button is displayed for plus user: " + start30DayFreeTrialPlusUserButton.isDisplayed() + ""
					+ " Start trial button AA is displayed: " + start30DayFreeTrialAllAccessUserButton.isDisplayed());
			if (!(start30DayFreeTrialPlusUserButton.isDisplayed()) || !(start30DayFreeTrialAllAccessUserButton.isDisplayed())) {
				err.add("Expected buttons: " + start30DayFreeTrialPlusUserButton.getText() + " and " + start30DayFreeTrialAllAccessUserButton
						.getText() + " are not displayed.");
				return err;
			} 
			System.out.println("Button state for trial eligible free user was verified and showed " +  start30DayFreeTrialPlusUserButton.getText() + " and " + start30DayFreeTrialAllAccessUserButton.getText() + ".");
		}
		if (subscriptionType.equals("FREE") && (trialEligible == false)) {
			if (!subscribeToPlusButton.isDisplayed() || !subscribeToAllAccessButton.isDisplayed()) {
				err.add("Expected buttons: " + subscribeToPlusButton.getText() + " and " + subscribeToAllAccessButton.getText() + " are not displayed.");
			return err;
			}
			System.out.println("Button state for trial expired free user was verified and showed " +  subscribeToPlusButton.getText() + " and " + subscribeToAllAccessButton.getText() + ".");
		}		
		if (subscriptionType.equals("PLUS") && (trialEligible == false)) {
			if (!subscribeToPlusButton.isDisplayed() || !subscribeToAllAccessButton.isDisplayed()) {
					err.add("Expected button:" + subscribeToPlusButton.getText() + " is not displayed.");
					return err;
			}
			System.out.println("Button state for plus user was verified and showed " +  subscribeToAllAccessButton.getText() + ".");
		}
		return err;
	}

	public Errors verifyUpsellButtonStates(String subscriptionType, boolean trialEligible, String actionToCallAfterClosingAppStoreModal) {
		Errors err = new Errors();
		if (isUpsellDisplayed()) {
			if (subscriptionType.equals("PLUS") && (trialEligible == false)) {
				System.out.println("Check 1");
				err.add(verifySubscriptionButtonText("PLUS", false));
				if (isPlusButtonActive()) {
					err.add("Plus user: Subscribe to Plus button shouldn't be active for a plus user and shouldn't connect to App Store - failed");
					return err;
				}
				else {
					System.out.println("Plus user : Clicked on Subscribe to Plus Button, and did no connect to App Store, as designed.");
				}
				System.out.println("Repeat upsell trigger action." + actionToCallAfterClosingAppStoreModal);
				repeatActionToTriggerUpsellOnPlayer(actionToCallAfterClosingAppStoreModal);
				if (!isPremiumButtonActive()) {
					err.add("Plus user : Subscribe to All Access button was not active for a plus user and could not connect to App Store.");	
					return err;
				}
				else {
					System.out.println("Plus user : Subscribe to All Access Button was active, and connected to App Store.");
				}
			}
			else if (subscriptionType.equals("FREE") && (trialEligible == false)) {
				err.add(verifySubscriptionButtonText(subscriptionType, trialEligible));
				if (!isPlusButtonActive()) {
					err.add("Free non trial eligibile user: Subscribe to Plus button was not active, could not connect to App Store - failed.");
					return err;
				}
				else {
					System.out.println("Free non trial eligibile user : Subscribe to Plus Button was active, and connected to App Store.");
				}
				System.out.println("Repeat upsell trigger action - " + actionToCallAfterClosingAppStoreModal);
				repeatActionToTriggerUpsellOnPlayer(actionToCallAfterClosingAppStoreModal);
				if (!isPremiumButtonActive()) {
					err.add("Free non trial eligibile user:  Subscribe to All Access button was not active for a Free non trial eligible user and could not connect to App Store.");
					return err;
				}
				else {
					System.out.println("Free non trial eligibile user : Subscribe to All Access Button was active, and connected to App Store.");
				}
			}		
			else if (subscriptionType.equals("FREE") && (trialEligible == true)) {
				err.add(verifySubscriptionButtonText(subscriptionType, trialEligible));
				if (!isPlusButtonActive()) {
					err.add("Free trial eligibile user: Start 30 day Free Trial Plus Button was not active and couldnt connect to App Store.");
					return err;
				} 
				else {
					System.out.println("Free trial eligibile user: Start 30 day Free Trial Plus Button was active, and connected to App Store.");
				}
				System.out.println("repeatActionToTriggerUpsellOnPlayer(() - Repeat upsell trigger action." + actionToCallAfterClosingAppStoreModal);
				repeatActionToTriggerUpsellOnPlayer(actionToCallAfterClosingAppStoreModal);
				if (!isPremiumButtonActive()) {
					err.add("Free trial eligibile user: Start 30 day Free Trial All Access Button was not active and could not connect to App Store.");
					return err;
				}
				else {
					System.out.println("Free trial eligibile user: Start 30 day Free Trial All Access Button was active, and connected to App Store.");
				}
			}
		else {
			err.add("Upsell is not seen."); 
			return err;
			}
		}
		return err;
	}
	
	/** sk - 2/28 - when verifying that upsell buttons for Plus and AA work, this method is used to repeat the action that trigerred the upsell
	 * to run the AllAccess button state test (Plus button verification closes it).
	 * 
	 * @param action   - says which action is being tested
	 */
	public void repeatActionToTriggerUpsellOnPlayer(String action) {
		if (action.equals("replay")) {
			fullPlayer.clickReplayButtonToOpenReplayModal();
			System.out.println("Repeated action: Replay button clicked.");
		}
		else if (action.equals("skip")) {
			fullPlayer.clickSkipButton();
			System.out.println("Repeated action: Skip button clicked.");
		}
		else if (action.equals("add to playlist")) {
			fullPlayer.clickSaveModalAddToPlaylist("FREE");
			System.out.println("Repeated action: Save clicked - then Add To Playlist clicked.");
		}		
	}
}
			