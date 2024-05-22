package jpa.qatestersvivo.service;

import jpa.qatestersvivo.exception.NotFoundException;
import jpa.qatestersvivo.model.TestCase;
import jpa.qatestersvivo.repository.ITestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService {
    private final ITestCaseRepository repositoryTestCase;

    @Override
    @Transactional
    public TestCase createTestCase(TestCase testCase) {
        return this.repositoryTestCase.save(testCase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCase> getAllTestCases() {
        return this.repositoryTestCase.findAll();

    }

    @Override
    @Transactional
    public TestCase getTestCaseById(Long id) {
        return this.repositoryTestCase.findById(id).orElseThrow(
                () -> new NotFoundException("Test case with id " + id + " not found")
        );
    }

    public TestCase updateTestCase(Long id, TestCase updatedTestCase) {
        TestCase testCase = repositoryTestCase.findById(id).orElseThrow(
                () -> new NotFoundException("TestCase not found: " + updatedTestCase.getIdCase())
        );
        testCase.setDescription(updatedTestCase.getDescription());
        testCase.setTested(updatedTestCase.getTested());
        testCase.setPassed(updatedTestCase.getPassed());
        testCase.setNumberOfTries(updatedTestCase.getNumberOfTries());
        testCase.setLastUpdate(updatedTestCase.getLastUpdate());
        return repositoryTestCase.save(testCase);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        getTestCaseById(id);
        this.repositoryTestCase.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TestCase> getTestCasesByLastUpdate(String lastUpdate) {
        LocalDate date = LocalDate.parse(lastUpdate);
        return repositoryTestCase.findByLastUpdateAfter(date);
    }

}
