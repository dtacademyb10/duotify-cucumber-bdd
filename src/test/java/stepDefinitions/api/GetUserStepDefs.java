package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.ApiUtils;

public class GetUserStepDefs {


    @Given("the {string} query parameter is set to {string}")
    public void the_query_parameter_is_set_to(String key, String value) {
        ApiUtils.setRequestQueryParameter(key, value);
    }

}
