package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.AdminApi.*;
import static com.think_get_it.api.applicationApi.RestResources.getCoupons;
import static org.testng.Assert.assertEquals;

public class AdminTests {

    @Test
    public void getDashboardAnalyticsTest() {
        Response res = getDashboardAnalytics();
        assertEquals(res.statusCode(), 200);
    }

    @Test
    public void getAllUsersTest() {
        Response res = getAllUsers(1, "q");
        assertEquals(res.statusCode(), 200);
    }

    @Test
    public void removeProductFromWishlistTest() {
        Response res = createCoupons(getCoupons());
        assertEquals(res.statusCode(), 200);
    }
}
