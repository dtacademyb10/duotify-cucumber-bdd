package stepDefinitions.api;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

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
                queryParam("api_key","e82042a5f58f449c9d5a9e3cf5a3f43b").
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


        given().

                queryParam("api_key","e82042a5f58f449c9d5a9e3cf5a3f43b").
                body("{\n" +
                        "  \"username\": \"coolhefdsrsaac"+new Random().nextInt(1000000)+"\",\n" +
                        "  \"firstName\": \"Cool\",\n" +
                        "  \"lastName\": \"Herc\",\n" +
                        "  \"email\": \"hedsfsdrc@mail.com"+new Random().nextInt(1000000)+"\",\n" +
                        "  \"password\": \"dhsjjfhdsf\"\n" +
                        "}").
        when().log().all().
                post("/user").
        then().log().all().
                assertThat().
                statusCode(201).
                body("message", is("The user has been created.")).
                header("Content-Type", "application/json").
                time(lessThan(1000L));

    }



}
