package com.ejercicio.testcases.service;

import com.ejercicio.testcases.dto.PostRequestDTO;
import com.ejercicio.testcases.dto.PostResponseDTO;
import com.ejercicio.testcases.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    PostResponseDTO createTestCase(PostRequestDTO postRequestDTO);
    List<TestCaseDTO> getAllTestCases();
    TestCaseDTO getTestCaseById(long id);
    TestCaseDTO updateTestCaseById(long id, TestCaseDTO testCaseDTO);
    void deleteTestCaseById(long id);
    List<TestCaseDTO> getAllByLastUpdate(String lastUpdate);
}
