package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.SignUpPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class SignUpStepDefs {


    @Given("the user is on the sign-up page")
    public void the_user_is_on_the_sign_up_page() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.clickOnSignUpLink();

    }
    @When("the user enters valid information including username, first name, last name, email, confirm email, password, and confirm password")
    public void the_user_enters_valid_information_including_first_name_last_name_email_password_and_confirm_password() {

     new SignUpPage().fillTheFormWithRandomData();

    }
    @When("^clicks on the sign-up button$")
    public void clicks_on_the_sign_up_button() {
        new SignUpPage().clickOnRegisterButton();
    }
    @Then("the user is redirected to the home page")
    public void the_user_is_redirected_to_the_home_page() {
        Assert.assertEquals("URLs don't match", "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?",Driver.getDriver().getCurrentUrl());
    }


    @When("the user enters an invalid email address")
    public void the_user_enters_an_invalid_email_address() throws InterruptedException {
         new SignUpPage().enterInvalidEmailAddress();
         new SignUpPage().clickOnRegisterButton();

    }
    @Then("the user should see an error message for email")
    public void the_user_should_see_an_error_message() {

        SeleniumUtils.waitForVisibility(new SignUpPage().getEmailErrorMessage(), 5);
        Assert.assertTrue(new SignUpPage().getEmailErrorMessage().isDisplayed());
    }
    @Then("the sign-up process should not proceed")
    public void the_sign_up_process_should_not_proceed() {
         Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/register.php", Driver.getDriver().getCurrentUrl());
    }


    @When("the user enters a weak password")
    public void the_user_enters_a_weak_password() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.enterWeakPassword();
        signUpPage.clickOnRegisterButton();

    }


    @Then("the user should see an error message for password")
    public void theUserShouldSeeAnErrorMessageForPassword() {

        SeleniumUtils.waitForVisibility(new SignUpPage().getPasswordErrorMessage(), 5);
        Assert.assertTrue(new SignUpPage().getPasswordErrorMessage().isDisplayed());
    }

    @When("^the user enters a password and enters a different password in the confirm password field$")
    public void the_user_enters_a_password() {
         SignUpPage signUpPage = new SignUpPage();

         new SignUpPage().enterNonMatchingPasswords();
    }

    @Then("the user should see an error message for confirm password")
    public void theUserShouldSeeAnErrorMessageForConfirmPassword() {
        SeleniumUtils.waitForVisibility(new SignUpPage().getPasswordConfirmErrorMessage(), 5);
        Assert.assertTrue(new SignUpPage().getPasswordConfirmErrorMessage().isDisplayed());

    }

    @When("the user enters an email address that is already associated with an account")
    public void the_user_enters_an_email_address_that_is_already_associated_with_an_account() {
            new SignUpPage().enterAlreadyUsedEmailAddress();
    }
    @Then("the user should see an error message for an already used email")
    public void the_user_should_see_an_error_message_for_an_alraedy_used_email() {
        SeleniumUtils.waitForVisibility(new SignUpPage().getAlreadyUsedEmailErrorMessage(), 5);
        Assert.assertTrue(new SignUpPage().getAlreadyUsedEmailErrorMessage().isDisplayed());
    }



}
