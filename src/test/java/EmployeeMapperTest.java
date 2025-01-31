import com.example.springboot.soap.interfaces.*;
import db.models.Employee;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.EmployeeMapperSteps;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Marshall;
import util.SoapServiceSender;
import util.Unmarshall;

import java.math.BigDecimal;
import java.time.LocalDate;

import static config.DataBaseConfig.dbMapper;


public class EmployeeMapperTest {

    private static final String SERVICE_URL = Constants.SERVICE_URL;
    private static final String ADD_EMPLOYEE_ACTION = Constants.ADD_EMPLOYEE_ACTION;
    private static final String GET_EMPLOYEE_ACTION = Constants.GET_EMPLOYEE_ACTION;
    private static final String UPDATE_EMPLOYEE_ACTION = Constants.UPDATE_EMPLOYEE_ACTION;
    private static final String DELETE_EMPLOYEE_ACTION = Constants.DELETE_EMPLOYEE_ACTION;
    ObjectFactory factory;
    EmployeeMapperSteps employeeMapperSteps;

    @BeforeTest
    public void setUp() {
        RestAssured.filters(new AllureRestAssured());
        factory = new ObjectFactory();
        employeeMapperSteps = new EmployeeMapperSteps();
    }

    @Test
    public void testInsert() {
        dbMapper().count();
        Employee employee = employeeMapperSteps.createEmployee();
        dbMapper().insertEmployee(employee);
        System.out.println("Inserted Employee ID: " + employee.getEmployeeId());
    }


    @Test
    public void testGetByID() {
        long employeeId = 1L;
        Employee employee = dbMapper().selectById(employeeId);

        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest);

        GetEmployeeByIdResponse response1 = Unmarshall.unmarshallResponse(response.getBody().asString(), GetEmployeeByIdResponse.class);
        employeeMapperSteps.validateEmployees(response1, employee);

    }

    @Test
    public void updateIDUsingDB() {
        long employeeId = 1L;

        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setName(Constants.RONCHEG_LEMONCHEG); //
        employee.setDepartment(Constants.IT); //
        employee.setPhone(Constants.NEW_PHONE); //
        employee.setAddress(Constants.MAIN_ST);
        employee.setSalary(new BigDecimal(Constants.TEN));
        employee.setEmail(Constants.EMAIL);
        employee.setBirthDate(LocalDate.of(1990, 5, 15));

        dbMapper().updateEmployee(employee);

        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest);

        GetEmployeeByIdResponse response1 = Unmarshall.unmarshallResponse(response.getBody().asString(), GetEmployeeByIdResponse.class);

        Assert.assertEquals(response1.getEmployeeInfo().getName(), Constants.RONCHEG_LEMONCHEG);
        Assert.assertEquals(response1.getEmployeeInfo().getDepartment(), Constants.IT);
        Assert.assertEquals(response1.getEmployeeInfo().getPhone(), Constants.NEW_PHONE);

    }


    @Test
    public void deleteEmployeeTest() {
        int countBeforeDelete = dbMapper().count();
        long employeeId = 1;

        DeleteEmployeeRequest deleteEmployeeRequest = factory.createDeleteEmployeeRequest();
        deleteEmployeeRequest.setEmployeeId(employeeId);

        String soapRequest = Marshall.marshallSoapRequest(deleteEmployeeRequest);
        Response response = SoapServiceSender.send(SERVICE_URL, DELETE_EMPLOYEE_ACTION, soapRequest);
        DeleteEmployeeResponse deleteEmployeeResponse = Unmarshall.unmarshallResponse(response.getBody().asString(), DeleteEmployeeResponse.class);

        // არ შვებოდა ამას XPATH-ით
        Assert.assertEquals(deleteEmployeeResponse.getServiceStatus().getMessage(), "Content Deleted Successfully");

        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest1 = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response1 = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest1);

        Assert.assertEquals(response1.statusCode(), 500);

        int countAfterDelete = dbMapper().count();
        Assert.assertEquals(countAfterDelete + 1, countBeforeDelete);

    }

}