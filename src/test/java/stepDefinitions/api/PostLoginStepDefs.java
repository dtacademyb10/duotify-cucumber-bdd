package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.ApiUtils;
import utils.ConfigReader;

public class PostLoginStepDefs {


    @Given("the body has the existing username and password")
    public void the_body_has_the_existing_username_and_password() {


        String body = "{\n" +
                "  \"username\": \""+ ConfigReader.getProperty("username") +"\",\n" +
                "  \"password\": \""+ConfigReader.getProperty("password")+"\"\n" +
                "}" ;
        ApiUtils.setRequestBody(body);


    }

    @Then("the JWT is set")
    public void the_jwt_is_set() {
        ApiUtils.setJWTToken();
    }


}
