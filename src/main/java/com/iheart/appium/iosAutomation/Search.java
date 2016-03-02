package com.iheart.appium.iosAutomation;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Search extends Page {

	public Search() {
		super();
	}

	public Search(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	// Search field
	@iOSFindBy(name = "Search") public IOSElement searchButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]") public IOSElement searchField;
	@iOSFindBy(name = "Cancel") public IOSElement cancel;
	// Search Elements, used to create custom stations
//	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]") public IOSElement firstElement;
	private final String firstResultXpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]";
	@iOSFindBy(xpath = firstResultXpath) public IOSElement firstStation;
	@iOSFindBy(xpath = firstResultXpath + "/UIAStaticText[1]") public IOSElement firstStationTitle;
	// Search result elements
	
	// Search filters
	@iOSFindBy(name = "All") public IOSElement allFilter;
	@iOSFindBy(name = "Stations") public IOSElement stationsFilter;
	@iOSFindBy(name = "Artists") public IOSElement artistsFilter;
	@iOSFindBy(name = "Songs") public IOSElement songsFilter;
//	@iOSFindBy(name = "Podcasts") public IOSElement podcastsFilter; // For some reason, this one doesn't work
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASegmentedControl[1]/UIAButton[5]") public IOSElement podcastsFilter;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]") public IOSElement noResults;
	
	// Get a particular result
	public IOSElement getResult(int i){
		return waitForVisible(driver, 
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + i + "]"),
				10);
	}
	
	// Search methods
	private IOSElement getSearchButton(){
		return waitForVisible(driver, By.name("Search"), 10);
	}
	private void getToSearch(){
		if(searchField == null || !isVisible(searchField)){
			IOSElement sb = getSearchButton();
			if(sb == null || !isVisible(sb)){
				sideNavBar.gotoHomePage();
			}
			sb = getSearchButton();
			sb.click();
			waitForElementToBeVisible(searchField, 3);
		}
	}
	
	/**
	 * Returns true if search results in stations showing up in list
	 * @param searchTerm
	 * @return
	 */
	public boolean searchForStationWithoutSelecting(String searchTerm){
		getToSearch();
		if(searchTerm == null || searchTerm.length() == 0){
			searchField.clear();
			waitForNotVisible(driver, By.xpath(firstResultXpath), 1);
			String firstResultText = waitForVisible(driver, By.xpath(firstResultXpath + "/UIAStaticText[1]"), 1).getText();
			return (!firstResultText.contains("No results for")); // This method sends TRUE when it finds a result, so we use that logic here
		}
		searchField.sendKeys(searchTerm);
		if(areResultsEmpty(searchTerm)){
			return false;
		}
		waitForElementToBeVisible(firstStation, 7);
		return getSearchResult(1) != null;
	}
	
	public boolean areResultsEmpty(String searchTerm){
		if(waitForVisible(driver, By.name("No results for \"" + searchTerm + "\""), 2) != null){
			return true;
		}
		return false;
	}
	
	/**
	 * Search for an item, return the name of the selected result
	 * @param searchTerm
	 * @return
	 */
	public String searchForStation(String searchTerm){
		searchForStationWithoutSelecting(searchTerm);
		String selectedStation = firstStationTitle.getText();
		firstStation.click();
		return selectedStation;
	}
	
	/**
	 * Test method for applying all filters and checking they're activated
	 * @return An error string, empty if no errors
	 */
	public String applyFilters(){
		StringBuilder errors = new StringBuilder();
		// Use a set to make sure we don't get all of the same results with the filter
		Set<String> topResults = new HashSet<String>();
		
		String[] filters = {"all", "stations", "artists", "songs", "podcasts"};
		for(String f : filters){
			String foundStation = applyFilter(f);
			topResults.add(foundStation);
			if(!strGood(foundStation)){
				errors.append("Could not find a station with the filter: " + f + "\n");
			}
		}
		
		// Ensure the filter changed the top result at least once
		if(topResults.size() <= 1){
			errors.append("Filters had no effect.\n");
		}
		
		if(errors == null || errors.toString().length() == 0)
			return null;
		return errors.toString();
	}
	
	/**
	 * Applies a search filter
	 * Choices: All, Stations, Artists, Songs, Podcasts
	 * @param filter
	 * @return First search result (empty indicates an error)
	 */
	public String applyFilter(String filter){
		String foundStation = "";
		// String switching was introduced in Java 7. The current verion as of this comment is 8.
		// If this is an error for you, go get Java 7, at least. 
		IOSElement toSelect = null;
		switch(filter.toLowerCase()){
		case "all":
			waitForElementToBeVisible(allFilter, 5);
			toSelect = allFilter;
			break;
		case "stations":
			waitForElementToBeVisible(stationsFilter, 5);
			toSelect = stationsFilter;
			break;
		case "artists":
			waitForElementToBeVisible(artistsFilter, 5);
			toSelect = artistsFilter;
			break;
		case "songs":
			waitForElementToBeVisible(songsFilter, 5);
			toSelect = songsFilter;
			break;
		case "podcasts":
			waitForElementToBeVisible(podcastsFilter, 5);
			toSelect = podcastsFilter;
			break;
		default:
			break;
		}
		
		if(toSelect != null){
			toSelect.click();
			IOSElement firstResult = getSearchResultTitle(1);
			if(firstResult != null){
				foundStation = firstResult.getText();
			}
		}
		
		return foundStation;
	}
	
	public String searchForPodCast(String searchTerm){
		getToSearch();
		searchField.sendKeys(searchTerm);
		waitForElementToBeVisible(firstStation, 10);
		// Select first result
		firstStation.click();
		// Select the first podcast episode 
		IOSElement podcastEpisode = podcastsPage.getPodcastEpisode(1);
		String chosenEpisode = "";
		if(podcastEpisode != null){
			podcastEpisode.getText();
			podcastEpisode.click();
		}
		return chosenEpisode;
	}
	
	public IOSElement getSearchResult(int i){
		return waitForVisible(driver, 
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[" + i + "]"),
					10);
	}
	public IOSElement getSearchResultTitle(int i){
		return waitForVisible(driver, 
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[" + i + "]/UIAStaticText[1]"),
					10);
	}
}
