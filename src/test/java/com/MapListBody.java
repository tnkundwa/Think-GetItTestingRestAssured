package com;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MapListBody {

    @BeforeClass
    public void setUp() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://14a113e7-9211-4dfb-9c5b-acb2de95fbff.mock.pstmn.io");
        requestSpecBuilder.addHeader("Content-Type", "application/json;charset=utf-8");
        requestSpecBuilder.log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();


        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void mapListBodyTest() {

        List<Integer> rgbaList = Arrays.asList(225, 225, 225, 1);

        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("rgba", rgbaList);
        codeMap.put("hex", "#000");

        Map<String, Object> upperMap = new HashMap<>();
        upperMap.put("color", "black");
        upperMap.put("category", "hue");
        upperMap.put("type", "primary");
        upperMap.put("code", codeMap);

        List<Integer> rgbaList2 = Arrays.asList(0, 0, 0, 1);

        Map<String, Object> codeMap2 = new HashMap<>();
        codeMap2.put("rgba", rgbaList2);
        codeMap2.put("hex", "#FFF");

        Map<String, Object> lowerMap = new HashMap<>();
        lowerMap.put("color", "white");
        lowerMap.put("category", "value");
        lowerMap.put("code", codeMap2);

        List<Map<String, Object>> colorsList = new ArrayList<>();
        colorsList.add(upperMap);
        colorsList.add(lowerMap);

        Map<String, List<Map<String, Object>>> reqBody = new HashMap<>();
        reqBody.put("colors", colorsList);

        given().
                body(reqBody).
                when().
                post("/post").
                then().
                assertThat().
                body("message", equalTo("success!"));
    }

}
