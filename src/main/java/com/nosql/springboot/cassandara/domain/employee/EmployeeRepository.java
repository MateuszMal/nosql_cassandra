package com.nosql.springboot.cassandara.domain.employee;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface EmployeeRepository extends CassandraRepository<Employee, Integer> {
}
