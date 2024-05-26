package org.meli.ejercicio6_p2_d2_qa_testers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.meli.ejercicio6_p2_d2_qa_testers.dto.TestCaseDtoRequest;
import org.meli.ejercicio6_p2_d2_qa_testers.dto.TestCaseDtoResponse;
import org.meli.ejercicio6_p2_d2_qa_testers.exception.GlobalException;
import org.meli.ejercicio6_p2_d2_qa_testers.exception.NotFoundException;
import org.meli.ejercicio6_p2_d2_qa_testers.model.TestCase;
import org.meli.ejercicio6_p2_d2_qa_testers.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TestCaseService implements ITestCaseService {
    private ITestCaseRepository testCaseRepository;
    private ObjectMapper objectMapper;

    @Override
    @Transactional
    public TestCaseDtoResponse save(TestCaseDtoRequest test) {
        TestCase testCase = toTest(test);
        TestCase testCase_response = testCaseRepository.save(testCase);
        return toTestResponseDTO(testCase_response);
    }

    @Override
    @Transactional
    public List<TestCaseDtoResponse> findAll() {
        List<TestCase> testCases = testCaseRepository.findAll();
         return testCases.stream()
                .map(this::toTestResponseDTO)
                .toList();
    }

    @Override
    @Transactional
    public TestCaseDtoResponse findById(Long id) {
        TestCase testCase = getTestbyId(id);
        return toTestResponseDTO(testCase);
    }

    @Override
    @Transactional
    public String delete(Long id) {
        TestCase testCase = getTestbyId(id);
        testCaseRepository.delete(testCase);
        return "Eliminado...";
    }

    @Override
    @Transactional
    public TestCaseDtoResponse udpate(Long id, TestCaseDtoRequest test) {
        TestCase testCase = getTestbyId(id);
        testCase.setDescription(test.getDescription());
        testCase.setTested(test.getTested());
        testCase.setPassed(test.getPassed());
        testCase.setNumber_of_tries(test.getNumber_of_tries());
        testCase.setLast_update(test.getLast_update());
        testCaseRepository.save(testCase);
        return toTestResponseDTO(testCase);
    }

    @Override
    public List<TestCaseDtoResponse> getAllTestCaseByFilter(LocalDate filter) {
        List<TestCase> listTestCases = testCaseRepository.getAllTestCaseByFilter(filter);

        return listTestCases.stream()
                .map(this::toTestResponseDTO)
                .toList();
    }

    private TestCase getTestbyId(Long id){
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if(testCase == null) throw new  NotFoundException("El test no existe");
        return testCase;
    }

    private TestCaseDtoRequest toTestRequestDTO(TestCase tes) {
        return objectMapper.convertValue(tes, TestCaseDtoRequest.class);
    }

    private TestCaseDtoResponse toTestResponseDTO(TestCase tes) {
        return objectMapper.convertValue(tes, TestCaseDtoResponse.class);
    }

    private TestCase toTest(TestCaseDtoRequest tes) {
        return objectMapper.convertValue(tes, TestCase.class);
    }

    private TestCase toTest(TestCaseDtoResponse tes) {
        return objectMapper.convertValue(tes, TestCase.class);
    }


}
