Feature: Login Page

  @temp
  Scenario: User successfully logs in with valid credentials
    Given the user is on the login page
    When the user enters valid username as "duotech2023" and password as "duotech"
    Then the user is redirected to the home page

  @temp
  Scenario: User successfully logs in with valid credentials
    Given the user is on the login page
    When the user enters valid username as "duotech2020" and password as "duotech2020"
    Then the user is redirected to the home page



#  Scenario: User enters invalid credentials
#    Given the user is on the login page
#    When the user enters invalid username or password
#    And clicks on the login button
#    Then the user should see an error message
#
#  Scenario: User forgot password and resets it
#    Given the user is on the login page
#    When the user clicks on the "Forgot password" link
#    And enters their email address
#    And clicks on the "Reset password" button
#    Then the user should receive an email with instructions to reset their password
#
#  Scenario: User tries to access protected page without logging in
#    Given the user is not logged in
#    When the user tries to access a protected page
#    Then the user should be redirected to the login page
#
#  Scenario: User logs out of the application
#    Given the user is logged in
#    When the user clicks on the "Logout" button
#    Then the user should be redirected to the login page