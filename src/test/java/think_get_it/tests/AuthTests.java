package think_get_it.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.response.UserResponse;
import think_get_it.api.applicationApi.AuthApi;

public class AuthTests {

    @Test
    public void registerUser() {
        UserResponse res = AuthApi.registerUser();
        Assert.assertNotNull(res, "The response should not be null");
    }

    @Test
    public void loginUser() {
        UserResponse res = AuthApi.login();
        Assert.assertNotNull(res, "The response should not be null");
    }
}
