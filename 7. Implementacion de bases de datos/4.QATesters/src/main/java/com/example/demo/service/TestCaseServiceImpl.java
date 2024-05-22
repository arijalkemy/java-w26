package com.example.demo.service;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.dto.TestCaseResponseDTO;
import com.example.demo.model.TestCase;
import com.example.demo.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
public class TestCaseServiceImpl implements ITestCaseService{

    @Autowired
    ITestCaseRepository testCaseRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Transactional
    @Override
    public void createTestCase(TestCaseDTO testCase) {
        TestCase testCaseEntity = mapper.convertValue(testCase, TestCase.class);
        testCaseRepository.save(testCaseEntity);
    }

    @Transactional
    @Override
    public TestCaseResponseDTO getTestCaseById(Long id) {
        TestCase testCaseEntity = testCaseRepository.findById(id).orElse(null);
        return mapper.convertValue(testCaseEntity, TestCaseResponseDTO.class);
    }

    @Transactional
    @Override
    public void updateTestCase(Long id, TestCaseDTO testCase) {
        TestCase testCase1 = testCaseRepository.findById(id).orElse(null);
        if (testCase1 != null) {
            testCase1.setDescription(testCase.getDescription());
            testCase1.setTested(testCase.getTested());
            testCase1.setPassed(testCase.getPassed());
            testCase1.setNumber_of_tries(testCase.getNumber_of_tries());
            testCase1.setLastUpdate(testCase.getLast_update());
            testCaseRepository.save(testCase1);
        }
    }

    @Transactional
    @Override
    public List<TestCaseResponseDTO> getAllTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream().map(v -> mapper.convertValue(v, TestCaseResponseDTO.class)).toList();
    }

    @Transactional
    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<TestCaseResponseDTO> getTestCasesByLastUpdate(LocalDate date) {
        List<TestCase> lastUpdatedTestCasesList = testCaseRepository.findByLastUpdate(date);
        return lastUpdatedTestCasesList.stream().map(v -> mapper.convertValue(v, TestCaseResponseDTO.class)).toList();
    }

}
