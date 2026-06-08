package com.think_get_it.tests;

import com.think_get_it.api.applicationApi.CartApi;
import com.think_get_it.pojo.response.CartDataPojo;
import com.think_get_it.pojo.response.ProductAddedToCartPojo;
import com.think_get_it.pojo.response.ResponsePojo;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.getProductDetails;
import static com.think_get_it.api.applicationApi.RestResources.getProductId;
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

    @Test
    public void addToCartTest() {
        Response res = CartApi.addCart(getProductDetails("Ubrtiuob"));
        ProductAddedToCartPojo productAddedToCart = res.getBody().as(ProductAddedToCartPojo.class);
        assertEquals("true", productAddedToCart.getSuccess());
        assertEquals("Item added to cart", productAddedToCart.getMessage());
    }

    @Test
    public void updateCartItemQuantityTest() {
        Response res = CartApi.updateCartQuantity("5", getProductId("Ubrtiuob"));
    }

    @Test
    public void deleteItemFromCartTest() {
        Response res = CartApi.deleteItemFromCart(getProductId("Ubrtiuob"));
    }
}
