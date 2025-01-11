package com.revature.service.homepage.parent;

import com.revature.planetarium.repository.planet.PlanetDaoImp;
import com.revature.planetarium.repository.planet.PlanetDao;
import com.revature.planetarium.repository.moon.MoonDaoImp;
import com.revature.planetarium.repository.moon.MoonDao;
import com.revature.planetarium.service.planet.PlanetService;
import com.revature.planetarium.service.planet.PlanetServiceImp;
import com.revature.planetarium.service.moon.MoonService;
import com.revature.planetarium.service.moon.MoonServiceImp;
import com.revature.utility.Setup;
import org.junit.Before;
import org.mockito.Mockito;

public class HomepageServiceTest {
    protected MoonDao moonDao;
    protected PlanetDao planetDao;
    protected MoonService moonService;
    protected PlanetService planetService;

    @Before
    public void setup(){
        moonDao = Mockito.mock(MoonDaoImp.class);
        planetDao = Mockito.mock(PlanetDaoImp.class);
        moonService = new MoonServiceImp(moonDao);
        planetService = new PlanetServiceImp(planetDao);
        Setup.resetTestDatabase();
    }
}
