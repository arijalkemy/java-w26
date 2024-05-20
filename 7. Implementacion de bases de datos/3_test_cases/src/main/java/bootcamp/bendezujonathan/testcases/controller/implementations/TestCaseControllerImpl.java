package bootcamp.bendezujonathan.testcases.controller.implementations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.testcases.controller.interfaces.TestCaseController;
import bootcamp.bendezujonathan.testcases.dto.request.TestCaseRequest;
import bootcamp.bendezujonathan.testcases.dto.response.MessageResponse;
import bootcamp.bendezujonathan.testcases.dto.response.TestCaseResponse;
import bootcamp.bendezujonathan.testcases.service.interfaces.TestCaseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestCaseControllerImpl  implements TestCaseController {

    private final TestCaseService service;

    @Override
    public ResponseEntity<MessageResponse> postTestCase(TestCaseRequest req) {
        MessageResponse res = service.create(req);
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<List<TestCaseResponse>> getAll() {
        List<TestCaseResponse> res = service.findAll();
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<TestCaseResponse> getById(long id) {
        TestCaseResponse res = service.findById(id);
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<Void> putTestCase(long id, TestCaseRequest req) {
        service.update(id, req); 
        return ResponseEntity.noContent()
            .build();
    }

    @Override
    public ResponseEntity<Void> deleteTestCase(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
        .build();
    }

    @Override
    public ResponseEntity<List<TestCaseResponse>> getAllByLastUpdate(LocalDate fechaDesde) {
       List<TestCaseResponse> res = service.findAllAfter(fechaDesde);
       return ResponseEntity.ok(res);
    }
    
}
