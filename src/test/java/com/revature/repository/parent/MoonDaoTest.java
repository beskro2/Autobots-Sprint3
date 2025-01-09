package com.revature.repository.parent;

import com.revature.planetarium.repository.moon.MoonDao;
import com.revature.planetarium.repository.moon.MoonDaoImp;
import com.revature.planetarium.repository.user.UserDao;
import com.revature.planetarium.repository.user.UserDaoImp;
import com.revature.utility.Setup;
import org.junit.Before;


public class MoonDaoTest {

    protected MoonDao moonDao;

    @Before
    public void setUp(){
    moonDao = new MoonDaoImp();
    Setup.resetTestDatabase(); // make suretocheck where this connects
    }

}
