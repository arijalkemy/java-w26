package org.responseentity.qatesters.service;

import org.responseentity.qatesters.dto.TestCaseDTO;
import org.responseentity.qatesters.model.TestCase;
import org.responseentity.qatesters.repository.TestCaseRepository;
import org.responseentity.qatesters.utils.mapper.TestCaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService{
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Override
    public TestCaseDTO saveTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCaseToSave = TestCaseMapper.convertDTOToEntity(testCaseDTO);
        TestCase testCase = testCaseRepository.save(testCaseToSave);
        return TestCaseMapper.convertEntityToDTO(testCase);
    }

    @Override
    public List<TestCaseDTO> listAllTestCase() {
        return testCaseRepository
                .findAll()
                .stream()
                .map(testCase -> TestCaseMapper.convertEntityToDTO(testCase))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO getTestCaseById(Long id) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        if(!testCase.isPresent()){
            throw new RuntimeException("test case not found");
        }

        return TestCaseMapper.convertEntityToDTO(testCase.get());
    }

    @Override
    public TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        if(!testCase.isPresent()){
            throw new RuntimeException("test case not found");
        }

        TestCase testCaseToUpdate = testCase.get();
        testCaseToUpdate.setDescription(testCaseDTO.getDescription());
        testCaseToUpdate.setTested(testCaseDTO.getTested());
        testCaseToUpdate.setPassed(testCaseDTO.getPassed());
        testCaseToUpdate.setNumber_of_tries(testCaseDTO.getNumber_of_tries());
        testCaseToUpdate.setLast_update(testCaseToUpdate.getLast_update());

        return TestCaseMapper.convertEntityToDTO(testCaseRepository.save(testCaseToUpdate));
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseDTO> findByLastUpdate(LocalDate localDate) {
        return testCaseRepository.findAll()
                .stream()
                .filter(testCase -> testCase.getLast_update().isAfter(localDate))
                .map(testCase -> TestCaseMapper.convertEntityToDTO(testCase))
                .collect(Collectors.toList());
    }
}
