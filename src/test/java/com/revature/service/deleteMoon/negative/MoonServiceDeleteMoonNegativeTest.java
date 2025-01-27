package com.revature.service.deleteMoon.negative;

import com.revature.planetarium.exceptions.MoonFail;
import com.revature.service.createMoon.parent.MoonServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MoonServiceDeleteMoonNegativeTest extends MoonServiceTest {

    @Parameter
    public String moonName;


    @Parameters
    public static Collection<String> inputs(){
        return Arrays.asList(new String[]{
             "",
            "Saurumon#@!",
            "moon Not in the db"
        });
    }

 @Test
    public void DeleteMoonNegativeTest(){
        Mockito.when(moonDao.deleteMoon(moonName)).thenReturn(false);
        MoonFail moonfail = Assert.assertThrows(MoonFail.class, () -> {
            moonService.deleteMoon(moonName);
        });
        Assert.assertEquals("Invalid moon name",moonfail.getMessage());
 }






}
