package com.implbd.qatesters.service;

import com.implbd.qatesters.dto.TestCaseRequestDTO;
import com.implbd.qatesters.dto.TestCaseResponseDTO;
import com.implbd.qatesters.entity.TestCase;
import com.implbd.qatesters.exception.NotFoundException;
import com.implbd.qatesters.repository.ITestCasesRepository;
import com.implbd.qatesters.utils.mappers.TestCaseMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCasesServiceImpl implements ITestCasesService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private final ITestCasesRepository testCasesRepository;

    public TestCasesServiceImpl(ITestCasesRepository testCasesRepository) {
        this.testCasesRepository = testCasesRepository;
    }

    @Override
    public Long createTestCase(TestCaseRequestDTO testCase) {
        TestCase req = this.testCasesRepository.save(TestCaseMapper.mapToTestCase(testCase));
        return req.getIdCase();
    }

    @Override
    public TestCaseResponseDTO updateTestCase(TestCaseRequestDTO testCase) {
        return null;
    }

    @Override
    public void deleteTestCase(Long testCaseId) {
        this.findById(testCaseId);
        this.testCasesRepository.deleteById(testCaseId);
    }

    @Override
    public List<TestCaseResponseDTO> getAllTestCases() {
        return this.testCasesRepository.findAll()
                .stream().map(TestCaseMapper::mapToTestCaseResponseDto)
                .toList();
    }

    @Override
    public List<TestCaseResponseDTO> getAllTestCases(String lastUpdate) {
        LocalDate date = LocalDate.parse(lastUpdate, formatter);
        return this.testCasesRepository.findAll()
                .stream()
                .filter(tc -> tc.getLastUpdate().isAfter(date))
                .map(TestCaseMapper::mapToTestCaseResponseDto)
                .toList();
    }

    @Override
    public TestCaseResponseDTO getTestCaseById(Long testCaseId) {
        TestCase testCase = this.findById(testCaseId);
        return TestCaseMapper.mapToTestCaseResponseDto(testCase);
    }

    private TestCase findById(Long testCaseId) {
        return this.testCasesRepository.findById(testCaseId)
                .orElseThrow(() -> new NotFoundException("Test Case with id: " + testCaseId + " not found"));
    }
}
