package jpa.qatestersvivo.service;

import jpa.qatestersvivo.model.TestCase;

import java.util.List;

public interface ITestCaseService {
    TestCase createTestCase(TestCase testCase);
    List<TestCase> getAllTestCases();
    TestCase getTestCaseById(Long id);
    TestCase updateTestCase(Long id, TestCase updatedTestCase);
    void deleteTestCase(Long id);
    List<TestCase> getTestCasesByLastUpdate(String lastUpdate);
}
