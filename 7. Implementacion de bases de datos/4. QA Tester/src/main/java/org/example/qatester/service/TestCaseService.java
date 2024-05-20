package org.example.qatester.service;

import jakarta.transaction.Transactional;
import org.example.qatester.dto.TestCaseDTOReq;
import org.example.qatester.dto.TestCaseDTORes;
import org.example.qatester.model.TestCase;
import org.example.qatester.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    ITestCaseRepository testCaseRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public TestCaseDTORes update(Long id, TestCaseDTOReq testDTO) {
        return null;
    }

    @Override
    public List<TestCaseDTORes> findAll() {
        return List.of();
    }

    @Override
    public TestCaseDTORes findById(Long id) {
        return null;
    }

    @Override
    public TestCaseDTORes delete(Long id) {
        return null;
    }

    @Override
    public List<TestCaseDTORes> filterByDate(LocalDate date) {
        return List.of();
    }

    @Override
    @Transactional
    public TestCaseDTORes create(TestCaseDTOReq testDTO) {
        TestCase test =  testCaseRepository.save(modelMapper.map(testDTO, TestCase.class));
        return modelMapper.map(test, TestCaseDTORes.class);
    }


}
