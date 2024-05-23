package com.bootcamp.qatesters.service;

import com.bootcamp.qatesters.models.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCase addTestCase(TestCase t);

    List<TestCase> getAllTestCases();

    TestCase getTestCaseById(Long id);

    TestCase modifyTestCaseById(Long id, TestCase t);

    String deleteTestCaseById(Long id);

    List<TestCase> findTestCasesAfterLastUpdate(LocalDate date);

}
