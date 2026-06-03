package com.think_get_it.tests;

import com.think_get_it.api.applicationApi.AuthApi;
import com.think_get_it.pojo.request.LoginUserReq;
import com.think_get_it.pojo.request.RegisterUser;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.pojo.response.UserDataPojo;
import com.think_get_it.utils.ConfigLoader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

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
        assertNotNull(res, "The response should not be null");
    }

    @Test
    public void loginUser() {
        LoginUserReq request = new LoginUserReq();
        request.setEmail(ConfigLoader.getInstance().getUserEmail());
        request.setPassword(ConfigLoader.getInstance().getPassword());
        ResponsePojo<UserDataPojo> res = AuthApi.login(request);
        assertNotNull(res, "The response should not be null");
    }
}
