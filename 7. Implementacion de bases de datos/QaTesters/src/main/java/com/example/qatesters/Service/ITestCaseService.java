package com.example.qatesters.Service;

import com.example.qatesters.DTO.CreateTestCaseRequest;
import com.example.qatesters.DTO.TestCaseDTO;
import com.example.qatesters.DTO.UpdateTestCaseRequest;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseDTO createTestCase(CreateTestCaseRequest request);

    List<TestCaseDTO> getAllTestCases();

    TestCaseDTO getTestCaseById(Long id);

    TestCaseDTO updateTestCase(Long id, UpdateTestCaseRequest request);

    String deleteTestCase(Long id);

    List<TestCaseDTO> getTestCasesByDate(String date);

}
