Feature: Music Streaming App Homepage

  As a music lover, I want to be able to access and explore music easily through a music streaming app. The homepage of the app should display 9 albums on the main page and have a left sidebar with links to Search, Browse, Your Music, and Edit User profile options.

  @homepage
  Scenario: User opens the app and sees 9 recommended albums on the homepage
    Given the user is on the homepage of the music streaming app
    Then the user should see 9 recommended albums displayed on the main page
#
#  Scenario: User clicks on an album cover and is taken to the album page
#    Given the user is on the homepage of the music streaming app
#    When the user clicks on an album cover
#    Then the user should be taken to the album page, where they can view its tracklist, see album information such as Title, Artist and Song Count.
#
#  Scenario: User clicks on the Your Music link in the sidebar
#    Given the user is on the homepage of the music streaming app
#    When the user clicks on the Your Music link in the sidebar
#    Then the user should be able to access their personal music library, where they can view, create, edit and delete playlists.
#
#  Scenario: User clicks on the Edit User link in the sidebar
#    Given the user is on the homepage of the music streaming app
#    When the user clicks on the Edit User link in the sidebar
#    Then the user should be able to view and edit their user profile information, such as their name, email address, password and should be able to log out.
#
#
#  Scenario: User plays a song from an album
#    Given the user is on the home page of the music streaming app
#    When the user selects the song "Daughter" from the album "Oscillation"
#    And the user clicks on the play button
#    Then the song "Daughter" should start playing
#
#
#  Scenario Outline: User plays a given song from given album
#    Given the user is on the home page of the music streaming app
#    When the user selects the song "<song_title>" from the album "<album_title>"
#    And the user clicks on the "Play" button
#    Then the song "<song_title>" should start playing
#
#    Examples:
#      | song_title        |album_title       |
#      | Lose Yourself     |Lose Yourself     |
#      | Clair de Lune     |Clair de Lune     |
#      | The Less I Know   |The Less I Know   |