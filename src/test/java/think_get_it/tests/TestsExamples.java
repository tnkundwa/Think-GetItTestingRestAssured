package think_get_it.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestsExamples {
    RequestSpecification requestSpecification;

//    @BeforeTest
//    public void beforeClass() throws FileNotFoundException {
//        PrintStream FileOutPutStream = new PrintStream(new File("restAssured.log"));
//
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
//                setBaseUri("https://dummyjson.com").
//                addHeader("accessToken", getToken()).
//                setContentType(ContentType.JSON).
//                addFilter(new RequestLoggingFilter(FileOutPutStream)).
//                addFilter(new ResponseLoggingFilter(FileOutPutStream));
//                log(LogDetail.ALL);
//        RestAssured.requestSpecification = requestSpecBuilder.build();
//
//        ResponseSpecBuilder responseSpecBuilder = new  ResponseSpecBuilder().
//                expectStatusCode(200).
//                expectContentType(ContentType.JSON).
//                log(LogDetail.ALL);
//        RestAssured.responseSpecification = responseSpecBuilder.build();
//    }

    @Test
    public void testWithApiKey() {
        String hold = "{\n" +
                "    \"firstName\": \"nkundwa\",\n" +
                "    \"lastName\": \"fidele\",\n" +
                "    \"age\": \"65\",\n" +
                "    \"email\": \"nfidele@gmail.com\"\n" +
                "}";

        Response response = with().body(hold).post("/users/add");
        assertThat(response.path("firstName"), is("nkundwa"));
        assertThat(response.path("lastName"), is("fidele"));


        given().body(hold).
                when().post("/users/add").
                then().assertThat().body("firstName", equalTo("nkundwa")).body("lastName", equalTo("fidele"));
    }

    @Test
    public void putTest() {
        String hold = "{\n" +
                "    \"firstName\": \"Janet\",\n" +
                "    \"age\": 31\n" +
                "}\n";

//        Response response = with().body(hold).put("/users/1");
//        assertThat(response.path("firstName"), is("Janet"));
//        assertThat(response.path("age"), is("31"));

        given().body(hold).
                when().put("/users/1").
                then().assertThat().body("firstName", equalTo("Janet")).body("age", equalTo(31));

    }


    @Test
    public void single_query_parameter() {
        given().baseUri("https://postman-echo.com/").
//                queryParam("foo1", "boo1").
        log().all().
                when().
                get("/get").
                then().log().all().assertThat().statusCode(200).
                body(matchesJsonSchemaInClasspath("EchoGet.json"));
    }

    @Test
    public void loggingFilter() throws FileNotFoundException {
//        PrintStream FileOutPutStream = new PrintStream(new File("restAssured.log"));
        given(requestSpecification).
                baseUri("https://postman-echo.com/").
//                filter(new RequestLoggingFilter(FileOutPutStream)).
//                filter(new ResponseLoggingFilter(FileOutPutStream)).
        when().
                get("/get").
                then().spec(responseSpecification).
                assertThat().
                statusCode(200);
    }

}
