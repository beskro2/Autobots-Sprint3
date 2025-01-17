package com.revature.repository.user.negative.suite;

import com.revature.repository.user.negative.UserDaoCreateUserNegativeTest;
import com.revature.repository.user.negative.UserDaoFindUserByUsernameNegativeTest;
import com.revature.repository.user.negative.positive.UserDaoPositiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        UserDaoPositiveTest.class,
        UserDaoCreateUserNegativeTest.class,
        UserDaoFindUserByUsernameNegativeTest.class
})
public class UserDaoTestSuite {

}
