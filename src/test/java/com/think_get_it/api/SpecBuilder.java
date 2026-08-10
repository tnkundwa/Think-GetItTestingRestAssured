package com.think_get_it.api;

import com.think_get_it.utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
    
    public static RequestSpecification getRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://think-and-get-it-production.up.railway.app");
        requestSpecBuilder.addHeader("Authorization", "Bearer " + ConfigLoader.getInstance().getAccessTokenUser());
        requestSpecBuilder.setBasePath(Routes.API + Routes.BASE_PATH);
        requestSpecBuilder.setContentType(ContentType.JSON);
        RestAssuredConfig config = RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Authorization"));
        requestSpecBuilder.setConfig(config);
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }

    public static ResponseSpecification getResponseSpecCreate() {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(201);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.log(LogDetail.ALL);
        return responseSpecBuilder.build();
    }

    public static ResponseSpecification getResponseSpecLogin() {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.log(LogDetail.ALL);
        return responseSpecBuilder.build();
    }
}
