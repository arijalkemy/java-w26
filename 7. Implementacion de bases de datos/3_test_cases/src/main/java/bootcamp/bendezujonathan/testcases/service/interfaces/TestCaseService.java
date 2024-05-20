package bootcamp.bendezujonathan.testcases.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import bootcamp.bendezujonathan.testcases.dto.request.TestCaseRequest;
import bootcamp.bendezujonathan.testcases.dto.response.MessageResponse;
import bootcamp.bendezujonathan.testcases.dto.response.TestCaseResponse;

public interface TestCaseService {
    MessageResponse create(TestCaseRequest toCreate);
    List<TestCaseResponse> findAll();
    TestCaseResponse findById(long id);
    List<TestCaseResponse> findAllAfter(LocalDate after);
    void update(long id, TestCaseRequest toUpdateData);
    void delete(long id);

}
