package org.example.jpatesterqa.service.impl;

import org.example.jpatesterqa.dto.TestCaseRequestDto;
import org.example.jpatesterqa.dto.TestCaseResponseDto;
import org.example.jpatesterqa.exception.NotFoundTestCase;
import org.example.jpatesterqa.model.TestCase;
import org.example.jpatesterqa.repository.ITestCaseRepository;
import org.example.jpatesterqa.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(@Autowired ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    @Transactional
    public TestCaseResponseDto createTestCase(TestCaseRequestDto requestDto) {
        ModelMapper modelMapper = new ModelMapper();
        TestCase newTestCase = testCaseRepository.save(modelMapper.map(requestDto, TestCase.class));
        return modelMapper.map(newTestCase, TestCaseResponseDto.class);
    }

    @Override
    @Transactional
    public TestCaseResponseDto updateTestCase(Long id, TestCaseRequestDto requestDto) {
        ModelMapper modelMapper = new ModelMapper();
        TestCase testCase = findTestCaseById(id);
        TestCase temp = modelMapper.map(requestDto, TestCase.class);
        temp.setId(id);
        return modelMapper.map(testCaseRepository.save(temp), TestCaseResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResponseDto getTestCase(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(findTestCaseById(id), TestCaseResponseDto.class);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<TestCaseResponseDto> getAllTestCases(LocalDate lastUpdate) {
        ModelMapper modelMapper = new ModelMapper();
        List<TestCaseResponseDto> response = testCaseRepository
                .findAll()
                .stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseResponseDto.class))
                .toList();
        if (lastUpdate != null) {
            return response.stream()
                    .filter(test -> test.getLastUpdate().isEqual(lastUpdate))
                    .toList();
        }
        return response;
    }

    @Transactional
    protected TestCase findTestCaseById(Long id) {
        return testCaseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundTestCase("Test case with id " + id + " not found",
                        HttpStatus.NOT_FOUND));
    }
}
