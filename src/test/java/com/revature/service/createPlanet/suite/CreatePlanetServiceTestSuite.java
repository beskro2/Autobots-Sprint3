package com.revature.service.createPlanet.suite;

import com.revature.service.createPlanet.negative.CreatePlanetServiceNegativeTest;
import com.revature.service.createPlanet.positive.CreatePlanetServicePositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreatePlanetServicePositiveTest.class,
        CreatePlanetServiceNegativeTest.class
})
public class CreatePlanetServiceTestSuite {
}
