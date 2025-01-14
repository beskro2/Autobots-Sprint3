package com.revature.service.deletePlanet.negative;

import com.revature.planetarium.exceptions.PlanetFail;
import com.revature.service.deletePlanet.parent.DeletePlanetServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import  static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class DeletePlanetServiceNegativeTest extends DeletePlanetServiceTest {

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
    public void deletePlanetServiceNegativeTest() {
        Mockito.when(planetDao.deletePlanet(negativePlanetName)).thenReturn(false);
        PlanetFail exception = Assert.assertThrows(PlanetFail.class, ()->{planetService.deletePlanet(negativePlanetName);});
        Assert.assertEquals(exceptionMessage, exception.getMessage());
    }
}
