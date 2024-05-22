package org.implementaciondb.ejercicio3_qatesters;

import jakarta.annotation.PostConstruct;
import org.implementaciondb.ejercicio3_qatesters.entity.TestCase;
import org.implementaciondb.ejercicio3_qatesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TestDataLoader {

    @Autowired
    private ITestCaseRepository testCaseRepository;

    @PostConstruct
    public void init() {
        // Verificar si los datos ya se han cargado
        if (testCaseRepository.count() == 0) {
            // Generar más casos de prueba
            List<TestCase> additionalTestCases = generateAdditionalTestCases(10);
            // Guardar los casos de prueba adicionales en la base de datos
            testCaseRepository.saveAll(additionalTestCases);
        }
    }

    private List<TestCase> generateAdditionalTestCases(int count) {
        List<TestCase> testCases = new ArrayList<>();
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 5, 15);
        for (int i = 0; i < count; i++) {
            // Generar una fecha aleatoria entre startDate y endDate
            LocalDate randomDate = startDate.plusDays(new Random().nextInt((int) ChronoUnit.DAYS.between(startDate, endDate) + 1));
            // Generar datos ficticios para los casos de prueba adicionales
            TestCase testCase = TestCase.builder()
                    .description("Test case " + (i + 1))
                    .tested(Math.random() < 0.5) // Aleatoriamente testeados o no testeados
                    .passed(Math.random() < 0.5) // Aleatoriamente aprobados o no aprobados
                    .numberOfTries((int) (Math.random() * 5) + 1) // Entre 1 y 5 intentos
                    .lastUpdate(randomDate)
                    .build();
            testCases.add(testCase);
        }
        return testCases;
    }
}