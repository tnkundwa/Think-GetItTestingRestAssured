package com.think_get_it.tests;

import com.think_get_it.api.applicationApi.UserApi;
import com.think_get_it.pojo.response.ResponsePojo;
import com.think_get_it.pojo.response.User;
import org.testng.annotations.Test;

import static com.think_get_it.api.applicationApi.RestResources.userChangePassword;
import static com.think_get_it.api.applicationApi.RestResources.userUpdate;
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
        ResponsePojo<User> res = UserApi.updateUser(userUpdate());
        assertNotNull(res, "The response should not be null");
        assertThat(res.getSuccess(), is(true));
        assertEquals(res.getMessage(), "Profile updated");
    }

    @Test
    public void changePasswordTest() {
        ResponsePojo<User> res = UserApi.changeUserPassword(userChangePassword());
        assertNotNull(res, "The response should not be null");
        assertThat(res.getSuccess(), is(true));
        assertEquals(res.getMessage(), "Password changed");
    }
}
