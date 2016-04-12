package com.iheart.appium.iosAutomation;

//import org.apache.log4j.Logger;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class Page extends TestRoot{

	// LOGIN PROMPT
	@iOSFindBy(name = "Sign up for Free") protected IOSElement signUpPrompt;
	@iOSFindBy(name = "Create Account") protected IOSElement createAccount;
	
	// Zip Code info
	@iOSFindBy(name = "Use Location") public IOSElement useLocation;
	@iOSFindBy(name = "Allow") public IOSElement allowButton;
	@iOSFindBy(name = "Don't Allow") public IOSElement dontAllowButton;
	
	
	// SUB NAVIGATION bar
	@iOSFindBy(name = "My Stations") public IOSElement myStations;
	@iOSFindBy(name = "For You") public IOSElement forYou;
	@iOSFindBy(name = "Perfect For") public IOSElement perfectFor;
	@iOSFindBy(name = "Local Radio") public IOSElement localRadio;

	@iOSFindBy(name = "iheartradio_logo_full") public static IOSElement iheartradio_logo_full;
	
	static IOSDriver<IOSElement> driver;
	static SideNavigationBar sideNavigationBar;
	static Player player;
	// Real device requires longer reponse time
	static boolean isRealDevice = false;
//	Logger logger = Logger.getLogger(Page.class);

	// Shorter account, easier to type in
	static final String OLD_USER_NAME = "iheartrocks999@gmail.com";
	static final String OLD_PASSWORD = "iheart001";
	static final String USER_NAME = "ihrttr@gmail.com";
	static final String PASSWORD = "yrdy"; // test, one key to the right. Doesn't require caps or other keyboard changes for speed
	static final String FACEBOOK_USER_NAME = OLD_USER_NAME;
	static final String FACEBOOK_USER_PERSONAL_NAME = "Tony Sopranos";
	static final String FACEBOOK_PASSWORD = OLD_PASSWORD;
	static final String GOOGLE_USER_NAME = OLD_USER_NAME;

	public static final String baseListItemXpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell";
	
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

	public static IOSElement getStationFromList(int selector){
		String xpathForItem = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + selector + "]";
		return waitForVisible(driver, find(xpathForItem, "xpath"), 5);
	}
	
	// Want your local radio?
	public static void handlePossiblePopUp() {
		try{
			IOSElement dismiss = waitForVisible(driver, By.name("No Thanks"), 3);
			if(!isVisible(dismiss)){
				dismiss = findElement(driver, By.name("Maybe Later")); // Has already waited 3 seconds
			}
			if(isVisible(dismiss)){
				dismiss.click();
			}
		}catch(Exception e){} // No chance of this failing a test
	}
	public static void quickDismissPopUp(){
		IOSElement noThanks = findElement(driver, By.name("No Thanks"));
		IOSElement maybeLater = findElement(driver, By.name("Maybe Later"));
		if(isVisible(noThanks)){
			noThanks.click();
		}
		else if(isVisible(maybeLater)){
			maybeLater.click();
		}
	}
	
	public void useLocation(){
		if(!isVisible(useLocation)){
			waitForElementToBeVisible(useLocation, 5);
		}
		if(isVisible(useLocation)){
			useLocation.click();
			allowButton.click();
		}
	}
	public static void enterZip(){
		enterZip("");
	}
	public static void enterZip(String zip){
		if(!strGood(zip)){
			try{
				waitForVisible(driver, By.name("No Thanks"), 4).click();
			}
			catch(Exception e){}
		}
		IOSElement enterZip = waitForVisible(driver, find("Enter ZIP"), 7);
		if(enterZip != null && isVisible(enterZip)){
			enterZip.click();
			IOSElement zipCodeEntry = waitForVisible(driver, 
					find("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]/UIATextField[1]"),
					5);
			if(zipCodeEntry != null){
				zipCodeEntry.sendKeys(zip);
				driver.findElement(By.name("OK"));
			}
		}
	}
	
	public void getBack(){
		try{
			player.back.click();
		}
		catch(Exception e){}
		try{
			waitForVisible(driver, By.name("Back"), 1).click();
		}catch(Exception e){}
		try{
			search.cancel.click();
		}catch(Exception e){}
	}
	
	/**
	 * Scroll to the bottom of a list until a show more button displays
	 * @return
	 */
	public static boolean swipeToShowMore(){
		IOSElement showMore = null;
		for(int i = 0; i < 7; i++){
			swipeUp();
			showMore = findElement(driver, By.name("Show More"));
			if(isVisible(showMore)){
				break;
			}
			else{
				// There's a chance that we're on My Stations, and it found the For You show more button by name
				showMore = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[4]"));
				if(isVisible(showMore)){
					break;
				}
			}
		}
		
		if(showMore == null){
			return false;
		}
		swipeUp(); // In case mini player is hiding it
		return true;
	}
	
	public static boolean clickShowMore(){
		IOSElement showMore = findElement(driver, By.name("Show More"));
		IOSElement showMoreMyStations = findElement(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[4]"));
		if(isVisible(showMore)){
			showMore.click();
			return true;
		}
		else if(isVisible(showMoreMyStations)){
			showMoreMyStations.click();
			return true;
		}
		else{
			swipeToShowMore();
			showMore = waitForVisible(driver, By.name("Show More"), 2);
			if(isVisible(showMore)){
				showMore.click();
				return true;
			}
		}
		
		return false;
	}
}	

