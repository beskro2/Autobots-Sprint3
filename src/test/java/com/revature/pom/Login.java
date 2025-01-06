package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void knownGoodLogin(){
        userInput.sendKeys("Batman");
        passInput.sendKeys("Iamthenight1939");
        loginButton.click();
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

}
