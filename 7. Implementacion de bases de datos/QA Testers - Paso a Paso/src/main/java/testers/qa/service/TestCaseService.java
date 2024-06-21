package testers.qa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import testers.qa.dto.TestCaseRequestDto;
import testers.qa.dto.TestCaseResponseDto;
import testers.qa.model.TestCase;
import testers.qa.repository.ITestCaseRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;
    private final ObjectMapper objectMapper;

    public TestCaseService(ITestCaseRepository testCaseRepository, ObjectMapper objectMapper) {
        this.testCaseRepository = testCaseRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public TestCaseResponseDto saveTest(TestCaseRequestDto testCaseRequestDto) {
        TestCase testCase = testCaseRepository.save(mapToTestCase(testCaseRequestDto));
        return mapToTestCaseResponseDto(testCase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDto> findAll() {
        return testCaseRepository.findAll()
                .stream()
                .map(this::mapToTestCaseResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResponseDto findById(Long id) {
        return testCaseRepository.findById(id)
                .map(this::mapToTestCaseResponseDto)
                .orElse(null);
    }

    @Override
    @Transactional
    public TestCaseResponseDto updateTest(Long id, TestCaseRequestDto testCaseRequestDto) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return null;
        }
        testCase = mapToTestCase(testCaseRequestDto);
        testCase.setId(id);
        return mapToTestCaseResponseDto(testCaseRepository.save(testCase));
    }

    @Override
    @Transactional
    public TestCaseResponseDto deleteTest(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return null;
        }
        testCaseRepository.delete(testCase);
        return mapToTestCaseResponseDto(testCase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDto> findByDate(LocalDate date) {
        return testCaseRepository.findByLastUpdateAfter(date)
                .stream()
                .map(this::mapToTestCaseResponseDto)
                .toList();
    }

    private TestCase mapToTestCase(TestCaseRequestDto testCaseRequestDto) {
        return objectMapper.convertValue(testCaseRequestDto, TestCase.class);
    }

    private TestCaseResponseDto mapToTestCaseResponseDto(TestCase testCase) {
        return objectMapper.convertValue(testCase, TestCaseResponseDto.class);
    }
}
