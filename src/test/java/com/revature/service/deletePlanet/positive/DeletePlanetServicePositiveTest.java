package com.revature.service.deletePlanet.positive;

import com.revature.service.deletePlanet.parent.DeletePlanetServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import  static org.junit.runners.Parameterized.*;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@RunWith(Parameterized.class)
public class DeletePlanetServicePositiveTest extends DeletePlanetServiceTest {
    @Parameter
    public String positivePlanetName;

    @Parameters
    public static Collection<Object> input(){
        return Arrays.asList(new Object[][]{
                {"Earth"},
                {"Mars"}
        });
    }

    @Test
    public void deletePlanetServicePositiveTest () {
        Mockito.when(planetDao.deletePlanet(positivePlanetName)).thenReturn(true);
        Assert.assertEquals(true,planetService.deletePlanet(positivePlanetName));
    }
}
