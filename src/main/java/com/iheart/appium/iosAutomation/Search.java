package com.iheart.appium.iosAutomation;

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
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]") public IOSElement firstStation;
	// Search result elements
	
	// Search filters
	@iOSFindBy(name = "All") public IOSElement allFilter;
	@iOSFindBy(name = "Artists") public IOSElement artistsFilter;
	@iOSFindBy(name = "Songs") public IOSElement songsFilter;
	@iOSFindBy(name = "Podcasts") public IOSElement podCastsFilter;
	
	// Get a particular result
	public IOSElement getResult(int i){
		return waitForVisible(driver, 
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + i + "]"),
				10);
	}
	
	// Search methods
	private void getToSearch(){
		if(!searchButton.isDisplayed()){
			sideNavigationBar.navIcon.click();
			sideNavigationBar.home.click();
		}
		searchButton.click();
	}
	/**
	 * Search for an item, return the name of the selected result
	 * @param searchTerm
	 * @return
	 */
	public String searchForStation(String searchTerm){
		getToSearch();
		searchField.sendKeys(searchTerm);
		waitForElementToBeVisible(firstStation, 10);
		String selectedStation = firstStation.getText();
		firstStation.click();
		return selectedStation;
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
	
	// Select search results
}
