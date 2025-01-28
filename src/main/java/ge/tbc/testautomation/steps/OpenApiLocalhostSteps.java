package ge.tbc.testautomation.steps;

import com.github.javafaker.Faker;
import ge.tbc.testautomation.data.Constants;
import io.restassured.response.Response;
import localhost.client.invoker.ApiClient;
import localhost.client.model.RegisterRequest;
import org.testng.Assert;

public class OpenApiLocalhostSteps {

    String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    String refresh_token;

    public OpenApiLocalhostSteps checkAuthorization(String token, ApiClient api){
        api.authorization()
                .sayHelloWithRoleAdminAndReadAuthority()
                .reqSpec(reqSpec -> reqSpec.addHeader("Authorization", "Bearer " + token))
                .execute(res -> {
                    Assert.assertEquals(res.statusCode(), 200);
                    String responseBody = res.getBody().asString().trim();
                    Assert.assertEquals(responseBody, Constants.HELLO_ADMIN);
                    return res;
                });
        return this;
    }

    public RegisterRequest generateRegistrationRequest(String password){
        Faker faker = new Faker();
        return new RegisterRequest()
                .email(faker.internet().emailAddress())
                .password(password)
                .role(RegisterRequest.RoleEnum.ADMIN)
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName());
    }

    public RegisterRequest generateRegistrationRequest(String password, String email){
        Faker faker = new Faker();
        return new RegisterRequest()
                .email(email)
                .password(password)
                .role(RegisterRequest.RoleEnum.ADMIN)
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName());
    }

    public OpenApiLocalhostSteps register(ApiClient api, RegisterRequest registerRequest){
        Response res = api.authentication().register().body(registerRequest).execute(response -> {
            response.then().log().all();
            Assert.assertEquals(response.statusCode(), 200);
            return response;
        });
        access_token = res.jsonPath().getString("access_token");
        refresh_token = res.jsonPath().getString("refresh_token");
        return this;
    }
}
