package com.iheart.appium.iosAutomation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestNewAccount extends TestRoot {

	@Rule
	public TestRule watcher = new TestWatcher() {
	    protected void starting(Description description) {
	       System.out.println("\nStarting test: " + description.getMethodName());
	    }
	 };
	 
	@Before
	public void setUp() throws Exception {
		setup();
	}

	@After
	public void after() {
		TestRoot.tearDown();
	}
	/**
	 * Test: CreateAnAccount creates a new account in iOS. 
	 * It fills out email, password, zipcode, birth year(selection), gender, checks Terms and Conditions,
	 * Creates account, and then uses enters a zip code and expects the Genre page to open. 
	 * @throws Exception
	 */
	@Test
	public void test_createAnAccount() throws Exception {
		Assert.assertTrue("Could not sign up for a new account.", signupPage.createAnAccount());
	}
}
