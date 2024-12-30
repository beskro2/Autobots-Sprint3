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

public class DeleteMoon {

    private WebDriver driver;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    public DeleteMoon(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void insertValidMoonName(){
        deleteInput.sendKeys("Luna");
    }

    public int getNumberOfCelestialRows(){
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"),4));
        List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
        return tableRows.size()-1;
    }

    public void insertInvalidMoonName(String planet){
        deleteInput.sendKeys(planet);
    }
}
