package com.revature.repository.deleteMoon.suite;


import com.revature.repository.deleteMoon.negative.MoonDaoDeleteMoonNegativeTest;
import com.revature.repository.deleteMoon.positive.MoonDaoDeleteMoonPositiveTest;
import com.revature.service.createMoon.negative.MoonServiceCreateMoonNegativeTest;
import com.revature.service.createMoon.positive.MoonServiceCreateMoonPositiveTest;
import com.revature.service.deleteMoon.negative.MoonServiceDeleteMoonNegativeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       MoonDaoDeleteMoonPositiveTest.class,
        MoonDaoDeleteMoonNegativeTest.class
})
public class deleteMoonDaoTestSuite {
}
