package com.example.qatester.service;

import com.example.qatester.dto.requestDto.TestCaseRequestDto;
import com.example.qatester.dto.responseDto.TestCaseResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDto addTestCase(TestCaseRequestDto testCaseRequestDto);
    List<TestCaseResponseDto> findAllTestCases();
    TestCaseResponseDto findTestCaseById(Long id) throws Exception;
    TestCaseResponseDto editTestCase(Long id, TestCaseRequestDto testCaseRequestDto) throws Exception;
    void deleteTestCase(Long id) throws Exception;
    List<TestCaseResponseDto> findTestCasesAfterDate(LocalDate date);
}
