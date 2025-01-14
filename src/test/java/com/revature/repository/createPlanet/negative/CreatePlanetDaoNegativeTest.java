package com.revature.repository.createPlanet.negative;

import com.revature.planetarium.entities.Planet;
import com.revature.planetarium.exceptions.PlanetFail;
import com.revature.repository.createPlanet.parent.CreatePlanetDaoTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;

import  static org.junit.runners.Parameterized.*;


@RunWith(Parameterized.class)
public class CreatePlanetDaoNegativeTest extends CreatePlanetDaoTest {

    private Planet negativePlanet;

    @Parameter
    public String planetName;

    @Parameter(1)
    public int ownerId;

    @Parameter(2)
    public String imageData;

    @Parameter(3)
    public String expectedMessage;

    @Parameters
    public static Collection<Object> input(){
        try {
            return Arrays.asList(new Object[][]{
                    {"", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_1.jpg")), "Invalid planet name"},
                    {"Molly tess tobi toff garthog lord of unholy darkness", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_1.jpg")), "Invalid planet name"},
                    {"Molly $@#", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_1.jpg")), "Invalid planet name"},
                    {"Little Planet", 1,Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/bad_filetype.gif")) , "Invalid file type"}
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Before
    public void positiveSetup(){
        negativePlanet = new Planet();
        negativePlanet.setPlanetName(planetName);
        negativePlanet.setOwnerId(ownerId);
        negativePlanet.setImageData(imageData);
        negativePlanet.setPlanetId(0);
    }

    public static byte[] convertImgToByteArray(String filePath) throws IOException {
        byte[] imageBytes = Files.readAllBytes(Paths.get(filePath));
        return imageBytes;
    }

    @Test
    public void createPlanetDaoNegativeTest(){
        System.out.println("This is the planet name: " + negativePlanet.getPlanetName());
        PlanetFail exception = Assert.assertThrows(PlanetFail.class, ()-> {planetDao.createPlanet(negativePlanet);});
        Assert.assertEquals(expectedMessage, exception.getMessage());
    }


}
