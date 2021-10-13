package com.nosql.springboot.cassandara.domain.employee;

import com.nosql.springboot.common.EntityNotFoundException;
import com.nosql.springboot.common.NullIdException;
import com.nosql.springboot.common.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee fetchEmployeeById(Long id) {
        Validator.checkIdIsNull(id);
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee [" + id + "] not found."));
    }

    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Validator.checkIdIsNull(id);
        Employee updatedEmployee = employeeRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Employee [" + id + "] not found."));
        updatedEmployee.updateEmployee(employee);
        return employeeRepository.save(updatedEmployee);
    }

    public void deleteEmployeeById(Long id) {
        Validator.checkIdIsNull(id);
        employeeRepository.deleteById(id);
    }


}
