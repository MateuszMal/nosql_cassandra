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
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public void updateEmployee(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.birthDate = employee.getBirthDate();
    }

//    public static Employee createNew(){
//
//    }

}
