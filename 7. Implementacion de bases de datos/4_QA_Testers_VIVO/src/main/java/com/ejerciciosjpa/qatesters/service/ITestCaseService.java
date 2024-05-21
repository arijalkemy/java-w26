package com.ejerciciosjpa.qatesters.service;



import com.ejerciciosjpa.qatesters.dto.RequestTestCaseDto;
import com.ejerciciosjpa.qatesters.dto.ResponseTestCaseDto;
import com.ejerciciosjpa.qatesters.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void addTestCase(RequestTestCaseDto testCase);
    List<ResponseTestCaseDto> getAll();
    ResponseTestCaseDto getTestCaseById(Long id);
    void updateTestCase(Long id, RequestTestCaseDto testCase);
    void deleteTestCase(Long id);
    List<ResponseTestCaseDto>  findTestCaseByDate(LocalDate date);
}
