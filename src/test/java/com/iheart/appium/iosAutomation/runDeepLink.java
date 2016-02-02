package com.iheart.appium.iosAutomation;

import org.junit.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

public class runDeepLink extends TestRoot {

	private DeepLink deepLink;

	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@Ignore
	@Test
	public void deepLinkTest() throws Exception {
		System.out.println("test method:" + name.getMethodName());
		deepLink.doDeepLink();
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
}
