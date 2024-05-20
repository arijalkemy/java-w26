package com.example.testcase.controller;

import com.example.testcase.model.TestCase;
import com.example.testcase.repository.ITestRepository;
import com.example.testcase.service.ITestCaseService;
import com.example.testcase.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@RestController
//@RequestMapping("/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<Long> createTestCase(@RequestBody TestCase testCase) {
        return new ResponseEntity<>( testCaseService.saveTestCase(testCase), HttpStatus.CREATED );
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getAllTestCases(@RequestParam(required = false )LocalDate date) {
        if (date == null) {
            return new ResponseEntity<>( testCaseService.getTestCases(), HttpStatus.OK );
        }
        return new ResponseEntity<>( testCaseService.getTestCases(date), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable("id") long id) {
        return new ResponseEntity<>( testCaseService.getTestCase(id), HttpStatus.OK );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> updateTestCase(@PathVariable("id") long id, @RequestBody TestCase testCase) {
        return new ResponseEntity<>( testCaseService.updateTestCase(id, testCase), HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable("id") long id) {
        return new ResponseEntity<>( testCaseService.deleteTestCase(id), HttpStatus.OK );
    }
}
