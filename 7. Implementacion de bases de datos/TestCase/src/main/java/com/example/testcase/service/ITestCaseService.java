package com.example.testcase.service;

import com.example.testcase.model.TestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ITestCaseService {
    Long saveTestCase(TestCase testCase);
    TestCase getTestCase(Long id);
    String deleteTestCase(Long id);
    List<TestCase> getTestCases();
    List<TestCase> getTestCases(LocalDate date);
    TestCase updateTestCase(Long id,TestCase testCase);
    List<TestCase> getTestCasesBefore( LocalDateTime dateTime );
}

