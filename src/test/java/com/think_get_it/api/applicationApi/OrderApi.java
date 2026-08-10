package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import io.restassured.response.Response;

import java.util.Map;

import static com.think_get_it.api.SpecBuilder.getRequestSpec;
import static com.think_get_it.api.SpecBuilder.getResponseSpecLogin;
import static io.restassured.RestAssured.given;

public class OrderApi {

    public static Response placeNewOrder(Map<String, String> params) {

        return given(getRequestSpec()).
                when()
                .body(params)
                .post(Routes.ORDERS)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static Response getOrders(Map<String, Object> queryParams) {

        return given(getRequestSpec())
                .queryParams(queryParams)
                .when()
                .get(Routes.ORDERS)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static Response getSingleOrder(String orderId) {

        return given(getRequestSpec())
                .pathParam("id", orderId)
                .when()
                .get(Routes.ORDERS)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static Response cancelOrder(String orderId) {

        return given(getRequestSpec())
                .pathParam("id", orderId)
                .when()
                .patch(Routes.ORDERS + "/{id}" + Routes.CANCEL)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }
}
