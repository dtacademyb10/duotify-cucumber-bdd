package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AlbumDetailsPage;
import pages.HomePage;

import java.util.List;

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



        Assert.assertEquals( (String) (dataTable.get(0)), actualAlbumName);
        Assert.assertEquals(  (dataTable.get(1)), actualArtistName);
        Assert.assertEquals(  (dataTable.get(2)), actualSongCount);

    }

}
