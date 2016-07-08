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
		tearDown();
	}
	/**
	 * Test: CreateNewAccount creates a new account in iOS. 
	 * It fills out email, password, zipcode, birth year(selection), gender, checks Terms and Conditions,
	 * Creates account, and then uses enters a zip code and expects the Genre page to open. 
	 * 
	 */
	@Test
	public void testCreateNewAccountWithDefaultParameters(){
		Assert.assertTrue(signupPage.createNewAccount());
		
	}
	@Test
	public void testAllElementsOnSignUpPage(){
		//We only care about console output here
		signupPage.checkAllElements();
		Assert.assertTrue(true);
	}
}
