package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.data.ApiSpecification;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserSteps {
    private Response response;

    public UserSteps createUser(String email, String name, String password, String avatar) {
        String body = """
                {
                    "email": "%s",
                    "name": "%s",
                    "password": "%s",
                    "avatar": "%s"
                }
                """.formatted(email, name, password, avatar);

        response = given()
                .spec(ApiSpecification.getRequestSpecification())
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/v1/users");

        response.then().log().all().statusCode(201);
        return this;
    }

}

