package com.revature.service.user.suite;


import com.revature.service.negative.UserServiceAuthenticateNegativeTest;
import com.revature.service.negative.UserServiceCreateUserNegativeTest;
import com.revature.service.positive.UserServicePositiveTest;
import com.revature.service.user.negative.Unit_RegisterDuplicateUsername;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServicePositiveTest.class,
        UserServiceCreateUserNegativeTest.class,
       UserServiceAuthenticateNegativeTest.class,
       com.revature.service.user.negative.Unit_RegisterDuplicateUsername.class

})
public class UserServiceTestSuite {
}
