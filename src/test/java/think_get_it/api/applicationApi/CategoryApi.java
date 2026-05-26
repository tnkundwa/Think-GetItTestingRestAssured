package think_get_it.api.applicationApi;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import pojo.response.ProductDataPojo;
import pojo.response.ResponsePojo;
import think_get_it.api.Routes;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static think_get_it.api.SpecBuilder.getRequestSpec;

public class CategoryApi {

    public static Response getAllCategories() {

        return given(getRequestSpec()).
                when().
                get(Routes.CATEGORIES);
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
                get(Routes.CATEGORIES + "/{slug}");
    }

}
