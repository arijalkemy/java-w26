package org.example.qa.service;

import org.example.qa.dto.TestCaseRequestDTO;
import org.example.qa.dto.TestCaseResponseDTO;
import org.example.qa.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    List<TestCaseResponseDTO> getTestCases();
    List<TestCaseResponseDTO> getTestCasesFiltered(LocalDate last_update);
    TestCaseResponseDTO getTestCaseById(Long id);
    TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCase);
    TestCaseResponseDTO updateTestCase(TestCaseRequestDTO testCase, Long id);
    String deleteTestCase(Long id);

}
