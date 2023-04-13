package stepDefinitions.db;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.DBUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BusinesRulesStepDefs {

    List<String> actual;
    @When("I send a request to retrieve genres from genres table")
    public void i_send_a_request_to_retrieve_genres_from_genres_table() {


       actual = DBUtils.getSingleColumnValues("name", "genres");




    }
    @Then("It should be the following genres")
    public void it_should_be_the_following_genres(List<String> expected) {

        Collections.sort(actual);
        expected = new ArrayList<>(expected);
        Collections.sort(expected);

        Assert.assertEquals(expected, actual);
    }
}
