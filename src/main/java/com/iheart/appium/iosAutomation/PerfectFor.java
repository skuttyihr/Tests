package com.iheart.appium.iosAutomation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PerfectFor extends Page {

	public PerfectFor(){
		super();
	}
	public PerfectFor(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	
	/**
	 * List items
	 * Label for day and time
	 * Secondary labels for stations split up
	 */
	// Use baseItemXpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"; To get first station variety
	public String pfListItemX = baseListItemXpath;
	public String pfSubListItemX = "//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableCell";
	public String pfSubStationLabelBaseX = "//UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableGroup";
	public String pfSubStationLabelX = pfSubStationLabelBaseX + "[XXXXX]/UIAStaticText[1]";
	
	
	@iOSFindBy(name = "Perfect For") public IOSElement perfectForHeading;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[1]") public IOSElement pfCategoryHeading;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[2]") public IOSElement pfSubStationHeading;
	@iOSFindBy(name = "Back") public IOSElement pfSubCatBack;
	
	// Getting elements
	private IOSElement getGenericListItem(String xpath){
		IOSElement testElement = waitForVisible(driver, 
				By.xpath(xpath),
						1);
		return testElement;
	}
	
	public IOSElement getPFListItem(int x){
		return getGenericListItem(pfListItemX + "[" + x + "]");
	}
	public IOSElement getPFSubListItem(int x){
		return getGenericListItem(pfSubListItemX + "[" + x + "]");
	}
	public IOSElement getPFSubListLabel(int x){
		IOSElement subListLabel = getGenericListItem(pfSubStationLabelX.replace("[XXXXX]", "[" + x + "]"));
		if(subListLabel == null){
			subListLabel = getGenericListItem(pfSubStationLabelX.replace("[XXXXX]", "[" + x + "]").replace("UIAStaticText", "UIAElement"));
		}
		
		return subListLabel;
	}
	
	private IOSElement searchForGeneric(String name, String xpath){
		IOSElement listItem = null;
		if (driver.getPageSource().contains(name)){
			List<IOSElement> listItems = findElements(driver, By.xpath(xpath));
			for(IOSElement ex : listItems){
				if(!isVisible(ex)){
					swipeUp();
					if(!isVisible(ex))
						break;
				}
				
				if(ex.getText().contains(name)){
					listItem = ex;
					break;
				}
			}
		}
		return listItem;
	}
	
	public IOSElement searchForCategory(String name){
		return searchForGeneric(name, pfListItemX);
	}
	
	public IOSElement searchForListLabel(String label){
		
		// If the exact name has been passed in, we don't even have to search much
		IOSElement testName = findElement(driver, By.name(label));
		if(isVisible(testName)){
			return testName;
		}
		
		// Shortcut for ones we can guess the name of labels that are based on decades
		try{
			Integer.parseInt(label);
			// If it gets here, it's a number, and might be a decade
			String name = label + "'s";
			if(label.equals("50")){
				name += " and More";
			}
			IOSElement testElement = findElement(driver, By.name(name));
			if(isVisible(testElement)){
				return testElement;
			}
			else{
				swipeUp();
				testElement = findElement(driver, By.name(name));
				if(isVisible(testElement)){
					return testElement;
				}
			}
		}catch(Exception e){}
		
		// Search for the element by swiping and checking the matching text
		IOSElement listLabel = null;
		if(driver.getPageSource().contains(label)){
			boolean hasFoundVisible = false; // We only want to scroll if we already found an item and need to search down further
			for(int i = 1; i <= 13; i++){
				IOSElement l = getPFSubListLabel(i);
				if(!isVisible(l)){
					if(hasFoundVisible)
						swipeUp();
					l = getPFSubListLabel(i);
					if(!isVisible(l)){
						if(hasFoundVisible)
							break;
						else
							continue;
					}
					else{
						hasFoundVisible = true;
					}
				}
				else{
					hasFoundVisible = true;
				}
				if(l.getText().contains(label)){
					listLabel = l; 
					break;
				}
			}
		}
		return listLabel;
	}
	
	// Behavior
	
	public String selectPerfectForCategories(int firstCategory, int station){
		Errors err = new Errors();
		sideNavBar.gotoPerfectFor();
		IOSElement first = getPFListItem(firstCategory);
		if(first == null){
			err.add("Could not select first item");
		}
		else{
			String categoryTitle = first.getText();
			first.click();
			waitForElementToBeVisible(pfSubStationHeading, 3);
			if(!pfSubStationHeading.getText().contains(categoryTitle)){
				err.add("Label for category did not match one we selected.");
			}
			IOSElement selectedStation = getPFSubListItem(station);
			if(selectedStation == null){
				err.add("Could not select station");
			}
			else{
				selectedStation.click();
				
				if(!player.isPlaying()){ // TODO this isn't detecting playback of live station
					err.add("Could not load station.");
				}
			}
		}
		
		return err.getErrors();
	}
	
	public String checkCategoryLabel(){
		Errors err = new Errors();
		
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("EEEE");
		String dayOfWeek = format.format(today);
		String timeOfDay = "";
		format = new SimpleDateFormat("HH");
		int hour = -1;
		try{
			hour = Integer.parseInt(format.format(today));
		}catch(Exception e){}
		if (hour >= 0){ //TODO verify that these are the options, as it doesn't respond to changing the clock (tricky!)
			if (hour < 12){
				timeOfDay = "Morning";
			}
			else if (hour < 17){
				timeOfDay = "Afternoon";
			}
			else{
				timeOfDay = "Evening";
			}
		}
		if(strGood(dayOfWeek) && strGood(timeOfDay)){
			String testString = "Find a station Perfect For " + dayOfWeek + " " + timeOfDay;
			if(pfCategoryHeading != null){
				String heading = "";
				try{
					heading = pfCategoryHeading.getText();
				}catch(Exception e){}
				if(!strGood(heading)){
					err.add("Could not grab heading for Perfect For page");
				}
				else if(!heading.equals(testString)){
					err.add("Heading: " + heading + " was not what we expected: " + testString);
				}
			}
			else{
				err.add("Could not get heading for Perfect For category list.");
			}
		}
		else{
			if(!strGood(dayOfWeek))
				err.add("Day of week could not be determined.");
			if(!strGood(timeOfDay))
				err.add("Time of day could not be determined.");
		}
		
		return err.getErrors();
	}
	
	public boolean selectCategory(String name){
		IOSElement item = searchForCategory(name);
		if(item != null){
			item.click();
			waitForElementToBeVisible(pfSubStationHeading, 3);
			if(pfSubStationHeading.getText().contains(name)){
				return true;
			}
			return false;
		}
		return false;
	}
}

