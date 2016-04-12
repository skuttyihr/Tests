package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Player extends Page {

	// Player Identifiers
	@iOSFindBy(name = "CustomMusicPlayerView") public IOSElement artistPlayerView;
	@iOSFindBy(name = "LivePlayerView") public IOSElement radioPlayerView;
	@iOSFindBy(name = "CustomTalkPlayerView") public IOSElement podcastPlayerView;
	// Player for live radio
	// @iOSFindBy(name="Back") public IOSElement back;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]") public IOSElement back;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]") public IOSElement stationLabel;
	@iOSFindBy(name = "Share") public IOSElement share;
	@iOSFindBy(name = "Favorite") public IOSElement favorite;
	@iOSFindBy(name = "airplay") public IOSElement airPlay;

	// Seems that this is depending upon from where the player is launched
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]") public IOSElement songTrack_artist;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]") public IOSElement artist_artist;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]") public IOSElement songTrack_live;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") public IOSElement artist_live;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") public IOSElement songTrack2_live;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]") public IOSElement artist2_live;

	// podcast specific
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASlider[1]") public IOSElement slideBar;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]") public IOSElement elapsedTime;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") public IOSElement totalTime;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]") public IOSElement episodeName_podcast;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public IOSElement stationName_podcast;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[7]") public IOSElement more;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[6]") public IOSElement skip;
	@iOSFindBy(name = "scan") public IOSElement scan;
	@iOSFindBy(name = "Thumb up") public IOSElement thumbUp;
	@iOSFindBy(name = "Thumb down") public IOSElement thumbDown;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASlider[2]") public IOSElement volume;

	// Play/Pause/Stop buttons
	public final String playPauseStopXpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]"; // Works for all, but subject to change
	@iOSFindBy(name = "player pause") public IOSElement pause; // Used for Podcasts and Artist Radio
	@iOSFindBy(name = "player play") public IOSElement play; // Used for Podcasts, Live Radio, and Artist Radio
	@iOSFindBy(name = "player stop") public IOSElement stop; // Used for Live Radio
	
	// FOR SHARE
	@iOSFindBy(name = "Mail") public IOSElement mail;
	
	// If loaded from mini player
	@iOSFindBy(name = "player downarrow") public IOSElement minimizeButton;
	
	// Images 
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[3]") public IOSElement radioImage;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[3]") public IOSElement artistAlbumArt;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[4]") public IOSElement podcastImage; // Same as above, but named to assist in any possible issues
	
	// Growl Messages (Use Xpath only as backup)
	@iOSFindBy(name = "Great, we’ll play you more  songs like this.") public IOSElement artistThumbUpGrowl; // //UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]
	@iOSFindBy(name = "OK, we'll adjust your music mix.") public IOSElement artistThumbDownGrowl;
	@iOSFindBy(name = "Glad you like it!  We'll let our DJs know.") public IOSElement liveThumbUpGrowl; // //UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]
	@iOSFindBy(name = "Thanks for the feedback. We'll let our DJs know you've  heard enough of this song.") public IOSElement liveThumbDownGrowl;
	@iOSFindBy(name = "Great, we’ll play you more  episodes like this.") public IOSElement podcastThumbUpGrowl; // //UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]
	@iOSFindBy(name = "OK, we’ll adjust your station.") public IOSElement podcastThumbDownGrowl;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]") public IOSElement stationTitle;
	
	// More info pane
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[4]") public IOSElement moreInfoAlbumArtwork;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]") public IOSElement moreInfoSong;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public IOSElement moreInfoArtist;
	@iOSFindBy(name = "Tune Station") public IOSElement moreInfoTuneStation;
	@iOSFindBy(name = "Lyrics") public IOSElement moreInfoLyrics;
	@iOSFindBy(name = "Artist Bio") public IOSElement moreInfoArtistBio;
	@iOSFindBy(name = "Share") public IOSElement moreInfoShare;
	@iOSFindBy(name = "Buy Song") public IOSElement moreInfoBuy;
	@iOSFindBy(name = "Close") public IOSElement moreInfoClose;
	// More info for Live Radio
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]") public IOSElement moreInfoRadioSong;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]") public IOSElement moreInfoRadioArtist;
	@iOSFindBy(name = "Station Info") public IOSElement moreInfoRadioStationInfo;

	// Tune station controls
	@iOSFindBy(name = "close inactive") public IOSElement tuneStationClose;
	@iOSFindBy(name = "Discovery Tuner") public IOSElement tuneStationLabel;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public IOSElement tuneStationDescription;
	@iOSFindBy(name = "Top Hits") public IOSElement tuneStationTopHits;
	@iOSFindBy(name = "Mix") public IOSElement tuneStationMix;
	@iOSFindBy(name = "Variety") public IOSElement tuneStationVariety;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[11]") public IOSElement tuneStationFeatured;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[12]") public IOSElement tuneStationListOfArtists;
	// Lyrics Elements
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]") public IOSElement lyricsSong;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]") public IOSElement lyricsArtist;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]") public IOSElement lyricsView;
	@iOSFindBy(name="Back") public IOSElement moreBack;
	// Artist bio elements
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]") public IOSElement artistBioArtist;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]") public IOSElement artistBioBio; 
	// Share pane and buy song handled by Page class
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAActivityView[1]/UIAActionSheet[1]/UIAButton[1]") public IOSElement shareCancel;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAActivityView[1]/UIAActionSheet[1]/UIAScrollView[1]/UIACollectionView[1]") public IOSElement shareOptions;
	
	// Station Info
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[2]") public IOSElement stationInfoName;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAImage[6]") public IOSElement stationInfoLogo;
	@iOSFindBy(name = "Now Playing") public IOSElement stationInfoNowPlaying;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAStaticText[2]") public IOSElement stationInfoSong;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAStaticText[3]") public IOSElement stationInfoArtist;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIAWebView[1]") public IOSElement stationInfoView;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAStaticText[4]") public IOSElement stationInfoNoContent;
	@iOSFindBy(name = "The Feed") public IOSElement stationInfoTheFeed;
	@iOSFindBy(name = "On Air") public IOSElement stationInfoOnAir;
	
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
	private String verifyPlayer_live(String stationName) { 
		Errors errors = new Errors();
		if(stationName != null && stationName.length() > 0 
				&& !stationLabel.getText().contains(stationName)){
			System.out.println("Station name: " + stationLabel.getText() + " wasn't what we expected: " + stationName);
		}

		if (!isVisible(songTrack_live)) {
			if (!isVisible(songTrack2_live))
				errors.append("No sound track name is displayed.\n");
		}
		if (!isVisible(play) && !isVisible(stop))
			errors.append("Play/Stop button is not displayed.\n");

		if (!isVisible(scan))
			errors.append("Scan button is not displayed.\n");

		if (!isVisible(more))
			errors.append("More button (...) is not displayed.\n");

		if(!isVisible(radioImage)){
			errors.append("Could not load live radio image\n");
		}
		
		
		return errors.toString();
	}

	/**
	 * Returns a String of any errors encountered. A blank string means a successful verification
	 * @param stationName
	 */
	private String verifyPlayer_artist(String stationName) {
		Errors errors = new Errors();
		
		if(stationName != null && stationName.length() > 0
				&& !stationLabel.getText().contains(stationName))
			errors.append("Station name is not correct.\n");

		if (!isVisible(songTrack_artist))
			errors.append("No sound track name is displayed.\n");

		if (!isVisible(artist_artist))
			errors.append("No artist name is displayed.\n");

		if (!isVisible(play) && !isVisible(pause))
			errors.append("Play/Pause button is not displayed.\n");

		if (!isVisible(skip))
			errors.append("Skip button is not displayed.\n");

		if(!isVisible(artistAlbumArt)){
			errors.append("Could not load artist album artwork.\n");
		}
		
		return errors.toString();
	}

	/**
	 * **Calls assert statements, can fail tests from within method!
	 * @param stationName
	 * Returns a String of any errors encountered. A blank string means a successful verification
	 */
	private String verifyPlayer_podcast(String stationName) {
		Errors errors = new Errors();
		if(stationName != null && stationName.length() > 0
				&& !stationLabel.getText().contains(stationName.substring(0, 5)))
			errors.append("Station name is not correct.\n");

		if (!isVisible(episodeName_podcast))
			errors.append("Episode name is not displayed.\n");

		if (!isVisible(stationName_podcast))
			errors.append("Station name is Not displayed.\n");

		if (!isVisible(slideBar))
			errors.append("No Scrubber is displayed.\n");

		if (!isVisible(play) && !isVisible(pause))
			errors.append("Play/Play button is not displayed.\n");

		if (!isVisible(skip))
			errors.append("Skip button is not displayed.\n");

		if(!isVisible(podcastImage)){
			errors.append("Could not load podcast image\n");
		}
		
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
		more.tap(1, 1);
		share.tap(1, 1);
		if (!isVisible(mail))
			return false;
		return true;
	}

	
	public boolean isThumbUpDisabled() {
		return !thumbUp.isEnabled();
	}

	public boolean isThumbDownDisabled() {
		return !thumbDown.isEnabled();
	}
	
	
	private void scanOrSkipUntilThumbAvailable(){
		IOSElement skipOrScan;
		String type = getType();
		
		if(type.equalsIgnoreCase("live")){
			skipOrScan = scan;
		}
		else{
			skipOrScan = skip;
		}
		
		int count = 0;
		while ((isThumbUpDisabled() || isThumbDownDisabled()) && count < 5) {
			System.out.println("thumb buttons are disabled. Scanning/skipping now..");
			try {
				waitForElementToBeVisible(skipOrScan, 1);
				skipOrScan.click();
				waitForTrackToLoad();
			}catch (Exception e) {
			}
			finally{
				count++;
			}
		}
	}
	
	// This happens when you thumbup a already thumbuped song track
	private void handleActionPopup() {
		try {
			waitForVisible(driver, By.name("No Thanks"), 3).click();
		} catch (Exception e) {}
		try {
			waitForVisible(driver, By.name("Okay"), 1).click();
		} catch (Exception e) {}
	}

		
	/**
	 * Thumb up a track, tests that thumb up was recorded
	 * @return
	 */
	public boolean doThumbUp() {
		// Sometimes the thumbUp button is disabled, keep scan(At most 3 times
		// 		though to avoid hang) until thumbUpicon is enabled.
		// Only do this for live stations, not for artist radio or podcasts
		scanOrSkipUntilThumbAvailable();
		String type = getType();
		// if it is still disabled, return
		if (isThumbUpDisabled())
			return false;
		
		// Actually click on the thumb up
		thumbUp.click();
		if (!verifyThumbUpGrowl(type)){
			System.out.println("Expected a thumb up growl but could not find one, likely just a matter of timing.");
		}
		// Sometimes 'Like iheartRadio?" pops up
		handleActionPopup();
		return isThumbUpDone();
	}

	/**
	 * Thumb down a track, tests that thumb down was recorded. 
	 * @return
	 */
	public boolean doThumbDown() {
		// Sometimes the thumbDown button is disabled, keep scan(At most 3 times
		// 		though to avoid hang) until thumbDownicon is enabled.
		// Only do this for live stations, not for artist radio or podcasts
		scanOrSkipUntilThumbAvailable();
		String type = getType();
		// if it is still disabled, return
		if (isThumbDownDisabled())
			return false;
		
		// Actually click on the thumb up
		thumbDown.click();
		if (!verifyThumbDownGrowl(type)){
			System.out.println("Expected a thumb down growl but could not find one, likely just a matter of timing.");
		}
		// Sometimes 'Like iheartRadio?" pops up
		handleActionPopup();
		return isThumbDownDone();
	}

	public boolean isThumbUpDone() {

		boolean isDone = false;
		try {
			// if yes, its value is 1; otherwise, blank
			String value = thumbUp.getAttribute("value");
			isDone = value.equals("1");

		} catch (Exception e) {
		}
		return isDone;
	}

	public boolean isThumbDownDone() {

		boolean isDone = false;
		try {
			// if yes, its value is 1; otherwise, blank
			String value = thumbDown.getAttribute("value");
			isDone = value.equals("1");
		} catch (Exception e) {
		}
		return isDone;
	}

	public boolean doFavorite() { // if faved before, its value is 1;
		if (!isFavorite()){
			if(isVisible(favorite)){
				favorite.click();
				handleActionPopup();
			}
		}
		// Verify that icon is filled
		return favorite.getAttribute("value").equals("1");
	}

	public boolean unFavorite(){
		if(isFavorite()){
			favorite.click();
			handleUnFavConfirmation();
		}
		return favorite.getAttribute("value").equals("0");
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

	public boolean isFavorite() {
		boolean isFav = false;
		
		waitForElementToBeVisible(favorite, 2);
		try {
			isFav = favorite.getAttribute("value").equals("1");
		} catch (Exception e) {
		}

		return isFav;
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

		String current = "";
		String type = getType();
		IOSElement track = null;
		switch(type){
		case "artist":
			waitForElementToBeVisible(songTrack_artist, 3);
			track = songTrack_artist;
			break;
		case "live":
			waitForElementToBeVisible(songTrack_live, 3);
			track = songTrack_live;
			break;
		case "podcast":
			waitForElementToBeVisible(episodeName_podcast, 3);
			track = episodeName_podcast;
			break;
		}

		if(isVisible(track))
			current = track.getText();
		
		if(type.equals("artist") || type.equals("podcast")){
			skip.click();
		}
		else{
			scan.click();
		}
		
		waitForTrackToLoad();
		// Verify that new song is playing
		String newSong = track.getText();
		if (newSong.equals(current))
			return false;
		else
			return true;

	}
	
	public boolean share(){
		boolean couldShare = false;
		if(isVisible(share)){
			share.click();
			waitForElementToBeVisible(shareCancel, 3);
			if(isVisible(shareCancel)){
				shareCancel.click();
				couldShare = true;
			}
		}
		return couldShare;
	}

	/**
	 * Pauses Podcasts and Artist Radio
	 * Will do nothing if already paused
	 */
	public void pause(){
		if(isVisible(pause)){
			pause.click();
		}
		else if(isVisible(stop)){
			// We know what you meant
			System.out.println("Note:\nPlease use the 'stop()' method when stopping live radio playback, not 'pause()'");
			stop();
		}
		else if(isVisible(miniPlayer.miniPlayerPause)){
			miniPlayer.pause();
		}
	}
	
	/**
	 * Stops live radio
	 * Will do nothing if live radio is already stopped
	 */
	public void stop(){
		if(isVisible(stop)){
			stop.click();
		}
		else if(isVisible(pause)){
			// We know what you meant
			System.out.println("Note:\nPlease use the 'pause()' method when pausing a podcast or artist station playback, not 'stop()'");
			pause();
		}
		else if(isVisible(miniPlayer.miniPlayerStop)){
			miniPlayer.stop();
		}
	}
	
	/**
	 * Plays station
	 * Will do nothing if station is already playing
	 */
	public void play(){
		if(isVisible(play)){
			play.click();
		}
		else if(isVisible(miniPlayer.miniPlayerPlay)){
			miniPlayer.play();
		}
	}
	
	public void pauseOrStop(){
		switch(getType()){
		case "artist":
		case "podcast":
			pause();
			break;
		case "live":
			stop();
			break;
		}
	}
	
	/**
	 * If it's playing stop or pause it. If it's stopped or paused, play
	 */
	public void togglePlaying(){
		if(isVisible(play)){
			play();
		}
		else if(isVisible(pause)){
			pause();
		}
		else if(isVisible(stop)){
			stop();
		}
	}
	
	/**
	 * Tests to see if we're actually streaming music
	 * @return
	 */
	public boolean isStreaming(){
		int currentTime = getElapsedTime();
		sleep(1100);
		return currentTime != getElapsedTime();
	}
	
	public boolean isPlayingInPlayer(){
		if(isPlaying()){
			// Try this first. Type uses the string in the player view
			String type = getType();
			if(strGood(type)){
				return true;
			}
			// This doesn't work anymore, all use the same player view now. Must use type 
//			if(isVisible(artistPlayerView)
//					|| isVisible(podcastPlayerView)
//					|| isVisible(radioPlayerView)){
//				return true;
//			}
		}
		return false;
	}
	
	public boolean isPlaying(){
		return isPlaying(getType());
	}
	
	public boolean isPlaying(String type) {
		boolean isPlaying = false;
		handlePossiblePopUp();
		
		// If it's playing in the mini player, skip the other assessments
		if(isVisible(miniPlayer.miniPlayerBar)){
			if(isVisible(miniPlayer.miniPlayerStop) || isVisible(miniPlayer.miniPlayerPause)){
				return true;
			}
			else{
				return false;
			}
		}
		
		switch(type){
		case "artist":
		case "podcast":
			if(isVisible(pause))
				isPlaying = true;
			break;
		case "live":
			if(isVisible(stop))
				isPlaying = true;
			break;
		}
		
		return isPlaying;
	}
	
	public static void waitForTrackToLoad(){
		//button buffering stop
		waitForVisible(driver, By.name("button buggering stop"), 3);
		waitForNotVisible(driver, By.name("button buffering stop"), 3);
	}

	/**
	 * Returns "artist", "podcast", or "live" for the station type
	 * @return
	 */
	public String getType(){
		String[] types = {"artist", "podcast", "live"};
		int type = 0; 
		
		// Try to do it a different way
		IOSElement liveRadioPlayer = findElement(driver, By.name("Live Radio"));
		IOSElement podcastPlayer = findElement(driver, By.name("Podcast"));
		if(isVisible(podcastPlayer)){
			type = 1;
		}
		else if(isVisible(liveRadioPlayer)){
			type = 2;
		}
		else if(isVisible(artistPlayerView)){
			type = 0;
		}
	
		
		return types[type];
	}
	
	public boolean verifyThumbUpGrowl(){
		return verifyThumbUpGrowl("");
	}
	/**
	 * 
	 * @param type (From Player.getType(), "artist" "live" or "podcast")
	 * 		Type can be passed in as "" (use verifyThumbUpGrowl() for this as well),
	 * 			 which will test for any thumb up growl
	 * @return True if 
	 */
	public boolean verifyThumbUpGrowl(String type){
		boolean foundGrowl = false;
		
		switch(type){
		case "artist":
			foundGrowl = isVisible(artistThumbUpGrowl);
			break;
		case "live":
			foundGrowl = isVisible(liveThumbUpGrowl);
			break;
		case "podcast":
			foundGrowl = isVisible(podcastThumbUpGrowl);
			break;
		default:
			foundGrowl = isVisible(artistThumbUpGrowl)
				|| isVisible(liveThumbUpGrowl)
				|| isVisible(podcastThumbUpGrowl); 
			break;
		}
		
		return foundGrowl;
	}
	
	public boolean verifyThumbDownGrowl(){
		return verifyThumbDownGrowl("");
	}
	/**
	 * 
	 * @param type (From Player.getType(), "artist" "live" or "podcast")
	 * 		Type can be passed in as "" (use verifyThumbDownGrowl() for this as well),
	 * 			 which will test for any thumb down growl
	 * @return True if 
	 */
	public boolean verifyThumbDownGrowl(String type){
		boolean foundGrowl = false;
		
		switch(type){
		case "artist":
			foundGrowl = isVisible(artistThumbDownGrowl);
			break;
		case "live":
			foundGrowl = isVisible(liveThumbDownGrowl);
			break;
		case "podcast":
			foundGrowl = isVisible(podcastThumbDownGrowl);
			break;
		default:
			foundGrowl = isVisible(artistThumbDownGrowl)
				|| isVisible(liveThumbDownGrowl)
				|| isVisible(podcastThumbDownGrowl); 
			break;
		}
		
		return foundGrowl;
	}
	
	public String verifyPlaybackControls(){
		return verifyPlaybackControls("");
	}
	/**
	 * Verifies the playback controls for any playback view
	 * @param station
	 * @return
	 */
	public String verifyPlaybackControls(String station){
		Errors errors = new Errors();
		
		// Verify that the controls are present
		if (!isVisible(thumbUp))
			errors.add("No Thumb Up icon is displayed.");

		if (!isVisible(thumbDown))
			errors.add("No Thumb Down icon is displayed.");
		
		// Verify based on type (Artist, Podcast, Radio)
		switch(getType()){
		case "artist":
			errors.add(verifyPlayer_artist(station));
			break;
		case "podcast":
			errors.add(verifyPlayer_podcast(station));
			break;
		case "live":
			errors.add(verifyPlayer_live(station));
			break;
		}
		
		// Verify that we can use the controls
		if(!doThumbDown()){
			errors.add("Could not thumb down!");
		}
		if(!doThumbUp()){ // End on a good note :)
			errors.add("Could not thumb up!");
		}
		if(!player.doFavorite()){
			errors.add("Could not favorite artist station!");
		}
		if(!player.doSkip()){
			errors.add("Could not skip!");
		}
		
		if(!player.share()){
			errors.add("Could not share!");
		}
		
		return errors.toString();
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
		
		// Grab the elapsed time, split out string by ":"
		if(isVisible(elapsedTime)){
			String[] times = elapsedTime.getText().split(":");
			if(times.length == 1){
				seconds = Integer.parseInt(times[1]);
			}
			else if(times.length == 2){
				minutes = Integer.parseInt(times[0]);
				seconds = Integer.parseInt(times[1]);
			}
			else if(times.length == 3){
				hours = Integer.parseInt(times[0]);
				minutes = Integer.parseInt(times[1]);
				seconds = Integer.parseInt(times[2]);
			}
			else{
				System.err.println("Error fetching time!");
			}
		}
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
		String[] et = e.getAttribute("value").trim().split(":");
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
	
	/**
	 * 
	 * @param percentage
	 */
	public void scrubTo(int percentage){
		if(percentage < 0 || percentage > 100){
			return;
		}
		// Add a little to adjust for consistently lower than requested position
		String floatingPercentage = String.valueOf((float) percentage / 100 + .0336); 
		if(isVisible(slideBar)){
			slideBar.setValue(floatingPercentage); // Done to enable our ability to change this
			int testLoc = getPodcastScubberPostitionPercentage();
			int count = 0;
			while(count < 3 && !isAbout(percentage, testLoc, 6)){
				count++;
				slideBar.sendKeys(floatingPercentage);
				pause(); // Get it in as soon as possible
				Page.quickDismissPopUp(); // If there was a popup, quickly dismiss it
				pause(); // Try pausing again. 
				testLoc = getPodcastScubberPostitionPercentage();
			}
		}
	}
	
	public boolean minimizePlayer(){
		waitForElementToBeVisible(minimizeButton, 4);
		if(isVisible(minimizeButton)){
			minimizeButton.click();
			return isVisible(miniPlayer.miniPlayerBar);
		}
		else{
			return false;
		}
	}
	
	public int getVolume(){
		int vol = -1;
		waitForElementToBeVisible(volume, 5);
		String volVal = volume.getAttribute("value");
		volVal = volVal.replace("%", "");
		try{
			vol = Integer.parseInt(volVal);
		}
		catch(Exception e){}
		return vol;
	}
	
	public String setVolume(int volumeLevel){
		Errors err = new Errors();
		waitForElementToBeVisible(volume, 5);
		if(!isVisible(volume)){
			err.add("Volume slider was not present.");
		}
		else{
			String floatingPercentage = String.valueOf((float) volumeLevel / 100);
			
			// Try this method. If it works, break
			// Sometimes this method is required before trying to set it the other way, to enable it
			volume.setValue(String.valueOf(floatingPercentage));
			int testVolume = getVolume();
			if(isAbout(volumeLevel, testVolume, 6)){
				return "";
			}
			int count = 0;
			testVolume = getVolume();
			while (count < 3 && !isAbout(volumeLevel, testVolume, 6)){
				count++;
				try{
					volume.sendKeys(String.valueOf(floatingPercentage));
				}
				catch(Exception e){
					err.add("Failure to set volume: " + e.getMessage());
				}
				testVolume = getVolume();
			}
			if(!isAbout(volumeLevel, testVolume, 6)){
				err.add("Could not set volume within volume levels.\nExpected: " + volumeLevel + "\nFound: " + testVolume);
			}
		}
		
		return err.getErrors();
	}
	
	/**
	 * From playback screen, check that we can stream over airplay
	 * Likely won't work with the simulator, and a physical device must have an AirPlay device within range.
	 * @return
	 */
	public String streamOverAirPlay(){
		Errors err = new Errors();
		
		if(isVisible(airPlay)){
			airPlay.click();
			// Check that the airplay dialog is now visible and close it
			IOSElement cancelAirPlay = waitForVisible(driver, By.name("Cancel"), 5);
			if(cancelAirPlay != null){
				cancelAirPlay.click();
			}
			else{
				err.add("Clicking AirPlay button did not bring up AirPlay dialog.");
			}
		}
		else{
			if(airPlay == null){ // If we have it but it's not visible, pass it anyway
				err.add("AirPlay button was not visible. Is this disabled?");
			}
		}
		
		return err.getErrors();
	}
	
	public String getStationTitle(){
		String title = "";
		waitForElementToBeVisible(stationTitle, 3);
		if(isVisible(stationTitle)){
			title = stationTitle.getText();
		}
		return title;
	}
	
	public String openMoreInfo(){
		return openMoreInfo(getType(), true);
	}
	public String openMoreInfo(boolean verify){
		return openMoreInfo(getType(), verify);
	}
	public String openMoreInfo(String type){
		return openMoreInfo(type, true);
	}
	public String openMoreInfo(String type, boolean verify){
		Errors err = new Errors();
		if(!isVisible(more)){
			handlePossiblePopUp();
		}
		if(isVisible(more)){
			more.click();
			// Check that all options are present
			// They may not all be clickable though...
			if(verify){ // May want to skip if executing verify all elements to save time
				err.add(verifyMoreInfoElementsVisible(type));
			}
		}
		else{
			err.add("More (...) button was not visible");
		}
		
		return err.getErrors();
	}
	
	public String verifyMoreInfoElementsVisible(String type){
		Errors err = new Errors();
		IOSElement song = moreInfoSong;
		IOSElement artist = moreInfoArtist;
		IOSElement station = moreInfoTuneStation;
		if(type.equals("live")){
			song = moreInfoRadioSong;
			artist = moreInfoRadioArtist;
			station = moreInfoRadioStationInfo;
		}
		waitForElementToBeVisible(moreInfoAlbumArtwork, 3);
		if(!isVisible(moreInfoAlbumArtwork)){
			err.add("Album artwork was not displayed on more info screen.");
		}
		if(!isVisible(song)){
			err.add("Song name was not displayed on more info screen.");
		}
		if(!isVisible(artist)){
			err.add("Artist name was not displayed on more info screen.");
		}
		if(!isVisible(station)){
			err.add("Tune Station/Station Info was not displayed on more info screen.");
		}
		if(!isVisible(moreInfoLyrics)){
			err.add("Lyrics button was not displayed on more info screen.");
		}
		if(!isVisible(moreInfoArtistBio)){
			err.add("Artist bio was not displayed on more info screen.");
		}
		if(!isVisible(moreInfoShare)){
			err.add("Share button was not displayed on more info screen.");
		}
		if(!isVisible(moreInfoBuy)){
			err.add("Buy Song button was not displayed on more info screen.");
		}
		if(!isVisible(moreInfoClose)){
			err.add("Close button was not displayed on more info screen.");
		}
		
		return err.getErrors();
	}
	
	public String closeMoreInfo(){
		Errors err = new Errors();
		
		if(isVisible(moreInfoClose)){
			moreInfoClose.click();
			if(isVisible(moreInfoClose)){
				err.add("Clicking on close button did not close more info dialog.");
			}
		}
		else{
			err.add("More info button was not visible.");
		}
		
		return err.getErrors();
	}
	public String verifyAllMoreInfoItems(){
		Errors err = new Errors();
		String type = getType();
		// If the more info button is present, open the more info dialog and verify that everything is present
		if(isVisible(more)){
			err.add(openMoreInfo(type, false));
		}
		
		String station = "Tune Station";
		String lyrics = "Lyrics"; // Usually aren't present on live
		String buy = "Buy Song";
		if(type.equals("live")){
			station = "Station Info";
			lyrics = "";
			buy = ""; // If it's on a commercial or segment, you can't buy anyway
		}
	
		String[] testItems = {
			station,
			lyrics,
			"Artist Bio",
			"Share",
			buy
		};
		
		for(String t : testItems){
			if(!strGood(t)){
				continue;
			}
			err.add(verifyMoreInfoItem(t));
			handlePossiblePopUp();
			if(isVisible(more)){
				err.add(openMoreInfo(type, false));
			}
		}
		
		return err. getErrors();
	}
	
	private void skipUntilEnabled(IOSElement ele){
		if(!isVisible(ele)){
			return;
		}
		int enabledCount = 0;
		while (enabledCount < 7 && !ele.isEnabled()){
			enabledCount++;
			if(isVisible(moreInfoClose)){
				moreInfoClose.click();
			}
			if(isVisible(skip)){
				skip.click();
			}
			else if(isVisible(scan)){
				scan.click();
			}
			openMoreInfo(false); // This is called exclusively in a method that verifies this anyway
			waitForElementToBeEnabled(ele, 2); // Some elements may not be immediately enabled
		}
		if(!ele.isEnabled()){
			System.out.println("After trying a number of stations, could not find enabled version of element.");
			try{
				String text = ele.getText();
				if(strGood(text)){
					System.out.println("Check element with text: " + text);
				}
			}
			catch(Exception e){}
		}
	}
	
	public String verifyMoreInfoItem(String itemName){
		Errors err = new Errors();
		
		switch(itemName){
		case "Tune Station":
			if(isVisible(moreInfoTuneStation)){
				moreInfoTuneStation.click();
				// Test that X is present
				// Test the description of the tuner
				// Test the three options
				// Test the artist list (and that it changes if options are clicked)
				if(!isVisible(tuneStationClose)){
					err.add("Tune Station close button was not present");
				}
				if(!isVisible(tuneStationLabel)){
					err.add("Tune Station label was not present");
				}
				if(!isVisible(tuneStationDescription)){
					err.add("Tune Station description was not present");
				}
				if(!isVisible(tuneStationTopHits)){
					err.add("Tune Station Top Hits button was not present");
				}
				if(!isVisible(tuneStationMix)){
					err.add("Tune Station Mix button was not present");
				}
				if(!isVisible(tuneStationVariety)){
					err.add("Tune Station Variety button was not present");
				}
				if(!isVisible(tuneStationFeatured)){
					err.add("Tune Station featured artists label was not present");
				}
				if(!isVisible(tuneStationListOfArtists)){
					err.add("Tune Station list of featured artists was not present");
				}
				if(err.howMany() == 0){
					String artists = tuneStationListOfArtists.getText();
					tuneStationMix.click();
					if(artists.equals(tuneStationListOfArtists.getText())){
						err.add("List of artists did not change when selecing different tuning method (Mix).");
					}
					tuneStationVariety.click();
					if(artists.equals(tuneStationListOfArtists.getText())){
						err.add("List of artists did not change when selecing different tuning method (Variety).");
					}
					tuneStationTopHits.click();
					if(!artists.equals(tuneStationListOfArtists.getText())){
						err.add("List of artists did not change when selecing different tuning method (Top Hits).");
					}
				}
				
				tuneStationClose.click();
			}
			else{
				err.add("Tune Station is not visible");				
			}
			break;
		case "Station Info":
			if(isVisible(moreInfoRadioStationInfo)){
				if(!moreInfoRadioStationInfo.isEnabled()){
					skipUntilEnabled(moreInfoRadioStationInfo);
				}
				if(moreInfoRadioStationInfo.isEnabled()){
					moreInfoRadioStationInfo.click();
				}
				else{
					err.add("Could not find a station where Station Info was enabled.");
					break;
				}
				waitForElementToBeVisible(moreBack, 5);
				if(!isVisible(moreBack)){
					err.add("Back button for Station Info is not visible");
				}
				if(isVisible(stationInfoName)){
					if(!strGood(stationInfoName.getText())){
						err.add("Station title at top of station info page was empty.");
					}
				}
				else{
					err.add("Station title is not at the top of station info page.");
				}
				if(!isVisible(stationInfoLogo)){
					err.add("Station logo was not present in station info");
				}
				if(!isVisible(stationInfoNowPlaying)){
					if(isVisible(stationInfoSong)){
						err.add("\"Now Playing\" label was not displayed on station info page, though a song or segment was displayed as currently playing.");
					}
				}
				else{
					if(!isVisible(stationInfoSong)){
						err.add("Song or segment is not displayed under now playing label in station info");
					}
					if(!isVisible(stationInfoArtist)){
						err.add("Artist or station description was not visible under now playing segment in station info.");
					}
				}
				if(!isVisible(stationInfoView)){
					if(!isVisible(stationInfoNoContent)){
						err.add("Station info viewer is not visible in Station Info section "
								+ "and information telling the user that station content "
								+ "is not available is not present either.");
					}
					else{
						// Verify elements that display if we have station info
						// Just the basics, as this is the entire website and testing it would be like testing... well, the entire website... To do?
						// Check that The Feed and On Air tabs are available
						if(!isVisible(stationInfoTheFeed)){
							err.add("Station Info \"The Feed\" tab is not visible");
						}
						if(!isVisible(stationInfoOnAir)){
							err.add("Station Info \"The Feed\" tab is not visible");
						}
					}
				}
				
				moreBack.click();
			}
			else{
				err.add("Could not find Station Info button on more info page for live radio.");
			}
			break; 
		case "Lyrics":
			// Lyrics may not always be available. Only test if they are. Try to skip if not
			if(isVisible(moreInfoLyrics)){
				
				// Skip songs until we find one with lyrics
				skipUntilEnabled(moreInfoLyrics);
				
				if(isVisible(moreInfoLyrics) && !moreInfoLyrics.isEnabled()){
					err.add("More info lyrics were not enabled.");
				}
				moreInfoLyrics.click();
				waitForElementToBeVisible(lyricsSong, 1);
				if(!isVisible(lyricsSong)){
					err.add("Lyrics song title was not displayed");
				}
				if(!isVisible(lyricsArtist)){
					err.add("Lyrics artist name was not displayed");
				}
				if(!isVisible(lyricsView)){
					err.add("Lyrics were not displayed.");
				}
				if(isVisible(moreBack)){
					moreBack.click();
				}
				else{
					getBack(); // Tries a few ways
				}
			}
			else{
				 err.add("More info lyrics were not visible at all.");
			}
			break;
		case "Artist Bio":
			if(isVisible(moreInfoArtistBio)){
				// Skip until we find a song with an artist bio
				skipUntilEnabled(moreInfoArtistBio);
				if(isVisible(moreInfoArtistBio) && !moreInfoArtistBio.isEnabled()){
					err.add("More info artist bio button could not be enabled");
				}
				// Click
				moreInfoArtistBio.click();
				waitForElementToBeVisible(artistBioArtist, 1);
				// Test for the artist bio elements
				if(!isVisible(artistBioArtist)){
					err.add("Artist bio label was not visible");
				}
				if(!isVisible(artistBioBio)){
					err.add("Text for artist bio was not visible");
				}
			}
			else{
				err.add("Artist Bio button was not visible.");
			}
			break;
		case "Share": 
			if(isVisible(moreInfoShare)){
				moreInfoShare.click();
				// Share may not be available if a station is on a commercial break
				skipUntilEnabled(moreInfoShare);
				waitForElementToBeVisible(shareOptions, 2);
				if(!isVisible(shareOptions)){
					err.add("Sharing options were not visible");
				}
				if(!isVisible(shareCancel)){
					err.add("Share cancel button was not visible");
				}
				else{
					shareCancel.click();
				}
			}
			else{
				err.add("Share option was not visible");
			}
			break;
		case "Buy Song":// Not much to test here since it exits the app, leaving Appium automation behind
			if(!isVisible(moreInfoBuy)){
				err.add("Option to buy song was not present");
			}
			break;
		}
		
		if(isVisible(moreBack)){
			moreBack.click();
		}
		
		return err.getErrors();
	}
}
