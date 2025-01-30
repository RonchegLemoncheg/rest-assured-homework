import com.github.javafaker.Faker;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.steps.OpenApiLocalhostSteps;
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
    private OpenApiLocalhostSteps openApiLocalhostSteps;

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
        openApiLocalhostSteps = new OpenApiLocalhostSteps();
    }

    @Test
    public void registerAdminAndAuthenticationTest() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = Constants.REAL_PASSWORD;
        RegisterRequest registerRequest = openApiLocalhostSteps.generateRegistrationRequest(password, email);

        openApiLocalhostSteps.register(api, registerRequest);

        String access_token = openApiLocalhostSteps.getAccess_token();
        String refresh_token = openApiLocalhostSteps.getRefresh_token();

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

        Assert.assertNotEquals(access_token, refreshTokenResponse.getAccessToken());

        // აქ ორივე ტოკენზე მუშაობს და დავაკომენტარე მაგიტო, უბრალოდ ვამოწმებ რომ შეიცვალა ტოკენი
//        api.authorization()
//                .sayHelloWithRoleAdminAndReadAuthority()
//                .reqSpec(reqSpec -> reqSpec.addHeader("Authorization", "Bearer " + accesss_token))
//                .execute(respo -> {
//                    System.out.println(respo.statusCode());
//                    return respo;
//                });

    }

    @Test(dataProvider = "passwordSupplier", dataProviderClass = DataSupplier.class)
    public void passwordTest(String password) {
        RegisterRequest registerRequest = openApiLocalhostSteps.generateRegistrationRequest(password);

        Response resp = api.authentication().register().body(registerRequest).execute(response -> {
                    response.then().log().all();
                    return response;
                }
        );
        if (resp.statusCode() == 200) {
            String token = (resp.jsonPath().getString("access_token"));
            openApiLocalhostSteps.checkAuthorization(token, api);
        }

    }

}
