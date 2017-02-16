package com.iheart.appium.iosAutomation;
import org.openqa.selenium.By;

import com.iheart.appium.utilities.Errors;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage extends Page {

	public HomePage() {
		super();
	}
	public HomePage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	@iOSFindBy(accessibility = "IHRiPhoneHomePageView") private IOSElement IHRiPhoneHomePageView;
	@iOSFindBy(accessibility = "NavBar-SideMenuButton-UIButton") private IOSElement NavBarSideMenuButtonUIButton;
	@iOSFindBy(accessibility = "iheartradio_logo_full") private IOSElement  iheartradio_logo_full;
	@iOSFindBy(accessibility = "iheartradio_logo_full_allaccess") private IOSElement iheartradio_logo_full_allaccess;
	@iOSFindBy(accessibility = "iheartradio_logo_full_plus") private IOSElement iheartradio_logo_full_plus;
	@iOSFindBy(accessibility = "IHRCastingBarButtonItem-UIButton") private IOSElement IHRCastingBarButtonItemUIButton;
	@iOSFindBy(accessibility = "NavBar-SearchBarButton-UIButton") private IOSElement NavBarSearchBarButtonUIButton;
	@iOSFindBy(accessibility="HomeSegmentedControl-TitleLabel-UIButton-For You") private IOSElement HomeSegmentedControlTitleLabelUIButtonForYou;
	@iOSFindBy(accessibility="HomeSegmentedControl-TitleLabel-UIButton-My Stations") private IOSElement HomeSegmentedControlTitleLabelUIButtonMyStations;
	@iOSFindBy(accessibility="HomeSegmentedControl-TitleLabel-UIButton-My Music") private IOSElement HomeSegmentedControlTitleLabelUIButtonMyMusic;
	//FOR YOU Cells
	@iOSFindBy(accessibility="ForYouTab-CollectionView") private IOSElement ForYouTabCollectionView;
	@iOSFindBy(accessibility="ForYou-CellNumber-0") private IOSElement ForYouCellNumber0;
	@iOSFindBy(accessibility="ForYou-CellNumber-1") private IOSElement ForYouCellNumber1;
	@iOSFindBy(accessibility="ForYou-CellNumber-2") private IOSElement ForYouCellNumber2;
	@iOSFindBy(accessibility="ForYou-CellNumber-3") private IOSElement ForYouCellNumber3;
	@iOSFindBy(accessibility="ForYou-CellNumber-4") private IOSElement ForYouCellNumber4;
	@iOSFindBy(accessibility="ForYou-CellNumber-5") private IOSElement ForYouCellNumber5;
	@iOSFindBy(accessibility="ForYou-CellNumber-6") private IOSElement ForYouCellNumber6;
	@iOSFindBy(accessibility="ForYou-CellNumber-7") private IOSElement ForYouCellNumber7;
	@iOSFindBy(accessibility="ForYou-CellNumber-8") private IOSElement ForYouCellNumber8;
	@iOSFindBy(accessibility="ForYou-CellNumber-9") private IOSElement ForYouCellNumber9;
	@iOSFindBy(accessibility="ForYou-CellNumber-10") private IOSElement ForYouCellNumber10;
	@iOSFindBy(accessibility="ForYou-CellNumber-11") private IOSElement ForYouCellNumber11;
	@iOSFindBy(accessibility="ForYouTC-ShowMoreButton-UIButton") private IOSElement ForYouTCShowMoreButtonUIButton;
	@iOSFindBy(accessibility="ForYouTC-RecommendationButton-UIButton") private IOSElement ForYouTCRecommendationButtonUIButton;
	//My Stations - Favorite Stations
	@iOSFindBy(accessibility="MyStationsTab-CollectionView") private IOSElement MyStationsTabCollectionView; //Collection is the same AID as For You. 
	@iOSFindBy(accessibility="SAVED STATIONS") private IOSElement SavedStations; //Header at the top
	@iOSFindBy(accessibility="Favorites-CellNumber-0") private IOSElement FavoritesCellNumber0;
	@iOSFindBy(accessibility="Favorites-CellNumber-1") private IOSElement FavoritesCellNumber1;
	@iOSFindBy(accessibility="Favorites-CellNumber-2") private IOSElement FavoritesCellNumber2;
	@iOSFindBy(accessibility="Favorites-CellNumber-3") private IOSElement FavoritesCellNumber3;
	@iOSFindBy(accessibility="Favorites-CellNumber-4") private IOSElement FavoritesCellNumber4;
	@iOSFindBy(accessibility="Favorites-CellNumber-5") private IOSElement FavoritesCellNumber5;
	@iOSFindBy(accessibility="Favorites-CellNumber-6") private IOSElement FavoritesCellNumber6;
	@iOSFindBy(accessibility="Favorites-CellNumber-7") private IOSElement FavoritesCellNumber7;
	//My Stations - Recent Stations
	@iOSFindBy(accessibility="RECENTLY PLAYED") private IOSElement RecentlyPlayed; //Header at the top
	@iOSFindBy(accessibility="Recents-CellNumber-0") private IOSElement RecentsCellNumber0;
	@iOSFindBy(accessibility="Recents-CellNumber-1") private IOSElement RecentsCellNumber1;
	@iOSFindBy(accessibility="Recents-CellNumber-2") private IOSElement RecentsCellNumber2;
	@iOSFindBy(accessibility="Recents-CellNumber-3") private IOSElement RecentsCellNumber3;
	@iOSFindBy(accessibility="Recents-CellNumber-4") private IOSElement RecentsCellNumber4;
	@iOSFindBy(accessibility="Recents-CellNumber-5") private IOSElement RecentsCellNumber5;
	@iOSFindBy(accessibility="Recents-CellNumber-6") private IOSElement RecentsCellNumber6;
	@iOSFindBy(accessibility="Recents-CellNumber-7") private IOSElement RecentsCellNumber7;
	@iOSFindBy(accessibility="Recents-CellNumber-8") private IOSElement RecentsCellNumber8;
	@iOSFindBy(accessibility="Favorites-ShowMoreButton-UIButton") private IOSElement FavoritesShowMoreButtonUIButton;
	//Local Radio
	@iOSFindBy(accessibility="LocalRadioTab-CollectionView") private IOSElement LocalRadioTabCollectionView;
	@iOSFindBy(accessibility="LocalRadio-CellNumber-0") private IOSElement LocalRadioCellNumber0;
	@iOSFindBy(accessibility="LocalRadio-CellNumber-1") private IOSElement LocalRadioCellNumber1;
	@iOSFindBy(accessibility="LocalRadio-CellNumber-2") private IOSElement LocalRadioCellNumber2;
	@iOSFindBy(accessibility="LocalRadio-CellNumber-3") private IOSElement LocalRadioCellNumber3;
	@iOSFindBy(accessibility="LocalRadio-CellNumber-4") private IOSElement LocalRadioCellNumber4;
	@iOSFindBy(accessibility="LocalRadio-CellNumber-5") private IOSElement LocalRadioCellNumber5;
	@iOSFindBy(accessibility="LocalRadio-CellNumber-17") private IOSElement LocalRadioCellNumber17;
	
	
	// MyMusic Stuff
	//Songs Button ->List of all songs
	//Albums Button -> List of all albums
	//Artists Button -> List of all artists in alphabetical order
	//Playlists Header
	// Create New (playlist) button
	//Create New Playlist Modal (Playlist Name) - Cancel, Create
	//Empty playlist = default playlist icon - name, # songs
	//List of Playlists 
	//Show All Playlists Button on bottom. 
	
	//Playlist Profile ->
	//Playlist Image
	//Playlist name
	//Playlist last modified date
	//Playlist ## songs * length
	//Offline Toggle (AA)  -> Clicking it puts ICcons next to each song near Artist- turn blue as they download - probably impossible in automated testing. 
	//List of songs
	//Song 1 = Album image, title, artist * Album name
	//Overflow button -> 
		//Add to Playlist -> Opens Add to Playlist with Create New Playlist and List of Playlists, and Cancel Button
		//Go to Artist ->Opens Artist Profile
		//Go to Album -> Opens Album Profile
	    //Remove from Playlist -> disappears from playlist
	//top of playlist = Back Button + Playlist name, Overflow Button
		//Playlist image, playlist name, downloaded icon, ## songs
		//Edit ->  Remove Buttons next to Songs, Move buttons, Cancel Button, Done Button
		//Rename -> Rename Playlist Modal, Give your playlist a new name. Textfield, Cancel, Rename
		//Add to Another Playlist
		//Delete Playlist
		// Cancel
	
	
	//Want your local radio?
	//Tell us where you are & we'll get your favorite DJs
	//Use Location - Allow / Don't Allow
	//Use ZIP
	//No Thanks
	// Use the getListItem(int x) method to get these items. 
	//private final String listItemXpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[XXXXX]";
	
	/**
	 * Title: Take Control of the Radio, 'X' button, 
	 * 'Free Trial' Button, 
	 * 
	 */
	@iOSFindBy(accessibility="Take Control of the Radio") private IOSElement takeControlOfTheRadioTitle;
	@iOSFindBy(accessibility="X") private IOSElement forYouUpsellCloseX;
	@iOSFindBy(accessibility="Free Trial") private IOSElement freeTrialUpsellButton;
	@iOSFindBy(accessibility="Play any song, unlimited skips, replay and save songs directly from the radio") private IOSElement upsellMessage;
	
	public void clickFreeTrialUpsellButton(){
		System.out.println("clickFreeTrialUpsellButton().");
		freeTrialUpsellButton.click();
	}
	
	public boolean isCurrentlyOnPlusAccountLogo(){
		return isCurrentlyOn("isCurrentlyOnPlusAccountLogo",iheartradio_logo_full_plus);
	}
	public boolean isCurrentlyOnAllAccessAccountLogo(){
		return isCurrentlyOn("isCurrentlyOnAllAccessAccountLogo",iheartradio_logo_full_allaccess);
	}
	public boolean isCurrentlyOnFreeAccountLogo(){
		return isCurrentlyOn("isCurrentlyOnFreeAccountLogo",iheartradio_logo_full);
	}
	
	
	/**
	 * 
	 */
	public void printForYouElements(){ 
		System.out.println("::::printForYouElements() on HomePage -> NavBar");
		printElementInformation(IHRiPhoneHomePageView);
		printElementInformation(NavBarSideMenuButtonUIButton);
		//printElementInformation(iheartradio_logo_full);
		//printElementInformation(IHRCastingBarButtonItemUIButton);
	/*	printElementInformation(NavBarSearchBarButtonUIButton);
		printElementInformation(HomeSegmentedControlTitleLabelUIButtonForYou);
		printElementInformation(HomeSegmentedControlTitleLabelUIButtonMyStations);
		printElementInformation(HomeSegmentedControlTitleLabelUIButtonMyMusic); */
		
		printElementName(NavBarSearchBarButtonUIButton);
		printElementName(HomeSegmentedControlTitleLabelUIButtonForYou);
		printElementName(HomeSegmentedControlTitleLabelUIButtonMyStations);
		printElementName(HomeSegmentedControlTitleLabelUIButtonMyMusic);
		//FOR YOU Cells
		System.out.println("::::Free Trial Upsell Message");
		printElementInformation(takeControlOfTheRadioTitle);
		//printElementInformation(forYouUpsellCloseX);
		printElementName(freeTrialUpsellButton);
		printElementName(upsellMessage);
		System.out.println("::::printForYouElements() on HomePage -> For You Cells");
		printElementName(ForYouTabCollectionView);
		printElementName(ForYouCellNumber0);
		printElementName(ForYouCellNumber1);
		printElementName(ForYouCellNumber2);
/*		printElementName(ForYouCellNumber3);
		printElementName(ForYouCellNumber4);
		printElementInformation(ForYouCellNumber5);
		printElementInformation(ForYouCellNumber6); */
		System.out.println("::::showAllElements() on HomePage -> For You Second Page Cells");
		scrollDown();
/*		printElementInformation(ForYouCellNumber7);
		printElementInformation(ForYouCellNumber8);
		printElementInformation(ForYouCellNumber9);
*/		scrollDown();
		scrollDown();
/*		printElementInformation(ForYouCellNumber10);
		printElementInformation(ForYouCellNumber11);
		printElementInformation(ForYouTCShowMoreButtonUIButton);
*/		//Clicking Show More opens 12 more cells. 
		printElementName(ForYouTCRecommendationButtonUIButton);
	}
	/**
	 * Prints out the elements on the My Stations Tab. 
	 * Currently works with test66//@Test.com/test
	 */
	public void printMyStationsElements(){ 
		System.out.println("::::showAllElements() on HomePage -> My Stations -> Favorites");// Should be 4 artist radios, one Favorites Radio, and 2 Radio Stations (based on what I favorited).
		printElementInformation(MyStationsTabCollectionView); //Collection is the same AID as For You. 
		printElementInformation(SavedStations); //Header at the top - Now says Saved Stations instead of Favorite Stations
		printElementName(FavoritesCellNumber0);
		printElementName(FavoritesCellNumber1);
		//sk - 2/10 - commenting out a few that can be added back for regression
		//at this point, the test that Saved Stations are seen under My Stations is verified
	/*	printElementInformation(FavoritesCellNumber2);
		printElementInformation(FavoritesCellNumber3);
		printElementInformation(FavoritesCellNumber4);
		printElementInformation(FavoritesCellNumber5);
		printElementInformation(FavoritesCellNumber6); */
		scrollDown();
		//My Stations - Recent Stations
		System.out.println("::::showAllElements() on HomePage -> My Stations -> Recents");
		printElementName(RecentlyPlayed); //Header at the top
		printElementName(RecentsCellNumber0);
		printElementName(RecentsCellNumber1);
		printElementName(RecentsCellNumber2);
/*		scrollDown();
		printElementInformation(RecentsCellNumber3);
		printElementInformation(RecentsCellNumber4);
		printElementInformation(RecentsCellNumber5);
		printElementInformation(RecentsCellNumber6);
		scrollDown();
		printElementInformation(RecentsCellNumber7);
		printElementInformation(RecentsCellNumber8);
		scrollDown();
		scrollDown();
		printElementInformation(FavoritesShowMoreButtonUIButton);
*/
	}
	private enum CellStrings {
		LOCALRADIO("LocalRadio"), RECENTS("Recents"), FAVORITES("Favorites"), FORYOU("ForYou");
		private final String stringValue;
		private CellStrings (final String s){
			stringValue = s;
		}
		public String toString(){return stringValue;}
		
	}
	/**
	 * Pass in a type of CellStrings and the Cell you want to create an IOSElement associated to the AccessibilityIdentifier in the Collection.
	 * Can take LocalRadio, Recents, Favorites, or ForYou.
	 * cellInArray can be any int 0 or greater. Most pages have 5 to 20 Cells. Remember that 0 is the first cell in the collection. 
	 * -createIOSElementOnHomePageForCell(CellStrings.FAVORITES.toString() , 3);
	 * @param type
	 * @param cellInArray
	 * @return
	 */
	public IOSElement createIOSElementOnHomePageForCell(String type, int cellInArray ){
		String create = type + "-CellNumber-" + cellInArray;
		System.out.println("createIOSElementOnHomePageForCell() : "+ create );
		return findElement(driver, MobileBy.AccessibilityId(create));
	}
	/**
	 * Must be on HomePage - Clicks the For You Tab
	 */
	public void clickForYouTab(){
		System.out.println("clickForYouTab().");
//		IOSElement blah = 
		createIOSElementOnHomePageForCell(CellStrings.FAVORITES.toString() , 3);
		HomeSegmentedControlTitleLabelUIButtonForYou.click();
	}
	/**
	 * Must be on HomePage - Clicks on the My Stations Tab
	 */
	public void clickMyStationsTab() {
		System.out.println("clickMyStationsTab().");
		HomeSegmentedControlTitleLabelUIButtonMyStations.click();
	}
	/**
	 * Clicks on My Music Tab
	 * Also enters Zip for local radio. 
	 */
	public void clickMyMusicTab(){
		System.out.println("clickLocalRadioTab(). Then Entering Zip.");
		HomeSegmentedControlTitleLabelUIButtonMyMusic.click();
		Page.enterZip();
	}
	
	/**
	 * Checks to see if the Hamburger Button that can access the Sidebar is displayed. 
	 * @return
	 */
	public boolean isHamburgerButtonDisplayed(){
		return isCurrentlyOn("isHamburgerButtonDisplayed", NavBarSideMenuButtonUIButton);
	}
	/**
	 * Checks to see if the For You Tab is displayed. Can be on For You, My Stations, Local Radio etc so be careful. 
	 * @return
	 */
	public boolean isCurrentlyOnHomePage(){
		return isCurrentlyOn("isCurrentlyOnHomePage", HomeSegmentedControlTitleLabelUIButtonForYou);
	}
	/**
	 * Checks to see if the For You Tab Collection view is open. This is only visible when the For You Button has been clicked. It is also the first page opened after login / genre picker.
	 * @return
	 */
	public boolean isCurrentlyOnForYouTab(){
		return isCurrentlyOn("isCurrentlyOnForYouTab", ForYouTabCollectionView);
	}
	/**
	 * Checks to see if the My Stations Collection View is Open. Reach it by clicking on My Stations. 
	 * @return
	 */
	public boolean isCurrentlyOnMyStationsTab(){
		return isCurrentlyOn("isCurrentlyOnMyStationsTab", MyStationsTabCollectionView);
	}
	

	/**
	 * Checks to see if Local Radio Collection View is open (displayed). Reach it by clicking on Local Radio. This view will eventually be replaced by My Music. 
	 * @return
	 */
	public boolean isCurrentlyOnLocalRadioTab(){
		return isCurrentlyOn("isCurrentlyOnLocalRadioTab", LocalRadioTabCollectionView);
	}

	/**
	 * Clicks the Hamburger / SideBar Icon to open or Close the Side Menu. Doesn't concern itself with original state. 
	 */
	public void clickHamburgerButtonToOpenSideMenu(){
		System.out.println("clickHamburgerButtonToOpenSideMenu()...");
		NavBarSideMenuButtonUIButton.click();
	}
	/**
	 * Clicks the Search Icon to open Search. Use SearchPage object hereafter.
	 * sk - 1/21/17 - changed to return Error as it failed constantly after login
	 */
	public Errors clickNavBarSearchButtonToOpenSearch(){
		Errors err = new Errors();
		System.out.println("clickNavBarSearchButtonToOpenSearch()...");
		if (waitForElementToBeVisible(NavBarSearchBarButtonUIButton, 2))
				NavBarSearchBarButtonUIButton.click();
		else
			err.add("Could not click Search icon as it was not visible", "clickNavBarSearhButtonToOpenSearch");
		return err;
	}
	
	/**
	 * Clicks the Casting Button to Connect streaming to a device. 
	 */
	public void clickCastingBarButtonToConnectADevice(){
		System.out.println("clickCastingBarButtonToConnectADevice()...");
		IHRCastingBarButtonItemUIButton.click();
	}
	
	/**
	 * Clicks the Show More Button on For You. Make sure the SIMULATOR has scrolled down all the way to make the Button visible first. 
	 */
	public void clickForYouShowMoreButton(){
		System.out.println("clickForYouShowMoreButton()");
		ForYouTCShowMoreButtonUIButton.click();
	}
	
	/**
	 * scrollDown really just Swipes up. A swipe up covers about 3.5 cells on the iPhone. So two of these scrollDown calls will swipe up 7 cells. Test it thoroughly.
	 */
	public static void scrollDown(){
		System.out.println("scrollDown() : Swiping Up Once.");
		TouchAction ta1 = new TouchAction(driver);
		MultiTouchAction ma = new MultiTouchAction(driver);
		ta1.press(100, 250).waitAction(1000).moveTo(0, -200).release();
		ma.add(ta1).perform();
	}
	
	/**
	 * scrollUp really just Swipes up. A swipe up covers about 3.5 cells on the iPhone. So two of these scrollDown calls will swipe up 7 cells. Test it thoroughly.
	 */
	public static void scrollUp(){
		System.out.println("scrollDown() : Swiping Up Once.");
		TouchAction ta1 = new TouchAction(driver);
		MultiTouchAction ma = new MultiTouchAction(driver);
		ta1.press(100, 550).waitAction(1000).moveTo(0, 200).release();
		ma.add(ta1).perform();
	}
	
	/**
	 * ScrollToTop just calls SwipeDown 4 times. For particularly long collection views, use it more. Test as needed. 
	 */
	public static void scrollToTop(){
		System.out.println("scrollToTop() : Swiping Down Four times. May not necessarily reach top.");
		for(int i = 0; i < 4; i++){
			swipeDown();
		}
	}
	

	/**
	 * Assume that page is on HomePage - My Stations - Scrolled to top
	 */
	public String getTextOfFirstFavorite(){
		if(homePage.isCurrentlyOnMyStationsTab()){
			return getElementText(FavoritesCellNumber0);
		}
		return "Not currently on HomePage - For you. ";
	}
	
	/**
	 * Assume that page is on HomePage - My Stations - Scrolled to top
	 * @return
	 */
	public String getTextOfFirstRecent(){
		if(homePage.isCurrentlyOnMyStationsTab()){
			scrollDown();
			return getElementText(RecentsCellNumber0);
		}
		return "Not currently on HomePage - For you. ";
	}
	/**
	 * Assume SIMULATOR is on HomePage - My Stations
	 * @return
	 */
	public boolean clickFirstFavoriteStationOnMyStationsToBeginPlaying(){
		if(homePage.isCurrentlyOnMyStationsTab()){
			System.out.println("clickFirstFavoriteStationOnMyStationsToBeginPlaying() : "+ FavoritesCellNumber0.getText());
			FavoritesCellNumber0.click();
			return miniPlayer.isCurrentlyOnMiniPlayer() || fullPlayer.isCurrentlyOnFullPlayer(); 
		}
		return false;
	}
	/**
	 * Assume SIMULATOR is on HomePage - My Stations
	 * @return
	 */
	public boolean clickCertainCellOnMyStationsToBeginPlaying(int cellNumber){
		if(homePage.isCurrentlyOnMyStationsTab()){
			IOSElement station = createIOSElementOnHomePageForCell("Favorites", cellNumber);
			
			System.out.println("clickCertainCellOnMyStationsToBeginPlaying(). ");//+ station.getAttribute("value"));
			station.click();
			return  miniPlayer.isCurrentlyOnMiniPlayer() || fullPlayer.isCurrentlyOnFullPlayer(); 
		}
		return false;
	}
	/**
	 * Assume SIMULATOR is on My Stations. It will scroll down and click on the first Recents Cell. Make sure to use an account that has Recents. 
	 * @return
	 */
	public boolean clickFirstRecentStationOnMyStationsToBeginPlaying(){
		if(homePage.isCurrentlyOnMyStationsTab()){
			scrollDown();
			System.out.println("clickFirstRecentStationOnMyStationsToBeginPlaying() : "+ RecentsCellNumber0.getText());
			RecentsCellNumber0.click();
			return miniPlayer.isCurrentlyOnMiniPlayer() || fullPlayer.isCurrentlyOnFullPlayer();
		}
		return false;
	}
	/**
	 * Assume Simulator is on HomePage - Local Radio
	 * @return
	 */
	public boolean clickFirstLocalRadioStationOnLocalRadioToBeginPlaying(){
		
		if(homePage.isCurrentlyOnLocalRadioTab()){
			
			System.out.println("clickFirstRecentStationOnMyStationsToBeginPlaying() : "+ LocalRadioCellNumber0.getText());
			LocalRadioCellNumber0.click();
			return miniPlayer.isCurrentlyOnMiniPlayer() || fullPlayer.isCurrentlyOnFullPlayer();
		}
		return false;
	}
	/**
	 * Assume Simulator is on HomePage - For You
	 * @return
	 */
	public boolean clickFirstStationOnForYouToBeginPlaying(){
	 
		if(homePage.isCurrentlyOnForYouTab()){
			System.out.println("clickFirstRecentStationOnMyStationsToBeginPlaying() : "+ ForYouCellNumber0.getText());
			ForYouCellNumber0.click();
			return miniPlayer.isCurrentlyOnMiniPlayer() || fullPlayer.isCurrentlyOnFullPlayer(); 
		}
		return false;
	}
	
	/**
	 * Pass in an IOSElement and get the element's text, print it out, and return as a String. 
	 * @param element
	 * @return
	 */
	private String getElementText(IOSElement element){
		if(element!= null){
			String text = element.getText();
			System.out.println("getTextOf() : "+text);
			return text;
		}
		return "Element was null";
	}
	/**
	 * This is a Popup that appears over HomePage, thus moving/adding it here. Clicks 'Get Notifications' or 'Maybe Later'
	 * @param stayConnected
	 */
	public void chooseStayConnected(boolean stayConnected) {
		try {
			if (stayConnected)
				waitForVisible(driver, By.name("Get Notifications"), 2).click();
			else
				waitForVisible(driver, By.name("Maybe Later"), 2).click();
		} catch (Exception e) {
		}
	}
	
	public void swipeFirstForYouStationToLeft(){
		if(homePage.isCurrentlyOnForYouTab()){
			System.out.println("swipeFirstForYouStationToLeft() ");
			ForYouCellNumber0.swipe(SwipeElementDirection.LEFT, 700);
			//None of the following are visible to Appium. 
			//IOSElement addToFavorite = waitForVisible(driver, By.name("Add To Favorites"), 5);
			//IOSElement NotforMe = waitForVisible(driver, By.name("Not for Me"), 5);
			//IOSElement Unfavorite = waitForVisible(driver, By.name("Unfavorite"), 5);
		}
	}

	public void printMyMusicElements() {
		// TODO Auto-generated method stub
		
	}
	
	//############################################## OLD METHODS #####################################
	// Behavior Methods
	/*
	public String toggleListItemFavorites(int x){
		return toggleListItemFavorites(x, false);
	}
	public String toggleListItemFavorites(int x, boolean removing){
		System.out.println("toggleListItemFavorites() - Swipes item to left, Adds to Favorites if visible");
		Errors err = new Errors();
		IOSElement item = getListItem(x);
		if(item != null){
			// Expose the hidden buttons with a swipe
			swipeOnItem(item, LEFT);
			toggleFavorites(item, x, removing);
		}
		else{
			err.add("Selected item was not visible on the screen.", "toggleListItemFavorites");
		}
		System.out.println("Done toggling favorites...");
		return err.getErrors();
	}
	*/
	/*
	private String toggleFavorites(IOSElement item, int x, boolean remove){
		/* 
		 * Button width ratio to item ratio is 0.24154589372
		 * Since our developers did not give us a way to easily access this...
		 * 1) Open an item
		 * 2) Is it favorited? Skip to step 7
		 * 3) Is it not a favorite? Make it a favorite
		 * 4) Go back
		 * 5) Go into same station, now at position 1
		 * 6) Un favorite
		 * 7) Go back
		 * 8) Swipe
		 * 9) Click button 2 to toggle
		 * *All of this could be done in one line if we had a name/xpath for these elements *
		
		if(!isVisible(item) || !isEnabled(item)){
			item = null;
			item = getListItem(x);
		}
		String returnMessage = "";
		int width = item.getSize().getWidth();
		int height = item.getSize().getHeight();
		int ix = item.getLocation().getX();
		int iy = item.getLocation().getY();
		double ratio = 0.24154589372;
		int firstButtonX = (int) ((ix + width) - (((double) width * ratio) * 2));
		int secondButtonX = (int) ((ix + width) - ((double) width * ratio));
		// Find the center of each button
		int clickFirstButtonX = (firstButtonX + secondButtonX) / 2;
		int clickSecondButtonX = (secondButtonX + (ix + width)) / 2;
		int clickY = iy + (height / 2);
		
		int tries = 0;
		boolean execute = false;

		if(!isVisible(homePage.getRecent()) || 
				!homePage.isStationARecent(x)){
			do{
				tries++;
				item = null;
				item = getListItem(x);
				click(driver, item);
				if (!player.isPlayingInPlayer()){
					click(driver, item);
				}
//				Player.waitForTrackToLoad();
				if(!player.isFavorite()){
					handlePossiblePopUp();
					player.doFavorite();
					player.minimizePlayer();
					item = null;
					item = getListItem(1);
					x = 1;
					returnMessage = "1";
					item.click();
					player.unFavorite();
				}
				player.minimizePlayer();
				item = null;
				item = getListItem(x);
				if(item == null){
					System.err.println("Item is still null!");
				}
				// Now we can swipe and click button 2
				// Intentionally doubled up, to reduce chance of failure (doesn't always swipe, Appium has consistency issues with swiping)nd 
				swipeOnItem(item, LEFT);
				swipeOnItem(item, LEFT); 
				sleep(750); // Since we can't wait for visible
				// Get the name of the station
				String text = item.getText();
				if(!execute)
					driver.tap(1, clickSecondButtonX, clickY, 300);
				else
					driver.tap(1, clickFirstButtonX, clickY, 300);
				item = null;
				item = getListItem(x);
				// If the name isn't the same, we need to re-try, because it unfavorited
				if(item == null){
					returnMessage += "\nCould not load item while trying to toggle favorite status."; 
				}
				else if(!remove && strGood(text) && !text.equals(item.getText())){ 
					// The item was removed, retry with the first button
					execute = true;
				}
			}while(tries < 2 && execute);
		}
		else{
			driver.tap(1, clickFirstButtonX, clickY, 300);
		}
		return returnMessage;
	}
	
	*/
	/*
	public boolean removeFavorite(int itemToRemove){
		System.out.println("removeFavorite("+ itemToRemove + ")");
		boolean removedFavorite = false;
		// First assert that it is a favorite
		IOSElement favorites = waitForVisible(driver, By.name("Favorite Stations"), 10);
		if(favorites != null && isVisible(favorites) && favorites.getText().equals("Favorite Stations")){
			int recentY = getRecentY();
			IOSElement item = getStationFromList(itemToRemove);
			if(item != null){
				int x = item.getLocation().getX();
				int y = item.getLocation().getY();
				if(y < recentY){
					int w = item.getSize().getWidth();
					int h = item.getSize().getHeight();
					int clickX = x + w - (w / 10);
//					int swipeToX = x + w - (w / 2);
					int clickY = y + h - (h / 2);
					// Swipe to reveal unfavorite
//					driver.swipe(clickX, clickY, swipeToX, clickY, 500);
					TestRoot.swipeOnItem(item, LEFT);
					// Tap unfavorite
					driver.tap(1, clickX, clickY, 150);
					removedFavorite = true;
				}
				else{
					return false;
				}
			}
		}
		
		return removedFavorite;
	}
	
	 */
	

	


}
