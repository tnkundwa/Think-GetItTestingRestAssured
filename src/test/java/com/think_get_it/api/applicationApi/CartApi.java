package com.think_get_it.api.applicationApi;


import com.think_get_it.api.Routes;
import io.restassured.response.Response;

import static com.think_get_it.api.SpecBuilder.getRequestSpec;
import static com.think_get_it.api.SpecBuilder.getResponseSpecLogin;
import static io.restassured.RestAssured.given;

public class CartApi {

    public static Response getCart() {
        return given(getRequestSpec())
                .when()
                .get(Routes.CART)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

//    public static Response addProductToCart() {
//
//    }
}
