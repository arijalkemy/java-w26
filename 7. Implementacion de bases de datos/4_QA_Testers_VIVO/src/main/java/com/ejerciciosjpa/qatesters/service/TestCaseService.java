package com.ejerciciosjpa.qatesters.service;

import com.ejerciciosjpa.qatesters.dto.RequestTestCaseDto;

import com.ejerciciosjpa.qatesters.dto.ResponseTestCaseDto;
import com.ejerciciosjpa.qatesters.entity.TestCase;
import com.ejerciciosjpa.qatesters.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    TestCaseRepository testCaseRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addTestCase(RequestTestCaseDto testCase) {
        testCaseRepository.save(modelMapper.map(testCase, TestCase.class));
    }

    @Override
    public List<ResponseTestCaseDto> getAll() {
        return testCaseRepository.findAll().stream().map(testCase -> modelMapper.map(testCase, ResponseTestCaseDto.class)).toList();
    }

    @Override
    public ResponseTestCaseDto getTestCaseById(Long id) {
        return modelMapper
                .map(testCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Test case not found")), ResponseTestCaseDto.class);
    }

    @Override
    public void updateTestCase(Long id,RequestTestCaseDto testCase) {
        TestCase testToUpdate = testCaseRepository.getReferenceById(id);
        testToUpdate.setDescription(testCase.getDescription());
        testToUpdate.setPassed(testCase.isPassed());
        testToUpdate.setTested(testCase.isTested());
        testToUpdate.setLast_updated(testCase.getLast_updated());
        testCaseRepository.save(testToUpdate);
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.getReferenceById(id);
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<ResponseTestCaseDto> findTestCaseByDate(LocalDate date) {
        return testCaseRepository.findAll().stream().filter(e -> e.getLast_updated().isAfter(date)).map(testCase -> modelMapper.map(testCase, ResponseTestCaseDto.class)).toList();
    }
}
