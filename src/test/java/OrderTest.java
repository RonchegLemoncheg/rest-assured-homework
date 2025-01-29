import ge.tbc.testautomation.steps.OrderSteps;
import org.testng.annotations.Test;
public class OrderTest {

    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    public void testCreateOrder() {
        orderSteps.createOrderRequest(1L, 5, true)
                .setShipDate("2025-01-25T10:30:00")
                .setStatus("placed")
                .sendPostRequest()
                .validateResponse("placed");
    }
}