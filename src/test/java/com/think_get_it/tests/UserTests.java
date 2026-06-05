package com.think_get_it.tests;

import com.think_get_it.api.applicationApi.UserApi;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.pojo.response.User;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserTests {
    @Test
    public void getCurrentUserTest() {
        ResponsePojo<User> res = UserApi.getCurrentUser();
        assertNotNull(res, "The response should not be null");
        assertThat(res.getSuccess(), is(true));
        assertEquals(res.getMessage(), "Success");
    }

    @Test
    public void updateUserProfileTest() {
        Map<String, String> request = new HashMap<>();
        request.put("firstName", "T");
        request.put("lastName", "N");
        request.put("phone", "+250788123456");
        ResponsePojo<User> res = UserApi.updateUser(request);
        assertNotNull(res, "The response should not be null");
        assertThat(res.getSuccess(), is(true));
        assertEquals(res.getMessage(), "Profile updated");
    }

    @Test
    public void changePasswordTest() {
        Map<String, String> request = new HashMap<>();
        request.put("currentPassword", "");
        request.put("newPassword", "");
        ResponsePojo<User> res = UserApi.changeUserPassword(request);
        assertNotNull(res, "The response should not be null");
        assertThat(res.getSuccess(), is(true));
        assertEquals(res.getMessage(), "Password changed");
    }
}
