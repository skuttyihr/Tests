package com.iheart.appium.iosAutomation;

import java.util.List;
import java.util.ArrayList;

import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.*;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class ForYouPage extends Page {
	

	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")
	   private IOSElement firstStation;
	//@iOSFindBy(name="Sign in") private WebElement signIn;
	
	//for search 
   @iOSFindBy(name="Top Hit") private IOSElement topHit;
   	
   @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[1]/UIAStaticText[1]")	
      private IOSElement topStation;
   
	public ForYouPage(IOSDriver _driver)
	{
		super(_driver);
	}
	
	public void AIOS_22674_createArtistStation()
	{   String artist ="Josh Groban";
		searchField.sendKeys(artist);
		topHit.click();
		WaitUtility.sleep(3000);
		//Verify PLAYER
		player.verifyPlayer_live(artist);
		
		player.doThumbUp();
	
		player.doThumbDown();
		
		player.doFavorite();
		
		player.doScan();
	    
	   //Verify that this station is added under My Station
		(player.back).click();
	    try{
	    	driver.findElement(By.name(artist)).getText();
	    }catch(Exception e)
	    {
	    	handleError("Artist station is not added under My Station.", "AIOS_22674_createArtistStation");
	    }
		
		
	}
	
	public void AIOS_22673_playLiveRadio()
	{   String myStation ="101.3";
		//First, find out for-sure live radio 101.3
		List<WebElement> stations = driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]"));
		for(WebElement station:stations)
		{
			if(station.getAttribute("name").contains(myStation))
			{
			   station.click();
			   break;
			}
			
		 }//for
		
		//Verify PLAYER
		player.verifyPlayer_live(myStation);
		
		player.doScan();
		
		player.doThumbUp();
	
		player.doThumbDown();
		
		player.doFavorite();
		   
		player.pauseAndResume("live");
	    
	   //tap on My Station and make sure Station is added??
		//Verify that this station is added under My Station
		(player.back).click();
	    
		if (!topStation.getText().equals(myStation))
	    	handleError("Artist station is not added under My Station.", "AIOS_22673_playLiveRadio");
	    
   	}
	
	
	
	public void comeToThisPage()
	{
		driver.findElement(By.name("For You")).click();
	}
	
}
