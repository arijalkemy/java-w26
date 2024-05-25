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
import java.util.Collections;
import java.util.List;

@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    ITestRepository testRepository;

    @Override
    public TestCaseDto addTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = convertDtoToTestCase(testCaseDto);
        TestCase returnValue = testRepository.save(testCase);
        return convertTestCaseToDto(returnValue);
    }

    @Override
    public List<TestCaseDto> getAllTestCases() {
        List<TestCase> testCases = testRepository.findAll();
        return testCases.stream().map(this::convertTestCaseToDto).toList();
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        TestCase testCase = testRepository.findById(id).orElseThrow(() -> new NotFoundException("No encontrado"));
        return convertTestCaseToDto(testCase);
    }

    @Override
    public TestCaseDto updateTestCase(Long id) {
        TestCase testCase = testRepository.findById(id).orElseThrow(() -> new NotFoundException("No encontrado"));
        testCase.setId(id);
        testRepository.save(testCase);
        return convertTestCaseToDto(testCase);
    }

    @Override
    public String deleteTestCase(Long id) {
        TestCase testCase = testRepository.findById(id).orElseThrow(() -> new NotFoundException("No encontrado"));
        testRepository.delete(testCase);
        return "Se elimino con exito";
    }

    @Override
    public List<TestCaseDto> filterTestCase(LocalDate updatedTime) {
        List<TestCase> testCases = testRepository.findAllByLocalDateAfter();
        List<TestCaseDto> testCaseDtos = new ArrayList<>();
        for (TestCase testCase : testCases) {
            testCaseDtos.add(convertTestCaseToDto(testCase));
        }
        return testCaseDtos;
    }

    private TestCaseDto convertTestCaseToDto(TestCase testCase) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(testCase, TestCaseDto.class);
    }

    private TestCase convertDtoToTestCase(TestCaseDto testCaseDto) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(testCaseDto, TestCase.class);
    }
}
