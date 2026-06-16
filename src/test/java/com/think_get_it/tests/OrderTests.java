package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.OrderApi.*;
import static com.think_get_it.api.applicationApi.RestResources.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderTests {

    @Test
    public void placeOrderTest() {
        Response res = placeNewOrder(itemToOrder());
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        assertTrue(success);
        assertEquals(message, "Order placed successfully");
    }

    @Test
    public void getOrderTest() {
        Response res = getOrders(orderDetails());
        assertEquals(res.statusCode(), 200);
    }

    @Test
    public void getSingleOrderTest() {
        Response res = getSingleOrder(getProductId("Ubrtiuob"));
        assertEquals(res.statusCode(), 200);
    }

    @Test
    public void cancelOrderTest() {
        Response res = cancelOrder(getProductId("Ubrtiuob"));
        assertEquals(res.statusCode(), 200);
    }
}
