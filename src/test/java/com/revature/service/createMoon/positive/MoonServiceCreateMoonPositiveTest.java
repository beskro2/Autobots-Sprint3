package com.revature.service.createMoon.positive;

import com.revature.planetarium.entities.Moon;

import com.revature.service.createMoon.parent.MoonServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Base64;

import java.util.Optional;

public class MoonServiceCreateMoonPositiveTest extends MoonServiceTest {

    private Moon positiveMoon;
    private Optional<Moon> mockOptional;
    private Moon mockReturnedMoon;

    private Moon positiveMoon2;
    private Optional<Moon> mockOptional2;
    private Moon mockReturnedMoon2;

    private Moon positiveMoon3;
    private Optional<Moon> mockOptional3;
    private Moon mockReturnedMoon3;

    private Moon positiveMoon4;
    private Optional<Moon> mockOptional4;
    private Moon mockReturnedMoon4;


    @Before public void positiveCreateMoonSetUp(){
        positiveMoon = new Moon(0,"Sam Wise_22-",1);
        mockReturnedMoon = new Moon(3,"Sam Wise_22-",1);
        mockOptional = Optional.of(mockReturnedMoon);
//--------------------------------------------------------------------------------------------------------
        positiveMoon2 = new Moon(0,"90Champion",1);
        mockReturnedMoon2 = new Moon(4,"90Champion",1);
        mockOptional2 = Optional.of(mockReturnedMoon2);
//--------------------------------------------------------------------------------------------------------

        positiveMoon3 = new Moon(0,"Sam Wise_22-",1);
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get("src/test/resources/test_images/Moon-8.jpeg")); // Read the file into a byte array
            String imagedata64 = Base64.getEncoder().encodeToString(imageBytes);
            positiveMoon3.setImageData(imagedata64);
        }catch (IOException e){
            e.printStackTrace();
        }
        mockReturnedMoon3 = new Moon(5,"Sam Wise_22-",1);
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get("src/test/resources/test_images/Moon-8.jpeg")); // Read the file into a byte array
            String imagedata64 = Base64.getEncoder().encodeToString(imageBytes);
            mockReturnedMoon3.setImageData(imagedata64);
        }catch (IOException e){
            e.printStackTrace();
        }
        mockOptional3 = Optional.of(mockReturnedMoon3);
//--------------------------------------------------------------------------------------------------------

        positiveMoon4 = new Moon(0,"Sam Wise_22-",1);
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get("src/test/resources/Celestial-Images/planet-5b.png")); // Read the file into a byte array
            String imagedata64 = Base64.getEncoder().encodeToString(imageBytes);
            positiveMoon4.setImageData(imagedata64);
        }catch (IOException e){
            e.printStackTrace();
        }
        mockReturnedMoon4 = new Moon(6,"Sam Wise_22-",1);
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get("src/test/resources/Celestial-Images/planet-5b.png")); // Read the file into a byte array
            String imagedata64 = Base64.getEncoder().encodeToString(imageBytes);
            mockReturnedMoon4.setImageData(imagedata64);
        }catch (IOException e){
            e.printStackTrace();
        }
        mockOptional4 = Optional.of(mockReturnedMoon4);
    }



    @Test
    public void CreateMoonPositiveTest(){
        Mockito.when(moonDao.createMoon(positiveMoon)).thenReturn(mockOptional);
        Moon result = moonService.createMoon(positiveMoon);
        Assert.assertEquals(true,result);
    }

    @Test
    public void CreateMoonPositiveTest2(){
        Mockito.when(moonDao.createMoon(positiveMoon2)).thenReturn(mockOptional2);
        Moon result = moonService.createMoon(positiveMoon2);
        Assert.assertEquals(true,result);
    }
    @Test
    public void CreateMoonPositiveTest3(){
        Mockito.when(moonDao.createMoon(positiveMoon3)).thenReturn(mockOptional3);
        Moon result = moonService.createMoon(positiveMoon3);
        Assert.assertEquals(true,result);
    }
    @Test
    public void CreateMoonPositiveTest4(){
        Mockito.when(moonDao.createMoon(positiveMoon4)).thenReturn(mockOptional4);
        Moon result = moonService.createMoon(positiveMoon4);
        Assert.assertEquals(true,result);
    }











}
