package com.example.qatester.service;

import com.example.qatester.model.TestCase;
import com.example.qatester.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public void createTestCase(TestCase testCase) {
        this.testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCase> getAllTestCase() {
        return this.testCaseRepository.findAll().stream().toList();
    }

    @Override
    public TestCase getTestCaseById(Long id) {
        return getAllTestCase()
                .stream()
                .filter(t -> t.getIdCase().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateTestCaseById(Long id, TestCase updatedTestCase) {
        TestCase testCase = this.testCaseRepository.findById(id).orElse(null);
        if (testCase != null) {
            testCase.setDescription(updatedTestCase.getDescription());
            testCase.setTested(updatedTestCase.getTested());
            testCase.setPassed(updatedTestCase.getPassed());
            testCase.setNumberOfTries(updatedTestCase.getNumberOfTries());
            testCase.setLastUpdate(LocalDate.now());
        }
        this.testCaseRepository.save(testCase);
    }

    @Override
    public void deleteTestCaseById(Long id) {
        this.testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCase> getAllTestCaseUpdatedAfterADate(LocalDate date) {
        return getAllTestCase()
                .stream()
                .filter(t -> t.getLastUpdate().isAfter(date))
                .toList();
    }

}
