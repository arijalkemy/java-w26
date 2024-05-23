package com.tests.cases.service;

import com.tests.cases.dto.TestCasesDto;
import com.tests.cases.entity.TestCases;

import java.time.LocalDate;
import java.util.List;

public interface ITestCasesService {
    TestCases saveTest(TestCasesDto testCasesDto);
    List<TestCases> getAllTest();
    TestCases getTestCasesById(Long id);
    TestCases changeTest(Long id, TestCasesDto testCasesDto);
    String deleteTest(Long id);
    List<TestCases> filterTests(boolean tested, boolean passed, Integer number_of_tries, LocalDate last_update);
}
