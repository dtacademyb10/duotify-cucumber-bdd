package stepDefinitions.db;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.SignUpPage;
import pages.UserDetailsPage;
import utils.DBUtils;

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


}
