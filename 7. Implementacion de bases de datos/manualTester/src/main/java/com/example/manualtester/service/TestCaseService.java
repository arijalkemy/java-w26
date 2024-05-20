package com.example.manualtester.service;

import com.example.manualtester.model.TestCase;
import com.example.manualtester.model.TestCaseDTO;
import com.example.manualtester.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository repository;

    private final ObjectMapper myMapper;

    public TestCaseService(ITestCaseRepository repository, ObjectMapper myMapper) {
        this.repository = repository;
        this.myMapper = myMapper;
    }


    @Override
    public TestCaseDTO saveTest(TestCaseDTO dto) {
        repository.save(this.mapToEntity(dto));
        return dto;
    }

    private TestCase mapToEntity(TestCaseDTO dto) {
        return myMapper.convertValue(dto, TestCase.class);
    }

    private TestCaseDTO mapToDto(TestCase testCase) {
        return myMapper.convertValue(testCase, TestCaseDTO.class);
    }

    @Override
    public void updateTest(TestCaseDTO dto) {
        repository.save(this.mapToEntity(dto));
    }

    @Override
    public void deleteTest(Long id) {
        TestCase aux = repository.findById(id).orElse(null);
        if (aux == null) {
            System.out.println("NO EXISTE EL USUARIO CON ID ");
        } else {
            repository.deleteById(id);
        }
    }

    @Override
    public void createTest(TestCaseDTO dto) {
        repository.save(this.mapToEntity(dto));
    }

    @Override
    public List<TestCaseDTO> getAllTests(LocalDate last_update) {
        List<TestCaseDTO> testCases;
        if (last_update != null){
           testCases  = repository.findAll()
                   .stream()
                   .filter(t -> t.getLast_update().isAfter(last_update))
                   .map(this::mapToDto)
                   .toList();
        } else {
            testCases = repository.findAll().stream().map(this::mapToDto).toList();
        }
        return testCases;
    }

    @Override
    public TestCaseDTO getOneTest(Long id) {
        Optional<TestCase> aux = repository.findById(id);
        return mapToDto(aux.get());
    }
}
