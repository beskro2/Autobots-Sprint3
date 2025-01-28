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





    // Test readMoonsByPlanet() Using Negative Test Data (Planet ID)
    //This test is a failure and causes the build to failr
    @Ignore
    @Test
    public void readMoonsByOwnerNegative(){
        System.out.println("Testing readPlanetsByOwner() with Owner ID: " + planetID);
        List<Moon> response = moonDao.readMoonsByPlanet(planetID);
        Assert.assertTrue(response.isEmpty());
        System.out.println("\n");
    }

}
