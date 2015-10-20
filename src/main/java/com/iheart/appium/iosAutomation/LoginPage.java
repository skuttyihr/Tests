package com.iheart.appium.iosAutomation;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.*;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")
	    private IOSElement userName;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]")
	   private IOSElement password;
	@iOSFindBy(name="Log In") private IOSElement loginButton;
	
	
	@iOSFindBy(name="Facebook") private WebElement facebookButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
		private WebElement fbEmail;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	    private IOSElement fbPassword;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
		private IOSElement fbLogin;
	
	
	//WEB version
	@FindBy(name="email") private WebElement facebookEmail_web;
	@FindBy(name="pass") private WebElement facebookPass_web;
	@FindBy(name="login") private WebElement facebookLogin;
	
	
	//Native version
	/*
	 * //*[@id="u_0_0"]/div[1]/div/input
	 * 
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]") 
	   private WebElement facebookEmail;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	   private WebElement facebookPassword;
	*/
	
	@iOSFindBy(name="Google") private WebElement googleButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	   private WebElement googleEmail;
	@iOSFindBy(name="Next") private WebElement nextButton;
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
	   private WebElement googlePassword;
	@iOSFindBy(name="Sign in") private WebElement signIn;
	//for first-timer
	@iOSFindBy(name="Continue") private WebElement continueButton; //for first-time login user
	@iOSFindBy(name="Allow") private WebElement allowButton;
	
	//for verification: Maybe shall move nav bar stuff up to the Page.java?
	@iOSFindBy(name="For You") private WebElement forYou;
	
	
	

	public LoginPage()
	{
		super();
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public LoginPage(IOSDriver _driver)
	{
		super(_driver);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void login()
	{  //logger.info("About to login...");
	   
	   loginButton.click();
	   
	   	userName.sendKeys(USER_NAME);
		password.sendKeys(PASSWORD);
		//loginButton.click();
	    
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
		if (isRealDevice)
		    WaitUtility.sleep(15000);
		else
		    WaitUtility.sleep(5000);
		
		chooseStayConnected(false);
		
		
		//verify we are in!
	   
	    driver.findElement(By.name("For You")).getText();
	   try{
		   driver.findElement(By.name("For You")).getText();
	   }catch(Exception e)
	   {
		   errors.append("Home page is not shown.");
	   }
	}
	
	
	public void loginViaFacebook()
	{   System.out.println("See context:" + driver.getContext());
		//getContextHandles();
		loginButton.click();
	    WaitUtility.sleep(1000);
	    facebookButton.click();
	    WaitUtility.sleep(2000);
	   
	    System.out.println("See context again:" + driver.getContext());
	    
	    System.out.println("SEE PAGE: " + driver.getPageSource());
	   /* NATIVE VERSION
	    fbEmail.sendKeys(FACEBOOK_USER_NAME);
		fbPassword.sendKeys(PASSWORD);
		fbLogin.click();
		*/
	    
	    
	    facebookEmail_web.sendKeys(FACEBOOK_USER_NAME);
		facebookPass_web.sendKeys(PASSWORD);
		facebookLogin.click();
		
		System.out.println("Done.");
	    /* If facebook is installed on this phone or sim
	     * iOS 9 is hybrid: SafariViewController inside of app showing facebook website
		  iOS 8 switches to native FB app on phone, if it doesn't exist, goes to external Safari and fb site
	     */
		/*
		facebookButton.click();
		WaitUtility.sleep(2000);
		facebookEmail.sendKeys(FACEBOOK_USER_NAME);
		facebookPassword.sendKeys(PASSWORD);
		loginButton.click();
		*/
	}
	
	
	public void loginViaGoogle()
	{   loginButton.click();
    	WaitUtility.sleep(1000);
		googleButton.click();
		WaitUtility.sleep(2000);
		googleEmail.sendKeys(GOOGLE_USER_NAME);
		nextButton.click();
	    googlePassword.sendKeys(PASSWORD);
		signIn.click();
	    try{
	    	continueButton.click();
	    }catch(Exception e)
	    {
	    	
	    }
	    
	    try{
	    	allowButton.click();
	    }catch(Exception e)
	    {
	    	
	    }
	    //verfiy that we are in Perfect for now!
	    //See page source:
	    logger.info("see page:" +  driver.getPageSource()) ;
		
	}
	
	
	private void chooseStayConnected(boolean stayConnected)
	{    handlePossiblePopUp();
		tellUsWhatYouLike();
		try{
			 if (stayConnected)
				 driver.findElement(By.name("Get Notifications")).click();
			 else 
				 driver.findElement(By.name("Maybe Later")).click();
		}catch(Exception e)
		{
			
		}
		
		WaitUtility.sleep(2000);
	}
	
	//Want your local radio?
	private void handlePossiblePopUp()
	{
		try{
			if (isRealDevice)
				WaitUtility.sleep(10000);
			else
			    WaitUtility.sleep(1000);
			driver.findElement(By.name("No Thanks")).click();
		}catch(Exception e)
		{
			
		}
	}
	
    //Tell us what you like
	private void tellUsWhatYouLike()
	{   try{
		  driver.findElement(By.name("Rock")).click();
		  if (isRealDevice)
			  WaitUtility.sleep(2000);
		  driver.findElement(By.name("Done")).click();
		  WaitUtility.sleep(2000);
		}catch(Exception e)
		{
			
		}
	}
	
}
