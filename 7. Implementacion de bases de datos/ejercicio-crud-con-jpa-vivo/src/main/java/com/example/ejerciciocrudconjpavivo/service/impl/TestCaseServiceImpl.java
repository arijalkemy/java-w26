package com.example.ejerciciocrudconjpavivo.service.impl;

import com.example.ejerciciocrudconjpavivo.dto.request.CreateTestCaseRequestDto;
import com.example.ejerciciocrudconjpavivo.dto.request.UpdateTestCaseRequestDto;
import com.example.ejerciciocrudconjpavivo.dto.response.TestCaseResponseDto;
import com.example.ejerciciocrudconjpavivo.exception.TestCaseNotFound;
import com.example.ejerciciocrudconjpavivo.model.TestCase;
import com.example.ejerciciocrudconjpavivo.repository.ITestCaseRepository;
import com.example.ejerciciocrudconjpavivo.service.ITestCaseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;

    @Override
    public void createTestCase(CreateTestCaseRequestDto createTestCaseRequestDto) {
        TestCase testCase = new ModelMapper().map(createTestCaseRequestDto, TestCase.class);
        testCase.setLastUpdate(LocalDate.now());
        testCase.setNumberOfTries(0);
        testCase.setTested(false);
        testCase.setPassed(false);

        testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCaseResponseDto> searchAllTestCases(String lastUpdate) {
        ModelMapper mapper = new ModelMapper();
        List<TestCase> testCases;

        if(lastUpdate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(lastUpdate, formatter);
            testCases = testCaseRepository.findAllByLastUpdateAfter(date);
        } else {
            testCases = testCaseRepository.findAll();
        }

        return testCases.stream().map(testCase -> mapper.map(testCase, TestCaseResponseDto.class)).toList();
    }

    @Override
    public TestCaseResponseDto searchTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new TestCaseNotFound("Test case with id '"+ id +"' not found."));
        return new ModelMapper().map(testCase, TestCaseResponseDto.class);
    }

    @Override
    public void deleteTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new TestCaseNotFound("Test case with id '"+ id +"' not found."));
        testCaseRepository.delete(testCase);
    }

    @Override
    public void updateTestCase(Long id, UpdateTestCaseRequestDto updateTestCaseRequestDto) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new TestCaseNotFound("Test case with id '"+ id +"' not found."));
        if(updateTestCaseRequestDto.getDescription() != null) {
            testCase.setDescription(updateTestCaseRequestDto.getDescription());
        }
        if(updateTestCaseRequestDto.getTested() != null) {
            testCase.setTested(updateTestCaseRequestDto.getTested());
        }
        if(updateTestCaseRequestDto.getPassed() != null) {
            testCase.setPassed(updateTestCaseRequestDto.getPassed());
        }
        testCase.setLastUpdate(LocalDate.now());
        testCase.setNumberOfTries(testCase.getNumberOfTries() + 1);
        testCaseRepository.save(testCase);
    }
}
