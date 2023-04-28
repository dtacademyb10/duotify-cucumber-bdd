package stepDefinitions.api;


import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import utils.ConfigReader;

import java.util.Random;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {








        @Test
    public void basicDemo(){

        // 1. Set the base URI

        baseURI  = "https://api.github.com/";


        // given() ->

//        given().header("Accept", "*/*").
////                queryParam("id","34")
//        when().log().all().
//              get("/users").
//        then().log().all().
//                statusCode(equalTo(200));

        // Divided version

        RequestSpecification requestSpecification = given().
                                            header("Accept", "*/*");
                            //                queryParam("id","34")

        Response response = requestSpecification.
                                            when().log().all().
                                            get("/users");


        response.
                then().log().all().
                statusCode(equalTo(200));



    }



    @Test
    public void testGetUser(){

        baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";

        String id = "46";
        given().
                queryParam("id", id).
                queryParam("api_key",ConfigReader.getProperty("api_key")).
        when().log().all().
                get("/user").
        then().log().all().
                assertThat().
                statusCode(200).
                body("id",equalTo(id)).
                body("firstName", is("Duotech")).
                header("Content-Type", "application/json").
                time(lessThan(1000L));




    }


    @Test
    public void testCreateUser(){

        baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";


        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();

        Response response = given().

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
                statusCode(201).
                body("message", is("The user has been created.")).
                body("status", is(1)).
                header("Content-Type", "application/json").
                time(lessThan(1000L)).extract().response();

        Integer userId = response.path("user_id");

        // Verify user creation by sending a get request to obtain the info about the user that is just created
        given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                queryParam("id", userId).
                when().log().all().
                get("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("username", equalTo(username)).
                body("email", is(email)).
                header("Content-Type", "application/json").
                time(lessThan(1000L));




    }



}
