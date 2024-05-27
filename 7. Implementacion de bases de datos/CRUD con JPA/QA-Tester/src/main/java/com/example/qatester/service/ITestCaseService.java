package com.example.qatester.service;

import com.example.qatester.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void createTestCase(TestCase testCase);
    List<TestCase> getAllTestCase();
    TestCase getTestCaseById(Long id);
    void updateTestCaseById(Long id, TestCase updatedTestCase);
    void deleteTestCaseById(Long id);
    List<TestCase> getAllTestCaseUpdatedAfterADate(LocalDate date);
}
