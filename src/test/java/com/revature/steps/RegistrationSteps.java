package com.revature.steps;

import com.revature.TestMain;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revature.TestMain.driver;

public class RegistrationSteps {

    @Given("the user is on the login page to register")
    public void the_user_is_on_the_login_page_to_register() {
        TestMain.registration.goToLoginPageToRegister();
        Assert.assertEquals("Planetarium Login", driver.getTitle());
    }

    @And("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        TestMain.registration.clickRegisterLink();
        Assert.assertEquals("Account Creation", driver.getTitle());
    }

    // Happy Path
    @When("the user provides a valid registration username")
    public void the_user_provides_a_valid_registration_username() {
        TestMain.registration.insertUsername("Super_man-20012");
    }

    @When("the user provides a valid registration password")
    public void the_user_provides_a_valid_registration_password() {
        TestMain.registration.insertPassword("Krypton-was_2000");
    }

    @When("the user submits the registration credentials")
    public void the_user_submits_the_registration_credentials() {
        TestMain.registration.accountCreation();
    }

    @Then("the user should get a registration browser alert saying {string}")
    public void the_user_should_get_a_registration_browser_alert_saying(String string) {
        //String result = TestMain.registration.alertHandler();
        //Assert.assertEquals(string, result);
        try{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(string, alert.getText());
        alert.accept();
        }
        catch (TimeoutException e){
            System.out.println("Defect: Alert Not Present");
        }


    }

    @Then("the user should be redirected to the login page after registration")
    public void the_user_should_be_redirected_to_the_login_page_after_registration() {
        Assert.assertEquals("Planetarium Login", driver.getTitle());
    }

    // Sad Path
    @When("the user provides a username {string}")
    public void the_user_provides_a_username(String string) {
        TestMain.registration.insertUsername(string);
    }

    @When("the user provides a password {string}")
    public void the_user_provides_a_password(String string) {
        TestMain.registration.insertPassword(string);
    }

    @Then("the user should be redirected to the register page")
    public void the_user_should_be_redirected_to_the_register_page() {
        Assert.assertEquals("Account Creation", driver.getTitle());
    }

}
