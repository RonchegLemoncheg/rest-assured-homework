package ge.tbc.testautomation.data;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DataSupplier {

    @DataProvider(name = "bookSupplier")
    public Object[][] bookSupplier() {
        Response response = given()
                .baseUri("https://bookstore.toolsqa.com")
                .basePath("/BookStore/v1")
                .when()
                .get("/Books")
                .then()
                .extract()
                .response();

        List<Integer> indexes = List.of(3, 6, 4);
        Object[][] bookData = new Object[indexes.size()][2];
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            bookData[i][0] = response.jsonPath().getString("books[" + index + "].isbn");
            bookData[i][1] = response.jsonPath().getString("books[" + index + "].author");
        }
        return bookData;
    }
}
