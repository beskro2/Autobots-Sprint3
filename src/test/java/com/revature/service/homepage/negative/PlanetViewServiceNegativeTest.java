package com.revature.service.homepage.negative;

import com.revature.planetarium.entities.Planet;
import com.revature.service.homepage.parent.HomepageServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class PlanetViewServiceNegativeTest extends HomepageServiceTest {

    private Planet negativePlanet;
    private List<Planet> expectedEmpty;

    @Parameter
    public int planetId;

    @Parameter(1)
    public String planetName;

    @Parameter(2)
    public int ownerID;

    @Parameters
    public static Collection<Object> inputs(){
        return Arrays.asList(new Object[][]{
                {3,"gandalffrodosamlegolisegimliborimirearigorn",1},
                {9,"",999},
                {0,"Saurumon#@!",0},
                {-1,"21321321",-1}
        });
    }

    @Before
    public void negativeSetup(){
        negativePlanet = new Planet();
        negativePlanet.setPlanetId(planetId);
        negativePlanet.setPlanetName(planetName);
        negativePlanet.setOwnerId(ownerID);
        expectedEmpty = new ArrayList<>();
    }

    // Testing selectByOwner() Using Positive Data (Owner ID)
    @Test
    public void selectByOwnerTestOwnerID(){
        System.out.println("Testing Owner ID: " + negativePlanet.getOwnerId());
        Mockito.when(planetDao.readPlanetsByOwner(Mockito.anyInt())).thenReturn(expectedEmpty);
        List<Planet> result = planetService.selectByOwner(negativePlanet.getOwnerId());
        Assert.assertTrue(result.isEmpty());
        System.out.println("Test Passed: List is Empty from Non-Existent Owner\n");
    }
}
