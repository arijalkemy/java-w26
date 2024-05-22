package org.ggomezr.empleadoselasticsearch.domain.repository;

import org.ggomezr.empleadoselasticsearch.domain.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
