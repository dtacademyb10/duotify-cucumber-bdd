package stepDefinitions.api;

import io.cucumber.java.en.Given;
import utils.ApiUtils;

public class PutUserStepDefs {


    @Given("the body is set to the following")
    public void the_body_is_set_to_the_following(String docString) {

        ApiUtils.setRequestBody(docString);
    }
}
