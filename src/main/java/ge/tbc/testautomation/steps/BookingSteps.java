package ge.tbc.testautomation.steps;
import ge.tbc.testautomation.data.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class BookingSteps {

    private static final String BASE_URL = Constants.BOOKER_HEROKU;;
    private String token;
    private int bookingId;

    public BookingSteps authenticate(String username, String password) {
        String authPayload = """
                {
                    "username": "%s",
                    "password": "%s"
                }
                """.formatted(username, password);

        Response authResponse = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(authPayload)
                .when()
                .post("/auth");

        authResponse.then().statusCode(200).log().all();
        this.token = authResponse.jsonPath().getString("token");
        return this;
    }

    public BookingSteps createBooking(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkin, String checkout, String additionalNeeds) {
        String bookingPayload = """
                {
                    "firstname": "%s",
                    "lastname": "%s",
                    "totalprice": %d,
                    "depositpaid": %b,
                    "bookingdates": {
                        "checkin": "%s",
                        "checkout": "%s"
                    },
                    "additionalneeds": "%s"
                }
                """.formatted(firstName, lastName, totalPrice, depositPaid, checkin, checkout, additionalNeeds);

        Response createResponse = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .when()
                .post("/booking");

        createResponse.then().statusCode(200);
        this.bookingId = createResponse.jsonPath().getInt("bookingid");

        validateBooking(firstName, lastName, totalPrice);
        return this;
    }

    public BookingSteps partialUpdateBooking(String firstName, String lastName) {
        String updatePayload = """
                {
                    "firstname": "%s",
                    "lastname": "%s"
                }
                """.formatted(firstName, lastName);

        Response updateResponse = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + this.token)
                .body(updatePayload)
                .when()
                .patch("/booking/" + this.bookingId);

        updateResponse.then().statusCode(200);

        validateBooking(firstName, lastName, null);
        return this;
    }

    public BookingSteps deleteBooking() {
        Response deleteResponse = given()
                .baseUri(BASE_URL)
                .header("Cookie", "token=" + this.token)
                .when()
                .delete("/booking/" + this.bookingId);

        deleteResponse.then().statusCode(201);

        Response getResponse = given()
                .baseUri(BASE_URL)
                .when()
                .get("/booking/" + this.bookingId);

        getResponse.then().statusCode(404);
        return this;
    }

    private void validateBooking(String expectedFirstName, String expectedLastName, Integer expectedTotalPrice) {
        Response getResponse = given()
                .baseUri(BASE_URL)
                .when()
                .get("/booking/" + this.bookingId);

        getResponse.then().statusCode(200).log().all();

        if (expectedFirstName != null) {
            String firstName = getResponse.jsonPath().getString("firstname");
            assert expectedFirstName.equals(firstName);
        }

        if (expectedLastName != null) {
            String lastName = getResponse.jsonPath().getString("lastname");
            assert expectedLastName.equals(lastName);
        }

        if (expectedTotalPrice != null) {
            int totalPrice = getResponse.jsonPath().getInt("totalprice");
            assert expectedTotalPrice == totalPrice;
        }
    }
}
