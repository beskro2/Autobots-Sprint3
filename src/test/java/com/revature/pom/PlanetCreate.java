package com.revature.pom;

import com.revature.TestMain;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        switch (filetype) {
            case "JPG":
                planetImageInput.sendKeys("C:\\Users\\Saumya Puthenveettil\\Desktop\\Revature\\Training\\project1_saumya\\Planetarium & Setup\\db-setup\\src\\test\\resources\\Celestial-Images\\planet-5.jpg");
                //C:\\Users\\xien6\\Documents\\GitHub\\Planetarium_Project_PEP\\src\\test\\resources\\test_images\\good_filetype_2.png"
                break;
            case "PNG":
                planetImageInput.sendKeys("C:\\Users\\Saumya Puthenveettil\\Desktop\\Revature\\Training\\project1_saumya\\Planetarium & Setup\\db-setup\\src\\test\\resources\\Celestial-Images\\planet-5b.png");
                break;
            case "TIFF":
                planetImageInput.sendKeys("C:\\Users\\Saumya Puthenveettil\\Desktop\\Revature\\Training\\project1_saumya\\Planetarium & Setup\\db-setup\\src\\test\\resources\\Celestial-Images\\planet-5a.tiff");
                break;

            case "NONE":

                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void submitPlanet(){
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }


    public int getNumberOfCelestialRows(int expectedRows){
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"),expectedRows+1));
        List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
        return tableRows.size()-1;
    }


}
