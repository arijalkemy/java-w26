package org.ejercicio.qatesters.service;

import org.ejercicio.qatesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public class TestCaseService implements ITestCaseService{
    @Override
    public void saveTestCase(TestCaseDto testCase) {

    }

    @Override
    public List<TestCaseDto> getTestCases() {
        return List.of();
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        return null;
    }

    @Override
    public void deleteTestCaseById(Long id) {

    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCase) {
        return null;
    }

    @Override
    public List<TestCaseDto> getTestCasesByDateUpdated(LocalDate date) {
        return List.of();
    }
}
