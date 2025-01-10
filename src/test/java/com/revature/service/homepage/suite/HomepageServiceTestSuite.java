package com.revature.service.homepage.suite;

import com.revature.service.homepage.positive.PlanetViewServicePositiveTest;
import com.revature.service.homepage.negative.PlanetViewServiceNegativeTest;
import com.revature.service.homepage.positive.MoonViewServicePositiveTest;
import com.revature.service.homepage.negative.MoonViewServiceNegativeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlanetViewServicePositiveTest.class,
        MoonViewServicePositiveTest.class,
        PlanetViewServiceNegativeTest.class,
        MoonViewServiceNegativeTest.class
})

public class HomepageServiceTestSuite {
}
