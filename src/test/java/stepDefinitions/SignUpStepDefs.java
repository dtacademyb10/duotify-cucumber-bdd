package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class SignUpStepDefs {


    @Given("the user is on the sign-up page")
    public void the_user_is_on_the_sign_up_page() {
        HomePage homePage = new HomePage();
        homePage.clickOnSignUpLink();

    }
    @When("the user enters valid information including username, first name, last name, email, confirm email, password, and confirm password")
    public void the_user_enters_valid_information_including_first_name_last_name_email_password_and_confirm_password() {

     new HomePage().fillTheFormWithRandomData();

    }
    @When("clicks on the sign-up button")
    public void clicks_on_the_sign_up_button() {
        new HomePage().clickOnRegisterButton();
    }
    @Then("the user is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {
        Assert.assertEquals("URLs don't match", "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?",Driver.getDriver().getCurrentUrl());
    }


    @When("the user enters an invalid email address")
    public void the_user_enters_an_invalid_email_address() throws InterruptedException {
         new HomePage().enterInvalidEmailAddress();
         new HomePage().clickOnRegisterButton();

    }
    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {

        SeleniumUtils.waitForVisibility(new HomePage().getEmailErrorMessage(), 5);
        Assert.assertTrue(new HomePage().getEmailErrorMessage().isDisplayed());
    }
    @Then("the sign-up process should not proceed")
    public void the_sign_up_process_should_not_proceed() {
         Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/register.php", Driver.getDriver().getCurrentUrl());
    }


    @When("the user enters a weak password")
    public void the_user_enters_a_weak_password() {
        HomePage homePage = new HomePage();
        homePage.enterWeakPassword();
        homePage.clickOnRegisterButton();

    }


    @Then("the user should see an error message for password")
    public void theUserShouldSeeAnErrorMessageForPassword() {

        SeleniumUtils.waitForVisibility(new HomePage().getPasswordErrorMessage(), 5);
        Assert.assertTrue(new HomePage().getPasswordErrorMessage().isDisplayed());
    }
}
