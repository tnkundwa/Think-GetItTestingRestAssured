package com.think_get_it.tests;

import com.think_get_it.api.applicationApi.CartApi;
import com.think_get_it.pojo.response.CartDataPojo;
import com.think_get_it.pojo.response.ResponsePojo;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

public class CartTests {

    @Test
    public void CartTest() {
        ResponsePojo<CartDataPojo> res = CartApi.getCart().as(new TypeRef<ResponsePojo<CartDataPojo>>() {
        });
        assertNotNull(res, "Response should not be null");
        assertEquals("Success", res.getMessage());
    }
}
