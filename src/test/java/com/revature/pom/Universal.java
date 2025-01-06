package com.revature.pom;

import com.revature.TestMain;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// Class contains functions universally used between two or more features.

public class Universal {

    WebDriver driver;

    public Universal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage(){
        driver.get("http://localhost:8080/");
    }

    public int getNumberOfCelestialRows(int expected){
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"),expected + 1));
        List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
        return tableRows.size()-1;
    }

    public String alertHandler(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }

}
