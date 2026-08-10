package com.think_get_it.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.searchProduct;
import static com.think_get_it.api.applicationApi.SearchApi.getTrendingSearchItems;
import static com.think_get_it.api.applicationApi.SearchApi.searchForProduct;
import static org.testng.Assert.assertEquals;

public class SearchTests {

    @Test
    public void searchForProductTest() {
        Response res = searchForProduct(searchProduct());
        assertEquals(res.statusCode(), 200);
    }

    @Test
    public void leaveReviewTest() {
        Response res = getTrendingSearchItems();
        assertEquals(res.statusCode(), 200);
    }

}
