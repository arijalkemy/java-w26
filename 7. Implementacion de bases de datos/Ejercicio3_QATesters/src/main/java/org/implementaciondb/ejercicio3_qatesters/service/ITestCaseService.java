package org.implementaciondb.ejercicio3_qatesters.service;

import org.implementaciondb.ejercicio3_qatesters.dto.TestCaseRequest;
import org.implementaciondb.ejercicio3_qatesters.dto.TestCaseResponse;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseResponse saveTestCase(TestCaseRequest testCaseRequest);

    List<TestCaseResponse> findAllTestCases();

    TestCaseResponse findTestCaseById(Long id);

    TestCaseResponse updateTestCase(Long id, TestCaseRequest testCaseRequest);

    TestCaseResponse deleteTestCase(Long id);

    List<TestCaseResponse> findTestCasesByDate(LocalDate lastUpdate);
}
