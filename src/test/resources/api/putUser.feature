@api
Feature: PUT /user API endpoint features


  Scenario: Update the user entry successfully

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "60"
    And the body is set to the following
     """
     {
      "username": "coolherc",
      "firstName": "Cool",
      "lastName": "Herc",
      "email": "herc@mail.com"
     }
     """
    When I send a "PUT" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "User updated successfully"

