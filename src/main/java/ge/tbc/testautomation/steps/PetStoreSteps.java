package ge.tbc.testautomation.steps;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreSteps {
    Response response;
    Faker faker = new Faker();

    public PetStoreSteps addPetWithID(String name, String status, int ID){
        String petCategory = faker.animal().name();

        JSONObject petBody = new JSONObject();
        petBody.put("id", ID);
        petBody.put("name", name);
        petBody.put("status", status);
        petBody.put("category", new JSONObject().put("name", petCategory));

        Response addPetResponse = given()
                .contentType("application/json")
                .body(petBody.toString())
                .when()
                .post("/pet");

        addPetResponse.then().statusCode(200).log().all();
        return this;
    }

    public PetStoreSteps filterByStatus(String petStatus){
        response = given()
                .when()
                .get("/pet/findByStatus?status=" + petStatus);
        return this;
    }

    public PetStoreSteps checkIfContainsID(int petId){
        response.then().body("id", hasItem(petId));
        return this;
    }

    public PetStoreSteps validatePet(int petId, String petName, String petStatus){
        Map<String, Object> petResponseJson = response
                .then()
                .extract()
                .jsonPath()
                .get("find { it.id == " + petId + " }");
        assertThat(petResponseJson, notNullValue());

        assertThat(petResponseJson.get("name"), equalTo(petName));
        assertThat(petResponseJson.get("status"), equalTo(petStatus));
        return this;
    }

    public PetStoreSteps putPetWithID(String newPetName, String status, int petId){
        JSONObject updatedPetBody = new JSONObject();
        updatedPetBody.put("id", petId);
        updatedPetBody.put("name", newPetName);
        updatedPetBody.put("status", status);

        Response updatePetResponse = given()
                .contentType("application/json")
                .body(updatedPetBody.toString())
                .when()
                .put("/pet");

        updatePetResponse.then().statusCode(200).log().all();
        return this;
    }

    public PetStoreSteps getPet(int id){
        response = given()
                .when()
                .get("/pet/" + id);
        return this;
    }

    public PetStoreSteps checkPet(String newPetName, String status){
        response.then()
                .body("name", equalTo(newPetName))
                .body("status", equalTo(status));
        return this;
    }

    public PetStoreSteps uploadImage(File file, String additionalMetadata, int petId){
        response = given()
                .contentType("multipart/form-data")
                .multiPart("file", file)
                .formParam("additionalMetadata", additionalMetadata)
                .when()
                .post("/pet/" + petId + "/uploadImage");

        response.then().statusCode(200).log().all();
        return this;
    }

    public PetStoreSteps checkImageMessage(String additionalMetadata, String fileName){
        response.then().body("message", containsString(additionalMetadata));
        response.then().body("message", containsString(fileName));
        return this;
    }


    public PetStoreSteps checkFileSizes(File file){
        String message = response
                .then()
                .extract()
                .path("message");
        Pattern pattern = Pattern.compile("([\\d]+) bytes");
        Matcher matcher = pattern.matcher(message);

        int uploadedFileSize = 0;
        if (matcher.find()) {
            uploadedFileSize = Integer.parseInt(matcher.group(1));
        } else {
            System.out.println("File size not found in the message.");
        }

        assertThat(uploadedFileSize, equalTo((int) file.length()));
        return this;
    }
}
