package org.example.qa_tester.service;

import org.example.qa_tester.dtos.ReqTestCaseDto;
import org.example.qa_tester.dtos.SuccessDto;
import org.example.qa_tester.dtos.TestCaseDto;

import java.util.Date;
import java.util.List;

public interface IQaTesterService {
    SuccessDto createTestCase(ReqTestCaseDto testCaseDto);
    List<TestCaseDto> getAllTestCases();
    TestCaseDto getTestCaseById(Long id);
    TestCaseDto updateTestCase(Long id, ReqTestCaseDto testCaseDto);
    SuccessDto deleteTestCase(Long id);
    List<TestCaseDto> getTestCasesByDate(Date lastUpdate);
}
