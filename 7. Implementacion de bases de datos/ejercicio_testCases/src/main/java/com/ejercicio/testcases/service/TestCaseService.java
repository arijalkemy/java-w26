package com.ejercicio.testcases.service;

import com.ejercicio.testcases.dto.PostRequestDTO;
import com.ejercicio.testcases.dto.PostResponseDTO;
import com.ejercicio.testcases.dto.TestCaseDTO;
import com.ejercicio.testcases.exception.NotFoundException;
import com.ejercicio.testcases.model.TestCase;
import com.ejercicio.testcases.repository.TestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService{

    private final TestCaseRepository testCaseRepository;
    private final ObjectMapper objectMapper;

    public TestCaseService(TestCaseRepository testCaseRepository, ObjectMapper objectMapper) {
        this.testCaseRepository = testCaseRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public PostResponseDTO createTestCase(PostRequestDTO postRequestDTO) {
        TestCase toSave = objectMapper.convertValue(postRequestDTO, TestCase.class);
        TestCase saved = testCaseRepository.save(toSave);
        return new PostResponseDTO(saved.getIdCase());
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        return testCaseRepository.findAll()
                .stream()
                .map(testCase -> objectMapper.convertValue(testCase, TestCaseDTO.class))
                .toList();
    }

    @Override
    public TestCaseDTO getTestCaseById(long id) {
        Optional<TestCase> result = testCaseRepository.findById(id);
        if(!result.isPresent()) throw new NotFoundException("No se encontraron resultados para el id: " + id);
        return objectMapper.convertValue(result, TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO updateTestCaseById(long id, TestCaseDTO testCaseDTO) {
        getTestCaseById(id);
        TestCase toUpdate = objectMapper.convertValue(testCaseDTO, TestCase.class);
        toUpdate.setIdCase(id);
        TestCase result = testCaseRepository.save(toUpdate);
        return objectMapper.convertValue(result, TestCaseDTO.class);
    }

    @Override
    public void deleteTestCaseById(long id) {
        TestCaseDTO searchResult = getTestCaseById(id);
        TestCase toDelete = objectMapper.convertValue(searchResult, TestCase.class);
        testCaseRepository.delete(toDelete);
    }

    @Override
    public List<TestCaseDTO> getAllByLastUpdate(String lastUpdateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastUpdate = LocalDate.parse(lastUpdateStr, formatter);

        List<TestCase> result = testCaseRepository.findAll()
                .stream()
                .filter(testCase -> testCase.getLastUpdate().isAfter(lastUpdate))
                .toList();

        return result
                .stream()
                .map(testCase -> objectMapper.convertValue(testCase, TestCaseDTO.class))
                .toList();
    }
}
