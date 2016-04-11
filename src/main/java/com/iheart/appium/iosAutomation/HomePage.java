package com.iheart.appium.iosAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

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

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[3]/UIAStatusBar[1]") public IOSElement statusBar;
	// Use the getListItem(int x) method to get these items. 
	private final String listItemXpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[XXXXX]";
	
	
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
		int recentY = 100; // When in doubt, remove nothing
		//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[1]
		IOSElement recent = getRecent();
		if(recent != null){
			recentY = recent.getLocation().getY();
		}
		
		return recentY;
	}
	
	
	public void gotoHome(){
		if(!isVisible(forYou)){
			if(isVisible(sideNavBar.navIcon)){
				sideNavBar.gotoHomePage();
			}
			else{
				getBack();
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
		Errors err = new Errors();
		IOSElement item = getListItem(x);
		if(item != null){
			// Expose the hidden buttons with a swipe
			swipeOnItem(item, LEFT);
			IOSElement add = waitForVisible(driver, By.name("Add to Favorites"), 2);
			if(!isVisible(add)){
				String message = toggleFavorites(item, x);
				err.add(message);
			}
			else{
				add.click();
			}
		}
		else{
			err.add("Selected item was not visible on the screen.");
		}
		
		return err.getErrors();
	}
	
	
	private String toggleFavorites(IOSElement item, int x){
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

		if(!homePage.isStationARecent(x)){
			do{
				tries++;
				if(!isVisible(item) || !isEnabled(item)){
					item = null;
					item = getListItem(x);
				}
				click(driver, item);
				if (!player.isPlayingInPlayer()){
					click(driver, item);
				}
				Player.waitForTrackToLoad();
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
				// Now we can swipe and click button 2
				swipeOnItem(item, LEFT);
				sleep(100); // Since we can't wait for visible
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
				else if(strGood(text) && !text.equals(item.getText())){
					//  The item was removed, retry with the first button
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
	
	
	public int isStationAFavorite(String artist){
		/*
		 * Click my Station if on home
		 * Ensure there are favorite stations
		 * Get Y of "recent stations"
		 * Find the item matching the artist
		 * Get the Y of that artist
		 * If it's above recent stations: YES
		 * Return the item number, so we can use it later, if need be
		 */
		int foundStation = -1;
		homePage.gotoMyStations();
		if(!driver.getPageSource().contains(artist)){
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
		
		return foundStation;
	}
	
	public boolean removeFavorite(int itemToRemove){
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
				err.add("Could not minimize player.");
			}
		}
			
		
		if(player.isPlaying()){
			miniPlayer.pause();
		}
		return err.getErrors();
	}
}
