package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import io.restassured.response.Response;

import java.util.Map;

import static com.think_get_it.api.SpecBuilder.getRequestSpec;
import static com.think_get_it.api.SpecBuilder.getResponseSpecLogin;
import static io.restassured.RestAssured.given;

public class Reviews {

    public static Response getProductReview(String productId, int page, String sort) {
        return given(getRequestSpec())
                .pathParam("slug", productId)
                .queryParam("page", page)
                .queryParam("sort", sort)
                .when()
                .get(Routes.REVIEWS + "/{productId}")
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static Response leaveProductReview(String productId, Map<String, Object> reviews) {
        return given(getRequestSpec())
                .pathParam("slug", productId)
                .when()
                .body(reviews)
                .post(Routes.REVIEWS + "/{productId}")
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }
}
