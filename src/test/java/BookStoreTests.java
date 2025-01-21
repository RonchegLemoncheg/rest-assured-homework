import com.github.javafaker.Faker;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.steps.BookStoreSteps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BookStoreTests {
    BookStoreSteps bookStoreSteps;

    @BeforeTest
    public void setUp(){
        bookStoreSteps = new BookStoreSteps();
    }

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
    public void BookingUpdate() {

        RestAssured.baseURI = Constants.BOOKER_HEROKU;

        bookStoreSteps
                .authorizeUser()
                .updateBooking(1);
    }


    @Test
    public void checkBookPages() {
        RestAssured.baseURI = Constants.BOOK_STORE;

        bookStoreSteps
                .getEveryBook()
                .checkBookPages()
                .checkFirstTwoAuthors(Constants.RICHARD_SILVERMAN, Constants.ADDY_OSMANI);

    }
}
