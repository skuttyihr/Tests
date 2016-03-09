package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class HomePage extends Page {

	// Use the getListItem(int x) method to get these items. 
	private final String listItemXpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[XXXXX]";
	
	public HomePage() {
		super();
	}
	public HomePage(IOSDriver<IOSElement> _driver){
		super(_driver);
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
	}

	public void gotoPerfectFor() {
		gotoHome();
		perfectFor.click();
	}

	public IOSElement getListItem(int x){
		return waitForVisible(driver, 
					By.xpath(listItemXpath.replace("[XXXXX]", "[" + x + "]")),
					5
				);
	}
	
	
	// Behavior Methods
	
	public String toggleListItemFavorites(int x){
		Errors err = new Errors();
		IOSElement item = getListItem(x);
		if(item != null){
			// Expose the hidden buttons with a swipe
			swipeOnItem(item, 3);
			IOSElement add = waitForVisible(driver, By.name("Add to Favorites"), 5);
			if(add == null){
				String returnMessage = toggleFavorites(x);
				if(strGood(returnMessage) 
						&& !returnMessage.equals("added") 
						&& !returnMessage.equals("removed")){
					if(returnMessage.contains("Had to get out of player")){
						if(x != 1){
							return "switch to 1";
						}
						else{
							return "";
						}
					}
					err.add(returnMessage);
				}
				else{
					System.out.println(returnMessage);
				}
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
	
	
	private String toggleFavorites(int x){
		Errors err = new Errors();
		// TODO
		// Button width ratio to item ratio is 0.24154589372
		// Leftmost button is the add to favorites, unless it's already a favorite (Unfavorite) 
		// Unfavorite: will be the only button. 
		// Name: Station added to your favorites!
		// Name: Station deleted from favorites.
		/*
		 * The process:
		 * Find the X location of the first button in a pair
		 * Click it
		 * If the player loads, go back
		 * Grab the FIRST item this time, 
		 * Click the Second block. That should toggle. 
		 */
		IOSElement item = getListItem(x);
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
		
		// Start clicking (ok, tapping)
		driver.tap(1, clickFirstButtonX, clickY, 500);
		// First see if the growl came up
		IOSElement growlAdd = findElement(driver, By.name("Station added to your favorites!"));
		if(isVisible(growlAdd)){
			return "added";
		}
		IOSElement growlRemove = findElement(driver, By.name("Station added to your favorites!"));
		if(isVisible(growlRemove)){
			return "removed";
		}
		
		if(player.isPlaying()){
			player.minimizePlayer();
			err.add("Had to get out of player");
		}
		
		// Try again, there was only one swiped button
		item = getListItem(1); // The last played station is the first item
		swipeOnItem(item, 3);
		iy = item.getLocation().getY();
		clickY = iy + (height / 2);
		driver.tap(1, clickSecondButtonX, clickY, 500);
		Page.handlePossiblePopUp();
		
		return err.getErrors();
	}
}
