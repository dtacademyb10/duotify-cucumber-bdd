package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));
    }

    @When("the user enters valid username as {string} and password as {string}")
    public void theUserEntersValidUsernameAsAndPasswordAs(String username, String pass) {

        new LoginPage().login(username, pass);

    }



}
