package com.example.qatester.service;

import com.example.qatester.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestService {

    TestCaseDto addTestCase(TestCaseDto testCaseDto);
    List<TestCaseDto> getAllTestCases();
    TestCaseDto getTestCaseById(Long id);
    TestCaseDto updateTestCase(Long id);
    String deleteTestCase(Long id);
    List<TestCaseDto>filterTestCase(LocalDate updatedTime);
}
