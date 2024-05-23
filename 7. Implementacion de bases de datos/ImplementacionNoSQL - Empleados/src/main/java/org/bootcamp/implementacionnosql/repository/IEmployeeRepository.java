package org.bootcamp.implementacionnosql.repository;

import org.bootcamp.implementacionnosql.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String>{
}
