package ge.tbc.testautomation.data;

import com.github.javafaker.Faker;
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

    @DataProvider(name = "petNameGenerator")
    public Object[][] petNames() {
        Faker faker = new Faker();

        String petName = faker.animal().name();
        int petId = faker.number().numberBetween(1000, 9999);
        String petStatus = "available";
        String newPetStatus = "sold";
        String newPetName = faker.animal().name();

        return new Object[][]{
                {petName, petId, petStatus, newPetName, newPetStatus}
        };
    }

    @DataProvider(name = "userInfoProvider")
    public Object[][] userInfo() {
        return new Object[][]{
                {
                        "john@mail.com"
                        , "Jhon"
                        , "changeme"
                        , "https://i.imgur.com/LDOO4Qs.jpg"}};
    }


    @DataProvider(name = "bookingInfoProvider")
    public Object[][] bookingInfo() {
        return new Object[][]{
                {
                        "admin"
                        , "password123"
                        , "Roncheg"
                        , "Lemoncheg"
                        , "Gverberg", "Gvainus"}};
    }

    @DataProvider(name = "bookingData")
    public Object[][] createBookingData() {
        return new Object[][] {
                { 1, "Roncheg", "Lemoncheg", 200, true, "2023-01-01", "2023-01-10", "Vegan", null, 150.50 },
                { 2, "Gverberg", "Gvainus", 300, false, "2023-02-01", "2023-02-10", "Gluten-Free", "12345678", 180.75 }
        };
    }
}
