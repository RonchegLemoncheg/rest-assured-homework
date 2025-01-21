package ge.tbc.testautomation.steps;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BookStoreSteps {
    Response response;
    String token;
    RequestSpecification requestSpec;

    public BookStoreSteps authorizeUser(){
        JSONObject authRequest = new JSONObject();
        authRequest.put("username", "admin");
        authRequest.put("password", "password123");

        Response authResponse = given()
                .header("Content-Type", "application/json")
                .body(authRequest.toString())
                .when()
                .post("/auth");

        token = authResponse.jsonPath().getString("token");
        if (token == null || token.isEmpty()) {
            System.out.println("Failed to retrieve token. Response: " + authResponse.asString());
            return null;
        }

        System.out.println("Generated Token: " + token);
        return this;
    }

    public BookStoreSteps updateBooking(int id){
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int totalPrice = faker.number().numberBetween(50, 500);
        boolean depositPaid = faker.bool().bool();
        String checkinDate = "2025-01-21";
        String checkoutDate = "2025-01-22";
        String additionalNeeds = faker.food().dish();

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", firstName);
        requestBody.put("lastname", lastName);
        requestBody.put("totalprice", totalPrice);
        requestBody.put("depositpaid", depositPaid);
        requestBody.put("bookingdates", new JSONObject()
                .put("checkin", checkinDate)
                .put("checkout", checkoutDate));
        requestBody.put("additionalneeds", additionalNeeds);

        requestSpec = given()
                .header("Content-Type", "application/json")
                .cookie("token", token);

        response = requestSpec
                .body(requestBody.toString())
                .when()
                .put("/booking/{id}", id);

        int statusCode = response.then().extract().statusCode();

        if (statusCode == 200) {
            System.out.println("Response Data: " + response.asString());
        } else {
            System.out.println("Failed to update booking. Status Code: " + statusCode);
        }
        return this;
    }


    public BookStoreSteps getEveryBook(){
        response = given()
                .when()
                .get("/BookStore/v1/Books");

        response.then().statusCode(200).log().all();
        return this;
    }

    public BookStoreSteps checkBookPages(){
        response.then().body("books.pages", Matchers.everyItem(Matchers.lessThan(1000)));
        return this;
    }

    public BookStoreSteps checkFirstTwoAuthors(String name1, String name2){
        response.then()
                .body("books[0].author", Matchers.equalTo(name1))
                .body("books[1].author", Matchers.equalTo(name2));
        return this;
    }
}
