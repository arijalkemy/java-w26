package org.example.integradorqatesters.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.integradorqatesters.exception.ConflictException;
import org.example.integradorqatesters.exception.NotFoundException;
import org.example.integradorqatesters.model.TestCase;
import org.example.integradorqatesters.model.dto.TestCaseRequestDTO;
import org.example.integradorqatesters.model.dto.TestCaseResponseDTO;
import org.example.integradorqatesters.model.dto.TestCaseUpdateDTO;
import org.example.integradorqatesters.repository.ITestCaseRepository;
import org.example.integradorqatesters.service.ITestCaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;
    private final ObjectMapper objectMapper;

    private TestCase mapToEntity(TestCaseUpdateDTO testCaseUpdateDTO) { return objectMapper.convertValue(testCaseUpdateDTO, TestCase.class); }
    private TestCase mapToEntity(TestCaseRequestDTO testCaseRequestDTO){ return objectMapper.convertValue(testCaseRequestDTO, TestCase.class); }
    private TestCaseResponseDTO mapToDTO(TestCase testCase){ return objectMapper.convertValue(testCase, TestCaseResponseDTO.class); }

    @Override
    public TestCaseRequestDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        List<TestCase> testCaseList = testCaseRepository.findAll();
        for (TestCase test:testCaseList){
            if (
                    test.getDescription().equals(testCaseRequestDTO.getDescription()) &&
                    test.getLastUpdate().equals(testCaseRequestDTO.getLastUpdate()) &&
                    test.getNumberOfTries().equals(testCaseRequestDTO.getNumberOfTries()) &&
                    (test.isTested() == testCaseRequestDTO.getTested()) &&
                    (test.isPassed() == testCaseRequestDTO.getPassed())){
                throw new ConflictException("Test case already exists.");
            }
        }
        testCaseRepository.save(mapToEntity(testCaseRequestDTO));
        return testCaseRequestDTO;
    }

    @Override
    public List<TestCaseResponseDTO> getAllTestCase() {
        return testCaseRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public String deleteTestCase(Long id) {
        Optional<TestCase> optionalTestCase = testCaseRepository.findById(id);
        if (optionalTestCase.isPresent()) {
            testCaseRepository.deleteById(id);
            return "Test case deleted!";
        } else {
            throw new NotFoundException("Test case was not found.");
        }
    }

    @Override
    public TestCaseResponseDTO getTestCase(Long id) {
        Optional<TestCase> optionalTestCase = testCaseRepository.findById(id);
        if (optionalTestCase.isPresent()) {
            return mapToDTO(optionalTestCase.get());
        } else {
            throw new NotFoundException("Test case was not found.");
        }
    }

    @Override
    public TestCaseUpdateDTO updateTestCase(TestCaseUpdateDTO joyaUpdateDTO) {
        getTestCase(joyaUpdateDTO.getIdCase());
        testCaseRepository.save(mapToEntity(joyaUpdateDTO));
        return joyaUpdateDTO;
    }

    @Override
    public List<TestCaseResponseDTO> getAllTestCaseLastUpdate(LocalDate date) {
        return testCaseRepository.findAll().
                stream().
                map(this::mapToDTO).
                filter(testCaseResponseDTO -> testCaseResponseDTO.getLastUpdate().isAfter(date)).
                toList();

    }

    @Override
    public List<TestCaseResponseDTO> getAllTestCasePassedOrTested(String value) {
        return (Objects.equals(value, "passed")) ?
                testCaseRepository.findAll().stream().map(this::mapToDTO).
                filter(testCaseResponseDTO -> testCaseResponseDTO.getPassed().equals(true)).toList() :
                testCaseRepository.findAll().stream().map(this::mapToDTO).
                filter(testCaseResponseDTO -> testCaseResponseDTO.getTested().equals(true)).toList();
    }

}
