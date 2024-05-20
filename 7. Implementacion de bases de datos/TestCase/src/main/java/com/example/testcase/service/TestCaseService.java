package com.example.testcase.service;

import com.example.testcase.model.TestCase;
import com.example.testcase.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    private ITestRepository testCaseRepository;

    @Override
    @Transactional
    public Long saveTestCase(TestCase testCase) {
        testCase.setLast_update(LocalDate.now());
        TestCase test = testCaseRepository.save(testCase);
        return test.getId_case();

    }

    @Override
    @Transactional (readOnly = true)
    public TestCase getTestCase(Long id) {

        return testCaseRepository.getById(id);
    }
    @Override
    @Transactional
    public String deleteTestCase(Long id) {
        if (testCaseRepository.findById(id).isPresent()){
            testCaseRepository.deleteById(id);
            return "Se eliminó el test con éxito";
        }
        return "No existe";
    }

    @Override
    @Transactional (readOnly = true)
    public List<TestCase> getTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    @Transactional
    public List<TestCase> getTestCases(LocalDate date) {
        return testCaseRepository.findAll().stream().
                filter(t->t.getLast_update().isBefore((date))).toList();
    }

    @Override
    @Transactional
    public TestCase updateTestCase(Long id, TestCase testCase) {
        TestCase test =  testCaseRepository.getById(id);
        test.setDescription(testCase.getDescription());
        test.setLast_update(testCase.getLast_update());
        test.setTested(testCase.getTested());
        test.setPassed(testCase.getPassed());
        test.setNumber_of_tries(testCase.getNumber_of_tries());
        return testCaseRepository.save(test);
    }

    @Override
    @Transactional (readOnly = true)
    public List<TestCase> getTestCasesBefore(LocalDateTime dateTime) {
        return List.of();
    }
}
