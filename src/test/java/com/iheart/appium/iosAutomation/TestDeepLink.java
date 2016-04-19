package com.iheart.appium.iosAutomation;

import org.junit.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

public class TestDeepLink extends TestRoot {

	private DeepLink deepLink;

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@Ignore
	@Test
	/**
	 * Deep Link doesn't currently work. 
	 * @throws Exception
	 */
	public void deepLinkTest() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		Assert.assertTrue("Could not completel deeplink test." , deepLink.doDeepLink());
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
}
