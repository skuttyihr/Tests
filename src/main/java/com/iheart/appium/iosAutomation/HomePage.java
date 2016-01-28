package com.iheart.appium.iosAutomation;


public class HomePage extends Page{

	public HomePage()
	{
		super();
	}
	/*
	public HomePage(IOSDriver _driver)
	{
		super(_driver);
	}
	*/
	public void gotoMyStations()
	{
		myStations.click();
	}
	public void gotoForYou()
	{
		forYou.click();
	}
	
	public void gotoPerfectFor()
	{
		perfectFor.click();
	}
	
}
