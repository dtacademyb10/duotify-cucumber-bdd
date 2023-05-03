package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import stepDefinitions.pojos.User;
import utils.ConfigReader;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

public class SerializationDeserialization {


    static {
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
    }

    @Test
    public void serializeUsingString(){






            String username = new Faker().name().username();
            String email = new Faker().internet().emailAddress();

          given().

                    queryParam("api_key", ConfigReader.getProperty("api_key")).
                    body("{\n" +
                            "  \"username\": \"" + username + "\",\n" +
                            "  \"firstName\": \"Cool\",\n" +
                            "  \"lastName\": \"Herc\",\n" +
                            "  \"email\": \"" + email + "\",\n" +
                            "  \"password\": \"pass\"\n" +
                            "}").
                    when().log().all().
                    post("/user").
                    then().log().all().
                    assertThat().
                    statusCode(201);

    }

    @Test
    public void serializeUsingMap(){



        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();

        //{
        //  "username": "gaylord.wiegand",
        //  "firstName": "Cool",
        //  "lastName": "Herc",
        //  "email": "dione.rogahn@yahoo.com",
        //  "password": "pass"
        //}

        Map<String, String > payload =  new LinkedHashMap<>();
        payload.put("username",username);
        payload.put("firstName","Cool");
        payload.put("lastName","Herc");
        payload.put("email",email);
        payload.put("password","pass");


        given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body(payload).
                when().log().all().
                post("/user").
                then().log().all().
                assertThat().
                statusCode(201);

    }

    @Test
    public void serializeUsingList(){


        List<String> body = List.of("Hello", "World", "This", "is", "a", "payload");

        given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body(body).
                when().log().all().
                post("/user").
                then().log().all().
                assertThat().
                statusCode(201);

    }


    @Test
    public void serializeUsingPOJO(){

        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();

        User user = new User();
        user.setUsername( username);
        user.setFirstName( "John");
        user.setLastName( "Doe");
        user.setEmail( email);
        user.setPassword( "dhcsgd");


        given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body(user).
                when().log().all().
                post("/user").
                then().log().all().
                assertThat().
                statusCode(201);


    }

    @Test
    public void serializeUsingPOJO2(){

        User user = new User();
        user.setUsername( "coolherc");
        user.setFirstName( "John");
        user.setLastName( "Doe");
        user.setEmail( "ebdcs@gmail.com");



        given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                queryParam("id", 60).
                body(user).
                when().log().all().
                put("/user").
                then().log().all().
                assertThat().
                statusCode(200);

    }

    @Test
    public void serializeUsingFile(){

        given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                queryParam("id", 60).
                body(new File("src/test/java/stepDefinitions/pojos/patchUserPayload.json")).
                when().log().all().
                put("/user").
                then().log().all().
                assertThat().
                statusCode(200);
    }
}
