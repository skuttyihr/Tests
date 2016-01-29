package com.iheart.appium.iosAutomation;

import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestName;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iosTest {
	// TODO Remove all of this, use properties files like we do for Android
	protected static final String DEVICE_NAME = "QA iPhone 5s";
	protected static final String UDID = "6a667778f94f8241aa6511e3c8cbc8b1643bb9b5"; // IPHONE
																					// 5s
	// private static final String UDID =
	// "d7cb4ae985ed62b786a621597c9c0d53a4c1e678";
	protected static final String BUNDLE_ID = "com.clearchannel.iheartradio";
	// private static final String IPA_NAME =
	// "/Users/1111128/Documents/ios-flagship_5_14/build/Debug-iphoneos/iHeartRadio.app";
	// private static final String IPA_NAME =
	// "/Users/1111128/Library/Developer/Xcode/DerivedData/iPhone-cgjadqsrbgztopfcrtkodcgtscgf/Build/Products/Debug-iphoneos/iHeartRadio.app";
	// TODO Definitely none of this
	protected static final String IPA_NAME = "/Users/1111128/Library/Developer/Xcode/DerivedData/iPhone-ccflceywhaxzymfxdatoocajqggx/Build/Products/Debug-iphonesimulator/iHeartRadio.app";

	protected HomePage homePage;
	protected LoginPage loginPage;
	protected SignUpPage signupPage;
	protected Player player;
	protected SideNavigationBar sideNavBar;

	protected ForYouPage forYouPage;
	protected PerfectForPage perfectForPage;
	protected DeepLink deepLink;
	protected PodcastsPage podcastsPage;

	protected IOSDriver<IOSElement> driver;

	protected String sessionId;

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {

		// BasicConfigurator.configure();
		// driver = Utils.launchAPPinSimulator("iPhone 6", IPA_NAME);
		driver = Utils.launchAPPinSimulator("iPhone 6", IPA_NAME);
		// driver = Utils.launchAPPinRealDevice(DEVICE_NAME, UDID, BUNDLE_ID,
		// IPA_NAME);

		Page.setDriver(driver);
		Page.clearErrors();

		loginPage = new LoginPage(driver);
		signupPage = new SignUpPage(driver);
		player = new Player(driver);
		sideNavBar = new SideNavigationBar(driver);

		forYouPage = new ForYouPage(driver);
		perfectForPage = new PerfectForPage(driver);
		podcastsPage = new PodcastsPage(driver);

		deepLink = new DeepLink(driver);

	}

	@Test
	public void test_AIOS_22674_createArtistStation_thumbUp_thumbDown_favorite_skip() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			forYouPage.AIOS_22674_createArtistStation();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22697_playPodcasts_skip_share() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			podcastsPage.AIOS_22697_playPodcasts();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22669_loginViaFacebook() throws Exception {
		try {
			loginPage.AIOS_22669_loginViaFacebook();

		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22673_playLiveRadio_thumbUP_thumbDown_doFavorite() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			forYouPage.AIOS_22673_playLiveRadio();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22642_playCustomStation_search_logout() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			loginPage.login();
			perfectForPage.AIOS_22642_playCustomStation();

		} catch (Exception e) {
			handleException(e);
		}
	}

	@Test
	public void test_AIOS_22672_createAnAccount() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			signupPage.AIOS_22672_createAnAccount();

		} catch (Exception e) {
			handleException(e);
		}
	}

	@After
	public void tearDown() {
		// driver.quit(); //moved into TestWatcher
		if (Page.getErrors().length() > 0)
			fail(Page.getErrors().toString());

	}

	private void handleException(Exception e) {
		Page.getErrors().append("Exception is thrown.");
		e.printStackTrace();
		/*
		 * try{ Utils.takeScreenshot(driver, name.getMethodName());
		 * }catch(Exception eX) {
		 * 
		 * }
		 */
	}

	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		public void finished(Description description) {
			driver.quit();
		}

		@Override
		public void failed(Throwable e, Description description) {

			try {

				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// String filePathRoot = "C:\\_Jenkins\\workspace\\" +
				// jenkinsJobName + "\\target\\surefire-reports\\";
				String currentPath = System.getProperty("user.dir");
				String path = currentPath + "\\target\\surefire-reports\\";

				String fullFilePath = path + description.getClassName() + "\\" + description.getMethodName() + ".jpg";

				FileUtils.copyFile(screenshot, new File(fullFilePath));

			} catch (Exception ex) {
				System.out.println(ex.toString());
				System.out.println(ex.getMessage());
			}

			driver.quit();
		}
	};

}
