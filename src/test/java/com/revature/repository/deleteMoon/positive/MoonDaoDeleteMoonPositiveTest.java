package com.revature.repository.deleteMoon.positive;

import com.revature.repository.createMoon.parent.MoonDaoTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MoonDaoDeleteMoonPositiveTest extends MoonDaoTest {

    @Parameter
    public String moonName;
    @Parameters
    public static Collection<String> inputs(){
        return Arrays.asList(new String[]{
                "Luna",
                "Titan"
        });
        }

    @Test
    public void DeleteMoonPositiveTest(){
      Boolean result = moonDao.deleteMoon(moonName);
      Assert.assertEquals(true,result);
    }
}
