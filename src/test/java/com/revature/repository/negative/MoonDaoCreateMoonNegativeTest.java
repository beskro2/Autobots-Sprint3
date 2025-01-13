package com.revature.repository.negative;

import com.revature.planetarium.entities.Moon;
import com.revature.planetarium.exceptions.MoonFail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.revature.repository.parent.MoonDaoTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MoonDaoCreateMoonNegativeTest extends MoonDaoTest {

    @Parameter
    public int moonId;

    @Parameter(1)
    public String moonName;

    @Parameter(2)
    public int planetID;

    @Parameter(3)
    public String imageData;

    @Parameter(4)
    public String exceptionMessage;

    @Parameters
    public static Collection<Object> inputs(){
        return Arrays.asList(new Object[][]{
                {0,"gandalffrodosamlegolisegimliborimirearigorn",1,"","Invalid moon name"},
                {0,"",1,"","Invalid moon name"},
                {0,"Saurumon#@!",1,"","Invalid moon name"},
                {0,"Luna",1,"","Invalid moon name"},//repeat
                {0,"Sam Wise_22-",0,"","Invalid planet ID"},
                {0,"Sam Wise_22-","a","","Invalid planet ID"},
                {0,"Sam Wise_22-",2147000000,"","Invalid planet ID"},
                {0,"Sam Wise_22-",1,"src/test/resources/Celestial-Images/Moon-6.webp","Invalid file type"}, //.webp
                {0,"Sam Wise_22-",1,"src/test/resources/Celestial-Images/planet-5a.tiff","Invalid file type"} ,//,tiff
                {0,"Sam Wise_22-",1,"src/test/resources/Celestial-Images/Moon-7.gif","Invalid file type"}, //gif

        });
    }


    @Test
    public void CreateMoonNegativeTest(){
        Moon testMoon = new Moon(moonId,moonName,planetID);
        testMoon.setImageData(imageData);
        MoonFail exception = Assert.assertThrows(MoonFail.class, ()->{moonDao.createMoon(testMoon);});
        Assert.assertEquals(exceptionMessage, exception.getMessage());

    }
}