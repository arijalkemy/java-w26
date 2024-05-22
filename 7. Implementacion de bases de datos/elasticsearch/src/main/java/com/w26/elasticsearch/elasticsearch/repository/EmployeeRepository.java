package com.w26.elasticsearch.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.w26.elasticsearch.elasticsearch.entity.Employee;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
    
}
