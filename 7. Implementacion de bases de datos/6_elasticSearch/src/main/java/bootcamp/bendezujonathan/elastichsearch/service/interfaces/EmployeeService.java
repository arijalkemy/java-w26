package bootcamp.bendezujonathan.elastichsearch.service.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.elastichsearch.dto.request.EmployeeRequest;
import bootcamp.bendezujonathan.elastichsearch.dto.response.EmployeeResponse;

public interface EmployeeService {
    
    List<EmployeeResponse> findAll();

    void create(EmployeeRequest req);

}
