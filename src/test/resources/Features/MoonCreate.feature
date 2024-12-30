Feature: Moon Creation
  As a user I want to add new moons to the Planetarium so I can update my findings

  Background: Moon Creation Starting Actions
    Given that the user is logged in and is on the home page
    And the user creates a moon

  ## Happy Path
  Scenario Outline: While logged in, the user is able to create a moon with valid inputs
    When the user inputs a moon name "<Moon Name>"
    When the user inputs a owning planet ID "<Planet ID>"
    When the user inputs a moon file type "<File Type>"
    When the user submits the moon
    Then the user is redirected to the home page
    And the data reflected has been refreshed to include the newly added moon

    Examples:
      |Moon Name                    |Planet ID | File Type          |
      |Moon_Prime-First 12	        |1         |NONE	            |
      |Moon_Prime-First 13	        |2         |NONE	            |
      |Moon_Prime-First 14	        |1         |JPG	                |
      |Moon_Prime-First 15	        |2         |JPG	                |
      |Moon_Prime-First 16          |1         |PNG	                |
      |Moon_Prime-First 17          |2         |PNG	                |

  ## Sad Path
  Scenario Outline: While logged in, the user is not able to create a moon with invalid inputs
    When the user inputs a moon name "<Moon Name>"
    When the user inputs a owning planet ID "<Planet ID>"
    When the user inputs a moon file type "<File Type>"
    When the user submits the moon
    Then the user should get a browser alert saying "<alert>"
    And the user is redirected to the home page

    Examples:
      |Moon Name                                                         |Planet ID | File Type             |alert                        |
      |Moon_Name_That_Is_Way_Too_Long_And_Breaks_Rules-123456789	     |1         |NONE	                |Invalid moon name            |
      |Invalid_$MOONName!!!!!!!!                                         |1         |NONE	                |Invalid moon name            |
      |Luna                                                              |1         |NONE	                |Invalid moon name            |
      |Moon_Prime-First 122                                              |1         |GIF	                |Invalid file type            |
      |Moon_Prime-First 122                                              |99        |NONE	                |Invalid planet id            |