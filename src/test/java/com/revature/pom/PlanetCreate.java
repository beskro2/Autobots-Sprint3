package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PlanetCreate {

    private WebDriver driver;

    @FindBy(id = "planetNameInput")
    private WebElement planetInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(xpath = "//button[@class='submit-button']")
    private WebElement submitButton;

    public PlanetCreate(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectPlanet(){
        WebElement selectElement = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElement);
        select.selectByIndex(1);
    }

    public void insertPlanetName(String planet){
        planetInput.sendKeys(planet);
    }

    //Change according to file path
    public void uploadPlanetImg(String filetype){
        if (filetype.equals("JPG")){
            planetImageInput.sendKeys("C:\\Users\\xien6\\Documents\\GitHub\\Planetarium_Project_PEP\\src\\test\\resources\\test_images\\good_filetype_1.jpg");
        }else if (filetype.equals("PNG")){
            planetImageInput.sendKeys("C:\\Users\\xien6\\Documents\\GitHub\\Planetarium_Project_PEP\\src\\test\\resources\\test_images\\good_filetype_2.png");
        }else if (filetype.equals("GIF")){
            planetImageInput.sendKeys("C:\\Users\\xien6\\Documents\\GitHub\\Planetarium_Project_PEP\\src\\test\\resources\\test_images\\bad_filetype.gif");
        }
    }

    public void submitPlanet(){
        submitButton.click();
    }

}
