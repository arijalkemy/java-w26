package com.implbd.qatesters.controller;

import com.implbd.qatesters.dto.TestCaseRequestDTO;
import com.implbd.qatesters.dto.TestCaseResponseDTO;
import com.implbd.qatesters.service.ITestCasesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/testcases")
public class TestCasesController {

    private final ITestCasesService testCasesService;

    public TestCasesController(ITestCasesService iTestCasesService) {
        this.testCasesService = iTestCasesService;
    }

    // CREATE
    @PostMapping("/new")
    ResponseEntity<Long> createTestCase(@Valid @RequestBody TestCaseRequestDTO testCase) {
        Long id = this.testCasesService.createTestCase(testCase);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    // GET
    @GetMapping("")
    ResponseEntity<List<TestCaseResponseDTO>> getAllTestCases(
            @RequestParam(required = false, value = "lastUpdate") String lastUpdate
    ) {
        List<TestCaseResponseDTO> testCases;
        if (lastUpdate != null) {
            testCases = this.testCasesService.getAllTestCases(lastUpdate);
        }else {
            testCases = this.testCasesService.getAllTestCases();
        }
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<TestCaseResponseDTO> getTestCase(
            @Positive(message = "Debe ser un número positivo.")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.testCasesService.getTestCaseById(id), HttpStatus.CREATED);
    }

    // UPDATE
    // TODO: Update method

    // DELETE
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTestCaseById(
            @Positive(message = "Debe ser un número positivo.")
            @PathVariable Long id
    ) {
        this.testCasesService.deleteTestCase(id);
        return new ResponseEntity<>("Eliminado correctamente", HttpStatus.NO_CONTENT);
    }
}
