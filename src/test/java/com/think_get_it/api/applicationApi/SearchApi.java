package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import io.restassured.response.Response;

import java.util.Map;

import static com.think_get_it.api.SpecBuilder.getRequestSpec;
import static com.think_get_it.api.SpecBuilder.getResponseSpecLogin;
import static io.restassured.RestAssured.given;

public class SearchApi {

    public static Response searchForProduct(Map<String, Object> request) {
        return given(getRequestSpec())
                .queryParams(request)
                .when()
                .get(Routes.SEARCH)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static Response getTrendingSearchItems() {
        return given(getRequestSpec())
                .when()
                .get(Routes.SEARCH + Routes.TRENDING)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

}
