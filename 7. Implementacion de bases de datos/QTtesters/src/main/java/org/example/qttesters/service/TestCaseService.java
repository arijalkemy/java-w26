package org.example.qttesters.service;

import org.example.qttesters.dto.RequestTestCaseDto;
import org.example.qttesters.dto.ResponseTestCaseDto;
import org.example.qttesters.entity.TestCase;
import org.example.qttesters.exception.BadRequestException;
import org.example.qttesters.exception.NotFoundException;
import org.example.qttesters.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    TestCaseRepository testCaseRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public String addTestCase(RequestTestCaseDto testCase) {
        testCaseRepository.save(modelMapper.map(testCase, TestCase.class));
        return "Test case added successfully";
    }

    @Override
    public List<ResponseTestCaseDto> getAll() {
        return testCaseRepository.findAll().stream().map(testCase -> modelMapper.map(testCase, ResponseTestCaseDto.class)).toList();
    }

    @Override
    public ResponseTestCaseDto getTestCaseById(Long id) {
        return modelMapper
                .map(testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Test case not found")), ResponseTestCaseDto.class);
    }

    @Override
    public String updateTestCase(Long id, RequestTestCaseDto testCase) {

        if (!isExists(id))
            throw new BadRequestException("Test case not found");

        TestCase testCaseUpdated =  modelMapper.map(testCase, TestCase.class);
        testCaseUpdated.setId_case(id);

        testCaseRepository.save(testCaseUpdated);

        return "Test case updated successfully";
    }

    @Override
    public String deleteTestCase(Long id) {

        if (!isExists(id))
            throw new BadRequestException("Test case not found");

        testCaseRepository.deleteById(id);
        return "Test case deleted successfully";
    }

    @Override
    public List<ResponseTestCaseDto> findTestCaseByDate(String date) {

        LocalDate dateParsed = LocalDate.parse(date);

        return testCaseRepository
                .findAll()
                .stream()
                .filter( element -> (element.getLast_updated().isAfter(dateParsed) || element.getLast_updated().isEqual(dateParsed)) )
                .map(element -> modelMapper.map(element, ResponseTestCaseDto.class))
                .toList();
    }

    private boolean isExists(Long id) {
        return testCaseRepository.existsById(id);
    }
}
