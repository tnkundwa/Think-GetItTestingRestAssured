package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.searchProduct;
import static com.think_get_it.api.applicationApi.SearchApi.getTrendingSearchItems;
import static com.think_get_it.api.applicationApi.SearchApi.searchForProduct;
import static org.testng.Assert.*;

public class SearchTests {

    @Test
    public void searchForProductTest() {
        Response res = searchForProduct(searchProduct());
        String query = searchProduct().get("searchQuery").toString();
        String minPriceStr = searchProduct().get("minPrice").toString();
        String maxPriceStr = searchProduct().get("maxPrice").toString();
        String description = res.jsonPath().getString("data[0].description");
        Double price = res.jsonPath().get("data[0].price");
        Double comparePrice = res.jsonPath().get("data[0].comparePrice");
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");

        double minPrice = Double.parseDouble(minPriceStr);
        double maxPrice = Double.parseDouble(maxPriceStr);

        assertTrue(success);
        assertFalse(data.isEmpty());
        assertEquals(message, "Success");
        assertTrue(description.contains(query));

        assertTrue(price >= minPrice && price <= maxPrice, "Price (" + price + ") is not between " + minPrice + " and " + maxPrice);
        assertTrue(comparePrice >= minPrice && comparePrice <= maxPrice, "Compare Price (" + comparePrice + ") is not between " + minPrice + " and " + maxPrice);

    }

    @Test
    public void searchForTrendingProductsTest() {
        Response res = getTrendingSearchItems();
        boolean success = res.jsonPath().getBoolean("success");
        String message = res.jsonPath().getString("message");
        java.util.Map<Object, Object> data = res.jsonPath().getMap("data");
        assertTrue(success);
        assertEquals(message, "Success");
        assertFalse(data.isEmpty());
    }

}
