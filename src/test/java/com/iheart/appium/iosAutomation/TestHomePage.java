package com.iheart.appium.iosAutomation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHomePage extends TestRoot {

	@Before
	public void setUp() throws Exception {
		TestRoot.setup();
	}
	@After
	public void after() {
		TestRoot.tearDown();
	}
	
	@Test
	public void testSearchFilters(){
		Assert.assertTrue("Was not able to login", loginPage.login()); // Log in so we can choose artist stations later
		
	}
}
