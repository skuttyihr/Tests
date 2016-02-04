package com.iheart.appium.iosAutomation;

import java.util.HashSet;
import java.util.Set;

//import org.apache.log4j.Logger;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;

public class Page extends TestRoot{

	// Search field
	@iOSFindBy(name = "Search") public IOSElement searchButton;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]") public IOSElement searchField;
	@iOSFindBy(name = "Cancel") public IOSElement cancel;

	// SUB NAVIGATION bar
	@iOSFindBy(name = "My Stations") public IOSElement myStations;
	@iOSFindBy(name = "For You") public IOSElement forYou;
	@iOSFindBy(name = "Perfect For") public IOSElement perfectFor;

	static IOSDriver<IOSElement> driver;
	static SideNavigationBar sideNavigationBar;
	static Player player;
	// Real device requires longer reponse time
	static boolean isRealDevice = false;
//	Logger logger = Logger.getLogger(Page.class);

	static final String USER_NAME = "iheartrocks999@gmail.com";
	static final String PASSWORD = "iheart001";
	static final String FACEBOOK_USER_NAME = USER_NAME;
	static final String GOOGLE_USER_NAME = USER_NAME;

	public static final String screenshot_folder = "iosScreenshots";

	public Page() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public Page(IOSDriver<IOSElement> _driver) {
		Page.driver = _driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// navBar = PageFactory.initElements(driver, SideNavigationBar.class);
		// player = PageFactory.initElements(driver, Player.class);
	}

	// The popup: Like iHeartRadio? Let us know!
	public void likeIheart() {

	}

	public static void setDriver(IOSDriver<IOSElement> _driver) {
		driver = _driver;
	}

	public static void setPlayer(Player _player) {
		player = _player;
	}

	public static void setSideNavigationBar(SideNavigationBar _sideNavigationBar) {
		sideNavigationBar = _sideNavigationBar;
	}

	public void waitForPreroll() {
	}

	public String switchWindow() {
		// Switch to new tab where the sign-up is
		String winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		return winHandleBefore;
	}

	public Set<String> getContextHandles() {
		Set<String> contexts = new HashSet<String>();
		try{
			contexts = driver.getContextHandles(); // Errors here
		}
		catch(Exception e){
		}

//		for (String context : contexts){
//			System.out.println(context);
//		}

		return contexts;
	}
	
	private static int getRecentY(){
		int recentY = 100000;
		try{
			recentY = waitForVisible(driver, 
								find(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[2]", "xpath"), 
								2).getLocation().getY();
		}
		catch(Exception e){
			IOSElement testElement = waitForVisible(driver, 
					find(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[1]", "xpath"), 
					2);
			if(testElement != null){
				if(testElement.getText().equalsIgnoreCase("Recent Stations")){
					recentY = testElement.getLocation().getY();
				}
			}
		}
		return recentY;
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
		IOSElement favorites = waitForVisible(driver, find(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[1]", "xpath"), 10);
		if(favorites != null && favorites.getText().equalsIgnoreCase("Favorite Stations")){
			int recentY = getRecentY();
			for(int i = 1; i <= 25; i++){
				IOSElement item = getStationFromList(i);
				if(item.getText().contains(artist)){
					if(item.getLocation().getY() < recentY){
						foundStation = i;
					}
					break;
				}
			}
		}
		
		return foundStation;
	}
	
	public static boolean removeFavorite(int itemToRemove){
		boolean removedFavorite = false;
		// First assert that it is a favorite
		IOSElement favorites = waitForVisible(driver, find(driver, "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[1]", "xpath"), 10);
		if(favorites != null){
			int recentY = getRecentY();
			IOSElement item = getStationFromList(itemToRemove);
			if(item != null){
				int x = item.getLocation().getX();
				int y = item.getLocation().getY();
				if(y < recentY){
					int w = item.getSize().getWidth();
					int h = item.getSize().getHeight();
					int clickX = x + w - (w / 10);
					int swipeToX = x + w - (w / 2);
					int clickY = y + h - (h / 2);
					// Swipe to reveal unfavorite
					driver.swipe(clickX, clickY, swipeToX, clickY, 500);
					// Tap unfavorite
					driver.tap(1, clickX, clickY, 150);
					removedFavorite = true;
				}
			}
		}
		
		return removedFavorite;
	}
	
	public static void removeAllFavorites(){
		IOSElement itemToRemove = getStationFromList(1);
		int count = 100; // let's be safe here
		while(itemToRemove != null && count > 0){
			count--;
			if(!removeFavorite(1)){
				break;
			}
		}
	}
	
	public static IOSElement getStationFromList(int selector){
		String xpathForItem = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + selector + "]";
		return waitForVisible(driver, find(driver, xpathForItem, "xpath"), 5);
	}
}
