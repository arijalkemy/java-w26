package com.meli.QA.Testers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.QA.Testers.dto.ResponseDto;
import com.meli.QA.Testers.dto.TestCaseDto;
import com.meli.QA.Testers.model.TestCase;
import com.meli.QA.Testers.repository.TestCaseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements ITestCaseService {

    private final TestCaseRepository testCaseRepository;

    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseDto createTestCase(TestCaseDto testCaseDto) {
        testCaseRepository.save(mapper.convertValue(testCaseDto, TestCase.class));
        return ResponseDto.builder()
                .status("201")
                .id(testCaseDto.getId())
                .message("Test case created successfully")
                .build();
    }

    @Override
    public List<TestCaseDto> getAll() {
        return testCaseRepository.findAll().stream().map(
                this::buildTestCaseDto).toList();
    }

    @Override
    public TestCaseDto getById(Long id) {
        return buildTestCaseDto(findById(id));
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = findById(id);
        testCase.setDescription(testCaseDto.getDescription());
        testCase.setTested(testCaseDto.getTested());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        testCase.setLastUpdate(LocalDate.parse(testCaseDto.getLastUpdate()));

        testCaseRepository.save(testCase);

        return ResponseDto.builder()
                .status("200")
                .id(testCase.getId())
                .message("Test case updated successfully")
                .build();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseDto deleteTestCase(Long id) {
        TestCase testCase = findById(id);
        testCaseRepository.delete(testCase);
        return ResponseDto.builder()
                .status("200")
                .id(testCase.getId())
                .message("Test case deleted successfully")
                .build();
    }

    private TestCase findById(Long id) {
        return testCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Test case not found"));
    }

    private TestCaseDto buildTestCaseDto(TestCase testCase){
        return new TestCaseDto(
                testCase.getId(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate().toString()
        );
    }
}
