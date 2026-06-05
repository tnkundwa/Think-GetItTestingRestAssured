package com.think_get_it.tests;

import com.think_get_it.api.applicationApi.AuthApi;
import com.think_get_it.pojo.request.LoginUserReq;
import com.think_get_it.pojo.request.RegisterUser;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.pojo.response.UserDataPojo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests {

    @Test
    public void registerUser() {
        RegisterUser request = new RegisterUser();
        request.setEmail("jo12@x.com");
        request.setPassword("MyPass@123");
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setPhone("+250788123456");
        ResponsePojo<UserDataPojo> res = AuthApi.registerUser(request);
        Assert.assertNotNull(res, "The response should not be null");
    }

    @Test
    public void loginUser() {
        LoginUserReq request = new LoginUserReq();
        request.setEmail("tn@gmail.com");
        request.setPassword("Admin@123456");
        ResponsePojo<UserDataPojo> res = AuthApi.login(request);
        Assert.assertNotNull(res, "The response should not be null");
    }
}
