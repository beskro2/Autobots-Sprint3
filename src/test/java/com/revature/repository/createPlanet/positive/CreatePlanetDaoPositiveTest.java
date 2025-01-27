package com.revature.repository.createPlanet.positive;

import com.revature.planetarium.entities.Planet;
import com.revature.repository.createPlanet.parent.CreatePlanetDaoTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import  static org.junit.runners.Parameterized.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Base64;

@RunWith(Parameterized.class)
public class CreatePlanetDaoPositiveTest extends CreatePlanetDaoTest {

    private Planet positivePlanet;

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
                    {"Little Earth",1, ""},
                    {"Treader  -2_2", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_1.jpg"))},
                    {"90Aries",1,Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_1.jpg"))},
                    {"Molly_22", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/good_filetype_2.png"))}
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //src/test/resources/Celestial-Images/planet-1.jpg

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
    }

    @Test
    public void createPlanetDaoPositiveTest(){
        System.out.println("This is the planet name: " + positivePlanet.getPlanetName());
        Optional<Planet> result = planetDao.createPlanet(positivePlanet);
        Assert.assertTrue(result.isPresent());
        Assert.assertNotEquals(0,result.get().getPlanetId());
    }

}
