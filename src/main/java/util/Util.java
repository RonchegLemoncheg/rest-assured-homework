package util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Util {
    public static void checkEachBook(String isbn, String author) {
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
                .body("isbn", equalTo(isbn))
                .body("title", notNullValue())
                .body("publish_date", notNullValue())
                .body("pages", notNullValue());


    }
}
