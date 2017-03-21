package com.iheart.appium.suites;


import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.iheart.appium.utilities.TestRoot.Stable;

/**
 * This class will include all the currently passing tests for the current Snapshot/RC
 * Running it should get a 100% passing score.
 * 
 * @author daniellegolinsky
 *
 */

@RunWith(Categories.class)
@IncludeCategory(Stable.class)
@Suite.SuiteClasses({
	// Example: Tests.TestGate.class,
})

/**
 * Class runs all tests from the above suites (when marked as stable)
 * @author daniellegolinsky
 *
 */
public class PassingSuite {

}
