package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.ConfigReader;
import utils.Driver;

public class SignUpStepDefs {

    @Given("the user is on the sign-up page")
    public void the_user_is_on_the_sign_up_page() {
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));
        HomePage homePage = new HomePage();
        homePage.clickOnSignUpLink();

    }
    @When("the user enters valid information including first name, last name, email, password, and confirm password")
    public void the_user_enters_valid_information_including_first_name_last_name_email_password_and_confirm_password() {

    }
    @When("clicks on the sign-up button")
    public void clicks_on_the_sign_up_button() {
        System.out.println("Step3");
    }
    @Then("the user is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {
        System.out.println("Step4");
    }
}
