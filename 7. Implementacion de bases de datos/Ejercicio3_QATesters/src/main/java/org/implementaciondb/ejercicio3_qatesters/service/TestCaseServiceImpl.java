package org.implementaciondb.ejercicio3_qatesters.service;

import org.implementaciondb.ejercicio3_qatesters.dto.TestCaseRequest;
import org.implementaciondb.ejercicio3_qatesters.dto.TestCaseResponse;
import org.implementaciondb.ejercicio3_qatesters.entity.TestCase;
import org.implementaciondb.ejercicio3_qatesters.exception.NoContentException;
import org.implementaciondb.ejercicio3_qatesters.exception.NotFoundException;
import org.implementaciondb.ejercicio3_qatesters.mapper.TestCaseMapper;
import org.implementaciondb.ejercicio3_qatesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final String TEST_CASE_NOT_FOUND = "Test Case no encontrado";

    @Autowired
    private ITestCaseRepository testCaseRepository;

    @Override
    public TestCaseResponse saveTestCase(TestCaseRequest testCaseRequest) {
        TestCase testCase = testCaseRepository.save(TestCaseMapper.mapToTestCase(testCaseRequest));
        return TestCaseMapper.mapToTestCaseDto(testCase);
    }

    @Override
    public List<TestCaseResponse> findAllTestCases() {
        List<TestCase> testCases =  testCaseRepository.findAll();
        if (testCases.isEmpty()) {
            throw new NoContentException();
        }
        return testCases.stream().map(TestCaseMapper::mapToTestCaseDto).toList();
    }

    @Override
    public TestCaseResponse findTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(TEST_CASE_NOT_FOUND));
        return TestCaseMapper.mapToTestCaseDto(testCase);
    }

    @Override
    public TestCaseResponse updateTestCase(Long id, TestCaseRequest testCaseRequest) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(TEST_CASE_NOT_FOUND));
        testCase.setIdCase(id);
        testCase.setLastUpdate(LocalDate.now());
        testCase = testCaseRepository.save(testCase);
        return TestCaseMapper.mapToTestCaseDto(testCase);
    }

    @Override
    public TestCaseResponse deleteTestCase(Long id) {
        TestCaseResponse testCase = findTestCaseById(id);
        testCaseRepository.deleteById(id);
        return testCase;
    }

    @Override
    public List<TestCaseResponse> findTestCasesByDate(LocalDate lastUpdate) {
        List<TestCaseResponse> testCases = findAllTestCases();
        List<TestCaseResponse> result = testCases.stream().filter(tc -> tc.getLastUpdate().isAfter(lastUpdate)).toList();
        if (result.isEmpty()) {
            throw new NoContentException();
        }
        return result;
    }
}
