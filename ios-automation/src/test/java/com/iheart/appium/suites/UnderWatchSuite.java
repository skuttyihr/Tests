package com.iheart.appium.suites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.iheart.appium.utilities.TestRoot.Stable;
import com.iheart.appium.utilities.TestRoot.UnderWatchForStability;


@RunWith(Categories.class)
@IncludeCategory(UnderWatchForStability.class)
@Suite.SuiteClasses({
	com.iheart.appium.iosAutomation.TestSearch.class,
})

/**
 * Class runs all tests from the above suites (when marked as stable)
 * @author daniellegolinsky
 *
 */
public class UnderWatchSuite {

}
