package com.iheart.appium.iosAutomation;

import org.junit.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

public class runDeepLink extends iosTest {

	private DeepLink deepLink;

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {

		// BasicConfigurator.configure();

		driver = Utils.launchBrowser("safari");
		driver.get("http://m.z100.com");
		WaitUtility.sleep(5000);
		Page.setDriver(driver);

		deepLink = new DeepLink(driver);

	}

	@Test
	public void AIOS_22641_doDeepLink() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		try {
			deepLink.AIOS_22641_doDeepLink();

		} catch (Exception e) {
			e.printStackTrace();
			Utils.takeScreenshot(driver, "testLogin");
		}
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
}
