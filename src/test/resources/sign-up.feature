Feature: Sign Up feature

  As a potential customer, I should be able to use the sign up page and create and account to be able to stream music


  Scenario: User successfully signs up with valid credentials
    Given the user is on the sign-up page
    When the user enters valid information including first name, last name, email, password, and confirm password
    And clicks on the sign-up button
    Then the user is redirected to the home page

#  Scenario: User enters invalid email address
#    Given the user is on the sign-up page





