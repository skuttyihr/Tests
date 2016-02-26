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
	@iOSFindBy(name = "Pause") public IOSElement miniPlayerPause;
	@iOSFindBy(name = "Play") public IOSElement miniPlayerPlay;
	@iOSFindBy(name = "Thumb up") public IOSElement miniPlayerThumbUp;
	@iOSFindBy(name = "Thumb down") public IOSElement miniPlayerThumbDown;
	@iOSFindBy(name = "miniplayer_skip_button") public IOSElement miniPlayerSkip;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]") public IOSElement miniPlayerSongTitle;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[2]") public IOSElement miniPlayerArtist;
	
	//TODO:
	// Create and minimize
	// Thumb up
	// Thumb down
	// Get song name
	// Get artist
	// pause/play
	//get pause or play status
}
