package org.ejercicio.qatesters.service;

import org.ejercicio.qatesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void saveTestCase(TestCaseDto testCaseDto);
    List<TestCaseDto> getTestCases(LocalDate date);
    TestCaseDto getTestCaseById(Long id);
    void deleteTestCaseById(Long id);
    TestCaseDto updateTestCase(Long id,TestCaseDto testCaseDto);
}
