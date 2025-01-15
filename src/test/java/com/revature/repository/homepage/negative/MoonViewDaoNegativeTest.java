package com.revature.repository.homepage.negative;

import com.revature.planetarium.entities.Moon;
import com.revature.repository.homepage.parent.HomepageDaoTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MoonViewDaoNegativeTest extends HomepageDaoTest{


    @Parameter
    public int moonID;

    @Parameter(1)
    public String moonName;

    @Parameter(2)
    public int planetID;

    @Parameters
    public static Collection<Object> inputs(){
        return Arrays.asList(new Object[][]{
                {-1,"", -1},
                {0,"@@@@", 0},
                {3,"9Earth", 3},
                {9,"notaplanet", 9},
                {99,"11111111111111111", 99},
                {999," ", 999},
                {9999,"DOESNTEXIST1!!!", 9999},
        });
    }

    // Test readMoon() Using Negative Test Data (ID)
    @Ignore("NOT NEEDED TO MEET MVP REQUIREMENTS")
    @Test
    public void readMoonNegativeTestID(){
        System.out.println("Testing readMoon() using ID: " + moonID);
        Optional<Moon> result = moonDao.readMoon(moonID);
        Assert.assertFalse(result.isPresent());
        System.out.println("\n");
    }

    // Test readMoon() Using Negative Test Data (Moon Name)
    @Ignore("NOT NEEDED TO MEET MVP REQUIREMENTS")
    @Test
    public void readMoonNegativeTestName(){
        System.out.println("Testing readMoon() using Planet Name: " + moonName);
        Optional<Moon> result = moonDao.readMoon(moonName);
        Assert.assertFalse(result.isPresent());
        System.out.println("\n");
    }

    // Test readMoonsByPlanet() Using Negative Test Data (Planet ID)
    @Test
    public void readPlanetsByOwnerNegative(){
        System.out.println("Testing readPlanetsByOwner() with Owner ID: " + planetID);
        List<Moon> response = moonDao.readMoonsByPlanet(planetID);
        Assert.assertTrue(response.isEmpty());
        System.out.println("\n");
    }

}
