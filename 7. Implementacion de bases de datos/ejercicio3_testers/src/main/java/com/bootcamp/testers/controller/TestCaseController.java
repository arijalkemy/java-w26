package com.bootcamp.testers.controller;

import com.bootcamp.testers.dto.ResponseDTO;
import com.bootcamp.testers.dto.TestCaseDTO;
import com.bootcamp.testers.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getTestCase(@RequestParam(required = false) String last_update) {
        if (last_update == null)
            return ResponseEntity.ok().body(testCaseService.getAll());
        return ResponseEntity.ok().body(testCaseService.getAllLastUpdatesAfter(last_update));
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.create(testCaseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTestCase(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(testCaseService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCase(@PathVariable long id, @RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.ok().body(testCaseService.update(id, testCaseDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable long id) {
        return ResponseEntity.ok().body(testCaseService.getById(id));
    }

}