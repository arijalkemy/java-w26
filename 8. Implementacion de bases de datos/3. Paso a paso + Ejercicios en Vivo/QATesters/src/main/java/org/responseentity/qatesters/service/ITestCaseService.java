package org.responseentity.qatesters.service;

import org.responseentity.qatesters.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public TestCaseDTO saveTestCase(TestCaseDTO testCaseDTO);
    public List<TestCaseDTO> listAllTestCase();
    public TestCaseDTO getTestCaseById(Long id);
    public TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO);
    public void deleteTestCase(Long id);
    public List<TestCaseDTO> findByLastUpdate(LocalDate localDate);
}
