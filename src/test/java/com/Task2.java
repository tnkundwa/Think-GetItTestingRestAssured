import io.restassured.path.json.JsonPath;
import java.util.*;

public class Task2 {
    static List<String> allKeys = new ArrayList<>();
    static List<Object> allValues = new ArrayList<>();

    public static void main(String[] args) {
        String jsonString = "[{\"k\":[1,3,5],\"k1\":{\"k10\":4,\"k11\":[4,7,9],\"k12\":{\"k120\":{\"k121\":\"v121\"}},\"k14\":6}},{\"k22\":{\"k221\":\"v122\"}}]";

        // Use RestAssured's JsonPath to parse the string into a List of Maps
        List<Map<String, Object>> rootList = JsonPath.from(jsonString).get();

        // 1. Loop through the list (the Entry Point)
        for (Map<String, Object> item : rootList) {
            parseObject(item);
        }

        System.out.println("keys = " + allKeys);
        System.out.println("values = " + allValues);
    }

    // 2. The Recursive Method using standard Java Map
    public static void parseObject(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            allKeys.add(key); // Always add the key

            if (value instanceof Map) {
                // If it's a Map, dive deeper
                parseObject((Map<String, Object>) value);
            } else {
                // If it's a list or a single value, store it
                allValues.add(value);
            }
        }
    }
}