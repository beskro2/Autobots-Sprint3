Feature: User Registration
  As a new user I want to open an account with the Planetarium so I can save my celestial findings

  Background: Registration Starting Actions
    Given the user is on the login page
    And the user clicks the register link

  ## Happy Path
  Scenario: Users can register a new account with valid credentials
    When the user provides a valid registration username
    And the user provides a valid registration password
    And the user submits the registration credentials
    Then the user should get a browser alert saying "Account created successfully"
    And the user should be redirected to the login page after registration

  ## Sad Path
  Scenario Outline: Users cannot register a new account with invalid credentials
    When the user provides an invalid registration username "<username>"
    When the user provides an invalid registration password "<password>"
    And the user submits the registration credentials
    Then the user should get a browser alert saying "<alert>"
    And the user should be redirected to the register page

  Examples:
    |username                            | password                           |alert           |
    |Batman	                             |Krypton-was_2000	                  |Invalid username|
    |Bane	                             |Krypton-was_2000	                  |Invalid username|
    |wonder_woman_for_the_DC_theming	 |Krypton-was_2000	                  |Invalid username|
    |2face	                             |Krypton-was_2000	                  |Invalid username|
    |Joker!!!?)	                         |Krypton-was_2000	                  |Invalid username|
    |Super_man-2001	                     |b4tS	                              |Invalid password|
    |Super_man-2001	                     |AlfredIsTheBestButlerToExist111	  |Invalid password|
    |Super_man-2001	                     |3atman	                          |Invalid password|
    |Super_man-2001	                     |AlfredIsTheBestButlerToExist!	      |Invalid password|
    |Super_man-2001	                     |batman1	                          |Invalid password|
    |Super_man-2001	                     |BATMAN1	                          |Invalid password|
    |Super_man-2001	                     |Robin	                              |Invalid password|