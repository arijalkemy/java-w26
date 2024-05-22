package com.example.ejerciciocrudconjpavivo.service;

import com.example.ejerciciocrudconjpavivo.dto.request.CreateTestCaseRequestDto;
import com.example.ejerciciocrudconjpavivo.dto.request.UpdateTestCaseRequestDto;
import com.example.ejerciciocrudconjpavivo.dto.response.TestCaseResponseDto;

import java.util.List;

public interface ITestCaseService {
    void createTestCase(CreateTestCaseRequestDto createTestCaseRequestDto);
    List<TestCaseResponseDto> searchAllTestCases(String lastUpdate);
    TestCaseResponseDto searchTestCaseById(Long id);
    void deleteTestCaseById(Long id);
    void updateTestCase(Long id, UpdateTestCaseRequestDto updateTestCaseRequestDto);
}
