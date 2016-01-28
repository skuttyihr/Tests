package com.iheart.appium.iosAutomation;


import java.util.Date;

import io.appium.java_client.pagefactory.*;

import io.appium.java_client.ios.*;


public class SignUpPage extends Page{
	
	
	@iOSFindBy(name="Get Started")  private IOSElement getStarted;
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]") private IOSElement email;
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]") private IOSElement password;
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]")
    	private IOSElement zip;
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[2]")
    	private IOSElement birthYear;
    //@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]")
    @iOSFindBy(name="Male") private IOSElement gender_male;
    @iOSFindBy(name="Female") private IOSElement gender_female;
    @iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAElement[1]") private IOSElement iAgree;
    @iOSFindBy(name="Create Account") private IOSElement create;
    
    @iOSFindBy(name="Facebook") private IOSElement facebook;
    @iOSFindBy(name="Google") private IOSElement google;
    
    @iOSFindBy(name="Maybe Later") private IOSElement maybeLater;
    
    //if account exists already
    @iOSFindBy(name="Okay") private IOSElement okay;
    
    //After success signup
    @iOSFindBy(name="IHRiPhoneGenrePickerView") private IOSElement genrePicker;
    
    public SignUpPage()
	{
		super();
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
    
    public SignUpPage(IOSDriver<IOSElement> _driver)
	{
		super(_driver);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
    
    public void AIOS_22672_createAnAccount()
	{   
    	getStarted.click();
    	
    	//Generate a random email
    	String  randomEmail_firstPart = getCurrentDateInMilli();
		String _email = randomEmail_firstPart + "@mailinator.com";
		System.out.println("See randomEmail:" + _email);
       
		email.sendKeys(_email);
		password.sendKeys("iheart234");
		zip.sendKeys("10001");
		birthYear.sendKeys("1988");
		gender_male.click();
		iAgree.click();
		create.click();
		WaitUtility.sleep(2000);
		realDeviceWait(15000);
		
		//verify that tell us what you like page shows up
		if (!isElementPresent(genrePicker))
			handleError("Genre Picker View is not displayed. Sign up failed.", "AIOS_22672_createAnAccount");
	}
    
    private String getCurrentDateInMilli()
	{
		Date date = new Date();
		return date.getTime() + "";
	}
   

}
