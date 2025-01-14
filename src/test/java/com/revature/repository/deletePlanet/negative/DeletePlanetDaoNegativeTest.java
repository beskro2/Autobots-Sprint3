package com.revature.repository.deletePlanet.negative;

import com.revature.planetarium.exceptions.PlanetFail;
import com.revature.repository.deletePlanet.parent.DeletePlanetDaoTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import  static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class DeletePlanetDaoNegativeTest extends DeletePlanetDaoTest {
    @Parameter
    public String negativePlanetName;

    @Parameter(1)
    public String exceptionMessage;

    @Parameters
    public static Collection<Object> input(){
        return Arrays.asList(new Object[][]{
                {"","Invalid planet name"},
                {"notaplanet","Invalid planet name"},
                {"non existing planet","Invalid planet name"}
        });
    }

    @Test
    public void deletePlanetDaoNegativeTest(){
        System.out.println("This is the negative planet name: " + negativePlanetName);
        //PlanetFail exception = Assert.assertThrows(PlanetFail.class, ()-> {planetDao.createPlanet(negativePlanet);});
        PlanetFail exception = Assert.assertThrows(PlanetFail.class, ()->{planetDao.deletePlanet(negativePlanetName);});
        Assert.assertEquals(exceptionMessage, exception.getMessage());
    }

}
