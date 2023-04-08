Feature: Verify User Sign Up in the Database


  Scenario: Sign up with valid user details
    Given the user is on the sign-up page
    When the user enters valid information including username, first name, last name, email, confirm email, password, and confirm password
    Then the system should create a new user in the database


  Scenario: Sign up with existing email
    Given the user is on the sign-up page
    And an existing user with the same email already exists in the database
    When the user enters the same email in the email field
    And clicks on the "Sign Up" button
    Then the system should display an error message stating that the email is already in use
    And not create a new user in the database
  Scenario: Sign up with invalid user details
    Given the user is on the sign-up page
    When the user enters invalid details such as invalid email format, password that does not meet requirements, or age below 18
    And clicks on the "Sign Up" button
    Then the system should display an error message for the invalid fields
    And not create a new user in the database
  Scenario: Sign up with incomplete details
    Given the user is on the sign-up page
    When the user enters incomplete details such as leaving required fields blank
    And clicks on the "Sign Up" button
    Then the system should display an error message for the missing fields
    And not create a new user in the database