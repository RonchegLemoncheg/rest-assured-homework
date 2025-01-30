import com.example.springboot.soap.interfaces.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Marshall;
import util.SoapServiceSender;
import util.Unmarshall;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestSoapLocalhost {
    private static final String SERVICE_URL = "http://localhost:8087/ws";
    private static final String ADD_EMPLOYEE_ACTION = "http://interfaces.soap.springboot.example.com/addEmployee";
    private static final String GET_EMPLOYEE_ACTION = "http://interfaces.soap.springboot.example.com/getEmployeeById";
    private static final String UPDATE_EMPLOYEE_ACTION = "http://interfaces.soap.springboot.example.com/updateEmployee";
    private static final String DELETE_EMPLOYEE_ACTION = "http://interfaces.soap.springboot.example.com/deleteEmployee";

    @Test
    public void someTest() throws DatatypeConfigurationException {
        ObjectFactory factory = new ObjectFactory();
        AddEmployeeRequest addEmployeeRequest = factory.createAddEmployeeRequest();
        EmployeeInfo employee = factory.createEmployeeInfo();
        employee.setEmployeeId(1);
        GregorianCalendar calendar = new GregorianCalendar(1990, 1, 1);
        XMLGregorianCalendar birthDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        employee.setBirthDate(birthDate);
        employee.setName("John Doe");
        employee.setDepartment("IT");
        employee.setPhone("123-456-7890");
        employee.setAddress("123 Main St");
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
        ObjectFactory factory = new ObjectFactory();

        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest);

        GetEmployeeByIdResponse response1 = Unmarshall.unmarshallResponse(response.getBody().asString(), GetEmployeeByIdResponse.class);

        // XPath-ით ვალიდაციას არ შვებოდა და response-თი ვამოწმებ
        Assert.assertEquals(response1.getEmployeeInfo().getDepartment(), "IT");
        Assert.assertEquals(response1.getEmployeeInfo().getName(), "John Doe");
        Assert.assertEquals(response1.getEmployeeInfo().getAddress(), "123 Main St");
    }

    @Test
    public void updateEmployeeAndCheckUpdated() {
        long employeeId = 1;
        String newName = "Roncheg Lemoncheg";
        String newDepartment = "Management";

        ObjectFactory factory = new ObjectFactory();

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
        Assert.assertEquals(response3.getEmployeeInfo().getDepartment(), "Management");
        Assert.assertEquals(response3.getEmployeeInfo().getName(), "Roncheg Lemoncheg");
    }

    @Test
    public void deleteEmployee(){
        ObjectFactory factory = new ObjectFactory();

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



