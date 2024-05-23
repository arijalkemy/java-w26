package com.bootcamp.testers.service;

import java.time.LocalDate;
import java.util.List;

import com.bootcamp.testers.dto.ResponseDTO;
import com.bootcamp.testers.dto.TestCaseDTO;

public interface ITestCaseService {

    List<TestCaseDTO> getAll();

    ResponseDTO create(TestCaseDTO testCaseDTO);

    ResponseDTO delete(Long id);

    TestCaseDTO getById(Long id);

    TestCaseDTO update(Long id, TestCaseDTO testCaseDTO);

    List<TestCaseDTO> getAllLastUpdatesAfter(String lastUpdate);
}
