package com.example.demo.service;

import com.example.demo.model.TestCase;
import com.example.demo.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class TestCaseServiceImpl implements ITestCaseService{

    @Autowired
    ITestCaseRepository testCaseRepository;

    @Transactional
    @Override
    public void createTestCase(TestCase testCase) {
        testCaseRepository.save(testCase);
    }

    @Transactional
    @Override
    public TestCase getTestCaseById(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void updateTestCase(TestCase testCase) {
        TestCase testCase1 = getTestCaseById(testCase.getId_case());
        testCase.setId_case(testCase1.getId_case());
        testCaseRepository.save(testCase);
    }

    @Transactional
    @Override
    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteTestCase(Long id) {
        TestCase testCase2 = getTestCaseById(id);
        testCaseRepository.delete(testCase2);
    }
}
