package com.revature.repository.positive;




import com.revature.planetarium.entities.Moon;
import com.revature.repository.parent.MoonDaoTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class MoonDaoPositiveTest extends MoonDaoTest {
    private Moon positiveMoon;
    private String PositiveMoonName;
    //private int positiveOwnerID;
  //  private img postiveimageData;


    @Before
    public void positiveSetup(){
        positiveMoon = new Moon(0, "Sam Wise_22-",1);

    }

    @Test
    public void CreateMoonPositiveTest(){
        Optional<Moon> response = moonDao.createMoon(positiveMoon);
        Assert.assertTrue((response.isPresent()));
        Assert.assertNotEquals(0,response.get().getMoonId());
    }




}
