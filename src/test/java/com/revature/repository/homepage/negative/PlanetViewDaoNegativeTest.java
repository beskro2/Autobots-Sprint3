package com.revature.repository.homepage.negative;

import com.revature.planetarium.entities.Planet;
import com.revature.repository.homepage.parent.HomepageDaoTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class PlanetViewDaoNegativeTest extends HomepageDaoTest{

    @Parameter
    public int planetId;

    @Parameter(1)
    public String planetName;

    @Parameter(2)
    public int ownerID;

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

    // Test readPlanetsByOwner() Using Negative Test Data (Owner ID)
    @Test
    public void readPlanetsByOwnerNegative(){
        System.out.println("Testing readPlanetsByOwner() with Owner ID: " + ownerID);
        List<Planet> response = planetDao.readPlanetsByOwner(ownerID);
        Assert.assertTrue(response.isEmpty());
        System.out.println("\n");
    }
}
