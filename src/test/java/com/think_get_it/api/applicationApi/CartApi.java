package com.think_get_it.api.applicationApi;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static think_get_it.api.SpecBuilder.getRequestSpec;
import static think_get_it.api.SpecBuilder.getResponseSpecLogin;

public class CartApi {

    public static Response getCart() {
        return given(getRequestSpec())
                .when()
                .get(think_get_it.api.Routes.CART)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }
}
