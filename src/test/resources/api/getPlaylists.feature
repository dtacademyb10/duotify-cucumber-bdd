Feature: GET /playlists API endpoint features


   @api
  Scenario: Retrieve all playlists for a specific user successfully




#     steps of POST /login
     Given the request is authenticated with a valid API key
     And the body has the existing username and password
     When I send a "POST" request to the endpoint "/login"
     Then the response log should be displayed
     Then the response status code should be 200
     And the JWT is set

#     steps of GET /playlists
    And the "Authorization" header is set to JWT token obtained through login endpoint
    When I send a "GET" request to the endpoint "/playlist"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response time should be less than 1000 ms


