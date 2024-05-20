package com.example.manualtester.service;

import com.example.manualtester.model.TestCase;
import com.example.manualtester.model.TestCaseDTO;
import com.example.manualtester.model.TestCaseReponse;
import com.example.manualtester.model.TestToUpdateDTO;
import com.example.manualtester.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

    private TestCase mapToEntity(TestToUpdateDTO dto) {
        return myMapper.convertValue(dto, TestCase.class);
    }


    @Override
    public TestCaseReponse updateTest(TestToUpdateDTO dto) {
        repository.findById(dto.getId_case());
        repository.save(this.mapToEntity(dto));
        return myMapper.convertValue(dto, TestCaseReponse.class);
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
    @Transactional
    public void createTest(TestCaseDTO dto) {
        System.out.println(dto.getDescription());
        repository.save(mapToEntity(dto));
    }

    @Override
    public List<TestCase> getAllTests() {
        return repository.findAll();
    }

    @Override
    public TestCaseReponse getOneTest(Long id) {
        Optional<TestCase> aux = repository.findById(id);
        return this.entityToResponseDTO(aux.get());
    }

    private TestCaseReponse entityToResponseDTO(TestCase testCase) {
        return myMapper.convertValue(testCase, TestCaseReponse.class);
    }
}
