package com.QAtesters.QAtesters.service;

import com.QAtesters.QAtesters.model.TestCase;
import com.QAtesters.QAtesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    @Autowired
    ITestCaseRepository testCaseRepository;

    @Override
    @Transactional
    public Long saveTestCase(TestCase testCase) {
        testCase.setLast_update( LocalDateTime.now() );
        //testCase.setLast_update( LocalDateTime.of(2024,10, 2) );
        TestCase test = testCaseRepository.save(testCase);
        return test.getId_case();
    }

    @Override
    @Transactional( readOnly = true )
    public TestCase getTestCase(Long id) {

        TestCase test = testCaseRepository.getById(id);
        return test;
    }

    @Override
    @Transactional
    public String deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
        return "Elimino OK";
    }

    @Override
    @Transactional( readOnly = true )
    public List<TestCase> getTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public List<TestCase> getTestCases(LocalDateTime date) {
        return testCaseRepository.findAll().stream().filter(t -> t.getLast_update().isBefore(date)).toList();
    }

    @Override
    @Transactional
    public TestCase updateTestCase(Long id, TestCase testCase) {
        TestCase test = testCaseRepository.getById(id);
        test.setDescription( testCase.getDescription() );
        test.setLast_update( LocalDateTime.now() );
        test.setTested( testCase.getTested() );
        test.setPassed( testCase.getPassed() );
        test.setNumber_of_tries(testCase.getNumber_of_tries());

        return testCaseRepository.save(test);
    }

    @Override
    @Transactional( readOnly = true )
    public List<TestCase> getTestCasesBefore(LocalDateTime dateTime) {
        return List.of();
    }
}
