package stepDefinitions.api;

import io.cucumber.java.en.Given;
import utils.ApiUtils;

public class GetPlaylistsStepDefs {



    @Given("the {string} header is set to JWT token obtained through login endpoint")
    public void the_header_is_set_to_jwt_token_obtained_through_post_login_endpoint(String key) {


        String jwtToken = ApiUtils.getJWTToken();

        ApiUtils.setRequestHeader(key, jwtToken );
    }



}
