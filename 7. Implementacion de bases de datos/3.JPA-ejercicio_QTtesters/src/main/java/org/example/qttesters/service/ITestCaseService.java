package org.example.qttesters.service;

import org.example.qttesters.dto.RequestTestCaseDto;
import org.example.qttesters.dto.RequestToUpdateTestCaseDto;
import org.example.qttesters.dto.ResponseTestCaseDto;
import org.example.qttesters.entity.TestCase;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    RequestTestCaseDto addTestCase(RequestTestCaseDto testCase);
    ResponseTestCaseDto updateTestCase(Long id, RequestTestCaseDto testCase);
    ResponseTestCaseDto findTestCaseById(Long id);
    List<ResponseTestCaseDto> getAll();
    List<ResponseTestCaseDto> findTestCaseByDate(LocalDate date);
    void deleteTestCase(Long id);
}
