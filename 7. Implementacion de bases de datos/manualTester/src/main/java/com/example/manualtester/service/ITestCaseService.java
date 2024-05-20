package com.example.manualtester.service;

import com.example.manualtester.model.TestCase;
import com.example.manualtester.model.TestCaseDTO;
import com.example.manualtester.model.TestCaseReponse;
import com.example.manualtester.model.TestToUpdateDTO;

import java.util.List;

public interface ITestCaseService {

    public TestCaseDTO saveTest(TestCaseDTO dto);
    public TestCaseReponse updateTest(TestToUpdateDTO dto);
    public void deleteTest(Long id);
    public void createTest(TestCaseDTO dto);
    public List<TestCase> getAllTests();
    public TestCaseReponse getOneTest(Long id);
}
