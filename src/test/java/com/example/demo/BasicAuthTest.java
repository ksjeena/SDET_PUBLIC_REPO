package com.example.demo;

import io.restassured.http.ContentType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BasicAuthTest {

    //@Test
    public void basicAuthLogin() {
        String username = "admin";
        String password = "password";

        //language=JSON
        String jsonBody = "{\n" +
                "  \"name\": \"Foo\"\n" +
                "}";

        given()
                .auth()        		
                .basic(username, password)
                .body(jsonBody)
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:7777/secured/hello")
                .then()
                .statusCode(200)    
                .body("success", equalTo(true)) 
                .body("data", equalTo("hello Foo"));
    }
    
    
    //@Test
    public void basicAuthLoginNg() {
        String username = "admin12";
        String password = "password";

        //language=JSON
        String jsonBody = "{\n" +
                "  \"name\": \"Foo\"\n" +
                "}";

        given().auth()        		
                .basic(username, password)
                .body(jsonBody)
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:7777/secured/hello")
                .then()
                .statusCode(401);
    }
    
}