package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.*;
import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;

public class DeepLink extends Page {

	@iOSFindBy(xpath = "//*[@id='push-content']/header/section[1]/div[3]/a") private IOSElement playButton;

	public DeepLink(IOSDriver<IOSElement> _driver) {
		super(_driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void doDeepLink() throws Exception {
		String deepLink = "http://www.iheart.com/live/1469";
		// Open Safari, load link

		// TODO No way to switch context in iOS Automation currently

		driver.get(deepLink);
		TestRoot.sleep(2000);

		System.out.println("See page:" + driver.getPageSource());
		if (!driver.getPageSource().contains("Get the App"))
			handleError("Get App page is not launched.", "doDeepLink");
	}

}
