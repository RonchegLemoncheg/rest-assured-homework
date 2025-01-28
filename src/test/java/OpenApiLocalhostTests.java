import com.github.javafaker.Faker;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.DataSupplier;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import localhost.client.model.*;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import localhost.client.invoker.ApiClient;
import localhost.client.invoker.JacksonObjectMapper;

import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenApiLocalhostTests {
    private ApiClient api;

    @BeforeSuite
    public void createApiClient() {
        api = ApiClient.api(ApiClient.Config.apiConfig()
                .reqSpecSupplier(() -> new RequestSpecBuilder()
                        .log(LogDetail.ALL)
                        .setConfig(config()
                                .objectMapperConfig(objectMapperConfig()
                                        .defaultObjectMapper(JacksonObjectMapper.jackson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri(Constants.LOCALHOST)));
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void registerAdminAndAuthenticationTest() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = Constants.REAL_PASSWORD;
        RegisterRequest registerRequest = new RegisterRequest()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .email(email)
                .password(password)
                .role(RegisterRequest.RoleEnum.ADMIN);

        Response res = api.authentication().register().body(registerRequest).execute(response -> {
                    response.then().log().all();
                    Assert.assertEquals(response.statusCode(), 200);
                    return response;
                }
        );

        String accesss_token = res.jsonPath().getString("access_token");
        String refresh_token = res.jsonPath().getString("refresh_token");

        AuthenticationRequest authenticationRequest = new AuthenticationRequest()
                .password(password)
                .email(email);

        api.authentication().authenticate().body(authenticationRequest).executeAs(
                        resp -> {
                            Assert.assertEquals(resp.statusCode(), 200);
                            List<String> expectedRoles = List.of(
                                    Constants.READ_PRIVILEGE,
                                    Constants.WRITE_PRIVILEGE,
                                    Constants.DELETE_PRIVILEGE,
                                    Constants.UPDATE_PRIVILEGE,
                                    Constants.ROLE_ADMIN
                            );

                            List<String> actualRoles = resp.jsonPath().getList("roles", String.class);

                            assertThat(actualRoles).containsExactlyInAnyOrderElementsOf(expectedRoles);

                            return resp;
                        }
                );
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest()
                .refreshToken(refresh_token);

        RefreshTokenResponse refreshTokenResponse = api.authentication().refreshToken().body(refreshTokenRequest).executeAs(response -> {
            response.then().log().all();
            return response;
        });

        Assert.assertNotEquals(accesss_token,refreshTokenResponse.getAccessToken());

    }

    @Test(dataProvider = "passwordSupplier", dataProviderClass = DataSupplier.class)
    public void passwordTest(String password) {
        Faker faker = new Faker();
        RegisterRequest registerRequest = new RegisterRequest()
                .email(faker.internet().emailAddress())
                .password(password)
                .role(RegisterRequest.RoleEnum.ADMIN)
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName());

        Response resp = api.authentication().register().body(registerRequest).execute(response -> {
                    response.then().log().all();
                    return response;
                }
        );
        if (resp.statusCode() == 200) {
            String token = (resp.jsonPath().getString("access_token"));
            api.authorization()
                    .sayHelloWithRoleAdminAndReadAuthority()
                    .reqSpec(reqSpec -> reqSpec.addHeader("Authorization", "Bearer " + token))
                    .execute(res -> {
                        Assert.assertEquals(res.statusCode(), 200);
                        String responseBody = res.getBody().asString().trim();
                        Assert.assertEquals(responseBody, Constants.HELLO_ADMIN);
                        return res;
                    });
        }

    }

}
