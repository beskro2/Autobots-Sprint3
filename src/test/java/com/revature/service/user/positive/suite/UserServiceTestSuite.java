package com.revature.service.user.positive.suite;

import com.revature.service.user.positive.negative.UserServiceAuthenticateNegativeTest;
import com.revature.service.user.positive.negative.UserServiceCreateUserNegativeTest;
import com.revature.service.user.positive.UserServicePositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServicePositiveTest.class,
        UserServiceCreateUserNegativeTest.class,
        UserServiceAuthenticateNegativeTest.class
})
public class UserServiceTestSuite {
}
