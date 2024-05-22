package org.implementaciondb.ejercicio3_qatesters.controller;

import jakarta.validation.Valid;
import org.implementaciondb.ejercicio3_qatesters.dto.TestCaseRequest;
import org.implementaciondb.ejercicio3_qatesters.dto.TestCaseResponse;
import org.implementaciondb.ejercicio3_qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    /**
     * Crear un nuevo caso de prueba.
     *
     * @param testCaseRequest
     */
    @PostMapping("/new")
    public ResponseEntity<TestCaseResponse> createNewTestCase(@RequestBody @Valid TestCaseRequest testCaseRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.saveTestCase(testCaseRequest));
    }

    /**
     * Devolver todos los casos de prueba.
     */
    @GetMapping
    public ResponseEntity<List<TestCaseResponse>> getAllTestCases() {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.findAllTestCases());
    }

    /**
     * Devolver un caso de prueba por id.
     *
     * @param id
     */
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponse> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.findTestCaseById(id));
    }

    /**
     * Actualizar un caso de prueba por id.
     *
     * @param id
     * @param testCaseRequest
     */
    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponse> updateTestCase(
            @PathVariable Long id, @RequestBody @Valid TestCaseRequest testCaseRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.updateTestCase(id, testCaseRequest));
    }

    /**
     * Eliminar un tutorial por id.
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.deleteTestCase(id));
    }

    /**
     * Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.
     *
     * @param lastUpdate
     */
    @GetMapping("/date")
    public ResponseEntity<List<TestCaseResponse>> getTestCasesByDate(
            @RequestParam(name = "last_update") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastUpdate
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.findTestCasesByDate(lastUpdate));
    }

}
