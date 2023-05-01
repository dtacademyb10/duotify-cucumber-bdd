package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import utils.ApiUtils;

public class PostUserStepDefs {

    @Given("the body is added")
    public void the_body_is_added() {

        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();



        ApiUtils.setRequestBody("{\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"firstName\": \"Cool\",\n" +
                "  \"lastName\": \"Herc\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"pass\"\n" +
                "}");
    }
}
