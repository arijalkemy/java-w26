package com.ejerciciocrud.qatester.service;

import com.ejerciciocrud.qatester.dto.request.MessageDTO;
import com.ejerciciocrud.qatester.dto.request.TestCaseRequestDTO;
import com.ejerciciocrud.qatester.dto.response.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public MessageDTO addTestCase(TestCaseRequestDTO testCaseRequestDTO);
    public List<TestCaseResponseDTO> showAllTests();
    public TestCaseResponseDTO showTestById(Long id);
    public TestCaseResponseDTO updateTestById(Long id, TestCaseRequestDTO testCaseRequestDTO);
    public MessageDTO removeTestCase(Long id);
    public List<TestCaseResponseDTO> showTestAfterDate(LocalDate date);
}
