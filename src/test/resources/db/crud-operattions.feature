@DB
Feature: Verify basic CRUD operations UI to DB flow


  Scenario: Sign up with valid user details and verify user creation  - CREATE
    Given the user is on the sign-up page
    When the user enters valid info
    Then the system should create a new user in the database


  Scenario: Sign up with valid user details and verify user info - READ
    Given the user is on the sign-up page
    When the user enters valid info
    Then the created user info in the database should match


  Scenario: Update user email and verify the update - UPDATE
    Given the user is on the login page
    When the user enters valid username as "duotech2023" and password as "duotech"
    Then the user is redirected to the home page
    And the user updates the email field to a new value "helloworld2050@gmail.com"
    Then the the success message should be displayed on the UI
    And the user email with username "duotech2023" is also updated in the database

  @DB_test
  Scenario: Create and Delete Playlist - DELETE
    Given the user is on the login page
    When the user enters valid username as "duotech2023" and password as "duotech"
    Then the user is redirected to the home page
    And the user creates a new playlist with the following details
          |playlist_name|
          |Study|
    Then the playlist should be created on the UI
    And the playlist should be created in the database and should belong to the user "duotech2023"
    When the user deletes the playlist with the following details
          |playlist_name|
          |Study|
    Then the playlist should be deleted on the UI
    And the playlist should be deleted in the database that belongs to the user "duotech2023"


#  Scenario: Sign up with existing email
#    Given the user is on the sign-up page
#    And an existing user with the same email already exists in the database
#    When the user enters the same email in the email field
#    And clicks on the "Sign Up" button
#    Then the system should display an error message stating that the email is already in use
#    And not create a new user in the database
#  Scenario: Sign up with invalid user details
#    Given the user is on the sign-up page
#    When the user enters invalid details such as invalid email format, password that does not meet requirements, or age below 18
#    And clicks on the "Sign Up" button
#    Then the system should display an error message for the invalid fields
#    And not create a new user in the database
#  Scenario: Sign up with incomplete details
#    Given the user is on the sign-up page
#    When the user enters incomplete details such as leaving required fields blank
#    And clicks on the "Sign Up" button
#    Then the system should display an error message for the missing fields
#    And not create a new user in the database