package com.iheart.appium.iosAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

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
	@iOSFindBy(accessibility = "IHRiPhoneGenrePickerView") public IOSElement genrePicker;
	@iOSFindBy(accessibility = "Done") public IOSElement genreDone;
	@iOSFindBy(accessibility = "Cancel") public IOSElement genreCancel;
	@iOSFindBy(accessibility = "Improve Recommendations") public IOSElement improveRecommendationsButton;
	
	// Behavior methods
	// By position in list
	public void selectGenre(int g) {
		selectGenre(g, false);
	}
	public IOSElement getGenre(int g){
		return waitForVisible(driver,
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + g + "]"), 10);
	}
	
	public void clickDone(){
		System.out.println("generPage.clickDone()");
		genreDone.click();
	}
	
	/**
	 * Can't call normal click because it doesn't know to scroll it into view
	 * Can be used for both selection and deselection
	 * Replaced click method
	 * @param genre
	 * @return
	 */
	private boolean clickGenreElement(IOSElement genre){
		boolean couldBeFound = false;
		if(isVisible(genre)){
			genre.click();
			couldBeFound = true;
		}
		else{
			int counter = 3;
			for(int i = 0; i < counter; i++){
				swipeUp();
				if(isVisible(genre)){
					System.out.println("selecting genres in clickGenre");
					genre.click();
					couldBeFound = true;
					break;
				}
			}
		}		
		return couldBeFound;
	}
	
	/**
	 * Select a genre based on its position
	 * @param g
	 * @param selectingMultiple
	 */
	public void selectGenre(int g, boolean selectingMultiple) {
		IOSElement genre = getGenre(g);
		if(!isGenreSelected(genre)){
			clickGenreElement(genre);
		}
		else{
			System.out.println("Genre in position: " + g + " was already selected. If you'd like to deselect, call the deselect method.");
		}

		if (!selectingMultiple) {
			genreDone.click();
		}
	}

	/**
	 * Selects genres by position, not name
	 * @param gs
	 * @param clickDone
	 */
	public void selectGenres(int[] gs, boolean clickDone) {		
		for (int g : gs) {
			System.out.println("selecting genres");
			selectGenre(g, true);
		}
		if(clickDone){
			genreDone.click();
		}
	}
	public void selectGenres(int[] gs){
		selectGenres(gs, true);
	}

	// By name
	/**
	 * Select a genre by the name if the genre category
	 * @param g
	 * @param clickDone
	 */
	public void selectGenre(String g, boolean clickDone) {
		// Examples: Top 40 & Pop, Country, Hip Hop and R&B, Alternative, etc
		try{
			IOSElement genre = waitForVisible(driver, By.name(g), 5);
			if(!isGenreSelected(genre) ){
				clickGenreElement(genre);
			}
			else{
				System.out.println("Genre: " + g + " was already selected. If you'd like to deselect, call the deselect method.");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if (clickDone) {
			genreDone.click();
		}
	}
	public void selectGenre(String g) {
		selectGenre(g, true);
	}

	/**
	 * Selects genres, will only click done if told to do so
	 * Will only select a genre if it is not already selected
	 * @param gs
	 * @param clickDone
	 */
	public void selectGenres(String[] gs, boolean clickDone) {
		for (String g : gs) {
			selectGenre(g, false);
		}
		if(clickDone){
			genreDone.click();
		}
	}
	public void selectGenres(String[] gs) {
		selectGenres(gs, true);
	}
	
	
	/**** Deselect Genre ****/
	
	/**
	 * Deselect a genre based on its position
	 * @param g
	 * @param selectingMultiple
	 */
	public void deselectGenre(int g, boolean selectingMultiple) {
		IOSElement genre = getGenre(g);
		if(isGenreSelected(genre)){
			clickGenreElement(genre);
		}
		else{
			System.out.println("Genre in position: " + g + " was not selected. If you'd like to select, call the select method.");
		}

		if (!selectingMultiple) {
			genreDone.click();
		}
	}

	/**
	 * Deselects genres by position, not name
	 * @param gs
	 * @param clickDone
	 */
	public void deselectGenres(int[] gs, boolean clickDone) {
		
		for (int g : gs) {
			deselectGenre(g, true);
		}
		if(clickDone){
			genreDone.click();
		}
	}
	public void deselectGenres(int[] gs){
		deselectGenres(gs, true);
	}

	// By name
	/**
	 * Deselect a genre by the name if the genre category
	 * @param g
	 * @param clickDone
	 */
	public void deselectGenre(String g, boolean clickDone) {
		// Examples: Top 40 & Pop, Country, Hip Hop and R&B, Alternative, etc
		try{
			IOSElement genre = waitForVisible(driver, By.name(g), 10);
			if(isGenreSelected(genre)){
				clickGenreElement(genre);
			}
			else{
				System.out.println("Genre: " + g + " was not selected. If you'd like to select, call the select method.");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if (clickDone) {
			genreDone.click();
		}
	}
	public void deselectGenre(String g) {
		deselectGenre(g, true);
	}

	/**
	 * deselects genres, will only click done if told to do so
	 * Will only deselect a genre if it is selected
	 * @param gs
	 * @param clickDone
	 */
	public void deselectGenres(String[] gs, boolean clickDone) {
		for (String g : gs) {
			deselectGenre(g, false);
		}
		if(clickDone){
			genreDone.click();
		}
	}
	public void deselectGenres(String[] gs) {
		deselectGenres(gs, true);
	}
	
	
	
	
	public String verifyGenres(){
		System.out.println("Verifying genres.");
		List<String> genreList = new ArrayList<String>();
		StringBuilder missingGenres = new StringBuilder();
		// Add all genres
		genreList.add("Top 40 & Pop");
		genreList.add("Country");
		genreList.add("Hip Hop and R&B");
		genreList.add("Alternative");
		genreList.add("News & Talk");
		genreList.add("Classic Rock");
		genreList.add("Soft Rock");
		genreList.add("Mix & Variety");
		genreList.add("Rock");
		genreList.add("Sports");
		// Below fold
		genreList.add("Spanish");
		genreList.add("Dance");
		genreList.add("Comedy");
		genreList.add("Oldies");
		genreList.add("Christian & Gospel");
		genreList.add("Jazz");
		genreList.add("Classical");
		genreList.add("World");
		genreList.add("Reggae & Island");
		genreList.add("College Radio");
		
		for(String g : genreList){
			IOSElement genre = findElement(driver, By.name(g));
			if(genre == null || !genre.isDisplayed()){
				// First see if we need to scroll down
				swipeUp();
				genre = findElement(driver, By.name(g));
				if(genre == null || !genre.isDisplayed()){
					missingGenres.append(g + "\n");
				}
			}
		}
		
		return missingGenres.toString(); // If this is longer than 0, we're missing genres
	}
	
	public boolean improveRecommendations(){
		System.out.println("Testing Improve Recommendations.");
		int maxSwipes = 10;
		while(maxSwipes > 0 && !isVisible(improveRecommendationsButton)){
			maxSwipes--;
			swipeUp();
		}
		improveRecommendationsButton.click();
		handlePossiblePopUp();
		if(!isVisible(genrePicker)){
			return false;
		}
		return true;
	}

	public boolean isGenreSelected(int g){
		return isGenreSelected(getGenre(g));
	}
	public boolean isGenreSelected(String s){
		return isGenreSelected(findElement(driver, By.name(s)));
	}
	public boolean isGenreSelected(IOSElement genre){
		boolean genreSelected = false;
		String trueOrNull = genre.getAttribute("value");
		if(trueOrNull == null){
			genreSelected = false;
		}
		else if( trueOrNull.equals("true")){
			genreSelected = true;
		}else {
			genreSelected = false; //default
		}
		
		//System.out.println(genre.isSelected());
		System.out.println("genrePage.isGenreSelected() ? : " + genreSelected);
		//if(Integer.parseInt(genre.getAttribute("value")) == 1){
		//	genreSelected = true;
		//}		
		return genreSelected;
	}

	public boolean isCurrentlyOnGenrePickerPage() {
		return genrePicker.isDisplayed();
	}
	
	public boolean isDoneEnabled(){
		boolean doneEnabled = false;
		String trueOrNull = genreDone.getAttribute("value");
		if(trueOrNull == null){
			doneEnabled = false;
		}
		else if( trueOrNull.equals("true")){
			doneEnabled = true;
		}else {
			doneEnabled = false; //default
		}
		return doneEnabled;
	}
}
