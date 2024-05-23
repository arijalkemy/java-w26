package com.mercadolibre.testcases.controller;

import com.mercadolibre.testcases.dto.TestCaseDTO;
import com.mercadolibre.testcases.dto.TestCaseResponseDTO;
import com.mercadolibre.testcases.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCasesController {
    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<Long> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseResponseDTO>> getAllTestCases
            (@RequestParam(required = false) String lastUpdate) {
        return ResponseEntity.ok(testCaseService.getAllTestCases(lastUpdate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCase(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> updateTestCase(@PathVariable Long id,
                                                              @RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCaseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.ok(id);
    }
}
