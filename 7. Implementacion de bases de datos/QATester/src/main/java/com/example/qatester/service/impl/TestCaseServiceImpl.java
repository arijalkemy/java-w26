package com.example.qatester.service.impl;

import com.example.qatester.dto.ResponseDTO;
import com.example.qatester.dto.TestCaseDTO;
import com.example.qatester.model.TestCase;
import com.example.qatester.repository.TestCaseRepository;
import com.example.qatester.service.ITestCaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    @Autowired
    TestCaseRepository testCaseRepository;

    @Override
    public ResponseDTO createTestCase(TestCaseDTO testCase) {
        TestCase testCaseSaved = testCaseRepository.save(testCaseDTOToTestCase(testCase));
        String message = "The test case "+testCaseSaved.getId()+" has been created";
        return new ResponseDTO(message);
    }

    @Override
    public ResponseDTO updateTestCase(Long id, TestCaseDTO testCase) {
        TestCase newCase = testCaseDTOToTestCase(testCase);
        newCase.setId(id);
        testCaseRepository.save(newCase);
        String message = "The test case "+id+" has been updated";
        return new ResponseDTO(message);
    }

    @Override
    public TestCaseDTO getTestCase(Long id) {
        return testCaseToTestCaseDTO(testCaseRepository.findById(id).orElse(null));
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        List<TestCaseDTO> cases = new ArrayList<>();
        for(TestCase t: testCaseRepository.findAll()){
            cases.add(testCaseToTestCaseDTO(t));
        }
        return cases;
    }

    @Override
    public ResponseDTO deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
        String message = "The test case "+id+" has been deleted";
        return new ResponseDTO(message);
    }

    public TestCase testCaseDTOToTestCase (TestCaseDTO testCase){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(testCase, TestCase.class);
    }

    public TestCaseDTO testCaseToTestCaseDTO (TestCase testCase){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(testCase, TestCaseDTO.class);
    }
}
