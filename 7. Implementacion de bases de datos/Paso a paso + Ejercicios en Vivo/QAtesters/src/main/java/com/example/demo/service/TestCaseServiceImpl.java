package com.example.demo.service;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.WrongDateFormatException;
import com.example.demo.model.TestCase;
import com.example.demo.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
//@RequiredArgsConstructor
public class TestCaseServiceImpl implements ITestCaseService{

    @Autowired
    ITestCaseRepository testCaseRepository;

    ModelMapper mapper = new ModelMapper();

    private final String NOT_FOUND_MESSAGE = "Test Case no encontrado";

    @Override
    @Transactional
    public TestCaseDTO createTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCaseCreated = testCaseRepository.save(mapToEntity(testCaseDTO));
        return mapToDto(testCaseCreated);
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseDTO findTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(NOT_FOUND_MESSAGE)
        );
        return mapToDto(testCase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDTO> getAllTestCases(String last_update) {
        if (last_update != null){
            LocalDate date;
            try {
                date = LocalDate.parse(last_update, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }catch (DateTimeException e){
                throw new WrongDateFormatException("El formato de fecha es invalido, Debe ser 'dd-MM-yyy'");
            }
            return testCaseRepository.findAll().stream()
                    .filter(testCase-> !testCase.getLast_update().isBefore(date))
                    .map(this::mapToDto)
                    .toList();
        }
        return testCaseRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    @Transactional
    public String updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        TestCaseDTO testCaseDTOFound = findTestCaseById(id);
        testCaseDTO.setId_case(testCaseDTOFound.getId_case());
        testCaseRepository.save(mapToEntity(testCaseDTO));
         return String.format("Test %s actualizado con exito", id);
    }


    @Override
    @Transactional
    public String deleteTestCase(Long id) {
        findTestCaseById(id);
        testCaseRepository.deleteById(id);
        return String.format("El test case con id %s, ha sido eliminado", id);
    }

    private TestCaseDTO mapToDto(TestCase testCase){
       return  mapper.map(testCase, TestCaseDTO.class);
    }
    private TestCase mapToEntity(TestCaseDTO testCaseDTO){
        return mapper.map(testCaseDTO, TestCase.class);
    }
}
