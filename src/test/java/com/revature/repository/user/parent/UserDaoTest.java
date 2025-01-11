package com.revature.repository.user.parent;

import com.revature.planetarium.repository.user.UserDao;
import com.revature.planetarium.repository.user.UserDaoImp;
import com.revature.utility.Setup;
import org.junit.Before;

public class UserDaoTest {

    protected UserDao userDao;

    @Before
    public void setup(){
        userDao = new UserDaoImp();
        Setup.resetTestDatabase();
    }

}
