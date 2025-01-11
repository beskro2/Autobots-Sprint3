package com.revature.service.homepage.negative;

import com.revature.planetarium.entities.Moon;
import com.revature.service.homepage.parent.HomepageServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MoonViewServiceNegativeTest extends HomepageServiceTest {

    private Moon negativeMoon;
    private List<Moon> expectedEmpty;

    @Parameter
    public int moonId;

    @Parameter(1)
    public String moonName;

    @Parameter(2)
    public int planetID;

    @Parameters
    public static Collection<Object> inputs(){
        return Arrays.asList(new Object[][]{
                {3,"gandalffrodosamlegolisegimliborimirearigorn",3},
                {9,"",999},
                {0,"Saurumon#@!",0},
                {-1,"21321321",-1}
        });
    }

    @Before
    public void negativeSetup(){
        negativeMoon = new Moon();
        negativeMoon.setMoonId(moonId);
        negativeMoon.setMoonName(moonName);
        negativeMoon.setOwnerId(planetID);
        expectedEmpty = new ArrayList<>();
    }

    // Testing selectByPlanet() Using Positive Data (Planet ID)
    @Test
    public void selectByOwnerTest(){
        System.out.println("Testing Planet ID: " + negativeMoon.getOwnerId());
        Mockito.when(moonDao.readMoonsByPlanet(Mockito.anyInt())).thenReturn(expectedEmpty);
        List<Moon> result = planetService.selectByOwner(negativeMoon.getOwnerId());
        Assert.assertTrue(result.isEmpty());
        System.out.println("Test Passed: List is Empty from Non-Existent Planet ID\n");
    }
}
