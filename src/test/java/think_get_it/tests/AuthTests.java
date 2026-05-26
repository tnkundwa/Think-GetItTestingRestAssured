package think_get_it.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.response.ResponsePojo;
import pojo.response.UserDataPojo;
import think_get_it.api.applicationApi.AuthApi;

public class AuthTests {

    @Test
    public void registerUser() {
        ResponsePojo<UserDataPojo> res = AuthApi.registerUser();
        Assert.assertNotNull(res, "The response should not be null");
    }

    @Test
    public void loginUser() {
        ResponsePojo<UserDataPojo> res = AuthApi.login();
        Assert.assertNotNull(res, "The response should not be null");
    }
}
