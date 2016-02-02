package com.iheart.appium.iosAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Player extends Page {

	// Player for live radio
	// @iOSFindBy(name="Back") public IOSElement back;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]") public IOSElement back;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]") public IOSElement stationLabel;
	@iOSFindBy(name = "Share") public IOSElement share;
	@iOSFindBy(name = "Favorite") public IOSElement favorite;

	// Seems that this is depending upon from where the player is launched
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]") public IOSElement songTrack_artist;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]") public IOSElement artist_artist;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]") public IOSElement songTrack_live;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public IOSElement artist_live;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") public IOSElement songTrack2_live;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]") public IOSElement artist2_live;

	// podcast specific
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[4]") public IOSElement podcastImage;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASlider[1]") public IOSElement slideBar;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]") public IOSElement episodeName_podcast;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public IOSElement stationName_podcast;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]") public IOSElement playButton_podcast;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[9]") public IOSElement more_podcast;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]") public IOSElement playButton_live; // doesn't apply for podcast
	// @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[9]") public
	// IOSElement playButton_artist;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") public IOSElement playButton_artist;
	// @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[11]") public
	// IOSElement more;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[6]") public IOSElement more_live;
	// @iOSFindBy(name="more") public IOSElement more;

	@iOSFindBy(name = "skip") public IOSElement skip;
	@iOSFindBy(name = "scan") public IOSElement scan;
	@iOSFindBy(name = "Thumb up") public IOSElement thumbUp;
	@iOSFindBy(name = "Thumb down") public IOSElement thumbDown;
	// FOR SHARE
	@iOSFindBy(name = "Mail") public IOSElement mail;

	public Player() {
		super();
	}

	public Player(IOSDriver<IOSElement> _driver) {
		super(_driver);
		setPlayer(this);
	}

	// ******* END OF PLAYER for live radio ********

	/*
	 * Verify player info Station Name Artist name if available Thumb up and
	 * Down Play/pause button Scan Button Share button iHeart button to Favorite
	 * statio Volume control
	 */
	public void verifyPlayer_live(String stationName) { // if(!stationLabel.getText().contains(stationName))
														// Assert.fail("Station
														// name is not
														// correct.");

		if (!TestRoot.isElementVisible(songTrack_live)) {
			if (!TestRoot.isElementVisible(songTrack2_live))
				Assert.fail("No sound track name is displayed.");
		}

		if (!TestRoot.isElementVisible(artist_live)) {
			if (!TestRoot.isElementVisible(artist2_live))
				Assert.fail("Artist name is NOT displayed.");
		}
		if (!TestRoot.isElementVisible(playButton_live))
			Assert.fail("Play icon is not displayed.");

		if (!TestRoot.isElementVisible(scan))
			Assert.fail("Scan icon is not displayed.");

		if (!TestRoot.isElementVisible(more_live))
			Assert.fail(".... is not displayed.");

		verfiyCommonIcons("verifyPlayer_live");

	}

	public void verifyPlayer_artist(String stationName) {
		if (!stationLabel.getText().contains(stationName))
			Assert.fail("Station name is not correct.");

		if (!TestRoot.isElementVisible(songTrack_artist))
			Assert.fail("No sound track name is displayed.");

		if (!TestRoot.isElementVisible(artist_artist))
			Assert.fail("No artist name is displayed.");

		if (!TestRoot.isElementVisible(playButton_artist))
			Assert.fail("Play icon is not displayed.");

		if (!TestRoot.isElementVisible(skip))
			Assert.fail("Skip icon is not displayed.");

		verfiyCommonIcons("verifyPlayer_custom");
	}

	public void verifyPlayer_podcast(String stationName) {
		if (!stationLabel.getText().contains(stationName.substring(0, 5)))
			Assert.fail("Station name is not correct.");

		if (!TestRoot.isElementVisible(episodeName_podcast))
			Assert.fail("Episode name is not displayed.");

		if (!TestRoot.isElementVisible(stationName_podcast))
			Assert.fail("Station name is Not displayed.");

		if (!TestRoot.isElementVisible(slideBar))
			Assert.fail("No Scrobber is displayed.");

		if (!TestRoot.isElementVisible(playButton_podcast))
			Assert.fail("Play icon is not displayed.");

		if (!TestRoot.isElementVisible(skip))
			Assert.fail("Skip icon is not displayed.");

		verfiyCommonIcons("verifyPlayer_podcast");
	}

	private void verfiyCommonIcons(String callingMethod) {
		if (!TestRoot.isElementVisible(thumbUp))
			Assert.fail("No Thumb Up icon is displayed.");

		if (!TestRoot.isElementVisible(thumbDown))
			Assert.fail("No Thumb Down icon is displayed.");
	}

	public void doSkip(String type) {
		String currentTrack, nowPlaying;
		currentTrack = getNowPlaying(type);

		skip.tap(1, 1);
		TestRoot.sleep(2000);
		nowPlaying = getNowPlaying(type);
		System.out.println("before/after:" + currentTrack + "/" + nowPlaying);
		// Verify new episode is playing
		if (currentTrack.equals(nowPlaying))
			Assert.fail("Skip is not working.");
	}

	private String getNowPlaying(String type) {
		String currentTrack = "";
		if (type.equals("podcast"))
			currentTrack = episodeName_podcast.getText();
		else if (type.equals("artist"))
			currentTrack = songTrack_artist.getText();
		else if (type.equals("live"))
			currentTrack = songTrack_live.getText();
		return currentTrack;
	}

	public void doShare() {
		more_live.tap(1, 1);
		share.tap(1, 1);
		if (!TestRoot.isElementVisible(mail))
			Assert.fail("Share button is not working.");
	}

	public void doThumbUp() {
		// Sometimes the thumbUp button is disabled, keep scan(At most 10 times
		// though to avoid hang) until thumbUpiCON is enabled.
		int count = 0;

		// Try a little bit more
		while (isThumbUpDisabled() && count < 3) {
			System.out.println("thumbUp button is disabled. Scan now..");
			try {
				scan.click();
			} catch (Exception e) {

			}
			count++;
			TestRoot.sleep(3000);
		}

		// if it is still disabled, return
		if (isThumbUpDisabled())
			return;

		// If this is thumbUp before, double-click
		if (isThumbUpDone()) {
			thumbUp.click();
			TestRoot.sleep(1000);
			// Sometimes 'Like iheartRadio?" pops up
			handleGladYouLikeItPopup();

		}

		thumbUp.click();
		// Glad you like it! We'll let our DJs know.
		String response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
		System.out.println("See growls:" + response);

		// Sometimes 'Like iheartRadio?" pops up
		handleGladYouLikeItPopup();

		// FOR ARITST: Great, we’ll play you more songs like this.
		// if (!(response.contains("Glad you like") || response.contains("Thanks
		// for your feedback") || response.contains("Great")))
		// handleError("Thump Up is not working properly.", "doThumbUp");

	}

	// This happens when you thumbup a already thumbuped song track
	private void handleGladYouLikeItPopup() {
		try {
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[10]")).click();// No, thank you
		} catch (Exception e) {}
	}

	private void handleGladAfterFavorite() {
		try {
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]")).click();// UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]
			TestRoot.sleep(200);
		} catch (Exception e) {

		}
	}

	// this needs to be tested
	private boolean isThumbUpDisabled() {
		return !thumbUp.isEnabled();
		/*
		 * boolean isDisabled = false; try{ String value =
		 * thumbUp.getAttribute("enabled");
		 * System.out.println("isThumbUpDisabled:" + value); isDisabled =
		 * !value.equals("true"); }catch(Exception e) { e.printStackTrace(); }
		 * return isDisabled;
		 */
	}

	private boolean isThumbDownDisabled() {
		return !thumbDown.isEnabled();
		/*
		 * boolean isDisabled = false; try{
		 * 
		 * //Here, need debugging.. String value =
		 * thumbDown.getAttribute("enabled");
		 * System.out.println("isThumbDownDisabled:" + value); isDisabled =
		 * !value.equals("true"); }catch(Exception e) { e.printStackTrace(); }
		 * return isDisabled;
		 */
	}

	// This is for live radio
	public void doThumbDown() {
		// Sometimes the thumbUp button is disabled, keep scan(At most 10 times
		// though to avoid hang) until thumbUpiCON is enabled.
		int count = 0;

		// Try a little bit more
		while (isThumbDownDisabled() && count < 3) {
			System.out.println("thumbDown button is disabled. Scan now..");
			try {
				scan.click();
			} catch (Exception e) {

			}
			count++;
			TestRoot.sleep(3000);
		}

		// if it is still disabled, return
		if (isThumbDownDisabled())
			return;

		// If this is thumbUp before, double-click
		if (isThumbDownDone()) {
			thumbDown.click();
			TestRoot.sleep(1000);
			// Sometimes 'Like iheartRadio?" pops up
			handleGladYouLikeItPopup();

		}

		thumbDown.click();
//		TestRoot.sleep(1000);

		// String response =
		// driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
		// System.out.println("See thumbDOWN DOWN growls:" + response);

		// if (! response.contains("heard enough"))
		// handleError("Thump Down is not working properly.", "doThumbDown");

	}

	public void doThumbDown(String stationType) {
		// Sometimes the thumbUp button is disabled, keep scan(At most 10 times
		// though to avoid hang) until thumbUpiCON is enabled.
		int count = 0;

		// Try a little bit more
		while (isThumbDownDisabled() && count < 3) {
			System.out.println("thumbDown button is disabled. Scan now..");
			try {
				if (stationType.equals("live"))
					scan.click();
				else
					skip.click();
			} catch (Exception e) {

			}
			count++;
			TestRoot.sleep(3000);
		}

		// if it is still disabled, return
		if (isThumbDownDisabled())
			return;

		// If this is thumbUp before, double-click
		if (isThumbDownDone()) {
			thumbDown.click();
			TestRoot.sleep(1000);
			// Sometimes 'Like iheartRadio?" pops up
			handleGladYouLikeItPopup();
		}

		thumbDown.click();
		TestRoot.sleep(1000);
		if (stationType.equals("artist"))
			handleThumbDownPopUpForArtistStation();

		String response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
		System.out.println("See thumbDOWN DOWN growls:" + response);

		if (stationType.equals("live")) {
			if (!response.contains("heard enough"))
				Assert.fail("Thump Down is not working properly.");
		}
	}

	private boolean isThumbUpDone() {

		boolean isDone = false;
		try {
			// if yes, its value is 1; otherwise, blank
			String value = thumbUp.getAttribute("value");

			System.out.println("Is thumpUp done:" + value);

			isDone = value.equals("1");

		} catch (Exception e) {

		}
		return isDone;
	}

	private boolean isThumbDownDone() {

		boolean isDone = false;
		try {
			// if yes, its value is 1; otherwise, blank
			String value = thumbDown.getAttribute("value");

			System.out.println("Is thumpDown done:" + value);

			isDone = value.equals("1");

		} catch (Exception e) {

		}
		return isDone;
	}

	public void doFavorite() { // if faved before, its value is 1;
		if (isFavDone()) // unfav it
		{
			favorite.click();
			TestRoot.sleep(1000);
			handleUnFavConfirmation();
		}

		favorite.click();
		TestRoot.sleep(500);

		handleGladAfterFavorite();

		// Verify that icon is filled
		if (!favorite.getAttribute("value").equals("1"))
			Assert.fail("Add to Favorite failed.");

		/*
		 * String response = ""; response = driver.findElement(By.xpath(
		 * "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
		 * System.out.println("See favorite growls:" + response);
		 * 
		 * 
		 * //Station added to your favorites! if (!response.contains(
		 * "Station added")) handleError("Add to Favorite failed.",
		 * "doFavorite");
		 * 
		 */

	}

	// Are you sure you want to delete this preset?
	private void handleUnFavConfirmation() {
		try {
			driver.findElement(By
					.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]"))
					.click();
			TestRoot.sleep(1000);
		} catch (Exception e) {

		}
	}

	// Thumbing down customizes your station without using a skip.
	private void handleThumbDownPopUpForArtistStation() {
		try {
			// click on OKAY BUTTON of alert box: Thumbing down customizes your
			// station without using a skip.
			driver.findElement(By
					.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]"))
					.click();
			TestRoot.sleep(1000);
		} catch (Exception e) {

		}
	}

	private boolean isFavDone() {
		boolean isDone = false;

		try {
			isDone = favorite.getAttribute("value").equals("1");
		} catch (Exception e) {

		}

		return isDone;
	}

	public void doScan() {
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"))
				.getText();

		scan.click();
		TestRoot.sleep(5000);
		// Verify that new song is playing
		String newSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		if (newSong.equals(currentSong))
			Assert.fail("Scan is not working.");

	}

	public void doSkip() {
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"))
				.getText();

		skip.click();
		TestRoot.sleep(5000);
		// Verify that new song is playing
		String newSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		if (newSong.equals(currentSong))
			Assert.fail("Skip is not working.");

	}

	public void pauseAndResume(String type) {
		IOSElement theOne;
		if (type.equals("live"))
			theOne = playButton_live;
		else if (type.equals("podcast"))
			theOne = playButton_podcast;
		else
			theOne = playButton_artist;

		theOne.click();
		// verify it is paused
		if (!theOne.getAttribute("name").contains("play"))
			Assert.fail("Station playing is not paused.");

		theOne.click();
		// verify it is resumed
		if (!theOne.getAttribute("name").contains("pause"))
			Assert.fail("Station playing is not RESUMED.");

	}

	public boolean isPlaying(String type) {
		boolean isPlaying = false;

		IOSElement theOne;
		if (type.equals("live"))
			theOne = playButton_live;
		else if (type.equals("podcast"))
			theOne = playButton_podcast;
		else
			theOne = playButton_artist;

		// verify that it is playing: Get its attribute: class shall be 'pause'
		String klasses = theOne.getAttribute("name");
		System.out.println("See playbutton classes:" + klasses);
		if (klasses.contains("pause") || klasses.contains("stop"))
			isPlaying = true;

		return isPlaying;
	}
}
