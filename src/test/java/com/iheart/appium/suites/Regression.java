package com.iheart.appium.suites;


import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.iheart.appium.utilities.TestRoot.RCStable;

/**
 * This class will include all the currently passing tests for the Regression RC
 * Running it should get a 100% passing score.
 */

@RunWith(Categories.class)
@IncludeCategory(Regression.class)
@Suite.SuiteClasses({
	com.iheart.appium.iosAutomation.TestCuratedPlaylist.class,
	com.iheart.appium.iosAutomation.TestSearch.class,
	com.iheart.appium.iosAutomation.TestAppboyUpsells.class,
	com.iheart.appium.iosAutomation.TestArtistProfile.class,
	com.iheart.appium.iosAutomation.TestCuratedPlaylist.class,
	com.iheart.appium.iosAutomation.TestFullPlayer.class,
	com.iheart.appium.iosAutomation.TestHomePage.class,
	com.iheart.appium.iosAutomation.TestLogin.class,
	com.iheart.appium.iosAutomation.TestMyMusic.class,
	com.iheart.appium.iosAutomation.TestOnboarding.class,
	com.iheart.appium.iosAutomation.TestHomePage.class,
	com.iheart.appium.iosAutomation.TestNewAccount.class,
})

/**
 * Class runs all tests from the above suites (when marked as Regression)
 *
 */
public class Regression {
}
