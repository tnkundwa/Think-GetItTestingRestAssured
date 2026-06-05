package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.pojo.response.User;
import io.restassured.common.mapper.TypeRef;

import java.util.Map;

import static com.think_get_it.api.SpecBuilder.getRequestSpec;
import static com.think_get_it.api.SpecBuilder.getResponseSpecLogin;
import static io.restassured.RestAssured.given;

public class UserApi {
    public static ResponsePojo<User> getCurrentUser() {
        return given(getRequestSpec())
                .when()
                .get(Routes.AUTH + Routes.ME)
                .then()
                .spec(getResponseSpecLogin())
                .extract()
                .response()
                .as(new TypeRef<ResponsePojo<User>>() {
                });
    }

    public static ResponsePojo<User> updateUser(Map<String, String> request) {
        return given(getRequestSpec())
                .when()
                .body(request)
                .put(Routes.USERS + Routes.PROFILE)
                .then()
                .spec(getResponseSpecLogin())
                .extract()
                .response()
                .as(new TypeRef<ResponsePojo<User>>() {
                });
    }

    public static ResponsePojo<User> changeUserPassword(Map<String, String> request) {
        return given(getRequestSpec())
                .when()
                .body(request)
                .put(Routes.USERS + Routes.CHANGE_PASSWORD)
                .then()
                .spec(getResponseSpecLogin())
                .extract()
                .response()
                .as(new TypeRef<ResponsePojo<User>>() {
                });
    }
}
