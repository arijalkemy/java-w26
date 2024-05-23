package com.bootcamp.qatesters.service;

import com.bootcamp.qatesters.models.TestCase;
import com.bootcamp.qatesters.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements  ITestCaseService{

    private final ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }


    @Override
    public TestCase addTestCase(TestCase t) {

        return testCaseRepository.save(t);
    }

    @Override
    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase getTestCaseById(Long id) {
        Optional<TestCase> testFound = testCaseRepository.findById(id);
        if (testFound.isEmpty()){
            throw new RuntimeException("No se encontro un test con el ID:" + id);
        }

        return testFound.get();
    }

    @Override
    public TestCase modifyTestCaseById(Long id, TestCase t) {
        Optional<TestCase> testFound = testCaseRepository.findById(id);
        if (testFound.isEmpty()){
            throw new RuntimeException("No se encontro un test con el ID:" + id);
        }
        testFound.get().setDescripcion(t.getDescripcion());
        testFound.get().setTested(t.isTested());
        testFound.get().setPassed(t.isPassed());
        testFound.get().setLastUpdate(t.getLastUpdate());
        testFound.get().setNumber_of_tries(t.getNumber_of_tries());
        return testCaseRepository.save(testFound.get());
    }

    @Override
    public String deleteTestCaseById(Long id) {
        Optional<TestCase> testFound = testCaseRepository.findById(id);
        if (testFound.isEmpty()){
            throw new RuntimeException("No se encontro un test con el ID:" + id);
        }
        testCaseRepository.delete(testFound.get());
        return "TestCase deleted successfully.";
    }

    @Override
    public List<TestCase> findTestCasesAfterLastUpdate(LocalDate date) {
        return testCaseRepository.findByLastUpdateAfter(date);
    }
}
