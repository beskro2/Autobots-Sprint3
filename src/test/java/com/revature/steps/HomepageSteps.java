package com.revature.steps;

import com.revature.TestMain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomepageSteps {

    @Given("the user is logged in and on the homepage")
    public void the_user_is_logged_in_and_on_the_homepage() {
        TestMain.homepage.goToLoginPageForHomepage();
        TestMain.homepage.knownGoodLogin();
    }

    @Then("they should see their planets and moons")
    public void they_should_see_their_planets_and_moons() {
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Home", TestMain.driver.getTitle());
        Assert.assertEquals("Welcome to the Home Page Batman", TestMain.homepage.getHomePageGreeting());
        Assert.assertEquals(4, TestMain.homepage.getNumberOfCelestialRows());
    }

    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() {
        if (TestMain.driver.getTitle().equals("Home")){
            TestMain.login.logoutAttempt();
        }else{
            TestMain.homepage.goToLoginPageForHomepage();
        }
        WebDriverWait wait = new WebDriverWait(TestMain.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs("Planetarium Login"));
        Assert.assertEquals("Planetarium Login", TestMain.driver.getTitle());
    }

    @When("the user tries to directly access the homepage")
    public void the_user_tries_to_directly_access_the_homepage() {
        TestMain.homepage.goDirectlyToHomepage();
    }

    @Then("the user should be denied access")
    public void the_user_should_be_denied_access() {
        Assert.assertNotEquals("Home", TestMain.driver.getTitle());
    }
}
