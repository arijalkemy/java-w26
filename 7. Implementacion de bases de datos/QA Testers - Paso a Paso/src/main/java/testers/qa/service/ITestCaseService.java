package testers.qa.service;

import testers.qa.dto.TestCaseRequestDto;
import testers.qa.dto.TestCaseResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDto saveTest(TestCaseRequestDto testCaseRequestDto);
    List<TestCaseResponseDto> findAll();
    TestCaseResponseDto findById(Long id);
    TestCaseResponseDto updateTest(Long id, TestCaseRequestDto testCaseRequestDto);
    TestCaseResponseDto deleteTest(Long id);
    List<TestCaseResponseDto> findByDate(LocalDate date);
}
