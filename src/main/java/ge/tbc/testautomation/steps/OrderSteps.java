package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.data.models.Requests.OrderRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;

public class OrderSteps {

    private OrderRequest orderRequest;

    public OrderSteps createOrderRequest(Long petId, Integer quantity, Boolean complete) {
        orderRequest = OrderRequest.builder()
                .petId(petId)
                .quantity(quantity)
                .complete(complete)
                .build();
        return this;
    }

    public OrderSteps setShipDate(String shipDate) {
        orderRequest.setShipDate(shipDate);
        return this;
    }

    public OrderSteps setStatus(String status) {
        orderRequest.setStatus(status);
        return this;
    }

    public OrderSteps sendPostRequest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(orderRequest)
                .when()
                .post("https://petstore3.swagger.io/api/v3/store/order")
                .then()
                .statusCode(200);
        return this;
    }

    public OrderSteps validateResponse(String expectedStatus) {
        String responseStatus = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(orderRequest)
                .when()
                .post("https://petstore3.swagger.io/api/v3/store/order")
                .then()
                .extract()
                .path("status");
        Assert.assertEquals(responseStatus, expectedStatus);
        return this;
    }
}

