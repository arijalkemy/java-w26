package org.example.qttesters.service;

import org.example.qttesters.dto.RequestTestCaseDto;
import org.example.qttesters.dto.ResponseTestCaseDto;
import org.example.qttesters.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    String addTestCase(RequestTestCaseDto testCase);
    List<ResponseTestCaseDto> getAll();
    ResponseTestCaseDto getTestCaseById(Long id);
    String updateTestCase(Long id, RequestTestCaseDto testCase);
    String deleteTestCase(Long id);
    List<ResponseTestCaseDto> findTestCaseByDate(String date);
}
