package com.revature.repository.deletePlanet.positive;

import com.revature.repository.deletePlanet.parent.DeletePlanetDaoTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import  static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class DeletePlanetDaoPositiveTest extends DeletePlanetDaoTest {
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
    public void deletePlanetDaoPositiveTest() {
        System.out.println("This is the planet that is going to be deleted: " + positivePlanetName);
        boolean result = planetDao.deletePlanet(positivePlanetName);
        Assert.assertTrue(result);
    }

}
