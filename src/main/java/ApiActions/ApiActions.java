package ApiActions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiActions {

    public static Response sendGetRequest(String url) {
        return RestAssured.get(url);
    }
}
