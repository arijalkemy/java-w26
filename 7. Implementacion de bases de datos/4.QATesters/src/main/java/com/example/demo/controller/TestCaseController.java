package com.example.demo.controller;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.dto.TestCaseResponseDTO;
import com.example.demo.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api")
@RestController
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @GetMapping("/testCases")
    public ResponseEntity<List<TestCaseResponseDTO>> getAllTestCases(@RequestParam(value = "last_update", required = false) LocalDate date) {
        if (date != null){
            return new ResponseEntity<>(testCaseService.getTestCasesByLastUpdate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
    }

    @PostMapping("/testCases/new")
    public ResponseEntity<String> createTestCase(@RequestBody TestCaseDTO testCase) {
        testCaseService.createTestCase(testCase);
        return new ResponseEntity<>("Created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/testCases/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/testCases/{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCase) {
        testCaseService.updateTestCase(id, testCase);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/testCases/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
