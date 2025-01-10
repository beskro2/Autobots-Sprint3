package com.revature.repository.homepage.positive;

import com.revature.planetarium.entities.Moon;
import com.revature.repository.homepage.parent.HomepageDaoTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MoonViewDaoPositiveTest extends HomepageDaoTest {

    // Tests Pre-Existing Moon: Luna
    @Test
    public void readMoonPositiveTest1(){
        System.out.println("Testing readMoon() with Pre-Existing Moon: Luna");
        // Test by ID
        Optional<Moon> response = moonDao.readMoon(1);
        System.out.println("Testing Moon ID");
        if (response.isPresent()){
            Assert.assertEquals(1, response.get().getMoonId());
            Assert.assertEquals("Luna", response.get().getMoonName());
            Assert.assertEquals(1, response.get().getOwnerId());
            System.out.println("Test Passed | Found ID: " + response.get().getMoonId() + " | Found Moon Name: " + response.get().getMoonName() + " | With the Owner ID of: " + response.get().getOwnerId());
        }else{
            System.out.println("Test Failed Moon Not Found");
            Assert.fail();
        }
        // Test by Name
        response = moonDao.readMoon("Luna");
        System.out.println("Testing Moon Name");
        if (response.isPresent()){
            Assert.assertEquals(1, response.get().getMoonId());
            Assert.assertEquals("Luna", response.get().getMoonName());
            Assert.assertEquals(1, response.get().getOwnerId());
            System.out.println("Test Passed | Found ID: " + response.get().getMoonId() + " | Found Moon Name: " + response.get().getMoonName() + " | With the Owner ID of: " + response.get().getOwnerId());
        }else{
            System.out.println("Test Failed Moon Not Found");
            Assert.fail();
        }
        System.out.println("\n");
    }

    // Tests Pre-Existing Moon: Titan
    @Test
    public void readMoonPositiveTest2(){
        System.out.println("Testing readMoon() with Pre-Existing Moon: Titan");
        // Test by ID
        Optional<Moon> response = moonDao.readMoon(2);
        System.out.println("Testing Planet ID");
        if (response.isPresent()){
            Assert.assertEquals(2, response.get().getMoonId());
            Assert.assertEquals("Titan", response.get().getMoonName());
            Assert.assertEquals(2, response.get().getOwnerId());
            System.out.println("Test Passed | Found ID: " + response.get().getMoonId() + " | Found Moon Name: " + response.get().getMoonName() + " | With the Owner ID of: " + response.get().getOwnerId());
        }else{
            System.out.println("Test Failed Moon Not Found");
            Assert.fail();
        }
        // Test by Name
        response = moonDao.readMoon("Titan");
        System.out.println("Testing Moon Name");
        if (response.isPresent()){
            Assert.assertEquals(2, response.get().getMoonId());
            Assert.assertEquals("Titan", response.get().getMoonName());
            Assert.assertEquals(2, response.get().getOwnerId());
            System.out.println("Test Passed | Found ID: " + response.get().getMoonId() + " | Found Moon Name: " + response.get().getMoonName() + " | With the Owner ID of: " + response.get().getOwnerId());
        }else{
            System.out.println("Test Failed Moon Not Found");
            Assert.fail();
        }
        System.out.println("\n");
    }

    // Testing Read All Moons Method With Expected Pre-Existing Moons
    @Test
    public void readAllMoonsTest(){
        System.out.println("Testing readAllMoons()");
        List<Moon> response = moonDao.readAllMoons();
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        if (!response.isEmpty() && response.size() == expected.size()){
            for (int index = 0; index < response.size(); index++){
                Assert.assertEquals(expected.get(index).intValue(), response.get(index).getMoonId());
                System.out.println("Test Passed | Found ID: " + response.get(index).getMoonId() + " | Found Moon Name: " + response.get(index).getMoonName() + " | With the Owner ID of: " + response.get(index).getOwnerId());
            }
        }else{
            System.out.println("Test Failed: Unexpected Result Moon List Is Empty");
            Assert.fail();
        }
        System.out.println("\n");
    }

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
            System.out.println("Test Failed: Unexpected Result Moon List Is Empty");
            Assert.fail();
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
            System.out.println("Test Failed: Unexpected Result Moon List Is Empty");
            Assert.fail();
        }
        System.out.println("\n");
    }
}
