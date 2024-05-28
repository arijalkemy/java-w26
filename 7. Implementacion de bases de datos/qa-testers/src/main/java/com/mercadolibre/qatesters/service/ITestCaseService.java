package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.TestCaseRequest;
import com.mercadolibre.qatesters.dto.TestCaseResponse;
import com.mercadolibre.qatesters.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void create(TestCaseRequest testCase);
    List<TestCaseResponse> getAll();
    TestCaseResponse getById(Long id);
    void update(Long id, TestCaseRequest testCase);
    void delete(Long id);
    List<TestCaseResponse> getByDateHigherThan(LocalDate date);
}
