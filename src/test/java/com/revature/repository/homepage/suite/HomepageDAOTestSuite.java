package com.revature.repository.homepage.suite;

import com.revature.repository.homepage.positive.PlanetViewDaoPositiveTest;
import com.revature.repository.homepage.positive.MoonViewDaoPositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        PlanetViewDaoPositiveTest.class,
        MoonViewDaoPositiveTest.class
})

public class HomepageDAOTestSuite {
}
