package com.iheart.appium.iosAutomation;

import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SearchPage extends Page{

	public SearchPage(){
		super();
	}
	public SearchPage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-CancelButton-UIButton") private IOSElement IHRGlobalSearchBarCancelButtonUIButton;
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-SearchBar-UISearchBar") private IOSElement IHRGlobalSearchBarSearchBarUISearchBar;
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-SearchBarTextField-UITextField") private IOSElement IHRGlobalSearchBarSearchBarTextFieldUITextField;
	@iOSFindBy(accessibility = "IHRGlobalSearchInstructionsView-IconView-UIImageView") private IOSElement IHRGlobalSearchInstructionsViewIconViewUIImageView;
	@iOSFindBy(accessibility = "IHRGlobalSearchInstructionsView-Spacer1-UIView") private IOSElement IHRGlobalSearchInstructionsViewSpacer1UIView;
	@iOSFindBy(accessibility = "IHRGlobalSearchInstructionsView-Spacer2-UIView") private IOSElement IHRGlobalSearchInstructionsViewSpacer2UIView;
	@iOSFindBy(accessibility = "IHRGlobalSearchInstructionsView-InstructionsLabel-UILabel") private IOSElement IHRGlobalSearchInstructionsViewInstructionsLabelUILabel;
	//These are added but may not be able to be found. 
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-SearchBarClearImage-UIImage") private IOSElement IHRGlobalSearchBarSearchBarClearImageUIImage;
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-Subview-UIView") private IOSElement  IHRGlobalSearchBarSubviewUIView;
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-SecondLevelSubview-UIView") private IOSElement IHRGlobalSearchBarSecondLevelSubviewUIView;
	
	/**
	 * Click Cancel to get out of Search and back to other page.
	 */
	public void clickCancelButtonOnSearchBar(){
		System.out.println("clickCancelButtonOnSearchBar().");
		IHRGlobalSearchBarCancelButtonUIButton.click();
	}
	/**
	 * Not sure if this is useful. 
	 */
	public void clickSearchButtonOnSearchBar(){
		System.out.println("clickSearchButtonOnSearchBar().");
		IHRGlobalSearchBarSearchBarUISearchBar.click();
	}

	/**
	 * Enters text into the Search Bar TextField. ClearsTextField first. No real need to hit enter as Search populates results as you type. 
	 * @param searchQuery
	 */
	public void enterTextIntoSearchBar(String searchQuery){
		clearSearchBarTextField();
		System.out.println("enterTextIntoSearchBar() : "+ searchQuery);
		IHRGlobalSearchBarSearchBarTextFieldUITextField.sendKeys(searchQuery);
	}
	/**
	 * Clears the SearchBar TextField
	 */
	public void clearSearchBarTextField(){
		System.out.println("clearSearchBarTextField().");
		IHRGlobalSearchBarSearchBarTextFieldUITextField.clear();
	}
	/**
	 * Checks if the Cancel Button is Displayed. Catches a NoSuchElementException if the element isn't available.
	 * @return
	 */
	public boolean isCurrentlyOnSearchPage(){
		try{
			boolean isCurr = IHRGlobalSearchBarCancelButtonUIButton.isDisplayed();
			System.out.println("isCurrentlyOnSearchPage() : "+ isCurr);
			return isCurr;
		}catch(NoSuchElementException e){
			System.out.println("isCurrentlyOnSearchPage() : false - Caught NoSuchElementException");
			return false;
		}
	}
	
	
	public void showAllElements(){
		printElementInformation(IHRGlobalSearchBarCancelButtonUIButton);
		printElementInformation(IHRGlobalSearchBarSearchBarUISearchBar);
		printElementInformation(IHRGlobalSearchBarSearchBarTextFieldUITextField);
		printElementInformation(IHRGlobalSearchInstructionsViewIconViewUIImageView);
		printElementInformation(IHRGlobalSearchInstructionsViewSpacer1UIView);
		printElementInformation(IHRGlobalSearchInstructionsViewSpacer2UIView);
		printElementInformation(IHRGlobalSearchInstructionsViewInstructionsLabelUILabel);
	}



}
