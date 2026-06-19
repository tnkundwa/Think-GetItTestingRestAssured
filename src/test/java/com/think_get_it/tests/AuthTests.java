package com.think_get_it.tests;

import com.think_get_it.api.applicationApi.AuthApi;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.pojo.response.UserDataPojo;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.newUser;
import static com.think_get_it.api.applicationApi.RestResources.userLogin;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AuthTests {

    @Test
    public void registerUser() {
        ResponsePojo<UserDataPojo> res = AuthApi.registerUser(newUser());
        String id = res.getData().getUser().getId();
        String token = res.getData().getToken();
        String refreshToken = res.getData().getRefreshToken();
        String email = newUser().getEmail();
        String firstName = newUser().getFirstName();
        String lastName = newUser().getLastName();
        assertTrue(res.getSuccess());
        assertEquals(res.getMessage(), "Registration successful. Check your email to verify.");
        assertThat(id, is(not(emptyOrNullString())));
        assertEquals(res.getData().getUser().getEmail(), email);
        assertEquals(res.getData().getUser().getFirstName(), firstName);
        assertEquals(res.getData().getUser().getLastName(), lastName);
        assertThat(token, is(not(emptyOrNullString())));
        assertThat(refreshToken, is(not(emptyOrNullString())));
    }

    @Test
    public void loginUser() {
        ResponsePojo<UserDataPojo> res = AuthApi.login(userLogin());
        String id = res.getData().getUser().getId();
        String token = res.getData().getToken();
        String refreshToken = res.getData().getRefreshToken();
        String email = newUser().getEmail();
        String firstName = newUser().getFirstName();
        String lastName = newUser().getLastName();
        assertTrue(res.getSuccess());
        assertEquals(res.getMessage(), "Login successful");
        assertThat(id, is(not(emptyOrNullString())));
        assertEquals(res.getData().getUser().getEmail(), email);
        assertEquals(res.getData().getUser().getFirstName(), firstName);
        assertEquals(res.getData().getUser().getLastName(), lastName);
        assertThat(token, is(not(emptyOrNullString())));
        assertThat(refreshToken, is(not(emptyOrNullString())));
    }
}
