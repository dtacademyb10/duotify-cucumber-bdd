Feature: GET /users API endpoint features
  As an admin
  I want to retrieve all the users of the mortgage application
  So that I can manage and monitor the user base


  Scenario: Retrieve all users successfully

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    When I send a "GET" request to the endpoint "/users"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response should contain a list of all users with the following fields
          |id|
          |username|
          |firstName|
          |lastName|
          |email|
          |password|
          |signUpDate|
          |profilePic|

    And the response should not contain any sensitive information
    And the response time should be less than 1000 ms



  Scenario: Missing api key

    Given the request is not authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    When I send a "GET" request to the endpoint "/users"
    Then the response log should be displayed
    Then the response status code should be 401
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "Invalid or missing API Key. API key must be provided as an 'api_key' query parameter."