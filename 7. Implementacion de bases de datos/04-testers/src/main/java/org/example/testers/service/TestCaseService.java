package org.example.testers.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.testers.dto.TestCaseDTOReq;
import org.example.testers.dto.TestCaseDTORes;
import org.example.testers.exception.NotFoundException;
import org.example.testers.model.TestCase;
import org.example.testers.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    ITestCaseRepository testCaseRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    //private final ObjectMapper modelMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    @Transactional
    public TestCaseDTORes update(Long id, TestCaseDTOReq testDTO) {
       TestCase test = modelMapper.map(testDTO, TestCase.class);
       test.setId(id);
       testCaseRepository.save(test);
       return modelMapper.map(test, TestCaseDTORes.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDTORes> findAll() {
        List<TestCase> tests = testCaseRepository.findAll();
        return tests.stream().map(t -> modelMapper.map(t, TestCaseDTORes.class)).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseDTORes findById(Long id) {
        TestCase test = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found testcase with id " + id));
        return modelMapper.map(test, TestCaseDTORes.class);
    }

    @Override
    @Transactional
    public TestCaseDTORes delete(Long id) {
        TestCaseDTORes test = findById(id);
        testCaseRepository.deleteById(id);;
        return test;
    }


    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDTORes> filterByDate(String date) {
        LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<TestCase> tests = testCaseRepository.findAll();
        List<TestCase> filteredTests = tests.stream()
                .filter(t -> t.getLastUdate().isAfter(parsedDate)).toList();
        return filteredTests.stream().map(
                t -> modelMapper.map(t, TestCaseDTORes.class)
        ).toList();
    }

    @Override
    @Transactional
    public TestCaseDTORes create(TestCaseDTOReq testDTO) {
        //TestCase prueba = modelMapper.map(testDTO, TestCase.class);
        TestCase test =  testCaseRepository.save(modelMapper.map(testDTO, TestCase.class));
        TestCaseDTORes res = modelMapper.map(test, TestCaseDTORes.class);
        return res;
    }
}
