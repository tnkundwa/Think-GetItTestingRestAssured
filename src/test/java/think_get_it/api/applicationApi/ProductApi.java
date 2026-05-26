package think_get_it.api.applicationApi;

import io.restassured.response.Response;
import think_get_it.api.Routes;

import static io.restassured.RestAssured.given;
import static think_get_it.api.SpecBuilder.getRequestSpec;

public class ProductApi {

    public static Response getProducts(Integer pageNumber, Integer limit, String category) {
        return given(getRequestSpec()).
                queryParam("page", pageNumber).
                queryParam("limit", limit).
                queryParam("category", category).
                when().
                get(Routes.PRODUCTS);
    }
}
