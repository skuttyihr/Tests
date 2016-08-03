package com.iheart.appium.iosAutomation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.openqa.selenium.By;

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
    @iOSFindBy(accessibility ="IHRPlayer-SaveButton-UIButton" ) private IOSElement IHRPlayerSaveButtonUIButton;  //(OD only)
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
    @iOSFindBy(accessibility ="Buy Song") private IOSElement BuySongButton;
    @iOSFindBy(accessibility ="Lyrics") private IOSElement LyricsButton;
    @iOSFindBy(accessibility ="Go to Artist Profile") private IOSElement GoToArtistProfileButton;
    //Coming with OD
    @iOSFindBy(accessibility ="Remove Station") private IOSElement RemoveStationButton;
    @iOSFindBy(accessibility ="Save Station") private IOSElement SaveStationButton;
    @iOSFindBy(accessibility ="Save Song") private IOSElement SaveSongButton;
    @iOSFindBy(accessibility ="Save to Playlist") private IOSElement SaveToPlaylistButton;
    
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
    
    
    //@iOSFindBy(accessibility ="LyricsView-TrackNameLabel-UIlabel" ) private IOSElement LyricsViewTrackNameLabelUIlabel;
    //@iOSFindBy(accessibility ="LyricsView-ArtistNameLabel-UILabel" ) private IOSElement LyricsViewArtistNameLabelUILabel;
    @iOSFindBy(accessibility ="PlayButton-AnimatingView-UIImageView" ) private IOSElement PlayButtonAnimatingViewUIImageView;
    @iOSFindBy(accessibility ="IHRPlayerViewNextButton-SkipCountLabel-UILabel" ) private IOSElement IHRPlayerViewNextButtonSkipCountLabelUILabel;
    @iOSFindBy(accessibility ="PlayerBannerView-BannerContainerView-UIView" ) private IOSElement PlayerBannerViewBannerContainerViewUIView;
    @iOSFindBy(accessibility ="PlayerBannerView-DfpBanner-UIView" ) private IOSElement PlayerBannerViewDfpBannerUIView;
    @iOSFindBy(accessibility ="PlayerBannerView-SyncBannerView-UIView" ) private IOSElement PlayerBannerViewSyncBannerViewUIView;
    @iOSFindBy(accessibility ="PlayerBannerView-DismissButton-UIButton" ) private IOSElement PlayerBannerViewDismissButtonUIButton;
    //@iOSFindBy(accessibility ="" ) private IOSElement ;
    
    /**
     * Have Full Player Open and playing a SONG with Artist Radio before calling this method. 
     */
    public void showAllElements(){
    	
    	System.out.println("Checking NavBar elements...");

    	printElementInformation(PlayerViewMinimizePlayerDownarrowUIButton);
    	printElementInformation(NavBarFavoriteButtonUIButton);
    	printElementInformation(NavBarShareButtonUIButton);
    	printElementInformation(IHRCastingBarButtonItemUIButton);
    	//printElementInformation(NavBarStyledLabelWithTitleUILabel);
    	
    	printElementInformation(IHRPlayerViewNextButtonSkipCountLabelUILabel);
    	printElementInformation(PlayerSliderViewPositionLabelUILabel);
    	printElementInformation(PlayerSliderViewDurationLabelUILabel);
    	printElementInformation(PlayerSliderViewProgressSliderUISlider);
        //CustomPlayerBannerController
    	if(checkProgressSliderAlignedToPosition()){
    		System.out.println("Progress Slider is aligned to Position - checked the math.");
    	}
    	
    	printElementInformation(PlayerImageViewImageViewUIImageView);
        //IHROptionMenuView
    	fullPlayer.clickMoreInfoButton();
    	System.out.println("Checking Option Menu View elements...");
    	printElementInformation(IHROptionMenuViewMenuContainerUIView);
    	printElementInformation(IHROptionMenuViewMetadataViewUIView);
    	printElementInformation(IHROptionMenuViewUpperContainerUIView);
    	printElementInformation(IHROptionMenuViewDividerViewUIView);
    	printElementInformation(IHROptionMenuViewButtonsContainerUIView);
    	printElementInformation(BuySongButton);
    	printElementInformation(LyricsButton);
    	printElementInformation(GoToArtistProfileButton);
    	printElementInformation(IHROptionMenuViewCancelButtonUIButton);
        //
    	printElementInformation(IHROptionMenuMetadataViewImageViewUIImageView);
    	printElementInformation(IHROptionMenuMetadataViewLabelContainerUIView);
    	printElementInformation(IHROptionMenuMetadataViewTitleLabelUILabel);
    	printElementInformation(IHROptionMenuMetadataViewSubTitleLabelUILabel);
    	
    	if(fullPlayer.clickMoreLyricsButtonIfEnabled()){
    	
    		printElementInformation(LyricsVCLyricsTextUIView);
    		printElementInformation(LyricsVCArtistNameLabelUILabel);
    		printElementInformation(LyricsVCTrackNameLabelUILabel);
    		fullPlayer.clickNavBarBackButton(); //This goes back to FullPlayers
    	}else{
    	//if(!fullPlayer.isCurrentlyOnFullPlayer()){
    		fullPlayer.clickMoreCancelButton();
    	}
    	/*
    	if(fullPlayer.clickGoToArtistProfileButtonIfEnabled()){
    		//test Artist Profile stuff. 
    		fullPlayer.clickNavBarBackButton();
    	}
    	*/
    	//Should exit back to the main Full Player View
    	//These work!
    	//IHRPlayerTitleView
    	printElementInformation(IHRPlayerTitleViewTitleLabelUILabel);
    	printElementInformation(IHRPlayerTitleViewSubTitleLabelUILabel);
    	
    	//IHRPlayerBackgroundView
    	printElementInformation(IHRPlayerBackgroundViewImageViewUIImageView);
    	printElementInformation(IHRPlayerBackgroundViewVisualEffectViewUIVisualEffectView);
    	//interface IHRPlayerView 
    	printElementInformation(IHRPlayerViewBackgroundImageViewUIImageView);
    	printElementInformation(IHRPlayerViewImageViewUIImageView);
    	printElementInformation(IHRPlayerViewCenterViewUIView);
    	printElementInformation(IHRPlayerViewSliderViewUIView);
    	printElementInformation(IHRPlayerViewButtonContainerUIView);
    	printElementInformation(IHRPlayerViewPlayButtonUIButton);
    	printElementInformation(IHRPlayerViewForwardButtonUIButton);
    	
    	printElementInformation(IHRPlayerMoreButtonUIButton);
    	printElementInformation(IHRPlayerViewThumbDownButtonUIButton);
    	printElementInformation(IHRPlayerViewThumbUpButtonUIButton);
    	printElementInformation(IHRPlayerViewLabelContainerUIView);
    	printElementInformation(IHRPlayerViewTitleLabelUILabel);
    	printElementInformation(IHRPlayerViewSubTitleLabelUILabel);
        //IHRPlayerReplayTimerViewController    //Enable when we get to On Demand
    	//printElementInformation(IHRPlayerReplayTimerViewBackgroundViewUIView);
    	//printElementInformation(IHRPlayerReplayTimerViewLabelUILabel);
    	//printElementInformation(IHRPlayerReplayTimerViewProgressViewUIView);
    	//printElementInformation(IHRPlayerReplayTimerViewCountLabelUILabel);
    	//printElementInformation(IHRPlayerReplayTimerViewCancelButtonUIButton);
        //PlayerCenterView
    	//printElementInformation(PlayerCenterViewBannerViewUIView);
        //PlayerSliderView
    	//printElementInformation(PlayButtonAnimatingViewUIImageView);
    	//printElementInformation(IHRPlayerViewBackButtonUIButton); //Enable when we get to On Demand
    	//printElementInformation(IHRPlayerSaveButtonUIButton);     //Enable when we get to On Demand
    	//Probably ads.
     	//printElementInformation(PlayerBannerViewBannerContainerViewUIView);
    	//printElementInformation(PlayerBannerViewDfpBannerUIView);
    	//printElementInformation(PlayerBannerViewSyncBannerViewUIView);
    	//printElementInformation(PlayerBannerViewDismissButtonUIButton);
    	//printElementInformation(PlayerBannerBlackOverlayUIView);
    	//printElementInformation(IHRPlayerTitleViewHeartViewUIImageView);  This basically needs to be removed. 
    	//printElementInformation(NavBarBackPlayerUIButton);
    	//printElementInformation(NavBarSideMenuButtonUIButton);
    	//printElementInformation(NavBarRightDisableableBarButtonUIButton);
    	//printElementInformation(NavBarSearchBarButtonUIButton);
    	
    }
    
    public void minimizeFullPlayerToMiniPlayer(){
    	System.out.println("minimizeFullPlayerToMiniPlayer()");
    	PlayerViewMinimizePlayerDownarrowUIButton.click();
    	
    }
    /**
     * Clicks the Play, Pause, Stop etc Button on the Full Player.
     */
    public void clickPlayButton(){
    	System.out.println("clickPlayButton()");
    	IHRPlayerViewPlayButtonUIButton.click();
    }
    
    /**
     * Clicks the Thumb Up Button. It can already be selected. 
     */
    public void clickThumbUpButton(){
    	System.out.println("clickThumbUpButton()");
    	IHRPlayerViewThumbUpButtonUIButton.click();
    }
    
    /**
     * Clicks the Thumb Down button. It can already be selected. 
     */
    public void clickThumbDownButton(){
    	System.out.println("clickThumbDownButton()");
    	IHRPlayerViewThumbDownButtonUIButton.click();
    }
    
    /**
	 * Returns true if Thumb Up is activated and Thumb Down is NOT activated. 
	 * @return
	 */
	public boolean isThumbUpButtonActivated(){
		boolean thumbUpActivated = (IHRPlayerViewThumbUpButtonUIButton.isSelected() && !IHRPlayerViewThumbDownButtonUIButton.isSelected() );
		System.out.println("isThumbUpButtonActivated() : " + thumbUpActivated);
		return thumbUpActivated;
	}
	/**
	 * Returns true if Thumb Down Is activated and Thumb Up is NOT activated. 
	 * @return
	 */
	public boolean isThumbDownButtonActivated(){
		boolean thumbDownActivated = (!IHRPlayerViewThumbUpButtonUIButton.isSelected() && IHRPlayerViewThumbDownButtonUIButton.isSelected() );
		System.out.println("isThumbDownButtonActivated() : " + thumbDownActivated);
		return thumbDownActivated;
	}
	
	/**
	 * Returns true if both Thumb Buttons are Not Selected. 
	 * @return
	 */
	public boolean isThumbUpAndThumbDownButtonNotActivated(){
		boolean thumbDownUpNotActivated = (!IHRPlayerViewThumbUpButtonUIButton.isSelected() && !IHRPlayerViewThumbDownButtonUIButton.isSelected() );
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
			//Music to Your Ears
			//Find out when your favorite artists, like Opeth, have new music and events. Notify Me / Maybe Later
			//System.out.println("Unfavorite message was shown. Clicked Yes. Should be false...favorite.isSelected? : " + NavBarFavoriteButtonUIButton.isSelected());
		//}
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
		IOSElement cancelButton = waitForVisible(driver, By.name("Cancel"), 10);
		if(cancelButton !=null){
			cancelButton.click();
		}
		System.out.println("clickCancelOnShareMenuToReturnToFullPlayer(). ");
		
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
	 * Checks if the NextButtonSkipCountLabel is present and then returns an integer equal to the number of Skips left. Returns -1 if the label couldn't be found.
	 * 
	 * @return
	 */
	public int getNumberOfSkipsRemaining(){
			int skipsLeft = Integer.parseInt(IHRPlayerViewNextButtonSkipCountLabelUILabel.getText());
			System.out.println("getNumberOfSkipsRemaining() : " + skipsLeft);
			return skipsLeft;
	}
	/**
	 * Clicks the Skip Button
	 */
	public void clickSkipButton(){
			System.out.println("clickSkipButton()... ");
			IHRPlayerViewForwardButtonUIButton.click();
	}
	
	/**
	 * Returns the Title of the Song playing. May also return the Station name if on Live Radio. 
	 * @return
	 */
	public String getTitleOfSongPlaying(){
		String title = IHRPlayerViewTitleLabelUILabel.getText();
		System.out.println("getTitleOfSongPlaying() : " + title);
		return title;
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
		System.out.println("getStationName() : " + stationType);
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
     * @return
     */
    public boolean isCurrentlyOnFullPlayer(){
    	boolean isFull = IHRPlayerViewBackgroundImageViewUIImageView.isDisplayed();
    	System.out.println("isCurrentlyOnFullPlayer() : " + isFull);
    	return isFull;
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
     * This checks if the OptionMenuView is displayed, indicating that the More Info button was clicked on FullPlayer
     * This means that Go to Artist Profile, Lyrics, and Buy Song buttons should be visible, and a Cancel Button can be clicked as well.
     * use fullPlayer.clickMoreCancelButton()
     * @return
     */
    public boolean isOptionMenuOpen(){
    	boolean isDisplayed  = IHROptionMenuViewMenuContainerUIView.isDisplayed();
    	System.out.println("isOptionMenuOpen() : " + isDisplayed);
    	return isDisplayed;
    	
    }
    
    /**
     * On the More Info pane on the Full Player - We're expecting a Lyrics Button to appear.
     * This method clicks it and returns true if it's there, otherwise we return false. 
     * @return
     */
    public boolean clickMoreLyricsButtonIfEnabled(){
    	System.out.println("clickMoreLyricsButton() - On More Info Pane - clicking Lyrics");
    	if(LyricsButton.isEnabled()){
    		System.out.println("LyricsButton is Enabled? : " + LyricsButton.isEnabled() );
    		LyricsButton.click();
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
    		if(GoToArtistProfileButton.isEnabled()){
    			System.out.println("clickGoToArtistProfileButtonIfEnabled() - On More Info Pane - clicking 'Go To Artist Profile'");
    			GoToArtistProfileButton.click();
    			return true;
    		}else{
    			System.out.println("GoToArtistProfileButton wasn't enabled. - couldn't click. Returning False.");
    			return false;
    		}
    	}else return false;
    		
    }
    
    /**
     * On the More Info Pane - click the Cancel Button. 
     * Option Menu View
     */
    public void clickMoreCancelButton(){
    	System.out.println("clickMoreCancelButton()");
    	IHROptionMenuViewCancelButtonUIButton.click();
    }
}
