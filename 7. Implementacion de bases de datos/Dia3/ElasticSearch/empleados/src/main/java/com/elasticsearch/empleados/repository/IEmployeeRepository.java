package com.elasticsearch.empleados.repository;

import com.elasticsearch.empleados.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
