import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.DataSupplier;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import util.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests1 {

    @Test
    public void validateBooks() {
        Response response = given()
                .baseUri("https://bookstore.toolsqa.com")
                .basePath("/BookStore/v1")
                .when()
                .get("/Books")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String firstBookISBN = response.jsonPath().getString("books[0].isbn");
        String firstAuthorInformation = response.jsonPath().getString("books[0].author");
        String secondBookISBN = response.jsonPath().getString("books[1].isbn");
        String secondAuthorInformation = response.jsonPath().getString("books[1].author");

        Util.checkEachBook(firstBookISBN, firstAuthorInformation);
        Util.checkEachBook(secondBookISBN, secondAuthorInformation);
    }

    @Test(dataProvider = "bookSupplier", dataProviderClass = DataSupplier.class)
    public void validateBooksWithDataProvider(String isbn, String author) {
        given()
                .baseUri("https://bookstore.toolsqa.com")
                .basePath("/BookStore/v1")
                .queryParam("ISBN", isbn)
                .when()
                .get("/Book")
                .then()
                .assertThat()
                .statusCode(200)
                .body("author", equalTo(author))
                .body("isbn", equalTo(isbn));
    }

    @Test
    public void deleteBook() {
        given()
                .baseUri("https://bookstore.toolsqa.com")
                .basePath("/BookStore/v1")
                .queryParam("ISBN", "9781449325862")
                .when()
                .delete("/Book")
                .then()
                .assertThat()
                .statusCode(401)
                .body("message", equalTo(Constants.ERROR_MESSAGE));
    }

    @Test
    public void createPetOrder() {
        String requestBody = Constants.REQUEST_BODY;

        given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/store")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/order")
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("petId", equalTo(12))
                .body("quantity", equalTo(2))
                .body("shipDate", notNullValue())
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true));
    }

    @Test
    public void createPetWithForms() {
        int petId = 13;
        String name = Constants.PETNAME;
        String status = Constants.STATUS;

        given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .contentType("application/x-www-form-urlencoded")
                .formParam("petId", petId)
                .formParam("name", name)
                .formParam("status", status)
                .when()
                .post("/" + petId)
                .then()
                .assertThat()
                .statusCode(200)
                .body("code", notNullValue())
                .body("type", notNullValue())
                .body("message", notNullValue());

    }


    @Test
    public void checkError() {
        int invalidPetId = 456;
        given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .when()
                .get("/" + invalidPetId)
                .then()
                .assertThat()
                .statusCode(404)
                // Code parameter was equal to 1, so i proceeded to check the message
                .body("message", equalTo(Constants.PET_NOT_FOUND));
    }

    @Test
    public void getLoginInfo() {
        String username = Constants.USERNAME;
        String password = Constants.PASSWORD;

        Response response = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user")
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get("/login")
                .then()
                .assertThat()
                .statusCode(200)
                .body("message", notNullValue())
                .extract()
                .response();

        String message = response.jsonPath().getString("message");
        String numbers = message.replaceAll("\\D+", "");
        if (numbers.length() >= 10) {
            System.out.println("Significant number: " + numbers);
        } else {
            throw new AssertionError("Message does not contain 10 numbers: " + message);
        }
    }

    @Test
    public void validateOpenLibrarySearch() {
        String keyword = Constants.HARRY_POTTER;

        given()
                .baseUri("https://openlibrary.org")
                .basePath("/search.json")
                .queryParam("q", keyword)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("docs.size()", greaterThan(0))
                .body("docs[0].title", equalTo(Constants.PHILOSOPHERS_STONE))
                .body("docs[0].author_name[0]", equalTo(Constants.ROWLING))
                .body("docs[0].place", hasItems(Constants.ENGLAND, Constants.SCHOOL_OF_WITCHCRAFT, Constants.PLATFORM));

    }

}