package bootcamp.bendezujonathan.elastichsearch.repository.interfaces;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.elastichsearch.model.Employee;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, Long> {
    
}
