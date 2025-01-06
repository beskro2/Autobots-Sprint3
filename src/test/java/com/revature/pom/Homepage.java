package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goDirectlyToHomepage() {
        driver.get("http://localhost:8080/planetarium");
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

}
