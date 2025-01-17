package com.revature;

import com.revature.repository.createMoon.suite.CreateMoonDaoTestSuite;
import com.revature.repository.createPlanet.suite.CreatePlanetDaoTestSuite;
import com.revature.repository.deleteMoon.suite.deleteMoonDaoTestSuite;
import com.revature.repository.deletePlanet.suite.DeletePlanetDaoTestSuite;
import com.revature.repository.homepage.suite.HomepageDAOTestSuite;

import com.revature.service.createMoon.suite.createMoonServiceTestSuite;
import com.revature.service.createPlanet.suite.CreatePlanetServiceTestSuite;
import com.revature.service.deletePlanet.suite.DeletePlanetServiceTestSuite;
import com.revature.service.homepage.suite.HomepageServiceTestSuite;

import com.revature.service.user.suite.UserServiceTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //repository suites
        CreatePlanetDaoTestSuite.class,
        DeletePlanetDaoTestSuite.class,
        HomepageDAOTestSuite.class,
        UserServiceTestSuite.class,
        CreateMoonDaoTestSuite.class,
        deleteMoonDaoTestSuite.class,

        //service suites
        CreatePlanetServiceTestSuite.class,
        DeletePlanetServiceTestSuite.class,
        HomepageServiceTestSuite.class,
        com.revature.repository.suite.UserDaoTestSuite.class,
        createMoonServiceTestSuite.class,
        deleteMoonDaoTestSuite.class




})
public class PlanetariumTestSuite {
}
