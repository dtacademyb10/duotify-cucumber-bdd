package stepDefinitions.api;

import io.cucumber.java.en.Given;
import org.apiguardian.api.API;
import utils.ApiUtils;

public class DeleteUserStepDefs {
    Integer userId;

    @Given("The user id is extracted")
    public void the_user_is_created_and_the_id() {
        userId = ApiUtils.getResponse().path("user_id");
    }
    @Given("the {string} query parameter is set to newly generated user's id")
    public void the_query_parameter_is_set_to_newly_generated_user_s_id(String key) {
        ApiUtils.setRequestQueryParameter(key, userId );
    }
}
