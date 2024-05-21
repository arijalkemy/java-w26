package com.bootcamp.qatesters.services;

import com.bootcamp.qatesters.dtos.TestCaseRequestDTO;
import com.bootcamp.qatesters.dtos.TestCaseResponseDTO;
import com.bootcamp.qatesters.entities.TestCase;
import com.bootcamp.qatesters.repositories.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TestCaseServiceImpl implements TestCaseService {
    private final TestCaseRepository testCaseRepository;
    private ModelMapper modelMapper;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public TestCaseResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        return modelMapper.map(
                testCaseRepository.save(modelMapper.map(testCaseRequestDTO, TestCase.class)),
                TestCaseResponseDTO.class);
    }

    @Override
    public List<TestCaseResponseDTO> getAllTestCases() {
        return testCaseRepository.findAll()
                .stream().map(x -> modelMapper.map(x, TestCaseResponseDTO.class)).toList();
    }

    @Override
    public TestCaseResponseDTO getById(Long id) {
        return modelMapper.map(testCaseRepository.findById(id), TestCaseResponseDTO.class);
    }

    @Override
    public List<TestCaseResponseDTO> getByDate(LocalDate date) {
        return testCaseRepository.findByLastUpdateAfter(date)
                .stream().map(x -> modelMapper.map(x, TestCaseResponseDTO.class)).toList();
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO) {
        return modelMapper.map(testCaseRepository.findById(id), TestCaseResponseDTO.class);
    }
}
