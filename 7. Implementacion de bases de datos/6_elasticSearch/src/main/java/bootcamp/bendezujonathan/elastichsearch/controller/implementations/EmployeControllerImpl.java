package bootcamp.bendezujonathan.elastichsearch.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.elastichsearch.controller.interfaces.EmployeeController;
import bootcamp.bendezujonathan.elastichsearch.dto.request.EmployeeRequest;
import bootcamp.bendezujonathan.elastichsearch.dto.response.EmployeeResponse;
import bootcamp.bendezujonathan.elastichsearch.service.interfaces.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeControllerImpl implements EmployeeController {

    private final EmployeeService service;

    @Override
    public ResponseEntity<List<EmployeeResponse>> getAll() {
       List<EmployeeResponse> res = service.findAll();
       return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<Void> postEmployee(EmployeeRequest req) {
         service.create(req);
        return ResponseEntity.ok()
                .build();
    }
    
}
