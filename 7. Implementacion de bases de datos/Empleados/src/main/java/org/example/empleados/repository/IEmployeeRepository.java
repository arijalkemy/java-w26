package org.example.empleados.repository;

import org.example.empleados.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findAll();
    Page<Employee> findAllByDepartmentContainingIgnoreCase(String depto, Pageable pageable);
}
