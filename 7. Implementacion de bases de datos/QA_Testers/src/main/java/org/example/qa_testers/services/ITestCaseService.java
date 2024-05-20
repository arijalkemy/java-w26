package org.example.qa_testers.services;

import org.example.qa_testers.DTO.NewTestCaseResponseDTO;
import org.example.qa_testers.DTO.TestCaseRequestDTO;
import org.example.qa_testers.DTO.TestCaseResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public interface ITestCaseService {
    NewTestCaseResponseDTO createNewTestCase(TestCaseRequestDTO newTest);
    List<TestCaseResponseDTO> findAllTestCases();
    TestCaseResponseDTO findTestCaseById(Long id);
    TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testCase);
    void deleteById(Long id);
    List<TestCaseResponseDTO>findAllTestAfterDate(LocalDate date);
}
