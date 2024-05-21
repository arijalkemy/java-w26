package com.example.qatesters.controller;

import com.example.qatesters.DTO.CreateTestCaseRequest;
import com.example.qatesters.DTO.UpdateTestCaseRequest;
import com.example.qatesters.Service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    TestCaseService testCaseService;


    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody CreateTestCaseRequest request) {
        return ResponseEntity.ok(testCaseService.createTestCase(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllTestCases() {
        return ResponseEntity.ok(testCaseService.getAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody UpdateTestCaseRequest request) {
        return ResponseEntity.ok(testCaseService.updateTestCase(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.deleteTestCase(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getTestCasesByDate(@RequestParam("last_update") String date) {
        return ResponseEntity.ok(testCaseService.getTestCasesByDate(date));
    }
}