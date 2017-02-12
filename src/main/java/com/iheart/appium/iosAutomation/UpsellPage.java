package com.iheart.appium.iosAutomation;

import org.junit.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * @author skutty
 *
 */
public class UpsellPage extends Page{
	
	public UpsellPage() {
		super();
	}

	public UpsellPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	@iOSFindBy(accessibility="IHRPlusUpsellView-TitleLabel-UILabel") 
	private IOSElement IHRPlusUpsellViewTitleLabelUILabel;
	@iOSFindBy(accessibility="IHRPlusUpsellView-BulletsView-UIView") 
	private IOSElement IHRPlusUpsellViewBulletsViewUIView;
	@iOSFindBy(accessibility="IHRPlusUpsellView-UpsellButton-UIButton")
	private IOSElement IHRPlusUpsellViewUpsellButtonUIButton;
	@iOSFindBy(accessibility="IHRPlusUpsellView-LearnMoreButton-UIButton")
	private IOSElement IHRPlusUpsellViewLearnMoreButtonUIButton;
	
/**	sk - 2/8 - upsells have changed to Appboy upsells so the below ids are not appearing in the app any longer
	@iOSFindBy(accessibility="IHRPremiumUpsellView-SubscribeButton-UIButton")		private IOSElement IHRPremiumUpsellViewSubscribeButtonUIButton;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-NapsterLogoView-UIImageView")	private IOSElement IHRPremiumUpsellViewNapsterLogoViewUIImageView;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-FeatureTableView-UIView")		private IOSElement IHRPremiumUpsellViewFeatureTableViewUIView;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-SubscribePlusLabel-UILabel")		private IOSElement IHRPremiumUpsellViewSubscribePlusLabelUILabel;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-SubscribePremiumLabel-UILabel")	private IOSElement IHRPremiumUpsellViewSubscribePremiumLabelUILabel;
	@iOSFindBy(accessibility="IHRUpsellBulletsView-Label-UILabel")					private IOSElement IHRUpsellBulletsViewLabelUILabel;
	@iOSFindBy(accessibility="IHRUpsellBulletsView-CircleView-UIView")				private IOSElement IHRUpsellBulletsViewCircleViewUIView;
	@iOSFindBy(accessibility="IHRUpsellView-ContainerView-UIView")					private IOSElement IHRUpsellViewContainerViewUIView;
	@iOSFindBy(accessibility="IHRUpsellView-ScrollView-UIScrollView")				private IOSElement IHRUpsellViewScrollViewUIScrollView;
	@iOSFindBy(accessibility="IHRUpsellView-ScrollContentView-UIView")				private IOSElement IHRUpsellViewScrollContentViewUIView;
	@iOSFindBy(accessibility="IHRUpsellView-HeaderView-UIImageView")				private IOSElement IHRUpsellViewHeaderViewUIImageView;
	@iOSFindBy(accessibility="IHRUpsellView-BannerImageView-UIImageView")			private IOSElement IHRUpsellViewBannerImageViewUIImageView;
	@iOSFindBy(accessibility="IHRUpsellView-MessageLabel-UILabel")					private IOSElement IHRUpsellViewMessageLabelUILabel
*/	//@iOSFindBy(accessibility="IHRUpsellView-CancelButton-UIButton")				private IOSElement IHRUpsellViewCancelButtonUIButton;
	@iOSFindBy(accessibility="Cancel") 												private IOSElement IHRUpsellViewCancelButtonUIButton;
	@iOSFindBy(accessibility="IHRUpsellView-ContentView-UIView")					private IOSElement IHRUpsellViewContentViewUIView;
	@iOSFindBy(accessibility="Subscribe To Plus") private IOSElement IHRPremiumUpsellViewSubscribePlusButtonUIButton;
	@iOSFindBy(accessibility="Subscribe To All Access") private IOSElement IHRPremiumUpsellViewSubscribePremiumButtonUIButton;

	//Upsell Modal
	//@iOSFindBy(accessibility = "Start Free 30 Day Trial")
	//private IOSElement startFree30DayTrialButton;
	@iOSFindBy(accessibility="Got it") private IOSElement gotItButton;
	@iOSFindBy(accessibility="Use Existing Apple ID") private IOSElement useExistingAppleIDButton;
		
	//sk - 1/15 - Text on upsells based on where the upsell is trigerred from
	@iOSFindBy(id="Save any album you want. Try iHeartRadio All Access.") private IOSElement albumUpsellText;
	@iOSFindBy(id="Save any song you want. Try iHeartRadio All Access.") private IOSElement songUpsellText;
	@iOSFindBy(id="Create unlimited playlists. Try iHeartRadio All Access.") private IOSElement addToPlaylistUpsellText;
	@iOSFindBy(id="Encore! Instantly replay songs on the radio with iHeartRadio Plus.") private IOSElement replaySongsUpsellText;

	/**
	 * @return
	 */
	public boolean clickCancelButton(){
		waitForElementToBeVisible(IHRUpsellViewCancelButtonUIButton, 5);
		IHRUpsellViewCancelButtonUIButton.click();
		System.out.println("ClickCancelButton()");
		return true;
	}
	/**
	 * Clicks the Subscribe to All Access Button - the 30 Day Free Trial (the right one) 
	 * on the Upsell Modal
	 * @return boolean if it was able to be clicked.
	 */
	public boolean clickSubscribeAllAccessButton(){
		if(IHRPremiumUpsellViewSubscribePremiumButtonUIButton!=null){
			IHRPremiumUpsellViewSubscribePremiumButtonUIButton.click();
			System.out.println("clickSubscribeAllAccessButton().");
			return true;
		}return false;
	}
	
	/**
	 * Clicks the Subscribe to Plus Button - the 30 Day Free Trial (the left one) 
	 * on the Upsell Modal
	 * @return boolean if it was able to be clicked.
	 */
	public boolean clickSubscribePlusButton(){
		if(IHRPremiumUpsellViewSubscribePlusButtonUIButton!=null){
			IHRPremiumUpsellViewSubscribePlusButtonUIButton.click();
			System.out.println("clickSubscribePlusButton().");
			return true;
		}return false;
	}
	/**
	 * Checks whether the Table View, a central part of the Upsell Modal, is not null and isDisplayed. 
	 * SK - 2/9 - changing as all upsells have been replaced by Appboy Upsells and IDs no longer exist
	 * @return boolean
	 */
	/*public boolean isUpsellModalOpen(){
		//if(IHRPremiumUpsellViewFeatureTableViewUIView!= null){
		if(IHRPremiumUpsellViewSubscribePremiumButtonUIButton!= null){
		boolean upsellOpen = IHRPremiumUpsellViewFeatureTableViewUIView.isDisplayed();
		if(IHRPremiumUpsellViewFeatureTableViewUIView.isDisplayed();
			System.out.println("isUpsellModalOpen() : " + upsellOpen);
			return upsellOpen;
		}else return false;
	}*/
	
	public boolean isUpsellModalOpen(){
		if(IHRPremiumUpsellViewSubscribePremiumButtonUIButton!= null){
			boolean upsellOpen = IHRPremiumUpsellViewSubscribePremiumButtonUIButton.isDisplayed();
		return upsellOpen;
	}
		else return false;
}
	/**
	 * Checks whether the Table View, a central part of the Upsell Modal, is not null and isDisplayed. 
	 * @return boolean
	 */
/*	public boolean isCurrentlyOnUpsellModal(){
		return (isCurrentlyOn("isCurrentlyOnUpsellModal", IHRPremiumUpsellViewFeatureTableViewUIView));
	}
	/**
	 * The top right of the Upsell Modal has an X to close it. You may need to close other Apple modals first before clicking this.
	 * 
	 * @return boolean
	 */
	public boolean clickXtoCloseUpsellModal(){
		
		if(IHRUpsellViewCancelButtonUIButton != null){
			IHRUpsellViewCancelButtonUIButton.click();
			//System.out.println("clickXtoCloseUpsellModal(). Upsell Modal should be gone.");
			return true;
		}
		System.out.println("clickXtoCloseUpsellModal() : Returned False. Couldn't find Cancel Button.");
		return false;
	}

	/**
	 * When Subscribing to AA or Plus for a Free User, it will ask you to sign into an Apple ID in order to complete the transaction.
	 * We will check whether this modal is displayed before canceling and leaving the Upsell Modal. 
	 * 
	 * Can't test full subscription process in automation (assumption?)
	 * @return
	 */
	public boolean isAppleIDSignInModalDisplayed() {
		if(useExistingAppleIDButton!=null){
			System.out.println("isAppleIDSignInModalDisplayed() : true.  ");
			return true;
		}
		return false;
	}

	/**
	 * Clicks the 'Got it' button on the bottom of the Upsell to AA Modal, which fails because original account was made on Web and was upgraded to PLUS on Web. 
	 * Therefore,it must be upgraded to AA on Web. 
	 * @return boolean, and stays on upsellModal
	 */
	public boolean clickGotItWebUpsellDisplayed() {
		if(waitForElementToBeVisible(gotItButton, 5)){
			gotItButton.click();
			System.out.println("clickGotItWebUpsellDisplayed() - Expected account was made on Web and upsell would prevent further access to upgrade to AA");
			return true;
		}
		return false;
	}
	
	/**
	 * sk - 1/15
	 * @return the addToPlaylistUpsellText
	 */
	public IOSElement getAddToPlaylistUpsellText() {
		return addToPlaylistUpsellText;
	}
	
	/**
	 * sk - 1/15
	 * @return the songUpsellText
	 */	
	public IOSElement getSongUpsellText() {
		return songUpsellText;
	}
	
	/**
	 * sk - 1/15
	 * @return the albumUpsellText
	 */	
	public IOSElement getAlbumUpsellText() {
		return albumUpsellText;
	}
	
	/**
	 * sk - 1/15
	 * @return status if both Subscribe to Plus and Premium buttons are enabled
	 */
	public boolean isPlusAndAAButtonsActive(){
		return (isEnabled(IHRPremiumUpsellViewSubscribePlusButtonUIButton) && isEnabled(IHRPremiumUpsellViewSubscribePremiumButtonUIButton));
	}
	
	/**
	 * sk - 1/15
	 * @return status if Subscribe to Plus button is enabled
	 */
	public boolean isPlusButtonActive(){
		return (isEnabled(IHRPremiumUpsellViewSubscribePlusButtonUIButton));
	}
	
	/**
	 * sk - 1/15
	 * @return status ifSubscribe to AA button is enabled
	 */
	public boolean isPremiumButtonActive() {
		return (isEnabled(IHRPremiumUpsellViewSubscribePremiumButtonUIButton));
	}
	
	/**
	 * sk - 2/10
	 * @return the replaySongUpsellText
	 */	
	public IOSElement getReplaySongUpsellText() {
		return replaySongsUpsellText;
	}
	
	public void assertPlaylistUpsell(String type,String text) {
		if (type == "Free") {
			Assert.assertEquals("Album Upsell should display", "Create unlimited playlists. Try iHeartRadio All Access.", text );	
			//assert plus and premium subscribe buttons are activated
			Assert.assertTrue("Upsell page at 'Album overflow - Add to Playlist' for free user should not have Plus subs button deactivated", upsellPage.isPlusButtonActive());					
			Assert.assertTrue("Upsell page at 'Album overflow - Add to Playlist' for free user should not have Premium subs button deactivated", upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile page - Add to Playlist upsell text verified; plus and premium subs buttons are activated for free user.");				
			
		}
		else if (type == "Plus") {
			Assert.assertEquals("Album Upsell should display", "Create unlimited playlists. Try iHeartRadio All Access.", text );
			//To do - assert plus and premium buttons are activated
			Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for plus user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for plus user should not have Premium subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile Page - Add to Playlist upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");
		}
	}
	
	//sk - 11/21
	public void assertTrackUpsell(String type, String text) {
		if (type == "Free") {
			Assert.assertEquals("Song Upsell should display", "Save any song you want. Try iHeartRadio All Access.",text);
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for free user should not have Premium subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			System.out.println("Album Profile Page - Save Song Upsell text verified; plus and premium subs buttons are activated for free user.");		
		}
		else if (type == "Plus") {
			Assert.assertEquals("Song Upsell should display", "Save any song you want. Try iHeartRadio All Access.",text);
			Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for plus user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for plus user should not have Premium subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			System.out.println("Album Profile Page - Save Song upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");			
		}
	}
	
	public void assertAlbumUpsell(String type,String text) {
		if (type == "Free") {
			Assert.assertEquals("Album Upsell should display", "Save any album you want. Try iHeartRadio All Access.", text );
			Assert.assertTrue("Upsell page at 'Album overflow - Save Album' for free user should not have Plus subs button deactivated", 
				upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Album' for free user should not have Premium subs button deactivated", 
				upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile Page - Album upsell text verified; plus and premium subs buttons are activated for free user.");
		}
		else if (type == "Plus") {
			Assert.assertEquals("Album Upsell should display", "Save any album you want. Try iHeartRadio All Access.", text);
			Assert.assertFalse("Upsell page at 'Album overflow - Save Song' for plus user should not have Plus subs button deactivated", 
					upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Song' for plus user should not have Premiu subs button deactivated", 
					upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile Page - Album upsell text verified; plus subs button is not enabled and premium subs button is enabled for plus user");
		}		
	}
	
	public void replaySongUpsell(String type,String text) {
		if (type == "Free") {
			Assert.assertEquals("Replay Upsell should display", "Encore! Instantly replay songs on the radio with iHeartRadio Plus.", text );
			Assert.assertTrue("Upsell page at 'Player - Replay' for free user should not have Plus subs button deactivated", 
				upsellPage.isPlusButtonActive());	
			Assert.assertTrue("Upsell page at 'Album overflow - Save Album' for free user should not have Premium subs button deactivated", 
				upsellPage.isPremiumButtonActive());
			System.out.println("Artist Profile Page - Album upsell text verified; plus and premium subs buttons are activated for free user.");
		}		
	}
}
