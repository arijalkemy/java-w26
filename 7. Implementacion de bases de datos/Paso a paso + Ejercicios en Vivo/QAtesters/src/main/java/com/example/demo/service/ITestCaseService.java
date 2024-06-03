package com.example.demo.service;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.model.TestCase;

import java.time.LocalDate;
import java.util.List;


public interface ITestCaseService {

    TestCaseDTO createTestCase(TestCaseDTO testCaseDTO);
    TestCaseDTO findTestCaseById(Long id);
    String updateTestCase(Long id, TestCaseDTO testCaseDTO);
    List<TestCaseDTO> getAllTestCases(String last_update);
    String deleteTestCase(Long id);
}
