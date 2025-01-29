package ge.tbc.testautomation.steps;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.models.Requests.UpdateBookingRequest;
import ge.tbc.testautomation.data.models.Responses.UpdateBookingResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class BookingSteps {

    private static final String BASE_URL = Constants.BOOKER_HEROKU;;
    private String token;
    private int bookingId;
    private UpdateBookingRequest request;
    private Response response;


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

    public BookingSteps withBookingDetails(int bookingId, String firstname, String lastname,
                                           int totalPrice, Boolean depositPaid, String checkIn,
                                           String checkOut, String additionalNeeds, String passportNo,
                                           Double saleprice) {
        this.bookingId = bookingId;
        this.request = UpdateBookingRequest.builder()
                .bookingId(bookingId)
                .first_name(firstname)
                .lastname(lastname)
                .totalprice(totalPrice)
                .depositpaid(depositPaid)
                .bookingdates(UpdateBookingRequest.BookingDates.builder()
                        .checkin(checkIn)
                        .checkout(checkOut)
                        .build())
                .additionalneeds(additionalNeeds)
                .passportNo(passportNo)
                .saleprice(saleprice)
                .build();
        return this;

    }

    public BookingSteps sendUpdateBookingRequest() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(request);
            System.out.println("Request Body: " + requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .header("Cookie", "token=" + this.token)
                .body(request)
                .when()
                .put("/booking/" + this.bookingId)
                .then()
                .log().all()
                .extract().response();
        return this;
    }

    public BookingSteps validateStatusIs201() {
        assertEquals(response.statusCode(),200);
        return this;
    }

    public BookingSteps assertUpdateBookingResponse(Integer bookingId, String firstname, String lastname,
                                            int totalPrice) {

        UpdateBookingResponse responseBody = response.as(UpdateBookingResponse.class);
        assertEquals(response.statusCode(), 200);
        System.out.println(response.body().asString());

        assertNotNull(responseBody.getBookingId());
        assertEquals(this.bookingId, bookingId);
        assertEquals(responseBody.getTotalprice(), totalPrice);
        assertEquals(responseBody.getFirstname(), firstname);
        assertEquals(responseBody.getLastname(), lastname);
        return this;
    }
}
