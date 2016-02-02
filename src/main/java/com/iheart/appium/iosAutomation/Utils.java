package com.iheart.appium.iosAutomation;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Map;
import java.util.Properties;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static void takeScreenshot(WebDriver driver, String testMethod) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		// System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		String screenshotName = testMethod + dateFormat.format(date) + ".png";
		System.out.println("See screenshotName:" + screenshotName);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		FileUtils.copyFile(scrFile, new File(screenshotName));
		System.out.println("Screenshot is taken.");
	}

	public static void waitForPageToLoad(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {

				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

			}

		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 1000);

		try {

			wait.until(expectation);

		} catch (Throwable error) {

			System.out.println("Timeout waiting for Page Load Request to complete.");

		}

	}

	public static int getRandomInt() {
		Random randomGenerator = new Random();

		int randomInt = randomGenerator.nextInt(999999);

		return randomInt;

	}

	public static Map<String, String> getLocationByIp(WebDriver driver) {
		Map<String, String> geoInfo = new HashMap<String, String>();
		driver.navigate().to("http://www.iplocation.net");
		String country = driver
				.findElement(
						By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(2)"))
				.getText();
		String state = driver
				.findElement(
						By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(3)"))
				.getText();
		String city = driver
				.findElement(
						By.cssSelector("#geolocation > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(4)"))
				.getText();

		geoInfo.put("country", country);
		geoInfo.put("state", state);
		geoInfo.put("city", city);

		return geoInfo;
	}

	
	public static Properties loadProperties(String propFile) throws Exception{
		Properties loadedProps = new Properties();
		InputStream in = null;
		try{
			in = Utils.class.getClassLoader().getResourceAsStream(propFile);
			loadedProps.load(in);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			in.close();
		}
		return loadedProps;
	}
}
