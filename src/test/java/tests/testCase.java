package tests;

import ApiActions.ApiActions;
import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Assertions.Assertion;

public class testCase extends TestBase {

    @DataProvider(name = "Apidata")
    public static Object[][] mydata() {
        return new Object[][] {

                { "us", "90210", "Beverly Hills" },
                { "us", "10001", "New York" },
                { "us", "60601", "Chicago" },
                { "ca", "B2R", "Waverley" },
                { "ca", "M5A", "Toronto" },
                { "gb", "SW1A 1AA", "London" },
                { "de", "10115", "Berlin" },
                { "fr", "75001", "Paris" },
                { "jp", "100-0001", "Tokyo" }
        };
    }

    @Test(dataProvider = "Apidata")
    public void testValidZipCode(String country, String zipCode, String expectedPlaceName) {
        String endpoint = country + "/" + zipCode;
        Response response = ApiActions.sendGetRequest(endpoint);

        Assertion.assertStatusCode(response, 200);
        Assertion.assertContentTypeJson(response);
        Assertion.assertPlaceName(response, expectedPlaceName);
        Assertion.assertResponseTime(response, 2000);
    }
}
