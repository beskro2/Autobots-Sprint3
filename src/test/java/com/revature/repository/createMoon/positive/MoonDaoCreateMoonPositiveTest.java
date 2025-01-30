package com.revature.repository.createMoon.positive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import com.revature.planetarium.entities.Moon;
import com.revature.repository.createMoon.parent.MoonDaoTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MoonDaoCreateMoonPositiveTest extends MoonDaoTest {


    @Parameter
    public int moonId;

    @Parameter(1)
    public String moonName;

    @Parameter(2)
    public int planetID;

    @Parameter(3)
    public String imageData;


    //test png should failbut passes?
    @Parameters
    public static Collection<Object> inputs() {
        try {
            return Arrays.asList(new Object[][]{
                    {0, "Sam Wise_22-", 1, ""},
                    {0, "90Champion", 2, ""},
                    {0, "Sam Wise_22-", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/Moon-8.jpeg"))}, //jpeg
                    {0, "Sam Wise_22-", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/Celestial-Images/planet-5b.png"))}, //png
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

    @Test
    public void CreateMoonPositiveTest(){
    Moon positiveMoon = new Moon(moonId,moonName,planetID,"test");
    positiveMoon.setImageData(imageData);
    Optional<Moon> response = moonDao.createMoon(positiveMoon);
    Assert.assertTrue((response.isPresent()));
    Assert.assertNotEquals(0,response.get().getMoonId());
}


    }


