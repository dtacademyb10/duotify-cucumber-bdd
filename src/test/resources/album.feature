Feature: Album features
  
  As a music lover, I should be able to view, play songs from albums.
  
   @album
  Scenario: Verify album details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the album "Cruel Summer"
    Then the album details should be the following
      | Cruel Summer |
      | Ace Of Base  |
      | 1            |
