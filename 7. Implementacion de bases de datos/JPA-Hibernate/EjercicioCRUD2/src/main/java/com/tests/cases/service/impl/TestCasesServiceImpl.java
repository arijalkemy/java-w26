package com.tests.cases.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tests.cases.dto.TestCasesDto;
import com.tests.cases.entity.TestCases;
import com.tests.cases.exception.NotFoundException;
import com.tests.cases.repository.ITestCasesRepository;
import com.tests.cases.service.ITestCasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TestCasesServiceImpl implements ITestCasesService {

    @Autowired
    ITestCasesRepository testCasesRepository;

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private LocalDate dateNow = LocalDate.now();

    private Long id;

    /**
     * @param testCasesDto: json que trae los datos a almacenar
     * @return retorna el objeto creado
     */
    @Override
    public TestCases saveTest(TestCasesDto testCasesDto) {
        TestCases testCases = new TestCases(id, testCasesDto.getDescription(), testCasesDto.isTested(), testCasesDto.isPassed(), testCasesDto.getNumber_of_tries(), dateNow);
        return this.testCasesRepository.save(testCases);
    }

    /**
     * @return retorna la lista de test almacenados
     */
    @Override
    public List<TestCases> getAllTest() {
        List<TestCases> testCases = this.testCasesRepository.findAll();
        if (!testCases.isEmpty()) {
            return testCases;
        } else {
            throw new NotFoundException("No hay registros");
        }
    }

    /**
     * @param id : Identificador del registro a eliminar
     * @return retorna la lista de test almacenados
     */
    @Override
    public TestCases getTestCasesById(Long id) {
        Optional<TestCases> testCases = this.testCasesRepository.findById(id);
        if (testCases.isPresent()) {
            return testCases.get();
        } else {
            throw new NotFoundException("No hay registros");
        }
    }

    /**
     * @param id : Identificador del registro a eliminar
     * @return retorna el estado de la transaccion
     */
    @Override
    public TestCases changeTest(Long id, TestCasesDto testCasesDto) {
        TestCases testOldCase = getTestCasesById(id);
        TestCases testNewCase = new TestCases(testOldCase.getId_case(), testCasesDto.getDescription(), testCasesDto.isTested(), testCasesDto.isTested(), testCasesDto.getNumber_of_tries(), dateNow);
        return this.testCasesRepository.saveAndFlush(testNewCase);
    }

    /**
     * @param id : Identificador del registro a eliminar
     * @return retorna el estado de la transaccion
     */
    @Override
    public String deleteTest(Long id) {
        getTestCasesById(id);
        this.testCasesRepository.deleteById(id);
        return "El registro ha sido eliminado";
    }

    @Override
    public List<TestCases> filterTests(boolean tested, boolean passed, Integer number_of_tries, LocalDate last_update) {
        List<TestCases> allTestCases = this.testCasesRepository.findAll();
        List<TestCases> filterTestCases = new ArrayList<>();
        if (tested) {
            filterTestCases = allTestCases.stream().filter(testCases -> testCases.isTested() == tested).toList();
        } else if (passed) {
            filterTestCases = allTestCases.stream().filter(testCases -> testCases.isPassed() == passed).toList();
        } else if (number_of_tries != null) {
            filterTestCases = allTestCases.stream().filter(testCases -> Objects.equals(testCases.getNumber_of_tries(), number_of_tries)).toList();
        } else if (last_update != null) {
            filterTestCases = allTestCases.stream().filter(testCases -> testCases.getLast_update().equals(last_update)).toList();
        }

        if (!filterTestCases.isEmpty()) {
            return filterTestCases;
        } else {
            throw new NotFoundException("No hay registros");
        }
    }
}
