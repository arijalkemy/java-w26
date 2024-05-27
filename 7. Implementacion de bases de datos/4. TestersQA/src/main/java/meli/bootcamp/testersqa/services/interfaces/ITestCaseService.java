package meli.bootcamp.testersqa.services.interfaces;

import meli.bootcamp.testersqa.DTOs.TestCaseRequestDTO;
import meli.bootcamp.testersqa.DTOs.TestCaseResponseDTO;

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
