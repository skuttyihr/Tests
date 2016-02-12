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
	@iOSFindBy(name = "IHRiPhoneGenrePickerView") public IOSElement genrePicker;
	@iOSFindBy(name = "Done") public IOSElement genreDone;
	@iOSFindBy(name = "Cancel") public IOSElement genreCancel;
	@iOSFindBy(name = "Improve Recommendations") public IOSElement improveRecommendationsButton;
	
	// Behavior methods
	// By position in list
	public void selectGenre(int g) {
		selectGenre(g, false);
	}
	public IOSElement getGenre(int g){
		return waitForVisible(driver,
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + g + "]"), 10);
	}
	public void selectGenre(int g, boolean selectingMultiple) {
		// XPATH:
		// //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]
		getGenre(g).click();

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
	public void selectGenre(String g) {
		selectGenre(g, true);
	}

	public void selectGenre(String g, boolean clickDone) {
		// Examples: Top 40 & Pop, Country, Hip Hop and R&B, Alternative, etc
		waitForVisible(driver, By.name(g), 10).click();
		if (clickDone) {
			genreDone.click();
		}
	}

	/**
	 * Selects genres, will only click done if told to do so
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
	
	
	public String verifyGenres(){
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
		int maxSwipes = 10;
		while(maxSwipes > 0 && !isVisible(improveRecommendationsButton)){
			maxSwipes--;
			swipeUp();
		}
		improveRecommendationsButton.click();
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
		
		if(Integer.parseInt(genre.getAttribute("value")) == 1){
			genreSelected = true;
		}
		
		return genreSelected;
	}
}
