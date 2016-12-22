package com.iheart.appium.iosAutomation;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;


public class OnboardingPage extends Page {

	public OnboardingPage(){
		super();
	}
	public OnboardingPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	// Accessibility Identifiers tied to Elements 
	@iOSFindBy(accessibility = "IHROnboardingView-ScrollView-UIScrollView") private IOSElement IHROnboardingViewScrollViewUIScrollView;
	@iOSFindBy(accessibility = "IHROnboardingView-LogoView-UIImageView") private IOSElement IHROnboardingViewLogoViewUIImageView;
	@iOSFindBy(accessibility = "IHROnboardingView-TitleLabel-UILabel") private IOSElement IHROnboardingViewTitleLabelUILabel;
	@iOSFindBy(accessibility = "IHROnboardingView-DescriptionLabel-UILabel") private IOSElement IHROnboardingViewDescriptionLabelUILabel;
	@iOSFindBy(accessibility = "IHROnboardingView-PageControl-UIPageControl") private IOSElement IHROnboardingViewPageControlUIPageControl;
	@iOSFindBy(accessibility = "IHROnboardingView-LogInButton-UIButton") private IOSElement IHROnboardingViewLogInButtonUIButton;
	@iOSFindBy(accessibility = "IHROnboardingView-SignUpButton-UIButton") private IOSElement IHROnboardingViewSignUpButtonUIButton;
	@iOSFindBy(accessibility = "IHROnboardingSlideView-LandscapeImageView-UIImageView") private IOSElement IHROnboardingSlideViewLandscapeImageViewUIImageView;
	@iOSFindBy(accessibility = "IHROnboardingSlideView-PortraitImageView-UIImageView") private IOSElement IHROnboardingSlideViewPortraitImageViewUIImageView;
	
	/**
	 * Gets the Title UILabel Text. This call will change as the page slides to each view. 
	 * @return
	 */
	public String getTitleLabelText(){
		return IHROnboardingViewTitleLabelUILabel.getAttribute("value");
	}
	
	/**
	 * Gets the Description UILabel Text. This call will change as the page slides to each view. 
	 * @return
	 */
	public String getDescriptionLabelText(){
		return IHROnboardingViewDescriptionLabelUILabel.getAttribute("value");
	}
	
	/**
	 * These may not be the exact same as shown since the page can change and the second Description could be the next page!!!
	 * @return
	 */
	public String getTitleAndDescriptionLabelText(){
		return "[" + IHROnboardingViewTitleLabelUILabel.getText() + ":" + IHROnboardingViewDescriptionLabelUILabel.getText() + "]";
	}
	
	/**
	 * Return a HashSet containing the three unique Title UILabels in the Onboarding pages. 
	 * This method can be modified by setting the failCounter limit higher, or including sleeps in the while loop, 
	 * but it works by anticipating changeover of the Pages and the slowness of .getText()
	 * @return
	 */
	public Set<String> getThreeTextFields(){
		int i = 0;
		int failCounter = 0;
		Set<String> returnSet = new HashSet<String>(3);
		while(i <= 3 && failCounter < 10){
			String entry = getTitleLabelText();
			if(!returnSet.contains(entry)){
				returnSet.add(entry);
				i++;
			}
			failCounter++;
			TestRoot.sleep(2000);
		}
		return returnSet;
	}
	/**
	 * Return a HashSet containing the three unique Description UILabels in the Onboarding pages. 
	 * This method can be modified by setting the failCounter limit higher, or including sleeps in the while loop, 
	 * but it works by anticipating changeover of the Pages and the slowness of .getText()
	 * @return
	 */
	public Set<String> getThreeDescriptionTextFields(){
		int i = 0;
		int failCounter = 0;
		Set<String> returnSet = new HashSet<String>();
		while(i <= 3 && failCounter < 10){
			String entry = getDescriptionLabelText();
			if(!returnSet.contains(entry)){
				returnSet.add(entry);
				i++;
			}
			failCounter++;
			TestRoot.sleep(1000);
		}
		return returnSet;
	}
	
	/**
	 * Returns true if currently on the onboardingPage
	 * No wait used. Expect the page to be open already. 
	 * @return
	 */
	public boolean isCurrentlyOnOnboardingPage(){
		return IHROnboardingViewScrollViewUIScrollView.isDisplayed();
	}

	/**
	 * waits for IHROnboardingViewScrollViewUIScrollView to be displayed for a max of 20 seconds. 
	 */
	public void waitForOnboardingPage(){
		waitForElementToBeVisible(IHROnboardingViewScrollViewUIScrollView, 20);
	}
	
	/**
	 * Checks that either the Portrait or the Landscape images are displayed.
	 * @return 
	 */
	public boolean isOnboardingBackgroundImagePresent(){
		return (IHROnboardingSlideViewPortraitImageViewUIImageView.isDisplayed() || IHROnboardingSlideViewLandscapeImageViewUIImageView.isDisplayed());
	}
	/**
	 * Checks if the Portrait image is Displayed. 
	 * @return
	 */
	public boolean isOnboardingPortraitImagePresent(){
		return IHROnboardingSlideViewPortraitImageViewUIImageView.isDisplayed();
	}
	/**
	 * Checks if the Landscape image is Displayed. 
	 * @return
	 */
	public boolean isOnboardingLandscapeImagePresent(){
		return IHROnboardingSlideViewLandscapeImageViewUIImageView.isDisplayed();
	}
	
	/*
	 * Returns true if currently on LoginPage
	 */
	public boolean clickOnboardingLoginButton(){
		IHROnboardingViewLogInButtonUIButton.click();
		return loginPage.currentlyOnLoginPage();
	}
	/**
	 * Returns true if currently on SignUpPage
	 * @return
	 */
	public boolean clickOnboardingCreateAccountButton(){
		IHROnboardingViewSignUpButtonUIButton.click();
		return signupPage.currentlyOnSignUpPage();
	}
	
	/**
	 * SwipePageRight is an action that will cause a fresh Background Image, Title, and Description to appear, and change the UIPageIndicator.
	 */
	public void swipePageRight(){
		pageSwipe(RIGHT);
	}
	/**
	 * SwipePageLeft is an action that will cause a fresh Background Image, Title, and Description to appear, and change the UIPageIndicator.
	 */
	public void swipePageLeft(){
		pageSwipe(LEFT);
	}
	
	/**
	 * There is a UIPageControlIndicator on the Onboarding page with 3 pages with it. 
	 * @return
	 */
	public int getPageControlIndicator(){
		String text = IHROnboardingViewPageControlUIPageControl.getText();
		if(text.contains("1")){
			return 1;
		}
		else if(text.contains("2")){
			return 2;
		}
		else return 3;
	}
	/**
	 * This method prints all of the IOSElements at the top of the page. If any get added, they should be added here as well. 
	 * The method returns a true if all the elements return true for .isDisplayed() 
	 * @return
	 */
	public boolean showAllElements(){
		waitForOnboardingPage();
		printElementInformation(IHROnboardingViewScrollViewUIScrollView);
		printElementInformation(IHROnboardingViewLogoViewUIImageView);
		printElementInformation(IHROnboardingViewTitleLabelUILabel);
		printElementInformation(IHROnboardingViewDescriptionLabelUILabel);
		printElementInformation(IHROnboardingViewPageControlUIPageControl);
		printElementInformation(IHROnboardingViewLogInButtonUIButton);
		printElementInformation(IHROnboardingViewSignUpButtonUIButton);
		printElementInformation(IHROnboardingSlideViewLandscapeImageViewUIImageView);
		printElementInformation(IHROnboardingSlideViewPortraitImageViewUIImageView);
		if(isOnboardingPortraitImagePresent()){
			System.out.println("Portrait Image isDisplayed()");
		}else if(isOnboardingLandscapeImagePresent()){
			System.out.println("Landscape Image isDisplayed()");
		}
		System.out.println("Trying to get all 3 unique PageControlIndicators and their text....Cycling 10 times");
		//music to your ears thousands of live radio
		//radio and unlimited - unlimited skips. 
		//join the party - 
		for(int i = 0; i < 10 ; i++){
			System.out.println("PageControl: " + getPageControlIndicator() + " Text:"+ getTitleAndDescriptionLabelText());
		}
		//Check that all elements are displayed
		return (IHROnboardingViewScrollViewUIScrollView.isDisplayed() && IHROnboardingViewLogoViewUIImageView.isDisplayed() &&
				IHROnboardingViewTitleLabelUILabel.isDisplayed() && IHROnboardingViewDescriptionLabelUILabel.isDisplayed() &&
				IHROnboardingViewPageControlUIPageControl.isDisplayed() && IHROnboardingViewLogInButtonUIButton.isDisplayed() &&
				IHROnboardingViewSignUpButtonUIButton.isDisplayed() && isOnboardingBackgroundImagePresent());
	}

	
}
