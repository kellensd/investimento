package test;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public abstract class BaseTest {

    @BeforeClass
    public static void preCondicao() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "http://5b847b30db24a100142dce1b.mockapi.io";
        basePath = "/api/v1";
    }
}