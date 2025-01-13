package com.revature.repository.positive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import com.revature.planetarium.entities.Moon;
import com.revature.repository.parent.MoonDaoTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MoonDaoPositiveTest extends MoonDaoTest {



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
    public static Collection<Object> inputs(){
        return Arrays.asList(new Object[][]{
                {0,"Sam Wise_22-",1,""},
                {0,"90Champion",2,""},
                {0,"Sam Wise_22-",1,"src/test/resources/Celestial-Images/Moon-8.jpeg"}, //jpeg
                {0,"Sam Wise_22-",1,"src/test/resources/Celestial-Images/planet-5b.png"}, //png
        });
    }

    @Test
    public void CreateMoonPositiveTest(){
        Moon positiveMoon = new Moon(moonId,moonName,planetID);
try{
    byte[] imageBytes = Files.readAllBytes(Paths.get(imageData)); // Read the file into a byte array
    String imagedata64 = Base64.getEncoder().encodeToString(imageBytes);    // Convert the byte array to Base64 string
    positiveMoon.setImageData(imagedata64);
    Optional<Moon> response = moonDao.createMoon(positiveMoon);
    Assert.assertTrue((response.isPresent()));
    Assert.assertNotEquals(0,response.get().getMoonId());
}
catch(IOException e){
    e.printStackTrace();
        }

    }

}
