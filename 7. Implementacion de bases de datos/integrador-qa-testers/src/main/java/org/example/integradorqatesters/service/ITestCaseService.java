package org.example.integradorqatesters.service;

import org.example.integradorqatesters.model.dto.TestCaseRequestDTO;
import org.example.integradorqatesters.model.dto.TestCaseResponseDTO;
import org.example.integradorqatesters.model.dto.TestCaseUpdateDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseRequestDTO createTestCase(TestCaseRequestDTO TestCaseRequestDTO);
    List<TestCaseResponseDTO> getAllTestCase();
    String deleteTestCase(Long id);
    TestCaseResponseDTO getTestCase(Long id);
    TestCaseUpdateDTO updateTestCase(TestCaseUpdateDTO joyaUpdateDTO);
    List<TestCaseResponseDTO> getAllTestCaseLastUpdate(LocalDate date);
    List<TestCaseResponseDTO> getAllTestCasePassedOrTested(String value);

}
