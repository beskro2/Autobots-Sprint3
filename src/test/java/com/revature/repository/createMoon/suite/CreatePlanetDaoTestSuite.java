package com.revature.repository.createMoon.suite;


import com.revature.service.createMoon.negative.MoonServiceCreateMoonNegativeTest;
import com.revature.service.createMoon.positive.MoonServiceCreateMoonPositiveTest;
import com.revature.service.deleteMoon.negative.MoonServiceDeleteMoonNegativeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MoonServiceCreateMoonPositiveTest.class,
        MoonServiceCreateMoonNegativeTest.class
})
public class CreatePlanetDaoTestSuite {
}
