package com.implbd.qatesters.service;

import com.implbd.qatesters.dto.TestCaseRequestDTO;
import com.implbd.qatesters.dto.TestCaseResponseDTO;

import java.util.List;

public interface ITestCasesService {

    Long createTestCase(TestCaseRequestDTO testCase);

    TestCaseResponseDTO updateTestCase(TestCaseRequestDTO testCase);

    void deleteTestCase(Long testCaseId);

    List<TestCaseResponseDTO> getAllTestCases();

    List<TestCaseResponseDTO> getAllTestCases(String lastUpdate);

    TestCaseResponseDTO getTestCaseById(Long testCaseId);
}
