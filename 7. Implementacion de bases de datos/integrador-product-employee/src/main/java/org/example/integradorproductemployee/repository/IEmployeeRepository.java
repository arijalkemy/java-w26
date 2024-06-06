package org.example.integradorproductemployee.repository;

import org.example.integradorproductemployee.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
