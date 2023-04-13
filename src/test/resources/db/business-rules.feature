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