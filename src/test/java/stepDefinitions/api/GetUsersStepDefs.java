package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUsersStepDefs {


    RequestSpecification requestSpecification;
    Response response;
    @Given("the request is authenticated with a valid API key")
    public void the_request_is_authenticated_with_a_valid_api_key() {

        requestSpecification = given().
                queryParam("api_key", ConfigReader.getProperty("api_key"));



    }
    @Given("the {string} header is set to {string}")
    public void the_header_is_set_to(String key, String value) {
        requestSpecification.header(key, value);
    }
    @When("I send a {string} request to the endpoint {string}")
    public void i_send_a_request_to_the_endpoint(String requestMethod, String endpoint) {

       if(requestMethod.equalsIgnoreCase("GET")) {
          response = requestSpecification.
                   when().log().all().
                   get(endpoint);
       }else if (requestMethod.equalsIgnoreCase("POST")){
           response =  requestSpecification.
                   when().log().all().
                   post(endpoint);
       }




    }
    @Then("the response log should be displayed")
    public void the_response_log_should_be_displayed() {
        response.then().log().all();
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        response.then().
                statusCode(equalTo(statusCode));
    }
    @Then("the response {string} header should be {string}")
    public void the_response_header_should_be(String key, String value) {
        response.then().
                header(key,value);

    }
    @Then("the response should contain a list of all users with the following fields")
    public void the_response_should_contain_a_list_of_all_users_with_the_following_fields(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("the response should not contain any sensitive information")
    public void the_response_should_not_contain_any_sensitive_information() {

    }
    @Then("the response time should be less than {int} ms")
    public void the_response_time_should_be_less_than_ms(Integer ms) {
           response.then().
                   time(lessThan((long)ms));
    }

    @Given("the request is not authenticated with a valid API key")
    public void the_request_is_not_authenticated_with_a_valid_api_key() {

        requestSpecification = given().
                queryParam("api_key", ConfigReader.getProperty("api_key")+"dcbsv");

    }

    @And("the response body key {string} should be {string}")
    public void theResponseBodyKeyShouldBe(String key, String value) {

        response.then().body(key, equalTo(value));

    }

    @Given("the body is added")
    public void the_body_is_added() {

        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();



        requestSpecification.body("{\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"firstName\": \"Cool\",\n" +
                "  \"lastName\": \"Herc\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"pass\"\n" +
                "}");
    }
}
