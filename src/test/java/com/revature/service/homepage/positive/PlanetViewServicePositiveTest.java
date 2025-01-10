package com.revature.service.homepage.positive;

import com.revature.planetarium.entities.Planet;
import com.revature.service.homepage.parent.HomepageServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlanetViewServicePositiveTest extends HomepageServiceTest {

    private int knownUserID;
    private Planet positivePlanet;
    private Optional<Planet> readPlanetOptional;
    private Planet expectedPositivePlanet;
    private Planet positivePlanet2;
    private Optional<Planet> readPlanetOptional2;
    private Planet expectedPositivePlanet2;
    private List<Planet> expectedPlanetList;

    // Initialize Local Variables
    @Before
    public void positiveSetup(){
        knownUserID = 1;
        positivePlanet = new Planet();
        positivePlanet.setPlanetName("Earth");
        positivePlanet.setPlanetId(1);
        positivePlanet.setOwnerId(knownUserID);
        readPlanetOptional = Optional.of(positivePlanet);
        expectedPositivePlanet = new Planet();
        expectedPositivePlanet.setPlanetName("Earth");
        expectedPositivePlanet.setPlanetId(1);
        expectedPositivePlanet.setOwnerId(knownUserID);
        positivePlanet2 = new Planet();
        positivePlanet2.setPlanetName("Mars");
        positivePlanet2.setPlanetId(2);
        positivePlanet2.setOwnerId(knownUserID);
        readPlanetOptional2 = Optional.of(positivePlanet2);
        expectedPositivePlanet2 = new Planet();
        expectedPositivePlanet2.setPlanetName("Mars");
        expectedPositivePlanet2.setPlanetId(2);
        expectedPositivePlanet2.setOwnerId(1);
        expectedPlanetList = new ArrayList<>();
        expectedPlanetList.add(positivePlanet);
        expectedPlanetList.add(positivePlanet2);
    }

    // Testing selectPlanet() with Positive Data (ID)
    @Test
    public void selectPlanetPositiveTestID(){
        System.out.println("Testing Pre-Existing Planet Earth by ID:");
        Mockito.when(planetDao.readPlanet(positivePlanet.getPlanetId())).thenReturn(readPlanetOptional);
        Planet result = planetService.selectPlanet(positivePlanet.getPlanetId());
        Assert.assertEquals(expectedPositivePlanet, result);
        System.out.println("Test Passed | Found ID: " + result.getPlanetId() + " | Found Planet Name: " + result.getPlanetName() + " | Found Owner ID: " + result.getOwnerId());
        System.out.println("Testing Pre-Existing Planet Mars by ID:");
        Mockito.when(planetDao.readPlanet(positivePlanet2.getPlanetId())).thenReturn(readPlanetOptional2);
        result = planetService.selectPlanet(positivePlanet2.getPlanetId());
        Assert.assertEquals(expectedPositivePlanet2, result);
        System.out.println("Test Passed | Found ID: " + result.getPlanetId() + " | Found Planet Name: " + result.getPlanetName() + " | Found Owner ID: " + result.getOwnerId() + "\n");
    }

    // Testing selectPlanet() with Positive Data (Planet Name)
    @Test
    public void selectPlanetPositiveTestName(){
        System.out.println("Testing Pre-Existing Planet Earth by Name:");
        Mockito.when(planetDao.readPlanet(positivePlanet.getPlanetName())).thenReturn(readPlanetOptional);
        Planet result = planetService.selectPlanet(positivePlanet.getPlanetName());
        Assert.assertEquals(expectedPositivePlanet, result);
        System.out.println("Test Passed | Found ID: " + result.getPlanetId() + " | Found Planet Name: " + result.getPlanetName() + " | Found Owner ID: " + result.getOwnerId());
        System.out.println("Testing Pre-Existing Planet Mars by Name:");
        Mockito.when(planetDao.readPlanet(positivePlanet2.getPlanetName())).thenReturn(readPlanetOptional2);
        result = planetService.selectPlanet(positivePlanet2.getPlanetName());
        Assert.assertEquals(expectedPositivePlanet2, result);
        System.out.println("Test Passed | Found ID: " + result.getPlanetId() + " | Found Planet Name: " + result.getPlanetName() + " | Found Owner ID: " + result.getOwnerId() + "\n");
    }

    // Testing selectAllPlanets()
    @Test
    public void selectAllPlanetsTest(){
        Mockito.when(planetDao.readAllPlanets()).thenReturn(expectedPlanetList);
        List<Planet> result = planetService.selectAllPlanets();
        Assert.assertEquals(expectedPlanetList, result);
        System.out.println("Test Passed, Found These Planets:");
        for (Planet element : result){
            System.out.println("Found ID: " + element.getPlanetId() + " | Found Planet Name: " + element.getPlanetName() + " | Found Owner ID: " + element.getOwnerId());
        }
        System.out.println("\n");
    }

    // Testing selectByOwner() Using Positive Data (Owner ID)
    @Test
    public void selectByOwnerTest(){
        Mockito.when(planetDao.readPlanetsByOwner(knownUserID)).thenReturn(expectedPlanetList);
        List<Planet> result = planetService.selectByOwner(positivePlanet.getOwnerId());
        Assert.assertEquals(expectedPlanetList, result);
        System.out.println("Test Passed, Found These Planets:");
        for (Planet element : result){
            System.out.println("Found ID: " + element.getPlanetId() + " | Found Planet Name: " + element.getPlanetName() + " | Found Owner ID: " + element.getOwnerId());
        }
        System.out.println("\n");
    }


}
