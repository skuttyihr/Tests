package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MiniPlayer extends Page {
	public MiniPlayer(){
		super();
	}
	public MiniPlayer(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]") public IOSElement miniPlayerBar;
	@iOSFindBy(accessibility = "Pause") public IOSElement miniPlayerPause;
	@iOSFindBy(accessibility = "Play") public IOSElement miniPlayerPlay;
	@iOSFindBy(accessibility = "Stop") public IOSElement miniPlayerStop;
	@iOSFindBy(accessibility = "Thumb up") public IOSElement miniPlayerThumbUp;
	@iOSFindBy(accessibility = "Thumb down") public IOSElement miniPlayerThumbDown;
	@iOSFindBy(accessibility = "Skip") public IOSElement miniPlayerSkip;
	@iOSFindBy(accessibility = "Player_Scan") public IOSElement miniPlayerScan;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]") public IOSElement miniPlayerSongTitle;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[2]") public IOSElement miniPlayerArtist;
	
	public boolean loadUpMiniPlayer(){
		return loadUpMiniPlayer("Alternative") != null; // Can play a station that won't require login
	}
	
	/**
	 * Plays a song and returns to the home screen
	 * 
	 * A note: Full player will always load the first time you play a station on an install(a fresh emulator instance). After, it will load miniplayer. 
	 * 
	 */
	public String loadUpMiniPlayer(String searchTerm){
		System.out.println("Loading up Mini Player");
		if(search.searchForStation(searchTerm) == null){
			return "Could not search for: " + searchTerm + ". ";
		}
		System.out.println("About to wait for Track to load");
		Player.waitForTrackToLoad();
		System.out.println("Track is loaded");
		if(!isVisible(miniPlayerBar)){
			//This means full player is visible
			player.minimizePlayer();
			System.out.println("Miniplayer did not display after Search because when Simulator is rebuilt, Full Player always starts!");
			//return "Mini player did not display! ";
		}
		sideNavBar.gotoHomePage();
		return "";
		
		/*
		
		if(isVisible(player.back)){
			player.back.click();
			System.out.println("Player.back.click() has been clicked");
		}
		else{
			return "Could not load player. ";
		}
		waitForElementToBeVisible(search.cancel, 3);
		search.cancel.click();
		System.out.println("Clicked Search - Cancel");
		sideNavBar.gotoHomePage(); // Ensure we're on home page
		if(!isVisible(miniPlayerBar)){
			return "Mini player did not display! ";
		}
		return "";
		*/
	}
	
	public boolean maximizeMiniPlayer(){
		System.out.println("Maximizing the mini player");
		waitForElementToBeVisible(miniPlayerBar, 3);
		if(!isVisible(miniPlayerBar)){
			return false;
		}
		miniPlayerBar.click();
		return player.isPlaying();
	}
	
	public boolean minimizePlayer(){
		System.out.println("Minimizing the player");
		return player.minimizePlayer();
	}
	
	public boolean isThumbedUp(){
		waitForElementToBeVisible(miniPlayerThumbUp, 3);
		String val = miniPlayerThumbUp.getAttribute("value");
		if(strGood(val)){
			if (Integer.parseInt(val) == 1){
				return true;
			}
			return false;
		}
		else{
			return false;
		}
	}
	public boolean isThumbedDown(){
		waitForElementToBeVisible(miniPlayerThumbDown, 3);
		String val = miniPlayerThumbDown.getAttribute("value");
		if(strGood(val)){
			if (Integer.parseInt(val) == 1){
				return true;
			}
			return false;
		}
		else{
			return false;
		}
	}
	
	public boolean thumbUp(){
		// If the track is already thumbed up, 
		//		reset it so we can test the mini player's capability in thumbing up
		if(isThumbedUp()){
			miniPlayerThumbUp.click();
		}
		miniPlayerThumbUp.click();
		return isThumbedUp();
	}
	public boolean thumbDown(){
		// If the track is already thumbed up, 
		//		reset it so we can test the mini player's capability in thumbing up
		if(isThumbedDown()){
			miniPlayerThumbDown.click();
		}
		miniPlayerThumbDown.click();
		return isThumbedDown();
	}

	/**
	 * Toggle play/pause
	 * @return
	 */
	public boolean pausePlay(){
		if(isVisible(miniPlayerPause)){
			miniPlayerPause.click();
			return true;
		}
		if(isVisible(miniPlayerPlay)){
			miniPlayerPlay.click();
			return true;
		}
		return false;
	}
	public boolean stop(){
		if(isVisible(miniPlayerStop)){
			miniPlayerStop.click();
		}
		return isVisible(miniPlayerPlay);
	}
	
	public boolean isStreaming(){
		return isVisible(miniPlayerPause);
	}
	
	/**
	 * Pauses, returns true if the stream has been paused
	 * @return
	 */
	public boolean pause(){
		boolean paused = false;
		boolean couldPause = false;
		if(isStreaming()){
			paused = pausePlay();
		}
		else{
			// Unpause and pause so we can test pausing capabilities
			pausePlay();
			paused = pausePlay();
		}
		if(paused){
			miniPlayerBar.click();
			// Test player isPaused to ensure stream was paused
			couldPause = !player.isStreaming();
			player.minimizePlayer(); // Return to mini player
		}
		else{
			return false;
		}
		return couldPause;
	}
	
	/**
	 * Un-pauses or plays music, returns true if playing music
	 * @return
	 */
	public boolean play(){
		boolean playing = false;
		boolean couldPlay = false;
		
		if(!isStreaming()){
			playing = pausePlay();
		}
		else{
			pausePlay();
			playing = pausePlay();
		}
		
		if(playing){
			miniPlayerBar.click();
			couldPlay = player.isStreaming();
			player.minimizePlayer();
		}
		else{
			return false;
		}
		
		return couldPlay;
	}
	
	public String getSongName(){
		String songTitle = "";
		if(isVisible(miniPlayerSongTitle)){
			songTitle = miniPlayerSongTitle.getText();
		}
		return songTitle;
	}
	public String getArtist(){
		String artist = "";
		if(isVisible(miniPlayerArtist)){
			artist = miniPlayerArtist.getText();
		}
		return artist;
	}
	
	public boolean skip(){
		boolean songSkipped = false;
		String firstSong = getSongName();
		if(isVisible(miniPlayerBar)){
			int startX = getAppWidth();
			int endX = 0;
			int y = miniPlayerBar.getLocation().getY() + (miniPlayerBar.getSize().getHeight() / 2);
			try{
				driver.swipe(startX, y, endX, y, 500);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			return false;
		}
		
		if(isVisible(miniPlayerSkip)){
			miniPlayerSkip.click();
		}
		else if(isVisible(miniPlayerScan)){
			miniPlayerScan.click();
		}
		songSkipped = !(getSongName().equals(firstSong));
		
		return songSkipped;
	}
	
	public Errors verifyControls(){
		Errors errors = new Errors();
		
		// Thumb up and down (if they're not disabled)
		System.out.println("Verifying controls for the Miniplayer");
		if(miniPlayerThumbDown.isEnabled()
				&& miniPlayerThumbUp.isEnabled()){
			System.out.println("Verifying MiniPlayer ThumbDown and ThumbUp");
			if(!thumbDown()){
				errors.add("Could not thumb down track on mini player.\n");
			}
			if(!thumbUp()){ // Do this so we're not downvoting all the tracks
				errors.add("Could not thumb up track on mini player.\n"); 
			}
			if(isThumbedDown()){
				errors.add("Mini player thumbs did nopt toggle when we thumbed up a track.\n");
			}
		}
		
		// Play and pause
		System.out.println("Verifying Play and Pause for MiniPlayer");
		if(isVisible(miniPlayerPlay)){
			miniPlayer.play();
		}
		if(!isVisible(miniPlayerStop)){
			if(!miniPlayer.pause()){
				errors.add("Could not pause from mini player.\n");
			}
			if(!miniPlayer.play()){
				errors.add("Could not play from mini player\n");
			}
		}
		else{
			try{
				miniPlayerStop.click();
				miniPlayerPlay.click();
			}
			catch(Exception e){
				errors.add("Could not stop/play live radio station.\n");
			}
		}
		
		// Verify info
		System.out.println("Verifying Artist, Song Name, and Skip feature.");
		if(!strGood(getArtist())){
			errors.add("Was not displaying artist.\n");
		}
		if(!strGood(getSongName())){
			errors.add("Was not displaying song.\n");
		}
		
		// Skip
		if(!skip()){
			errors.add("Could not skip.\n");
		}
		
		return errors;
	}
}
