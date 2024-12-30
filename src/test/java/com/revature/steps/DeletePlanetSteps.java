package com.revature.steps;

import com.revature.TestMain;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class DeletePlanetSteps {

    @Given("the user deletes a planet")
    public void the_user_deletes_a_planet() {
        TestMain.planetCreate.selectPlanet();
    }

    @When("the user inputs a valid planet name")
    public void the_user_inputs_a_valid_name() {
        TestMain.deletePlanet.insertValidPlanetName();
    }

    @When("the user presses delete")
    public void the_user_presses_delete() {
        TestMain.deletePlanet.pressDelete();
    }

    @Then("the data reflected has been refreshed to include the removed planet and corresponding moons")
    public void the_data_reflected_has_been_refreshed_to_include_the_removed_planet_and_corresponding_moons() {
        Assert.assertEquals(2, TestMain.deletePlanet.getNumberOfCelestialRows());
    }

    @When("the user inputs a invalid planet name {string}")
    public void the_user_inputs_a_invalid_name(String string) {
        TestMain.deletePlanet.insertInvalidPlanetName(string);
    }

}
