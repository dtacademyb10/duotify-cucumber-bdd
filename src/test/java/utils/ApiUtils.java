package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.InputStream;

import static io.restassured.RestAssured.requestSpecification;

import static org.hamcrest.Matchers.*;

public class ApiUtils {


    private  static  RequestSpecification requestSpecification;
    private static Response response;

    private static String JWTToken;


    public static void prepareAPI() {
        RestAssured.baseURI = ConfigReader.getProperty("api_base_uri");
        requestSpecification = RestAssured.given();
    }

    public static void setRequestQueryParameter(String key, Object value){
        requestSpecification.
                queryParam(key, value);
    }
    public static void setRequestPathParameter(String key, Object value){
        requestSpecification.
                pathParam(key, value);
    }
    public static void setRequestHeader(String key, Object value){
        requestSpecification.
                header(key, value);
    }
    public static void  setRequestBody(String body){
        requestSpecification.
                body(body);
    }
    public static void setRequestBody(File file){
        requestSpecification.
                body(file);
    }
    public static void setRequestBody(InputStream inputStream){
        requestSpecification.
                body(inputStream);
    }
    public static void setRequestBody(Object object){
        requestSpecification.
                body(object);
    }
    public static void sendRequest(String method, String endpoint){
        requestSpecification.
                when().log().all(); //display the request details in a log
        response = switch (method) {
            case "GET" -> requestSpecification.get(endpoint);
            case "POST" -> requestSpecification.post(endpoint);
            case "PUT" -> requestSpecification.put(endpoint);
            case "PATCH" -> requestSpecification.patch(endpoint);
            case "DELETE" -> requestSpecification.delete(endpoint);
            default -> throw new IllegalArgumentException("Invalid Request Method");
        };
    }
    public static void displayResponseLog() {
        if(response == null) {
            throw new RuntimeException("Response is null. Make sure the request was sent successfully before trying to display the response log.");
        }
        response.then().log().all();
    }
    public static void verifyResponseStatusCode(int statusCode) {
        if(response == null) {
            throw new RuntimeException("Response is null. Make sure the request was sent successfully before trying to verify the response status code.");
        }
        response.then().statusCode(statusCode);
    }
    public static void verifyResponseHeader(String key, String value) {
        if(response == null) {
            throw new RuntimeException("Response is null. Make sure the request was sent successfully before trying to verify the response header.");
        }
        response.then().header(key,value);
    }
    public static void verifyResponseTime(int milliseconds) {
        if(response == null) {
            throw new RuntimeException("Response is null. Make sure the request was sent successfully before trying to verify the response time.");
        }
        long time = response.then().time(lessThan((long) milliseconds)).extract().time(); // extract response time to be displayed on the console
        System.out.println("The response time: " + time + " ms");
    }
    public static void verifyBasicResponseBody(String key, Object value) {
        if(response == null) {
            throw new RuntimeException("Response is null. Make sure the request was sent successfully before trying to verify the response time.");
        }
        response.then().body(key, equalTo(value));
    }
    public static Response getResponse(){
        if(response == null) {
            throw new RuntimeException("Response is null. Make sure the request was sent successfully before trying to obtain response.");
        }
        return response;
    }


    public static void setJWTToken() {
        JWTToken = response.path("access_token");
    }


    public static String getJWTToken() {
        if(JWTToken == null){
            throw new RuntimeException("JWT Token is required for this request. Make sure to call POST /login before this request.");
        }
       return JWTToken;
    }

}
