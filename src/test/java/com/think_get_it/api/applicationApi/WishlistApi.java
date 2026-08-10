package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import io.restassured.response.Response;

import static com.think_get_it.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class WishlistApi {

    public static Response getUsersWishlist() {
        return given(getRequestSpec())
                .when()
                .get(Routes.WISHLIST)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static Response addProductToWishlist(String productId) {
        return given(getRequestSpec())
                .pathParam("productId", productId)
                .when()
                .post(Routes.WISHLIST + "{productId}")
                .then()
                .spec(getResponseSpecCreate())
                .extract().response();
    }

    public static Response removeProductFromWishlist(String productId) {
        return given(getRequestSpec())
                .pathParam("productId", productId)
                .when()
                .delete(Routes.WISHLIST + "{productId}")
                .then()
                .spec(getResponseSpecCreate())
                .extract().response();
    }

}
