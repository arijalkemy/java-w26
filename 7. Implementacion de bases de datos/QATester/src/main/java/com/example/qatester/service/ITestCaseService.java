package com.example.qatester.service;

import com.example.qatester.dto.ResponseDTO;
import com.example.qatester.dto.TestCaseDTO;

import java.util.List;

public interface ITestCaseService {
    ResponseDTO createTestCase(TestCaseDTO testCase);
    ResponseDTO updateTestCase(Long id, TestCaseDTO testCase);
    TestCaseDTO getTestCase(Long id);
    List<TestCaseDTO> getAllTestCases();
    ResponseDTO deleteTestCase(Long id);
}
