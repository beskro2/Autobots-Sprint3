package com.revature.service.homepage.positive;

import com.revature.planetarium.entities.Moon;
import com.revature.service.homepage.parent.HomepageServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MoonViewServicePositiveTest extends HomepageServiceTest {

    private int knownPlanetID1;
    private int knownPlanetID2;
    private Moon positiveMoon;
    private Optional<Moon> readMoonOptional;
    private Moon expectedPositiveMoon;
    private Moon positiveMoon2;
    private Optional<Moon> readMoonOptional2;
    private Moon expectedPositiveMoon2;
    private List<Moon> expectedMoonList1; // Total List of Moons
    private List<Moon> expectedMoonList2; // Expected Result for checking Planet ID 1
    private List<Moon> expectedMoonList3; // Expected Result for checking Planet ID 2

    // Initialize Local Variables
    @Before
    public void positiveSetup(){
        knownPlanetID1 = 1;
        knownPlanetID2 = 2;
        positiveMoon = new Moon();
        positiveMoon.setMoonName("Luna");
        positiveMoon.setMoonId(1);
        positiveMoon.setOwnerId(knownPlanetID1);
        readMoonOptional = Optional.of(positiveMoon);
        expectedPositiveMoon = new Moon();
        expectedPositiveMoon.setMoonName("Luna");
        expectedPositiveMoon.setMoonId(1);
        expectedPositiveMoon.setOwnerId(knownPlanetID1);
        positiveMoon2 = new Moon();
        positiveMoon2.setMoonName("Titan");
        positiveMoon2.setMoonId(2);
        positiveMoon2.setOwnerId(knownPlanetID2);
        readMoonOptional2 = Optional.of(positiveMoon2);
        expectedPositiveMoon2 = new Moon();
        expectedPositiveMoon2.setMoonName("Titan");
        expectedPositiveMoon2.setMoonId(2);
        expectedPositiveMoon2.setOwnerId(knownPlanetID2);
        expectedMoonList1 = new ArrayList<>();
        expectedMoonList1.add(positiveMoon);
        expectedMoonList1.add(positiveMoon2);
        expectedMoonList2 = new ArrayList<>();
        expectedMoonList2.add(positiveMoon);
        expectedMoonList3 = new ArrayList<>();
        expectedMoonList3.add(positiveMoon2);
    }

    // Testing selectMoon() with Negative Data (ID)
    @Ignore("NEEDED TO MEET MVP REQUIREMENTS")
    @Test
    public void selectMoonPositiveTestID(){
        System.out.println("Testing Pre-Existing Moon Luna by ID:");
        Mockito.when(moonDao.readMoon(positiveMoon.getMoonId())).thenReturn(readMoonOptional);
        Moon result = moonService.selectMoon(positiveMoon.getMoonId());
        Assert.assertEquals(expectedPositiveMoon, result);
        System.out.println("Test Passed | Found ID: " + result.getMoonId() + " | Found Moon Name: " + result.getMoonName() + " | Found Planet ID: " + result.getOwnerId());
        System.out.println("Testing Pre-Existing Moon Titan by ID:");
        Mockito.when(moonDao.readMoon(positiveMoon2.getMoonId())).thenReturn(readMoonOptional2);
        result = moonService.selectMoon(positiveMoon2.getMoonId());
        Assert.assertEquals(expectedPositiveMoon2, result);
        System.out.println("Test Passed | Found ID: " + result.getMoonId() + " | Found Moon Name: " + result.getMoonName() + " | Found Planet ID: " + result.getOwnerId() + "\n");
    }

    // Testing selectMoon() with Negative Data (Planet Name)
    @Ignore("NOT NEEDED TO MEET MVP REQUIREMENTS")
    @Test
    public void selectMoonPositiveTestName(){
        System.out.println("Testing Pre-Existing Moon Luna by Name:");
        Mockito.when(moonDao.readMoon(positiveMoon.getMoonName())).thenReturn(readMoonOptional);
        Moon result = moonService.selectMoon(positiveMoon.getMoonName());
        Assert.assertEquals(expectedPositiveMoon, result);
        System.out.println("Test Passed | Found ID: " + result.getMoonId() + " | Found Moon Name: " + result.getMoonName() + " | Found Planet ID: " + result.getOwnerId());
        System.out.println("Testing Pre-Existing Moon Titan by Name:");
        Mockito.when(moonDao.readMoon(positiveMoon2.getMoonName())).thenReturn(readMoonOptional2);
        result = moonService.selectMoon(positiveMoon2.getMoonName());
        Assert.assertEquals(expectedPositiveMoon2, result);
        System.out.println("Test Passed | Found ID: " + result.getMoonId() + " | Found Moon Name: " + result.getMoonName() + " | Found Planet ID: " + result.getOwnerId() + "\n");
    }

    // Testing selectAllMoons()
    @Ignore("NOT NEEDED TO MEET MVP REQUIREMENTS")
    @Test
    public void selectAllMoonsTest(){
        Mockito.when(moonDao.readAllMoons()).thenReturn(expectedMoonList1);
        List<Moon> result = moonService.selectAllMoons();
        Assert.assertEquals(expectedMoonList1, result);
        System.out.println("Test Passed, Found These Moons:");
        for (Moon element : result){
            System.out.println("Found ID: " + element.getMoonId() + " | Found Moon Name: " + element.getMoonName() + " | Found Planet ID: " + element.getOwnerId());
        }
        System.out.println("\n");
    }

    // Testing selectByPlanet() Using Positive Data (Planet ID: Earth)
    @Test
    public void selectByPlanetTestEarth(){
        Mockito.when(moonDao.readMoonsByPlanet(knownPlanetID1)).thenReturn(expectedMoonList2);
        List<Moon> result = moonService.selectByPlanet(knownPlanetID1);
        Assert.assertEquals(expectedMoonList2, result);
        System.out.println("Test Passed, Found These Moons:");
        for (Moon element : result){
            System.out.println("Found ID: " + element.getMoonId() + " | Found Moon Name: " + element.getMoonName() + " | Found Planet ID: " + element.getOwnerId());
        }
        System.out.println("\n");
    }

    // Testing selectByPlanet() Using Positive Data (Planet ID: Mars)
    @Test
    public void selectByPlanetTestMars(){
        Mockito.when(moonDao.readMoonsByPlanet(knownPlanetID2)).thenReturn(expectedMoonList3);
        List<Moon> result = moonService.selectByPlanet(knownPlanetID2);
        Assert.assertEquals(expectedMoonList3, result);
        System.out.println("Test Passed, Found These Moons:");
        for (Moon element : result){
            System.out.println("Found ID: " + element.getMoonId() + " | Found Moon Name: " + element.getMoonName() + " | Found Planet ID: " + element.getOwnerId());
        }
        System.out.println("\n");
    }

}
