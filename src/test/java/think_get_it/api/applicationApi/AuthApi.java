package think_get_it.api.applicationApi;

import pojo.request.LoginUserReq;
import pojo.request.RegisterUser;
import pojo.response.UserResponse;
import think_get_it.api.Routes;

import static io.restassured.RestAssured.given;
import static think_get_it.api.SpecBuilder.getRequestSpec;
import static think_get_it.api.SpecBuilder.getResponseSpec;


public class AuthApi {

    public static UserResponse registerUser() {
        RegisterUser request = new RegisterUser();
        request.setEmail("jo12@x.com");
        request.setPassword("MyPass@123");
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setPhone("+250788123456");

        return given(getRequestSpec()).
                body(request).
                when().
                post("auth/register").
                then().
                spec(getResponseSpec()).
                extract().as(UserResponse.class);
    }

    public static UserResponse login() {
        LoginUserReq request = new LoginUserReq();
        request.setEmail("john@example.com");
        request.setPassword("MyPass@123");
        return given(getRequestSpec()).
                body(request).
                when().
                post(Routes.AUTH + Routes.LOGIN).
                then().
                spec(getResponseSpec()).
                extract().as(UserResponse.class);

    }
}
