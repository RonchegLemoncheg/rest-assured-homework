import com.example.springboot.soap.interfaces.*;
import ge.tbc.testautomation.data.Constants;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Marshall;
import util.SoapServiceSender;
import util.Unmarshall;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.GregorianCalendar;


public class TestSoapLocalhost {
    private static final String SERVICE_URL = Constants.SERVICE_URL;
    private static final String ADD_EMPLOYEE_ACTION = Constants.ADD_EMPLOYEE_ACTION;
    private static final String GET_EMPLOYEE_ACTION = Constants.GET_EMPLOYEE_ACTION;
    private static final String UPDATE_EMPLOYEE_ACTION = Constants.UPDATE_EMPLOYEE_ACTION;
    private static final String DELETE_EMPLOYEE_ACTION = Constants.DELETE_EMPLOYEE_ACTION;
    ObjectFactory factory;
    @BeforeTest
    public void setUp(){
        RestAssured.filters(new AllureRestAssured());
        factory = new ObjectFactory();
    }
    @Test
    public void someTest() throws DatatypeConfigurationException {
        AddEmployeeRequest addEmployeeRequest = factory.createAddEmployeeRequest();
        EmployeeInfo employee = factory.createEmployeeInfo();
        employee.setEmployeeId(1);
        GregorianCalendar calendar = new GregorianCalendar(1990, 1, 1);
        XMLGregorianCalendar birthDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        employee.setBirthDate(birthDate);
        employee.setName(Constants.JOHN_DOE);
        employee.setDepartment(Constants.IT);
        employee.setPhone("123-456-7890");
        employee.setAddress(Constants.MAIN_ST);
        employee.setSalary(new BigDecimal("50000.00"));
        employee.setEmail("john.doe@example.com");

        addEmployeeRequest.setEmployeeInfo(employee);
        String soapRequest = Marshall.marshallSoapRequest(addEmployeeRequest);

        Response response = SoapServiceSender.send(SERVICE_URL, ADD_EMPLOYEE_ACTION, soapRequest);

        AddEmployeeResponse addEmployeeResponse = Unmarshall.unmarshallResponse(response.getBody().asString(), AddEmployeeResponse.class);

        Assert.assertEquals(addEmployeeResponse.getServiceStatus().getMessage(), "Content Added Successfully");
    }

    @Test
    public void getEmployeeById() {
        long employeeId = 1;
        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest);

        GetEmployeeByIdResponse response1 = Unmarshall.unmarshallResponse(response.getBody().asString(), GetEmployeeByIdResponse.class);

        // XPath-ით ვალიდაციას არ შვებოდა და response-თი ვამოწმებ
        Assert.assertEquals(response1.getEmployeeInfo().getDepartment(), Constants.IT);
        Assert.assertEquals(response1.getEmployeeInfo().getName(), Constants.JOHN_DOE);
        Assert.assertEquals(response1.getEmployeeInfo().getAddress(), Constants.MAIN_ST);
    }

    @Test
    public void updateEmployeeAndCheckUpdated() {
        long employeeId = 1;
        String newName = Constants.RONCHEG_LEMONCHEG;
        String newDepartment = Constants.MANAGEMENT;

        UpdateEmployeeRequest updateEmployeeRequest = factory.createUpdateEmployeeRequest();
        EmployeeInfo employee = factory.createEmployeeInfo();

        employee.setEmployeeId(employeeId);
        employee.setName(newName);
        employee.setDepartment(newDepartment);

        updateEmployeeRequest.setEmployeeInfo(employee);

        String soapRequest = Marshall.marshallSoapRequest(updateEmployeeRequest);

        Response response = SoapServiceSender.send(SERVICE_URL, UPDATE_EMPLOYEE_ACTION, soapRequest);

        UpdateEmployeeResponse response1 = Unmarshall.unmarshallResponse(response.getBody().asString(), UpdateEmployeeResponse.class);

        Assert.assertEquals(response1.getServiceStatus().getMessage(),"Content Updated Successfully");


        // Checking if it updated correctly
        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest1 = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response2 = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest1);

        GetEmployeeByIdResponse response3 = Unmarshall.unmarshallResponse(response2.getBody().asString(), GetEmployeeByIdResponse.class);

        // XPath-ით ვალიდაციას არ შვებოდა და response-თი ვამოწმებ
        Assert.assertEquals(response3.getEmployeeInfo().getDepartment(), newDepartment);
        Assert.assertEquals(response3.getEmployeeInfo().getName(), newName);
    }

    @Test
    public void deleteEmployee(){
        long employeeId = 1;

        DeleteEmployeeRequest deleteEmployeeRequest = factory.createDeleteEmployeeRequest();
        deleteEmployeeRequest.setEmployeeId(employeeId);

        String soapRequest = Marshall.marshallSoapRequest(deleteEmployeeRequest);
        Response response = SoapServiceSender.send(SERVICE_URL, DELETE_EMPLOYEE_ACTION, soapRequest);
        DeleteEmployeeResponse deleteEmployeeResponse = Unmarshall.unmarshallResponse(response.getBody().asString(), DeleteEmployeeResponse.class);

        Assert.assertEquals(deleteEmployeeResponse.getServiceStatus().getMessage(), "Content Deleted Successfully");


        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest1 = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response1 = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest1);

        Assert.assertEquals(response1.statusCode(),500);
    }
}



