package think_get_it.tests;

import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;
import pojo.response.ProductsEndPointData;
import pojo.response.ResponsePojo;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static think_get_it.api.applicationApi.ProductApi.getProducts;

public class ProductsTests {
    String targetCategory = "home-living";

    @Test
    public void verifyPaginationLimitsItems() {
        int limit = 20;

        getProducts(1, 20, targetCategory)
                .then()
                .body("success", equalTo(true))
                .body("message", equalTo("Success"))
                .body("data.size()", equalTo(limit));
    }

    @Test
    public void verifyCategoryFiltering() {

        getProducts(1, 10, targetCategory)
                .then()
                .body("data.isActive", everyItem(equalTo(true)))
                .body("data.category.slug", everyItem(equalTo(targetCategory)));
    }

    @Test
    public void getOneProductBySlug() {

        ResponsePojo<List<ProductsEndPointData>> response = getProducts(1, 10, targetCategory)
                .then()
                .extract()
                .as(new TypeRef<ResponsePojo<List<ProductsEndPointData>>>() {
                });

        assertThat(response.getSuccess(), equalTo(true));
        assertThat(response.getMessage(), equalTo("Success"));
        assertThat(response.getPagination().getLimit(), equalTo(10));
        List<ProductsEndPointData> data = response.getData();
        assertThat(data.size(), equalTo(10));
        assertThat(data.get(0).getName(), equalTo("Ultrasonic Aroma Diffuser"));
        assertThat(data.get(0).getInventory().getTotalStock(), equalTo(94));
    }
}