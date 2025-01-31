package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MoonCreate {

    private WebDriver driver;

    @FindBy(id = "moonNameInput")
    private WebElement moonInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(xpath = "//button[@class='submit-button']")
    private WebElement submitButton;

    public MoonCreate(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectMoon(){
        WebElement selectElement = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElement);
        select.selectByIndex(0);
    }

    public void insertMoonName(String moon){
        moonInput.sendKeys(moon);
    }

    public void insertOrbitedPlanet(String planet){
        orbitedPlanetInput.sendKeys(planet);
    }

    public void submitMoon(){
        submitButton.click();
    }

    public void uploadMoonImg(String filetype){
        if (filetype.equals("JPG")){
            moonImageInput.sendKeys("C:\\Users\\xien6\\Documents\\GitHub\\Planetarium_Project_PEP\\src\\test\\resources\\test_images\\good_filetype_1.jpg");
        }else if (filetype.equals("PNG")){
            moonImageInput.sendKeys("C:\\Users\\xien6\\Documents\\GitHub\\Planetarium_Project_PEP\\src\\test\\resources\\test_images\\good_filetype_2.png");
        }else if (filetype.equals("GIF")){
            moonImageInput.sendKeys("C:\\Users\\xien6\\Documents\\GitHub\\Planetarium_Project_PEP\\src\\test\\resources\\test_images\\bad_filetype.gif");
        }
    }

}
