package com.nosql.springboot.cassandara.domain.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> fetchEmployees() {
        List<Employee> employeeList = employeeService.fetchAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> fetchEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.fetchEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee employeeDto = employeeService.createNewEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);
    }

    @PutMapping("/employess/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee employeeDto = employeeService.updateEmployee(id, employee);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
