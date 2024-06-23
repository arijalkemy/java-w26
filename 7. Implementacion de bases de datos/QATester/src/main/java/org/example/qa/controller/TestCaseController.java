package org.example.qa.controller;

import org.example.qa.dto.TestCaseRequestDTO;
import org.example.qa.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @GetMapping("/")
    public ResponseEntity<?> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.getTestCases(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseRequestDTO test) {
        return new ResponseEntity<>(testCaseService.createTestCase(test), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDTO test) {
        return new ResponseEntity<>(testCaseService.updateTestCase(test,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getTestCasesFilter(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update) {
        return new ResponseEntity<>(testCaseService.getTestCasesFiltered(last_update), HttpStatus.OK);
    }



}
