package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AlbumDetailsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomePageStepDefs {

    @Given("the user is on the homepage of the music streaming app")
    public void the_user_is_on_the_homepage_of_the_music_streaming_app() {
        new LoginPage().login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
    }
    @Then("the user should see {int} recommended albums displayed on the main page")
    public void the_user_should_see_recommended_albums_displayed_on_the_main_page(Integer numberOfAlbums) {

        Assert.assertEquals(numberOfAlbums, Integer.valueOf(new HomePage().getAlbums().size()));
    }

    @When("the user clicks on the {string} link in the sidebar")
    public void the_user_clicks_on_the_link_in_the_sidebar(String linkName) {
        new HomePage().clickOnLinkByText(linkName);
    }
    @Then("the user should be able to access their personal music library, where they can view, create, edit and delete playlists.")
    public void the_user_should_be_able_to_access_their_personal_music_library_where_they_can_view_create_edit_and_delete_playlists() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/yourMusic.php?", Driver.getDriver().getCurrentUrl());
    }

    @Then("the user should be able to view and edit their user profile information, such as their name, email address, password and should be able to log out.")
    public void the_user_should_be_able_to_() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/settings.php?", Driver.getDriver().getCurrentUrl());
    }


    @Then("the user should be able to view recommended albums")
    public void the_user_should_be_able_to_view_recommended_albums() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());
    }

    @Then("the user should be able to search for an artist, album or tracks")
    public void the_user_should_be_able_to_search_for_an_artist_album_or_tracks() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/search.php?", Driver.getDriver().getCurrentUrl());
    }


    @When("the user selects the song {string} from the album {string} the user clicks on the play button")
    public void the_user_selects_the_song_from_the_album(String song, String album) {

           new HomePage().clickOnAlbumByText(album);
           new AlbumDetailsPage().clickOnSongByText(song);
           SeleniumUtils.waitFor(2);
    }

    @Then("the song {string} should start playing")
    public void the_song_should_start_playing(String currentSong) {
          Assert.assertEquals(currentSong,new HomePage().getCurrentlyPlayingSongText());
    }


    @Then("the following albums should be displayed")
    public void the_following_albums_should_be_displayed(List<String> expectedAlbums) {

        List<String> modifieable = new ArrayList<>(expectedAlbums);
        Collections.sort(modifieable);

      List<String> actualAlbums =  SeleniumUtils.getElementsText(new HomePage().getAlbums());

      Collections.sort(actualAlbums);

      Assert.assertEquals(modifieable, actualAlbums);
    }

}
