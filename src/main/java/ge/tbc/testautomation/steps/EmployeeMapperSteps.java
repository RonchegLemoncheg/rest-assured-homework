package ge.tbc.testautomation.steps;

import com.example.springboot.soap.interfaces.GetEmployeeByIdResponse;
import db.models.Employee;
import ge.tbc.testautomation.data.Constants;
import org.testng.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeMapperSteps {
    public Employee createEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setName(Constants.JOHN_DOE);
        employee.setDepartment(Constants.MANAGEMENT);
        employee.setPhone(Constants.PHONE);
        employee.setAddress(Constants.MAIN_ST);
        employee.setSalary(new BigDecimal(Constants.TEN));
        employee.setEmail(Constants.EMAIL);
        employee.setBirthDate(LocalDate.of(1990, 5, 15));
        return employee;
    }
    public EmployeeMapperSteps validateEmployees(GetEmployeeByIdResponse response1, Employee employee){
        Assert.assertEquals(response1.getEmployeeInfo().getName(),employee.getName());
        Assert.assertEquals(response1.getEmployeeInfo().getAddress(),employee.getAddress());
        Assert.assertEquals(response1.getEmployeeInfo().getEmail(),employee.getEmail());
        Assert.assertEquals(response1.getEmployeeInfo().getPhone(),employee.getPhone());
        Assert.assertEquals(response1.getEmployeeInfo().getSalary(),employee.getSalary());
        return this;
    }
}
