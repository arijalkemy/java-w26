package com.example.elastic.repository;

import com.example.elastic.domain.Employee;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, Integer> {

    @Query ("{\n" +
            "  \"query\": {\n" +
            "    \"match_all\": {}\n" +
            "  }")
    public List<Employee> findAll();

}
