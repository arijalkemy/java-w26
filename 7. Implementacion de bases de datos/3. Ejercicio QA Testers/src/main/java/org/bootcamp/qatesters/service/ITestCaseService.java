package org.bootcamp.qatesters.service;

import org.bootcamp.qatesters.dto.TestCaseRequestDTO;
import org.bootcamp.qatesters.dto.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO);
    TestCaseResponseDTO getTestCase(Long id);
    List<TestCaseResponseDTO> getAllTestCases();
    TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO);
    void deleteTestCase(Long id);
    List<TestCaseResponseDTO> getTestCasesByLastUpdate(LocalDate lastUpdate);
}
