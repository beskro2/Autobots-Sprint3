package com.revature.repository.positive;

import com.revature.planetarium.repository.moon.MoonDao;
import com.revature.repository.parent.MoonDaoTest;
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
                "Earth",
                "Mars"
        });
        }

    @Test
    public void DeleteMoonPositiveTest(){
      Boolean result = moonDao.deleteMoon(moonName);
      Assert.assertEquals(false,result);
    }
}
