package com.bootcamp.qatesters.services;

import com.bootcamp.qatesters.dtos.TestCaseRequestDTO;
import com.bootcamp.qatesters.dtos.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {
    TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO);
    List<TestCaseResponseDTO> getAllTestCases();
    TestCaseResponseDTO getById(Long id);
    List<TestCaseResponseDTO> getByDate(LocalDate date);
    void deleteTestCase(Long id);
    TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO);
}
