Feature: Planet Creation
  As a user I want to add new planets to the Planetarium so I can update my findings

  Background: Planet Creation Starting Actions
    Given that the user is logged in and is on the home page
    And the user creates a planet

  ## Happy Path
  Scenario Outline: While logged in, the user is able to create a planet with valid inputs
    When the user inputs a name "<Planet Name>"
    When the user inputs a file type "<File Type>"
    When the user submits the planet
    Then the user is redirected to the home page
    And the data reflected has been refreshed to include the newly added planet

    Examples:
      |Planet Name                  | File Type             |
      |Earth_Prime-First 12	        |NONE	                |
      |Earth_Prime-First 13	        |JPG	                |
      |Earth_Prime-First 14	        |PNG	                |

  ## Sad Path
  Scenario Outline: While logged in, the user is not able to create a planet with invalid inputs
    When the user inputs a name "<Planet Name>"
    When the user inputs a file type "<File Type>"
    When the user submits the planet
    Then the user should get a browser alert saying "<alert>"
    And the user is redirected to the home page

    Examples:
      |Planet Name                                                      | File Type             |alert                        |
      |Planet_Name_That_Is_Way_Too_Long_And_Breaks_Rules-123456789	    |NONE	                |Invalid planet name          |
      |Invalid_Name!!!!!!!!                                     	    |NONE	                |Invalid planet name          |
      |Earth                                                            |NONE	                |Invalid planet name          |
      |Earth_Prime-First 122                                            |GIF	                |Invalid file type            |