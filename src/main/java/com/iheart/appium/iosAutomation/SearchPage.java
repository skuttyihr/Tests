package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.SwipeElementDirection;
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
	/**
	 * Business Logic
	 * Click Live Station
	 * 	If no stream was playing before, start the live station in the full player
		If a stream is already playing, start the live station in the mini player
		//Click Artist
		If no stream is playing, load Artist Radio in mini player and direct to Artist Profile
		If stream is playing, do not load Artist Radio and direct to Artist Profile
		-Free user
		Artist Radio for relevant track plays in full player if no stream is playing, Artist Radio for relevant track plays in mini player if stream is playing
		On first time selecting a track from search as a free user, an upsell modal will display
		+||P
		Song to start, then Artist Radio, plays in full player if no stream is playing.
		Song to start, then Artist Radio, plays in mini player if stream is already playing
		
		User is directed to Podcast profile page (stream does not start) For All Entitlements. 
		As a free user, search any valid Playlist term and select Playlist from Top Hit or Playlists results section = Curated playlist does not play and shows the user an upsell message
		As a plus or premium user, search any valid Playlist term and select Playlist from Top Hit or Playlists results section  = Curated playlist starts playing
	 */
	//Initial Search Page
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-CancelButton-UIButton") private IOSElement IHRGlobalSearchBarCancelButtonUIButton;
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-SearchBar-UISearchBar") private IOSElement IHRGlobalSearchBarSearchBarUISearchBar;
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-SearchBarTextField-UITextField") private IOSElement IHRGlobalSearchBarSearchBarTextFieldUITextField;
	@iOSFindBy(accessibility = "IHRGlobalSearchInstructionsView-IconView-UIImageView") private IOSElement IHRGlobalSearchInstructionsViewIconViewUIImageView;
	@iOSFindBy(accessibility = "IHRGlobalSearchInstructionsView-Spacer1-UIView") private IOSElement IHRGlobalSearchInstructionsViewSpacer1UIView;
	@iOSFindBy(accessibility = "IHRGlobalSearchInstructionsView-Spacer2-UIView") private IOSElement IHRGlobalSearchInstructionsViewSpacer2UIView;
	@iOSFindBy(accessibility = "IHRGlobalSearchInstructionsView-InstructionsLabel-UILabel") private IOSElement IHRGlobalSearchInstructionsViewInstructionsLabelUILabel;
	//NavBar
	@iOSFindBy(accessibility = "NavBar-BackButton-UIButton") private IOSElement NavBarBackButtonUIButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[2]") private IOSElement NavBarTitle;
	//These are added but may not be able to be found. 
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-SearchBarClearImage-UIImage") private IOSElement IHRGlobalSearchBarSearchBarClearImageUIImage;
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-Subview-UIView") private IOSElement  IHRGlobalSearchBarSubviewUIView;
	@iOSFindBy(accessibility = "IHRGlobalSearchBar-SecondLevelSubview-UIView") private IOSElement IHRGlobalSearchBarSecondLevelSubviewUIView;
	
	@iOSFindBy(accessibility = "GlobalSearchNoResultsCell-ClosingQuoteLabel-UILabel") private IOSElement GlobalSearchNoResultsCellClosingQuoteLabelUILabel;
	@iOSFindBy(accessibility = "GlobalSearchNoResultsCell-NoResultsLabel-UILabel") private IOSElement GlobalSearchNoResultsCellNoResultsLabelUILabel;
	@iOSFindBy(accessibility = "GlobalSearchNoResultsCell-NoResultsSubtitleLabel-UILabel") private IOSElement GlobalSearchNoResultsCellNoResultsSubtitleLabelUILabel;
	//Search Results
	@iOSFindBy(accessibility = "GlobalSearchView-FadingView-UIView") private IOSElement GlobalSearchViewFadingViewUIView;
	@iOSFindBy(accessibility = "GlobalSearchView-CollectionView-UICollectionView") private IOSElement GlobalSearchViewCollectionViewUICollectionView;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-TOP RESULT-HeaderView-UIView") private IOSElement GlobalSearchDataSourceTOPRESULTHeaderViewUIView;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Top Result-Row0") private IOSElement GlobalSearchDataSourceSearchResultCellTopResultRow0;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-LIVE STATIONS-HeaderView-UIView") private IOSElement GlobalSearchDataSourceLIVESTATIONSHeaderViewUIView;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Live Stations-Row0") private IOSElement GlobalSearchDataSourceSearchResultCellLiveStationsRow0;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Live Stations-Row1") private IOSElement GlobalSearchDataSourceSearchResultCellLiveStationsRow1;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-ShowAllLive Stations-DisclosureCell") private IOSElement GlobalSearchDataSourceShowAllLiveStationsDisclosureCell; //Space in String must be there. 
	@iOSFindBy(accessibility = "GlobalSearchDataSource-ARTISTS-HeaderView-UIView") private IOSElement GlobalSearchDataSourceARTISTSHeaderViewUIView;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Artists-Row0") private IOSElement GlobalSearchDataSourceSearchResultCellArtistsRow0;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Artists-Row1") private IOSElement GlobalSearchDataSourceSearchResultCellArtistsRow1;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-ShowAllArtists-DisclosureCell") private IOSElement GlobalSearchDataSourceShowAllArtistsDisclosureCell;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SONGS-HeaderView-UIView") private IOSElement GlobalSearchDataSourceSONGSHeaderViewUIView;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Songs-Row0") private IOSElement GlobalSearchDataSourceSearchResultCellSongsRow0;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Songs-Row1") private IOSElement GlobalSearchDataSourceSearchResultCellSongsRow1;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-ShowAllSongs-DisclosureCell") private IOSElement GlobalSearchDataSourceShowAllSongsDisclosureCell;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-PERFECT FOR-HeaderView-UIView") private IOSElement GlobalSearchDataSourcePERFECTFORHeaderViewUIView;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Perfect For-Row0") private IOSElement GlobalSearchDataSourceSearchResultCellPerfectForRow0;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Perfect For-Row1") private IOSElement GlobalSearchDataSourceSearchResultCellPerfectForRow1;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-PODCASTS-HeaderView-UIView") private IOSElement GlobalSearchDataSourcePODCASTSHeaderViewUIView;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Podcasts-Row0") private IOSElement GlobalSearchDataSourceSearchResultCellPodcastsRow0;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-SearchResultCell-Podcasts-Row1") private IOSElement GlobalSearchDataSourceSearchResultCellPodcastsRow1;
	@iOSFindBy(accessibility = "GlobalSearchDataSource-ShowAllPodcasts-DisclosureCell") private IOSElement GlobalSearchDataSourceShowAllPodcastsDisclosureCell;
	
	//Section 0 = Top Result, Section1 = Live Stations, Section 2 = Artists, Section 3 = Songs, Section 4 = Perfect For (to become Playlists), Section 5 = Podcasts. Only if all exist, otherwise.
	//Add Search Results AIDs and related methods to click them, get information out of them, scroll down, etc. 

	
	//All Artist //Back Arrow, Artist Header, Label, Collection, and List of Artists, their images. Each opens Artist Bio. 
	@iOSFindBy(accessibility = "GlobalSearchCategorySearchTermCell-Label-UILabel") private IOSElement GlobalSearchCategorySearchTermCellLabelUILabel; //Results for "alic"
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-CollectionView-UICollectionView") private IOSElement GlobalSearchCategoryDataSourceCollectionViewUICollectionView; //List of Cells
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Artist-SearchResultCell-Row0") private IOSElement GlobalSearchCategoryDataSourceArtistSearchResultCellRow0;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Artist-SearchResultCell-Row1") private IOSElement GlobalSearchCategoryDataSourceArtistSearchResultCellRow1;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Artist-SearchResultCell-Row2") private IOSElement GlobalSearchCategoryDataSourceArtistSearchResultCellRow2;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Artist-SearchResultCell-Row3") private IOSElement GlobalSearchCategoryDataSourceArtistSearchResultCellRow3;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Artist-SearchResultCell-Row4") private IOSElement GlobalSearchCategoryDataSourceArtistSearchResultCellRow4;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Artist-SearchResultCell-Row5") private IOSElement GlobalSearchCategoryDataSourceArtistSearchResultCellRow5;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Artist-SearchResultCell-Row6") private IOSElement GlobalSearchCategoryDataSourceArtistSearchResultCellRow6;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Artist-SearchResultCell-Row7") private IOSElement GlobalSearchCategoryDataSourceArtistSearchResultCellRow7;
	//All Songs //Back Arrow, Artist Header, Label, Collection, and List of Artists, their images. Each opens Artist Bio. 
	//@iOSFindBy(accessibility = "GlobalSearchCategorySearchTermCell-Label-UILabel") private IOSElement GlobalSearchCategorySearchTermCellLabelUILabel; //Results for "alic"
	//@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-CollectionView-UICollectionView") private IOSElement GlobalSearchCategoryDataSourceCollectionViewUICollectionView;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row0") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow0;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row1") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow1;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row2") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow2;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row3") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow3;	
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row4") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow4;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row5") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow5;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row6") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow6;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row7") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow7;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Track-SearchResultCell-Row12") private IOSElement GlobalSearchCategoryDataSourceTrackSearchResultCellRow12;
	//Podcasts
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Show-SearchResultCell-Row0") private IOSElement GlobalSearchCategoryDataSourceShowSearchResultCellRow0;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Show-SearchResultCell-Row1") private IOSElement GlobalSearchCategoryDataSourceShowSearchResultCellRow1;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Show-SearchResultCell-Row2") private IOSElement GlobalSearchCategoryDataSourceShowSearchResultCellRow2;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Show-SearchResultCell-Row3") private IOSElement GlobalSearchCategoryDataSourceShowSearchResultCellRow3;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Show-SearchResultCell-Row4") private IOSElement GlobalSearchCategoryDataSourceShowSearchResultCellRow4;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Show-SearchResultCell-Row5") private IOSElement GlobalSearchCategoryDataSourceShowSearchResultCellRow5;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Show-SearchResultCell-Row6") private IOSElement GlobalSearchCategoryDataSourceShowSearchResultCellRow6;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Show-SearchResultCell-Row12") private IOSElement GlobalSearchCategoryDataSourceShowSearchResultCellRow12;
	//Goes to Row39 - maybe there is a max limit of 40 Podcast cells? 
	//Live Stations List 
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row0") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow0;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row1") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow1;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row2") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow2;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row3") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow3;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row4") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow4;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row5") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow5;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row6") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow6;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row7") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow7;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row8") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow8;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-LiveRadio-SearchResultCell-Row9") private IOSElement GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow9;
	//Themed Radio List 
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHROriginalStation-SearchResultCell-Row0") private IOSElement GlobalSearchCategoryDataSourceIHROriginalStationSearchResultCellRow0;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHROriginalStation-SearchResultCell-Row1") private IOSElement GlobalSearchCategoryDataSourceIHROriginalStationSearchResultCellRow1;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHROriginalStation-SearchResultCell-Row2") private IOSElement GlobalSearchCategoryDataSourceIHROriginalStationSearchResultCellRow2;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHROriginalStation-SearchResultCell-Row3") private IOSElement GlobalSearchCategoryDataSourceIHROriginalStationSearchResultCellRow3;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHROriginalStation-SearchResultCell-Row4") private IOSElement GlobalSearchCategoryDataSourceIHROriginalStationSearchResultCellRow4;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHROriginalStation-SearchResultCell-Row5") private IOSElement GlobalSearchCategoryDataSourceIHROriginalStationSearchResultCellRow5;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHROriginalStation-SearchResultCell-Row6") private IOSElement GlobalSearchCategoryDataSourceIHROriginalStationSearchResultCellRow6;
	//Keyword
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Keyword-SearchResultCell-Row0") private IOSElement GlobalSearchCategoryDataSourceKeywordSearchResultCellRow0;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Keyword-SearchResultCell-Row1") private IOSElement GlobalSearchCategoryDataSourceKeywordSearchResultCellRow1;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Keyword-SearchResultCell-Row2") private IOSElement GlobalSearchCategoryDataSourceKeywordSearchResultCellRow2;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Keyword-SearchResultCell-Row3") private IOSElement GlobalSearchCategoryDataSourceKeywordSearchResultCellRow3;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Keyword-SearchResultCell-Row4") private IOSElement GlobalSearchCategoryDataSourceKeywordSearchResultCellRow4;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Keyword-SearchResultCell-Row5") private IOSElement GlobalSearchCategoryDataSourceKeywordSearchResultCellRow5;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-Keyword-SearchResultCell-Row6") private IOSElement GlobalSearchCategoryDataSourceKeywordSearchResultCellRow6;
	//IHRPlaylistDataModel
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHRPlaylistDataModel-SearchResultCell-Row0") private IOSElement GlobalSearchCategoryDataSourceIHRPlaylistDataModelSearchResultCellRow0;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHRPlaylistDataModel-SearchResultCell-Row1") private IOSElement GlobalSearchCategoryDataSourceIHRPlaylistDataModelSearchResultCellRow1;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHRPlaylistDataModel-SearchResultCell-Row2") private IOSElement GlobalSearchCategoryDataSourceIHRPlaylistDataModelSearchResultCellRow2;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHRPlaylistDataModel-SearchResultCell-Row3") private IOSElement GlobalSearchCategoryDataSourceIHRPlaylistDataModelSearchResultCellRow3;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHRPlaylistDataModel-SearchResultCell-Row4") private IOSElement GlobalSearchCategoryDataSourceIHRPlaylistDataModelSearchResultCellRow4;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHRPlaylistDataModel-SearchResultCell-Row5") private IOSElement GlobalSearchCategoryDataSourceIHRPlaylistDataModelSearchResultCellRow5;
	@iOSFindBy(accessibility = "GlobalSearchCategoryDataSource-IHRPlaylistDataModel-SearchResultCell-Row6") private IOSElement GlobalSearchCategoryDataSourceIHRPlaylistDataModelSearchResultCellRow6;
	
	
	public void clickNavBarBackButton(){
		System.out.println("clickNavBarBackButton().");
		NavBarBackButtonUIButton.click();
	}
	public void clickShowAllArtists(){
		System.out.println("clickShowAllArtists().");
		GlobalSearchDataSourceShowAllArtistsDisclosureCell.click();
	}
	public void clickShowAllPodcasts(){
		System.out.println("clickShowAllPodcasts().");
		GlobalSearchDataSourceShowAllPodcastsDisclosureCell.click();
	}
	public void clickShowAllSongs(){
		System.out.println("clickShowAllSongs().");
		GlobalSearchDataSourceShowAllSongsDisclosureCell.click();
	}
	public void clickShowAllLiveStations(){
		System.out.println("clickShowAllLiveStations().");
		GlobalSearchDataSourceShowAllLiveStationsDisclosureCell.click();
	}

	public void clickAllPlaylists(){
		
	}
	
	public String getSearchLabel(){
		String resultsForText = GlobalSearchCategorySearchTermCellLabelUILabel.getText();
		System.out.println("getSearchLabel() : " +resultsForText);
		return resultsForText;
	}
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
	public boolean isCurrentlyOnArtistsList(){
		return isCurrentlyOn("isCurrentlyOnArtistsList", GlobalSearchCategoryDataSourceArtistSearchResultCellRow0);
	}
	public boolean isCurrentlyOnLiveStationsList(){
		return isCurrentlyOn("isCurrentlyOnLiveStationsList", GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow0);
	}
	public boolean isCurrentlyOnSongsList(){
		return isCurrentlyOn("isCurrentlyOnSongsList", GlobalSearchCategoryDataSourceTrackSearchResultCellRow0);
	}
	public boolean isCurrentlyOnPodcastsList(){
		return isCurrentlyOn("isCurrentlyOnPodcastsList", GlobalSearchCategoryDataSourceShowSearchResultCellRow0);
	}
	public boolean isCurrentlyOnOriginalStationsList(){
		return isCurrentlyOn("isCurrentlyOnOriginalStationsList", GlobalSearchCategoryDataSourceIHROriginalStationSearchResultCellRow0);
	}
	public boolean isCurrentlyOnKeywordList(){
		return isCurrentlyOn("isCurrentlyOnKeywordList", GlobalSearchCategoryDataSourceKeywordSearchResultCellRow0);
	}
	public boolean isCurrentlyOnSearchResultsList(){
		return isCurrentlyOn("isCurrentlyOnSearchResultsList", GlobalSearchViewFadingViewUIView);
	}
	public boolean isCurrentlyOnPodcastList(){
		IOSElement episodes = Page.waitForVisible(driver, By.name("Episodes"), 10);
		return isCurrentlyOn("isCurrentlyOnPodcastList", episodes);
	}
	/**
	 * No results for "cvg"
	 * Check your spelling or try another search
	 * click on searchBar, delete a character, then click on item and ensure we're on artistprofile or player. 
	 * @param searchTerm
	 * @return
	 */
	public boolean isNoResultsCellDisplayedCorrectly(){
		waitForElementToBeVisible(GlobalSearchNoResultsCellNoResultsLabelUILabel, 3);
		printElementInformation(GlobalSearchNoResultsCellNoResultsLabelUILabel);
		printElementInformation(GlobalSearchNoResultsCellNoResultsSubtitleLabelUILabel);
		String noResultsLabel = GlobalSearchNoResultsCellNoResultsSubtitleLabelUILabel.getText();
		boolean subtitleCorrect = noResultsLabel.equals("Check your spelling or try another search");
		System.out.println("isNoResultsCellDisplayedCorrectly() : "+ subtitleCorrect);
		return  subtitleCorrect;
		
	}
	/**
	 * This scrolls the Search Results collection view up and down. 
	 * If you've just entered text into the search bar, use a startPosition of 500 when swiping up to be above the keyboard.
	 * @param direction  SwipeElementDirection.UP and .DOWN
	 * @param startPosition
	 * @param endPosition
	 * @param timeToScroll 750 to 1000 is pretty good
	 */
	public void scrollSearchResultsCollectionView(SwipeElementDirection direction, int startPosition, int endPosition, int timeToScroll){
		System.out.println("scrollSearchResultsCollectionView() : Direction - " + direction + " timeToScroll: " + timeToScroll + " milliseconds from " + startPosition + " through " + endPosition);
		GlobalSearchViewFadingViewUIView.swipe(direction, startPosition, endPosition, timeToScroll);
	}
	
	/**
	 * This scrolls the List of Artists, Songs, Albums, Podcasts in the Search results page. 
	 * 
	 * @param direction
	 * @param startPosition
	 * @param endPosition
	 * @param timeToScroll
	 */
	public void scrollCategoryCollectionView(SwipeElementDirection direction, int startPosition, int endPosition, int timeToScroll){
		System.out.println("scrollCategoryCollectionView() : Direction - " + direction + " timeToScroll: " + timeToScroll + " milliseconds from " + startPosition + " through " + endPosition);
		GlobalSearchCategoryDataSourceCollectionViewUICollectionView.swipe(direction, startPosition, endPosition, timeToScroll);
	}

	/**
	 * Enters text into the Search Bar TextField. ClearsTextField first. No real need to hit enter as Search populates results as you type. 
	 * @param searchQuery
	 */
	public void enterTextAndPressEnterIntoSearchBar(String searchQuery){
		System.out.println("enterTextAndPressEnterIntoSearchBar() : "+ searchQuery);
		IHRGlobalSearchBarSearchBarTextFieldUITextField.sendKeys(searchQuery);
		IHRGlobalSearchBarSearchBarTextFieldUITextField.sendKeys(Keys.ENTER);
	}
	/**
	 * Enters searchQuery into the search bar textfield. 
	 * @param searchQuery
	 */
	public void enterTextIntoSearchBar(String searchQuery){
		System.out.println("enterTextIntoSearchBar() : "+ searchQuery);
		IHRGlobalSearchBarSearchBarTextFieldUITextField.sendKeys(searchQuery);

	}
	/**
	 * Enter the ENTER key into the Search Bar Text Field. 
	 */
	public void enterEnterKeyIntoSearchBar(){
		System.out.println("enterEnterIntoSearchBar(). ");
		IHRGlobalSearchBarSearchBarTextFieldUITextField.sendKeys(Keys.ENTER);
	}
	/**
	 * Uses the Keys.BACK_SPACE and enters it for a set number of times into the textfield. 
	 * @param numberOfBackSpaces
	 */
	public void enterBackSpaceKeyIntoSearchBar(int numberOfBackSpaces){
		System.out.println("enterBackSpaceKeyIntoSearchBar() : "+ numberOfBackSpaces);
		int count = 0;
		while(count < numberOfBackSpaces){
			IHRGlobalSearchBarSearchBarTextFieldUITextField.sendKeys(Keys.BACK_SPACE);
			count++;
		}
	}
	/**
	 * Retrieve the Search Bar Textfield text - this has been entered by you / some other method. 
	 * @return
	 */
	public String getSearchBarText(){
		String text = IHRGlobalSearchBarSearchBarTextFieldUITextField.getText();
		System.out.println("getSearchBarText() : "+ text);
		return text;
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
		return isCurrentlyOn("isCurrentlyOnSearchPage", IHRGlobalSearchBarCancelButtonUIButton);
	}
	
	public void clickTopResult(){
		System.out.println("clickTopResult().");
		GlobalSearchDataSourceSearchResultCellTopResultRow0.click();
	}
	public void clickFirstLiveStation(){
		System.out.println("clickFirstLiveStation().");
		GlobalSearchDataSourceSearchResultCellLiveStationsRow0.click();
	}
	public void clickSecondLiveStation(){
		System.out.println("clickSecondLiveStation().");
		GlobalSearchDataSourceSearchResultCellLiveStationsRow1.click();
	}
	public void clickFirstArtist(){
		System.out.println("clickFirstArtist().");
		GlobalSearchDataSourceSearchResultCellArtistsRow0.click();
	}
	public void clickSecondArtist(){
		System.out.println("clickSecondArtist().");
		GlobalSearchDataSourceSearchResultCellArtistsRow1.click();
	}
	public void clickFirstSong(){
		System.out.println("clickFirstSong().");
		GlobalSearchDataSourceSearchResultCellSongsRow0.click();
	}
	public void clickSecondSong(){
		System.out.println("clickSecondSong().");
		GlobalSearchDataSourceSearchResultCellSongsRow1.click();
	}
	public void clickFirstPerfectForCell(){
		System.out.println("clickFirstPerfectForCell().");
		GlobalSearchDataSourceSearchResultCellPerfectForRow0.click();
	}
	public void clickSecondPerfectForCell(){
		System.out.println("clickSecondPerfectForCell().");
		GlobalSearchDataSourceSearchResultCellPerfectForRow1.click();
	}
	public void clickFirstPodcastsCell(){
		System.out.println("clickFirstPodcastsCell().");
		GlobalSearchDataSourceSearchResultCellPodcastsRow0.click();
	}
	public void clickSecondPodcastsCell(){
		System.out.println("clickSecondPodcastsCell().");
		GlobalSearchDataSourceSearchResultCellPodcastsRow1.click();
	}
	
	/**
	 * Simply print out all of the Search elements we've added and return whether they are all correctly displayed. 
	 * @return
	 */
	public void showAllElements(){
		System.out.println("::::Printing out SEARCH Elements.::::");
		
		printElementInformation(IHRGlobalSearchBarCancelButtonUIButton);
		printElementInformation(IHRGlobalSearchBarSearchBarUISearchBar); 
		printElementInformation(IHRGlobalSearchBarSearchBarTextFieldUITextField);
		printElementInformation(IHRGlobalSearchInstructionsViewIconViewUIImageView);
		printElementInformation(IHRGlobalSearchInstructionsViewSpacer1UIView);
		printElementInformation(IHRGlobalSearchInstructionsViewSpacer2UIView);//this isn't working
		printElementInformation(IHRGlobalSearchInstructionsViewInstructionsLabelUILabel); //this isn't visible. 
	}
	public void showAllElementsVoid(){
	//Search Results
		
		System.out.println("::::Printing out element information for 'rap' search Results.::::");
		printElementInformation(GlobalSearchViewFadingViewUIView);
		printElementInformation(GlobalSearchViewCollectionViewUICollectionView);
		
		System.out.println("::::Printing out TOP RESULT.::::");
		printElementInformation(GlobalSearchDataSourceTOPRESULTHeaderViewUIView);
		printElementInformation(GlobalSearchDataSourceSearchResultCellTopResultRow0);
		System.out.println("::::Printing out LIVE STATIONS.::::");
		printElementInformation(GlobalSearchDataSourceLIVESTATIONSHeaderViewUIView);
		printElementInformation(GlobalSearchDataSourceSearchResultCellLiveStationsRow0);
		printElementInformation(GlobalSearchDataSourceSearchResultCellLiveStationsRow1);
		printElementInformation(GlobalSearchDataSourceShowAllLiveStationsDisclosureCell);
		searchPage.clickShowAllLiveStations();
		searchPage.showSomeElementsOnLiveStationsList();
		searchPage.scrollSearchResultsCollectionView(SwipeElementDirection.UP, 500, 100, 1000); //keyboard is still visible
		//clickNavBarBackButton();
		System.out.println("::::Printing out ARTISTS.::::");
		printElementInformation(GlobalSearchDataSourceARTISTSHeaderViewUIView);
		printElementInformation(GlobalSearchDataSourceSearchResultCellArtistsRow0);
		printElementInformation(GlobalSearchDataSourceSearchResultCellArtistsRow1);
		printElementInformation(GlobalSearchDataSourceShowAllArtistsDisclosureCell);
		searchPage.clickShowAllArtists(); //move back
		clickNavBarBackButton();
		//searchPage.clickNavBarBackButton(); //searchPage.showSomeElementsOnArtistsList(); //  This simply doesn't work reliably enough. Collection view isn't fully populated. 
		//searchPage.scrollSearchResultsCollectionView(SwipeElementDirection.UP, 500, 50, 2000); //Move the page down some more to see Songs. 
		System.out.println("::::Printing out SONGS.::::");
		printElementInformation(GlobalSearchDataSourceSONGSHeaderViewUIView);
		printElementInformation(GlobalSearchDataSourceSearchResultCellSongsRow0);
		printElementInformation(GlobalSearchDataSourceSearchResultCellSongsRow1);
		printElementInformation(GlobalSearchDataSourceShowAllSongsDisclosureCell);
		searchPage.clickShowAllSongs();
		clickNavBarBackButton(); //searchPage.showSomeElementsOnSongsList();//  This simply doesn't work reliably enough. Collection view isn't fully populated. 
		//sk - 11/5 - the old swipe is swiping from left to right with appium 1.6.0  to reveal the side nav bar so updating to new swipe
		//searchPage.scrollSearchResultsCollectionView(SwipeElementDirection.UP, 500, 50, 2000);
		swipeUp();
		//sk - 11/5 - commenting out as PERFECT FOR has been removed from the app
		/*System.out.println("::::Printing out PERFECT FOR.::::");
		printElementInformation(GlobalSearchDataSourcePERFECTFORHeaderViewUIView);
		printElementInformation(GlobalSearchDataSourceSearchResultCellPerfectForRow0);
		printElementInformation(GlobalSearchDataSourceSearchResultCellPerfectForRow1);
		searchPage.scrollSearchResultsCollectionView(SwipeElementDirection.UP, 500, 50, 2000);*/
		System.out.println("::::Printing out PODCASTS.::::");
		printElementInformation(GlobalSearchDataSourcePODCASTSHeaderViewUIView);
		printElementInformation(GlobalSearchDataSourceSearchResultCellPodcastsRow0);
		printElementInformation(GlobalSearchDataSourceSearchResultCellPodcastsRow1);
		printElementInformation(GlobalSearchDataSourceShowAllPodcastsDisclosureCell);
	}
	public void showSomeElementsOnLiveStationsList(){
		if(searchPage.isCurrentlyOnLiveStationsList()){
			System.out.println(":::: Printing out Live Radio Cells ::::");
			printElementInformation(NavBarBackButtonUIButton);	
			printElementInformation(GlobalSearchCategorySearchTermCellLabelUILabel); //Results for ""
			printElementInformation(GlobalSearchCategoryDataSourceCollectionViewUICollectionView); 
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow0);
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow1);
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow2);
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow3);
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow4);
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow5);
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow6);
			searchPage.scrollCategoryCollectionView(SwipeElementDirection.UP, 50, 50, 1000);		
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow7);
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow8);
			printElementInformation(GlobalSearchCategoryDataSourceLiveRadioSearchResultCellRow9);
			searchPage.clickNavBarBackButton(); //Always shown at top. 
		}
	}
	public void showSomeElementsOnArtistsList(){
		Page.waitForElementToBeVisible(GlobalSearchCategorySearchTermCellLabelUILabel, 5);
		searchPage.scrollCategoryCollectionView(SwipeElementDirection.UP, 50, 50, 10);
		System.out.println(":::: Printing out Artist Cells ::::");
		printElementInformation(NavBarBackButtonUIButton);	
		printElementInformation(GlobalSearchCategorySearchTermCellLabelUILabel); //Results for ""
		printElementInformation(GlobalSearchCategoryDataSourceCollectionViewUICollectionView); 
		printElementInformation(GlobalSearchCategoryDataSourceArtistSearchResultCellRow0);
		printElementInformation(GlobalSearchCategoryDataSourceArtistSearchResultCellRow1);
		printElementInformation(GlobalSearchCategoryDataSourceArtistSearchResultCellRow2);
		printElementInformation(GlobalSearchCategoryDataSourceArtistSearchResultCellRow3);
		printElementInformation(GlobalSearchCategoryDataSourceArtistSearchResultCellRow4);
		printElementInformation(GlobalSearchCategoryDataSourceArtistSearchResultCellRow5);
		printElementInformation(GlobalSearchCategoryDataSourceArtistSearchResultCellRow6);
		searchPage.scrollCategoryCollectionView(SwipeElementDirection.UP, 50, 50, 1000);	//No keyboard on this page
		printElementInformation(GlobalSearchCategoryDataSourceArtistSearchResultCellRow7);
		searchPage.clickNavBarBackButton();
	}
	public void showSomeElementsOnSongsList(){
		if(searchPage.isCurrentlyOnSongsList()){
			System.out.println(":::: Printing out Track Cells ::::");
			printElementInformation(NavBarBackButtonUIButton);	
			printElementInformation(GlobalSearchCategorySearchTermCellLabelUILabel); //Results for ""
			printElementInformation(GlobalSearchCategoryDataSourceCollectionViewUICollectionView); 
			printElementInformation(GlobalSearchCategoryDataSourceTrackSearchResultCellRow0);
			printElementInformation(GlobalSearchCategoryDataSourceTrackSearchResultCellRow1);
			printElementInformation(GlobalSearchCategoryDataSourceTrackSearchResultCellRow2);
			printElementInformation(GlobalSearchCategoryDataSourceTrackSearchResultCellRow3);
			printElementInformation(GlobalSearchCategoryDataSourceTrackSearchResultCellRow4);
			printElementInformation(GlobalSearchCategoryDataSourceTrackSearchResultCellRow5);
			printElementInformation(GlobalSearchCategoryDataSourceTrackSearchResultCellRow6);
			searchPage.scrollCategoryCollectionView(SwipeElementDirection.UP, 50, 50, 1000);	//No keyboard on this page
			printElementInformation(GlobalSearchCategoryDataSourceTrackSearchResultCellRow12);
			searchPage.clickNavBarBackButton();
		}
	}
}
