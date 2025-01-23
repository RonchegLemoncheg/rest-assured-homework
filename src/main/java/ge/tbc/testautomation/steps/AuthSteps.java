package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.data.ApiSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthSteps {
    private Response response;
    private String accessToken;
    private String refreshToken;

    public AuthSteps login(String email, String password) {
        String body = """
            {
                "email": "%s",
                "password": "%s"
            }
            """.formatted(email, password);

        response = given()
                .spec(ApiSpecification.getRequestSpecification())
                .body(body)
                .when()
                .post("/v1/auth/login");

        response.then().log().all().statusCode(201);

        accessToken = response.jsonPath().getString("access_token");
        refreshToken = response.jsonPath().getString("refresh_token");
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}

