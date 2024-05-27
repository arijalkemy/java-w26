package com.example.qatester.controller;

import com.example.qatester.model.TestCase;
import com.example.qatester.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/api/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping(path = "/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCase testCase) {
        this.testCaseService.createTestCase(testCase);
        return ResponseEntity.ok(null);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTestCase() {
        return ResponseEntity.ok(this.testCaseService.getAllTestCase());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(this.testCaseService.getTestCaseById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateTestCaseById(@PathVariable Long id,
                                                @RequestBody TestCase testCase) {
        this.testCaseService.updateTestCaseById(id, testCase);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTestCaseById(@PathVariable Long id) {
        this.testCaseService.deleteTestCaseById(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/filter")
    public ResponseEntity<?> getAllTestCaseUpdatedAfterADate(@RequestParam("last_update") LocalDate lastUpdate) {
        return ResponseEntity.ok(this.testCaseService.getAllTestCaseUpdatedAfterADate(lastUpdate));
    }
}
