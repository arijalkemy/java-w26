package org.example.qatesters.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.qatesters.dto.TestCaseRequestDTO;
import org.example.qatesters.dto.TestCaseResponseDTO;
import org.example.qatesters.model.TestCase;
import org.example.qatesters.repository.ITestCaseRepository;
import org.example.qatesters.service.ITestCaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;
    private final ObjectMapper objectMapper;

    private TestCase findTestCaseById(Long id) {
        // TODO: Implementar lanzamiento y manejo de excepcion
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Long create(TestCaseRequestDTO testCaseRequestDTO) {
        TestCase newTestCase = objectMapper.convertValue(testCaseRequestDTO, TestCase.class);
        testCaseRepository.save(newTestCase);
        return newTestCase.getId_case();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDTO> listAll() {
        return testCaseRepository.findAll().stream().map(
                (testCase) -> objectMapper.convertValue(testCase, TestCaseResponseDTO.class)
                ).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResponseDTO getById(Long id) {
        TestCase testCase = findTestCaseById(id);
        return objectMapper.convertValue(testCase, TestCaseResponseDTO.class);
    }

    @Override
    @Transactional
    public TestCaseResponseDTO updateById(Long id, TestCaseRequestDTO testCaseRequestDTO) {
        findTestCaseById(id);
        TestCase updatedTestCase = objectMapper.convertValue(testCaseRequestDTO, TestCase.class);
        updatedTestCase.setId_case(id);
        testCaseRepository.save(updatedTestCase);
        return objectMapper.convertValue(updatedTestCase, TestCaseResponseDTO.class);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDTO> getUpdatedAfterDate(LocalDate localDateFrom) {
        List<TestCase> testCasesList = testCaseRepository.findAll()
                .stream()
                .filter(testCase -> testCase.getLast_update().isAfter(localDateFrom))
                .toList();
        return testCasesList
                .stream()
                .map(testCase -> objectMapper.convertValue(testCase, TestCaseResponseDTO.class))
                .toList();
    }
}
