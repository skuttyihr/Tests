package com.iheart.appium.iosAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;


import io.appium.java_client.MobileBy;
import io.appium.java_client.SwipeElementDirection;
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
	@iOSFindBy(accessibility = "IHRCastingBarButtonItem-UIButton") private IOSElement IHRCastingBarButtonItemUIButton;
	@iOSFindBy(accessibility = "NavBar-SearchBarButton-UIButton") private IOSElement NavBarSearchBarButtonUIButton;
	@iOSFindBy(accessibility="HomeSegmentedControl-TitleLabel-UIButton-For You") private IOSElement HomeSegmentedControlTitleLabelUIButtonForYou;
	@iOSFindBy(accessibility="HomeSegmentedControl-TitleLabel-UIButton-My Stations") private IOSElement HomeSegmentedControlTitleLabelUIButtonMyStations;
	@iOSFindBy(accessibility="HomeSegmentedControl-TitleLabel-UIButton-Local Radio") private IOSElement HomeSegmentedControlTitleLabelUIButtonLocalRadio;
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
	@iOSFindBy(accessibility="Favorite Stations") private IOSElement FavoriteStations; //Header at the top
	@iOSFindBy(accessibility="Favorites-CellNumber-0") private IOSElement FavoritesCellNumber0;
	@iOSFindBy(accessibility="Favorites-CellNumber-1") private IOSElement FavoritesCellNumber1;
	@iOSFindBy(accessibility="Favorites-CellNumber-2") private IOSElement FavoritesCellNumber2;
	@iOSFindBy(accessibility="Favorites-CellNumber-3") private IOSElement FavoritesCellNumber3;
	@iOSFindBy(accessibility="Favorites-CellNumber-4") private IOSElement FavoritesCellNumber4;
	@iOSFindBy(accessibility="Favorites-CellNumber-5") private IOSElement FavoritesCellNumber5;
	@iOSFindBy(accessibility="Favorites-CellNumber-6") private IOSElement FavoritesCellNumber6;
	@iOSFindBy(accessibility="Favorites-CellNumber-7") private IOSElement FavoritesCellNumber7;
	//My Stations - Recent Stations
	@iOSFindBy(accessibility="Recent Stations") private IOSElement RecentStations; //Header at the top
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
	
	//Want your local radio?
	//Tell us where you are & we'll get your favorite DJs
	//Use Location - Allow / Don't Allow
	//Use ZIP
	//No Thanks
	// Use the getListItem(int x) method to get these items. 
	private final String listItemXpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[XXXXX]";
	
	/**
	 * This method has been specifically designed to go through all elements on the HomePage. 
	 * Currently works with test66@test.com/test
	 */
	public void showAllElements(){ 
		if(homePage.isCurrentlyOnHomePage()){
			printElementInformation(IHRiPhoneHomePageView);
			printElementInformation(NavBarSideMenuButtonUIButton);
			printElementInformation(iheartradio_logo_full);
			printElementInformation(IHRCastingBarButtonItemUIButton);
			printElementInformation(NavBarSearchBarButtonUIButton);
			printElementInformation(HomeSegmentedControlTitleLabelUIButtonForYou);
			printElementInformation(HomeSegmentedControlTitleLabelUIButtonMyStations);
			printElementInformation(HomeSegmentedControlTitleLabelUIButtonLocalRadio);
			//FOR YOU Cells
			printElementInformation(ForYouTabCollectionView);
			printElementInformation(ForYouCellNumber0);
			printElementInformation(ForYouCellNumber1);
			printElementInformation(ForYouCellNumber2);
			printElementInformation(ForYouCellNumber3);
			printElementInformation(ForYouCellNumber4);
			printElementInformation(ForYouCellNumber5);
			printElementInformation(ForYouCellNumber6);

			scrollDown();
			printElementInformation(ForYouCellNumber7);
			printElementInformation(ForYouCellNumber8);
			printElementInformation(ForYouCellNumber9);
			printElementInformation(ForYouCellNumber10);
			printElementInformation(ForYouCellNumber11);
			scrollDown();
			printElementInformation(ForYouTCShowMoreButtonUIButton);
			//Clicking Show More opens 12 more cells. 
			printElementInformation(ForYouTCRecommendationButtonUIButton);
			//My Stations - Favorite Stations
			scrollToTop();

			homePage.clickMyStationsTab();
			printElementInformation(MyStationsTabCollectionView); //Collection is the same AID as For You. 
			printElementInformation(FavoriteStations); //Header at the top
			printElementInformation(FavoritesCellNumber0);
			printElementInformation(FavoritesCellNumber1);
			printElementInformation(FavoritesCellNumber2);
			printElementInformation(FavoritesCellNumber3);
			printElementInformation(FavoritesCellNumber4);
			printElementInformation(FavoritesCellNumber5);
			printElementInformation(FavoritesCellNumber6);

			//printElementInformation(FavoritesCellNumber7);
			scrollDown();
			//My Stations - Recent Stations

			printElementInformation(RecentStations); //Header at the top
			printElementInformation(RecentsCellNumber0);
			printElementInformation(RecentsCellNumber1);
			printElementInformation(RecentsCellNumber2);
			scrollDown();
			printElementInformation(RecentsCellNumber3);
			printElementInformation(RecentsCellNumber4);
			printElementInformation(RecentsCellNumber5);
			printElementInformation(RecentsCellNumber6);
			printElementInformation(RecentsCellNumber7);
			scrollDown();
			printElementInformation(RecentsCellNumber8);
			printElementInformation(FavoritesShowMoreButtonUIButton);
			scrollToTop();
			homePage.clickLocalRadioTab();
			//Local Radio
			printElementInformation(LocalRadioTabCollectionView);
			printElementInformation(LocalRadioCellNumber0);
			printElementInformation(LocalRadioCellNumber1);
			printElementInformation(LocalRadioCellNumber2);
			printElementInformation(LocalRadioCellNumber3);
			printElementInformation(LocalRadioCellNumber4);
			printElementInformation(LocalRadioCellNumber5);
			scrollDown();
			scrollDown();
			scrollDown();
			scrollDown();
			printElementInformation(LocalRadioCellNumber17);
		}

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
	 * Clicks on Local Radio Tab
	 * Also enters Zip for local radio. 
	 */
	public void clickLocalRadioTab(){
		System.out.println("clickLocalRadioTab(). Then Entering Zip.");
		HomeSegmentedControlTitleLabelUIButtonLocalRadio.click();
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
	 */
	public void clickNavBarSearchButtonToOpenSearch(){
		System.out.println("clickNavBarSearchButtonToOpenSearch()...");
		NavBarSearchBarButtonUIButton.click();
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
		swipeUp();
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
			
			System.out.println("clickCertainCellOnMyStationsToBeginPlaying() : "+ station.getText());
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
	
	//############################################## OLD METHODS #####################################
	private IOSElement getFavorite(){
		IOSElement favorite = null;
		for(int i = 1; i < 4; i++){
			IOSElement testElement = waitForVisible(driver, 
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[" + i + "]"),
					2);
			if(testElement != null){
				if(isVisible(testElement) && testElement.getText().equals("Favorite Stations")){
					favorite = testElement;
					break;
				}
			}
		}
		
		return favorite;
	}
	

	
	private IOSElement getRecent(){
		IOSElement recent = null;
		for(int i = 1; i < 4; i++){
			IOSElement testElement = waitForVisible(driver, 
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[" + i + "]"),
					2);
			if(testElement != null){
				if(isVisible(testElement) && testElement.getText().equals("Recent Stations")){
					recent = testElement;
					break;
				}
			}
		}
		
		return recent;
	}
	
	private int getRecentY(){
		int recentY = getAppHeight() + 1; 
		//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[1]
		IOSElement recent = getRecent();
		if(recent != null){
			recentY = recent.getLocation().getY();
		}
		else{
			IOSElement favorites = getFavorite();
			if(favorites == null){
				recentY = 0; // A low value, because there are no favorites, all are recents 
			}
		}
		
		return recentY;
	}
	
	
	public void gotoHome(){
		if(!isVisible(forYou)){
			if(isHamburgerButtonDisplayed()){
				sideNavBar.gotoHomePage();
			}
			else{
				clickNavBarBackButton();
				sideNavBar.gotoHomePage();
			}
		}
	}
	public void gotoMyStations() {
		gotoHome();
		myStations.click();
	}

	public void gotoForYou() {
		gotoHome();
		forYou.click();
	}
	
	public void gotoLocalRadio(){
		gotoHome();
		localRadio.click();
		quickDismissPopUp();
	}

	public void gotoPerfectFor() {
		gotoHome();
		perfectFor.click();
	}

	/**
	 * Xpath to work with: //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[XXXXX]
	 * 
	 * @param x
	 * @return
	 */
	public IOSElement getListItem(int x){
		IOSElement returnElement = findElement(driver, By.xpath(listItemXpath.replace("[XXXXX]", "[" + x + "]")));
		if(!isVisible(returnElement)){
			returnElement = waitForVisible(driver, 
								By.xpath(listItemXpath.replace("[XXXXX]", "[" + x + "]")),
								5
							);
		}
		return returnElement;
	}
	public String getListItemText(int x){
		String text = "";
		IOSElement listItem = getListItem(x);
		if(isVisible(listItem)){
			text = listItem.getText();
		}
		return text;
	}
	
	public boolean selectListItem(int x){
		IOSElement li = getListItem(x);
		if(isVisible(li)){
			li.click();
			return true;
		}
		return false;
	}
	
	public String getStationNameFromListItem(int x){
		IOSElement li = getListItem(x);
		if(isVisible(li)){
			String station = li.getText();
			if(strGood(station)){
				if(station.contains(",")){
					station = station.substring(0, station.indexOf(","));
				}
				return station;
			}
		}
		return "";
	}
	
	/**
	 * Removes all favorites, useful at the end of testing
	 */
	public void removeAllFavorites(){
		try{ // We don't want a test to fail if this has an issue
			System.out.println("Removing all favorites.");
			homePage.gotoMyStations();
			IOSElement itemToRemove = getStationFromList(1);
			if(itemToRemove == null){
				return; // No items to remove
			}
			int recent = getRecentY();
			if(recent <= itemToRemove.getLocation().getY()){
				return;
			}
			
			int count = 20; // let's be safe here
			while(itemToRemove != null && count > 0){
				count--;
				if(recent <= itemToRemove.getLocation().getY()){
					return;
				}
				if(!removeFavorite(1)){
					break;
				}
			}
		}
		catch(Exception e){
			System.err.println("\nCould not remove favorites!\n");
			e.printStackTrace();
		}
	}
	
	
	// Behavior Methods
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
		*/
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
	
	
	/**
	 * Returns an integer 1+ for the list item ONLY if it is a recent station
	 * @param artist
	 * @return
	 */
	public int isStationARecent(String artist){
		int station = -1;
		IOSElement recent = getRecent();
		if(isVisible(recent)){
			int recentY = recent.getLocation().getY();
			List<IOSElement> allMyStations = findElements(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell"));
			int i = 0;
			for(IOSElement test : allMyStations){
				i++;
				if(test != null && test.getText().length() <= 0){
					continue;
				}
				if(!isVisible(test)){
					break;
				}
				if(test.getText().toLowerCase().contains(artist.toLowerCase())){
					if(test.getLocation().getY() > recentY){
						station = i;
						break;
					}
				}
			}
		}
		return station;
	}
	
	public boolean isStationARecent(int n){
		IOSElement listItem = getListItem(n);
		if(isVisible(listItem)){
			if(listItem.getLocation().getY() > getRecentY()){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * gets the nth recent station, if possible
	 * If list item n is a recent station, return it, otherwise, return nothing
	 * @param n
	 * @return IOSElement, the list item
	 */
	public IOSElement getRecentStation(int n){
		int startOfRecents = -1;
		// Find first recent
		// Increment from there
		for(int i = 1; i < 20; i++){
			if(!isVisible(getListItem(i))){
				break;
			}
			if(isStationARecent(i)){
				startOfRecents = i;
				break;
			}
		}
		
		if(startOfRecents > 0){
			if(n == 1){
				return getListItem(startOfRecents);
			}
			else{
				IOSElement test = getListItem(startOfRecents + n);
				if(isVisible(test)){
					return test;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Always returns the first recent station (if it exists and is visible)
	 * @return
	 */
	public IOSElement getFirstRecentStation(){
		return getRecentStation(1);
	}
	
	/**
	 * Click my Station if on home
	 * Ensure there are favorite stations
	 * Get Y of "recent stations"
	 * Find the item matching the artist
	 * Get the Y of that artist
	 * If it's above recent stations: YES
	 * Return the item number, so we can use it later, if need be
	 */
	public int isStationAFavorite(String artist){
		System.out.println("Seeing if artist: '"+ artist + "' is a favorite.");
		int foundStation = -1;
		homePage.gotoMyStations();
		if(!driver.getPageSource().contains(artist)){
			System.out.println("foundStation is: "+ foundStation);
			return foundStation;
		}
		
		IOSElement favorites = waitForVisible(driver, find("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[1]", "xpath"), 3);
		if(favorites != null && favorites.getText().equalsIgnoreCase("Favorite Stations")){
			int recentY = getRecentY();
			List<IOSElement> allMyStations = findElements(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell"));
			
			int i = 1;
			for(IOSElement item : allMyStations){
				if(!isVisible(item)){
					break;
				}
				if(item.getLocation().getY() >= recentY){ 
					break;
				}
				if(item.getText().contains(artist)){ 
					foundStation = i;
					break;
				}
				
				i++;
			}
		}
		System.out.println("foundStation is: "+ foundStation);
		return foundStation;
	}
	
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
	
	public List<String> getVisibleListItems(){
		List<String> visibleItems = new ArrayList<String>();
		List<IOSElement> allItemsInContainer = findElements(driver, By.xpath(listItemXpath.replace("[XXXXX]", "")));
		boolean foundVisible = false;
		for(IOSElement item : allItemsInContainer){
			if(isVisible(item)){
				String itemName = item.getText();
				if(itemName.contains(",")){
					itemName = itemName.substring(0, itemName.indexOf(","));
				}
				visibleItems.add(itemName);
				foundVisible = true;
			}
			else if(foundVisible){
				break;
			}
		}
		
		return visibleItems;
	}
	
	public int searchForStation(String station){
		int foundStation = -1;
		
		if(driver.getPageSource().contains(station)){
			for(int i = 1; i < 17; i++){
				IOSElement item = getListItem(i);
				if(item.getText().contains(station)){
					foundStation = i;
					break;
				}
			}
		}
		return foundStation;
	}
	
	public String loadUpStations(){
		return loadUpStations(5);
	}
	public String loadUpStations(int n){
		Errors err = new Errors();
		
		sideNavBar.gotoHomePage();
		gotoForYou();
	
		for(int stations = 1; stations < n; stations++){
			IOSElement listItem = getListItem(stations);
			if(!isVisible(listItem)){
				break;
			}
			if(listItem.getText().contains("iHeartRadio Music Awards")){
				continue;
			}
			
			listItem.click();
			
			// If it was a favorites station, we're going to get a popup. Dismiss it
			if(isVisible(waitForVisible(driver, By.name("favorites_radio"), 1))){
				findElement(driver, By.name("Save")).click();
				waitForVisible(driver, By.name("Got It"), 2).click();
			}
			
			if(player.isPlayingInPlayer() 
					&& !player.minimizePlayer()){
				err.add("Could not minimize player.", "loadUpStations");
			}
		}
			
		
		if(player.isPlaying()){
			miniPlayer.clickPlayPauseButton();
		}
		return err.getErrors();
	}
}
