package com.nosql.springboot.cassandara.domain.project;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProjectRepository extends CassandraRepository<Project, Long> {
}
