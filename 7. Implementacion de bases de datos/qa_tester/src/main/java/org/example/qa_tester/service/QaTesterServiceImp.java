package org.example.qa_tester.service;

import lombok.RequiredArgsConstructor;
import org.example.qa_tester.dtos.ReqTestCaseDto;
import org.example.qa_tester.dtos.SuccessDto;
import org.example.qa_tester.dtos.TestCaseDto;
import org.example.qa_tester.exceptions.NotFoundException;
import org.example.qa_tester.models.TestCase;
import org.example.qa_tester.respository.IQaTesterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QaTesterServiceImp implements IQaTesterService {
    private final IQaTesterRepository repository;

    @Override
    public SuccessDto createTestCase(ReqTestCaseDto testCaseDto) {
        TestCase testCase = mapDtoToEntity(testCaseDto);
        repository.save(testCase);
        return new SuccessDto("Updated successfully");
    }

    @Override
    public List<TestCaseDto> getAllTestCases() {
        return repository.findAll().stream()
                .map(this::mapEntityToDto)
                .toList();
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        Optional<TestCase> foundTestCase = repository.findById(id);
        if (foundTestCase.isEmpty()) {
            throw new NotFoundException("Test Case with id " + id + " not found");
        }
        return mapEntityToDto(foundTestCase.get());
    }

    @Override
    public TestCaseDto updateTestCase(Long id, ReqTestCaseDto testCaseDto) {
        TestCase testCase = mapDtoToEntity(testCaseDto);
        testCase.setIdCase(id);
        TestCase updatedTestCase = repository.save(testCase);
        return mapEntityToDto(updatedTestCase);
    }

    @Override
    public SuccessDto deleteTestCase(Long id) {
        boolean testCaseExists = repository.existsById(id);
        if (!testCaseExists) {
            throw new NotFoundException("Test Case with id " + id + " not found");
        }
        repository.deleteById(id);
        return new SuccessDto("Deleted test case with id " + id);
    }

    @Override
    public List<TestCaseDto> getTestCasesByDate(Date lastUpdate) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate filterDate = LocalDate.parse(lastUpdate, formatter);
        LocalDate filterDate = new java.sql.Date(lastUpdate.getTime()).toLocalDate();
        List<TestCase> foundTestCases = repository.findByLastUpdateAfter(filterDate);
        return foundTestCases.stream()
                .map(this::mapEntityToDto)
                .toList();
    }

    private TestCase mapDtoToEntity(ReqTestCaseDto caseDto) {
        ModelMapper mapper = new ModelMapper();
        TestCase entity = mapper.map(caseDto, TestCase.class);
        entity.setLastUpdate(LocalDate.now());
        return entity;
    }

    private TestCaseDto mapEntityToDto(TestCase entity) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(entity, TestCaseDto.class);
    }
}
