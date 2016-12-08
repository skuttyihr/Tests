package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

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
	
	@iOSFindBy(accessibility="IHRPremiumUpsellView-SubscribeButton-UIButton")		private IOSElement IHRPremiumUpsellViewSubscribeButtonUIButton;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-NapsterLogoView-UIImageView")	private IOSElement IHRPremiumUpsellViewNapsterLogoViewUIImageView;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-FeatureTableView-UIView")		private IOSElement IHRPremiumUpsellViewFeatureTableViewUIView;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-SubscribePlusButton-UIButton")	private IOSElement IHRPremiumUpsellViewSubscribePlusButtonUIButton;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-SubscribePremiumButton-UIButton")private IOSElement IHRPremiumUpsellViewSubscribePremiumButtonUIButton;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-SubscribePlusLabel-UILabel")		private IOSElement IHRPremiumUpsellViewSubscribePlusLabelUILabel;
	@iOSFindBy(accessibility="IHRPremiumUpsellView-SubscribePremiumLabel-UILabel")	private IOSElement IHRPremiumUpsellViewSubscribePremiumLabelUILabel;
	
	@iOSFindBy(accessibility="IHRUpsellBulletsView-Label-UILabel")					private IOSElement IHRUpsellBulletsViewLabelUILabel;
	@iOSFindBy(accessibility="IHRUpsellBulletsView-CircleView-UIView")				private IOSElement IHRUpsellBulletsViewCircleViewUIView;
	@iOSFindBy(accessibility="IHRUpsellView-ContainerView-UIView")					private IOSElement IHRUpsellViewContainerViewUIView;
	@iOSFindBy(accessibility="IHRUpsellView-ScrollView-UIScrollView")				private IOSElement IHRUpsellViewScrollViewUIScrollView;
	@iOSFindBy(accessibility="IHRUpsellView-ScrollContentView-UIView")				private IOSElement IHRUpsellViewScrollContentViewUIView;
	@iOSFindBy(accessibility="IHRUpsellView-HeaderView-UIImageView")				private IOSElement IHRUpsellViewHeaderViewUIImageView;
	@iOSFindBy(accessibility="IHRUpsellView-BannerImageView-UIImageView")			private IOSElement IHRUpsellViewBannerImageViewUIImageView;
	@iOSFindBy(accessibility="IHRUpsellView-MessageLabel-UILabel")					private IOSElement IHRUpsellViewMessageLabelUILabel;
	@iOSFindBy(accessibility="IHRUpsellView-CancelButton-UIButton")					private IOSElement IHRUpsellViewCancelButtonUIButton;
	@iOSFindBy(accessibility="IHRUpsellView-ContentView-UIView")					private IOSElement IHRUpsellViewContentViewUIView;
	//Upsell Modal
	@iOSFindBy(accessibility = "Start Free 30 Day Trial")
	private IOSElement startFree30DayTrialButton;
	
	@iOSFindBy(accessibility="Cancel") private IOSElement cancelButton;
	@iOSFindBy(accessibility="Got it") private IOSElement gotItButton;
	@iOSFindBy(accessibility="Use Existing Apple ID") private IOSElement useExistingAppleIDButton;
	
	
	public boolean clickCancelButton(){
		waitForElementToBeVisible(cancelButton, 5);
		cancelButton.click();
		System.out.println("ClickCancelButton()");
		return true;
	}
	public boolean clickSubscribeAllAccessButton(){
		if(IHRPremiumUpsellViewSubscribePremiumButtonUIButton!=null){
			IHRPremiumUpsellViewSubscribePremiumButtonUIButton.click();
			System.out.println("clickSubscribeAllAccessButton().");
			return true;
		}return false;
	}
	
	
	public boolean clickSubscribePlusButton(){
		if(IHRPremiumUpsellViewSubscribePlusButtonUIButton!=null){
			IHRPremiumUpsellViewSubscribePlusButtonUIButton.click();
			System.out.println("clickSubscribePlusButton().");
			return true;
		}return false;
	}
	public boolean isUpsellModalOpen(){
		if(IHRPremiumUpsellViewFeatureTableViewUIView!= null){
			boolean upsellOpen = IHRPremiumUpsellViewFeatureTableViewUIView.isDisplayed();
			System.out.println("isUpsellModalOpen() : " + upsellOpen);
			return upsellOpen;
		}else return false;
	}
	public boolean clickXtoCloseUpsellModal(){
		if(IHRUpsellViewCancelButtonUIButton != null){
			IHRUpsellViewCancelButtonUIButton.click();
			System.out.println("clickXtoCloseUpsellModal(). Upsell Modal should be gone.");
			return true;
		}
		System.out.println("clickXtoCloseUpsellModal() : Returned False. Couldn't find Cancel Button.");
		return false;
	}

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
}
