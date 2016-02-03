package com.iheart.appium.iosAutomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLogin extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
	
	@Test
	public void test_loginViaFacebook() {
		loginPage.loginViaFacebook();
	}
}
