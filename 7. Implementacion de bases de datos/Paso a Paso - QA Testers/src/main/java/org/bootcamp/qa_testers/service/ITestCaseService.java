package org.bootcamp.qa_testers.service;

import org.bootcamp.qa_testers.dto.TestCaseDTO;
import org.bootcamp.qa_testers.dto.ResponseTestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResponseTestCaseDTO createTestCase(TestCaseDTO testCaseDTO);
    List<ResponseTestCaseDTO> getTestCases(LocalDate lastUpdate);
    ResponseTestCaseDTO getTestCaseById(Long idCase);
    ResponseTestCaseDTO updateTestCase(TestCaseDTO testCaseDTO, Long idCase);
    ResponseTestCaseDTO deleteTestCase(Long idCase);
}
