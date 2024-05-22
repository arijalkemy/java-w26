package bootcamp.bendezujonathan.elastichsearch.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.bendezujonathan.elastichsearch.dto.request.EmployeeRequest;
import bootcamp.bendezujonathan.elastichsearch.dto.response.EmployeeResponse;

@RequestMapping("/employee")
public interface EmployeeController {
    
    @GetMapping
    ResponseEntity<List<EmployeeResponse>> getAll();

    @PostMapping
    ResponseEntity<Void> postEmployee(@RequestBody EmployeeRequest req);

}
