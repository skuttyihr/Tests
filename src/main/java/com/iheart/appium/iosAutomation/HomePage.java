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
			sideNavBar.gotoHomePage();
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
	
	public String addListItemToFavorites(int x){
		Errors err = new Errors();
		IOSElement item = getListItem(x);
		if(item != null){
			// Expose the hidden buttons with a swipe
			swipeOnItem(item, 3);
			IOSElement add = waitForVisible(driver, By.name("Add to Favorites"), 5);
			if(add != null){
				clickAddToFavorites(x);
			}
			else{
				err.add("Could not locate 'Add to Favorites' button after swiping.");
			}
		}
		else{
			err.add("Selected item was not visible on the screen.");
		}
		
		return err.getErrors();
	}
	
	
	private String clickAddToFavorites(int x){
		Errors err = new Errors();
		// T
		
		return err.getErrors();
	}
}
