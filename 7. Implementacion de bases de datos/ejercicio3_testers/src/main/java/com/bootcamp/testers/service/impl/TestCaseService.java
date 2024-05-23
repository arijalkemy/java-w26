package com.bootcamp.testers.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.bootcamp.testers.dto.ResponseDTO;
import com.bootcamp.testers.dto.TestCaseDTO;
import com.bootcamp.testers.exception.LocalDateInvalidException;
import com.bootcamp.testers.exception.NotFoundException;
import com.bootcamp.testers.mapper.TestCaseMapper;
import com.bootcamp.testers.service.ITestCaseService;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.testers.model.TestCase;
import com.bootcamp.testers.repository.ITestCaseRepository;

import org.springframework.stereotype.Service;

@Service
public class TestCaseService implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public List<TestCaseDTO> getAll() {
        return TestCaseMapper.testCaseListToTestCaseDTOList(testCaseRepository.findAll());
    }

    @Override
    @Transactional
    public ResponseDTO create(TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseRepository.save(TestCaseMapper.testCaseDTOToTestCase(testCaseDTO));
        return new ResponseDTO("El test case fue agregado correctamente con el id " + testCase.getIdCase() + ".");
    }

    @Override
    @Transactional
    public ResponseDTO delete(Long id) {
        validateTestCase(id);
        testCaseRepository.deleteById(id);
        return new ResponseDTO("El test case fue eliminado correctamente.");
    }

    @Override
    public TestCaseDTO getById(Long id) {
        return TestCaseMapper.testCaseToTestCaseDTO(getEntityById(id));
    }

    @Override
    @Transactional
    public TestCaseDTO update(Long id, TestCaseDTO testCaseDTO) {
        validateTestCase(id);
        testCaseDTO.setIdCase(id);
        return TestCaseMapper.testCaseToTestCaseDTO(
                testCaseRepository.save(TestCaseMapper.testCaseDTOToTestCase(testCaseDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDTO> getAllLastUpdatesAfter(String lastUpdate) {
        LocalDate lastUpdateLD;
        try {
            lastUpdateLD = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            throw new LocalDateInvalidException();
        }

        return TestCaseMapper.testCaseListToTestCaseDTOList(
                testCaseRepository.findByLastUpdateAfter(lastUpdateLD));
    }

    private TestCase getEntityById(Long id) {
        return testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró ningun TestCase con el id indicado."));
    }

    private void validateTestCase(Long id) {
        if (!testCaseRepository.existsById(id))
            throw new NotFoundException("No se encontró ningun TestCase con el id indicado.");
    }
}
