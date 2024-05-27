package com.mercadolibre.testcases.service;

import com.mercadolibre.testcases.dto.TestCaseDTO;
import com.mercadolibre.testcases.dto.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    Long createTestCase(TestCaseDTO testCaseDTO);

    List<TestCaseResponseDTO> getAllTestCases(String lastUpdate);

    TestCaseResponseDTO getTestCase(Long id);

    TestCaseResponseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO);

    void deleteTestCase(Long id);
}
