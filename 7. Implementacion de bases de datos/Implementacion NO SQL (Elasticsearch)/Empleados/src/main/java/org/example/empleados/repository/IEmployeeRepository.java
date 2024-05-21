package org.example.empleados.repository;

import org.example.empleados.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
