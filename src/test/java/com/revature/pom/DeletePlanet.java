package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void insertInvalidPlanetName(String planet){
        deleteInput.sendKeys(planet);
    }
}
