package com.revature.service.homepage.suite;

import com.revature.service.homepage.positive.PlanetViewServicePositiveTest;
import com.revature.service.homepage.positive.MoonViewServicePositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlanetViewServicePositiveTest.class,
        MoonViewServicePositiveTest.class
})

public class HomepageServiceTestSuite {
}
