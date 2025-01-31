import com.example.springboot.soap.interfaces.AddEmployeeResponse;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.SoapDemoCRCINDTestSteps;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.tempuri.FindPerson;
import org.tempuri.FindPersonResponse;
import org.tempuri.ObjectFactory;
import org.tempuri.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Marshall;
import util.SoapServiceSender;
import util.Unmarshall;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class SoapDemoCRCINDTest {
    String SERVICE_URL = Constants.SERVICE_URL2;
    String FIND_PERSON_ACTION = Constants.FIND_PERSON_ACTION;
    ObjectFactory factory;
    SoapDemoCRCINDTestSteps soapDemoCRCINDTestSteps;

    @BeforeTest
    public void setUp() {
        RestAssured.filters(new AllureRestAssured());
        factory = new ObjectFactory();
        soapDemoCRCINDTestSteps = new SoapDemoCRCINDTestSteps();
    }

    @Test
    public void personValidationTest() {
        FindPerson findPerson = factory.createFindPerson();
        findPerson.setId(Constants.TEN);
        String soapRequest = Marshall.marshallSoapRequest(findPerson);

        Response response = SoapServiceSender.send(SERVICE_URL, FIND_PERSON_ACTION, soapRequest);
        FindPersonResponse findPersonResponse = Unmarshall.unmarshallResponse(response.getBody().asString(), FindPersonResponse.class);

        Person person = findPersonResponse.getFindPersonResult();
        soapDemoCRCINDTestSteps.validatePerson(person);
    }
}
