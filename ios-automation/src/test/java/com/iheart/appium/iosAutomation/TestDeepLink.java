package com.iheart.appium.iosAutomation;

import org.junit.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.iheart.appium.utilities.TestRoot;

public class TestDeepLink extends TestRoot {

	private DeepLink deepLink;

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@Rule
	public RetryRule retry = new RetryRule(1);
	
	@Ignore
	//@Test
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
		tearDown();
	}
}
