package com.think_get_it.api.applicationApi;

import com.think_get_it.api.Routes;
import com.think_get_it.pojo.request.LoginUserReq;
import com.think_get_it.pojo.request.RegisterUser;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.pojo.response.UserDataPojo;

import static com.think_get_it.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;


public class AuthApi {

    @SuppressWarnings("unchecked")
    public static ResponsePojo<UserDataPojo> registerUser(RegisterUser request) {
        return given(getRequestSpec()).
                body(request).
                when().
                post(Routes.AUTH + Routes.REGISTER).
                then().
                spec(getResponseSpecCreate()).
                extract().as(ResponsePojo.class);
    }

    @SuppressWarnings("unchecked")
    public static ResponsePojo<UserDataPojo> login(LoginUserReq request) {
        return given(getRequestSpec()).
                body(request).
                when().
                post(Routes.AUTH + Routes.LOGIN).
                then().
                spec(getResponseSpecLogin()).
                extract().as(ResponsePojo.class);

    }
}
