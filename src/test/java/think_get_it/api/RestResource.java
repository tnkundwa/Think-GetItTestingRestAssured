//package googleOauth2.api;
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import pojo.EmailBody;
//import pojo.Example;
//import pojo.MessageRequest;
//
//import java.util.Base64;
//import java.util.HashMap;
//
//import static googleOauth2.api.SpecBuilder.*;
//import static io.restassured.RestAssured.given;
//
////These are reussable across every api
//public class RestResource {
//
//    public static Response send(EmailBody email, String userid){
//
//        String mimeString = email.getFormattedMime();
//        String baseUrlEncoding = Base64.getUrlEncoder().encodeToString(mimeString.getBytes());
//
//        MessageRequest requestPayload = new MessageRequest(baseUrlEncoding);
//
//        return given(getRequestSpec()).
//                body(requestPayload).
//            when().
//                post("/users/"+ userid + "/messages/send").
//            then().
//                spec(getResponseSpec()).
//                extract().response();
//    }
//
//    public static Example get(String messageId, String userid){
//        return given(getRequestSpec()).
//                pathParams("id", messageId).
//            when().
//                get("users/" + userid + "/messages/" + messageId).
//            then().
//                spec(getResponseSpec()).
//                extract().as(Example.class);
//    }
//
//    public static Response postAccount(HashMap<String, String> formParams){
////        return
////                given().
////                    baseUri("https://oauth2.googleapis.com").
////                    contentType(ContentType.URLENC).
////                    formParams(formParams).
////                    log().all().
////                when().
////                    post("/token").
////                then().
////                    spec(getResponseSpec()).
////                    extract().
////                    response();
//
//
//        //this is using the new requestspec
//        return
//                given(getAccountRequestSpec()).
//                    formParams(formParams).
//                when().
//                    post("/token").
//                then().
//                    spec(getResponseSpec()).
//                    extract().
//                    response();
//
//    }
//
//}
