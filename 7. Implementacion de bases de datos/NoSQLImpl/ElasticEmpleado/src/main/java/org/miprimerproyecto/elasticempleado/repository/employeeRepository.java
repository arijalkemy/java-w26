package org.miprimerproyecto.elasticempleado.repository;

import org.miprimerproyecto.elasticempleado.entities.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeeRepository extends ElasticsearchRepository<Employee, String>{
    List<Employee> findAll();

}
