package com.revature.steps;

import com.revature.TestMain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Class Contains Steps Universally Used by Two or More Steps

public class UniversalSteps {

    @Given("that the user is logged in and is on the home page")
    public void that_the_user_is_logged_in_and_is_on_the_home_page() {
        TestMain.universal.goToLoginPage();
        TestMain.login.knownGoodLogin();
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Home", TestMain.driver.getTitle());
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestMain.universal.goToLoginPage();
        Assert.assertEquals("Planetarium Login", TestMain.driver.getTitle());
    }

    @Then("the user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String string) {
        Assert.assertEquals(string, TestMain.universal.alertHandler());
    }

}
