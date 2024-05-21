package org.bootcamp.qatesters.service;

import org.bootcamp.qatesters.dto.TestCaseRequestDTO;
import org.bootcamp.qatesters.dto.TestCaseResponseDTO;
import org.bootcamp.qatesters.model.TestCase;
import org.bootcamp.qatesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = modelMapper.map(testCaseRequestDTO, TestCase.class);
        testCase = testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseResponseDTO.class);
    }

    @Override
    public TestCaseResponseDTO getTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return modelMapper.map(testCase, TestCaseResponseDTO.class);
    }

    @Override
    public List<TestCaseResponseDTO> getAllTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return List.of(modelMapper.map(testCases, TestCaseResponseDTO[].class));
    }

    @Override
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = modelMapper.map(testCaseRequestDTO, TestCase.class);
        testCase.setId(id);
        testCase = testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseResponseDTO.class);
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseResponseDTO> getTestCasesByLastUpdate(LocalDate lastUpdate) {
        List<TestCase> testCases = testCaseRepository.findAll();
        testCases = testCases.stream()
                             .filter(testCase -> !testCase.getLastUpdate().isBefore(lastUpdate))
                             .collect(Collectors.toList());
        return List.of(modelMapper.map(testCases, TestCaseResponseDTO[].class));
    }
}
