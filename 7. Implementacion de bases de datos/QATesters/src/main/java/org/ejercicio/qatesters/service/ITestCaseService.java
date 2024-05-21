package org.ejercicio.qatesters.service;

import org.ejercicio.qatesters.dto.TestCaseDto;
import org.ejercicio.qatesters.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void saveTestCase(TestCaseDto testCase);
    List<TestCaseDto> getTestCases();
    TestCaseDto getTestCaseById(Long id);
    void deleteTestCaseById(Long id);
    TestCaseDto updateTestCase(Long id,TestCaseDto testCase);
    List<TestCaseDto> getTestCasesByDateUpdated(LocalDate date);
}
