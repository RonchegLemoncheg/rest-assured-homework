import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.steps.BookingSteps;
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
                .authenticate(username,password)
                .createBooking(name,lastname, 123, true, "2024-01-01", "2025-01-01", "Food")
                .partialUpdateBooking(newname,newlastname)
                .deleteBooking();
    }
}
