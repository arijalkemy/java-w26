package com.implementaciondb.ejercicio7_empleados_elasticsearch.repository;

import com.implementaciondb.ejercicio7_empleados_elasticsearch.model.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {


}
