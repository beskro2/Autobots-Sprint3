package com.revature;

import com.revature.pom.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.steps",
        plugin = {"pretty", "html:src/test/resources/reports/html-report.html", "json:src/test/resources/reports/json-report.json"}
)
public class TestMain {
    public static WebDriver driver = null;
    public static Registration registration;
    public static Login login;
    public static Homepage homepage;
    public static PlanetCreate planetCreate;
    public static MoonCreate moonCreate;
    public static DeletePlanet deletePlanet;
    public static DeleteMoon deleteMoon;
    public static Universal universal;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        registration = new Registration(driver);
        login = new Login(driver);
        homepage = new Homepage(driver);
        planetCreate = new PlanetCreate(driver);
        moonCreate = new MoonCreate(driver);
        deletePlanet = new DeletePlanet(driver);
        deleteMoon = new DeleteMoon(driver);
        universal = new Universal(driver);
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}