package com.iheart.appium.iosAutomation;

import java.util.HashMap;

import io.appium.java_client.pagefactory.*;

import io.appium.java_client.ios.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

public class PodcastsPage extends Page {

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]") private IOSElement firstPod;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[2]/UIAButton[1]") private IOSElement firstEpisode;

	public PodcastsPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}

	public String playPodcasts() {
		sideNavigationBar.gotoPodcastsPage();
		waitForElementToBeVisible(firstPod, 5);
		String podName = firstPod.getAttribute("name");
		System.out.println("See pod name:" + podName);
		IOSElement podcastSeries = getPodcast(1);
		if(podcastSeries != null){
			podcastSeries.click();
		}
		else{
			return "Could not select a podcast series.";
		}
		waitForElementToBeVisible(firstEpisode, 5);
		IOSElement podcastEpisode = getPodcastEpisode(1);
		if(podcastEpisode != null){
			podcastEpisode.click();
		}
		else{
			return "Could not load up a podcast episode.";
		}
		waitForElementToBeVisible(player.thumbUp, 5);
		if(isVisible(player.playButton_podcast)){
			return "";
		}
		return "Did not enter a podcast playback view, podcast play button was not visible.";
	}

	protected void swipeSlide() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();

		swipeObject.put("startX", 0.05);
		swipeObject.put("startY", 0.5);
		swipeObject.put("endX", 0.95);
		swipeObject.put("endY", 0.5);
		swipeObject.put("duration", 1.8);
		swipeObject.put("element", Double.valueOf(((RemoteWebElement) player.slideBar).getId()));

		// String[] sargs = {"startX: 0.05", "startY: 0.5", "endX: 0.95", "endY:
		// 0.5", "element: " + ((RemoteWebElement)objSlider).getId()};
		js.executeScript("mobile: swipe", swipeObject);

	}
	
	public IOSElement getPodcast(int i){
		return waitForVisible(driver, 
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[" + i + "]"), 
				7);
	}
	public IOSElement getPodcastEpisode(int i){
		i += 1; // First "podcast episode" is actually the station
		return waitForVisible(driver, 
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell[" + i + "]"
							+ "/UIAButton[1]"),
					7);
	}
}
