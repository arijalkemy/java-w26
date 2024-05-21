package com.w26.testcase.testcase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.testcase.testcase.dto.Testcase.GetAllTestcase;
import com.w26.testcase.testcase.dto.Testcase.GetTestcase;
import com.w26.testcase.testcase.dto.Testcase.PatchTestcase;
import com.w26.testcase.testcase.dto.Testcase.PostTestcase;
import com.w26.testcase.testcase.dto.Testcase.UpdateTestcase;
import com.w26.testcase.testcase.exception.NotFoundEntity;
import com.w26.testcase.testcase.model.Testcase;
import com.w26.testcase.testcase.repository.ITestcaseRepository;
import com.w26.testcase.testcase.util.CustomSpringBeanUtils;

@Service
public class TestcaseService implements ITestcaseService {

    @Autowired
    ITestcaseRepository repositoryTestcaseJPA;

    private final Pageable pageable = Pageable.ofSize(10);
    private final ObjectMapper objectMapper;

    public TestcaseService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Long createTestcase(PostTestcase testcaseToCreate) {
        Testcase testcase = this.objectMapper.convertValue(testcaseToCreate, Testcase.class);
        
        Testcase testcaseSaved = repositoryTestcaseJPA.save(testcase);

        return testcaseSaved.getId();
    }

    @Override
    public GetTestcase getTestcase(Long idTestcase) {
        Optional<Testcase> testcase = this.repositoryTestcaseJPA.findById(idTestcase);
        
        if (testcase.isEmpty()){ //Nota: Podría refactorizarse
            throw new NotFoundEntity("The testcase with id: " + idTestcase + " was not found!");
        }

        return objectMapper.convertValue(testcase, GetTestcase.class);
    }

    @Override
    public GetAllTestcase getAllTestcases(int page) {
        Page<Testcase> testCasesPage = this.repositoryTestcaseJPA.findAll(pageable.withPage(page));
        if (testCasesPage.isEmpty()) {
            throw new NotFoundEntity("There are not Testcases in the page selected.");
        }
        
        List<GetTestcase> result = objectMapper.convertValue(testCasesPage.toList(), new TypeReference<List<GetTestcase>>(){}); //Depende de otro DTO!!!
        
        return GetAllTestcase.builder()
        .testCases(result)
        .build();
    }


    @Override
    public Long deleteTestCase(Long idTestcase) {
        Optional<Testcase> testcase = this.repositoryTestcaseJPA.findById(idTestcase);
        
        if (testcase.isEmpty()) { //Nota: Podría refactorizarse
            throw new NotFoundEntity("The testcase with id: " + idTestcase + " was not found!");
        }

        this.repositoryTestcaseJPA.delete(testcase.get());
        return idTestcase;
    }
    @Override
    public Boolean patchTestCase(Long idTestcase, PatchTestcase testcaseToPatch) {
        Optional<Testcase> testcase = this.repositoryTestcaseJPA.findById(idTestcase);
        
        if (testcase.isEmpty()) { //Nota: Podría refactorizarse
            throw new NotFoundEntity("The testcase with id: " + idTestcase + " was not found!");
        }
        Testcase patchData = this.objectMapper.convertValue(testcaseToPatch, Testcase.class);
        Testcase dataBase = testcase.get();
        
        CustomSpringBeanUtils.copyNonNullProperties(patchData, testcase.get());
        this.repositoryTestcaseJPA.save(dataBase);
        return true;
    }

    @Override
    public Boolean updateTestCase(Long idTestcase, UpdateTestcase testcaseToUpdate) {
        Optional<Testcase> testcase = this.repositoryTestcaseJPA.findById(idTestcase);
        
        if (testcase.isEmpty()) { //Nota: Podría refactorizarse
            throw new NotFoundEntity("The testcase with id: " + idTestcase + " was not found!");
        }
        Testcase entityToUpdate = this.objectMapper.convertValue(testcaseToUpdate, Testcase.class);
        entityToUpdate.setId(idTestcase);
        this.repositoryTestcaseJPA.save(entityToUpdate);
        return true;
    }
    
}
