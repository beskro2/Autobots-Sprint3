package com.revature.service.deleteMoon.suite;

import com.revature.service.deleteMoon.negative.MoonServiceDeleteMoonNegativeTest;
import com.revature.service.deleteMoon.positive.MoonServiceDeleteMoonPositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MoonServiceDeleteMoonNegativeTest.class,
        MoonServiceDeleteMoonPositiveTest.class
})
public class deleteMoonServiceTestSuite {
}
