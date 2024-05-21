package org.bootcamp.qatesters.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bootcamp.qatesters.dto.TestCaseRequestDTO;
import org.bootcamp.qatesters.dto.TestCaseResponseDTO;
import org.bootcamp.qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseResponseDTO> createTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseService.createTestCase(testCaseRequestDTO));
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<TestCaseResponseDTO> getTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCase(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<TestCaseResponseDTO>> getAllTestCases() {
        return ResponseEntity.ok(testCaseService.getAllTestCases());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> updateTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCaseRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lastupdate")
    public ResponseEntity<Iterable<TestCaseResponseDTO>> getTestCasesByLastUpdate(@RequestParam("last_update") LocalDate lastUpdate) {
        return ResponseEntity.ok(testCaseService.getTestCasesByLastUpdate(lastUpdate));
    }
}
