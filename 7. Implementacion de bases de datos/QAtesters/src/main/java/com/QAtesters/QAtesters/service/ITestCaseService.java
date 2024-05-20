package com.QAtesters.QAtesters.service;

import com.QAtesters.QAtesters.model.TestCase;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface ITestCaseService {

    Long saveTestCase(TestCase testCase);
    TestCase getTestCase(Long id);
    String deleteTestCase(Long id);
    List<TestCase> getTestCases();
    List<TestCase> getTestCases( LocalDateTime date);
    TestCase updateTestCase(Long id,TestCase testCase);
    List<TestCase> getTestCasesBefore( LocalDateTime dateTime );
}
