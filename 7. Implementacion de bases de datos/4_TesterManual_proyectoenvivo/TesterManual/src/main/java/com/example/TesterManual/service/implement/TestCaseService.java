package com.example.TesterManual.service.implement;

import com.example.TesterManual.model.TestCase;
import com.example.TesterManual.repository.ITestCaseRepository;
import com.example.TesterManual.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    ITestCaseRepository testRepository;

    @Override
    public String saveTestCase(TestCase testCase) {
        testRepository.save(testCase);
        return "Test Case guardado con exito!!! ";
    }

    @Override
    public List<TestCase> getAllTestsCase() {
        return testRepository.findAll();
    }

    @Override
    public TestCase findTestCase(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteTestCase(Long id) {
        return null;
    }

    @Override
    public String editTestCase(Long id_modificar, TestCase testCase_modif) {
        TestCase testCaseOrigin = this.findTestCase(id_modificar);

        testCaseOrigin.setDescription(testCase_modif.getDescription());
        testCaseOrigin.setTested(testCase_modif.getTested());
        testCaseOrigin.setPassed(testCase_modif.getPassed());
        testCaseOrigin.setNumber_of_tries(testCase_modif.getNumber_of_tries());
        testCaseOrigin.setLast_update(testCase_modif.getLast_update());

        this.saveTestCase(testCaseOrigin);

        return "Modificaciones guardadas correctamente";
    }

    @Override
    public List<TestCase> getAllTestsCaseLastUpdate(LocalDate last_update) {
        return testRepository.findAll().stream()
                .filter(test -> test.getLast_update().isBefore(last_update)).toList();
    }
}
