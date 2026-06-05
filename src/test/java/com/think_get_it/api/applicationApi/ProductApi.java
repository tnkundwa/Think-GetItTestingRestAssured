package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import io.restassured.response.Response;

import static com.think_get_it.api.SpecBuilder.getRequestSpec;
import static com.think_get_it.api.SpecBuilder.getResponseSpecLogin;
import static io.restassured.RestAssured.given;

public class ProductApi {

    @SuppressWarnings("unchecked")
    public static Response getProducts(Integer pageNumber, Integer limit, String category) {
        return given(getRequestSpec()).
                queryParam("page", pageNumber).
                queryParam("limit", limit).
                queryParam("category", category).
                when().
                get(Routes.PRODUCTS)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    @SuppressWarnings("unchecked")
    public static Response getProductBySlug(String slug) {
        return given(getRequestSpec()).
                pathParam("slug", slug).
                when().
                get(Routes.PRODUCTS + "/{slug}")
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }
}
