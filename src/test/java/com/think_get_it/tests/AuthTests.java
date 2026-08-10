package com.think_get_it.tests;

import com.think_get_it.api.applicationApi.AuthApi;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.pojo.response.UserDataPojo;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.newUser;
import static com.think_get_it.api.applicationApi.RestResources.userLogin;
import static org.testng.Assert.assertNotNull;

public class AuthTests {

    @Test
    public void registerUser() {
        ResponsePojo<UserDataPojo> res = AuthApi.registerUser(newUser());
        assertNotNull(res, "The response should not be null");
    }

    @Test
    public void loginUser() {
        ResponsePojo<UserDataPojo> res = AuthApi.login(userLogin());
        assertNotNull(res, "The response should not be null");
    }
}
