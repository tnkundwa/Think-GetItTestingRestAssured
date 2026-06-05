package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import com.think_get_it.pojo.response.ProductDataPojo;
import com.think_get_it.pojo.response.ResponsePojo;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

import static com.think_get_it.api.SpecBuilder.getRequestSpec;
import static com.think_get_it.api.SpecBuilder.getResponseSpecLogin;
import static io.restassured.RestAssured.given;

public class CategoryApi {

    public static Response getAllCategories() {

        return given(getRequestSpec()).
                when().
                get(Routes.CATEGORIES)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static String getRandomSlug() {
        ResponsePojo<List<ProductDataPojo>> allCategories = getAllCategories().as(new TypeRef<ResponsePojo<List<ProductDataPojo>>>() {
        });
        int randomSlug = new Random().nextInt(allCategories.getData().size());
        return allCategories.getData().get(randomSlug).getSlug();
    }

    public static Response getCategoryBySlug(String slug) {
        return given(getRequestSpec()).
                pathParam("slug", slug).
                when().
                get(Routes.CATEGORIES + "/{slug}")
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

}
