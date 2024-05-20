package org.example.templatemvc.Service;

import lombok.RequiredArgsConstructor;
import org.example.templatemvc.Common.Errors.NotFoundException;
import org.example.templatemvc.DTOs.Request.TestCaseRequest;
import org.example.templatemvc.DTOs.Response.TestCaseResponse;
import org.example.templatemvc.Mapper.ITestCaseMapper;
import org.example.templatemvc.Repository.Entity.TestCase;
import org.example.templatemvc.Repository.ITestCaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository repo;
    private final ITestCaseMapper mapper;

    @Override
    @Transactional()
    public TestCaseResponse createTestCase(TestCaseRequest testCaseRequest) {
        TestCase newTestCase = mapper.toTestCase(testCaseRequest);
        TestCase responseEntity = repo.save(newTestCase);
        return mapper.toTestCaseResponse(responseEntity);
    }

    @Override
    @Transactional()
    public TestCaseResponse updateTestCase(Long id, TestCaseRequest testCaseRequest) {
        TestCase testCaseFound = findById(id);
        TestCase testUpdated = mapper.toTestCase(testCaseRequest);
        testUpdated.setId(testCaseFound.getId());
        return mapper.toTestCaseResponse(testUpdated);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        findById(id);
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponse> getAllTestCases() {
        List<TestCase> testCases = repo.findAll();
        return mapper.toTestCaseResponseList(testCases);
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResponse getTestCaseById(Long id) {
        return mapper.toTestCaseResponse(findById(id));
    }

    private TestCase findById(Long id) {
        return repo
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Test case", id.toString()));
    }

}
