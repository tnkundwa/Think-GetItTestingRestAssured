package com.think_get_it.api.applicationApi;

import com.github.javafaker.Faker;
import com.think_get_it.pojo.request.CouponsPojo;
import com.think_get_it.pojo.request.LoginUserReq;
import com.think_get_it.pojo.request.RegisterUser;
import com.think_get_it.pojo.response.*;
import com.think_get_it.utils.ConfigLoader;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.think_get_it.api.applicationApi.OrderApi.getOrders;
import static com.think_get_it.api.applicationApi.ProductApi.getProducts;
import static com.think_get_it.api.applicationApi.UserApi.getUserAddress;

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

    public static String getProductIdInCart(int product) {
        ResponsePojo<CartDataPojo> res = CartApi.getCart().as(new TypeRef<ResponsePojo<CartDataPojo>>() {
        });
        List<ItemsPojo> allItems = res.getData().getItems();
        return allItems.get(product).getId();
    }

    public static String getAddressId() {
        AddressDataPojo data = getUserAddress();
        return data.getId();
    }


    public static Map<String, String> itemToOrder() {
        Map<String, String> request = new HashMap<>();
        request.put("addressId", getAddressId());
        request.put("paymentMethod", "CASH_ON_DELIVERY");
        request.put("notes", "Leave it and go home");
        request.put("shippingFee", "0");
        return request;
    }

    public static Map<String, Object> reviewToProduct() {
        Map<String, Object> request = new HashMap<>();
        request.put("rating", 5);
        request.put("title", "CASH_ON_DELIVERY");
        request.put("body", "Leave it and go home");
        return request;
    }

    public static CouponsPojo getCoupons() {
        CouponsPojo coupons = new CouponsPojo();
        coupons.setCode("SAVE21NOW");
        coupons.setDescription("description");
        coupons.setDiscountType("PERCENTAGE");
        coupons.setDiscountValue(1);
        coupons.setMinOrderAmount(100);
        coupons.setMaxUsers(10);
        coupons.setExpiresAt("2026-06-16T07:39:03.334Z");
        return coupons;
    }

    public static Map<String, Object> searchProduct() {
        Map<String, Object> request = new HashMap<>();
        request.put("searchQuery", "shoes");
        request.put("limit", 1);
        request.put("category", "home");
        request.put("minPrice", 1);
        request.put("maxPrice", 1000);
        request.put("sort", "newest");
        return request;
    }

    public static Map<String, Object> orderDetails() {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("page", 1);
        queryParams.put("status", "PENDING");
        return queryParams;
    }

    public static String getOrderId() {
        Response res = getOrders(orderDetails());
        return res.jsonPath().getString("data[0].id");
    }

}
