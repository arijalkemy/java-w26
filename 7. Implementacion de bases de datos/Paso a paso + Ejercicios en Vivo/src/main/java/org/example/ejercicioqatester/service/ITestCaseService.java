package org.example.ejercicioqatester.service;

import jakarta.transaction.Transactional;
import org.example.ejercicioqatester.dto.TestCaseDTO;
import org.example.ejercicioqatester.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {


    public TestCaseDTO saveTestCase(TestCaseDTO testCase);
    public void deleteTestCase(Long id);
    public List<TestCaseDTO> getAllTestCases();
    public TestCaseDTO getTestCaseById(Long id);
    public List<TestCaseDTO> getTestCasesByDate(String find);
    public void updateTestCase(Long id_case, String description, Boolean tested, Boolean passed, int number_of_tries, LocalDate last_update);
}
