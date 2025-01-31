import ge.tbc.testautomation.steps.OrderSteps;
import groovyjarjarantlr4.v4.runtime.atn.SemanticContext;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class OrderTest {

    OrderSteps orderSteps;


    @BeforeMethod
    public void setUp(){
        orderSteps = new OrderSteps();
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void testCreateOrder() {
        orderSteps.createOrderRequest(1L, 5, true)
                .setShipDate("2025-01-25T10:30:00")
                .setStatus("placed")
                .sendPostRequest()
                .validateResponse("placed");
    }
}