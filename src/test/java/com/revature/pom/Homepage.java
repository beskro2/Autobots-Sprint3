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

public class Homepage {
    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(id = "usernameInput")
    private WebElement userInput;

    @FindBy(id = "passwordInput")
    private WebElement passInput;

    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPageForHomepage(){
        driver.get("http://localhost:8080/");
    }

    public void goDirectlyToHomepage() {
        driver.get("http://localhost:8080/planetarium");
    }

    public void knownGoodLogin(){
        userInput.sendKeys("Batman");
        passInput.sendKeys("Iamthenight1939");
        loginButton.click();
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"),5));
        List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
        return tableRows.size()-1;
    }
}
