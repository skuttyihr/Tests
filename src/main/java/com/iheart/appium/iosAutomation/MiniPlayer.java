package com.iheart.appium.iosAutomation;

import com.iheart.appium.utilities.Errors;

import io.appium.java_client.SwipeElementDirection;
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
	@iOSFindBy(accessibility = "MiniPlayerView-ImageView-UIImageView") private IOSElement MiniPlayerViewImageViewUIImageView;
	@iOSFindBy(accessibility = "MiniPlayerView-ScrollView-UIScrollView") private IOSElement MiniPlayerViewScrollViewUIScrollView;
		@iOSFindBy(accessibility = "MiniPlayerView-ContentView-UIView") private IOSElement MiniPlayerViewContentViewUIView;
			@iOSFindBy(accessibility = "MiniPlayerView-PlayButton-UIButton") private IOSElement  MiniPlayerViewPlayButtonUIButton;
			@iOSFindBy(accessibility = "MiniPlayerView-RightButtonContainerView-UIView") private IOSElement MiniPlayerViewRightButtonContainerViewUIView;
				@iOSFindBy(accessibility = "MiniPlayerView-ThumbDownButton-UIButton") private IOSElement MiniPlayerViewThumbDownButtonUIButton;
				@iOSFindBy(accessibility = "MiniPlayerView-ThumbUpButton-UIButton") private IOSElement MiniPlayerViewThumbUpButtonUIButton;
			@iOSFindBy(accessibility = "MiniPlayerView-TitleLabel-UILabel") private IOSElement  MiniPlayerViewTitleLabelUILabel;
			@iOSFindBy(accessibility = "MiniPlayerView-SubtitleLabel-UILabel") private IOSElement MiniPlayerViewSubtitleLabelUILabel;
			
	//Swipe MiniPlayer to Left - Skip button appears with number of tracks left.			
	@iOSFindBy(accessibility = "MiniPlayerView-ClipView-UIView") private IOSElement MiniPlayerViewClipViewUIView;
	@iOSFindBy(accessibility = "MiniPlayerView-SwipeButtonContainerView-UIView") private IOSElement MiniPlayerViewSwipeButtonContainerViewUIView;
	@iOSFindBy(accessibility = "MiniPlayerView-RedSkipButton-UIButton") private IOSElement MiniPlayerViewRedSkipButtonUIButton;
	@iOSFindBy(accessibility = "MiniPlayerView-ProgressBarView-UIView") private IOSElement MiniPlayerViewProgressBarViewUIView;
	
	//This does not exist. 
	@iOSFindBy(accessibility = "MiniPlayerView-BackwardButton-UIButton") private IOSElement MiniPlayerViewBackwardButtonUIButton;
	//This is only visible during Play of a Song in Artist radio - Not on a Station
	@iOSFindBy(accessibility = "MiniPlayerProgressBarView-ElapsedView-UIView") private IOSElement MiniPlayerProgressBarViewElapsedViewUIView;
	
	/**
	 * This method prints to console all the elements that should be displayed in an active MiniPlayer. Make sure that miniplayer is active before calling this.
	 * ElapsedView may not show up. 
	 */
	public void showAllElements(){
		printElementInformation(MiniPlayerViewImageViewUIImageView);
		printElementInformation(MiniPlayerViewScrollViewUIScrollView);
		printElementInformation(MiniPlayerViewContentViewUIView);
		printElementInformation(MiniPlayerViewPlayButtonUIButton);
		printElementInformation(MiniPlayerViewRightButtonContainerViewUIView);
		printElementInformation(MiniPlayerViewThumbDownButtonUIButton);
		printElementInformation(MiniPlayerViewThumbUpButtonUIButton);
		printElementInformation(MiniPlayerViewTitleLabelUILabel);
		printElementInformation(MiniPlayerViewSubtitleLabelUILabel);
		printElementInformation(MiniPlayerViewClipViewUIView);
		printElementInformation(MiniPlayerViewSwipeButtonContainerViewUIView);
		printElementInformation(MiniPlayerViewRedSkipButtonUIButton);
		printElementInformation(MiniPlayerViewProgressBarViewUIView);
		printElementInformation(MiniPlayerProgressBarViewElapsedViewUIView);
	}
	/**
	 * Clicks the MiniPlayer to open Full Player. 
	 */
	public Errors openFullPlayer(){
		Errors err = new Errors();
		System.out.println("Opening Full Player by clicking on MiniPlayerViewImageViewUIImageView element.");
		if (!waitForElementToBeVisible(getMiniPlayerViewImageViewUIImageView(), 6)) {
			err.add("MiniPlayer was not displayed.");
			return err;
		} 
		else {
			getMiniPlayerViewImageViewUIImageView().click();
		}
		return err;
	}
	
	/**
	 * Clicks the Pause, Play, Stop Button. There is only one button the page but it can have different names / icons / animations. 
	 */
	public void clickPlayPauseButton(){
		waitForElementToBeVisible(MiniPlayerViewPlayButtonUIButton, 5);
		System.out.println("clickPlayPauseButton(): " + MiniPlayerViewPlayButtonUIButton.getAttribute("value"));
		MiniPlayerViewPlayButtonUIButton.click();
	}
	/**
	 * Simply clicks the Thumb Down Button. Void - no check is done. 
	 */
	public void clickThumbDownButton(){
		System.out.println("clickThumbDownButton()");
		MiniPlayerViewThumbDownButtonUIButton.click();
	}
	
	/**
	 * Simply clicks the Thumb Up Button. Void - no check is done. 
	 */
	public void clickThumbUpButton(){
		System.out.println("clickThumbUpButton()");
		MiniPlayerViewThumbUpButtonUIButton.click();
	}
	
	/**
	 * There used to be a specific element, but now we just get the Red Skip button and get the number out of the getText and turn it into an int.
	 * @return int of number of skips remaining. -1 means the button was null.
	 */
	public int getNumberOfSkipsRemaining(){
		
		if(MiniPlayerViewRedSkipButtonUIButton !=null){
			String text = MiniPlayerViewRedSkipButtonUIButton.getText();//Skip. 6 skips remaining
			int count = Integer.parseInt(text.substring(6,7));
			System.out.println("getNumberOfSkipsRemaining() : " + count);
			return count;
		}
		return -1;
		
	}
	/**
	 * Gets the Song Title, but it may also get the Radio Station.
	 * @return
	 */
	public String getSongTitle(){
		Page.waitForElementToBeVisible(MiniPlayerViewTitleLabelUILabel, 5);
		String title = MiniPlayerViewTitleLabelUILabel.getText();
		System.out.println("getSongTitle() : " + title);
		return title;
	}
	/**
	 * Gets the Second Label in the MiniPlayer. Usually used for Artist Name - but it may also be the station Description. 
	 * @return
	 */
	public String getArtistName(){
		Page.waitForElementToBeVisible(MiniPlayerViewSubtitleLabelUILabel, 5);
		String subtitle = MiniPlayerViewSubtitleLabelUILabel.getText();
		System.out.println("getArtistName() : " + subtitle);
		return subtitle;
	}
	
	public void swipeMiniPlayerToLeftToShowSkipButton(){
		System.out.println("swipeMiniPlayerToLeftToShowSkipButton()");
		getMiniPlayerViewImageViewUIImageView().swipe(SwipeElementDirection.LEFT, 5);
	}
	
	/**
	 * Gets the Label attribute out of the RedSkip Button to see what kind of button it is.
	 * @return
	 */
	public String getTypeOfSkipButton(){
		String type = MiniPlayerViewRedSkipButtonUIButton.getAttribute("label");
		System.out.println("getTypeOfSkipButton() : "+ type);
		return type;
	}
	
	/**
	 * Swipes the miniPlayer to the right to hide the Skip(scan) button. 
	 */
	public void swipeMiniPlayerToRightToHideSkipButton(){
		System.out.println("swipeMiniPlayerToRightToHideSkipButton()");
		getMiniPlayerViewImageViewUIImageView().swipe(SwipeElementDirection.RIGHT, 5);
	}
	/**
	 * Swipes to left for half a second exposing Skip(scan) button and then clicks it. 
	 */
	public void swipeMiniPlayerToLeftAndClickSkipButton(){
		System.out.println("swipeMiniPlayerToLeftAndClickSkipButton()");
		sleep(1000);
		//System.out.println("AppWidth = " + Page.getAppWidth()  + " SkipButton : " + MiniPlayerViewRedSkipButtonUIButton.getSize().getWidth());
		getMiniPlayerViewImageViewUIImageView().swipe(SwipeElementDirection.LEFT, 5);
		sleep(1000);
		MiniPlayerViewRedSkipButtonUIButton.click();
	}
	
	/**
	 * Simply clicks the Skip(Scan) button. No swiping done. Assume the miniplayer will go back to default state. 
	 */
	public void clickSkipButton(){
		System.out.println("clickSkipButton()");
		MiniPlayerViewRedSkipButtonUIButton.click();
	}
	/**
	 * Returns true if Thumb Up is activated and Thumb Down is NOT activated. 
	 * @return
	 */
	public boolean isThumbUpButtonActivated(){
		boolean thumbUpActivated = getThumbUpStatus() && !getThumbDownStatus();
		System.out.println("isThumbUpButtonActivated() : " + thumbUpActivated);
		return thumbUpActivated;
	}
	/**
	 * Returns true if Thumb Down Is activated and Thumb Up is NOT activated. 
	 * @return
	 */
	public boolean isThumbDownButtonActivated(){
		boolean thumbDownActivated = !getThumbUpStatus() && getThumbDownStatus();
		System.out.println("isThumbDownButtonActivated() : " + thumbDownActivated);
		return thumbDownActivated;
	}
	public boolean getThumbUpStatus(){
		String thumbUpButtonChecked = MiniPlayerViewThumbUpButtonUIButton.getAttribute("value");
		boolean isUpChecked;
		if(thumbUpButtonChecked==null){
			isUpChecked = false;
		}
		else{
			isUpChecked = thumbUpButtonChecked.equals("true");
		}
		return isUpChecked;
	}
	public boolean getThumbDownStatus(){
		String thumbDownButtonChecked = MiniPlayerViewThumbDownButtonUIButton.getAttribute("value");
		boolean isDownChecked;
		if(thumbDownButtonChecked==null){
			isDownChecked = false;
		}
		else{
			isDownChecked = thumbDownButtonChecked.equals("true");
		}
		return isDownChecked;
	}
	/**
	 * Returns true if both Thumb Buttons are Not Selected. 
	 * @return
	 */
	public boolean isThumbUpAndThumbDownButtonNotActivated(){
		boolean bothDown = !getThumbUpStatus() && !getThumbDownStatus();
		System.out.println("isThumbUpAndThumbDownButtonNotActivated: " + bothDown);
		return bothDown; 
	}
	
	/**
	 * @return the miniPlayerViewImageViewUIImageView
	 */
	public IOSElement getMiniPlayerViewImageViewUIImageView() {
		return MiniPlayerViewImageViewUIImageView;
	}
	
	/**
	 * Checks if MiniPlayer is open.
	 * @return
	 */
	public boolean isCurrentlyOnMiniPlayer(){
		return isCurrentlyOn("isCurrentlyOnMiniPlayer", MiniPlayerViewImageViewUIImageView);
	}

	/**
	 * Gets TitleLabel, Clicks Skip Button, gets TitleLabel again and then compares to make sure they are not equal.
	 * @return
	 */
	public boolean isTitleDifferentAfterSkip(){
		String firstTitle = getSongTitle();
		swipeMiniPlayerToLeftAndClickSkipButton();
		String secondTitle = getSongTitle();
		boolean diffTitle = (!firstTitle.equals(secondTitle));
		System.out.println("isTitleDifferentAfterSkip() : " + diffTitle );
		return diffTitle;
	}
	
	public String getTypeOfPlayButton(){
		String type = MiniPlayerViewPlayButtonUIButton.getAttribute("label");
		System.out.println("Type of Play-Pause-Stop-Buffering Button: '" + type +"'");
		return type;		
	}
	
	public boolean isElapsedViewDisplayed(){
		System.out.println("isElapsedViewDisplayed() : " + MiniPlayerProgressBarViewElapsedViewUIView.isDisplayed());
		return MiniPlayerProgressBarViewElapsedViewUIView.isDisplayed();
	}
}
