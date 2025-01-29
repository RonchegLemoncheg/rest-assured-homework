package ge.tbc.testautomation.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import ge.tbc.testautomation.data.models.PetStore.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Getter;
import util.XmlUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class PetStoreSteps {
    Pet pet;
    @Getter
    Pet responsePet;
    Response response;
    Faker faker = new Faker();

    public PetStoreSteps addPetWithID(String name, String status, int ID) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Category category = new Category(1, "Dog");
        TagsItem tag = new TagsItem();
        tag.setId(1);
        tag.setName("Tag1");

        PostPetStore pet = new PostPetStore();
        pet.setId(ID);
        pet.setName(name);
        pet.setCategory(category);
        pet.setTags(List.of(tag));
        pet.setStatus(Status.valueOf(status.toUpperCase()));

        Response addPetResponse = given()
                .contentType("application/json")
                .body(mapper.writeValueAsString(pet))
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

    public PetStoreSteps validatePet(int petId, String petName, String petStatus) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        PostPetStore pet = mapper.readValue(response.asString(), PostPetStore.class);

        assertThat(pet, notNullValue());
        assertThat(pet.getId(), equalTo(petId));
        assertThat(pet.getName(), equalTo(petName));
        assertThat(pet.getStatus().getValue(), equalTo(petStatus));

        return this;
    }

    public PetStoreSteps putPetWithID(String newPetName, String status, int petId) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        PostPetStore pet = new PostPetStore();
        pet.setId(petId);
        pet.setName(newPetName);
        pet.setStatus(Status.valueOf(status.toUpperCase()));

        Response updatePetResponse = given()
                .contentType("application/json")
                .body(mapper.writeValueAsString(pet))
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


    public PetStoreSteps createPet() {
        pet = new Pet();
        pet.setId(123);
        pet.setName("Ronchegius");
        pet.setStatus("available");
        return this;
    }

    public PetStoreSteps serializePetToXml() throws JAXBException {
        String petXml = XmlUtils.serializeToXml(pet);
        System.out.println("Serialized XML:\n" + petXml);
        return this;
    }

    public PetStoreSteps postPetXmlToApi() throws JAXBException {
        String petXml = XmlUtils.serializeToXml(pet);
        response = RestAssured.given()
                .header("Content-Type", "application/xml")
                .header("Accept", "application/xml")
                .body(petXml)
                .post("https://petstore3.swagger.io/api/v3/pet");
        return this;
    }

    public PetStoreSteps validateResponse() throws JAXBException {
        assertEquals(200, response.statusCode());
        String responseXml = response.body().asString();
        System.out.println("Response XML:\n" + responseXml);

        responsePet = XmlUtils.deserializeFromXml(responseXml, Pet.class);

        return this;
    }

    public PetStoreSteps validatePet() {
        assertNotNull(responsePet);
        assertEquals(pet.getId(), responsePet.getId());
        assertEquals(pet.getName(), responsePet.getName());
        assertEquals(pet.getStatus(), responsePet.getStatus());
        return this;
    }

}
