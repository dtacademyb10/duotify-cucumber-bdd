package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.Driver;

public class LoginStepDefinitions {


    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        Driver.getDriver().get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
    }
    @When("I enter the correct username and password")
    public void i_enter_the_correct_username_and_password() {
         Driver.getDriver().findElement(By.id("loginUsername")).sendKeys("duotech2023");
         Driver.getDriver().findElement(By.id("loginPassword")).sendKeys("duotech", Keys.ENTER);
    }
    @Then("I should be able to login successfully")
    public void i_should_be_able_to_login_successfully() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?",Driver.getDriver().getCurrentUrl());
    }
}
