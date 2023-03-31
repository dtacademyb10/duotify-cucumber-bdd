package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLOutput;

public class ExampleStepDefs {

    @Given("the first number is {int}")
    public void the_first_number_is(Integer num) {
        System.out.println(num);
    }
    @Given("the second number is {int}")
    public void the_second_number_is(Integer num2) {
        System.out.println(num2);
    }
    @When("the numbers are added together")
    public void the_numbers_are_added_together() {
        System.out.println("Numbers are added: " );
    }
    @Then("the result is {int}")
    public void the_result_is(Integer result) {
        System.out.println(result);
    }

    @Given("I am on the homepage of e-commerce")
    public void i_am_on_the_homepage_of_e_commerce() {
        System.out.println("navigating to homepage");
    }
    @Then("the first promoted product price should be {double}")
    public void the_first_promoted_product_price_should_be(Double price) {
        System.out.println("The price is " + price);
    }
}
