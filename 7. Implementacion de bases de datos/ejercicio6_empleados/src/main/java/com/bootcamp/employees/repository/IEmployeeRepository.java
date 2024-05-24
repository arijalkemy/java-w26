package com.bootcamp.employees.repository;

import com.bootcamp.employees.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findAll();
    Optional<Employee> findById(String id);


}
