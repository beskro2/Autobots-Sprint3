package com.revature.repository.homepage.parent;

import com.revature.planetarium.repository.planet.PlanetDaoImp;
import com.revature.planetarium.repository.planet.PlanetDao;
import com.revature.planetarium.repository.moon.MoonDaoImp;
import com.revature.planetarium.repository.moon.MoonDao;
import com.revature.utility.Setup;
import org.junit.Before;

public class HomepageDaoTest {

    protected MoonDao moonDao;
    protected PlanetDao planetDao;

    @Before
    public void setup(){
        moonDao = new MoonDaoImp();
        planetDao = new PlanetDaoImp();
        Setup.resetTestDatabase();
    }

}
