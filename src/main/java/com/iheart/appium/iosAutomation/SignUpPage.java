package com.iheart.appium.iosAutomation;

import java.util.Date;

import org.openqa.selenium.By;

import io.appium.java_client.pagefactory.*;
import io.appium.java_client.ios.*;

public class SignUpPage extends Page {

	@iOSFindBy(name = "Get Started") private IOSElement getStarted;
	@iOSFindBy(name = "Back") private IOSElement backButton;
	private final String createAccountName = "Create An Account";
	@iOSFindBy(name = createAccountName) private IOSElement createAnAccount;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]") private IOSElement email;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]") private IOSElement password;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]") private IOSElement zip;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[2]") private IOSElement birthYear;
	// @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]")
	@iOSFindBy(name = "Male") private IOSElement gender_male;
	@iOSFindBy(name = "Female") private IOSElement gender_female;
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[1]") private IOSElement iAgree;
	@iOSFindBy(name = "Create Account") private IOSElement create;

	@iOSFindBy(name = "Facebook") private IOSElement facebook;
	@iOSFindBy(name = "Google") private IOSElement google;

	private final String maybeLaterName = "Maybe Later";
	@iOSFindBy(name = maybeLaterName) private IOSElement maybeLater;

	// if account exists already
	@iOSFindBy(name = "Okay") private IOSElement okay;

	public SignUpPage() {
		super();
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public SignUpPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public boolean createAnAccount() {
		TestRoot.waitForElementToBeVisible(getStarted, 10);
		getStarted.click();

		// Generate a random email
		String _email = getCurrentDateInMilli() + "@mailinator.com";
		System.out.println("See randomEmail:" + _email);

		email.sendKeys(_email);
		password.sendKeys("iheart234");
		zip.sendKeys("10001");
		birthYear.sendKeys("1988");
		gender_male.click();
		iAgree.click();
		TestRoot.waitForElementToBeVisible(create, 5);
		create.click();
		TestRoot.waitForElementToBeVisible(genrePage.genrePicker, 15);

		// verify that tell us what you like page shows up
		return TestRoot.isVisible(genrePage.genrePicker);
	}

	private String getCurrentDateInMilli() {
		Date date = new Date();
		return date.getTime() + "";
	}

	public IOSElement getGetStartedButton(){
		return getStarted;
	}
	public boolean tapGetStarted(){
		getStarted.click();
		waitForElementToBeVisible(createAnAccount, 2);
		return isVisible(createAnAccount);
	}
	public boolean tapMaybeLater(){
		// Page factory fails miserably when trying to test elements that aren't present
		// Doing this the more direct way than relying on page factory:
		IOSElement testCreateAccount = waitForVisible(driver, By.name("createAccountName"), 1);
		if(!isVisible(testCreateAccount)){
			tapGetStarted();
			waitForElementToBeVisible(createAnAccount, 2);
		}
		maybeLater.click();
		waitForNotVisible(driver, By.name(maybeLaterName), 3);
		
		handlePossiblePopUp();
		
		boolean pastGate = false;
		if(isVisible(forYou) || isVisible(genrePage.genrePicker)){
			pastGate = true;
		}
		return pastGate;
	}
	public void tapBack(){
		backButton.click();
	}
}
