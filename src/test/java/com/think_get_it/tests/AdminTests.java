package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.AdminApi.*;
import static com.think_get_it.api.applicationApi.RestResources.getCoupons;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class AdminTests {

    @Test
    public void getDashboardAnalyticsTest() {
        Response res = getDashboardAnalytics();
        String stats = res.jsonPath().getString("data[0].stats");
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");
        assertTrue(success);
        assertEquals(message, "Success");
        assertFalse(data.isEmpty());
        assertThat(stats, is(not(emptyOrNullString())));
    }

    @Test
    public void getAllUsersTest() {
        Response res = getAllUsers(1, "t");
        String id = res.jsonPath().getString("data[0].id");
        String email = res.jsonPath().getString("data[0].email");
        String firstName = res.jsonPath().getString("data[0].firstName");
        String lastName = res.jsonPath().getString("data[0].lastName");
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");
        assertTrue(success);
        assertEquals(message, "Success");
        assertFalse(data.isEmpty());
        assertThat(id, is(not(emptyOrNullString())));
        assertThat(email, is(not(emptyOrNullString())));
        assertThat(firstName, is(not(emptyOrNullString())));
        assertThat(lastName, is(not(emptyOrNullString())));
    }

    @Test
    public void createCouponsTest() {
        Response res = createCoupons(getCoupons());
        String c_Code = getCoupons().getCode();
        String c_Description = getCoupons().getDescription();
        String c_DiscountType = getCoupons().getDiscountType();
        String code = res.jsonPath().getString("data[0].code");
        String description = res.jsonPath().getString("data[0].description");
        String discountType = res.jsonPath().getString("data[0].discountType");
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");
        assertTrue(success);
        assertEquals(message, "Coupon created");
        assertFalse(data.isEmpty());
        assertEquals(code, c_Code);
        assertEquals(description, c_Description);
        assertEquals(discountType, c_DiscountType);
    }
}
