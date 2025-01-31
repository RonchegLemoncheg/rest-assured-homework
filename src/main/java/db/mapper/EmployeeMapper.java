package db.mapper;

import db.models.Employee;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    @Insert("INSERT INTO employee (employee_id, name, department, phone, address, salary, email, birth_date) " +
            "VALUES (#{employeeId}, #{name}, #{department}, #{phone}, #{address}, #{salary}, #{email}, #{birthDate})")
    @Options(useGeneratedKeys = true, keyProperty = "employeeId")
    void insertEmployee(Employee employee);

    @Select("SELECT employee_id, name, department, phone, address, salary, email, birth_date " +
            "FROM employee WHERE employee_id = #{employeeId}")
    Employee selectById(long employeeId);

    @Select("SELECT employee_id, name, department, phone, address, salary, email, birth_date FROM employee")
    List<Employee> selectAll();

    @Update("UPDATE employee SET name = #{name}, department = #{department}, phone = #{phone}, " +
            "address = #{address}, salary = #{salary}, email = #{email}, birth_date = #{birthDate} " +
            "WHERE employee_id = #{employeeId}")
    void updateEmployee(Employee employee);

    @Delete("DELETE FROM employee WHERE employee_id = #{employeeId}")
    void deleteEmployee(long employeeId);

    @Select("SELECT employee_id, name, department, phone, address, salary, email, birth_date " +
            "FROM employee WHERE department = #{department}")
    List<Employee> selectByDepartment(String department);

    @Select("SELECT employee_id, name, department, phone, address, salary, email, birth_date " +
            "FROM employee WHERE salary > #{minSalary}")
    List<Employee> selectBySalaryGreaterThan(@Param("minSalary") BigDecimal minSalary);

    @Select("SELECT COUNT(*) FROM employee")
    int count();

    @Select("SELECT employee_id, name, department, phone, address, salary, email, birth_date " +
            "FROM employee ORDER BY employee_id LIMIT 1")
    Map<String, Object> selectTop1AsMap();

    @Select("SELECT employee_id, name, department, phone, address, salary, email, birth_date " +
            "FROM employee ORDER BY employee_id LIMIT 100")
    List<Map<String, Object>> selectTop100AsListMap();
}
