package com.iheart.appium.iosAutomation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNewAccount extends TestRoot {

	@Before
	public void setUp() throws Exception {
		setup();
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
	
	@Test
	public void test_createAnAccount() throws Exception {
		Assert.assertTrue("Could not sign up for a new account.", signupPage.createAnAccount());
	}
}
