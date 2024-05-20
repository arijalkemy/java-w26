package bootcamp.bendezujonathan.testcases.service.implementations;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.testcases.dto.request.TestCaseRequest;
import bootcamp.bendezujonathan.testcases.dto.response.MessageResponse;
import bootcamp.bendezujonathan.testcases.dto.response.TestCaseResponse;
import bootcamp.bendezujonathan.testcases.exception.NotFoundException;
import bootcamp.bendezujonathan.testcases.model.TestCase;
import bootcamp.bendezujonathan.testcases.repository.interfaces.TestCaseRepository;
import bootcamp.bendezujonathan.testcases.service.interfaces.TestCaseService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository repository;
    private final ModelMapper MAPPER = new ModelMapper();

    @Override
    public MessageResponse create(TestCaseRequest toCreate) {
        TestCase model = requestToModel(toCreate);
        repository.save(model);

        return new MessageResponse(String.format("Tescase created with ID [%d]", model.getId()));
    }

    @Override
    public List<TestCaseResponse> findAll() {
        return repository.findAll()
        .stream()
        .map(this::modelToResponse)
        .toList();
    }

    public TestCase findModelById(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("No test case for ID [%d]", id)));
    }

    @Override
    public TestCaseResponse findById(long id) {
        TestCase model = findModelById(id);
        return modelToResponse(model);
    }

    @Override
    public List<TestCaseResponse> findAllAfter(LocalDate after) {
        return this.findAll()
        .stream()
        .filter(testcase -> testcase.getLastUpdate().isAfter(after))
        .toList();
    }

    @Override
    public void update(long id, TestCaseRequest toUpdateData) {
       TestCase model = findModelById(id);
       model.update(requestToModel(toUpdateData));
        repository.save(model);
    }

    @Override
    public void delete(long id) {
       TestCase model = findModelById(id);
       repository.delete(model);
    }

    private TestCase requestToModel(TestCaseRequest req){
        return MAPPER.map(req, TestCase.class);
    }

    private TestCaseResponse modelToResponse(TestCase model) {
        return MAPPER.map(model, TestCaseResponse.class);
    }


}
