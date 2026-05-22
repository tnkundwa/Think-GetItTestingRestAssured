//package googleOauth2.tests;
//
//import googleOauth2.api.applicationApi.AuthApi;
//import io.qameta.allure.Description;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pojo.EmailBody;
//import pojo.Example;
//import pojo.SentEmailRes;
//
//import java.util.Base64;
//import java.util.HashMap;
//
//import static googleOauth2.api.SpecBuilder.getRequestSpec;
//import static googleOauth2.api.SpecBuilder.getResponseSpec;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//
//public class GoogleOauth {
//
//    private SentEmailRes sharedSentEmail;
//
//    public SentEmailRes getEmailSent(){
//        EmailBody email = new EmailBody("Toussaint NKUNDWA <tnkundwa9@gmail.com>", "Toussaint NKUNDWA <toussaintnkundwa@gmail.com>", "Testing now from the RestAssured End", "Damn it's working!");
//        return AuthApi.send(email);
//    }
//
//    @BeforeClass
//    public void setupEmail(){
//        sharedSentEmail = getEmailSent();
//    }
//
//    @Test
//    public void getUserProperties(){
//        given(getRequestSpec()).
//            when().
//                get("/users/{userid}/profile").
//            then().
//                spec(getResponseSpec()).
//                body("emailAddress", equalTo("tnkundwa9@gmail.com"));
//    }
//
//    @Test(enabled = false)
//    public void sendMessageUsingMap(){
//        String msg = "From: tnkundwa9@gmail.com\n" +
//                "To: toussaintnkundwa@gmail.com\n" +
//                "Subject: Testing the second Email\n" +
//                "\n" +
//                "Sending this form the the other side of the Gmail API";
//
//        String baseUrlEncoding = Base64.getUrlEncoder().encodeToString(msg.getBytes());
//
//        HashMap<String, String> payload = new HashMap<>();
//        payload.put("raw", baseUrlEncoding);
//
//        given(getRequestSpec()).
//                body(payload).
//            when().
//                post("/users/{userid}/messages/send").
//            then().
//                spec(getResponseSpec());
//    }
//
//    @Test
//    public void sendMessageUsingPojo(){
/// /        String msg = "From: tnkundwa9@gmail.com\n" +
/// /                "To: toussaintnkundwa@gmail.com\n" +
/// /                "Subject: Testing the second Email\n" +
/// /                "\n" +
/// /                "Sending this form the the other side of the Gmail API";
//
////        EmailBody email = new EmailBody("tnkundwa9@gmail.com", "toussaintnkundwa@gmail.com", "Testing the second Email", "Sending this form the the other side of the Gmail API but now using the POJO shittt!");
////
////        SentEmailRes response = EmailsApi.send(email);
//
////        String mimeString = email.getFormattedMime();
////        String baseUrlEncoding = Base64.getUrlEncoder().encodeToString(mimeString.getBytes());
////
////        MessageRequest requestPayload = new MessageRequest(baseUrlEncoding);
////
////
////        given(getRequestSpec()).
////                body(requestPayload).
////            when().
////                post("/users/{userid}/messages/send").
////            then().
////                spec(getResponseSpec());
//
//        assertThat(sharedSentEmail, hasProperty("id"));
//        assertThat(sharedSentEmail, hasProperty("threadId"));
//        assertThat(sharedSentEmail.getLabelIds(), hasItems("SENT"));
//    }
//
//    @Description("ohhhhhhh!")
//    @Test(testName = "getting a single email")
//    public void getEmail(){
//
////        Example getEmail = given(getRequestSpec()).
////                pathParams("id", "19d90106954b9031").
////            when().
////                get("users/{userid}/messages/{id}").
////            then().
////                spec(getResponseSpec()).
////                extract().as(Example.class);
//
//
//        String msgId = sharedSentEmail.getId();
//        String threadId = sharedSentEmail.getThreadId();
//        Example emailResponse = AuthApi.get(msgId);
//
//        // 1. Asserting Top-Level Fields
//        assertThat(emailResponse.getId(), equalTo(msgId));
//        assertThat(emailResponse.getThreadId(), equalTo(threadId));
//
//        // 2. Asserting the Snippet (the preview text seen in your console [1])
//        assertThat(emailResponse.getSnippet(), containsString("Damn"));
//
//        // 3. Asserting the Label List
//        // Since labelIds is a List<String> [1], we can check for specific values
////        assertThat(emailResponse.getLabelIds(), hasItems("UNREAD", "INBOX", "IMPORTANT"));
//        assertThat(emailResponse.getLabelIds(), hasItems("SENT"));
//
//        // 4. Asserting Nested Payload Data
//        // We go from Example -> Payload -> get field [1]
//        assertThat(emailResponse.getPayload().getMimeType(), equalTo("text/plain"));
//
//        // 5. Asserting Headers (Example: Checking the 'Delivered-To' header)
//        // We find the header in the list and check its value
//
//        String deliveredTo = emailResponse.getPayload().getHeaders().stream()
//                .filter(h -> h.getName().equals("To"))
//                .findFirst()
//                .get()
//                .getValue();
//
//        assertThat(deliveredTo, containsString("toussaintnkundwa@gmail.com"));
//    }
//}
