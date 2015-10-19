package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Player extends Page{
	
	 //Player  for live radio
	//@iOSFindBy(name="Back") public IOSElement back;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]") public IOSElement back;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")
	   public IOSElement stationLabel;
	@iOSFindBy(name="Share") public IOSElement share;
	@iOSFindBy(name="Favorite") public IOSElement favorite;
	
	//Seems that this is depending upon from where the player is launched
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]") public IOSElement songTrack_artist;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]") public IOSElement artist_artist;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]")  public IOSElement songTrack_live;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]")  public IOSElement artist_live;
	
	//podcast specific
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAImage[4]") public IOSElement podcastImage;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIASlider[1]") public IOSElement slideBar;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]") public IOSElement episodeName_podcast;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]") public IOSElement stationName_podcast;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")  public IOSElement playButton_podcast;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[9]")   public IOSElement more_podcast;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[7]") public IOSElement playButton_live; //doesn't apply for podcast
	//@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[9]") public IOSElement playButton_artist;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[2]") public IOSElement playButton_artist;
	//@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[11]") public IOSElement more;
	@iOSFindBy(name="more") public IOSElement more;
	@iOSFindBy(name="skip") public IOSElement skip;
	@iOSFindBy(name="scan") public IOSElement scan;
	@iOSFindBy(name="Thumb up") public IOSElement thumbUp;
	@iOSFindBy(name="Thumb down") public IOSElement thumbDown;
	//FOR SHARE
	@iOSFindBy(name="Mail") public IOSElement mail;
    
	
	public Player()
	{
		super();
	}
	
	public Player(IOSDriver _driver)
	{
		super(_driver);   
		setPlayer(this);
	}
	
	//******* END OF PLAYER for live radio ********
	
	/* Verify player info
	Station Name
	Artist name if available
	Thumb up and Down
	Play/pause button
	Scan Button
	Share button
	iHeart button to Favorite statio
	Volume control
	*/
	public void verifyPlayer_live(String stationName)
	{  if(!stationLabel.getText().contains(stationName))
		  errors.append("Station name is not correct.");
	
		if(!isElementPresent(songTrack_live))
		   errors.append("No sound track name is displayed.");
		
		if(!isElementPresent(artist_live))
			   errors.append("No artist name is displayed.");
		
		if(!isElementPresent(playButton_live))
			   errors.append("Play icon is not displayed.");
		
		if(!isElementPresent(scan))
			   errors.append("Scan icon is not displayed.");
		
		verfiyCommonIcons("verifyPlayer_live");
		
	}
	
	
	public void verifyPlayer_custom(String stationName)
	{  if(!stationLabel.getText().contains(stationName))
		  errors.append("Station name is not correct.");
	
		if(!isElementPresent(songTrack_artist))
		   errors.append("No sound track name is displayed.");
		
		if(!isElementPresent(artist_artist))
			   errors.append("No artist name is displayed.");
		
		if(!isElementPresent(playButton_artist))
			   errors.append("Play icon is not displayed.");
		
		if(!isElementPresent(skip))
			   errors.append("Skip icon is not displayed.");
		
		verfiyCommonIcons("verifyPlayer_custom");
	}
	
	public void verifyPlayer_podcast(String stationName)
	{  if(!stationLabel.getText().contains(stationName))
		  errors.append("Station name is not correct.");
	
		if(!isElementPresent(episodeName_podcast))
		   errors.append("Episode name is not displayed.");
		
		if(!isElementPresent(stationName_podcast))
			   errors.append("Station name is Not displayed.");
		
		if(!isElementPresent(slideBar))
			   errors.append("No Scrobber is displayed.");
			
		
		if(!isElementPresent(playButton_podcast))
			   errors.append("Play icon is not displayed.");
		
		if(!isElementPresent(skip))
			   errors.append("Skip icon is not displayed.");
		
		verfiyCommonIcons("verifyPlayer_podcast");
	}

	private void verfiyCommonIcons(String callingMethod)
	{
		if(!isElementPresent(thumbUp))
			   errors.append("No Thumb Up icon is displayed.");
		
		if(!isElementPresent(thumbDown))
			   errors.append("No Thumb Down icon is displayed.");
		
		
		if(!isElementPresent(more))
			   errors.append(".... is not displayed.");
		
		if(errors.length() > 1)
			handleError("", callingMethod);
	}
	
	public void doSkip(String type)
	{
		String currentTrack, nowPlaying;
		currentTrack = getNowPlaying(type);
		
	    skip.tap(1, 1);
	    WaitUtility.sleep(2000);
	    nowPlaying = getNowPlaying(type);
	    //Verify new episode is playing
	    if (currentTrack.equals(nowPlaying))
	    	handleError("Skip is not working.", "doSkipFor" + type);
	}
	
	
	private String getNowPlaying(String type)
	{   String currentTrack ="";
		if (type.equals("podcast"))
		      currentTrack	= episodeName_podcast.getText();
			else if (type.equals("artist"))
				currentTrack	= songTrack_artist.getText();
			else if (type.equals("live"))
				currentTrack	= songTrack_live.getText();
	    return currentTrack;
	}
	
	public void doShare()
	{
		more.tap(1, 1);
		share.tap(1, 1);
		if(!isElementPresent(mail))
			handleError("Share button is not working.", "doShare");
	}   
	
	public void doThumbUp()
	{
		thumbUp.click();
		
		String response = driver.findElement(By.className("growls")).getText();
		System.out.println("See growls:" + response);
		if (!(response.contains("Glad you like") || response.contains("Thanks for your feedback")))
			handleError("Thump Up is not working properly.", "AIOS_22674_createArtistStation");
		
	}
	
	public void doThumbDown()
	{
		thumbDown.click();
		
	    String response = driver.findElement(By.className("growls")).getText();
		System.out.println("See growls:" + response);
		if (! response.contains("Thanks for your feedback"))
			handleError("Thump Down is not working properly.", "AIOS_22674_createArtistStation");
		
	}
	
	
	public void doFavorite()
	{
		favorite.click();
		String response = driver.findElement(By.className("growls")).getText();
		System.out.println("See growls:" + response);
		
		if (!response.contains("Favorite"))
			handleError("Add to Favorite failed.", "AIOS_22674_createArtistStation");
		   
	}
	
	public void doScan()
	{
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		
		scan.click();
		WaitUtility.sleep(5000);
		//Verify that new song is playing 
		String newSong =  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		if (newSong.equals(currentSong))
			handleError("Skip is not working.", "doScan");
		
	}
	
	public void pauseAndResume(String type)
	{   IOSElement theOne;
	    if (type.equals("live"))
	    	theOne = playButton_live;
	    else if(type.equals("podcast"))
	    	theOne = playButton_podcast;
	    else 
	    	theOne = playButton_artist;
	    
		theOne.click();
		//verify it is paused
	    if(!theOne.getAttribute("name").contains("play"))
	    	errors.append("Station playing is not paused.");
	    
	    theOne.click();
	    //verify it is resumed
	    if(!theOne.getAttribute("name").contains("pause"))
	    	errors.append("Station playing is not RESUMED.");
	    
	}
	
	public boolean isPlaying(String type)
	{  
		boolean isPlaying = false;
		
		IOSElement theOne;
	    if (type.equals("live"))
	    	theOne = playButton_live;
	    else if(type.equals("podcast"))
	    	theOne = playButton_podcast;
	    else 
	    	theOne = playButton_artist;
	    
	  //verify that it is playing: Get its attribute: class shall be 'pause'
	    String klasses = theOne.getAttribute("name");
	    System.out.println("See playbutton classes:" + klasses);
	    if (klasses.contains("pause") || klasses.contains("stop"))
	    	isPlaying = true;
		
	    return isPlaying;
	}
}
