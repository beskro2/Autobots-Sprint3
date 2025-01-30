package com.revature.service.createPlanet.positive;

import com.revature.planetarium.entities.Planet;
import com.revature.service.createPlanet.parent.CreatePlanetServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Optional;

import  static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class CreatePlanetServicePositiveTest extends CreatePlanetServiceTest {
    private Planet positivePlanet;
    private Planet mockReturnedPlanet;
    private Optional<Planet> mockOptionalTrue;
    private Optional<Planet> mockOptionalEmpty;

    @Parameter
    public String planetName;

    @Parameter(1)
    public int ownerId;

    @Parameter(2)
    public String imageData;

    @Parameters
    public static Collection<Object> input(){
        try {
            return Arrays.asList(new Object[][]{
                    {"Treader  -2_2", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_1.jpg"))},
                    {"90Aries",1,Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_1.jpg"))},
                    {"Molly_22", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_2.png"))}
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] convertImgToByteArray(String filePath) throws IOException {
        byte[] imageBytes = Files.readAllBytes(Paths.get(filePath));
        return imageBytes;
    }

    @Before
    public void positiveSetup(){
        positivePlanet = new Planet();
        positivePlanet.setPlanetName(planetName);
        positivePlanet.setOwnerId(ownerId);
        positivePlanet.setImageData(imageData);
        positivePlanet.setPlanetId(0);

        mockReturnedPlanet = new Planet();
        mockReturnedPlanet.setPlanetName(planetName);
        mockReturnedPlanet.setOwnerId(1);
        mockReturnedPlanet.setImageData(imageData);
        mockReturnedPlanet.setPlanetId(0);

        mockOptionalTrue = Optional.of(mockReturnedPlanet);
        mockOptionalEmpty = Optional.empty();
    }

    @Test
    public void createPlanetDaoPositiveTest(){
        System.out.println("This is the planet name: " + positivePlanet.getPlanetName());
        Mockito.when(planetDao.readPlanet(positivePlanet.getPlanetName())).thenReturn(mockOptionalEmpty);
        Mockito.when(planetDao.createPlanet(positivePlanet)).thenReturn(mockOptionalTrue);
        boolean result = planetService.createPlanet(positivePlanet);
        //System.out.println("This is the planet name for result: " + result.getPlanetName());
        Assert.assertEquals(true, result);
        //System.out.println("This is the planetID for result: " + result.getPlanetId());
        //Assert.assertNotEquals(0,result.getPlanetId());
    }
}
