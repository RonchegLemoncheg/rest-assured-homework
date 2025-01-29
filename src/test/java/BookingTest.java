import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.data.models.Responses.UpdateBookingResponse;
import ge.tbc.testautomation.steps.BookingSteps;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingTest {
    BookingSteps bookingSteps;

    @BeforeMethod
    public void setUp() {
        bookingSteps = new BookingSteps();
    }

    @Test(dataProvider = "bookingInfoProvider", dataProviderClass = DataSupplier.class)
    public void bookingApiTest(String username, String password, String name, String lastname, String newname, String newlastname) {
        bookingSteps
                .authenticate(username, password)
                .createBooking(name, lastname, 123, true, "2024-01-01", "2025-01-01", "Food")
                .partialUpdateBooking(newname, newlastname)
                .deleteBooking();
    }

    @Test(dataProvider = "bookingData", dataProviderClass = DataSupplier.class)
    public void testUpdateBooking(Integer bookingId, String firstname, String lastname, int totalPrice,
                                  Boolean depositPaid, String checkIn, String checkOut, String additionalNeeds,
                                  String passportNo, Double saleprice) {

        String username = "admin";
        String password = "password123";
        bookingSteps
                .authenticate(username, password)
                .withBookingDetails(bookingId, firstname, lastname, totalPrice, depositPaid, checkIn, checkOut,
                        additionalNeeds, passportNo, saleprice)
                .sendUpdateBookingRequest()
                .validateStatusIs201()
                .assertUpdateBookingResponse(bookingId, firstname, lastname, totalPrice);
    }

}
