package com.iheart.appium.iosAutomation;


import org.apache.log4j.Logger;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
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
