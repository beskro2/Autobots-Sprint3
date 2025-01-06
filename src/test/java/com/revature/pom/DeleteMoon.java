package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void insertInvalidMoonName(String planet){
        deleteInput.sendKeys(planet);
    }
}
