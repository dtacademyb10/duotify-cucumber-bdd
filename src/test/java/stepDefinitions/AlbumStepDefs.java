package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.AlbumDetailsPage;
import pages.HomePage;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class AlbumStepDefs {




    @When("the user clicks on the album {string}")
    public void theUserClicksOnTheAlbum(String albumName) {
        new HomePage().clickOnAlbumByText(albumName);
    }


    @Then("the album details should be the following")
    public void the_album_details_should_be_the_following(List<Object> dataTable) {

        AlbumDetailsPage albumDetailsPage = new AlbumDetailsPage();
        String actualAlbumName = albumDetailsPage.getAlbumName().getText();
        String actualArtistName = albumDetailsPage.getArtistName().getText().substring(3);
        String actualSongCount = albumDetailsPage.getSongCount().getText().split(" ")[0];



        assertEquals( (String) (dataTable.get(0)), actualAlbumName);
        assertEquals(  (dataTable.get(1)), actualArtistName);
        assertEquals(  (dataTable.get(2)), actualSongCount);
        assertTrue(  true);
        assertNotEquals(  (dataTable.get(2)), actualSongCount);

    }

    @Then("the album should have the following info")
    public void the_album_should_have_the_following_info(Map<String,String > dataTable) {

        AlbumDetailsPage albumDetailsPage = new AlbumDetailsPage();
        String actualAlbumName = albumDetailsPage.getAlbumName().getText();
        String actualArtistName = albumDetailsPage.getArtistName().getText().substring(3);
        String actualSongCount = albumDetailsPage.getSongCount().getText().split(" ")[0];


//        Assert.assertEquals( dataTable.get("Name"), actualAlbumName);
//        Assert.assertEquals(  (dataTable.get("Artist")), actualArtistName);
//        Assert.assertEquals(  (dataTable.get("SongCount")), actualSongCount);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(dataTable.get("Name")).isEqualTo(actualAlbumName);
        softAssertions.assertThat(dataTable.get("Artist")).isEqualTo(actualArtistName);
        softAssertions.assertThat(dataTable.get("SongCount")).isEqualTo(actualSongCount);

        softAssertions.assertAll();

    }

    @Then("the album songs should have the following info")
    public void the_album_songs_should_have_the_following_info(List<List<String>> dataTable) {


        Assert.assertEquals(dataTable, new AlbumDetailsPage().getSongInfoAsList());

    }


}
