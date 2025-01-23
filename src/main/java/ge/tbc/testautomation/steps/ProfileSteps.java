package ge.tbc.testautomation.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.tbc.testautomation.data.ApiSpecification;
import ge.tbc.testautomation.data.models.User.UserProfile;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProfileSteps {
    private Response response;

    public ProfileSteps fetchProfile(String accessToken) {
        response = given()
                .spec(ApiSpecification.getRequestSpecification())
                .auth().oauth2(accessToken)
                .when()
                .get("/v1/auth/profile");

        response.then().log().all().statusCode(200);
        return this;
    }

    public UserProfile getProfileAsPojo() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.asString(), UserProfile.class);
    }

    public ProfileSteps validateProfile(UserProfile expectedProfile) throws Exception {
        UserProfile actualProfile = getProfileAsPojo();

        assertThat(actualProfile.getEmail(), equalTo(expectedProfile.getEmail()));
        assertThat(actualProfile.getName(), equalTo(expectedProfile.getName()));
        assertThat(actualProfile.getAvatar(), equalTo(expectedProfile.getAvatar()));
        return this;
    }
}

