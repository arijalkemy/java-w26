package com.example.demo.controller;

import com.example.demo.model.TestCase;
import com.example.demo.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;


    @GetMapping("/testCases")
    public ResponseEntity<List<TestCase>> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
    }

    @PostMapping("/testCases/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase testCase) {
        testCaseService.createTestCase(testCase);
        return new ResponseEntity<>(testCase, HttpStatus.CREATED);
    }

}
