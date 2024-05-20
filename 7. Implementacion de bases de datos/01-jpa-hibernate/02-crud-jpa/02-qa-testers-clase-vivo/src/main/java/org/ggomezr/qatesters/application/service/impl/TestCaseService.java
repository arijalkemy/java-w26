package org.ggomezr.qatesters.application.service.impl;

import org.ggomezr.qatesters.application.service.interfaces.ITestCaseService;
import org.ggomezr.qatesters.domain.dto.ResponseDTO;
import org.ggomezr.qatesters.domain.dto.TestCaseDTO;
import org.ggomezr.qatesters.domain.exception.NotFoundException;
import org.ggomezr.qatesters.domain.model.TestCase;
import org.ggomezr.qatesters.domain.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    private final ModelMapper modelMapper;

    public TestCaseService(ITestCaseRepository testCaseRepository, ModelMapper modelMapper) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TestCaseDTO createTestCase(TestCaseDTO testCaseDTO) {
        testCaseRepository.save(convertTestCaseDtoToTestCase(testCaseDTO));
        return testCaseDTO;
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        return testCaseRepository.findAll().stream()
                .map(this::convertTestCaseToTestCaseDto)
                .toList();
    }

    @Override
    public TestCaseDTO getTestCaseById(Long id) {
        Optional<TestCase> currentTestCase = testCaseRepository.findById(id);

        if(currentTestCase.isEmpty()) throw new NotFoundException("Test case not found");

        return convertTestCaseToTestCaseDto(currentTestCase.get());
    }

    @Override
    public ResponseDTO updatedTestCase(Long id, TestCaseDTO testCaseDTO) {
        Optional<TestCase> currentTestCase = testCaseRepository.findById(id);

        if(currentTestCase.isEmpty()) throw new NotFoundException("Test case not found");

        currentTestCase.get().setDescription(testCaseDTO.getDescription());
        currentTestCase.get().setTested(testCaseDTO.getTested());
        currentTestCase.get().setPassed(testCaseDTO.getPassed());
        currentTestCase.get().setNumber_of_tries(testCaseDTO.getNumber_of_tries());
        currentTestCase.get().setLast_update(testCaseDTO.getLast_update());

        testCaseRepository.save(currentTestCase.get());

        return new ResponseDTO("Test case with id " + currentTestCase.get().getId_case() + " has been updated");
    }

    @Override
    public ResponseDTO deleteTestCase(Long id) {
        Optional<TestCase> currentTestCase = testCaseRepository.findById(id);

        if(currentTestCase.isEmpty()) throw new NotFoundException("Test case not found");

        testCaseRepository.deleteById(id);

        return new ResponseDTO("Test case with id " + currentTestCase.get().getId_case() + " has been deleted");
    }

    @Override
    public List<TestCaseDTO> getTestCasesAfterLastUpdateDate(LocalDate date) {
        return testCaseRepository.findTestCaseByLast_updateAfter(date)
                .stream()
                .map(this::convertTestCaseToTestCaseDto)
                .toList();
    }

    private TestCase convertTestCaseDtoToTestCase(TestCaseDTO testCaseDTO){
        return modelMapper.map(testCaseDTO, TestCase.class);
    }

    private TestCaseDTO convertTestCaseToTestCaseDto(TestCase testCase){
        return modelMapper.map(testCase, TestCaseDTO.class);
    }
}
