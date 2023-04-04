Feature: Album features
  
  As a music lover, I should be able to view, play songs from albums.
  

  Scenario: Verify album details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the album "Cruel Summer"
    Then the album details should be the following
      | Cruel Summer |
      | Ace Of Base  |
      | 1            |


  Scenario: Verify album details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the album "Escape"
    Then the album should have the following info
      | Name      | Escape           |
      | Artist    | Enrique Iglesias |
      | SongCount | 5                |



  Scenario: Verify album songs details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the album "Escape"
    Then the album songs should have the following info
      | Escape                    | Enrique Iglesias | 2:56 |
      | Hero                      | Enrique Iglesias | 2:56 |
      | Maybe                     | Enrique Iglesias | 2:56 |
      | Don't Turn Off The Lights | Enrique Iglesias | 2:56 |
      | Escapar                   | Enrique Iglesias | 2:56 |


  @album
  Scenario: Verify album songs details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the album "Werk"
    Then the album songs should have the following info
      | Whirls                    | Maya Jane Coles | 2:56 |


