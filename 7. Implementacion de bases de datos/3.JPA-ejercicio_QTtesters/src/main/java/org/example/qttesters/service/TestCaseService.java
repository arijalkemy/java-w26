package org.example.qttesters.service;

import org.example.qttesters.dto.RequestTestCaseDto;
import org.example.qttesters.dto.ResponseTestCaseDto;
import org.example.qttesters.entity.TestCase;
import org.example.qttesters.exception.NotFoundException;
import org.example.qttesters.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    TestCaseRepository testCaseRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public RequestTestCaseDto addTestCase(RequestTestCaseDto testCase) {
        TestCase testCaseModel = testCaseRepository.save(modelMapper.map(testCase, TestCase.class));
        return(modelMapper.map(testCaseModel,RequestTestCaseDto.class));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseTestCaseDto> getAll() {
        return testCaseRepository.findAll().stream().map(testCase -> modelMapper.map(testCase, ResponseTestCaseDto.class)).toList();
    }

    @Override
    @Transactional
    public ResponseTestCaseDto updateTestCase(Long id, RequestTestCaseDto requestTestCaseDto) {
        findTestCaseById(id);
        TestCase testCase = modelMapper.map(requestTestCaseDto, TestCase.class);
        testCase.setId_case(id);
        TestCase testCaseEntity = testCaseRepository.save(testCase);
        return modelMapper.map(testCaseEntity, ResponseTestCaseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseTestCaseDto findTestCaseById(Long id){
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("No se encontró el test con id"+ id)
        );
        return modelMapper.map(testCase, ResponseTestCaseDto.class);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseTestCaseDto> findTestCaseByDate(LocalDate date) {
        return  testCaseRepository.findAll()
                .stream()
                .filter(testCase -> testCase.getLast_updated().isAfter(date))
                .map(testCase -> modelMapper.map(testCase, ResponseTestCaseDto.class))
                .toList();
    }
}
