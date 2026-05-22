package think_get_it.tests;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FormAuthentication {

    @BeforeClass
    public void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setBaseUri("https://localhost:8443").
                setRelaxedHTTPSValidation().
                build();
    }

    @Test
    public void form_authentication_using_csrf_token() {
        SessionFilter filter = new SessionFilter();
        given().
                auth().form("dan", "dan123", new FormAuthConfig("/signin", "txtUsername", "txtPassword").withAdditionalField("_csrf")).
                filter(filter).
                log().all().
                when().
                get("/login").
                then().
                log().all().assertThat().statusCode(200);

        given().
                sessionId(filter.getSessionId()).
                log().all().
                when().
                get("/profile/index").
                then().
                log().all().assertThat().statusCode(200).
                body("html.body.div.p", equalTo("java -jar springboot-security-forms-0.0.1-SNAPSHOT.jar"));
    }

    @Test
    public void form_authentication_using_csrf_token_cookie_example() {
        SessionFilter filter = new SessionFilter();
        given().
                auth().form("dan", "dan123", new FormAuthConfig("/signin", "txtUsername", "txtPassword").withAdditionalField("_csrf")).
                filter(filter).
                log().all().
                when().
                get("/login").
                then().
                log().all().assertThat().statusCode(200);

        Cookie cookie = new Cookie.Builder("JSESSIONID", filter.getSessionId()).setHttpOnly(true).setSecured(true).setComment("my damn cookie").build();
        Cookie cookie1 = new Cookie.Builder("dummy", "dummyValue").build();
        Cookies cookies = new Cookies(cookie, cookie1);

        given().
//                cookie("JSESSIONID", filter.getSessionId()).
//                cookie(cookie).
        cookies(cookies).
                log().all().
                when().
                get("/profile/index").
                then().
                log().all().assertThat().statusCode(200).
                body("html.body.div.p", equalTo("java -jar springboot-security-forms-0.0.1-SNAPSHOT.jar"));
    }
}
