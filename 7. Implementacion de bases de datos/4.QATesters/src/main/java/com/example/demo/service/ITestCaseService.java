package com.example.demo.service;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.dto.TestCaseResponseDTO;
import com.example.demo.model.TestCase;

import java.time.LocalDate;
import java.util.List;


public interface ITestCaseService {

    void createTestCase(TestCaseDTO testCase);
    TestCaseResponseDTO getTestCaseById(Long id);
    void updateTestCase(Long id, TestCaseDTO testCase);
    List<TestCaseResponseDTO> getAllTestCases();
    void deleteTestCase(Long id);
    List<TestCaseResponseDTO> getTestCasesByLastUpdate(LocalDate date);
}
