package think_get_it.api.applicationApi;

import pojo.request.LoginUserReq;
import pojo.request.RegisterUser;
import pojo.response.ResponsePojo;
import pojo.response.UserDataPojo;
import think_get_it.api.Routes;

import static io.restassured.RestAssured.given;
import static think_get_it.api.SpecBuilder.*;


public class AuthApi {

    @SuppressWarnings("unchecked")
    public static ResponsePojo<UserDataPojo> registerUser() {
        RegisterUser request = new RegisterUser();
        request.setEmail("jo12@x.com");
        request.setPassword("MyPass@123");
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setPhone("+250788123456");

        return given(getRequestSpec()).
                body(request).
                when().
                post(Routes.AUTH + Routes.REGISTER).
                then().
                spec(getResponseSpecCreate()).
                extract().as(ResponsePojo.class);
    }

    @SuppressWarnings("unchecked")
    public static ResponsePojo<UserDataPojo> login() {
        LoginUserReq request = new LoginUserReq();
        request.setEmail("john@example.com");
        request.setPassword("MyPass@123");
        return given(getRequestSpec()).
                body(request).
                when().
                post(Routes.AUTH + Routes.LOGIN).
                then().
                spec(getResponseSpecLogin()).
                extract().as(ResponsePojo.class);

    }
}
