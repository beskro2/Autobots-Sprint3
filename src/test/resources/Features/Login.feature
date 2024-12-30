Feature: Login Feature
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

  Background: Login Starting Actions
    Given the user is on the login page to login

  ## Happy Path
  Scenario: Users can login to an account with valid credentials
    When the user provides a valid login username
    And the user provides a valid login password
    And the user submits the login credentials
    Then the user should be redirected to the home page

  ## Sad Path
  Scenario Outline: Users cannot login to an account with invalid credentials
    When the user provides an invalid login username "<username>"
    When the user provides an invalid login password "<password>"
    And the user submits the login credentials
    Then the user should get a login browser alert saying "<alert>"
    And the user should be redirected to the login page to login

  Examples:
    |username   | password              |alert                        |
    |Batman	    |Iamtheintern1939	    |Invalid credentials          |
    |Robin	    |Iamtheintern1939	    |Invalid credentials          |
    |Robin	    |Iamthenight1939	    |Invalid credentials          |