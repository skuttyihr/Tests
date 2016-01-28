package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.*;
import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;




public class DeepLink extends Page{

	@iOSFindBy(xpath="//*[@id='push-content']/header/section[1]/div[3]/a") private IOSElement playButton;
	
	public DeepLink(IOSDriver<IOSElement> _driver)
	{
		super(_driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void AIOS_22641_doDeepLink() throws Exception
	{
		//System.out.println("See page:" + driver.getPageSource());
		//Tap on the play button on the page
		/*
		List<WebElement> playButtons = driver.findElements(By.className("play"));
		System.out.println("See button count:" + playButtons.size());
		for (WebElement button: playButtons)
		{
			try{
				button.click();
				WaitUtility.sleep(1000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		*/
		
		if(!driver.getPageSource().contains("//www.iheart.com/live/1469/?"))
			handleError("Listen Live link is not found.", "AIOS_22641_doDeepLink");
		
		
		driver.get("//www.iheart.com/live/1469");
		WaitUtility.sleep(2000);
		
		System.out.println("See page:" + driver.getPageSource());
		if(!driver.getPageSource().contains("Get the App"))
			handleError("Get App page is not launched.", "AIOS_22641_doDeepLink");
		
		/*
		driver.findElement(By.xpath("//*[@id='MainContent']/div[1]/nav/ul/li[2]/a")).click();
		//Nav button
		driver.findElement(By.xpath("//*[@id='push-content']/header/section[1]/div[1]/a")).click();
		WaitUtility.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='push-menu']/div/section[2]/a[2]")).click();
		
		//switch window
		switchWindow();
	*/
		
	}
	
	
}
