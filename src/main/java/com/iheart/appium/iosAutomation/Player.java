package com.iheart.appium.iosAutomation;

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
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]") public IOSElement songTrack_artist;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]") public IOSElement artist_artist;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[6]") public IOSElement songTrack_live;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]") public IOSElement artist_live;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") public IOSElement songTrack2_live;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]") public IOSElement artist2_live;

	// podcast specific
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[4]") public IOSElement podcastImage;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASlider[1]") public IOSElement slideBar;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") public IOSElement elapsedTime;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]") public IOSElement totalTime;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]") public IOSElement episodeName_podcast;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public IOSElement stationName_podcast;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]") public IOSElement playButton_podcast;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[9]") public IOSElement more_podcast;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]") public IOSElement playButton_live; // doesn't apply for podcast
	// @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[9]") public
	// IOSElement playButton_artist;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]") public IOSElement playButton_artist;
	// @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[11]") public
	// IOSElement more;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[6]") public IOSElement more_live;
	// @iOSFindBy(name="more") public IOSElement more;

//	@iOSFindBy(name = "Skip") public IOSElement skip;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[6]") public IOSElement skip;
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

	/**
	 * Verify player info Station Name Artist name if available Thumb up and
	 * Down Play/pause button Scan Button Share button iHeart button to Favorite
	 * station Volume control
	 * Returns a String of any errors encountered. A blank string means a successful verification
	 */
	public String verifyPlayer_live(String stationName) { 
		StringBuilder errors = new StringBuilder();
		if(!stationLabel.getText().contains(stationName)){
			System.out.println("Station name: " + stationLabel.getText() + " wasn't what we expected: " + stationName);
		}

		if (!TestRoot.isVisible(songTrack_live)) {
			if (!TestRoot.isVisible(songTrack2_live))
				errors.append("No sound track name is displayed.\n");
		}

		if (!TestRoot.isVisible(artist_live)) {
			if (!TestRoot.isVisible(artist2_live))
				errors.append("Artist name is NOT displayed.\n");
		}
		if (!TestRoot.isVisible(playButton_live))
			errors.append("Play icon is not displayed.\n");

		if (!TestRoot.isVisible(scan))
			errors.append("Scan icon is not displayed.\n");

		if (!TestRoot.isVisible(more_live))
			errors.append(".... is not displayed.\n");

		errors.append(verfiyCommonIcons("verifyPlayer_live"));
		
		return errors.toString();
	}

	/**
	 * **Calls assert statements
	 * Returns a String of any errors encountered. A blank string means a successful verification
	 * @param stationName
	 */
	public String verifyPlayer_artist(String stationName) {
		StringBuilder errors = new StringBuilder();
		
		if (!stationLabel.getText().contains(stationName))
			errors.append("Station name is not correct.\n");

		if (!TestRoot.isVisible(songTrack_artist))
			errors.append("No sound track name is displayed.\n");

		if (!TestRoot.isVisible(artist_artist))
			errors.append("No artist name is displayed.\n");

		if (!TestRoot.isVisible(playButton_artist))
			errors.append("Play icon is not displayed.\n");

		if (!TestRoot.isVisible(skip))
			errors.append("Skip icon is not displayed.\n");

		errors.append(verfiyCommonIcons("verifyPlayer_custom"));
		
		return errors.toString();
	}

	/**
	 * **Calls assert statements, can fail tests from within method!
	 * @param stationName
	 * Returns a String of any errors encountered. A blank string means a successful verification
	 */
	public String verifyPlayer_podcast(String stationName) {
		StringBuilder errors = new StringBuilder();
		if (!stationLabel.getText().contains(stationName.substring(0, 5)))
			errors.append("Station name is not correct.\n");

		if (!TestRoot.isVisible(episodeName_podcast))
			errors.append("Episode name is not displayed.\n");

		if (!TestRoot.isVisible(stationName_podcast))
			errors.append("Station name is Not displayed.\n");

		if (!TestRoot.isVisible(slideBar))
			errors.append("No Scrubber is displayed.\n");

		if (!TestRoot.isVisible(playButton_podcast))
			errors.append("Play icon is not displayed.\n");

		if (!TestRoot.isVisible(skip))
			errors.append("Skip icon is not displayed.\n");

		errors.append(verfiyCommonIcons("verifyPlayer_podcast"));
		
		return errors.toString();
	}

	/**
	 * **Calls assert statements, can fail tests from within method!
	 * @param callingMethod
	 */
	private String verfiyCommonIcons(String callingMethod) {
		StringBuilder errors = new StringBuilder();
		if (!TestRoot.isVisible(thumbUp))
			errors.append("No Thumb Up icon is displayed.\n");

		if (!TestRoot.isVisible(thumbDown))
			errors.append("No Thumb Down icon is displayed.\n");
		
		return errors.toString();
	}

	public boolean doSkip(String type) {
		String currentTrack, nowPlaying;
		currentTrack = getNowPlaying(type);

		skip.tap(1, 1);
		waitForTrackToLoad();
		nowPlaying = getNowPlaying(type);
		System.out.println("before/after:" + currentTrack + "/" + nowPlaying);
		// Verify new episode is playing
		if (currentTrack.equals(nowPlaying))
			return false;
		return true;
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

	public boolean doShare() {
		more_live.tap(1, 1);
		share.tap(1, 1);
		if (!isVisible(mail))
			return false;
		return true;
	}

	public void doThumbUp() {
		// Sometimes the thumbUp button is disabled, keep scan(At most 10 times
		// though to avoid hang) until thumbUpicon is enabled.
		int count = 0;

		// Try a little bit more
		while (isThumbUpDisabled() && count < 3) {
			System.out.println("thumbUp button is disabled. Scan now..");
			try {
				scan.click();
				waitForTrackToLoad();
			} catch (Exception e) {
			}
			count++;
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
			waitForVisible(driver, By.name("No Thanks"), 5).click();
//			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[10]")).click();// No, thank you
		} catch (Exception e) {}
	}

	private void handleGladAfterFavorite() {
		try {
			waitForVisible(driver, By.name("No Thanks"), 5).click();
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
				waitForTrackToLoad();
			} catch (Exception e) {

			}
			count++;
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

	/**
	 * Returns an error string. Blank string means no errors encountered
	 * @param stationType
	 * @return
	 */
	public String doThumbDown(String stationType) {
		
		StringBuilder errors = new StringBuilder();
		
		// Sometimes the thumbUp button is disabled, keep scan(At most 10 times
		// though to avoid hang) until thumbUpiCON is enabled.
		int count = 0;

		// Try a little bit more
		while (isThumbDownDisabled() && count < 3) {
			System.out.println("thumbDown button is disabled. Scan now..");
			try {
				if (stationType.equals("live")){
					scan.click();
					waitForTrackToLoad();
				}
				else{
					skip.click();
					waitForTrackToLoad();
				}
			} catch (Exception e) {

			}
			count++;
		}

		// if it is still disabled, return
		if (isThumbDownDisabled())
			return "";

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
				errors.append("Thump Down is not working properly.\n");
		}
		
		return errors.toString();
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

	public boolean doFavorite() { // if faved before, its value is 1;
		if (isFavDone()){
			favorite.click();
			handleUnFavConfirmation();
		}

		favorite.click();
		handleGladAfterFavorite();

		// Verify that icon is filled
		if (!favorite.getAttribute("value").equals("1"))
			return false;
		else
			return true;
	}

	// Are you sure you want to delete this preset?
	private void handleUnFavConfirmation() {
		try {
			waitForVisible(driver, 
					By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]"), 
					4).click();
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

	public boolean doScan() {
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"))
				.getText();

		scan.click();
		waitForTrackToLoad();
		// Verify that new song is playing
		String newSong = waitForVisible(driver, By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"), 5).getText();
		if (newSong.equals(currentSong))
			return false;
		else 
			return true;

	}

	public boolean doSkip() {
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"))
				.getText();

		skip.click();
		waitForTrackToLoad();
		// Verify that new song is playing
		String newSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		if (newSong.equals(currentSong))
			return false;
		else
			return true;

	}

	/**
	 * Returns an error string
	 * A blank string means no errors
	 * "live" "podcast" or "artist" (can leave blank for artist)
	 * @param type
	 * @return
	 */
	public void pause(String type) {
		IOSElement theOne;
		if (strGood(type) && type.equals("live"))
			theOne = playButton_live;
		else if (strGood(type) && type.equals("podcast"))
			theOne = playButton_podcast;
		else
			theOne = playButton_artist;

		theOne.click();
	}
	public void pauseAndResume() {
		pause("");
	}
	
	//TODO 		
//	// verify it is paused
//	if (!theOne.getAttribute("name").contains("play"))
//		return "Station playing is not paused.";
//
//	theOne.click();
//	// verify it is resumed
//	if (!theOne.getAttribute("name").contains("pause"))
//		return "Station playing is not RESUMED.";
	

	public boolean isPlaying(String type) {
		boolean isPlaying = false;

		IOSElement theOne;
		if (type.equals("live"))
			theOne = playButton_live;
		else if (type.equals("podcast"))
			theOne = playButton_podcast;
		else
			theOne = playButton_artist;
		try{
			if(isVisible(createAccount)){
				// User tried to play artist radio without logging in
				return false;
			}
		}catch(Exception e){}
		waitForElementToBeVisible(theOne, 5);
		// verify that it is playing: Get its attribute: class shall be 'pause'
		try{
			if(theOne != null && isVisible(theOne)){
				String klasses = theOne.getAttribute("name");
				System.out.println("See playbutton classes:" + klasses);
				if (klasses.contains("pause") || klasses.contains("stop"))
					isPlaying = true;
			}
		}
		catch(Exception e){
			return false;
		}
		return isPlaying;
	}
	
	public static void waitForTrackToLoad(){
		//button buffering stop
		waitForVisible(driver, By.name("button buggering stop"), 3);
		waitForNotVisible(driver, By.name("button buffering stop"), 3);
	}

	/**
	 * Returns a blank string if there are no issues
	 * All invisible elements or problem elements will be returned in a 
	 * 	multi-line string for easy output and debugging
	 * @return
	 */
	public String verifyArtistPlaybackControls(String artist){
		StringBuilder errors = new StringBuilder();
		errors.append(player.verifyPlayer_artist(artist));
		player.doThumbUp();
		errors.append(player.doThumbDown("artist"));
		if(!player.doFavorite()){
			errors.append("Could not favorite artist station!\n");
		}
		if(!player.doSkip()){
			errors.append("Could not skip!\n");
		}
		
		return errors.toString();
	}
	public String verifyArtistPlaybackControls(){
		return verifyArtistPlaybackControls("");
	}
	
	/**
	 * Returns the position of the slider (as a percentage)
	 * @return
	 */
	public int getPodcastScubberPostitionPercentage(){
		int scrubberPos = -1;
		
		if(isVisible(slideBar)){
			try{
				String sliderValue = slideBar.getAttribute("value").replace("%", "").trim();
				scrubberPos = Integer.parseInt(sliderValue);
			}
			catch(Exception e){
				System.err.println("Could not get scrubber position as an integer!");
			}
		}
		return scrubberPos;
	}
	
	/**
	 * Returns the current playback position in seconds
	 * @return
	 */
	public int getElapsedTime(){
		int timeElapsed = -1;
		
		// Grab the elapsed time, convert minutes & hours into seconds
		if(isVisible(elapsedTime)){
			timeElapsed = getTimeInSeconds(elapsedTime);
		}
		return timeElapsed;
	}
	
	
	/**
	 * Returns the current playback position in Hours, Minutes, and Seconds format
	 * Each one is an integer return[0] is hours, return[1] is minutes, etc
	 * @return
	 */
	public int[] getPodcastTimeBreakdown(){
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		
		//TODO
		// Grab the elapsed time, split out string by ":"
		
		int[] returnTime = {hours, minutes, seconds};
		return returnTime;
	}
	
	public int getTotalTime(){
		int totalTimeSec = -1;
		
		if(isVisible(totalTime)){
			totalTimeSec = getTimeInSeconds(totalTime);
		}
		
		return totalTimeSec;
	}
	
	private int getTimeInSeconds(IOSElement e){
		int time = -1;
		String[] et = e.getAttribute("value").split(":");
		if(et != null && et.length > 0){
			time = Integer.parseInt(et[et.length - 1]);
			if(et.length > 2){
				// Get hours
				int hours = Integer.parseInt(et[0]);
				time += (hours * 360);
				int minutes = Integer.parseInt(et[1]);
				time += (minutes * 60);
			}
			else if(et.length >= 1){
				int minutes = Integer.parseInt(et[0]);
				time += (minutes * 60);
			}
		}
		return time;
	}
}
