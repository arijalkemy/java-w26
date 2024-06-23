package org.example.qa.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.qa.dto.TestCaseRequestDTO;
import org.example.qa.dto.TestCaseResponseDTO;
import org.example.qa.entity.TestCase;
import org.example.qa.repository.TestCaseRepository;
import org.example.qa.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    private ObjectMapper objectMapper;

    public TestCaseServiceImpl() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }


    @Override
    public List<TestCaseResponseDTO> getTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream().map(this::convertTestCaseResponseDTO).toList();
    }

    @Override
    public List<TestCaseResponseDTO> getTestCasesFiltered(LocalDate last_update) {
        List<TestCaseResponseDTO> tests = getTestCases();
        return tests.stream().filter(test -> test.getLast_update().isAfter(last_update)).toList();
    }

    @Override
    public TestCaseResponseDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return convertTestCaseResponseDTO(testCase);
    }

    @Override
    public TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCase) {
        TestCase newTestCase = convertToTestCase(testCase);
        return convertTestCaseResponseDTO(testCaseRepository.save(newTestCase));
    }

    @Override
    public TestCaseResponseDTO updateTestCase(TestCaseRequestDTO testCase, Long id) {
        TestCase testCaseUpdate = testCaseRepository.findById(id).orElse(null);
        if (testCaseUpdate != null) {
            testCaseUpdate = convertToTestCase(testCase);
            testCaseUpdate.setId_case(id);
            return convertTestCaseResponseDTO(testCaseRepository.save(testCaseUpdate));

        }
        return new TestCaseResponseDTO();
    }

    @Override
    public String deleteTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase != null) {
            testCaseRepository.delete(testCase);
            return "Successfully deleted test case";
        }
        return "Test case not found";
    }

    TestCase convertToTestCase(TestCaseRequestDTO test) {
        return objectMapper.convertValue(test, TestCase.class);
    }

    TestCaseResponseDTO convertTestCaseResponseDTO(TestCase test) {
        return objectMapper.convertValue(test, TestCaseResponseDTO.class);
    }
}
