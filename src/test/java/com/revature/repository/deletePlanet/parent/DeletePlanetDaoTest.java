package com.revature.repository.deletePlanet.parent;

import com.revature.planetarium.repository.planet.PlanetDao;
import com.revature.planetarium.repository.planet.PlanetDaoImp;
import com.revature.utility.Setup;
import org.junit.Before;

public class DeletePlanetDaoTest {
    protected PlanetDao planetDao;

    @Before
    public void setup(){
        planetDao = new PlanetDaoImp();
        Setup.resetTestDatabase();
    }
}
