@current
Feature: Sign Up feature

  As a potential customer, I should be able to use the sign up page and create and account to be able to stream music


  Scenario: User successfully signs up with valid credentials
    Given the user is on the sign-up page
    When the user enters valid information including username, first name, last name, email, confirm email, password, and confirm password
    And clicks on the sign-up button
    Then the user is redirected to the home page



  Scenario: User enters invalid email address
    Given the user is on the sign-up page
    When the user enters an invalid email address
    And clicks on the sign-up button
    Then the user should see an error message
    And the sign-up process should not proceed

    @currentTest
  Scenario: User enters a weak password
    Given the user is on the sign-up page
    When the user enters a weak password
    And clicks on the sign-up button
    Then the user should see an error message for password
    And the sign-up process should not proceed


  Scenario: User password and confirm password do not match
    Given the user is on the sign-up page
    When the user enters a password
    And enters a different password in the confirm password field
    And clicks on the sign-up button
    Then the user should see an error message
    And the sign-up process should not proceed


  Scenario: User already has an account
    Given the user is on the sign-up page
    When the user enters an email address that is already associated with an account
    And clicks on the sign-up button
    Then the user should see an error message
    And the sign-up process should not proceed




