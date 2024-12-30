package com.revature.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement userInput;

    @FindBy(id = "passwordInput")
    private WebElement passInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPageToLogin(){
        driver.get("http://localhost:8080/");
    }

    public void insertUsername(String user){
        userInput.sendKeys(user);
    }

    public void insertPassword(String pass){
        passInput.sendKeys(pass);
    }

    public void loginAttempt(){
        loginButton.click();
    }

    //Logout incorporated into login handler
    public void logoutAttempt() {
        logoutButton.click();
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
