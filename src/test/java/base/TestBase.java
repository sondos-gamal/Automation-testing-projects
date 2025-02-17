package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import config.config;

public class TestBase {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = config.getBaseURL();
    }
}
