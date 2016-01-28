package com.iheart.appium.iosAutomation;

import java.util.HashMap;

import io.appium.java_client.pagefactory.*;

import io.appium.java_client.ios.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;


public class PodcastsPage extends Page{

	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]") 
	   private IOSElement firstPod;
						//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]")
	   private IOSElement firstEpisode;
	
	
	
	
	public PodcastsPage(IOSDriver<IOSElement> _driver)
	{   super(_driver);
	}
	
	
	public void AIOS_22697_playPodcasts()
	{   sideNavigationBar.gotoPodcastsPage();
	    String podName = firstPod.getAttribute("name");
	    System.out.println("See pod name:" + podName);
		firstPod.click();
		WaitUtility.sleep(3000);
		
		/*
		List<WebElement> tables = driver.findElements(By.className("UIATableView"));
		
		int count = 0;
		for (WebElement table: tables)
		{   count++;
			System.out.println("TABLE:" + table.getText());
		
			if (count ==2)
			{	
			   List<WebElement> cells = table.findElements(By.className("UIATableCell"));
			   for(WebElement cell: cells)
				   System.out.println("see cell:" + cell.getText());
			}
		}
		
			
		WebElement tableView2 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]"));
		List<WebElement> cells = tableView2.findElements(By.className("UIATableCell"));
		
		int count2 = 0;
		WebElement target = null;
	    for (WebElement cell: cells)	
	    {	count2++;
	    		
	        System.out.println("cell TExt:" + cell.getText());
	        System.out.println("cell name:" + cell.getAttribute("name"));
	        System.out.println("cell value:" + cell.getAttribute("value"));
	        
	        if (cell.getText().startsWith("Thursday"))
	        {
	        	target = cell;
	        	break;
	        }
	    	
	    }
	    */
	   // target.click();
		
		System.out.println("Have problem clicking on the episode. Working on it. For now please play podcast manually.");
		/*
	    firstEpisode.click();
	    //Wait for PREROLL
	    waitForPreroll();
	    player.verifyPlayer_podcast(podName);
	    //Swipe on the scrobber bar
	   // player.slideBar.swipe(SwipeElementDirection.RIGHT, 2);
	   // swipeSlide();
	    
	    player.doSkip("podcast");
	    
	    player.doShare();
	    */
	}
	
	protected void swipeSlide()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();

		swipeObject.put("startX", 0.05);
		swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.95);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 1.8);
        swipeObject.put("element",Double.valueOf(((RemoteWebElement)player.slideBar).getId()));

        //String[] sargs = {"startX: 0.05", "startY: 0.5", "endX: 0.95", "endY: 0.5", "element: " + ((RemoteWebElement)objSlider).getId()}; 
        js.executeScript("mobile: swipe", swipeObject);

	}
}
