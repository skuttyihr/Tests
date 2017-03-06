package com.iheart.appium.iosAutomation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.iheart.appium.utilities.Errors;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class GenrePage extends Page {
	public GenrePage() {
		super();
	}

	public GenrePage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}

	// Elements
	
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-TitleLabel-UILabel") 				public IOSElement IHRGenrePickerViewControllerTitleLabelUILabel;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-SubtitleLabel-UILabel") 			public IOSElement IHRGenrePickerViewControllerSubtitleLabelUILabel;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-CancelButton-UIButton") 			public IOSElement IHRGenrePickerViewControllerCancelButtonUIButton;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-DoneButton-UIButton") 				public IOSElement IHRGenrePickerViewControllerDoneButtonUIButton;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-BottomBar-UIView") 				public IOSElement IHRGenrePickerViewControllerBottomBarUIView;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-GenreCollectionView-UICollectionView") public IOSElement IHRGenrePickerViewControllerGenreCollectionViewUICollectionView;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-0") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-1") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-2") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-3") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell3;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-4") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell4;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-5") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell5;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-6") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell6;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-7") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell7;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-8") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell8;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-9") 		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell9;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-10") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell10;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-11") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell11;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-12")		public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell12;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-13") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell13;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-14") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell14;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-15") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell15;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-16") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell16;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-17") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell17;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-18") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell18;
	@iOSFindBy(accessibility = "IHRGenrePickerViewController-Cell-UICollectionViewCell-19") 	public IOSElement IHRGenrePickerViewControllerCellUICollectionViewCell19;
	@iOSFindBy(accessibility = "IHRGenreCollectionViewCell-ContainerView-UIView") 				public IOSElement IHRGenreCollectionViewCellContainerViewUIView;
	@iOSFindBy(accessibility = "IHRGenreCollectionViewCell-TitleBackgroundView-UIView") 		public IOSElement IHRGenreCollectionViewCellTitleBackgroundViewUIView;
	
	public final String GENREPAGE_SUBTITLE = "We'll suggest stations just For You.";
	public final String GENREPAGE_TITLE = "Tell us all the genres you like.";
	/**
	 * Prints the elements in the Genre Picker Screen 
	 * Title, subtitle, cancel, done and done button, and the genre collection view. 
	 */
	public void printGenreElements(){
		System.out.println("printGenreElements()...");
		printElementInformation(IHRGenrePickerViewControllerTitleLabelUILabel);
		printElementInformation(IHRGenrePickerViewControllerSubtitleLabelUILabel);
		printElementInformation(IHRGenrePickerViewControllerCancelButtonUIButton);
		printElementInformation(IHRGenrePickerViewControllerDoneButtonUIButton);
		printElementInformation(IHRGenrePickerViewControllerBottomBarUIView);
		printElementInformation(IHRGenrePickerViewControllerGenreCollectionViewUICollectionView);
		printElementInformation(IHRGenrePickerViewControllerCellUICollectionViewCell0);
	}
	/**
	 * Clicks Several random genres, scrolls down, clicks Genre Cell 17, then clicks Done button and handles pop-ups
	 */
	public Errors selectGenresAndClickDone(){
		System.out.println("selectGenresAndClickDone()...");
		Errors happyNow = new Errors();
		clickSeveralRandomGenres();
		scrollGenreCollectionDown();
		scrollGenreCollectionDown();
		clickGenreCell(17);
		if(isDoneButtonEnabled()){
			clickDoneButton();
			Page.handlePossiblePopUp();
		}else{
			happyNow.add("Done Button was NOT enabled after clicking Genre cells and was not able to move to next step.","selectGenresAndClickDone");
		}
		return happyNow;
			
	}
	/**
	 * Gets the text out of the Title Label which should look like:
	 * 'Tell us all the genres you like.'
	 * @return
	 */
	public String getTitleLabelText(){
		String title = IHRGenrePickerViewControllerTitleLabelUILabel.getText();
		//System.out.println("getTitleLabelText() : " + title);
		return title;
	}
	/**
	 * Gets the text out of the Subtitle Label which should look like:
	 * 'We'll suggest stations just For You.'
	 * @return String of subtitleLabel
	 */
	public String getSubtitleLabelText(){
		String subtitle = IHRGenrePickerViewControllerSubtitleLabelUILabel.getText();
		//System.out.println("getSubtitleLabelText() : " + subtitle);
		return subtitle;
	}
	/**
	 * Clicks the Done button, but doesn't factor in whether the Done button is enabled. 
	 */
	public boolean clickDoneButton(){
		if(waitForElementToBeVisible(IHRGenrePickerViewControllerDoneButtonUIButton, 3)) {
			IHRGenrePickerViewControllerDoneButtonUIButton.click();
			System.out.println("clickDoneButton(): Clicked.");
			return true;
		}
		return false;
	}
	/**
	 * Checks whether the Done button is enabled, meaning that a Genre cell has been clicked and the user can move on.
	 * @return true if isEnabled()
	 */
	public boolean isDoneButtonEnabled(){
		boolean doneEnabled = false;
		if (waitForElementToBeVisible(IHRGenrePickerViewControllerDoneButtonUIButton, 5)) {
			doneEnabled = true;
			return doneEnabled;
		}
		return doneEnabled;		
	}
	/**
	 * Uses Random number generator to select between 1 and 6 genres on the first page.
	 */
	public void clickSeveralRandomGenres(){
		System.out.println("clickSeveralRandomGenres()");
		Random rand = new Random();
		//Create number of genres
		int numberOfGenres = ThreadLocalRandom.current().nextInt(1, 7); //Range between 1 and 6
		HashSet<Integer> intSet = new HashSet<Integer>(7);
		int first = rand.nextInt(10);
		for(int i = 0; i < numberOfGenres; i++){
			if(!intSet.contains(first)){
				intSet.add(first);
			}
			first = rand.nextInt(10);
		}
		Iterator<Integer> hashItr = intSet.iterator();
		while(hashItr.hasNext()){
			clickGenreCell((int) hashItr.next());
		}
	}
	/**
	 * Selects genres based on an int array, iterates through array, creates IOSElements and clicks on them. 
	 * @param gs
	 */
	public Errors selectGenres(int[] gs){
		Errors err = new Errors();
		for(int i : gs){
			String genre = "IHRGenrePickerViewController-Cell-UICollectionViewCell-" + i;
			System.out.println("creating an IOSElement for Genre and clicking it : "+ genre );
			if(waitForElementToBeVisible(findElement(driver, MobileBy.AccessibilityId(genre)), 5)){
				findElement(driver, MobileBy.AccessibilityId(genre)).click();
			}else{
				err.add("The Genre cell wasn't visible and thus couldn't be clicked.", "clickGenreCell");
			}
		}
		return err;
	}
	/**
	 * Checks that g is between 0 and 19 and then creates an element and clicks on it. 
	 * @param g
	 */
	public Errors clickGenreCell(int g){
		Errors err = new Errors();
		if(g < 20 && g >= 0){
			String genre = "IHRGenrePickerViewController-Cell-UICollectionViewCell-" + g;
			System.out.println("creating an IOSElement for Genre and clicking it : "+ genre );
			if(waitForElementToBeVisible(findElement(driver, MobileBy.AccessibilityId(genre)), 5)){
				findElement(driver, MobileBy.AccessibilityId(genre)).click();
			}else{
				err.add("The Genre cell wasn't visible and thus couldn't be clicked.", "clickGenreCell");
			}
		}else{
			err.add("Input integer is out of bounds!!", "clickGenreCell");
		}
		return err;
	}
	/**
	 * checks if the Genre Collection View is open indicating the SIM is on the Genre Page.
	 * @return true if on GenrePage
	 */
	public boolean isCurrentlyOnGenrePage(){
		return isCurrentlyOn("isCurrentlyOnGenrePage", IHRGenrePickerViewControllerGenreCollectionViewUICollectionView);
	}
	/**
	 * Scrolls the GenrePage Down
	 */
	public void scrollGenreCollectionDown(){
		rootScrollDown();
	}
	/**
	 * Scrolls the GenrePage Up
	 */
	public void scrollGenreCollectionUp(){
		rootScrollUp();
	}

}
