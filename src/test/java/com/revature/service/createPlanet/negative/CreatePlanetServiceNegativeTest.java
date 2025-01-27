package com.revature.service.createPlanet.negative;

import com.revature.planetarium.entities.Planet;
import com.revature.planetarium.exceptions.PlanetFail;
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
public class CreatePlanetServiceNegativeTest extends CreatePlanetServiceTest {

    private Planet negativePlanet;
    private Planet mockReturnedPlanet;
    private String negativePlanetName;
    private Optional<Planet> mockOptionalEmpty;
    private Optional<Planet> mockOptional;

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
                    {"Little Planet", 1,Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/bad_filetype.gif")) , "Invalid file type"},
                    {"Earth",1,"","Invalid planet name"}
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

        mockReturnedPlanet = new Planet();
        mockReturnedPlanet.setPlanetName("Earth");
        mockReturnedPlanet.setOwnerId(1);
        mockReturnedPlanet.setImageData(imageData);
        mockReturnedPlanet.setPlanetId(0);
        mockOptionalEmpty = Optional.empty();

        //This is used to mock what happens when negative data is being passed in the dao
        mockOptional = Optional.of(mockReturnedPlanet);

        negativePlanetName = "Mars";
    }


    public static byte[] convertImgToByteArray(String filePath) throws IOException {
        byte[] imageBytes = Files.readAllBytes(Paths.get(filePath));
        return imageBytes;
    }

    @Test
    public void createPlanetDaoNegativeTest(){
        System.out.println("This is the planet name: " + negativePlanet.getPlanetName());
        //This will have the optional variable be not empty so that first check will fail
        Mockito.when(planetDao.readPlanet(mockReturnedPlanet.getPlanetName())).thenReturn(mockOptional);

        //This will have the optional variable be empty so that second check will fail
        Mockito.when(planetDao.createPlanet(mockReturnedPlanet)).thenReturn(mockOptionalEmpty);
        PlanetFail exception = Assert.assertThrows(PlanetFail.class, ()-> {planetService.createPlanet(negativePlanet);});
        Assert.assertEquals(expectedMessage, exception.getMessage());
    }

}
