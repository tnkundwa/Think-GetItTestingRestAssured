package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.OrderApi.*;
import static com.think_get_it.api.applicationApi.RestResources.*;
import static org.testng.Assert.assertEquals;

public class OrderTests {

    @Test
    public void placeOrderTest() {
        Response res = placeNewOrder(itemToOrder());
        assertEquals(res.statusCode(), 201);
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
