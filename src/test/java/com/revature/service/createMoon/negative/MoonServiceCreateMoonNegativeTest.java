package com.revature.service.createMoon.negative;


import com.revature.planetarium.entities.Moon;
import com.revature.planetarium.exceptions.MoonFail;
import com.revature.service.createMoon.parent.MoonServiceTest;
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


import static org.junit.runners.Parameterized.*;
@RunWith(Parameterized.class)
public class MoonServiceCreateMoonNegativeTest extends MoonServiceTest {

    public Moon negativeMoon;
    private Moon mockreturnedMoon;
    private Optional<Moon> mockOptional;

    @Parameter
    public int userId;

    @Parameter(1)
    public String moonName;
    @Parameter(2)
    public int planetId;
    @Parameter(3)
    public String imageData;
    @Parameter(4)
    public String expectedExeptionMessage;


    @Parameters
    public static Collection<Object> inputs() {

        try {
            return Arrays.asList(new Object[][]{
                    {0, "gandalffrodosamlegolisegimliborimirearigorn", 1, "", "Invalid moon name"},
                    {0, "", 1, "", "Invalid moon name"},
                    {0, "Saurumon#@!", 1, "", "Invalid moon name"},
                    {0, "Luna", 1, "", "Invalid moon name"},//repeat
                    {0, "", 0, "", "Invalid planet ID"},
                    {0, "Sam Wise_24-", "a", "", "Invalid planet ID"},
                    {0, "Sam Wise_23-", 2147000000, "", "Invalid planet ID"},
                    {0, "Sam Wise_25-", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/Moon-6.webp")), "Invalid file type"}, //.webp
                    {0, "Sam Wise_26-", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/Celestial-Images/planet-5a.tiff")), "Invalid file type"},//,tiff
                    {0, "Sam Wise_27-", 1, Base64.getEncoder().encodeToString(convertImgToByteArray("src/test/resources/test_images/Moon-7.gif")), "Invalid file type"}, //gif

            });
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] convertImgToByteArray(String filePath) throws IOException {
        byte[] imageBytes = Files.readAllBytes(Paths.get(filePath));
        return imageBytes;
    }

    @Before
    public void negativeSetup() {
        negativeMoon = new Moon(userId, moonName, planetId);
        negativeMoon.setImageData(imageData);
        mockOptional = Optional.empty();
        mockreturnedMoon= new Moon(0,"Luna",1);
        mockOptional = Optional.of(mockreturnedMoon);

    }

    @Test
    public void CreateMoonNegativeTest() {
        Mockito.when(moonDao.createMoon(negativeMoon)).thenReturn(Optional.empty());
        Mockito.when(moonDao.readMoon(mockreturnedMoon.getMoonName())).thenReturn(mockOptional);
        MoonFail moonfail = Assert.assertThrows(MoonFail.class, () -> {
            moonService.createMoon(negativeMoon);
        });
        Assert.assertEquals(expectedExeptionMessage, moonfail.getMessage());

    }
}
