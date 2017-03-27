package com.iheart.appium.suites;


import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.iheart.appium.utilities.TestRoot.RCStable;

/**
 * This class will include all the currently passing tests for the Regression RC
 * Running it should get a 100% passing score.
 * @author skutty
 */

@RunWith(Categories.class)
@IncludeCategory(RCStable.class)
@Suite.SuiteClasses({
	com.iheart.appium.iosAutomation.TestCuratedPlaylist.class,

})

/**
 * Class runs all tests from the above suites (when marked as stable)
 * @author daniellegolinsky
 *
 */
public class RegressionPassingSuite {
}
