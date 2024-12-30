package com.revature.pom;

import com.revature.TestMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DeletePlanet {
    private WebDriver driver;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    public DeletePlanet(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void insertValidPlanetName(){
        deleteInput.sendKeys("Earth");
    }

    public void pressDelete(){
        deleteButton.click();
    }

    public int getNumberOfCelestialRows(){
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"),3));
        List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
        return tableRows.size()-1;
    }

    public void insertInvalidPlanetName(String planet){
        deleteInput.sendKeys(planet);
    }
}
