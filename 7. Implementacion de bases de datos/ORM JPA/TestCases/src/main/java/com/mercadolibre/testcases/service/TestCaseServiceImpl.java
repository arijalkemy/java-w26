package com.mercadolibre.testcases.service;

import com.mercadolibre.testcases.dto.TestCaseDTO;
import com.mercadolibre.testcases.dto.TestCaseResponseDTO;
import com.mercadolibre.testcases.exception.TestCaseNotFoundException;
import com.mercadolibre.testcases.model.TestCase;
import com.mercadolibre.testcases.repository.ITestCasesRepository;
import com.mercadolibre.testcases.utils.LocalDateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private ITestCasesRepository testCasesRepository;

    public TestCaseServiceImpl(ITestCasesRepository testCasesRepository) {
        this.testCasesRepository = testCasesRepository;
    }

    @Override
    @Transactional
    public Long createTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = defineTestCase(testCaseDTO);
        return testCasesRepository.save(testCase).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDTO> getAllTestCases(String lastUpdate) {
        List<TestCase> responseTestCases;
        if (lastUpdate == null) {
            responseTestCases = testCasesRepository.findAll();
        } else{
            responseTestCases = testCasesRepository.findAll()
                    .stream()
                    .filter(testCase -> testCase.getLastUpdate().isAfter(LocalDateMapper.toLocalDate(lastUpdate)))
                    .toList();
        }
        return responseTestCases
                .stream()
                .map(testCase -> new ModelMapper().map(testCase, TestCaseResponseDTO.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResponseDTO getTestCase(Long id) {
        TestCase testCaseToFind = findAndCheckTestCaseById(id);
        return new ModelMapper().map(testCaseToFind, TestCaseResponseDTO.class);
    }

    @Override
    @Transactional
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        TestCase testCaseToUpdate = findAndCheckTestCaseById(id);
        updateTestCaseByDTOInfo(testCaseToUpdate, testCaseDTO);
        return new ModelMapper().map(testCaseToUpdate, TestCaseResponseDTO.class);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        findAndCheckTestCaseById(id);
        testCasesRepository.deleteById(id);
    }

    private void updateTestCaseByDTOInfo(TestCase testCaseToUpdate, TestCaseDTO testCaseDTO) {
        testCaseToUpdate.setDescription(testCaseDTO.getDescription());
        testCaseToUpdate.setTested(testCaseDTO.getTested());
        testCaseToUpdate.setPassed(testCaseDTO.getPassed());
        testCaseToUpdate.setNumberOfTries(testCaseDTO.getNumberOfTries());
        testCaseToUpdate.setLastUpdate(LocalDate.now());
        testCasesRepository.save(testCaseToUpdate);
    }

    private TestCase findAndCheckTestCaseById(Long id) {
        TestCase testCase = testCasesRepository.findById(id).orElse(null);
        if(testCase == null){
            throw new TestCaseNotFoundException("Test case with id " + id + " not found");
        }
        return testCase;
    }

    private static TestCase defineTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = new ModelMapper().map(testCaseDTO, TestCase.class);
        testCase.setLastUpdate(LocalDate.now());
        return testCase;
    }
}
