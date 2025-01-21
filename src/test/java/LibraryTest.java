import ge.tbc.testautomation.data.Constants;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LibraryTest {
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
