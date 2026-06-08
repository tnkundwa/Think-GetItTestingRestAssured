package com.think_get_it.api.applicationApi;

import com.github.javafaker.Faker;
import com.think_get_it.pojo.request.LoginUserReq;
import com.think_get_it.pojo.request.RegisterUser;
import com.think_get_it.pojo.response.ProductsEndPointData;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.utils.ConfigLoader;
import io.restassured.common.mapper.TypeRef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.think_get_it.api.applicationApi.ProductApi.getProducts;

public class RestResources {


    public static RegisterUser newUser() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phone = faker.phoneNumber().phoneNumber();


        RegisterUser request = new RegisterUser();
        request.setEmail(email);
        request.setPassword(password);
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setPhone(phone);
        return request;
    }

    public static LoginUserReq userLogin() {
        LoginUserReq request = new LoginUserReq();
        request.setEmail(ConfigLoader.getInstance().getUserEmail());
        request.setPassword(ConfigLoader.getInstance().getPassword());
        return request;
    }

    public static Map<String, String> userUpdate() {
        Map<String, String> request = new HashMap<>();
        request.put("firstName", "T");
        request.put("lastName", "N");
        request.put("phone", "+250788123456");
        return request;
    }

    public static Map<String, String> userChangePassword() {
        Map<String, String> request = new HashMap<>();
        request.put("currentPassword", "");
        request.put("newPassword", "");
        return request;
    }

    public static Map<String, String> getProductDetails(String productName) {
        String quantity = "2";
        Map<String, String> request = new HashMap<>();
        request.put("quantity", quantity);
        ResponsePojo<List<ProductsEndPointData>> res = getProducts(1, 10, "home-living")
                .then()
                .extract()
                .as(new TypeRef<ResponsePojo<List<ProductsEndPointData>>>() {
                });
        List<ProductsEndPointData> list = res.getData();
        ProductsEndPointData singleProduct = list.stream().filter(product -> product.getName().equals(productName)).findFirst().orElse(null);
        if (singleProduct != null) {
            request.put("productId", singleProduct.getId());
            request.put("variantId", singleProduct.getName());
        } else {
            throw new RuntimeException("Product not found with name: " + productName);
        }
        return request;
    }

    public static String getProductId(String productName) {
        ResponsePojo<List<ProductsEndPointData>> res = getProducts(1, 10, "home-living")
                .then()
                .extract()
                .as(new TypeRef<ResponsePojo<List<ProductsEndPointData>>>() {
                });
        List<ProductsEndPointData> list = res.getData();
        ProductsEndPointData singleProduct = list.stream().filter(product -> product.getName().equals(productName)).findFirst().orElse(null);
        return singleProduct.getId();
    }
}
