package stepDefinitions.api;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import utils.ConfigReader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {



    static {
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
    }






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



        String id = "46";
        String prettyString = given().
                queryParam("id", id).
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                when().log().all().
                get("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("id", equalTo(id)).
                body("firstName", is("Duotech")).
                header("Content-Type", "application/json").
                time(lessThan(1000L)).extract().response().asPrettyString();

        //asPrettyString(); -> returns the response body in as String in Json format

        System.out.println(prettyString);


    }

    @Test
    public void testGetUsers(){




   List all =    given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                when().log().all().
                get("/users").
                then().log().all().
                assertThat().
                 body("[0].id", equalTo("43")).
//                statusCode(200).extract().path("");
                  statusCode(200).extract().path("$");


        System.out.println(all);
        System.out.println(all.size());








    }


    @Test
    public void testCreateUser(){




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


    @Test
    public void testPutUser(){


        given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                queryParam("id", 1709870652).
                body("""
                        {
                          "username": "barack",
                          "firstName": "Joe",
                          "lastName": "Herc",
                          "email": "joe@gmail.com"
                        }""").
                when().log().all().
                put("/user").
                then().log().all().
                statusCode(200).
                body("message", is("User updated successfully")).
                header("Content-Type", "application/json").
                time(lessThan(1000L));


    }


    @Test
    public void testPatchUser(){


        given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                queryParam("id", 1709870652).
                body("""
                        {
                                       "username": "billclinton",
                                        "email": "billclinton@gmail.com",
                                        "lastName":"Zaur"
                                                 
                                }""").
                when().log().all().
                patch("/user").
                then().log().all().
                statusCode(200).
                body("message", is("User updated successfully")).
                header("Content-Type", "application/json").
                time(lessThan(1000L));

    }


    @Test
    public void testDeleteUser(){


        // Create user first
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

             // Delete the user by id

        given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                queryParam("id",userId).
                when().log().all().
                delete("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", is("User deleted successfully")).
                header("Content-Type", "application/json").
                time(lessThan(1000L));


        System.out.println(UUID.randomUUID());




    }

    @Test
    public void testUUID(){
        // 2 different ways of getting truly unique values
//        UUID uuid = UUID.randomUUID();
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void testUserLogin(){
    String accessToken =    given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body("{\n" +
                        "  \"username\": \""+ConfigReader.getProperty("username")+"\",\n" +
                        "  \"password\": \""+ConfigReader.getProperty("password")+"\"\n" +
                        "}").
                when().log().all().
                post("/login").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", is("The user has been created.")).
                body("status", is(1)).
                header("Content-Type", "application/json").
                time(lessThan(1000L)).extract().response().path("access_token");
    }


    @Test
    public void testGetPlaylists(){
        String accessToken =    given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body("{\n" +
                        "  \"username\": \""+ConfigReader.getProperty("username")+"\",\n" +
                        "  \"password\": \""+ConfigReader.getProperty("password")+"\"\n" +
                        "}").
                when().log().all().
                post("/login").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", is("You've successfully logged in!")).
                body("success", is(true)).
                header("Content-Type", "application/json; charset=UTF-8").
                time(lessThan(1000L)).extract().response().path("access_token");

        // Use the access token to obtain the user specific playlists

        given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                header("Authorization", accessToken).
                when().log().all().
                get("/playlists").
                then().log().all().
                assertThat().
                statusCode(200).
                body("success", equalTo(1)).
                header("Content-Type", "application/json; charset=UTF-8").
                time(lessThan(1000L));




    }


    @Test
    public void testGpathBasics(){

        baseURI = "http://api.weatherapi.com/v1";


//        String locationName = given().
//                queryParam("key", ConfigReader.getProperty("weather_api_key")).
//                queryParam("q", "Fairfax VA").
//                when().log().all().
//                get("/current.json").
//                then().log().all().
//                assertThat().
//                statusCode(200).
//                body("location.name", equalTo("Fairfax")).
//                time(lessThan(1000L)).extract().path("location.region");
//
//
//        System.out.println(locationName);


        JsonPath jsonPath = given().
                queryParam("key", ConfigReader.getProperty("weather_api_key")).
                queryParam("q", "Fairfax VA").
                when().log().all().
                get("/current.json").
                then().log().all().
                assertThat().
                statusCode(200).
                body("location.name", equalTo("Fairfax")).
                body("current.condition.icon", equalTo("//cdn.weatherapi.com/weather/64x64/night/116.png")).
                time(lessThan(1000L)).extract().jsonPath();

        String country = jsonPath.getString("location.country");

        System.out.println(country);

        Double lat = jsonPath.getDouble("location.lat");

        System.out.println(lat);

        Object o = jsonPath.get("location.lon");

        System.out.println(o);

        Map<String, Object> location = jsonPath.getMap("location");

        System.out.println(location.keySet());

//        System.out.println(location.getClass());

        System.out.println(location);


        System.out.println(jsonPath.getString("current.condition.text"));


    }

    @Test
    public void testGpathAdvanced(){

        JsonPath jsonPath =  new JsonPath(new File("src/test/java/stepDefinitions/api/bookstore.json"));


        jsonPath.prettyPrint();

        System.out.println(jsonPath.getInt("id"));
        System.out.println(jsonPath.getDouble("location.lat"));
        System.out.println(jsonPath.getList("days_open"));
        System.out.println(jsonPath.getString("days_open[0]"));
        System.out.println(jsonPath.getInt("days_open.size()"));


        List<Map<String,Object>> listOfBooks = jsonPath.getList("store.book");

        System.out.println(listOfBooks);


        Object o = jsonPath.get("store.book[1].author");

        System.out.println(o);

        List<String> authors= jsonPath.get("store.book.author");

        System.out.println(authors);


    }








}
