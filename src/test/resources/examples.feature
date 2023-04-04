Feature: Example scenarios to demo the concepts


  Scenario: Adding two integers
    Given the first number is 12
    And the second number is 220
    When the numbers are added together
    Then the result is 232


  @demo
  Scenario: Verify the product price
    Given I am on the homepage of e-commerce
    Then the first promoted product price should be 23.67

  @demo
  Scenario: Verify the product price
    Given I am on the homepage of e-commerce
    Then the first promoted product price should be 34.66


    Scenario: Verify Dropdown options
      Given I am on the homepage
      When I click on reason for loan dropdown
      Then I should see the following options
            |Mortgage		|
            |Auto Loan		|
            |Personal loan	|
            |Student Loan	|


  Scenario: User can register with valid details
    Given the user is on the registration page
    When the user enters the following details
      | Name 		| John Smith 		|
      | Email 		| john@example.com 	|
      | Password 	| password123 		|

    And the user clicks the submit button
    Then the user is registered successfully



    Scenario: Datatable example

      Given I have the following info
        | Annie M. G. | Schmidt  | 1911-03-20 |
        | Roald       | Dahl     | 1916-09-13 |
        | Astrid      | Lindgren | 1907-11-14 |



  Scenario: Datatable example

    Given I have the following info as List of Maps

        | Annie M. G. | Schmidt  | 1911-03-20 |
        | Roald       | Dahl     | 1916-09-13 |
        | Astrid      | Lindgren | 1907-11-14 |


  @datatableDemo
  Scenario: Datatable example

    Given I have the following info as Map

      | KMSY | 29.993333 | -90.258056  |
      | KSFO | 37.618889 | -122.375000 |
      | KSEA | 47.448889 | -122.309444 |
      | KJFK | 40.639722 | -73.778889  |






  @sc_outline
  Scenario Outline: Login with valid credentials

    Given I am on the login page
    When I enter username "<username>" and password "<pass>"
    And I click on the login button
    Then I should see the dashboard page

    Examples:
      | username       | pass       |
      | duotech2023    | duotech    |
      | johnnycash2023 | johnnycash |
      | stevejobs2023  | stevejobs  |








