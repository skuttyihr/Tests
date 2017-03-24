package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.iheart.appium.iosAutomation.AppboyUpsellsPage.Entitlement;
import com.iheart.appium.utilities.Errors;
import com.iheart.appium.utilities.TestRoot;

//import org.apache.log4j.Logger;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Page extends TestRoot {

	// LOGIN PROMPT
	@iOSFindBy(accessibility = "Sign up for Free")
	protected IOSElement signUpPrompt;
	@iOSFindBy(accessibility = "Create Account")
	protected IOSElement createAccount;

	// Zip Code info
	@iOSFindBy(accessibility = "Use Location")
	public IOSElement useLocation;
	@iOSFindBy(accessibility = "Allow")
	public IOSElement allowButton;
	@iOSFindBy(accessibility = "Don't Allow")
	public IOSElement dontAllowButton;

	// SUB NAVIGATION bar
	@iOSFindBy(accessibility = "My Stations")
	public IOSElement myStations;
	@iOSFindBy(accessibility = "For You")
	public IOSElement forYou;
	@iOSFindBy(accessibility = "Perfect For")
	public IOSElement perfectFor;
	@iOSFindBy(accessibility = "Local Radio")
	public IOSElement localRadio;
	
	@iOSFindBy(accessibility = "iheartradio_logo_full")
	public static IOSElement iheartradio_logo_full;

	// sk - 11/8 - Header elements for each side nav page
	@iOSFindBy(accessibility = "NavBar-BackButton-UIButton")
	protected static IOSElement NavBarBackButton;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeOther/"
			+ "XCUIElementTypeStaticText")
	protected static IOSElement liveRadio;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeOther/"
			+ "XCUIElementTypeStaticText[2]")
	protected static IOSElement artistRadio;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeOther/"
			+ "XCUIElementTypeStaticText[2]")
	protected static IOSElement podcasts;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/"
			+ "XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
	protected static IOSElement listeningHistory;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeOther/"
			+ "XCUIElementTypeStaticText[2]")
	protected static IOSElement alarmClock;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeOther/"
			+ "XCUIElementTypeStaticText[2]")
	protected static IOSElement sleepTimer;

	static IOSDriver<IOSElement> driver;
	static SideNavigationBar sideNavigationBar;
	static FullPlayer fullPlayer;
	// Real device requires longer reponse time
	static boolean isRealDevice = false;
	// Logger logger = Logger.getLogger(Page.class);

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
	
	
	//////////////////////
	//		Getters		//
	//////////////////////
	
	public static IOSElement getMaybeLater(IOSDriver<IOSElement> d){
		return getMaybeLater(d, 5);
	}
	
	public static IOSElement getMaybeLater(IOSDriver<IOSElement> d, int maxWait){
		return waitForVisible(d, By.name("Maybe Later"), maxWait);
	}
	
	public static IOSElement getNoThanks(IOSDriver<IOSElement> d){
		return waitForVisible(driver, By.name("No Thanks"), 5);
	}
	
	public static IOSElement getNotifyMe(IOSDriver<IOSElement> d){
		return getMaybeLater(d, 5);
	}
	
	public static IOSElement getNotifyMe(IOSDriver<IOSElement> d, int maxWait){
		return waitForVisible(d, By.name("Notify Me"), maxWait);
	}

	
	/**
	 * Scroll to the bottom of a list until a show more button displays
	 * 
	 * @return
	 */
	public static IOSElement swipeToShowMore() { // TODO
		IOSElement showMore = null;
		boolean foundShowMore = false;
		for (int i = 0; i < 7; i++) {
			if (foundShowMore) {
				break;
			}
			swipeUp();
			showMore = findElement(driver, By.name("Show More"));
			if (isVisible(showMore)) {
				foundShowMore = true;
				break;
			} else {
				// There's a chance that we're on My Stations, and it found the
				// For You show more button by name
				int offset = 2;
				do {
					showMore = findElement(driver, By
							.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[" + offset + "]"));
					if (isVisible(showMore)) {
						foundShowMore = true;
						break;
					}
					offset++;
				} while (!isVisible(showMore) && offset < 5);
			}
		}

		if (showMore == null) {
			return null;
		}
		swipeUp(); // In case mini player is hiding it
		return showMore;
	}
	
	public static IOSElement getStationFromList(int selector) {
		String xpathForItem = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + selector
				+ "]";
		return waitForVisible(driver, find(xpathForItem, "xpath"), 5);
	}
	
	//////////////////////
	//		Actions		//
	//////////////////////
	
	// The popup: Like iHeartRadio? Let us know!
	public void likeIheart() {

	}
	//public boolean clickXtoCloseUpsellModal(){
	//	if()
	//	return false;
	//}

	public static void setDriver(IOSDriver<IOSElement> _driver) {
		driver = _driver;
	}

	public static void setPlayer(FullPlayer _fullPlayer) {
		fullPlayer = _fullPlayer;
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

	// Want your local radio?
	public static void handlePossiblePopUp() {
		try {
			IOSElement dismiss = waitForVisible(driver, By.name("No Thanks"), 3);
			if (!isVisible(dismiss)) {
				dismissStayConnectedPopup();
			}
			if (isVisible(dismiss)) {
				dismiss.click();
			}
		} catch (Exception e) {
		} // No chance of this failing a test
	}

	public static void dismissStayConnectedPopup() {
		chooseStayConnected(false);
	}

	public static void chooseStayConnected(boolean stayConnected) {
		if (stayConnected)
			click(driver, waitForVisible(driver, By.name("Get Notifications"), 20));
		else{
			click(driver, getMaybeLater(driver, 20));
		}
	}
	
	public static void quickDismissPopUp() {
		IOSElement noThanks = getNoThanks(driver);
		IOSElement maybeLater = getMaybeLater(driver);
		if (isVisible(noThanks)) {
			noThanks.click();
		} else if (isVisible(maybeLater)) {
			maybeLater.click();
		}
	}

	public void useLocation() {
		if (!isVisible(useLocation)) {
			waitForElementToBeVisible(useLocation, 5);
		}
		if (isVisible(useLocation)) {
			useLocation.click();
			allowButton.click();
		}
	}

	/**
	 * Enters "No Thanks" for zip code popup
	 */
	public static void enterZip() {
		enterZip("");
	}

	public static void enterZip(String zip) {
		if (!strGood(zip)) {
			try {
				waitForVisible(driver, By.name("No Thanks"), 4).click();
			} catch (Exception e) {
			}
		}
		IOSElement enterZip = waitForVisible(driver, find("Enter ZIP"), 7);
		if (enterZip != null && isVisible(enterZip)) {
			enterZip.click();
			IOSElement zipCodeEntry = waitForVisible(driver,
					find("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]/UIATextField[1]"),
					5);
			if (zipCodeEntry != null) {
				zipCodeEntry.sendKeys(zip);
				driver.findElement(By.name("OK"));
			}
		}
	}

	public void clickNavBarBackButton() {
		System.out.println("Page.clickNavBarBackButton().");
		NavBarBackButton.click();
	}

	public static boolean clickShowMore() {
		IOSElement showMore = findElement(driver, By.name("Show More"));
		IOSElement showMoreMyStations = findElement(driver,
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAButton[4]"));
		if (isVisible(showMore)) {
			showMore.click();
			return true;
		} else if (isVisible(showMoreMyStations)) {
			showMoreMyStations.click();
			return true;
		} else {
			showMore = swipeToShowMore();
			if (isVisible(showMore)) {
				showMore.click();
				return true;
			}
		}

		return false;
	}
	
	/** sk - 2/24 - helper method originally developed for Appboy Upsell testing
	 * Used to login, play the top result, and open the full player
	 * @param free
	 * @param isTrialEligible
	 * @param stationName
	 * @return
	 */
	public static Errors playStationOpenFullPlayer(Entitlement entitlement, boolean isTrialEligible, String stationName) {
		Errors err = new Errors();
		login(entitlement, isTrialEligible);
		homePage.clickNavBarSearchButtonToOpenSearch();
		if (miniPlayer.getMiniPlayer()) {
			if (!miniPlayer.getTypeOfPlayButton().equals("Play"))  //if station is not in paused or stopped state, then tap the play button
			miniPlayer.clickPlayPauseButton();
		}
		searchPage.searchAndPlayTopResults(stationName);		
		err.add(miniPlayer.openFullPlayer());
		System.out.println("Full player opened, playing " + stationName + " Radio");
		return err;
	}
	
	/** sk - 2/24 - helper method originally developed for Appboy Upsell testing 
	 * Used to login as a user with certain entitlements
	 * @param free
	 * @param isTrialEligible
	 * @return
	 */
	public static void login(Entitlement e, boolean isTrialEligible)  {
		if (e == Entitlement.FREE && isTrialEligible ==  true)
			loginPage.loginVerifyEntitlement(IHEARTFREEUSERNAME, IHEARTFREEPASSWD,"FREE");
		else if(e == Entitlement.FREE && isTrialEligible ==  false)
			loginPage.loginVerifyEntitlement(IHEARTFREETRIALEXPUSERNAME, IHEARTFREETRIALEXPPASSWD,"FREE");
		else if(e == Entitlement.PLUS)
			loginPage.loginVerifyEntitlement(IHEARTPLUSUSERNAME, IHEARTPLUSPASSWD, "PLUS");
		else
			loginPage.loginVerifyEntitlement(IHEARTPREMIUMUSERNAME, IHEARTPREMIUMPASSWD, "ALLA");
	}		
}
