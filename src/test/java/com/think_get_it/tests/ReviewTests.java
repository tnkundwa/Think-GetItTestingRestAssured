package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.*;
import static com.think_get_it.api.applicationApi.ReviewsApi.getProductReview;
import static com.think_get_it.api.applicationApi.ReviewsApi.leaveProductReview;
import static org.testng.Assert.*;

public class ReviewTests {

    @Test
    public void getReviewTest() {
        Response res = getProductReview(getOrderId(), 1, "newest");
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");
        assertTrue(success);
        assertEquals(message, "Success");
        assertTrue(data.isEmpty());
    }

    @Test
    public void leaveReviewTest() {
        Response res = leaveProductReview(getProductId("Ubrtiuob"), reviewToProduct());
        Integer rating = res.jsonPath().getInt("data[0].rating");
        String title = res.jsonPath().getString("data[0].title");
        String body = res.jsonPath().getString("data[0].body");
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");
        assertTrue(success);
        assertFalse(data.isEmpty());
        assertEquals(message, "Review submitted");
        assertEquals(rating, reviewToProduct().get("rating"));
        assertEquals(title, reviewToProduct().get("title"));
        assertEquals(body, reviewToProduct().get("body"));
    }

}
