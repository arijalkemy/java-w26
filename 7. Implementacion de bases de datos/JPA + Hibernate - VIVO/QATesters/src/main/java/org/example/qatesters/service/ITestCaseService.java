package org.example.qatesters.service;

import org.example.qatesters.dto.TestCaseRequestDTO;
import org.example.qatesters.dto.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    Long create(TestCaseRequestDTO testCaseRequestDTO);
    List<TestCaseResponseDTO> listAll();
    TestCaseResponseDTO getById(Long id);
    TestCaseResponseDTO updateById(Long id, TestCaseRequestDTO testCaseRequestDTO);
    boolean deleteById(Long id);
    List<TestCaseResponseDTO> getUpdatedAfterDate(LocalDate localDate);
}
