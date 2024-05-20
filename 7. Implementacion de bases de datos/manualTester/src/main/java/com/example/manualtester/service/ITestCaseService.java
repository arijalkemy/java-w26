package com.example.manualtester.service;

import com.example.manualtester.model.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    public TestCaseDTO saveTest(TestCaseDTO dto);
    public void updateTest(TestCaseDTO dto);
    public void deleteTest(Long id);
    public void createTest(TestCaseDTO dto);
    public List<TestCaseDTO> getAllTests(LocalDate last_update);
    public TestCaseDTO getOneTest(Long id);
}
