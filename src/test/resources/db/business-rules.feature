@DB
Feature: Verify database related business rules


  @db_only
  Scenario: Verify the pre-defined genres in the database
    When  I send a request to retrieve genres from genres table
    Then It should be the following genres

      | pop        |
      | techno     |
      | rnb        |
      | house      |
      | classical  |
      | jazz       |
      | electronic |
      | dance      |
      | reggae     |
      | reggaeton  |
      | rap        |

  @db_only @regression
  Scenario: Verify the column names for albums table
    When I send a request to retrieve column names for albums table
    Then It should be the following
      | id          |
      | title       |
      | artist      |
      | genre       |
      | artworkPath |


 @db_only
  Scenario: Verify the duplicate usernames
    When  I send a request to retrieve usernames
    Then  the result should contain duplicates


@db_only
  Scenario: Verify the duplicate usernames
    When  I send a request to retrieve duplicate usernames
    Then  The result should be empty




