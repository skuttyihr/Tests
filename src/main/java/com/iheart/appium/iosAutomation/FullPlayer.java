package com.iheart.appium.iosAutomation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.openqa.selenium.By;

import com.iheart.appium.iosAutomation.AppboyUpsellsPage.Entitlement;
import com.iheart.appium.utilities.Errors;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class FullPlayer extends Page {
	
	public FullPlayer() {
		super();
	}

	public FullPlayer(IOSDriver<IOSElement> _driver) {
		super(_driver);
		setPlayer(this);
	}
	
	 public enum entitlementType {FREE, PLUS, ALLA }

	//IHRPlayerTitleView
	@iOSFindBy(accessibility = "IHRPlayerTitleView-TitleLabel-UILabel") private IOSElement IHRPlayerTitleViewTitleLabelUILabel;
	@iOSFindBy(accessibility = "IHRPlayerTitleView-SubTitleLabel-UILabel") private IOSElement IHRPlayerTitleViewSubTitleLabelUILabel;
	@iOSFindBy(accessibility = "IHRPlayerTitleView-HeartView-UIImageView") private IOSElement IHRPlayerTitleViewHeartViewUIImageView;
	@iOSFindBy(accessibility = "NavBar-BackPlayer-UIButton") private IOSElement   NavBarBackPlayerUIButton;
	@iOSFindBy(accessibility = "PlayerView-MinimizePlayer-Downarrow-UIButton") private IOSElement PlayerViewMinimizePlayerDownarrowUIButton;
	@iOSFindBy(accessibility = "NavBar-SideMenuButton-UIButton") private IOSElement  NavBarSideMenuButtonUIButton;
	@iOSFindBy(accessibility = "NavBar-RightDisableableBarButton-UIButton") private IOSElement   NavBarRightDisableableBarButtonUIButton;
	@iOSFindBy(accessibility = "NavBar-SearchBarButton-UIButton") private IOSElement  NavBarSearchBarButtonUIButton;
	@iOSFindBy(accessibility = "NavBar-FavoriteButton-UIButton") private IOSElement   NavBarFavoriteButtonUIButton;
	@iOSFindBy(accessibility ="NavBar-ShareButton-UIButton") private IOSElement    NavBarShareButtonUIButton;
	@iOSFindBy(accessibility ="NavBar-StyledLabelWithTitle-UILabel") private IOSElement    NavBarStyledLabelWithTitleUILabel;
	@iOSFindBy(accessibility ="IHRCastingBarButtonItem-UIButton") private IOSElement IHRCastingBarButtonItemUIButton;
	@iOSFindBy(accessibility ="NavBar-BackButton-UIButton") private IOSElement NavBarBackButton;
	
	//IHRPlayerBackgroundView
	@iOSFindBy(accessibility ="IHRPlayerBackgroundView-ImageView-UIImageView") private IOSElement IHRPlayerBackgroundViewImageViewUIImageView;
	@iOSFindBy(accessibility ="IHRPlayerBackgroundView-VisualEffectView-UIVisualEffectView" ) private IOSElement IHRPlayerBackgroundViewVisualEffectViewUIVisualEffectView;
	//interface IHRPlayerView 
    @iOSFindBy(accessibility ="IHRPlayerView-BackgroundImageView-UIImageView") private IOSElement IHRPlayerViewBackgroundImageViewUIImageView;
    @iOSFindBy(accessibility ="IHRPlayerView-ImageView-UIImageView" ) private IOSElement IHRPlayerViewImageViewUIImageView;
    @iOSFindBy(accessibility ="IHRPlayerView-CenterView-UIView" ) private IOSElement IHRPlayerViewCenterViewUIView;
    @iOSFindBy(accessibility ="IHRPlayerView-SliderView-UIView") private IOSElement IHRPlayerViewSliderViewUIView;
    @iOSFindBy(accessibility ="IHRPlayerView-ButtonContainer-UIView" ) private IOSElement IHRPlayerViewButtonContainerUIView;
    @iOSFindBy(accessibility ="IHRPlayerView-PlayButton-UIButton" ) private IOSElement IHRPlayerViewPlayButtonUIButton;
    @iOSFindBy(accessibility ="IHRPlayerView-ForwardButton-UIButton" ) private IOSElement IHRPlayerViewForwardButtonUIButton;
    @iOSFindBy(accessibility ="IHRPlayerView-BackButton-UIButton") private IOSElement  IHRPlayerViewBackButtonUIButton;
    @iOSFindBy(accessibility ="IHRPlayer-SaveButton-UIButton" ) private IOSElement IHRPlayerSaveButtonUIButton;  
    @iOSFindBy(accessibility ="IHRPlayer-ReplayButton-UIButton" ) private IOSElement IHRPlayerReplayButtonUIButton;
    @iOSFindBy(accessibility ="IHRPlayer-MoreButton-UIButton" ) private IOSElement IHRPlayerMoreButtonUIButton;
    @iOSFindBy(accessibility ="IHRPlayerView-ThumbDownButton-UIButton" ) private IOSElement IHRPlayerViewThumbDownButtonUIButton;
    @iOSFindBy(accessibility ="IHRPlayerView-ThumbUpButton-UIButton" ) private IOSElement IHRPlayerViewThumbUpButtonUIButton;
    @iOSFindBy(accessibility ="IHRPlayerView-LabelContainer-UIView" ) private IOSElement IHRPlayerViewLabelContainerUIView;
    @iOSFindBy(accessibility ="IHRPlayerView-TitleLabel-UILabel" ) private IOSElement IHRPlayerViewTitleLabelUILabel;
    @iOSFindBy(accessibility ="IHRPlayerView-SubTitleLabel-UILabel" ) private IOSElement IHRPlayerViewSubTitleLabelUILabel;
    //IHRPlayerReplayTimerViewController    This isn't used yet
    @iOSFindBy(accessibility ="IHRPlayerReplayTimerView-BackgroundView-UIView" ) private IOSElement IHRPlayerReplayTimerViewBackgroundViewUIView;
    @iOSFindBy(accessibility ="IHRPlayerReplayTimerView-Label-UILabel" ) private IOSElement IHRPlayerReplayTimerViewLabelUILabel;
    @iOSFindBy(accessibility ="IHRPlayerReplayTimerView-ProgressView-UIView" ) private IOSElement IHRPlayerReplayTimerViewProgressViewUIView;
    @iOSFindBy(accessibility ="IHRPlayerReplayTimerView-CountLabel-UILabel" ) private IOSElement IHRPlayerReplayTimerViewCountLabelUILabel;
    @iOSFindBy(accessibility ="IHRPlayerReplayTimerView-CancelButton-UIButton" ) private IOSElement IHRPlayerReplayTimerViewCancelButtonUIButton;
    //PlayerCenterView
    @iOSFindBy(accessibility ="PlayerCenterView-BannerView-UIView" ) private IOSElement PlayerCenterViewBannerViewUIView;
    //PlayerSliderView
    @iOSFindBy(accessibility ="PlayerSliderView-PositionLabel-UILabel" ) private IOSElement PlayerSliderViewPositionLabelUILabel;
    @iOSFindBy(accessibility ="PlayerSliderView-DurationLabel-UILabel" ) private IOSElement PlayerSliderViewDurationLabelUILabel;
    @iOSFindBy(accessibility ="PlayerSliderView-ProgressSlider-UISlider" ) private IOSElement PlayerSliderViewProgressSliderUISlider;
    //CustomPlayerBannerController - Used for Ads - Don't look for it. 
    @iOSFindBy(accessibility ="PlayerBanner-BlackOverlay-UIView" ) private IOSElement PlayerBannerBlackOverlayUIView;
    @iOSFindBy(accessibility ="PlayerImageView-ImageView-UIImageView" ) private IOSElement PlayerImageViewImageViewUIImageView;
    //IHROptionMenuView
    @iOSFindBy(accessibility ="IHROptionMenuView-MenuContainer-UIView" ) private IOSElement IHROptionMenuViewMenuContainerUIView;
    @iOSFindBy(accessibility ="IHROptionMenuView-MetadataView-UIView" ) private IOSElement IHROptionMenuViewMetadataViewUIView;
    @iOSFindBy(accessibility ="IHROptionMenuView-UpperContainer-UIView" ) private IOSElement IHROptionMenuViewUpperContainerUIView;
    @iOSFindBy(accessibility ="IHROptionMenuView-DividerView-UIView" ) private IOSElement IHROptionMenuViewDividerViewUIView;
    @iOSFindBy(accessibility ="IHROptionMenuView-ButtonsContainer-UIView" ) private IOSElement IHROptionMenuViewButtonsContainerUIView;
    //These aren't true Objects - can't figure how to add AccessibilityIdentifiers to them. 
    @iOSFindBy(accessibility ="Buy on iTunes") private IOSElement buySongButton;
    @iOSFindBy(accessibility ="Lyrics") private IOSElement lyricsButton;
    @iOSFindBy(accessibility ="Go to Artist") private IOSElement goToArtistProfileButton;
    //OD - Click SaveButton and these should appear. Remove/Save Station are interchangeable. 
    @iOSFindBy(accessibility ="Remove Station") private IOSElement removeStationButton;  //Growl: Station removed from My Stations
    @iOSFindBy(accessibility ="Save Station") private IOSElement saveStationButton;  //Saved 'name' to My Stations
    @iOSFindBy(accessibility ="Save Song") private IOSElement saveSongButton; //Song saved to My Music
    @iOSFindBy(accessibility ="Add to Playlist") private IOSElement addToPlaylistButton;
    @iOSFindBy(accessibility ="Cancel") private IOSElement cancelOutOfSaveButton;
    
    @iOSFindBy(accessibility ="IHROptionMenuView-CancelButton-UIButton" ) private IOSElement IHROptionMenuViewCancelButtonUIButton;
    //Album and song title at the top of the More Info Option Menu screen
    @iOSFindBy(accessibility ="IHROptionMenuMetadataView-ImageView-UIImageView" ) private IOSElement IHROptionMenuMetadataViewImageViewUIImageView;
    @iOSFindBy(accessibility ="IHROptionMenuMetadataView-LabelContainer-UIView" ) private IOSElement IHROptionMenuMetadataViewLabelContainerUIView;
    @iOSFindBy(accessibility ="IHROptionMenuMetadataView-TitleLabel-UILabel" ) private IOSElement IHROptionMenuMetadataViewTitleLabelUILabel;
    @iOSFindBy(accessibility ="IHROptionMenuMetadataView-SubTitleLabel-UILabel" ) private IOSElement IHROptionMenuMetadataViewSubTitleLabelUILabel;
    //lyricsVC
    @iOSFindBy(accessibility ="LyricsVC-LyricsText-UIView" ) private IOSElement LyricsVCLyricsTextUIView;
    @iOSFindBy(accessibility ="LyricsVC-ArtistNameLabel-UILabel" ) private IOSElement LyricsVCArtistNameLabelUILabel;
    @iOSFindBy(accessibility ="LyricsVC-TrackNameLabel-UILabel" ) private IOSElement LyricsVCTrackNameLabelUILabel;
    
    @iOSFindBy(accessibility ="PlayButton-AnimatingView-UIImageView" ) private IOSElement PlayButtonAnimatingViewUIImageView;
    @iOSFindBy(accessibility ="PlayerBannerView-BannerContainerView-UIView" ) private IOSElement PlayerBannerViewBannerContainerViewUIView;
    @iOSFindBy(accessibility ="PlayerBannerView-DfpBanner-UIView" ) private IOSElement PlayerBannerViewDfpBannerUIView;
    @iOSFindBy(accessibility ="PlayerBannerView-SyncBannerView-UIView" ) private IOSElement PlayerBannerViewSyncBannerViewUIView;
    @iOSFindBy(accessibility ="PlayerBannerView-DismissButton-UIButton" ) private IOSElement PlayerBannerViewDismissButtonUIButton;

    //Replay Modal
    @iOSFindBy(accessibility ="IHRPlayerReplayOptionsViewController-TableView-UITableView" ) private IOSElement IHRPlayerReplayOptionsViewControllerTableViewUITableView;
    @iOSFindBy(accessibility ="IHRPlayerReplayOptionsViewController-CELL-0" ) private IOSElement IHRPlayerReplayOptionsViewControllerCELL0;
    @iOSFindBy(accessibility ="IHRPlayerReplayOptionsViewController-CELL-1" ) private IOSElement IHRPlayerReplayOptionsViewControllerCELL1;
    @iOSFindBy(accessibility ="IHRPlayerReplayOptionsViewController-CELL-2" ) private IOSElement IHRPlayerReplayOptionsViewControllerCELL2;

    /* - To be used
	@iOSFindBy(accessibility = "Great, we’ll play you more  songs like this.") public IOSElement artistThumbUpGrowl; // //UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]
	@iOSFindBy(accessibility = "OK, we'll adjust your music mix.") public IOSElement artistThumbDownGrowl;
	@iOSFindBy(accessibility = "Glad you like it!  We'll let our DJs know.") public IOSElement liveThumbUpGrowl; // //UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]
	@iOSFindBy(accessibility = "Thanks for the feedback. We'll let our DJs know you've  heard enough of this song.") public IOSElement liveThumbDownGrowl;
	@iOSFindBy(accessibility = "Great, we’ll play you more  episodes like this.") public IOSElement podcastThumbUpGrowl; // //UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]
	@iOSFindBy(accessibility = "OK, we’ll adjust your station.") public IOSElement podcastThumbDownGrowl;
	*/
    /**
     * Have Full Player Open and playing a SONG with Artist Radio before calling this method. 
     */
    public void showAllElements(){
    	System.out.println("Checking NavBar elements...");
    	printElementInformation(PlayerViewMinimizePlayerDownarrowUIButton);
    	//printElementInformation(NavBarFavoriteButtonUIButton); This button has been removed and replaced in the Save Modal
    	printElementInformation(NavBarShareButtonUIButton);
    	//printElementInformation(IHRCastingBarButtonItemUIButton);
    	System.out.println("Checking Slider elements...");
    	printElementName(PlayerSliderViewPositionLabelUILabel);
    	printElementName(PlayerSliderViewDurationLabelUILabel);
    	printElementInformation(PlayerSliderViewProgressSliderUISlider);
    	printElementInformation(PlayerImageViewImageViewUIImageView);
        //IHROptionMenuView
    	fullPlayer.clickMoreInfoButton();
    	System.out.println("Checking Option Menu View elements...");
    	printElementName(IHROptionMenuViewMenuContainerUIView);
    	printElementName(IHROptionMenuViewMetadataViewUIView);
    	printElementName(IHROptionMenuViewUpperContainerUIView);
    	printElementInformation(IHROptionMenuViewDividerViewUIView);
    	printElementInformation(IHROptionMenuViewButtonsContainerUIView);
    	printElementName(buySongButton);
    	printElementName(lyricsButton);
    	printElementName(goToArtistProfileButton);
    	printElementName(IHROptionMenuViewCancelButtonUIButton);
    	printElementName(IHROptionMenuMetadataViewImageViewUIImageView);
    	printElementName(IHROptionMenuMetadataViewLabelContainerUIView);
    	printElementName(IHROptionMenuMetadataViewTitleLabelUILabel);
    	printElementName(IHROptionMenuMetadataViewSubTitleLabelUILabel);
    	
    	if(fullPlayer.clickMoreLyricsButtonIfEnabled()){
    		System.out.println("Checking Lyrics Elements...");
    		printElementName(LyricsVCLyricsTextUIView);
    		printElementName(LyricsVCArtistNameLabelUILabel);
    		printElementInformation(LyricsVCTrackNameLabelUILabel);
    		fullPlayer.clickNavBarBackButton(); //This goes back to FullPlayers
    	}else{
    		fullPlayer.clickMoreCancelButton();
    	}
    	//IHRPlayerTitleView
    	System.out.println("Checking Title View elements... Station Name and Station Type");
    	printElementName(IHRPlayerTitleViewTitleLabelUILabel);
    	printElementName(IHRPlayerTitleViewSubTitleLabelUILabel);
    	//IHRPlayerBackgroundView
    	System.out.println("Checking Background View elements...");
    	printElementInformation(IHRPlayerBackgroundViewImageViewUIImageView);
    	printElementInformation(IHRPlayerBackgroundViewVisualEffectViewUIVisualEffectView);
    	//interface IHRPlayerView 
    	System.out.println("Checking FullPlayer elements...like Play Button, Skip, More Info, Thumbs, and Song Title/Artist");
    	printElementName(IHRPlayerViewBackgroundImageViewUIImageView);
    	printElementInformation(IHRPlayerViewImageViewUIImageView);
    	printElementInformation(IHRPlayerViewCenterViewUIView);
    	printElementName(IHRPlayerViewSliderViewUIView);
    	printElementInformation(IHRPlayerViewButtonContainerUIView);
    	printElementInformation(IHRPlayerViewPlayButtonUIButton);
    	printElementName(IHRPlayerViewForwardButtonUIButton);
    	printElementName(IHRPlayerMoreButtonUIButton);
    	printElementName(IHRPlayerViewThumbDownButtonUIButton);
    	printElementName(IHRPlayerViewThumbUpButtonUIButton);
    	printElementName(IHRPlayerViewLabelContainerUIView);
    	printElementInformation(IHRPlayerViewTitleLabelUILabel);
    	printElementName(IHRPlayerViewSubTitleLabelUILabel);
    	System.out.println("Checking if Replay and Save Buttons exist on FullPlayer");
    	printElementName(IHRPlayerReplayButtonUIButton);
    	printElementName(IHRPlayerSaveButtonUIButton);     
    }
    /**
     * Clicks the Down Arrow at the top of FullPlayer to minimize it into MiniPlayer. 
     */
    public void minimizeFullPlayerToMiniPlayer(){
    	System.out.println("minimizeFullPlayerToMiniPlayer()");
    	PlayerViewMinimizePlayerDownarrowUIButton.click();
    }
    /**
     * Clicks the Down Arrow at the top of FullPlayer to minimize it into MiniPlayer. 
     * This method has the same functionality as above but different wording to keep up the 'click' actions idea. 
     */
    public void clickDownArrowOnNavBarToMinimizeFullPlayer(){
    	//System.out.println("clickDownArrowOnNavBarToMinimizeFullPlayer()");
    	PlayerViewMinimizePlayerDownarrowUIButton.click();
    }
    /**
     * Clicks the Play, Pause, Stop etc Button on the Full Player.
     */
    public void clickPlayButton(){
    	//System.out.println("clickPlayButton()");
    	IHRPlayerViewPlayButtonUIButton.click();
    }
    
    /**
     * Clicks the Thumb Up Button. It can already be selected. 
     */
    public void clickThumbUpButton(){
    	//System.out.println("clickThumbUpButton()");
    	IHRPlayerViewThumbUpButtonUIButton.click();
    }
    
    /**
     * Clicks the Thumb Down button. It can already be selected. 
     */
    public void clickThumbDownButton(){
    	//System.out.println("clickThumbDownButton()");
    	IHRPlayerViewThumbDownButtonUIButton.click();
    }
    
    
	/**
	 * Returns true if Thumb Down Is activated and Thumb Up is NOT activated. 
	 * @return
	 */
	public boolean isThumbDownButtonActivated(){
		String thumbDownButtonChecked = IHRPlayerViewThumbDownButtonUIButton.getAttribute("value");
		boolean isDownChecked;
		if(thumbDownButtonChecked==null){
			isDownChecked = false;
		}
		else{
			isDownChecked = thumbDownButtonChecked.equals("true");
		}
		System.out.println("isThumbDownButtonActivated() : " + isDownChecked);
		return isDownChecked;
	}
	/**
	 * Returns true if Thumb Up is activated. Checks value on the button, if it returns a "true" string, it returns true, null returns false.
	 * @return
	 */
	public boolean isThumbUpButtonActivated(){
		String thumbUpButtonChecked = IHRPlayerViewThumbUpButtonUIButton.getAttribute("value");
		boolean isUpChecked;
		if(thumbUpButtonChecked==null){
			isUpChecked = false;
		}
		else if(thumbUpButtonChecked.equals("true")){
			isUpChecked = true;
		}
		else {
			isUpChecked = false;
		}
		System.out.println("isThumbUpButtonActivated() : " + isUpChecked);
		return isUpChecked;
	}
	
	/**
	 * Returns true if both Thumb Buttons are Not Selected. 
	 * @return
	 */
	public boolean isThumbUpAndThumbDownButtonNotActivated(){
		boolean thumbDownUpNotActivated = (!isThumbUpButtonActivated() && !isThumbDownButtonActivated() );
		System.out.println("isThumbUpAndThumbDownButtonNotActivated() : " + thumbDownUpNotActivated);
		return thumbDownUpNotActivated;
	}
	
	/**
	 * Clicks the Favorite Button (the Heart) on the NavBar at the top of the Full Player
	 * 
	 * A small alert will popup saying "Station added to Favorites" and then it will go away or...
	 * An alert will popup to ask if you want to get notifications about a favorite artist. Notify Me / Maybe Later are options.
	 * Clicking to Defavorite the Station will ask you to be sure - Yes / No are the options. 
	 */
	public void clickFavoriteButtonOnNavBar(Boolean clickYes, Boolean clickMaybeLater){
		System.out.println("clickFavoriteButtonOnNavBar() ");
		NavBarFavoriteButtonUIButton.click();
		//IOSElement unfavoriteMessage = waitForVisible(driver, By.name("Are you sure you want to remove this station from My Stations"), 10);
		//if(unfavoriteMessage.isDisplayed()){
		IOSElement yesButton =	waitForVisible(driver, By.name("Yes"), 5);
		IOSElement noButton =	waitForVisible(driver, By.name("No"), 5);
			if(yesButton != null && noButton != null){
				if(clickYes)
					yesButton.click();
				else noButton.click();
				System.out.println("Clicked on Yes Button to unFavorite the station");
			}
		IOSElement maybeLater = waitForVisible(driver, By.name("Maybe Later"), 5);
		IOSElement NotifyMe = waitForVisible(driver, By.name("Notify Me"), 5);
		if(maybeLater != null && NotifyMe!=null){
			if(clickMaybeLater){
				maybeLater.click();
				System.out.println("Clicked on 'Maybe Later'Button to Favorite the station, but not get notifications about favorite artist.");
			}
			else {
				NotifyMe.click();
				System.out.println("Clicked on 'Notify Me' Button to Favorite the station, AND get notifications about favorite artist.");
			}
		}
	}
	
	/**
	 * See if the Favorite Button is selected for the current station. 
	 * @return
	 */
	public boolean isFavoriteButtonOnNavBarSelected(){
		boolean isSelected = NavBarFavoriteButtonUIButton.isSelected();
		System.out.println("isFavoriteButtonOnNavBarSelected() isSelected? : " + isSelected);
		return isSelected;
	
	}
	
	/**
	 * Clicks the Share Button to share the current track to Social Media / Text etc. 
	 * Expect to call clickCancelOnShareMenuToReturnToFullPlayer() 
	 */
	public void clickShareButtonOnNavBar(){
		NavBarShareButtonUIButton.click();
		System.out.println("clickShareButtonOnNavBar(). " );
    	
	}
	/**
	 * Checks to see if the 'Mail' icon is there. 
	 * @return
	 */
	public boolean isShareMenuOpen(){
		IOSElement mailButton = waitForVisible(driver, By.name("Mail"), 10);
		boolean isThere = false;
		if(mailButton != null){
			isThere = true;
		}
		System.out.println("isShareMenuOpen() : "+ isThere);
		return isThere;
	}
	
	/**
	 * Clicks Cancel Button on the bottom of the Share Menu. Expect to return to Full Player. 
	 */
	public void clickCancelOnShareMenuToReturnToFullPlayer(){
		IOSElement cancelButton = waitForVisible(driver, By.name("Cancel"), 5);
		if(cancelButton !=null){
			cancelButton.click();
		}
		//System.out.println("clickCancelOnShareMenuToReturnToFullPlayer(). ");
		
	}
	/**
	 * Expects the Connect to a Device screen to come up. 
	 * Listening On - iPhone Simulator, iPhone, external device etc.
	 * There's a volume slider (doesn't work on Simulator)
	 * and a Close button. 
	 * 
	 * Expect to clickCloseOnConnectADevice to return to FullPlayer
	 * 
	 * 
	 */
	public void clickCastingAirplayButtonOnNavBar(){
		IHRCastingBarButtonItemUIButton.click();
		System.out.println("clickCastingAirplayButtonOnNavBar(). ");
	}
	/**
	 * Check to see if the Casting Button worked. 
	 * @return
	 */
	public boolean isConnectToADeviceDisplayed(){
		IOSElement connectToADevice = waitForVisible(driver, By.name("Connect to a Device"), 10);
		boolean isDisplayed = connectToADevice.isDisplayed();
		System.out.println("isConnectToADeviceOpen() : " + isDisplayed);
		return isDisplayed;
	}
	
	/**
	 * Finds the 'Close' button and clicks it and returns to Full Player. 
	 */
	public void clickCloseOnConnectADevice(){
		IOSElement closeButton = waitForVisible(driver, By.name("Close"), 10);
		closeButton.click();
		System.out.println("clickCloseOnConnectADevice().");
	}
	
	/**
	 * Checks if the IHRPlayerViewForwardButtonUIButton is present and then returns an integer equal to the number of Skips left. 
	 * Returns -1 if the label couldn't be found.
	 * sk - 3/2 - getText() isn't getting the whole label text ie. Skip. 5 skips remaining. It only returns skip.
	 * @return
	 */
	public int getNumberOfSkipsRemaining(){
		if (waitForElementToBeVisible(IHRPlayerViewForwardButtonUIButton, 4)) {
			String skips = IHRPlayerViewForwardButtonUIButton.getText();
			int skipsLeft = Integer.parseInt(skips.substring(6, 7));
			System.out.println("getNumberOfSkipsRemaining() : " + skipsLeft);
			return skipsLeft;
		}
		return 0;		
	}
	/**
	 * Clicks the Skip/ Scan Button
	 */
	public void clickSkipButton(){
		System.out.println("clickSkipButton()... ");
		if (waitForElementToBeVisible(IHRPlayerViewForwardButtonUIButton, 2))
			IHRPlayerViewForwardButtonUIButton.click();
	}
	
	/**
	 * Returns the Title of the Song playing. May also return the Station name if on Live Radio. 
	 * @return
	 */
	public String getTitleOfSongPlaying(){
		if (waitForElementToBeVisible(IHRPlayerViewTitleLabelUILabel,4)) {
			String title = IHRPlayerViewTitleLabelUILabel.getText();
			System.out.println("getTitleOfSongPlaying() : " + title);
			return title;
		}
		return "";
	}
	
	/**
	 * Returns the Artist of the Song playing. May also return the Station description if on Live Radio. 
	 * @return
	 */
	public String getSubTitleOfSongPlaying(){
		String title = IHRPlayerViewSubTitleLabelUILabel.getText();
		System.out.println("getSubTitleOfSongPlaying() : " + title);
		return title;
	}
	
	/**
	 * Checks the number of skips remaining, then skips, then rechecks and returns a true or false. Only call when there is at least two skips remaining.
	 * @return
	 */
	public boolean doesSkipCountDecreaseAfterClickingSkipButton(){
		System.out.println("doesSkipCountDecreaseAfterClickingSkipButton()");
		int start = fullPlayer.getNumberOfSkipsRemaining();
		if(start > 2){
			fullPlayer.clickSkipButton();
		}
		int end = fullPlayer.getNumberOfSkipsRemaining();
		return start > end;
	}
	
	/**
	 * Gets the String of the Station Name at the top of the FullPlayer Title View. 
	 * Also known as: IHRPlayerTitleViewTitleLabelUILabel
	 * @return
	 */
	public String getStationName(){
		String stationName = IHRPlayerTitleViewTitleLabelUILabel.getText();
		System.out.println("getStationName() : " + stationName);
		return stationName;
	}
	/**
	 * Gets the String of the Station Type at the top of the FullPlayer Title View. 
	 * Also known as: IHRPlayerTitleViewSubTitleLabelUILabel
	 * @return
	 */
	public String getStationType(){
		String stationType = IHRPlayerTitleViewSubTitleLabelUILabel.getText();
		System.out.println("getStationType() : " + stationType);
		return stationType;
	}
    
    /**
     * In the More Info pane on Full Player - it clicks the Back Button - the main NavBarBackButton. Can be used in Lyrics View, Artist Profile, etc.
     */
    public void clickNavBarBackButton() {
    	System.out.println("clickNavBarBackButton()");
    	NavBarBackButton.click();
	}

    /**
     * Gets the current location of the Position (in time) for the currently playing song. 
     * Note that using this in conjunction with getProgressSlider shouldn't be exactly equal to the percentage since these cammands take time.
     * @return
     */
    public String getPositionLabelText(){
    	String position = PlayerSliderViewPositionLabelUILabel.getText();
    	System.out.println("getPositionLabelText() : " + position);
    	return position;
    }
    /**
     * Gets the Duration(song length in time) for the currently playing song. 
     * Note that using this in conjunction with getProgressSlider shouldn't be exactly equal to the percentage since these cammands take time.
     * @return
     */
    public String getDurationLabelText(){
    	String duration = PlayerSliderViewDurationLabelUILabel.getText();
    	System.out.println("getDurationLabelText() : " + duration);
    	return duration;
    }
    /**
     * Gets the PlayerSliderViewProgressSliderUISlider played percentage for the currently playing song. 
     * position / duration = progress%, but first pause the player before checking this. 
     * @return
     */
    public String getProgressSliderText(){
    	String progress = PlayerSliderViewProgressSliderUISlider.getText();
    	System.out.println("getProgressLabelText() : " + progress);
    	return progress;
    }
    
    /**
     * This tests whether the Progress Slider Percentage is the same as the position and duration numbers. 
     * First Presses the Play/Pause button - best to have the player already running for a decent number of seconds first. 
     * Then gets the position and duration values, turns them into seconds, then gets the Progress text and turs it into a number. 
     * I don't really expect this to fail much, but it was fun to code.
     * 
     * @return
     */
    public boolean checkProgressSliderAlignedToPosition(){
    	clickPlayButton(); //Pause the player. 
    	String[] position = getPositionLabelText().split(":");
    	String[] duration = getDurationLabelText().split(":");
    	double pSeconds = Integer.parseInt(position[1]);
    	double dSeconds = Integer.parseInt(duration[1]);
    	for(int minuteCounter = 0; minuteCounter < Integer.parseInt(position[0]); minuteCounter++ ){
    		pSeconds+=60;
    	}
    	for(int minuteCounter = 0; minuteCounter < Integer.parseInt(duration[0]); minuteCounter++ ){
    		dSeconds+=60;
    	}
    	String progress = getProgressSliderText();
    	int progressPercentage = Integer.parseInt(progress.substring(0, progress.length()-1));
    	double val = pSeconds / dSeconds;
    	Double perc = new Double(val);
    	BigDecimal prog = new BigDecimal(new Double(progressPercentage));
    	System.out.println("Seconds passed in the song: " + pSeconds + " Total seconds: " + dSeconds + " Percentage :" + perc);
    	BigDecimal bd = new BigDecimal(perc);
    	prog = prog.divide(new BigDecimal("100"), new MathContext(2));
    	bd = bd.round(new MathContext(2, RoundingMode.HALF_UP));
    	System.out.println("Rounded bd : " + bd.toPlainString() + "   .    Progress% / 100 : " + prog.toPlainString());
    	bd = bd.subtract(prog);
    	System.out.println("Subtracted progress percentage from bd : " + bd.toPlainString());
    	BigDecimal one = new BigDecimal("1");
    	bd = bd.abs();
    	System.out.println("Absolute value of bd should be less than 1.0 : " + bd.toPlainString());
    	if(bd.abs().compareTo(one) < 0 ){ //we want compareTo to return -1, indicating that the bd is less than one.
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    /**
     * Returns a String of the type of Play Button it is. Could be Play, Pause, Stop etc. 
     * @return
     */
    public String getTypeOfPlayButton(){
    	String type = IHRPlayerViewPlayButtonUIButton.getText();
    	System.out.println("getTypeOfPlayButton() : " + type);
    	return type;
    }
	/**
     * Returns true if the Full Player is open. 
     * Does a Null Check on the element so there won't be a NoSuchElementException
     * @return
     */
    public boolean isCurrentlyOnFullPlayer(){
    	return isCurrentlyOn("isCurrentlyOnFullPlayer", IHRPlayerViewBackgroundImageViewUIImageView);
    }
    
    /**
     * Clicks the More Info button to show Metadata, Lyrics, Buy Song Button, and Artist Bio.
     * use fullPlayer.clickMoreCancelButton() to escape this view. 
     */
    public void clickMoreInfoButton(){
    	System.out.println("clickMoreInfoButton()...");
    	IHRPlayerMoreButtonUIButton.click();
    }
    /**
     * This checks if the OptionMenuView is displayed, indicating that the More Info button was clicked on FullPlayer.
     * This means that Go to Artist Profile, Lyrics, and Buy Song buttons should be visible, and a Cancel Button can be clicked as well.
     * use fullPlayer.clickMoreCancelButton()
     * @return
     */
    public boolean isOptionMenuOpen(){
    	return isCurrentlyOn("isOptionMenuOpen", IHROptionMenuViewMenuContainerUIView);
    }
    
    /**
     * On the More Info pane on the Full Player - We're expecting a Lyrics Button to appear.
     * This method clicks it and returns true if it's there, otherwise we return false. 
     * @return
     */
    public boolean clickMoreLyricsButtonIfEnabled(){
    	System.out.println("clickMoreLyricsButton() - On More Info Pane - clicking Lyrics");
    	if(lyricsButton.isEnabled()){
    		System.out.println("LyricsButton is Enabled? : " + lyricsButton.isEnabled() );
    		lyricsButton.click();
    		System.out.println("Clicked Lyrics Button. ");
    		return true;
    	}else{
    		System.out.println("Lyrics button wasn't enabled. - couldn't click. Returning False.");
    		return false;
    	}
    }
    
    /**
     * Expects the Simulator to be on More Info pane in Full Player. 
     * @return
     */
    public boolean clickGoToArtistProfileButtonIfEnabled(){
    	if(IHROptionMenuViewCancelButtonUIButton.isDisplayed()){
    		if(goToArtistProfileButton.isEnabled()){
    			System.out.println("clickGoToArtistProfileButtonIfEnabled() - On More Info Pane - clicking 'Go To Artist Profile'");
    			goToArtistProfileButton.click();
    			return true;
    		}else{
    			System.out.println("GoToArtistProfileButton wasn't enabled. - couldn't click. Returning False.");
    			return false;
    		}
    	}else{ 
    		return false;
    	}
    }
    
    /**
     * On the More Info Pane - click the Cancel Button. 
     * Option Menu View
     */
    public void clickMoreCancelButton(){
    	System.out.println("clickMoreCancelButton()");
    	IHROptionMenuViewCancelButtonUIButton.click();
    }
    /**
     * This must be tested. 
     * @return
     */
    public boolean isCurrentStationSaved(){
    	boolean isSaved = IHRPlayerTitleViewHeartViewUIImageView.isDisplayed();
    	System.out.println("isCurrentStationSaved() : "+ isSaved);
    	return isSaved;
    }
    /**
     * Only clicks the Save Button once - Other actions afterwards need to be taken.
     * @return
     */
    public boolean clickSaveButtonToOpenSaveModal(){
    	System.out.print("clickSaveButton() : Opening Save Overflow. SaveSongButton.isDisplayed() : ");
    	IHRPlayerSaveButtonUIButton.click();
    	//Save Modal should be up now
    	boolean isSaveSongVisible = saveSongButton.isDisplayed();
    	System.out.println(isSaveSongVisible);
    	return isSaveSongVisible;
    	
    }

    /**
     * Clicks the 'Replay' button to open the Replay Modal. If user is FREE -> expect Upsell Modal.
     * If User is Plus/AA, expect to be able to click a song or cancel. 
     * @return
     * sk - 2/24 - modified this method to account for Replay button being disabled when instream ads are playing.
     */
    public Errors clickReplayButtonToOpenReplayModal(){
    	Errors err = new Errors();
    	while (!waitForElementToBeEnabled(IHRPlayerReplayButtonUIButton, 10)) {
    		err.add("Replay button was disabled - could have been playing non-track content on live radio.");
    		return err;
    	}
    	if(waitForElementToBeVisible(IHRPlayerReplayButtonUIButton, 4)) {
    		IHRPlayerReplayButtonUIButton.click();
    		System.out.println("clickReplayButtonToOpenReplayModal(): Clicked.");
    	}
    	else
    		err.add("Replay button was not displayed/visible on full player.");
		return err;
    }
    /**
     * Clicks the Add to Playlist Button, uses String entitlement to determine expected action. 
     * entitlement must be "FREE", "PLUS", or "ALLACCESS"
     */
    public boolean clickAddToPlaylistButtonInSaveModal(String entitlement){
    	if(entitlement!= null && addToPlaylistButton != null && !entitlement.equals("")){
    		if(entitlement.equals("FREE")){
    			addToPlaylistButton.click();
    			System.out.println("AddToPlaylistButton was clicked for FREE User - Expect Upsell Modal to appear");
    			return upsellPage.isUpsellModalOpen();
    		}else if(entitlement.equals("PLUS")){
    			addToPlaylistButton.click();
    			System.out.println("AddToPlaylistButton was clicked for PLUS User - Expect Upsell Modal to appear");
    			return upsellPage.isUpsellModalOpen();
    			//return upsellPage.isad
    		}else if(entitlement.equals("ALLACCESS")){
    			addToPlaylistButton.click();
    			System.out.println("AddToPlaylistButton was clicked for ALLACCESS User - Expect Add to Playlist Modal to appear");
    			//addToPlaylistModal.clickFirstPlaylist(); This can be filled in once AddToPlaylist page Object is done!!!!
    			return true;
    		}else return false;
    	}else return false;
    }
    /**
     * Clicks the Save Song button in the Save Modal to Save currently playing song to My Playlist. 
     * @return fullPlayer.isCurrentlyOnFullPlayer();
     */
    public boolean clickSaveSongInSaveModal(){
    	if(saveSongButton != null){
    		saveSongButton.click();
    		System.out.println("clickSaveSongInSaveModal().");
    	}
    	return fullPlayer.isCurrentlyOnFullPlayer();
    }
    /**
     * Clicks the Remove Station button in the Save Station Modal, and returns whether it reached the FullPlayer.
     * @return fullPlayer.isCurrentlyOnFullPlayer();
     */
    public boolean clickRemoveStationInSaveModal(){
    	if(removeStationButton!=null){
    		removeStationButton.click();
    		System.out.println("clickRemoveStationInSaveModal().");
    	}
    	
    	return fullPlayer.isCurrentlyOnFullPlayer();
    }
    /**
     * Clicks the Cancel Button on the bottom of the Save Modal to return to the FullPlayer.
     * @return fullPlayer.isCurrentlyOnFullPlayer();
     */
    public boolean clickCancelInSaveModal(){
    	if(cancelOutOfSaveButton!= null){
    		cancelOutOfSaveButton.click();
    	}
    	System.out.println("clickCancelInSaveModal().");
    	return fullPlayer.isCurrentlyOnFullPlayer();
    }
    /**
     * Clicks the Save Station to 'Heart' or 'Favorite' the Station. 
     * @return fullPlayer.isCurrentlyOnFullPlayer();
     */
    public boolean clickSaveStationInSaveModal(){
    	if(saveStationButton != null){
    		saveStationButton.click();
    	}
    	System.out.println("clickSaveStationInSaveModal().");
    	return fullPlayer.isCurrentlyOnFullPlayer();
    }
    /**
     * Checks if the 'Remove Station' is available/displayed. 
     * Precondition : Clicked Save button on FullPlayer and already Saved Station. 
     * @return boolean
     */
    public boolean isRemoveStationInSaveModalDisplayed(){
    	return (fullPlayer.isCurrentlyOn("isCurrentlyOnSaveModal with 'Remove Station' Button", removeStationButton));
    }
    /**
     * Checks if the 'Save Station' is available/displayed.
     * Precondition : Clicked Save button on FullPlayer and already Saved Station. 
     * @return
     */
    public boolean isSaveStationInSaveModalDisplayed(){
    	return (fullPlayer.isCurrentlyOn("isCurrentlyOnSaveModal with 'Save Station' Button", saveStationButton));
    }
    
    /**
     * Checks if the Replay Modal is currently open by passing in the TableView element.
     * @return
     */
    public boolean isCurrentlyOnReplayModal(){
    	return (fullPlayer.isCurrentlyOn("isCurrentlyOnReplayModal()", IHRPlayerReplayOptionsViewControllerTableViewUITableView));

    }
    /**
     * Checks if the First Cell in Replay Modal is displayed. It can be clicked hereafter.
     * @return
     */
    public boolean isCurrentlyOnReplayFirstTrackCell(){
    	return (fullPlayer.isCurrentlyOn("isCurrentlyOnReplayModal()", IHRPlayerReplayOptionsViewControllerCELL0));
    }
    /**
     * Clicks the First Replay Cell. This should be the current song playing.
     * @return
     */
    public boolean clickReplayFirstCell(){
    	if(IHRPlayerReplayOptionsViewControllerCELL0!=null){
    		 IHRPlayerReplayOptionsViewControllerCELL0.click();
    		System.out.println("clickReplayFirstCell().");
    		return true;
    	} return false;
    }
    /**
     * Clicks the Second Replay Cell. This should be the last song played(even if skipped).
     * @return
     */
    public boolean clickReplaySecondCell(){
    	if(IHRPlayerReplayOptionsViewControllerCELL1!=null){
    		 IHRPlayerReplayOptionsViewControllerCELL1.click();
    		System.out.println("clickReplaySecondCell().");
    		return true;
    	} return false;
    }
    /**
     * Clicks the Third Replay Cell. This should be the second to last song played.
     * @return
     */
    public boolean clickReplayThirdCell(){
    	if(IHRPlayerReplayOptionsViewControllerCELL2!=null){
    		IHRPlayerReplayOptionsViewControllerCELL2.click();
    		System.out.println("clickReplayThirdCell().");
    		return true;
    	} return false;
    }

    /**
     * Runs the isCurrentlyOn Method for the HeartView Image that shows up next to the Station name on Full Player. 
     * @return
     */
    public boolean isStationHearted(){
    	return isCurrentlyOn("isStationHearted", IHRPlayerTitleViewHeartViewUIImageView);
    }
    /**
     * sk - 2/26 - Skip to the skip limit
     */
    public void skipToTheLimit() {
    	int i = 0;
    	if (isCurrentlyOnFullPlayer()) {
    		clickSkipButton();
    		while (!(isVisible(appboyUpsellsPage.getNewFeatureTag()) && isVisible(IHRPlayerViewForwardButtonUIButton))) {
    			clickSkipButton();
    			i++;
    			if (i > 7)
    				break;
    		}
    		if(i==5) {
    			String trackName = getTitleOfSongPlaying();
    			System.out.println("TrackName at " + i + " skips remaining: '" + trackName +"'");
    		}
    	}
    }

    /**
     * sk - 2/27 - there is another method above that does the same thing. However considering that we cannot really click the 
     * Save Song or Add to Playlist options without clicking the Save button first, I'm adding that in as a first step.
     * Changes made are:
     * 1. Adding in click on Save button first
     * 2. Changed the method to return Errors object to capture text on what actually failed. Have found that this helps to identify 
     * 	  step and reason failure quickly as compared to only a screenshot.
     * This will help make the actual test more compact.
     * I am not removing the existing method cause FullPlayer tests are using that.
     * I'll add in a ticket to refactor the FullPlayer tests with this method if we all agree on it?
     */
    public Errors clickSaveModalAddToPlaylist(Entitlement entitlement) {
    	Errors err = new Errors();
    	if (clickSaveButtonToOpenSaveModal()) {
    		if(entitlement!= null && addToPlaylistButton != null && !entitlement.equals("")) {
    			// check if Add to Playlist button is enabled, else return error
    			if(entitlement.equals(entitlementType.FREE) && isVisible(addToPlaylistButton)) {
    				addToPlaylistButton.click();
    			}
    			else {
    				err.add("Add to playlist button was not enabled - this can occur if station tested is a live radio.");
    				return err;
    			}
    			//check if upsell is displayed after clicking Add to Playlist button
    			if (!(appboyUpsellsPage.isUpsellDisplayed())) {
    				err.add("Upsell page was not displayed on clicking Save Modal - Add to Playlist button for Free User");
    				return err;
    			}
    			return err;
    		}
    		else if(entitlement.equals(entitlementType.PLUS)) {
    			// check if Add to Playlist button is enabled, else return error
    			if (isEnabled(addToPlaylistButton)) {
    				addToPlaylistButton.click();
    			} 
    			else {
    				err.add("Add to playlist button was not enabled - this can occur if station tested is a live radio.");
    				return err;
    			}
    			//check if upsell is displayed after clicking Add to Playlist button
    			if (!(appboyUpsellsPage.isUpsellDisplayed())) {
    				err.add("Upsell page was not displayed on clicking Save Modal - Add to Playlist button for Plus User");
    				return err;
    			}
    			return err;
    		}
    		else if(entitlement.equals(entitlementType.ALLA)) {
    			if (isEnabled(addToPlaylistButton)) {
    				addToPlaylistButton.click();
    			} 
    			else {
    				err.add("Add to playlist button was not enabled - this can occur if station tested is a live radio.");
    				return err;
    			}
    			//check if upsell is displayed after clicking Add to Playlist button
    			if (!(appboyUpsellsPage.isUpsellDisplayed())) {
    				err.add("Upsell page was not displayed on clicking Save Modal - Add to Playlist button for AA User");
    				return err;
    			}
    			return err;
    		}
    	}
    	else {
    		err.add("Player - Save modal did not open");
    		return err;
    	}
    	return err;
    }
}