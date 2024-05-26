package org.meli.ejercicio6_p2_d2_qa_testers.service;

import org.meli.ejercicio6_p2_d2_qa_testers.dto.TestCaseDtoRequest;
import org.meli.ejercicio6_p2_d2_qa_testers.dto.TestCaseDtoResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ITestCaseService {
    TestCaseDtoResponse save(TestCaseDtoRequest test);
    List<TestCaseDtoResponse> findAll();
    TestCaseDtoResponse findById(Long id);
    String delete(Long id);
    TestCaseDtoResponse udpate(Long id, TestCaseDtoRequest test);
    List<TestCaseDtoResponse> getAllTestCaseByFilter(LocalDate filter);
}
