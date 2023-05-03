@api
Feature: PATCH /user API endpoint features


  Scenario: Update the user detail successfully

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "60"
    And the body is set to the following
     """
     {
      "firstName": "Cool",
      "lastName": "Herc"
     }
     """
    When I send a "PATCH" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "User updated successfully"

   @temp
  Scenario: Update the user detail successfully using Map as a request body

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "60"
    And the body is set to the following map
            |  lastName |  Herc           |
            |  email    |  herc@mail.com  |
    When I send a "PATCH" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "User updated successfully"
