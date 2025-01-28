package com.revature.repository.homepage.positive;

import com.revature.planetarium.entities.Planet;
import com.revature.repository.homepage.parent.HomepageDaoTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlanetViewDaoPositiveTest extends HomepageDaoTest {



    // Testing Read All Planets Method With Expected Pre-Existing Planets


    // Testing Pre-Existing UserID: 1
    @Test
    public void readPlanetsByOwnerPositiveTest(){
        System.out.println("Testing readPlanetsByOwner() with Pre-Existing Owner ID: 1");
        List<Planet> response = planetDao.readPlanetsByOwner(1);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        if (!response.isEmpty() && response.size() == expected.size()){
            for (int index = 0; index < response.size(); index++){
                Assert.assertEquals(expected.get(index).intValue(), response.get(index).getPlanetId());
                System.out.println("Test Passed | Found ID: " + response.get(index).getPlanetId() + " | Found Planet Name: " + response.get(index).getPlanetName());
            }
        }else{
            Assert.fail("Test Failed: Unexpected Result Planet List Is Empty or Size Not (Equal To) Expected");
        }
        System.out.println("\n");
    }
}
