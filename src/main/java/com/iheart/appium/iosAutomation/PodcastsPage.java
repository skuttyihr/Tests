package com.iheart.appium.iosAutomation;

import java.util.List;
import java.util.ArrayList;

import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.*;
import io.appium.java_client.SwipeElementDirection;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class PodcastsPage extends Page{

	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]") 
	   private WebElement firstPod;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]")
	   private WebElement firstEpisode;
	
	
	
	
	public PodcastsPage(IOSDriver _driver)
	{   super(_driver);
	}
	
	
	public void AIOS_22697_playPodcasts()
	{   sideNavigationBar.gotoPodcastsPage();
	    String podName = firstPod.getAttribute("name");
	    System.out.println("See pod name:" + podName);
		firstPod.click();
	    firstEpisode.click();
	    //Wait for PREROLL
	    waitForPreroll();
	    player.verifyPlayer_podcast(podName);
	    //Swipe on the scrobber bar
	    player.slideBar.swipe(SwipeElementDirection.RIGHT, 2);
	    
	    player.doSkip("podcast");
	    
	    player.doShare();
	
	}
}
