package com.think_get_it.api.applicationApi;

import com.github.javafaker.Faker;
import com.think_get_it.pojo.request.LoginUserReq;
import com.think_get_it.pojo.request.RegisterUser;
import com.think_get_it.utils.ConfigLoader;

import java.util.HashMap;
import java.util.Map;

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
}
