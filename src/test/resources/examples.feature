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