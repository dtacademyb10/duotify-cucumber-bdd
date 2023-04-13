package stepDefinitions.db;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.DBUtils;

import java.util.*;

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

    List<String> actualColumnNames;
    @When("I send a request to retrieve column names for albums table")
    public void i_send_a_request_to_retrieve_column_names_for_albums_table() {

        actualColumnNames = DBUtils.getColumnNames("SELECT * from albums");

    }
    @Then("It should be the following")
    public void it_should_be_the_following(List<String> expectedColumnNames) {

        Assert.assertEquals(expectedColumnNames, actualColumnNames);
    }

    List<String> list;
    @When("I send a request to retrieve usernames")
    public void i_send_a_request_to_retrieve_usernames() {
        list = DBUtils.getSingleColumnValues("username", "users");

    }
    @Then("the result should contain duplicates")
    public void the_result_should_contain_duplicates() {

        ArrayList<String> actual = new ArrayList<>(new LinkedHashSet<>(list));

        System.out.println(actual);
        System.out.println(list);

        Assert.assertEquals(list, actual);

    }

    List<Map<String, Object>> expectedList;
    @When("I send a request to retrieve duplicate usernames")
    public void i_send_a_request_to_retrieve_duplicate_usernames() {
        expectedList = DBUtils.getListOfMaps("SELECT  username,count(*) from users GROUP BY username having count(*) > 1");
    }
    @Then("The result should be empty")
    public void the_result_should_be_empty() {
         Assert.assertEquals(0, expectedList.size());
    }



}
