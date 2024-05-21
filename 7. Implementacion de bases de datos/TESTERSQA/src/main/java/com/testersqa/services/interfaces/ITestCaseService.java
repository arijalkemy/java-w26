package com.testersqa.services.interfaces;

import com.testersqa.DTOs.TestCaseRequestDTO;
import com.testersqa.DTOs.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    // create
    TestCaseResponseDTO create(TestCaseRequestDTO testCaseRequestDTO);
    List<TestCaseResponseDTO> findAll();
    // read
    TestCaseResponseDTO findById(Long id);
    // update
    TestCaseResponseDTO update(Long id, TestCaseRequestDTO testCaseRequestDTO);
    // delete
    void delete(Long id);

    List<TestCaseResponseDTO> findTestCasesUpdatedAfter(LocalDate date);
}
