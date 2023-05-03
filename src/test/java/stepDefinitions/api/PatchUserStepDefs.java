package stepDefinitions.api;

import io.cucumber.java.en.Given;
import utils.ApiUtils;

import java.util.Map;

public class PatchUserStepDefs {

    @Given("the body is set to the following map")
    public void the_body_is_set_to_the_following_map( Map<String, String> payload) {

        ApiUtils.setRequestBody(payload);

    }

}
