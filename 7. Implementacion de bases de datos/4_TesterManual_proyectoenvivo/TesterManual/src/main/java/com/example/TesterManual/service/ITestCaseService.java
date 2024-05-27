package com.example.TesterManual.service;

import com.example.TesterManual.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    String saveTestCase(TestCase testCase);
    public List<TestCase> getAllTestsCase();
    public TestCase findTestCase(Long id);
    public String deleteTestCase(Long id);
    public String editTestCase(Long id_modificar, TestCase testCase_modif);
    public List<TestCase> getAllTestsCaseLastUpdate(LocalDate last_update);
}
