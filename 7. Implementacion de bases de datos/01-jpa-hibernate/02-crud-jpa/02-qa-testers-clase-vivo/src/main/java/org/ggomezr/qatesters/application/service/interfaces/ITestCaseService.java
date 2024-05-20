package org.ggomezr.qatesters.application.service.interfaces;

import org.ggomezr.qatesters.domain.dto.ResponseDTO;
import org.ggomezr.qatesters.domain.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseDTO createTestCase(TestCaseDTO testCaseDTO);
    List<TestCaseDTO> getAllTestCases();
    TestCaseDTO getTestCaseById(Long id);
    ResponseDTO updatedTestCase(Long id, TestCaseDTO testCaseDTO);
    ResponseDTO deleteTestCase(Long id);
    List<TestCaseDTO> getTestCasesAfterLastUpdateDate(LocalDate date);
}
