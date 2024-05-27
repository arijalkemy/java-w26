package com.example.TesterManual.controller;

import com.example.TesterManual.model.TestCase;
import com.example.TesterManual.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCase testCase){
        return ResponseEntity.status(HttpStatus.OK).body(service.saveTestCase(testCase));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTestCase(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTestsCase());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findTestCase(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase){
        return ResponseEntity.status(HttpStatus.OK).body(service.editTestCase(id, testCase));
    }

    @GetMapping("")
    public ResponseEntity<?> getTestCaseByLastUpdate(@RequestParam LocalDate lastUpdate){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTestsCaseLastUpdate(lastUpdate));
    }
}
