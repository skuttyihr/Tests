package com.iheart.appium.iosAutomation;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;

public class Page extends TestRoot{

	// Search field
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
	Logger logger = Logger.getLogger(Page.class);

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
}
