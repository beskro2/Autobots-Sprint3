package com.revature.service.deletePlanet.suite;

import com.revature.service.deletePlanet.negative.DeletePlanetServiceNegativeTest;
import com.revature.service.deletePlanet.positive.DeletePlanetServicePositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
       DeletePlanetServicePositiveTest.class,
       DeletePlanetServiceNegativeTest.class
})
public class DeletePlanetServiceTestSuite {
}
