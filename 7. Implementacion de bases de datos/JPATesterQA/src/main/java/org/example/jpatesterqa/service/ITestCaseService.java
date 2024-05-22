package org.example.jpatesterqa.service;

import org.example.jpatesterqa.dto.TestCaseRequestDto;
import org.example.jpatesterqa.dto.TestCaseResponseDto;
import org.example.jpatesterqa.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDto createTestCase(TestCaseRequestDto testCase);

    TestCaseResponseDto updateTestCase(Long id, TestCaseRequestDto testCase);

    TestCaseResponseDto getTestCase(Long id);

    List<TestCaseResponseDto> getAllTestCases(LocalDate lastUpdate);

    void deleteTestCase(Long id);
}
