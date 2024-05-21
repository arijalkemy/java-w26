package org.ejercicio.qatesters.service;

import org.ejercicio.qatesters.dto.TestCaseDto;
import org.ejercicio.qatesters.exception.NotFoundException;
import org.ejercicio.qatesters.model.TestCase;
import org.ejercicio.qatesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    private ModelMapper modelMapper;
    private ITestCaseRepository testCaseRepository;
    private final String NO_TEST_ENCONTRADO = "No se encontro el test case con id: ";

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public void saveTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = modelMapper.map(testCaseDto, TestCase.class);
        testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCaseDto> getTestCases(LocalDate date) {
        if (date == null) {
            return modelMapper.map(testCaseRepository.findAll(), new TypeToken<List<TestCaseDto>>() {}.getType());
        }
        List<TestCase> testCases = testCaseRepository.findAll().stream().filter(t ->
                t.getLast_update().isAfter(date)
        ).toList();
        return modelMapper.map(testCases, new TypeToken<List<TestCaseDto>>() {}.getType());
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        return modelMapper.map(testCaseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NO_TEST_ENCONTRADO + id)
        ), TestCaseDto.class);
    }

    @Override
    public void deleteTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NO_TEST_ENCONTRADO + id)
        );
        testCaseRepository.delete(testCase);
    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NO_TEST_ENCONTRADO + id)
        );
        modelMapper.map(testCaseDto, testCase);
        return modelMapper.map(testCaseRepository.save(testCase), TestCaseDto.class);
    }
}
