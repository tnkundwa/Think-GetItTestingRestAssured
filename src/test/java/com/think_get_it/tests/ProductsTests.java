package com.think_get_it.tests;

import com.think_get_it.pojo.response.ProductsEndPointData;
import com.think_get_it.pojo.response.ResponsePojo;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static com.think_get_it.api.applicationApi.ProductApi.getProductBySlug;
import static com.think_get_it.api.applicationApi.ProductApi.getProducts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;

public class ProductsTests {
    @Test
    public void verifyPaginationLimitsItems() {
        int limit = 20;

        getProducts(1, 20, "home-living")
                .then()
                .body("success", equalTo(true))
                .body("message", equalTo("Success"))
                .body("data.size()", equalTo(limit));
    }

    @Test
    public void verifyCategoryFiltering() {
        String targetCategory = "home-living";

        getProducts(1, 10, "home-living")
                .then()
                .body("data.category.slug", everyItem(equalTo("home-living")))
                .body("data.isActive", everyItem(equalTo(true)))
                .body("data.category.slug", everyItem(equalTo(targetCategory)));
    }

    @Test
    public void getOneProductBySlug() {

        ResponsePojo<List<ProductsEndPointData>> res = getProducts(1, 10, "home-living")
                .then()
                .extract()
                .as(new TypeRef<ResponsePojo<List<ProductsEndPointData>>>() {
                });

        int randomSlug = new Random().nextInt(res.getData().size());

        String slug = res.getData().get(randomSlug).getSlug();

        ResponsePojo<ProductsEndPointData> response = getProductBySlug(slug).then()
                .extract()
                .as(new TypeRef<ResponsePojo<ProductsEndPointData>>() {
                });

        assertThat(response.getSuccess(), equalTo(true));
        assertThat(response.getMessage(), equalTo("Success"));
        List<ProductsEndPointData> data = res.getData();
        assertThat(data.size(), equalTo(10));
        assertThat(data.get(0).getName(), equalTo("Ultrasonic Aroma Diffuser"));
        assertThat(data.get(0).getInventory().getTotalStock(), equalTo(94));
    }
}