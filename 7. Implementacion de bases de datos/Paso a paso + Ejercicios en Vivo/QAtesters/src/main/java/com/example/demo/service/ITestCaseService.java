package com.example.demo.service;

import com.example.demo.model.TestCase;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITestCaseService {

    void createTestCase(TestCase testCase);
    TestCase getTestCaseById(Long id);
    void updateTestCase(TestCase testCase);
    List<TestCase> getAllTestCases();
    void deleteTestCase(Long id);
}
