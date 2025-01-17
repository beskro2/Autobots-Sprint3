package com.revature.service.deleteMoon.positive;

import com.revature.service.createMoon.parent.MoonServiceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MoonServiceDeleteMoonPositiveTest extends MoonServiceTest {

private String moonName;

@Before
public void positiveDeleteMoonSetUp(){
    moonName="Luna";

}

@Test
    public void DeleteMoon(){

    Mockito.when(moonDao.deleteMoon(moonName)).thenReturn(true);
    String result = moonService.deleteMoon(moonName);
    Assert.assertEquals(true,result);
}

}
