package com.nosql.springboot.cassandara.domain;

import com.nosql.springboot.cassandara.domain.employee.Employee;
import com.nosql.springboot.cassandara.domain.employee.EmployeeRepository;
import com.nosql.springboot.cassandara.domain.generates_data.EmployeeGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeed implements InitializingBean {

    private final EmployeeRepository employeeRepository;
    private final EmployeeGenerator employeeGenerator;

    public DataSeed(EmployeeRepository employeeRepository, EmployeeGenerator employeeGenerator) {
        this.employeeRepository = employeeRepository;
        this.employeeGenerator = employeeGenerator;
    }

    public void createRandomEmployees() {
        List<Employee> employeeList = employeeGenerator.generate(5000);
        int employeeId = 3;
        for (Employee employee : employeeList) {
            employee.setId(employeeId++);
        }
        employeeRepository.saveAll(employeeList);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        employeeRepository.deleteAll();
        createRandomEmployees();
    }
}
