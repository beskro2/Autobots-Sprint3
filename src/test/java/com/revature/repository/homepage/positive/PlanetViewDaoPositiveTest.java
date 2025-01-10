package com.revature.repository.homepage.positive;

import com.revature.planetarium.entities.Planet;
import com.revature.repository.homepage.parent.HomepageDaoTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlanetViewDaoPositiveTest extends HomepageDaoTest {

    // Tests Pre-Existing Planet: Earth
    @Test
    public void readPlanetPositiveTest1(){
        System.out.println("Testing readPlanet() with Pre-Existing Planet: Earth");
        // Test by ID
        Optional<Planet> response = planetDao.readPlanet(1);
        System.out.println("Testing Planet ID");
        if (response.isPresent()){
            Assert.assertEquals(1, response.get().getPlanetId());
            Assert.assertEquals("Earth", response.get().getPlanetName());
            System.out.println("Test Passed | Found ID: " + response.get().getPlanetId() + " | Found Planet Name: " + response.get().getPlanetName());
        }else{
            Assert.fail("Test Failed Planet Not Found");
        }
        // Test by Name
        response = planetDao.readPlanet("Earth");
        System.out.println("Testing Planet Name");
        if (response.isPresent()){
            Assert.assertEquals(1, response.get().getPlanetId());
            Assert.assertEquals("Earth", response.get().getPlanetName());
            System.out.println("Test Passed | Found ID: " + response.get().getPlanetId() + " | Found Planet Name: " + response.get().getPlanetName());
        }else{
            Assert.fail("Test Failed Planet Not Found");
        }
        System.out.println("\n");
    }

    // Tests Pre-Existing Planet: Mars
    @Test
    public void readPlanetPositiveTest2(){
        System.out.println("Testing readPlanet() with Pre-Existing Planet: Mars");
        // Test by ID
        System.out.println("Testing Planet ID");
        Optional<Planet> response = planetDao.readPlanet(2);
        if (response.isPresent()){
            Assert.assertEquals(2, response.get().getPlanetId());
            Assert.assertEquals("Mars", response.get().getPlanetName());
            System.out.println("Test Passed | Found ID: " + response.get().getPlanetId() + " | Found Planet Name: " + response.get().getPlanetName());
        }else{
            Assert.fail("Test Failed Planet Not Found");
        }
        // Test by Name
        response = planetDao.readPlanet("Mars");
        System.out.println("Testing Planet Name");
        if (response.isPresent()){
            Assert.assertEquals(2, response.get().getPlanetId());
            Assert.assertEquals("Mars", response.get().getPlanetName());
            System.out.println("Test Passed | Found ID: " + response.get().getPlanetId() + " | Found Planet Name: " + response.get().getPlanetName());
        }else{
            Assert.fail("Test Failed Planet Not Found");
        }
        System.out.println("\n");
    }

    // Testing Read All Planets Method With Expected Pre-Existing Planets
    @Test
    public void readAllPlanetsTest(){
        System.out.println("Testing readAllPlanets()");
        List<Planet> response = planetDao.readAllPlanets();
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
