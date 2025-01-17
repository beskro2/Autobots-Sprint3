package com.revature.repository.deleteMoon.negative;

import com.revature.planetarium.exceptions.MoonFail;
import com.revature.repository.createMoon.parent.MoonDaoTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MoonDaoDeleteMoonNegativeTest extends MoonDaoTest {


        @Parameter
        public String moonName;

        @Parameters
        public static Collection<String> inputs(){
            return Arrays.asList(new String[]{
                    "",
                    "notaplanet"
            });
        }

        @Test
        public void DeleteMoonNegativeTest(){
            MoonFail exception = Assert.assertThrows(MoonFail.class, ()->{moonDao.deleteMoon(moonName);});
            Assert.assertEquals("Invalid moon name", exception.getMessage());
        }
    }


