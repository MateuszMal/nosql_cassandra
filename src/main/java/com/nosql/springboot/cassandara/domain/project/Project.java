package com.nosql.springboot.cassandara.domain.project;

import com.nosql.springboot.cassandara.domain.employee.Employee;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;

@Data
@Table
@Getter
@NoArgsConstructor
public class Project {
    @PrimaryKey
    private Integer id;
    private String projectName;
    private LocalDate startProjectDate;
    private List<Employee> employeeList;
}
