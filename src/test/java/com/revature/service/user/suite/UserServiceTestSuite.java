package com.revature.service.user.suite;

import com.revature.service.user.negative.UserServiceAuthenticateNegativeTest;
import com.revature.service.user.negative.UserServiceCreateUserNegativeTest;
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
