@DB
Feature: Verify data mapping


  Scenario: Verify data mapping of playlist creation
    Given the user is on the login page
    When the user enters valid username as "duotech2023" and password as "duotech"
    Then the user is redirected to the home page
    And the user creates a new playlist with the following details
      | playlist_name | playlist_owner|
      |  Popular      | duotech2023 |
    Then the data should be mapped correctly to the following columns in the "playlists" table:
      |  name          |
      |  owner         |

  @db_data-mapping
  Scenario: Verify data mapping of user registration process
    Given the user is on the sign-up page
    When the user enters the following data in the registration form and clicks sign up:
      | username     | first_name | last_name | email                | password   |
      | johndoe2023  | John       | Doe       | john.doe@example.com | password123|
    Then the data should be mapped correctly to the following columns in the table users:
      | username     | first_name | last_name | email                | password   |
      | johndoe2023  | John       | Doe       | john.doe@example.com | password123|


