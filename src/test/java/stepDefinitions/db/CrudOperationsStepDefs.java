package stepDefinitions.db;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.DBUtils;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class CrudOperationsStepDefs {

    String expectedUsername;
    String first;
    String last;

    String email;
    @When("the user enters valid info")
    public void the_user_enters_valid_info() {

        Faker faker = new Faker();
         expectedUsername = faker.name().username();
         first = faker.name().firstName();
         last = faker.name().lastName();
         email = faker.internet().emailAddress();
        String password = faker.internet().password();
        new SignUpPage().fillTheFormWithRandomData(expectedUsername, first, last ,email,password);
        new SignUpPage().clickRegister();

    }
    @Then("the system should create a new user in the database")
    public void the_system_should_create_a_new_user_in_the_database() {
        List<List<Object>> result = DBUtils.getListOfLists("SELECT username from users where username='" + expectedUsername + "'");
        System.out.println("The user has been created: " + result );
        String actualUsernameRecordedInTheDB = (String)(result.get(0).get(0));
        Assert.assertEquals(expectedUsername,actualUsernameRecordedInTheDB );
    }

    @Then("the created user info in the database should match")
    public void the_created_user_info_in_the_database_should_match() {

        List<Map<String, Object>> result = DBUtils.getListOfMaps("select * from users where username='" + expectedUsername + "' ");

        System.out.println(result);

        Assert.assertEquals(expectedUsername, result.get(0).get("username"));
        Assert.assertEquals(first, result.get(0).get("firstName"));
        Assert.assertEquals(last, result.get(0).get("lastName"));
        Assert.assertEquals(email, result.get(0).get("email"));


    }

    String expectedEmail;
    @Then("the user updates the email field to a new value {string}")
    public void the_user_updates_the_email_field_to_a_new_value(String email) {
        expectedEmail = email;
        HomePage homePage = new HomePage();
        homePage.clickOnLinkByText("Duotech Academy");
        homePage.getUserDetailsButton().click();
        UserDetailsPage userDetailsPage =  new UserDetailsPage();
        userDetailsPage.enterNewEmailAndSave(email);

    }
    @Then("the the success message should be displayed on the UI")
    public void the_the_success_message_should_be_displayed_on_the_ui() {
        Assert.assertTrue(new UserDetailsPage().getUpdateSuccessMessage().isDisplayed());
    }
    @Then("the user email with username {string} is also updated in the database")
    public void the_user_email_is_also_updated_in_the_database(String username) {
        List<Map<String, Object>> result = DBUtils.getListOfMaps("select email from users where username='" + username + "'");
        System.out.println(result);
        Assert.assertEquals(expectedEmail, result.get(0).get("email"));
    }

    String playlist;
    @Then("the user creates a new playlist with the following details")
    public void the_user_creates_a_new_playlist_with_the_following_details(List<Map<String, String>> dataTable) {

          new HomePage().clickOnLinkByText("Your Music");
          new PlaylistPage().getNewPlaylistButton().click();

        playlist = dataTable.get(0).get("playlist_name");
        expectedUser = dataTable.get(0).get("playlist_owner");
        Driver.getDriver().switchTo().alert().sendKeys(playlist);
        Driver.getDriver().switchTo().alert().accept();


    }
    @Then("the playlist should be created on the UI")
    public void the_playlist_should_be_created_on_the_ui() {
           SeleniumUtils.waitFor(1);
           Assert.assertTrue(Driver.getDriver().getPageSource().contains(playlist));
    }

    String expectedUser;
    @Then("the playlist should be created in the database and should belong to the user {string}")
    public void the_playlist_should_be_created_in_the_database_and_should_belong_to_the_user(String user) {

        List<Map<String, Object>> result = DBUtils.getListOfMaps("select * from playlists where owner='" + user + "'and name='" + playlist + "'");
        Assert.assertTrue(!result.isEmpty());
        Assert.assertEquals(result.get(0).get("name"), playlist);
    }
    @When("the user deletes the playlist with the following details")
    public void the_user_deletes_the_playlist_with_the_following_details(List<Map<String, String>> dataTable) {

        new PlaylistPage().clickOnPlaylistByName(playlist);
        new PlaylistDetailsPage().getDeletePlaylistButton().click();
        Driver.getDriver().switchTo().alert().accept();



    }
    @Then("the playlist should be deleted on the UI")
    public void the_playlist_should_be_deleted_on_the_ui() {
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(!Driver.getDriver().getPageSource().contains(playlist));
    }
    @Then("the playlist should be deleted in the database that belongs to the user {string}")
    public void the_playlist_should_be_deleted_in_the_database(String user) {
        List<Map<String, Object>> result = DBUtils.getListOfMaps("select * from playlists where owner='" + user + "'and name='" + playlist + "'");

//        System.out.println(result);  // check how list looks like
        Assert.assertTrue(result.isEmpty());

    }


    @Then("the data should be mapped correctly to the following columns in the {string} table:")
    public void the_data_should_be_mapped_correctly_to_the_following_columns_in_the_table(String table, List<String> columnNames) {


        System.out.println("select * from " + table + " where owner='" + expectedUser + "'and name='" + playlist + "'");
        List<Map<String, Object>> actual = DBUtils.getListOfMaps("select * from " + table + " where owner='" + expectedUser + "'and name='" + playlist + "'");


        Assert.assertEquals( playlist , actual.get(0).get(columnNames.get(0)));
        Assert.assertEquals( expectedUser , actual.get(0).get(columnNames.get(1)));


    }


}
