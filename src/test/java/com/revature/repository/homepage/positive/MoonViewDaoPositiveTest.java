package com.revature.repository.homepage.positive;

import com.revature.planetarium.entities.Moon;
import com.revature.repository.homepage.parent.HomepageDaoTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MoonViewDaoPositiveTest extends HomepageDaoTest {

    // Testing Pre-Existing PlanetID: 1
    @Test
    public void readMoonsByOwnerTest1(){
        System.out.println("Testing readMoonsByOwner() with Pre-Existing Owner ID: 1");
        List<Moon> response = moonDao.readMoonsByPlanet(1);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        if (!response.isEmpty() && response.size() == expected.size()){
            for (int index = 0; index < response.size(); index++){
                Assert.assertEquals(expected.get(index).intValue(), response.get(index).getMoonId());
                System.out.println("Test Passed | Found ID: " + response.get(index).getMoonId() + " | Found Moon Name: " + response.get(index).getMoonName() + " | With the Owner ID of: " + response.get(index).getOwnerId());
            }
        }else{
            System.out.println();
            Assert.fail("Test Failed: Unexpected Result Moon List Is Empty or Size Not (Equal To) Expected");
        }
        System.out.println("\n");
    }

    // Testing Pre-Existing PlanetID: 2
    @Test
    public void readMoonsByOwnerTest2(){
        System.out.println("Testing readMoonsByOwner() with Pre-Existing Owner ID: 2");
        List<Moon> response = moonDao.readMoonsByPlanet(2);
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        if (!response.isEmpty() && response.size() == expected.size()){
            for (int index = 0; index < response.size(); index++){
                Assert.assertEquals(expected.get(index).intValue(), response.get(index).getMoonId());
                System.out.println("Test Passed | Found ID: " + response.get(index).getMoonId() + " | Found Moon Name: " + response.get(index).getMoonName() + " | With the Owner ID of: " + response.get(index).getOwnerId());
            }
        }else{
            Assert.fail("Test Failed: Unexpected Result Moon List Is Empty or Size Not (Equal To) Expected");
        }
        System.out.println("\n");
    }
}
