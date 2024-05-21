package com.example.qatester.service;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.exception.NotFoundException;
import com.example.qatester.model.TestCase;
import com.example.qatester.repository.ITestRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    ITestRepository testRepository;

    @Override
    public TestCaseDto addTestCase(TestCaseDto testCaseDto) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TestCase testCase = mapper.convertValue(testCaseDto, TestCase.class);
        TestCase returnValue = testRepository.save(testCase);

        return mapper.convertValue(returnValue, TestCaseDto.class);
    }

    @Override
    public List<TestCaseDto> getAllTestCases() {

        List<TestCase> testCases = testRepository.findAll();


        return testCases.stream().map(item -> convertTestCaseToDto(item)).toList();
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {

        TestCase testCase = testRepository.findById(id).orElseThrow(() -> new NotFoundException("No encontrado"));

        return convertTestCaseToDto(testCase);
    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {

        TestCase testCase = testRepository.findById(id).orElseThrow(() -> new NotFoundException("No encontrado"));

        TestCase modifiedTest = convertDtoToTestCase(testCaseDto);
        modifiedTest.setId(id);

        testRepository.save(modifiedTest);

        return convertTestCaseToDto(modifiedTest);
    }

    @Override
    public List<TestCaseDto> deleteTestCase(Long id) {
        if(testRepository.existsById(id)) {
            testRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("No encontrado");
        }

        return testRepository.findAll().stream().map(item -> convertTestCaseToDto(item)).toList();
    }

    @Override
    public List<TestCaseDto> filterTestCase(LocalDate updatedTime) {
        List<TestCase> allTests = testRepository.findAll();
        List<TestCase> filteredTests = allTests.stream()
                .filter(testCase -> testCase.getLast_update().equals(updatedTime))
                .collect(Collectors.toList());
        return filteredTests.stream()
                .map(this::convertTestCaseToDto)
                .collect(Collectors.toList());
    }

    private TestCaseDto convertTestCaseToDto(TestCase testCase) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TestCaseDto testCaseDto = mapper.convertValue(testCase, TestCaseDto.class);
        return testCaseDto;
    }

    private TestCase convertDtoToTestCase(TestCaseDto testCaseDto) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TestCase testCase = mapper.convertValue(testCaseDto, TestCase.class);
        return testCase;

    }
}
