package com.revature.repository.homepage.suite;

import com.revature.repository.homepage.positive.PlanetViewDaoPositiveTest;
import com.revature.repository.homepage.positive.MoonViewDaoPositiveTest;
import com.revature.repository.homepage.negative.PlanetViewDaoNegativeTest;
import com.revature.repository.homepage.negative.MoonViewDaoNegativeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        PlanetViewDaoPositiveTest.class,
        MoonViewDaoPositiveTest.class,
        PlanetViewDaoNegativeTest.class,
        MoonViewDaoNegativeTest.class
})

public class HomepageDAOTestSuite {
}
