package com.iheart.appium.iosAutomation;

import static org.junit.Assert.fail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class TestRoot {

	protected static IOSDriver<IOSElement> driver;

	// Desired Capabilities for Appium to be imported from properties
	protected static String DEVICE_NAME;
	protected static String UDID;
	protected static String BUNDLE_ID;
	protected static String IPA_NAME;

	protected static void setup() {

	}

	protected static void tearDown() {
		if (Page.getErrors().length() > 0) {
			fail(Page.getErrors().toString());
		}
	}

	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		public void finished(Description description) {
			driver.quit();
		}

		@Override
		public void failed(Throwable e, Description description) {

			try {

				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// String filePathRoot = "C:\\_Jenkins\\workspace\\" +
				// jenkinsJobName + "\\target\\surefire-reports\\";
				String currentPath = System.getProperty("user.dir");
				String path = currentPath + "\\target\\surefire-reports\\";

				String fullFilePath = path + description.getClassName() + "\\" + description.getMethodName() + ".jpg";

				FileUtils.copyFile(screenshot, new File(fullFilePath));

			} catch (Exception ex) {
				System.out.println(ex.toString());
				System.out.println(ex.getMessage());
			}

			driver.quit();
		}
	};
}
