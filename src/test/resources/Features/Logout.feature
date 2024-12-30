Feature: Logout Feature

  Scenario: Users can logout if signed in
    Given the user is logged in
    When the user clicks the logout link
    Then the user should be redirected to the login page after logout