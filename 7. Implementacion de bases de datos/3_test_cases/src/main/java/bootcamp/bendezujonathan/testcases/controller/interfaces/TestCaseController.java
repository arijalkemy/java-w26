package bootcamp.bendezujonathan.testcases.controller.interfaces;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.testcases.dto.request.TestCaseRequest;
import bootcamp.bendezujonathan.testcases.dto.response.MessageResponse;
import bootcamp.bendezujonathan.testcases.dto.response.TestCaseResponse;

@RequestMapping("/testcases")
public interface TestCaseController {
    
    @PostMapping
    ResponseEntity<MessageResponse> postTestCase(@RequestBody TestCaseRequest req);

    @GetMapping
    ResponseEntity<List<TestCaseResponse>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<TestCaseResponse> getById(@PathVariable long id);

    @PutMapping("/{id}")
    ResponseEntity<Void> putTestCase(@PathVariable long id, @RequestBody TestCaseRequest req);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTestCase(@PathVariable long id);

    @GetMapping(value = "", params = {"last_update"})
    ResponseEntity<List<TestCaseResponse>> getAllByLastUpdate(@RequestParam(name = "last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fechaDesde); 

}