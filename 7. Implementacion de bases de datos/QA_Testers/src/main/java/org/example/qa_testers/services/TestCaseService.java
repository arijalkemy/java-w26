package org.example.qa_testers.services;

import org.example.qa_testers.DTO.NewTestCaseResponseDTO;
import org.example.qa_testers.DTO.TestCaseRequestDTO;
import org.example.qa_testers.DTO.TestCaseResponseDTO;
import org.example.qa_testers.exceptions.NotFoundException;
import org.example.qa_testers.models.TestCase;
import org.example.qa_testers.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    private final String NOT_FOUND_MESSAGE="The testCase with proportionate Id NOT exists";

    private final ITestCaseRepository testCaseRepository;
    private final ModelMapper mapper;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        mapper = new ModelMapper();
    }

    @Override
    public NewTestCaseResponseDTO createNewTestCase(TestCaseRequestDTO newTest) {
        TestCase testCase = convertToModel(newTest);
        testCase = testCaseRepository.save(testCase);
        return convertToNewDTO(testCase);
    }

    @Override
    public List<TestCaseResponseDTO> findAllTestCases() {
        List<TestCase> testCaseList = testCaseRepository.findAll();
        return testCaseList.stream().map(this::converToDTO).toList();
    }

    @Override
    public TestCaseResponseDTO findTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(()->
                new NotFoundException(NOT_FOUND_MESSAGE));
        return converToDTO(testCase);
    }

    @Override
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testCase) {
        testCaseRepository.findById(id).orElseThrow(()->
                new NotFoundException(NOT_FOUND_MESSAGE));
        TestCase testCaseUpdated = convertToModel(testCase);
        testCaseUpdated.setIdCase(id);
        testCaseUpdated.setLastUpdate(LocalDate.now());
        testCaseUpdated = testCaseRepository.save(testCaseUpdated);
        return converToDTO(testCaseUpdated);
    }

    @Override
    public void deleteById(Long id) {
        if(!testCaseRepository.existsById(id)) throw new NotFoundException(NOT_FOUND_MESSAGE);
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseResponseDTO> findAllTestAfterDate(LocalDate date) {
        List<TestCase> testCaseList = testCaseRepository.findAll();
        testCaseList = testCaseList.stream().filter(testCase ->
                testCase.getLastUpdate().isAfter(date)).toList();
        return testCaseList.stream().map(this::converToDTO).toList();
    }

    private TestCaseResponseDTO converToDTO(TestCase testCase){
        return mapper.map(testCase, TestCaseResponseDTO.class);
    }
    private TestCase convertToModel(TestCaseRequestDTO testCaseRequestDTO){
        return mapper.map(testCaseRequestDTO,TestCase.class);
    }

    private NewTestCaseResponseDTO convertToNewDTO(TestCase testCase){
        return mapper.map(testCase, NewTestCaseResponseDTO.class);
    }

}
