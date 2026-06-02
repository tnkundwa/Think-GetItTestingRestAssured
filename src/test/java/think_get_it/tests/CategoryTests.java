package think_get_it.tests;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.response.ProductDataPojo;
import pojo.response.ResponsePojo;
import think_get_it.api.applicationApi.CategoryApi;

import java.util.List;

import static org.testng.Assert.*;


public class CategoryTests {

    @Test
    public void testCartPage() {
        ResponsePojo<List<ProductDataPojo>> res = CategoryApi.getAllCategories().as(new TypeRef<ResponsePojo<List<ProductDataPojo>>>() {
        });
        assertNotNull(res, "The response should not be null");
    }

    @Test
    public void testGetCategoryByValidSlug() {
        String slug = CategoryApi.getRandomSlug();
        Response res = CategoryApi.getCategoryBySlug(slug);
        assertNotNull(res, "Response should not be null");

        ResponsePojo<ProductDataPojo> categoryResult = res.as(new TypeRef<ResponsePojo<ProductDataPojo>>() {
        });
        assertTrue(categoryResult.getSuccess(), "API success flag should be true");
        assertEquals(res.getStatusCode(), 200, "API response status code should be 200");
        assertEquals(categoryResult.getData().getSlug(), slug, "API response slug should be slug");
    }
}
