package com.revature.steps;

import com.revature.TestMain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteMoonSteps {

    // Background
    @Given("the user deletes a moon")
    public void the_user_deletes_a_moon() {
        TestMain.moonCreate.selectMoon();
    }

    // Happy Path
    @When("the user inputs a valid moon name")
    public void the_user_inputs_a_valid_moon_name() {
        TestMain.deleteMoon.insertValidMoonName();
    }

    @Then("the data reflected has been refreshed to include the removed moon\\(s)")
    public void the_data_reflected_has_been_refreshed_to_include_the_removed_moon_s() {
        Assert.assertEquals(3, TestMain.universal.getNumberOfCelestialRows(3));
    }

    // Sad Path
    @When("the user inputs a invalid moon name {string}")
    public void the_user_inputs_a_invalid_moon_name(String string) {
        TestMain.deleteMoon.insertInvalidMoonName(string);
    }
}
