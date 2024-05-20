package com.meli.QA.Testers.service;

import com.meli.QA.Testers.dto.ResponseDto;
import com.meli.QA.Testers.dto.TestCaseDto;

import java.util.List;

public interface ITestCaseService {
    ResponseDto createTestCase(TestCaseDto testCaseDto);

    List<TestCaseDto> getAll();

    TestCaseDto getById(Long id);

    ResponseDto updateTestCase(Long id, TestCaseDto testCaseDto);

    ResponseDto deleteTestCase(Long id);
}
