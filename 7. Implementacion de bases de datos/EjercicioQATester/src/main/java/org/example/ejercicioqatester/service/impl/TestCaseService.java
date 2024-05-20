package org.example.ejercicioqatester.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.example.ejercicioqatester.dto.TestCaseDTO;
import org.example.ejercicioqatester.exception.NotFoundException;
import org.example.ejercicioqatester.model.TestCase;
import org.example.ejercicioqatester.repository.TestCaseRepository;
import org.example.ejercicioqatester.service.ITestCaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {
    private final TestCaseRepository testCaseRepository;
    private final ObjectMapper objectMapper;

    public TestCaseService(TestCaseRepository testCaseRepository, ObjectMapper objectMapper){
        this.testCaseRepository = testCaseRepository;
        this.objectMapper = objectMapper;
    }

    private  final String TEST_CASE_NOT_FOUND = "Test case not found";

    @Override
    public TestCaseDTO saveTestCase(TestCaseDTO testCase) {
        testCaseRepository.save(mapToEntity(testCase));
        return testCase;
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateTestCase(Long id_case, String description, Boolean tested, Boolean passed, int number_of_tries, LocalDate last_update) {
        TestCase testCase= objectMapper.convertValue(getTestCaseById(id_case), TestCase.class);
        TestCase testCaseUpdated = new TestCase(description, tested, passed, number_of_tries, last_update);
        testCaseUpdated.setId_case(testCase.getId_case());
        testCaseRepository.save(testCaseUpdated);
    }

    @Override
    @Transactional
    public List<TestCaseDTO> getAllTestCases() {
        return testCaseRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    @Transactional
    public TestCaseDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException(TEST_CASE_NOT_FOUND));
        return mapToDTO(testCase);
    }

    @Override
    public List<TestCaseDTO> getTestCasesByDate(String find) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(find, inputFormatter);
        String formattedDate = date.format(outputFormatter);
        return testCaseRepository.findAll().stream()
                .filter(testCase -> testCase.getLast_update().isAfter(LocalDate.parse(formattedDate)))
                .map(this::mapToDTO)
                .toList();
    }

    private TestCase mapToEntity(TestCaseDTO testCaseDTO){
        return objectMapper.convertValue(testCaseDTO, TestCase.class);
    }

    private TestCaseDTO mapToDTO(TestCase testCase){
        return objectMapper.convertValue(testCase, TestCaseDTO.class);
    }
}
