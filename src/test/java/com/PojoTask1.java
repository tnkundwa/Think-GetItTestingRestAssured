//package exercise2;
//
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.http.ContentType;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pojo2.AddressPojo;
//import pojo2.BodyPojo;
//import pojo2.GeoPojo;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.notNullValue;
//
//public class PojoTask1 {
//
//    @BeforeClass
//    public void setUp(){
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        requestSpecBuilder.setBaseUri("https://jsonplaceholder.typicode.com");
//        requestSpecBuilder.addHeader("Content-Type", "application/json;charset=utf-8");
//        requestSpecBuilder.log(LogDetail.ALL);
//        RestAssured.requestSpecification = requestSpecBuilder.build();
//
//
//        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
//        responseSpecBuilder.expectStatusCode(201);
//        responseSpecBuilder.expectContentType(ContentType.JSON);
//        responseSpecBuilder.log(LogDetail.ALL);
//        RestAssured.responseSpecification = responseSpecBuilder.build();
//    }
//
//    @Test
//    public void PojoBody(){
//        GeoPojo geoPojo = new GeoPojo("-37.3159", "81.1496");
//        AddressPojo addressPojo = new AddressPojo("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", geoPojo);
//        BodyPojo bodyPojo = new BodyPojo("Leanne Graham", "Bret", "Sincere@april.biz", addressPojo);
//        given().
//                body(bodyPojo).
//                when().
//                post("/users").
//                then().
//                assertThat().
//                body("id", notNullValue());
//    }
//}
