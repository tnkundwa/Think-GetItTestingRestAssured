//package exercise2;
//
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.filter.log.LogDetail;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static googleOauth2.api.TokenManager.getToken;
//import static io.restassured.RestAssured.given;
//
//public class DeleteEmail {
//
//    static String access_token = getToken();
//
//    @BeforeClass
//    public void setUp(){
//        RequestSpecBuilder requestSpecBuilder =  new RequestSpecBuilder();
//        requestSpecBuilder.setBaseUri("https://gmail.googleapis.com");
//        requestSpecBuilder.addHeader("Authorization", "Bearer " + access_token);
//        requestSpecBuilder.setBasePath("/gmail/v1");
//        requestSpecBuilder.addPathParam("userId", "tnkundwa9@gmail.com");
//        requestSpecBuilder.log(LogDetail.ALL);
//        RestAssured.requestSpecification = requestSpecBuilder.build();
//
//        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
//        responseSpecBuilder.log(LogDetail.ALL);
//        RestAssured.responseSpecification = responseSpecBuilder.build();
//    }
//
//    @Test
//    public void deleteEmail(){
//        given().
//                pathParams("id", "19d9c061554f706c").
//        when().
//                delete("/users/{userId}/messages/{id}").
//        then().
//                statusCode(204);
//    }
//}
