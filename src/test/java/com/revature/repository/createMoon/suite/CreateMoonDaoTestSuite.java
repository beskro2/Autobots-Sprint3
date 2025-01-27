package com.revature.repository.createMoon.suite;


import com.revature.service.createMoon.negative.MoonServiceCreateMoonNegativeTest;
import com.revature.service.createMoon.positive.MoonServiceCreateMoonPositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MoonDaoCreateMoonPositiveTest.class,
        MoonDaoCreateMoonNegativeTest.class
})
public class CreateMoonDaoTestSuite {
}
