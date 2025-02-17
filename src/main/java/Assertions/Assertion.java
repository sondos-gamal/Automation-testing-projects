package Assertions;

import io.restassured.response.Response;
import org.testng.Assert;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class Assertion {

    private static final ObjectMapper objectMapper = new ObjectMapper();



    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
                "Expected status code " + expectedStatusCode + " but got " + response.getStatusCode());
    }


    public static void assertContentTypeJson(Response response) {
        String contentType = response.getContentType();
        Assert.assertTrue(contentType.contains("application/json"),
                "Expected JSON content type but got: " + contentType);
    }

    public static void assertPlaceName(Response response, String expectedPlaceName) {
        response.then().assertThat()
                .body("places[0].'place name'", equalTo(expectedPlaceName));
    }


    public static void assertResponseTime(Response response, long maxTimeMs) {
        Assert.assertTrue(response.getTime() <= maxTimeMs,
                "Response time exceeded: " + response.getTime() + "ms (Max: " + maxTimeMs + "ms)");
    }


}
