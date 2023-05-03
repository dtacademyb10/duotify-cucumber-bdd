package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.ApiUtils;
import utils.ConfigReader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetPlaylistsStepDefs {



    @Given("the {string} header is set to JWT token obtained through login endpoint")
    public void the_header_is_set_to_jwt_token_obtained_through_post_login_endpoint(String key) {


        String jwtToken = ApiUtils.getJWTToken();

        ApiUtils.setRequestHeader(key, jwtToken );
    }


    @Then("the owner of all playlists should be correct")
    public void the_owner_of_all_playlists_should_be_correct() {

        List<String> allOwners = ApiUtils.getResponse().path("playlists.owner");

        System.out.println(allOwners);

        String expectedOwner = ConfigReader.getProperty("username");
        for (String owner : allOwners) {
            Assert.assertEquals(expectedOwner,owner);
        }


    }

    @Then("the all playlists should be sorted in descending order")
    public void the_all_playlists_should_be_sorted_in_descending_order() {


        List<LocalDateTime> actual = ApiUtils.getResponse().path("playlists.dateCreated");

        System.out.println(actual);

        List<LocalDateTime> expected =  new ArrayList<>(actual);

        expected.sort(Comparator.reverseOrder());

        System.out.println(expected);

        Assert.assertEquals(expected,actual);




    }



}
