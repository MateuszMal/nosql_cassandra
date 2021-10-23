package com.nosql.springboot.cassandara.domain.employee;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table
@Getter
@NoArgsConstructor
public class Employee {
    @PrimaryKey
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfEmployment;
    private String emailAddress;
    private String deviceMacAddress;
    private String password;

    public void updateEmployee(Employee employee) {
        this.id= employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.dateOfEmployment = employee.getDateOfEmployment();
        this.emailAddress = employee.getEmailAddress();
        this.deviceMacAddress = employee.getDeviceMacAddress();
        this.password = employee.getPassword();
    }

}
