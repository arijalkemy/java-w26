package Ejercicio.TestCase.Service;

import Ejercicio.TestCase.Dto.TestCaseRequestDto;
import Ejercicio.TestCase.Dto.TestCaseResponseDto;
import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void createTestCase(TestCaseRequestDto testCase);

    TestCaseResponseDto getAllTestCases(Long id);

    void updateTestCase(TestCaseRequestDto testCase, Long id);

    void deleteTestCase(Long id);

    TestCaseResponseDto getTestCaseById(Long id);

    List<TestCaseResponseDto> getUpdatedTestCasesBy(LocalDate date);
}
