package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.TestCaseRequest;
import com.mercadolibre.qatesters.dto.TestCaseResponse;
import com.mercadolibre.qatesters.model.TestCase;
import com.mercadolibre.qatesters.repository.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService {
    private final TestCaseRepository testCaseRepository;
    @Override
    public void create(TestCaseRequest testCase) {
        testCaseRepository.save(mapToEntity(testCase));
    }

    @Override
    public List<TestCaseResponse> getAll() {
        return testCaseRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public TestCaseResponse getById(Long id) {
        return mapToDto(findTestCaseById(id));
    }

    @Override
    public void update(Long id, TestCaseRequest newTestCase) {
        findTestCaseById(id);
        TestCase testCaseToSave = mapToEntity(newTestCase);
        testCaseToSave.setId(id);
        testCaseRepository.save(testCaseToSave);

    }

    @Override
    public void delete(Long id) {
        TestCase testCase = findTestCaseById(id);
        testCaseRepository.delete(testCase);
    }

    @Override
    public List<TestCaseResponse> getByDateHigherThan(LocalDate date) {
        return getAll().stream()
                .filter(t -> t.getLastUpdate().isAfter(date))
                .toList();
    }
    private TestCase findTestCaseById(Long id) {
        return testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el test case"));
    }
    private TestCase mapToEntity(TestCaseRequest dto) {
        return new TestCase(
                null,
                dto.getDescription(),
                dto.getTested(),
                dto.getPassed(),
                dto.getNumberOfTries(),
                dto.getLastUpdate()
        );
    }
    private TestCaseResponse mapToDto(TestCase testCase) {
        return new TestCaseResponse(
                testCase.getId(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate()
        );
    }
}
