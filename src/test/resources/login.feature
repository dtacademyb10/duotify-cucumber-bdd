Feature: As a registered user, I should be able to login using the login


  Scenario: Positive login
    Given I am on the homepage
    When I enter the correct username and password
    Then I should be able to login successfully

#  Scenario: Negative login
#    Given I am on the homepage
#    When I enter the incorrect username and password
#    Then I should not be able to login successfully

