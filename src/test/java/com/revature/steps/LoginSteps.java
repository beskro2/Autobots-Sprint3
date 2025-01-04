package com.revature.steps;

import com.revature.TestMain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import static com.revature.TestMain.driver;

public class LoginSteps {

    @Given("the user is on the login page to login")
    public void the_user_is_on_the_login_page_to_login() {
        TestMain.login.goToLoginPageToLogin();
        Assert.assertEquals("Planetarium Login", driver.getTitle());
    }

    @When("the user provides password {string}")
    public void the_user_provides_password(String password) {
        TestMain.login.insertPassword(password);
    }

    @Then("the password will never be visible in plain text")
    public void the_password_will_never_be_visible_in_plain_text() {
        // Write code here that turns the phrase above into concrete actions

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path screenshotDestination = Paths.get("src/test/resources/screenshot/screentemp.jpeg");
        try {
            Files.copy(scrFile.toPath(),screenshotDestination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("See Screenshot");

    }

    // Happy Path
    @When("the user provides a valid login username")
    public void the_user_provides_a_valid_login_username() {
        TestMain.login.insertUsername("Batman");
    }

    @When("the user provides a valid login password")
    public void the_user_provides_a_valid_login_password() {
        TestMain.login.insertPassword("Iamthenight1939");
    }

    @When("the user submits the login credentials")
    public void the_user_submits_the_login_credentials() {
        TestMain.login.loginAttempt();
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_register_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Home", driver.getTitle());
    }

    // Sad Path
    @When("the user provides an invalid login username {string}")
    public void the_user_provides_a_username(String string) {
        TestMain.login.insertUsername(string);
    }

    @When("the user provides an invalid login password {string}")
    public void the_user_provides_a_password(String string) {
        TestMain.login.insertPassword(string);
    }

    @Then("the user should get a login browser alert saying {string}")
    public void the_user_should_get_a_login_browser_alert_saying(String string) {
        String result = TestMain.login.alertHandler();
        //System.out.println(result);
        Assert.assertEquals(string, result);
    }

    @Then("the user should be redirected to the login page to login")
    public void the_user_should_be_redirected_to_the_login_page_to_login() {
        Assert.assertEquals("Planetarium Login", driver.getTitle());
    }

}
