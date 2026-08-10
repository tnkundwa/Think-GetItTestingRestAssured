package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.getProductId;
import static com.think_get_it.api.applicationApi.WishlistApi.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class WishlistTests {

    @Test
    public void getUserWishlistTest() {
        Response res = getUsersWishlist();
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");
        assertTrue(success);
        assertEquals(message, "Success");
        assertFalse(data.isEmpty());
    }

    @Test
    public void addProductToWishlistTest() {
        Response res = addProductToWishlist(getProductId("Ubrtiuob"));
        String name = res.jsonPath().getString("data[0].name");
        String slug = res.jsonPath().getString("data[0].slug");
        String description = res.jsonPath().getString("data[0].description");
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");
        assertTrue(success);
        assertEquals(message, "Added to wishlist");
        assertFalse(data.isEmpty());
        assertThat(name, is(not(emptyOrNullString())));
        assertThat(slug, is(not(emptyOrNullString())));
        assertThat(description, is(not(emptyOrNullString())));
    }

    @Test
    public void removeProductFromWishlistTest() {
        Response res = removeProductFromWishlist(getProductId("Ubrtiuob"));
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("Removed from wishlist");
        assertTrue(success);
        assertEquals(message, "Added to wishlist");
        assertTrue(data.isEmpty());
    }

}
