package com.revature.steps;

import com.revature.TestMain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MoonCreateSteps {

    // Background
    @Given("the user creates a moon")
    public void the_user_creates_a_moon() {
        TestMain.moonCreate.selectMoon();
    }

    // Operates as both Happy and Sad Path. (Variable Input)
    @When("the user inputs a moon name {string}")
    public void the_user_inputs_a_moon_name(String string) {
        TestMain.moonCreate.insertMoonName(string);
    }

    @When("the user inputs a owning planet ID {string}")
    public void the_user_inputs_a_owning_planet_ID(String string) {
        TestMain.moonCreate.insertOrbitedPlanet(string);
    }

    @When("the user inputs a moon file type {string}")
    public void the_user_inputs_a_moon_file_type(String string) {
        TestMain.moonCreate.uploadMoonImg(string);
    }

    @When("the user submits the moon")
    public void the_user_submits_the_moon() {
        TestMain.moonCreate.submitMoon();
    }

    @Then("the data reflected has been refreshed to include the newly added moon")
    public void the_data_reflected_has_been_refreshed_to_include_the_newly_added_moon() {
        Assert.assertEquals(5, TestMain.universal.getNumberOfCelestialRows(5));
    }

}
