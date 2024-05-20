package com.example.testqajpa.service;

import com.example.testqajpa.dto.TestcaseDTO;
import com.example.testqajpa.model.Testcase;

import java.time.LocalDate;
import java.util.List;

public interface ITestQaService {
    String crearTestQa(TestcaseDTO testcasee);
    String actualizarTestQa(Long id, TestcaseDTO test);
    String eliminarTestQa(Long id);
    TestcaseDTO buscarTestQaPorId(Long id);
    List<TestcaseDTO> buscarTodosLosTestQa();
    List<TestcaseDTO> buscarConFiltro(LocalDate fecha);
}
