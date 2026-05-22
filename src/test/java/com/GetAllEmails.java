package com;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;

public class GetAllEmails {

    static String access_token = "";

    @BeforeClass
    public void setUp() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://gmail.googleapis.com");
        requestSpecBuilder.addHeader("Authorization", "Bearer " + access_token);
        requestSpecBuilder.setBasePath("/gmail/v1");
        requestSpecBuilder.addPathParam("userId", "tnkundwa9@gmail.com");
        requestSpecBuilder.log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void GetAllEmails() {
        given().
                when().
                get("/users/{userId}/messages").
                then().
                assertThat().
                body("messages", notNullValue()).
                body("messages", not(empty())).
                body("messages.id", everyItem(notNullValue())).
                body("messages.id", everyItem(not(emptyString()))).
                body("resultSizeEstimate", notNullValue()).
                body("resultSizeEstimate", greaterThanOrEqualTo(0));
    }
}
