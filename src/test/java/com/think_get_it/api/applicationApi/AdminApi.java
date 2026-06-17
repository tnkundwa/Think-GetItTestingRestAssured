package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import com.think_get_it.pojo.request.CouponsPojo;
import io.restassured.response.Response;

import static com.think_get_it.api.SpecBuilder.getRequestSpec;
import static com.think_get_it.api.SpecBuilder.getResponseSpecLogin;
import static io.restassured.RestAssured.given;

public class AdminApi {

    public static Response getDashboardAnalytics() {
        return given(getRequestSpec())
                .when()
                .get(Routes.ADMIN + Routes.DASHBOARD)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static Response getAllUsers(int page, String search) {
        return given(getRequestSpec())
                .queryParam("page", page)
                .queryParam("search", search)
                .when()
                .get(Routes.ADMIN + Routes.USERS)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }

    public static Response createCoupons(CouponsPojo couponsPojo) {
        return given(getRequestSpec())
                .when()
                .body(couponsPojo)
                .post(Routes.ADMIN + Routes.COUPONS)
                .then()
                .spec(getResponseSpecLogin())
                .extract().response();
    }
}
