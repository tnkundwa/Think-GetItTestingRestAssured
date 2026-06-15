package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.getProductId;
import static com.think_get_it.api.applicationApi.WishlistApi.*;
import static org.testng.Assert.assertEquals;

public class WishlistTests {

    @Test
    public void getUserWishlistTest() {
        Response res = getUsersWishlist();
        assertEquals(res.statusCode(), 200);
    }

    @Test
    public void addProductToWishlistTest() {
        Response res = addProductToWishlist(getProductId("Ubrtiuob"));
        assertEquals(res.statusCode(), 201);
    }

    @Test
    public void removeProductFromWishlistTest() {
        Response res = removeProductFromWishlist(getProductId("Ubrtiuob"));
        assertEquals(res.statusCode(), 200);
    }

}
