package meli.bootcamp.testersqa.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.testersqa.DTOs.TestCaseRequestDTO;
import meli.bootcamp.testersqa.DTOs.TestCaseResponseDTO;
import meli.bootcamp.testersqa.exceptions.TestCaseNotFoundException;
import meli.bootcamp.testersqa.models.TestCase;
import meli.bootcamp.testersqa.repositories.ITestCaseRepository;
import meli.bootcamp.testersqa.services.interfaces.ITestCaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TestCaseServiceImpl implements ITestCaseService {

    ITestCaseRepository testCaseRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        objectMapper.findAndRegisterModules();
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseResponseDTO create(TestCaseRequestDTO testCaseRequestDTO) {

        TestCase testCase = objectMapper.convertValue(
                testCaseRequestDTO,
                TestCase.class
        );

        testCaseRepository.save(testCase);

        return objectMapper.convertValue(
                testCase,
                TestCaseResponseDTO.class
        );
    }

    @Override
    public List<TestCaseResponseDTO> findAll() {

        return testCaseRepository
                .findAll()
                .stream()
                .map(testCase -> objectMapper.convertValue(
                        testCase,
                        TestCaseResponseDTO.class
                ))
                .toList();
    }

    @Override
    public TestCaseResponseDTO findById(Long id) {

        return objectMapper.convertValue(
                this.getTestCaseById(id),
                TestCaseResponseDTO.class
        );
    }

    @Override
    public TestCaseResponseDTO update(Long id, TestCaseRequestDTO testCaseRequestDTO) {
        if (!testCaseRepository.existsById(id)) {
            throw new TestCaseNotFoundException("Test case not found");
        }

        TestCase testCaseUpdated = objectMapper.convertValue(
                testCaseRequestDTO,
                TestCase.class
        );
        testCaseUpdated.setId_case(id);
        testCaseUpdated.setLast_update(LocalDate.now());

        testCaseRepository.save(testCaseUpdated);

        return objectMapper.convertValue(
                testCaseUpdated,
                TestCaseResponseDTO.class
        );
    }

    @Override
    public void delete(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseResponseDTO> findTestCasesUpdatedAfter(LocalDate date) {

        List<TestCase> testCases = testCaseRepository
                .findAll()
                .stream()
                .filter(testCase -> testCase
                        .getLast_update()
                        .isAfter(date))
                .toList();


        return testCases
                .stream()
                .map(testCase -> objectMapper.convertValue(
                        testCase,
                        TestCaseResponseDTO.class
                ))
                .toList();
    }


    private TestCase getTestCaseById(Long id) {
        return testCaseRepository
                .findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException("Test case not found"));
    }
}
