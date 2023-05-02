@api
Feature: POST /login API endpoint features


  Scenario: Log in existing user successfully and generate a temporary JWT token

    Given the request is authenticated with a valid API key
    And the body has the existing username and password
    When I send a "POST" request to the endpoint "/login"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response time should be less than 1000 ms
    And the response body key "message" should be "You've successfully logged in!"
    And the response body key "success" should be true




