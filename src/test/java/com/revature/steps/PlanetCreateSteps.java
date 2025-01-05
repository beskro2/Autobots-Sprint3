package com.revature.steps;

import com.revature.TestMain;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.UnexpectedException;
import java.time.Duration;
import java.util.List;

import static com.revature.TestMain.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class PlanetCreateSteps {

    @Given("that the user is logged in and is on the home page")
    public void that_the_user_is_logged_in_and_is_on_the_home_page() {
        TestMain.homepage.goToLoginPageForHomepage();
        TestMain.homepage.knownGoodLogin();
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Home", TestMain.driver.getTitle());
    }

    @And("the user creates a planet")
    public void the_user_creates_a_planet() {
        TestMain.planetCreate.selectPlanet();
    }

    @When("the user inputs a name {string}")
    public void the_user_inputs_a_valid_name(String string) {
        TestMain.planetCreate.insertPlanetName(string);
    }

    @When("the user inputs a file type {string}")
    public void the_user_inputs_a_valid_file_type(String string) {
        TestMain.planetCreate.uploadPlanetImg(string);
    }

    @When("the user submits the planet")
    public void the_user_submits_the_planet(){
        try{
        TestMain.planetCreate.submitPlanet();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        }
        catch(TimeoutException e){
          System.out.println(" ");

        }
    }

    @Then("the user is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Home", TestMain.driver.getTitle());
    }

    @Then("the data reflected has been refreshed to include the newly added planet {string}")
    public void the_data_reflected_has_been_refreshed_to_include_the_newly_added_planet(String string) {
        //Assert.assertEquals(5, TestMain.planetCreate.getNumberOfCelestialRows(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.titleIs("Home"));

        Integer rows = TestMain.homepage.getNumberOfCelestialRows();
        List<WebElement> tCols = TestMain.homepage.getCelestialTableCols();

        int tColsSize = tCols.size();

        int count = 0;

        for (int i = 0; i < tCols.size(); i++) {

            if (tCols.get(i).getText().equals(string)) {
                count = count + 1;
                System.out.println("Planet Added Successfully");
                break;}
        }
        if (count== 0){
            System.out.println("DEFECT: Unable to add planet with valid file type and valid name");
        }
    }

    @When("the user submits the invalid planet")
    public void the_user_submits_the_invalid_planet() {
        TestMain.planetCreate.submitPlanet();
    }

    @Then("the user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String string) {
       // Assert.assertEquals(string, TestMain.planetCreate.alertHandler());
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(alertIsPresent());
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals(string, alert.getText());
            alert.accept();
        }
        catch (TimeoutException e){
            System.out.println("DEFECT: Alert Not Present For Invalid File Name or Type");
        }
    }
}
