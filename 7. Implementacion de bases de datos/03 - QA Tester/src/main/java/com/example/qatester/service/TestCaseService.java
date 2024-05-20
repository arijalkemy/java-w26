package com.example.qatester.service;

import com.example.qatester.dto.requestDto.TestCaseRequestDto;
import com.example.qatester.dto.responseDto.TestCaseResponseDto;
import com.example.qatester.model.TestCase;
import com.example.qatester.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{
    ModelMapper mapper = new ModelMapper();

    @Autowired
    ITestCaseRepository iTestCaseRepository;

    @Override
    public TestCaseResponseDto addTestCase(TestCaseRequestDto testCaseRequestDto) {
        TestCase testCase = iTestCaseRepository.save(mapper.map(testCaseRequestDto, TestCase.class));

        return mapper.map(testCase, TestCaseResponseDto.class);
    }

    @Override
    public List<TestCaseResponseDto> findAllTestCases() {
        List<TestCaseResponseDto> testCaseResponseDtoList = new ArrayList<>();

        for (TestCase testCase : iTestCaseRepository.findAll()){
            testCaseResponseDtoList.add(mapper.map(testCase, TestCaseResponseDto.class));
        }

        return testCaseResponseDtoList;
    }

    @Override
    public TestCaseResponseDto findTestCaseById(Long id) throws Exception {
        TestCase testCase = iTestCaseRepository.findById(id)
                .orElseThrow(() -> new Exception("No existe el test case"));

        return mapper.map(testCase, TestCaseResponseDto.class);
    }

    @Override
    public TestCaseResponseDto editTestCase(Long id, TestCaseRequestDto testCaseRequestDto) throws Exception {
        TestCase testCase = mapper.map(findTestCaseById(id),TestCase.class);

        testCase.setDescription(testCaseRequestDto.getDescription());
        testCase.setTested(testCaseRequestDto.getTested());
        testCase.setPassed(testCaseRequestDto.getPassed());
        testCase.setNumberOfTries(testCaseRequestDto.getNumberOfTries());
        testCase.setLastUpdate(testCaseRequestDto.getLastUpdate());

        iTestCaseRepository.save(testCase);

        return mapper.map(testCase, TestCaseResponseDto.class);
    }

    @Override
    public void deleteTestCase(Long id) throws Exception {
        findTestCaseById(id);

        iTestCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseResponseDto> findTestCasesAfterDate(LocalDate date) {
        List<TestCaseResponseDto> testCaseResponseDtoList = new ArrayList<>();

        for (TestCase testCase : iTestCaseRepository.findAll()){
            if(testCase.getLastUpdate().isAfter(date))
                testCaseResponseDtoList.add(mapper.map(testCase, TestCaseResponseDto.class));
        }

        return testCaseResponseDtoList;
    }
}
