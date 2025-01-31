import com.example.springboot.soap.interfaces.*;
import db.models.Employee;
import db.models.Person;
import ge.tbc.testautomation.data.Constants;
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
import java.util.List;

import static config.DataBaseConfig.dbMapper;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

public class PersonMapperTest {

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
    public void testInsert() {
        dbMapper().count();
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setName("John Doe");
        employee.setDepartment("Engineering");
        employee.setPhone("123-456-7890");
        employee.setAddress("123 Main St");
        employee.setSalary(new BigDecimal("75000.00"));
        employee.setEmail("john.doe@example.com");
        employee.setBirthDate(LocalDate.of(1990, 5, 15));

        dbMapper().insertEmployee(employee);
        System.out.println("Inserted Employee ID: " + employee.getEmployeeId());
    }


    @Test
    public void testGetByID(){
        long employeeId = 1L;
        Employee employee = dbMapper().selectById(employeeId);

        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest);

        GetEmployeeByIdResponse response1 = Unmarshall.unmarshallResponse(response.getBody().asString(), GetEmployeeByIdResponse.class);

        Assert.assertEquals(response1.getEmployeeInfo().getName(),employee.getName());
        Assert.assertEquals(response1.getEmployeeInfo().getAddress(),employee.getAddress());
        Assert.assertEquals(response1.getEmployeeInfo().getEmail(),employee.getEmail());
        Assert.assertEquals(response1.getEmployeeInfo().getPhone(),employee.getPhone());
        Assert.assertEquals(response1.getEmployeeInfo().getSalary(),employee.getSalary());

    }

    @Test
    public void updateIDUsingDB(){
        long employeeId = 1L;

        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setName("Ronchegius Lemonchegius"); //
        employee.setDepartment("IT"); //
        employee.setPhone("555-70-70-70"); //
        employee.setAddress("123 Main St");
        employee.setSalary(new BigDecimal("75000.00"));
        employee.setEmail("john.doe@example.com");
        employee.setBirthDate(LocalDate.of(1990, 5, 15));

        dbMapper().updateEmployee(employee);

        GetEmployeeByIdRequest getEmployeeByIdRequest = factory.createGetEmployeeByIdRequest();
        getEmployeeByIdRequest.setEmployeeId(employeeId);

        String soapRequest = Marshall.marshallSoapRequest(getEmployeeByIdRequest);

        Response response = SoapServiceSender.send(SERVICE_URL, GET_EMPLOYEE_ACTION, soapRequest);

        GetEmployeeByIdResponse response1 = Unmarshall.unmarshallResponse(response.getBody().asString(), GetEmployeeByIdResponse.class);

        Assert.assertEquals(response1.getEmployeeInfo().getName(), "Ronchegius Lemonchegius");
        Assert.assertEquals(response1.getEmployeeInfo().getDepartment(), "IT");
        Assert.assertEquals(response1.getEmployeeInfo().getPhone(), "555-70-70-70");

    }


    @Test
    public void deleteEmployeeTest(){
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

        Assert.assertEquals(response1.statusCode(),500);

        int countAfterDelete = dbMapper().count();
        Assert.assertEquals(countAfterDelete+1,countBeforeDelete);

    }

}