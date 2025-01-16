package com.revature.service.negative;
import com.revature.pom.*;

import org.junit.Assert;
import org.junit.Test;


import static com.revature.TestMain.driver;
import static com.revature.TestMain.*;


import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Unit_RegisterDuplicateUsername {

    @Test
    public void Service_RegisterDuplicateUsername() {

                driver = new ChromeDriver();
                driver.get("http://localhost:8080/");

                registration = new Registration(driver);
                registration.clickRegisterLink();
                registration.insertUsername("Batman");
                registration.insertPassword("Krypton-was_2000");
                registration.accountCreation();

                 universal = new Universal(driver);
                 String text = "defect";
                 try {
                     text = universal.alertHandler();
                     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                 }
                 catch (TimeoutException e) {
                     Assert.assertEquals("Invalid Username", text);
                 }




        }

}
