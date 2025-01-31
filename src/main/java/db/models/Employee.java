package db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long employeeId;
    private String name;
    private String department;
    private String phone;
    private String address;
    private BigDecimal salary;
    private String email;
    private LocalDate birthDate;
}
