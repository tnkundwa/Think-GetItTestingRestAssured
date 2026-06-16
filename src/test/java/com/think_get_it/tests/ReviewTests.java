package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.getProductId;
import static com.think_get_it.api.applicationApi.RestResources.reviewToProduct;
import static com.think_get_it.api.applicationApi.ReviewsApi.getProductReview;
import static com.think_get_it.api.applicationApi.ReviewsApi.leaveProductReview;
import static org.testng.Assert.assertEquals;

public class ReviewTests {

    @Test
    public void getReviewTest() {
        Response res = getProductReview(getProductId("Ubrtiuob"), 1, "newest");
        assertEquals(res.statusCode(), 200);
    }

    @Test
    public void leaveReviewTest() {
        Response res = leaveProductReview(getProductId("Ubrtiuob"), reviewToProduct());
        assertEquals(res.statusCode(), 200);
    }

}
