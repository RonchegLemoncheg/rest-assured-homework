import ge.tbc.testautomation.data.Constants;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.LogDetail;
import org.assertj.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pet.store.v3.invoker.ApiClient;
import pet.store.v3.invoker.JacksonObjectMapper;
import pet.store.v3.model.Order;
import pet.store.v3.model.Pet;

import java.time.OffsetDateTime;

import static io.restassured.RestAssured.config;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static org.hamcrest.Matchers.equalTo;

public class OpenApiTests {
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
                        .setBaseUri(Constants.SWAGGER_LINK)));
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void openAPIOrderTest() {
        Order order = new Order()
                .id(1L)
                .petId(12345L)
                .quantity(2)
                .shipDate(OffsetDateTime.parse("2025-01-26T10:15:30Z"))
                .status(Order.StatusEnum.PLACED)
                .complete(true);

        Order res2 = api.store().placeOrder().body(order).executeAs(response -> {
            response.then().log().all();
            Assert.assertEquals(response.statusCode(), 200);
            Assert.assertEquals(response.jsonPath().getString("status"), ("placed"));
            Assert.assertTrue(response.jsonPath().getBoolean("complete"));
            return response;
        });


        Assertions.assertThat(res2)
                .hasId(order.getId())
                .hasPetId(order.getPetId())
                .hasStatus(order.getStatus());
    }

    @Test
    public void printRawResponseTest() {
        Pet body = new Pet()
                .id(567L)
                .name("Tyberos")
                .status(Pet.StatusEnum.AVAILABLE);

        api.pet().addPet().body(body).executeAs(response -> {
            response.then()
                    .log().all()
                    .statusCode(200)
                    .body("id",equalTo(567))
                    .body("name", equalTo("Tyberos"))
                    .body("status", equalTo("available"));
            return response;
        });

    }
}
