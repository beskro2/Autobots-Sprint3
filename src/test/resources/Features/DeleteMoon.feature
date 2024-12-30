Feature: Moon Deletion
  As a user I want to remove moons from the Planetarium so I can correct my findings

  Background: Moon Deletion Starting Actions
    Given that the user is logged in and is on the home page
    And the user deletes a moon

  ## Happy Path
  Scenario: The user should be able to delete an existing moon
    When the user inputs a valid moon name
    When the user presses delete
    Then the user is redirected to the home page
    And the data reflected has been refreshed to include the removed moon(s)

  ## Sad Path
  Scenario Outline: The user should not be able to delete a non-existing moon
    When the user inputs a invalid moon name "<Moon Name>"
    When the user presses delete
    Then the user should get a browser alert saying "Invalid moon name"
    And the user should be redirected to the home page

    Examples:
      |Moon Name    |
      |Random_Moon  |
      |DoesntExist12|
      |TestRemove!!!|