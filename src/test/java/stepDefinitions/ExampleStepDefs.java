package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLOutput;
import java.util.List;

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

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {

    }
    @When("I click on reason for loan dropdown")
    public void i_click_on_reason_for_loan_dropdown() {

    }
    @Then("I should see the following options")
    public void i_should_see_the_following_options(List<String> dataTable) {
        System.out.println(dataTable);
    }
}
