package com.example.qatesters.Service;

import com.example.qatesters.DTO.CreateTestCaseRequest;
import com.example.qatesters.DTO.TestCaseDTO;
import com.example.qatesters.DTO.UpdateTestCaseRequest;
import com.example.qatesters.entity.TestCase;
import com.example.qatesters.exception.NotFoundException;
import com.example.qatesters.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    TestCaseRepository testCaseRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    @Transactional
    public TestCaseDTO createTestCase(CreateTestCaseRequest request) {
        TestCase savedTestCase = testCaseRepository.save(convertToEntity(request));
        return convertToDto(savedTestCase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDTO> getAllTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream()
                .map(this::convertToDto)
                .toList();
    }


    @Override
    @Transactional(readOnly = true)
    public TestCaseDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Test case not found with id: " + id));
        return convertToDto(testCase);
    }

    @Override
    public TestCaseDTO updateTestCase(Long id, UpdateTestCaseRequest request) {
        getTestCaseById(id);
        TestCase testCase = convertToEntity(request, id);
        TestCase updatedTestCase = testCaseRepository.save(testCase);
        return convertToDto(updatedTestCase);
    }

    @Override
    @Transactional
    public String deleteTestCase(Long id) {
        getTestCaseById(id);
        testCaseRepository.deleteById(id);
        return "Test case deleted with id: " + id;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDTO> getTestCasesByDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream()
                .filter(testCase -> testCase.getLastUpdate().isAfter(localDate))
                .map(this::convertToDto)
                .toList();
    }


    private TestCaseDTO convertToDto(TestCase testCase) {
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    private TestCase convertToEntity(CreateTestCaseRequest request) {
        return modelMapper.map(request, TestCase.class);
    }

    private TestCase convertToEntity(UpdateTestCaseRequest request, Long id) {
        TestCase testCase = modelMapper.map(request, TestCase.class);
        testCase.setId(id);
        testCase.setLastUpdate(LocalDate.now());
        return testCase;
    }

}
