package org.bootcamp.qa_testers.controller;

import org.bootcamp.qa_testers.dto.TestCaseDTO;
import org.bootcamp.qa_testers.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getTestCases(@RequestParam(required = false) LocalDate lastUpdate) {
        return new ResponseEntity<>(testCaseService.getTestCases(lastUpdate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@RequestBody TestCaseDTO testCaseDTO, @PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.updateTestCase(testCaseDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }
}
