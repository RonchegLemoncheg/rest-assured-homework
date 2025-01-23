import com.github.javafaker.Faker;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.steps.PetStoreSteps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Before;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetStoreTests {
    PetStoreSteps petStoreSteps;

    @BeforeTest
    public void setUp(){
        petStoreSteps = new PetStoreSteps();
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

    @Test(dataProvider = "petNameGenerator", dataProviderClass = DataSupplier.class)
    public void addPetAndValidate(String petName, int petId, String petStatus, String newPetName, String newPetStatus) throws Exception {
        RestAssured.baseURI = Constants.PETSTORESWAGGERV2;

        petStoreSteps
                .addPetWithID(petName, petStatus, petId)
                .filterByStatus(petStatus)
                .checkIfContainsID(petId)
                .validatePet(petId,petName,petStatus)
                .putPetWithID(newPetName,newPetStatus,petId)
                .getPet(petId)
                .checkPet(newPetName,newPetStatus);

    }

    @Test
    public void postPicture(){
        RestAssured.baseURI = Constants.PETSTORESWAGGERV2;

        // ფაილს DataProvider-ში ვერ გავიტანდი და ბარემ ეს ორიც აქ დავტოვე და ცალკე DataProvider არ გავუკეთე
        File file = new File("meshuggah.jpg");
        int petId = 567;
        String additionalMetadata = Constants.MESHUGGAH_DESCRIPTION;

        petStoreSteps
                .uploadImage(file,additionalMetadata,petId)
                .checkImageMessage(additionalMetadata,file.getName())
                .checkFileSizes(file);

    }
}
