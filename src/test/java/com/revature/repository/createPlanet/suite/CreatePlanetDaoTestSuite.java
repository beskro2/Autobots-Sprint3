package com.revature.repository.createPlanet.suite;

import com.revature.repository.createPlanet.negative.CreatePlanetDaoNegativeTest;
import com.revature.repository.createPlanet.positive.CreatePlanetDaoPositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        CreatePlanetDaoPositiveTest.class,
        CreatePlanetDaoNegativeTest.class
})
public class CreatePlanetDaoTestSuite {
}
