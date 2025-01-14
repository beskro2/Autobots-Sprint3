package com.revature.repository.deletePlanet.suite;

import com.revature.repository.deletePlanet.negative.DeletePlanetDaoNegativeTest;
import com.revature.repository.deletePlanet.positive.DeletePlanetDaoPositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        DeletePlanetDaoPositiveTest.class,
        DeletePlanetDaoNegativeTest.class
})
public class DeletePlanetDaoTestSuite {
}
