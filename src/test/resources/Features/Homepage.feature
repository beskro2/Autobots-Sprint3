Feature: View User Planets and Moons
  As a user I want to see my planets and moons added to the Planetarium so I can track my findings

  ## Happy Path
  Scenario: Login should allow for viewing owned resources
    Given the user is logged in and on the homepage
    Then they should see their planets and moons

  ## Sad Path
  Scenario: Users not logged in should not be able to view their homepage
    Given the user is not logged in
    When the user tries to directly access the homepage
    Then the user should be denied access