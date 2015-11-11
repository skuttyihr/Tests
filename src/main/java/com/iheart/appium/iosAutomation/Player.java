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
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")  public IOSElement songTrack2_live;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]")  public IOSElement artist2_live;
	
	
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
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[6]") public IOSElement more_live;
	//@iOSFindBy(name="more") public IOSElement more;
	
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
	{  //if(!stationLabel.getText().contains(stationName))
		//  errors.append("Station name is not correct.");
	
		if(!isElementPresent(songTrack_live))
		{   if(!isElementPresent(songTrack2_live))
			    errors.append("No sound track name is displayed.");
		}
		
		if(!isElementPresent(artist_live))
		{	
			if(!isElementPresent(artist2_live))
			   errors.append("Artist name is NOT displayed.");
		}
		if(!isElementPresent(playButton_live))
			   errors.append("Play icon is not displayed.");
		
		if(!isElementPresent(scan))
			   errors.append("Scan icon is not displayed.");
		
		if(!isElementPresent(more_live))
			   errors.append(".... is not displayed.");
		
		
		verfiyCommonIcons("verifyPlayer_live");
		
	}
	
	
	public void verifyPlayer_artist(String stationName)
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
	{  if(!stationLabel.getText().contains(stationName.substring(0,5)))
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
		
		
		//if(!isElementPresent(more))
		//	   errors.append(".... is not displayed.");
		
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
	    System.out.println("before/after:" + currentTrack + "/" + nowPlaying);
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
		more_live.tap(1, 1);
		share.tap(1, 1);
		if(!isElementPresent(mail))
			handleError("Share button is not working.", "doShare");
	}   
	
	public void doThumbUp()
	{
		//Sometimes the thumbUp button is disabled, keep scan(At most 10 times though to avoid hang) until thumbUpiCON is enabled.
		int count = 0; 
		
		//Try a little bit more
		while(isThumbUpDisabled() && count < 3)
		{	System.out.println("thumbUp button is disabled. Scan now..");
		    try{
			   scan.click();
		    }catch(Exception e)
		    {   
		    	
		    }
			count++;
			WaitUtility.sleep(3000);
		}
		
		//if it is still disabled, return 
		if(isThumbUpDisabled()) return;
		
		//If this is thumbUp before, double-click
		if (isThumbUpDone())
		{	thumbUp.click();
		     WaitUtility.sleep(1000);
		   //Sometimes 'Like iheartRadio?" pops up
			handleGladYouLikeItPopup();
			
		}

	     
	    thumbUp.click();
		//Glad you like it!  We'll let our DJs know.
	    String response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
		System.out.println("See growls:" + response);
		
		
		
		//Sometimes 'Like iheartRadio?" pops up
		handleGladYouLikeItPopup();
		
		//FOR ARITST: Great, we’ll play you more songs like this.
	//	if (!(response.contains("Glad you like") || response.contains("Thanks for your feedback") || response.contains("Great")))
	//		handleError("Thump Up is not working properly.", "doThumbUp");
		
	}
	
	//This happens when you thumbup a already thumbuped song track
	private void handleGladYouLikeItPopup()
	{
		try{
			   driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[10]")).click();//No , thnak you.
		}catch(Exception e)
		{
			
		}
	}
	
	private void handleGladAfterFavorite()
	{
	  try{
	    driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]")).click();//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]
	    WaitUtility.sleep(200);
	  }catch(Exception e)
	  {
		  
	  }
	}
	//this needs to be tested
	private boolean isThumbUpDisabled()
	{    return !thumbUp.isEnabled();
	/*
		boolean isDisabled = false;
		try{
			String value = thumbUp.getAttribute("enabled");
			System.out.println("isThumbUpDisabled:" + value);
		   isDisabled = !value.equals("true");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isDisabled;
		*/
	}
	
	private boolean isThumbDownDisabled()
	{
		return !thumbDown.isEnabled();
		/*
		boolean isDisabled = false;
		try{
			
			//Here, need debugging.. 
			String value = thumbDown.getAttribute("enabled");
			System.out.println("isThumbDownDisabled:" + value);
		   isDisabled = !value.equals("true");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isDisabled;
		*/
	}
	
	
	//This is for live radio
	public void doThumbDown()
	{
		//Sometimes the thumbUp button is disabled, keep scan(At most 10 times though to avoid hang) until thumbUpiCON is enabled.
		int count = 0; 
		
		//Try a little bit more
		while(isThumbDownDisabled() && count < 3)
		{	System.out.println("thumbDown button is disabled. Scan now..");
		    try{
			   scan.click();
		    }catch(Exception e)
		    {   
		    	
		    }
			count++;
			WaitUtility.sleep(3000);
		}
		
		//if it is still disabled, return 
		if(isThumbDownDisabled()) return;
		
		//If this is thumbUp before, double-click
		if (isThumbDownDone())
		{	thumbDown.click();
		     WaitUtility.sleep(1000);
		   //Sometimes 'Like iheartRadio?" pops up
			handleGladYouLikeItPopup();
			
		}
		
		thumbDown.click();
		WaitUtility.sleep(1000);
		
		String response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
	//	System.out.println("See thumbDOWN DOWN growls:" + response);
		
		
	//	if (! response.contains("heard enough"))
	//		handleError("Thump Down is not working properly.", "doThumbDown");
		
	}
	
	public void doThumbDown(String stationType)
	{
		//Sometimes the thumbUp button is disabled, keep scan(At most 10 times though to avoid hang) until thumbUpiCON is enabled.
		int count = 0; 
		
		//Try a little bit more
		while(isThumbDownDisabled() && count < 3)
		{	System.out.println("thumbDown button is disabled. Scan now..");
		    try{
		       if(stationType.equals("live"))	
			      scan.click();
		       else
		    	   skip.click();
		    }catch(Exception e)
		    {   
		    	
		    }
			count++;
			WaitUtility.sleep(3000);
		}
		
		//if it is still disabled, return 
		if(isThumbDownDisabled()) return;
		
		//If this is thumbUp before, double-click
		if (isThumbDownDone())
		{	thumbDown.click();
		     WaitUtility.sleep(1000);
		   //Sometimes 'Like iheartRadio?" pops up
			handleGladYouLikeItPopup();
			
		}
		
		thumbDown.click();
		WaitUtility.sleep(1000);
		if (stationType.equals("artist"))
			handleThumbDownPopUpForArtistStation();
														
		String response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
		System.out.println("See thumbDOWN DOWN growls:" + response);
		

		if (stationType.equals("live"))
		{   if (!response.contains("heard enough"))
			   handleError("Thump Down is not working properly.", "doThumbDown");
		}
		/*
		else // No growl when alert is showing up "Thumbing down customizes your station without using a skip." 
		{
			if (!response.contains("OK, we’ll adjust your music mix."))
				   handleError("Thump Down is not working properly.", "doThumbDown");
		}
	   	*/
		
	}
	
	private boolean isThumbUpDone()
	{
		
		boolean isDone = false;
		try{
			//if yes, its value is 1; otherwise, blank
			String value = thumbUp.getAttribute("value");
			
			System.out.println("Is thumpUp done:" + value );
			  
		   isDone = value.equals("1");
		   
		}catch(Exception e)
		{
			
		}
		return isDone;
	}
	
	private boolean isThumbDownDone()
	{
		
		boolean isDone = false;
		try{
			//if yes, its value is 1; otherwise, blank
			String value = thumbDown.getAttribute("value");
			
			System.out.println("Is thumpDown done:" + value );
			  
		   isDone = value.equals("1");
		   
		}catch(Exception e)
		{
			
		}
		return isDone;
	}
	
	public void doFavorite()
	{   //if faved before, its value is 1;
		if (isFavDone()) //unfav it
		{
			favorite.click();
			WaitUtility.sleep(1000);
			handleUnFavConfirmation();
		}
		
		favorite.click();
		WaitUtility.sleep(500);

		handleGladAfterFavorite();
		
		//Verify that icon is filled
		if (!favorite.getAttribute("value").equals("1"))
			handleError("Add to Favorite failed.", "doFavorite");
		
	/*
		String response = "";
		response = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]")).getText();
	    System.out.println("See favorite growls:" + response);
		
		
		//Station added to your favorites!
		if (!response.contains("Station added"))
			handleError("Add to Favorite failed.", "doFavorite");
			
	*/		
		  
	}
	
	//Are you sure you want to delete this preset?
	private void handleUnFavConfirmation()
	{
		try{
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
		    WaitUtility.sleep(1000);
		}catch(Exception e)
		{
			
		}
	}
	
	//Thumbing down customizes your station without using a skip.
	private void handleThumbDownPopUpForArtistStation()
	{
		try{
			//click on OKAY BUTTON of alert box: Thumbing down customizes your station without using a skip.
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
		    WaitUtility.sleep(1000);
		}catch(Exception e)
		{
			
		}
	}
	
	private boolean isFavDone()
	{
		boolean isDone = false;
		
	    try{
	    	isDone = favorite.getAttribute("value").equals("1");
	    }catch(Exception e)
	    {
	    	
	    }
	    
	    return isDone;
	}
	
	public void doScan()
	{
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		
		scan.click();
		WaitUtility.sleep(5000);
		//Verify that new song is playing 
		String newSong =  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		if (newSong.equals(currentSong))
			handleError("Scan is not working.", "doScan");
		
	}
	
	public void doSkip()
	{
		String currentSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		
		skip.click();
		WaitUtility.sleep(5000);
		//Verify that new song is playing 
		String newSong =  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")).getText();
		if (newSong.equals(currentSong))
			handleError("Skip is not working.", "doSkip");
		
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
